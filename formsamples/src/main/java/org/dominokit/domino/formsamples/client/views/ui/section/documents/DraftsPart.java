package org.dominokit.domino.formsamples.client.views.ui.section.documents;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.client.views.ui.section.ImportSection;
import org.dominokit.domino.formsamples.shared.model.DocumentsRequired;
import org.dominokit.domino.formsamples.shared.model.DraftsItem;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.IconButton;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.lists.ListGroup;
import org.dominokit.domino.ui.lists.ListItem;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;

import static org.dominokit.domino.formsamples.client.views.ui.Constants.NUMBERS_ONLY;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.*;
import static org.dominokit.domino.ui.utils.ElementUtil.numbersOnly;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.i;
import static org.jboss.gwt.elemento.core.Elements.small;

public class DraftsPart implements ImportSection {

    private final HTMLElement validationMessage = small()
            .textContent("At least one draft should be provided.")
            .css(Color.RED.getStyle())
            .asElement();
    private Select<String> draftDrawnOnSelect;
    private TextBox atDaysTextBox;
    private Select<String> documentsRequiredFromSelect;
    private TextBox draftsPercentage;
    private Select<String> draftsOf;
    private SwitchButton draftsRequiredSwitch;
    private ListGroup<DraftsItem> draftsListGroup;

    private FieldsGrouping fieldsGrouping = FieldsGrouping.create();
    private Card draftsCard;

    private HTMLDivElement element = div().asElement();

    public DraftsPart() {

        draftsListGroup = ListGroup.<DraftsItem>create()
                .setSelectable(false);

        draftDrawnOnSelect = Select.<String>create("Draft Drawn On")
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.business())
                .addOption(SelectOption.create("Progressoft", "Progressoft"))
                .addOption(SelectOption.create("Clusus", "Clusus"))
                .addOption(SelectOption.create("Bank XYZ", "Bank XYZ"))
                .addOption(SelectOption.create("Bank ABC", "Bank ABC"));

        atDaysTextBox = numbersOnly(TextBox.create("At (Days)"))
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .setHelperText(NUMBERS_ONLY)
                .setLeftAddon(Icons.ALL.looks_one());

        documentsRequiredFromSelect = Select.<String>create("From")
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.date_range())
                .addOption(SelectOption.create("shipmentDate", "Shipment Date"))
                .addOption(SelectOption.create("commercialDate", "Commercial Date"))
                .addOption(SelectOption.create("billOfLading", "Bill Of Lading"));

        draftsPercentage = numbersOnly(TextBox.create("Percentage"))
                .groupBy(fieldsGrouping)
                .setHelperText(NUMBERS_ONLY)
                .setRequired(true)
                .setAutoValidation(true)
                .addValidator(() -> validatePercent(draftsPercentage))
                .setLeftAddon(i()
                        .css("fas", "fa-percent", "fa-sm")
                        .style("margin-left: 15px;padding-right: 6px;"));


        draftsOf = Select.<String>create("Of")
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.insert_drive_file())
                .addOption(SelectOption.create("Invoice value", "Invoice value"))
                .addOption(SelectOption.create("IC value", "IC value"));

        draftsCard = Card.create("Drafts")
                .setBodyPaddingTop("40px")
                .collapse();

        Button addDraftButton = initAddButton();

        draftsRequiredSwitch = createRequiredField();
        draftsRequiredSwitch.addChangeHandler(value -> {
            if (value) {
                draftsCard.expand();
                addDraftButton.expand();
            } else {
                draftsCard.collapse();
                addDraftButton.collapse();
                revalidate();
            }
        });
        draftsCard.getHeaderBar().appendChild(addDraftButton.asElement());
        draftsCard.getHeaderDescription().appendChild(draftsRequiredSwitch.asElement());
        element.appendChild(Style.of(draftsCard)
                .get()
                .appendChild(Row.create()
                        .addColumn(Column.span4()
                                .addElement(draftDrawnOnSelect))
                        .addColumn(Column.span4()
                                .addElement(atDaysTextBox))
                        .addColumn(Column.span4()
                                .addElement(documentsRequiredFromSelect))
                ).appendChild(Row.create()
                        .addColumn(Column.span6()
                                .addElement(draftsPercentage))
                        .addColumn(Column.span6()
                                .addElement(draftsOf))
                ).appendChild(Row.create()
                        .addColumn(Column.span12()
                                .addElement(draftsListGroup))
                ).asElement());
    }



    private Button initAddButton() {
        Button addDraftButton = IconButton.createDefault(Icons.ALL.add()).setContent("ADD").linkify()
                .addClickListener(evt -> {
                    if (fieldsGrouping.validate().isValid()) {

                        DraftsItem draftsItem = makeDraftItem();

                        ListItem<DraftsItem> draftsItemListItem = draftsListGroup.addItem(draftsItem, formattedDraftItem(draftsItem));

                        Icon delete = Style.of(Icons.ALL.delete())
                                .css(Styles.pull_right)
                                .setMarginTop("-3px")
                                .setMarginLeft("10px").get();

                        delete.asElement().addEventListener("click", evt1 -> {
                            draftsListGroup.removeItem(draftsItemListItem);
                            revalidate();
                        });
                        draftsItemListItem.appendContent(delete.asElement());

                        atDaysTextBox.clear();
                        draftDrawnOnSelect.clear();
                        documentsRequiredFromSelect.clear();
                        draftsPercentage.clear();
                        draftsOf.clear();
                        fieldsGrouping.clearInvalid();
                        revalidate();
                    }
                });
        addDraftButton.collapse();
        return addDraftButton;
    }

    private String formattedDraftItem(DraftsItem draftsItem) {
        return draftsItem.formatted(documentsRequiredFromSelect.getSelectedOption().getDisplayValue().toLowerCase(), draftsOf.getValue().toLowerCase());
    }

    private DraftsItem makeDraftItem() {
        return new DraftsItem(Integer.parseInt(atDaysTextBox.getValue()),
                draftDrawnOnSelect.getValue(), documentsRequiredFromSelect.getValue(),
                Integer.parseInt(draftsPercentage.getValue()));
    }

    @Override
    public void collect(LetterOfCredit letterOfCredit) {
        DocumentsRequired documentsRequired = letterOfCredit.getDocumentsRequired();
        documentsRequired.setDraftRequired(draftsRequiredSwitch.getValue());
        if (documentsRequired.isDraftRequired())
            documentsRequired.setDrafts(draftsListGroup.getAllValues());
    }

    @Override
    public boolean validate() {
        boolean valid = isValid();
        markCardValidation(draftsCard, valid);
        markWithValidationMessage(valid);
        return valid;
    }

    private void revalidate() {
        if(isInvalidatedCard(draftsCard)) {
            boolean valid = isValid();
            if (valid) {
                markCardValidation(draftsCard, true, false);
                markWithValidationMessage(valid);
            }
        }
    }

    private void markWithValidationMessage(boolean valid) {
        if(!valid){
            draftsCard.getHeaderDescription().appendChild(validationMessage);
        }else{
            validationMessage.remove();
        }
    }

    private boolean isValid() {
        return !draftsRequiredSwitch.getValue() || !draftsListGroup.getAllValues().isEmpty();
    }

    @Override
    public HTMLElement asElement() {
        return element;
    }
}
