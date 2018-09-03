package org.dominokit.domino.formsamples.client.views.ui.section.documents;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.client.views.ui.section.ImportSection;
import org.dominokit.domino.formsamples.shared.model.DocumentsRequired;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.formsamples.shared.model.OtherDocumentsItem;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.lists.ListGroup;
import org.dominokit.domino.ui.lists.ListItem;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;

import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.createCopiesField;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.createDescriptionField;
import static org.dominokit.domino.ui.grid.Column.*;
import static org.jboss.gwt.elemento.core.Elements.div;

public class OtherDocumentsPart implements ImportSection {

    private final Row otherDocumentListGroupRow;
    private ListGroup<OtherDocumentsItem> otherDocumentsItemListGroup;
    private TextBox otherDocumentsCopiesTextBox;
    private TextBox otherDocumentsDescriptionTextBox;

    private FieldsGrouping fieldsGrouping = FieldsGrouping.create();

    private HTMLDivElement element = div().asElement();

    public OtherDocumentsPart() {
        otherDocumentsCopiesTextBox = createCopiesField()
                .groupBy(fieldsGrouping);

        otherDocumentsDescriptionTextBox = createDescriptionField()
                .groupBy(fieldsGrouping);

        otherDocumentsItemListGroup = ListGroup.<OtherDocumentsItem>create()
                .setSelectable(false);

        Card otherDocumentsCard = Card.create("Other documents").setBodyPaddingTop("40px");
        otherDocumentsCard.getHeaderBar()
                .appendChild(Button.createDefault(Icons.ALL.add())
                        .setContent("ADD")
                        .linkify()
                        .addClickListener(evt -> {
                            if (fieldsGrouping.validate().isValid()) {
                                addOtherDocumentItem();
                            }
                        }).asElement());

        otherDocumentListGroupRow = Row.create()
                .collapse();
        element.appendChild(otherDocumentsCard
                .appendChild(Row.create()
                        .addColumn(span4().appendChild(otherDocumentsCopiesTextBox.setRequired(true)))
                        .addColumn(span8()
                                .appendChild(otherDocumentsDescriptionTextBox.setRequired(true)))
                )
                .appendChild(otherDocumentListGroupRow
                        .addColumn(span12()
                                .appendChild(otherDocumentsItemListGroup)
                        )
                )
                .asElement());
    }

    private void addOtherDocumentItem() {
        OtherDocumentsItem item = makeNewOtherDocument();
        ListItem<OtherDocumentsItem> listItem = otherDocumentsItemListGroup.addItem(item, item.getDescription());
        Icon delete = Style.of(Icons.ALL.delete())
                .css(Styles.pull_right)
                .setMarginTop("-3px")
                .setMarginLeft("10px").get();

        delete.asElement()
                .addEventListener("click", evt1 -> {
                    otherDocumentsItemListGroup.removeItem(listItem);
                    if (otherDocumentsItemListGroup.getAllValues().size() == 0) {
                        otherDocumentListGroupRow.collapse();
                    }
                });

        if (otherDocumentListGroupRow.isCollapsed()) {
            otherDocumentListGroupRow.expand();
        }

        listItem
                .appendChild(delete)
                .appendChild(createCopiesBadge(item));

        otherDocumentsCopiesTextBox.clear();
        otherDocumentsCopiesTextBox.clearInvalid();
        otherDocumentsDescriptionTextBox.clear();
        otherDocumentsDescriptionTextBox.clearInvalid();
    }

    private Badge createCopiesBadge(OtherDocumentsItem item) {
        return Badge.create(item.getNumberOfCopies() + " Copies")
                .setBackground(Color.GREEN)
                .style()
                .css(Styles.pull_right).get();
    }

    private OtherDocumentsItem makeNewOtherDocument() {
        return new OtherDocumentsItem(Integer.parseInt(otherDocumentsCopiesTextBox.getValue()), otherDocumentsDescriptionTextBox.getValue());
    }


    @Override
    public void collect(LetterOfCredit letterOfCredit) {
        DocumentsRequired documentsRequired = letterOfCredit.getDocumentsRequired();
        documentsRequired.setOtherDocuments(otherDocumentsItemListGroup.getAllValues());
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public HTMLElement asElement() {
        return element;
    }
}
