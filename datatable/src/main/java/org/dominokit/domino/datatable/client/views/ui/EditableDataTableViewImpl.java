package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLDivElement;

import static org.dominokit.domino.ui.utils.Domino.*;

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
import org.dominokit.domino.ui.datatable.plugins.header.BordersTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.CondenseTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.HoverTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.NavigationBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.StripesTableAction;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;

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
                        .setRenderer(cell -> cell.appendChild(Icons.pencil()
                                .clickable()
                                .setTooltip("Edit")
                                .addClickListener(evt -> cell.getTableRow().edit()))
                        )
                        .setEditableRenderer(cell -> cell.appendChild(Icons.content_save()
                                .clickable()
                                .setTooltip("Save")
                                .addClickListener(evt -> {
                                    if (cell.getTableRow().validate().isValid()) {
                                        cell.getTableRow().save();
                                    }
                                })))
                )
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getIndex() + 1 + "")))
                )
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .setTextAlign(CellTextAlign.CENTER)
                        .setRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                cell.appendChild(Icons.check_circle().addCss(dui_fg_green_d_3));
                            } else {
                                cell.appendChild(Icons.close_circle().addCss(dui_fg_red_d_3));
                            }
                        })
                        .setEditableRenderer(cell -> {
                            CheckBox activeCheckBox = CheckBox.create()
                                    .addCss(dui_form_select_check_box, dui_hide_label)
                                    .withValue(cell.getRecord().isActive());
                            cell.setDirtyRecordHandler(dirty -> dirty.setActive(activeCheckBox.getValue()));
                            cell.appendChild(activeCheckBox);
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getName())))
                        .setEditableRenderer(cell -> {
                            TextBox nameBox = TextBox.create()
                                    .withValue(cell.getRecord().getName());

                            cell.setDirtyRecordHandler(dirty -> dirty.setName(nameBox.getValue()));
                            cell.appendChild(nameBox);
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getGenderElement(cell.getRecord())))
                        .setEditableRenderer(cell -> {
                            Select<Gender> genderSelect = Select.<Gender>create()
                                    .addCss(dui_min_w_24)
                                    .appendChild(SelectOption.create("Male", Gender.male, "Male"))
                                    .appendChild(SelectOption.create("female", Gender.female, "female"))
                                    .withValue(cell.getRecord().getGender());
                            cell.setDirtyRecordHandler(dirty -> dirty.setGender(genderSelect.getValue()));
                            cell.appendChild(genderSelect);
                        })
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getEyeColorElement(cell.getRecord())))
                        .setEditableRenderer(cell -> {
                            Select<EyeColor> eyeColorSelect = Select.<EyeColor>create()
                                    .appendChild(SelectOption.create("Blue", EyeColor.blue, "Blue"))
                                    .appendChild(SelectOption.create("Brown", EyeColor.brown, "Brown"))
                                    .appendChild(SelectOption.create("Green", EyeColor.green, "Green"))
                                    .withValue(cell.getRecord().getEyeColor());
                            cell.setDirtyRecordHandler(dirty -> dirty.setEyeColor(eyeColorSelect.getValue()));
                            cell.appendChild(eyeColorSelect);
                        })
                        .setTextAlign(CellTextAlign.CENTER))
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getBalanceElement(cell.getRecord())))
                        .setEditableRenderer(cell -> {
                            DoubleBox doubleBox = DoubleBox.create()
                                    .setMaxValue(4000.0)
                                    .withValue(cell.getRecord().getBalance());
                            cell.setDirtyRecordHandler(dirty -> dirty.setBalance(doubleBox.getValue()));
                            cell.setCellValidator(doubleBox::validate);
                            cell.appendChild(doubleBox);
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getEmail())))
                        .setEditableRenderer(cell -> {
                            EmailBox emailBox = EmailBox.create()
                                    .withValue(cell.getRecord().getEmail());
                            cell.setDirtyRecordHandler(dirty -> dirty.setEmail(emailBox.getValue()));
                            cell.appendChild(emailBox);
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getPhone())))
                        .setEditableRenderer(cell -> {
                            TelephoneBox telephoneBox = TelephoneBox.create()
                                    .withValue(cell.getRecord().getPhone());

                            cell.setDirtyRecordHandler(dirty -> dirty.setPhone(telephoneBox.getValue()));
                            cell.appendChild(telephoneBox);
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                cell.appendChild(Badge.create("Young")
                                        .addCss(dui_green, dui_float_none));
                            } else {
                                cell.appendChild(text(""));
                            }
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
                .addPlugin(new NavigationBarPlugin<>((datatable, self) -> {
                    self
                            .setTitle("Demo table")
                            .setDescription("Sample table table demonstrating the feature")
                            .appendChild(PostfixAddOn.of(HoverTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(CondenseTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(StripesTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(BordersTableAction.create(datatable)));
                }));

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("EDITABLE TABLE", "Render cells as editable fields and save the row data.")
                .setCollapsible(true)
                .appendChild(table)
                .element());

        localListDataStore.setData(ContactsProvider.instance.subList());
    }

}
