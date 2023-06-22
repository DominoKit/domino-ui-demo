package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.datatable.client.presenters.EditableDatatableProxy;
import org.dominokit.domino.datatable.client.task.ContactsProvider;
import org.dominokit.domino.datatable.client.views.DatatableView;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.datatable.client.views.model.EyeColor;
import org.dominokit.domino.datatable.client.views.model.Gender;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.plugins.header.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.typography.BlockHeader;

import static org.dominokit.domino.ui.forms.FormsStyles.dui_form_select_check_box;

@UiView(presentable = EditableDatatableProxy.class)
@SampleClass(includeClassName = true)
public class EditableDataTableViewImpl extends BaseDemoView<HTMLDivElement> implements DatatableView {

    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("datatable", this.getClass()));
        element.appendChild(BlockHeader.create("DATA TABLES", "For detailed demo code please visit: ")
                .appendChild(a()
                        .setAttribute("href", "https://github.com/DominoKit/domino-ui-demo/tree/master/datatable")
                        .setAttribute("target", "_blank")
                        .textContent("Data table demo source code"))
        );

        editableTable();
        element.appendChild(CodeCard.createLazyCodeCard(EditableDataTableViewImpl_CodeResource.INSTANCE.editableTable()));

        return element.element();
    }

    @SampleMethod
    private void editableTable() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("edit_save", "")
                        .setCellRenderer(cell -> Icons.pencil()
                                .clickable()
                                .setTooltip("Edit")
                                .addClickListener(evt -> cell.getTableRow().edit())
                                .element()
                        )
                        .setEditableCellRenderer(cell -> Icons.content_save()
                                .clickable()
                                .setTooltip("Save")
                                .addClickListener(evt -> {
                                    if (cell.getTableRow().validate().isValid()) {
                                        cell.getTableRow().save();
                                    }
                                })
                                .element())
                )
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getIndex() + 1 + ""))
                )
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .setTextAlign(CellTextAlign.CENTER)
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Icons.check_circle().addCss(dui_fg_green_d_3).element();
                            } else {
                                return Icons.close_circle().addCss(dui_fg_red_d_3).element();
                            }
                        })
                        .setEditableCellRenderer(cell -> {
                            CheckBox activeCheckBox = CheckBox.create()
                                    .addCss(dui_form_select_check_box, dui_hide_label)
                                    .withValue(cell.getRecord().isActive());
                            cell.setDirtyRecordHandler(dirty -> dirty.setActive(activeCheckBox.getValue()));
                            return activeCheckBox.element();
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getName()))
                        .setEditableCellRenderer(cell -> {
                            TextBox nameBox = TextBox.create()
                                    .withValue(cell.getRecord().getName());

                            cell.setDirtyRecordHandler(dirty -> dirty.setName(nameBox.getValue()));
                            return nameBox.element();
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .setEditableCellRenderer(cell -> {
                            Select<Gender> genderSelect = Select.<Gender>create()
                                    .addCss(dui_min_w_24)
                                    .appendChild(SelectOption.create("Male", Gender.male, "Male"))
                                    .appendChild(SelectOption.create("female", Gender.female,"female"))
                                    .withValue(cell.getRecord().getGender());
                            cell.setDirtyRecordHandler(dirty -> dirty.setGender(genderSelect.getValue()));
                            return genderSelect.element();
                        })
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .setEditableCellRenderer(cell -> {
                            Select<EyeColor> eyeColorSelect = Select.<EyeColor>create()
                                    .appendChild(SelectOption.create("Blue", EyeColor.blue, "Blue"))
                                    .appendChild(SelectOption.create("Brown", EyeColor.brown, "Brown"))
                                    .appendChild(SelectOption.create("Green", EyeColor.green, "Green"))
                                    .withValue(cell.getRecord().getEyeColor());
                            cell.setDirtyRecordHandler(dirty -> dirty.setEyeColor(eyeColorSelect.getValue()));
                            return eyeColorSelect.element();
                        })
                        .setTextAlign(CellTextAlign.CENTER))
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cell -> ContactUiUtils.getBalanceElement(cell.getRecord()))
                        .setEditableCellRenderer(cell -> {
                            DoubleBox doubleBox = DoubleBox.create()
                                    .setMaxValue(4000.0)
                                    .withValue(cell.getRecord().getBalance());
                            cell.setDirtyRecordHandler(dirty -> dirty.setBalance(doubleBox.getValue()));
                            cell.setCellValidator(doubleBox::validate);
                            return doubleBox.element();
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getEmail()))
                        .setEditableCellRenderer(cell -> {
                            EmailBox emailBox = EmailBox.create()
                                    .withValue(cell.getRecord().getEmail());
                            cell.setDirtyRecordHandler(dirty -> dirty.setEmail(emailBox.getValue()));
                            return emailBox.element();
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getPhone()))
                        .setEditableCellRenderer(cell -> {
                            TelephoneBox telephoneBox = TelephoneBox.create()
                                    .withValue(cell.getRecord().getPhone());

                            cell.setDirtyRecordHandler(dirty -> dirty.setPhone(telephoneBox.getValue()));
                            return telephoneBox.element();
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .addCss(dui_green, dui_float_none)
                                        .element();
                            }
                            return text("");
                        })
                )
                .setDirtyRecordHandlers(Contact::new, (originalRecord, dirtyRecord) -> {
                    originalRecord.setActive(dirtyRecord.isActive());
                    originalRecord.setPhone(dirtyRecord.getPhone());
                    originalRecord.setEmail(dirtyRecord.getEmail());
                    originalRecord.setBalance(dirtyRecord.getBalance());
                    originalRecord.setEyeColor(dirtyRecord.getEyeColor());
                    originalRecord.setGender(dirtyRecord.getGender());
                    originalRecord.setName(dirtyRecord.getName());
                })
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "Sample table table demonstrating the feature")
                        .addActionElement(new HeaderBarPlugin.HoverTableAction<>())
                        .addActionElement(new HeaderBarPlugin.CondenseTableAction<>())
                        .addActionElement(new HeaderBarPlugin.StripesTableAction<>())
                        .addActionElement(new HeaderBarPlugin.BordersTableAction<>())
                );

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("EDITABLE TABLE", "Render cells as editable fields and save the row data.")
                .setCollapsible(true)
                .appendChild(table)
                .element());

            localListDataStore.setData(ContactsProvider.instance.subList());
    }

}
