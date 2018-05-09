package org.dominokit.domino.lists.client.views.ui;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.lists.client.presenters.ListsPresenter;
import org.dominokit.domino.lists.client.views.CodeResource;
import org.dominokit.domino.lists.client.views.ListsView;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.lists.ListGroup;
import org.dominokit.domino.ui.lists.SimpleListGroup;
import org.dominokit.domino.ui.lists.SimpleListItem;
import org.dominokit.domino.ui.row.Row;
import elemental2.dom.HTMLDivElement;
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
        element.appendChild(BlockHeader.create("LIST GROUPS").asElement());
        basicListsSample();
        selectableSample();
        coloredSample();
        richItems();
    }

    private void basicListsSample() {
        Row row = Row.create();
        Column column = Column.create()
                .onLarge(Column.OnLarge.six)
                .onMedium(Column.OnMedium.six)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);
        element.appendChild(row.asElement());

        row.addColumn(column.addElement(Card.create("BASIC EXAMPLES", "The most basic list group is simply an unordered list with list items, and the proper classes.")
                .appendContent(SimpleListGroup.create()
                        .appendItem("Cras justo odio")
                        .appendItem("Dapibus ac facilisis in")
                        .appendItem("Morbi leo risus")
                        .appendItem("Porta ac consectetur ac")
                        .appendItem("Vestibulum at eros")
                        .asElement()).asElement()));

        row.addColumn(column.copy().addElement(Card.create("BADGES", "Add the badges component to any list group item and it will automatically be positioned on the right.")
                .appendContent(SimpleListGroup.create()
                        .appendItem(SimpleListItem.create("Cras justo odio")
                                .appendContent(Badge.create("14 new").setBackground(Color.PINK).asElement()))

                        .appendItem(SimpleListItem.create("Dapibus ac facilisis in")
                                .appendContent(Badge.create("99 unread").setBackground(Color.CYAN).asElement()))

                        .appendItem(SimpleListItem.create("Morbi leo risus")
                                .appendContent(Badge.create("99+").setBackground(Color.TEAL).asElement()))

                        .appendItem(SimpleListItem.create("Porta ac consectetur ac")
                                .appendContent(Badge.create("21").setBackground(Color.ORANGE).asElement()))

                        .appendItem(SimpleListItem.create("Vestibulum at eros")
                                .appendContent(Badge.create("Pending").setBackground(Color.PURPLE).asElement()))
                        .asElement()).asElement()));

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.basicListsSample())
                .asElement());
    }

    private void selectableSample() {
        Row row = Row.create();
        Column column = Column.create()
                .onLarge(Column.OnLarge.six)
                .onMedium(Column.OnMedium.six)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);
        element.appendChild(row.asElement());

        ListGroup<String> listGroup = ListGroup.create();
        listGroup
                .multiSelect()
                .appendItem(listGroup.createItem("Value1", "Cras justo odio").select())
                .appendItem(listGroup.createItem("Value2", "Dapibus ac facilisis in"))
                .appendItem(listGroup.createItem("Value3", "Morbi leo risus"))
                .appendItem(listGroup.createItem("Value4", "Porta ac consectetur ac"))
                .appendItem(listGroup.createItem("Value5", "Vestibulum at eros"));

        row.addColumn(column.addElement(Card.create("SELECTABLE ITEMS", "Use ListGroup instead of SimpleListGroup to make items selectable, use multiSelect to select more than one item.")
                .appendContent(listGroup.asElement()).asElement()));

        ListGroup<String> disabledItems = ListGroup.create();
        disabledItems
                .appendItem(disabledItems.createItem("Value1", "Cras justo odio").disable())
                .appendItem(disabledItems.createItem("Value2", "Dapibus ac facilisis in").select())
                .appendItem(disabledItems.createItem("Value3", "Morbi leo risus").disable())
                .appendItem(disabledItems.createItem("Value4", "Porta ac consectetur ac"))
                .appendItem(disabledItems.createItem("Value5", "Vestibulum at eros"));

        row.addColumn(column.copy().addElement(Card.create("DISABLED ITEMS", "List group items can be disabled and prevented from being selected.")
                .appendContent(disabledItems.asElement()).asElement()));

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.selectableSample())
                .asElement());
    }

    private void coloredSample() {
        Row row = Row.create();
        Column column = Column.create()
                .onLarge(Column.OnLarge.six)
                .onMedium(Column.OnMedium.six)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);
        element.appendChild(row.asElement());

        ListGroup<String> contextualGroup = ListGroup.create();
        contextualGroup
                .appendItem(contextualGroup.createItem("Value1", "Cras justo odio").select().success())
                .appendItem(contextualGroup.createItem("Value2", "Dapibus ac facilisis in").info())
                .appendItem(contextualGroup.createItem("Value3", "Morbi leo risus").warning())
                .appendItem(contextualGroup.createItem("Value4", "Porta ac consectetur ac").error())
                .appendItem(contextualGroup.createItem("Value5", "Vestibulum at eros"));

        row.addColumn(column.addElement(Card.create("CONTEXTUAL CLASSES", "Use contextual classes to style list items.")
                .appendContent(contextualGroup.asElement()).asElement()));

        ListGroup<String> coloredGroup = ListGroup.create();
        coloredGroup
                .appendItem(coloredGroup.createItem("Value1", "Cras justo odio").disable().setBackground(Color.PINK))
                .appendItem(coloredGroup.createItem("Value2", "Dapibus ac facilisis in").setBackground(Color.TEAL))
                .appendItem(coloredGroup.createItem("Value3", "Morbi leo risus").setBackground(Color.LIGHT_GREEN))
                .appendItem(coloredGroup.createItem("Value4", "Porta ac consectetur ac").setBackground(Color.AMBER))
                .appendItem(coloredGroup.createItem("Value5", "Vestibulum at eros").setBackground(Color.DEEP_PURPLE));

        row.addColumn(column.copy().addElement(Card.create("MATERIAL DESIGN COLORS", "Use Material design background colors to style list items.")
                .appendContent(coloredGroup.asElement()).asElement()));

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.coloredSample())
                .asElement());
    }

    private void richItems() {
        ListGroup<String> listGroup = ListGroup.create();
        listGroup
                .appendItem(listGroup.createItem("value1", SAMPLE_CONTENT).setHeading("Cras justo odio"))
                .appendItem(listGroup.createItem("value2", SAMPLE_CONTENT).setHeading("Dapibus ac facilisis in"))
                .appendItem(listGroup.createItem("value3", SAMPLE_CONTENT).setHeading("Morbi leo risus"))
                .appendItem(listGroup.createItem("value4", SAMPLE_CONTENT).setHeading("Porta ac consectetur ac").select())
                .appendItem(listGroup.createItem("value5", SAMPLE_CONTENT).setHeading("Vestibulum at eros"));

        element.appendChild(Card.create("RICH ITEMS", "Add rich items with header and description.")
                .appendContent(listGroup.asElement()).asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.richItems())
                .asElement());
    }
}