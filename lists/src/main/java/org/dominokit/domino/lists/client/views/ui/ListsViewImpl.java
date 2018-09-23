package org.dominokit.domino.lists.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.lists.client.presenters.ListsPresenter;
import org.dominokit.domino.lists.client.views.CodeResource;
import org.dominokit.domino.lists.client.views.ListsView;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.lists.ListGroup;
import org.dominokit.domino.ui.lists.SimpleListGroup;
import org.dominokit.domino.ui.lists.SimpleListItem;
import org.dominokit.domino.ui.style.Color;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = ListsPresenter.class)
public class ListsViewImpl extends ComponentView<HTMLDivElement> implements ListsView {

    private static final String SAMPLE_CONTENT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.";

    private HTMLDivElement element = Elements.div().asElement();

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {
        element.appendChild(LinkToSourceCode.create("lists", this.getClass()).asElement());
        element.appendChild(BlockHeader.create("LIST GROUPS").asElement());
        basicListsSample();
        selectableSample();
        coloredSample();
        richItems();
    }

    private void basicListsSample() {

        element.appendChild(Row.create()
                .addColumn(Column.span6()
                        .appendChild(Card.create("BASIC EXAMPLES", "The most basic list group is simply an unordered list with list items, and the proper classes.")
                                .appendChild(SimpleListGroup.create()
                                        .appendChild("Cras justo odio")
                                        .appendChild("Dapibus ac facilisis in")
                                        .appendChild("Morbi leo risus")
                                        .appendChild("Porta ac consectetur ac")
                                        .appendChild("Vestibulum at eros")
                                        .asElement()).asElement()))
                .addColumn(Column.span6()
                        .appendChild(Card.create("BADGES", "Add the badges component to any list group item and it will automatically be positioned on the right.")
                                .appendChild(SimpleListGroup.create()
                                        .appendChild(SimpleListItem.create("Cras justo odio")
                                                .appendChild(Badge.create("14 new")
                                                        .setBackground(Color.PINK)))
                                        .appendChild(SimpleListItem.create("Dapibus ac facilisis in")
                                                .appendChild(Badge.create("99 unread")
                                                        .setBackground(Color.CYAN)))
                                        .appendChild(SimpleListItem.create("Morbi leo risus")
                                                .appendChild(Badge.create("99+")
                                                        .setBackground(Color.TEAL)))
                                        .appendChild(SimpleListItem.create("Porta ac consectetur ac")
                                                .appendChild(Badge.create("21")
                                                        .setBackground(Color.ORANGE)))
                                        .appendChild(SimpleListItem.create("Vestibulum at eros")
                                                .appendChild(Badge.create("Pending")
                                                        .setBackground(Color.PURPLE))))))
                .asElement());


        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.basicListsSample())
                .asElement());
    }

    private void selectableSample() {
        ListGroup<String> listGroup = ListGroup.create();
        listGroup
                .multiSelect()
                .appendChild(listGroup.createItem("Value1", "Cras justo odio").select())
                .appendChild(listGroup.createItem("Value2", "Dapibus ac facilisis in"))
                .appendChild(listGroup.createItem("Value3", "Morbi leo risus"))
                .appendChild(listGroup.createItem("Value4", "Porta ac consectetur ac"))
                .appendChild(listGroup.createItem("Value5", "Vestibulum at eros"));

        ListGroup<String> disabledItems = ListGroup.create();
        disabledItems
                .appendChild(disabledItems.createItem("Value1", "Cras justo odio").disable())
                .appendChild(disabledItems.createItem("Value2", "Dapibus ac facilisis in").select())
                .appendChild(disabledItems.createItem("Value3", "Morbi leo risus").disable())
                .appendChild(disabledItems.createItem("Value4", "Porta ac consectetur ac"))
                .appendChild(disabledItems.createItem("Value5", "Vestibulum at eros"));

        element.appendChild(Row.create()
                .addColumn(Column.span6().appendChild(Card.create("SELECTABLE ITEMS", "Use ListGroup instead of SimpleListGroup to make items selectable, use multiSelect to select more than one item.")
                        .appendChild(listGroup)))
                .addColumn(Column.span6().appendChild(Card.create("DISABLED ITEMS", "List group items can be disabled and prevented from being selected.")
                        .appendChild(disabledItems)))
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.selectableSample())
                .asElement());
    }

    private void coloredSample() {
        ListGroup<String> contextualGroup = ListGroup.create();
        contextualGroup
                .appendChild(contextualGroup.createItem("Value1", "Cras justo odio").select().success())
                .appendChild(contextualGroup.createItem("Value2", "Dapibus ac facilisis in").info())
                .appendChild(contextualGroup.createItem("Value3", "Morbi leo risus").warning())
                .appendChild(contextualGroup.createItem("Value4", "Porta ac consectetur ac").error())
                .appendChild(contextualGroup.createItem("Value5", "Vestibulum at eros"));

        ListGroup<String> coloredGroup = ListGroup.create();
        coloredGroup
                .appendChild(coloredGroup.createItem("Value1", "Cras justo odio").disable().setBackground(Color.PINK))
                .appendChild(coloredGroup.createItem("Value2", "Dapibus ac facilisis in").setBackground(Color.TEAL))
                .appendChild(coloredGroup.createItem("Value3", "Morbi leo risus").setBackground(Color.LIGHT_GREEN))
                .appendChild(coloredGroup.createItem("Value4", "Porta ac consectetur ac").setBackground(Color.AMBER))
                .appendChild(coloredGroup.createItem("Value5", "Vestibulum at eros").setBackground(Color.DEEP_PURPLE));

        element.appendChild(Row.create()
                .addColumn(Column.span6().appendChild(Card.create("CONTEXTUAL CLASSES", "Use contextual classes to style list items.")
                        .appendChild(contextualGroup)))
                .addColumn(Column.span6().appendChild(Card.create("MATERIAL DESIGN COLORS", "Use Material design background colors to style list items.")
                        .appendChild(coloredGroup)))
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.coloredSample())
                .asElement());
    }

    private void richItems() {
        ListGroup<String> listGroup = ListGroup.create();
        listGroup
                .appendChild(listGroup.createItem("value1", SAMPLE_CONTENT).setHeading("Cras justo odio"))
                .appendChild(listGroup.createItem("value2", SAMPLE_CONTENT).setHeading("Dapibus ac facilisis in"))
                .appendChild(listGroup.createItem("value3", SAMPLE_CONTENT).setHeading("Morbi leo risus"))
                .appendChild(listGroup.createItem("value4", SAMPLE_CONTENT).setHeading("Porta ac consectetur ac").select())
                .appendChild(listGroup.createItem("value5", SAMPLE_CONTENT).setHeading("Vestibulum at eros"));

        element.appendChild(Card.create("RICH ITEMS", "Add rich items with header and description.")
                .appendChild(listGroup).asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.richItems())
                .asElement());
    }
}