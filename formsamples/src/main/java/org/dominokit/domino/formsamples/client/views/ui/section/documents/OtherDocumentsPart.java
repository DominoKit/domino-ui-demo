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
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.lists.ListGroup;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.TextNode;

import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.createCopiesField;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.createDescriptionField;
import static org.dominokit.domino.ui.grid.Column.span12;
import static org.dominokit.domino.ui.grid.Column.span4;
import static org.dominokit.domino.ui.grid.Column.span8;
import static org.jboss.elemento.Elements.div;

public class OtherDocumentsPart implements ImportSection {

    private final Row otherDocumentListGroupRow;
    private ListGroup<OtherDocumentsItem> otherDocumentsItemListGroup;
    private TextBox otherDocumentsCopiesTextBox;
    private TextBox otherDocumentsDescriptionTextBox;

    private FieldsGrouping fieldsGrouping = FieldsGrouping.create();

    private HTMLDivElement element = div().element();

    public OtherDocumentsPart() {
        otherDocumentsCopiesTextBox = createCopiesField()
                .groupBy(fieldsGrouping);

        otherDocumentsDescriptionTextBox = createDescriptionField()
                .groupBy(fieldsGrouping);

        otherDocumentListGroupRow = Row.create()
                .hide();

        otherDocumentsItemListGroup = ListGroup.<OtherDocumentsItem>create()
                .setItemRenderer((listGroup, listItem) -> {
                    Icon delete = Icons.ALL.delete()
                            .clickable()
                            .styler(style -> style.addCss(Styles.pull_right)
                                    .setMarginTop("-3px")
                                    .setMarginLeft("10px")
                            )
                            .addClickListener(evt -> {
                                otherDocumentsItemListGroup.removeItem(listItem);
                                if (otherDocumentsItemListGroup.getValues().size() == 0) {
                                    otherDocumentListGroupRow.hide();
                                }
                            });

                    listItem
                            .appendChild(FlexLayout.create()
                                    .css(Styles.padding_10)
                                    .appendChild(FlexItem.create()
                                            .appendChild(TextNode.of(listItem.getValue().getDescription()))
                                            .setFlexGrow(1)
                                    )
                                    .appendChild(FlexItem.create().appendChild(delete))
                                    .appendChild(FlexItem.create().appendChild(createCopiesBadge(listItem.getValue())))
                            );

                });

        Card otherDocumentsCard = Card.create("Other documents").setBodyPaddingTop("40px");
        otherDocumentsCard.getHeaderBar()
                .appendChild(Button.createDefault(Icons.ALL.add())
                        .setContent("ADD")
                        .styler(style -> style.setMarginTop("-10px"))
                        .linkify()
                        .addClickListener(evt -> {
                            if (fieldsGrouping.validate().isValid()) {
                                addOtherDocumentItem();
                            }
                        }).element());


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
                .element());
    }

    private void addOtherDocumentItem() {
        OtherDocumentsItem item = makeNewOtherDocument();
        otherDocumentsItemListGroup.addItem(item);

        if (otherDocumentListGroupRow.isCollapsed()) {
            otherDocumentListGroupRow.show();
        }
        otherDocumentsCopiesTextBox.clear();
        otherDocumentsCopiesTextBox.clearInvalid();
        otherDocumentsDescriptionTextBox.clear();
        otherDocumentsDescriptionTextBox.clearInvalid();
    }

    private Badge createCopiesBadge(OtherDocumentsItem item) {
        return Badge.create(item.getNumberOfCopies() + " Copies")
                .setBackground(Color.GREEN)
                .style()
                .addCss(Styles.pull_right).get();
    }

    private OtherDocumentsItem makeNewOtherDocument() {
        return new OtherDocumentsItem(Integer.parseInt(otherDocumentsCopiesTextBox.getValue()), otherDocumentsDescriptionTextBox.getValue());
    }


    @Override
    public void collect(LetterOfCredit letterOfCredit) {
        DocumentsRequired documentsRequired = letterOfCredit.getDocumentsRequired();
        documentsRequired.setOtherDocuments(otherDocumentsItemListGroup.getValues());
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public HTMLElement element() {
        return element;
    }
}
