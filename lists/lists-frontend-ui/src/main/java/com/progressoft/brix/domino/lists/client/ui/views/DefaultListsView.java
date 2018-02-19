package com.progressoft.brix.domino.lists.client.ui.views;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.lists.client.presenters.ListsPresenter;
import com.progressoft.brix.domino.lists.client.views.ListsView;
import com.progressoft.brix.domino.ui.badges.Badge;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.column.Column;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.lists.ListGroup;
import com.progressoft.brix.domino.ui.lists.ListGroupStyle;
import com.progressoft.brix.domino.ui.lists.SimpleListGroup;
import com.progressoft.brix.domino.ui.lists.SimpleListItem;
import com.progressoft.brix.domino.ui.row.Row;
import com.progressoft.brix.domino.ui.style.Background;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import jsinterop.base.Js;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = ListsPresenter.class)
public class DefaultListsView implements ListsView {

    private static final String SAMPLE_CONTENT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.";

    private HTMLDivElement element = div().asElement();

    public DefaultListsView() {
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
                                .appendContent(Badge.create("14 new").setBackground(Background.PINK).asElement()))

                        .appendItem(SimpleListItem.create("Dapibus ac facilisis in")
                                .appendContent(Badge.create("99 unread").setBackground(Background.CYAN).asElement()))

                        .appendItem(SimpleListItem.create("Morbi leo risus")
                                .appendContent(Badge.create("99+").setBackground(Background.TEAL).asElement()))

                        .appendItem(SimpleListItem.create("Porta ac consectetur ac")
                                .appendContent(Badge.create("21").setBackground(Background.ORANGE).asElement()))

                        .appendItem(SimpleListItem.create("Vestibulum at eros")
                                .appendContent(Badge.create("Pending").setBackground(Background.PURPLE).asElement()))
                        .asElement()).asElement()));

        element.appendChild(Card.createCodeCard("Row row = Row.create();\n" +
                "Column column = Column.create()\n" +
                "        .onLarge(Column.OnLarge.six)\n" +
                "        .onMedium(Column.OnMedium.six)\n" +
                "        .onSmall(Column.OnSmall.twelve)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "element.appendChild(row.asElement());\n" +
                "\n" +
                "row.addColumn(column.addElement(Card.create(\"BASIC EXAMPLES\", \"The most basic list group is simply an unordered list with list items, and the proper classes.\")\n" +
                "        .appendContent(SimpleListGroup.create()\n" +
                "                .appendItem(\"Cras justo odio\")\n" +
                "                .appendItem(\"Dapibus ac facilisis in\")\n" +
                "                .appendItem(\"Morbi leo risus\")\n" +
                "                .appendItem(\"Porta ac consectetur ac\")\n" +
                "                .appendItem(\"Vestibulum at eros\")\n" +
                "                .asElement()).asElement()));\n" +
                "\n" +
                "row.addColumn(column.copy().addElement(Card.create(\"BADGES\", \"Add the badges component to any list group item and it will automatically be positioned on the right.\")\n" +
                "        .appendContent(SimpleListGroup.create()\n" +
                "                .appendItem(SimpleListItem.create(\"Cras justo odio\")\n" +
                "                        .appendContent(Badge.create(\"14 new\").setBackground(Background.PINK).asElement()))\n" +
                "\n" +
                "                .appendItem(SimpleListItem.create(\"Dapibus ac facilisis in\")\n" +
                "                        .appendContent(Badge.create(\"99 unread\").setBackground(Background.CYAN).asElement()))\n" +
                "\n" +
                "                .appendItem(SimpleListItem.create(\"Morbi leo risus\")\n" +
                "                        .appendContent(Badge.create(\"99+\").setBackground(Background.TEAL).asElement()))\n" +
                "\n" +
                "                .appendItem(SimpleListItem.create(\"Porta ac consectetur ac\")\n" +
                "                        .appendContent(Badge.create(\"21\").setBackground(Background.ORANGE).asElement()))\n" +
                "\n" +
                "                .appendItem(SimpleListItem.create(\"Vestibulum at eros\")\n" +
                "                        .appendContent(Badge.create(\"Pending\").setBackground(Background.PURPLE).asElement()))\n" +
                "                .asElement()).asElement()));")
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

        element.appendChild(Card.createCodeCard("Row row = Row.create();\n" +
                "Column column = Column.create()\n" +
                "        .onLarge(Column.OnLarge.six)\n" +
                "        .onMedium(Column.OnMedium.six)\n" +
                "        .onSmall(Column.OnSmall.twelve)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "element.appendChild(row.asElement());\n" +
                "\n" +
                "ListGroup<String> listGroup=ListGroup.create();\n" +
                "listGroup\n" +
                "        .multiSelect()\n" +
                "        .appendItem(listGroup.createItem(\"Value1\", \"Cras justo odio\").select())\n" +
                "        .appendItem(listGroup.createItem(\"Value2\", \"Dapibus ac facilisis in\"))\n" +
                "        .appendItem(listGroup.createItem(\"Value3\", \"Morbi leo risus\"))\n" +
                "        .appendItem(listGroup.createItem(\"Value4\", \"Porta ac consectetur ac\"))\n" +
                "        .appendItem(listGroup.createItem(\"Value5\", \"Vestibulum at eros\"));\n" +
                "\n" +
                "row.addColumn(column.addElement(Card.create(\"SELECTABLE ITEMS\", \"Use ListGroup instead of SimpleListGroup to make items selectable.\")\n" +
                "        .appendContent(listGroup.asElement()).asElement()));\n" +
                "\n" +
                "ListGroup<String> disabledItems=ListGroup.create();\n" +
                "disabledItems\n" +
                "        .appendItem(disabledItems.createItem(\"Value1\", \"Cras justo odio\").disable())\n" +
                "        .appendItem(disabledItems.createItem(\"Value2\", \"Dapibus ac facilisis in\").select())\n" +
                "        .appendItem(disabledItems.createItem(\"Value3\", \"Morbi leo risus\").disable())\n" +
                "        .appendItem(disabledItems.createItem(\"Value4\", \"Porta ac consectetur ac\"))\n" +
                "        .appendItem(disabledItems.createItem(\"Value5\", \"Vestibulum at eros\"));\n" +
                "\n" +
                "row.addColumn(column.copy().addElement(Card.create(\"DISABLED ITEMS\", \"List group items can be disabled and prevented from being selected.\")\n" +
                "        .appendContent(disabledItems.asElement()).asElement()));")
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
                .appendItem(coloredGroup.createItem("Value1", "Cras justo odio").disable().setBackground(Background.PINK))
                .appendItem(coloredGroup.createItem("Value2", "Dapibus ac facilisis in").setBackground(Background.TEAL))
                .appendItem(coloredGroup.createItem("Value3", "Morbi leo risus").setBackground(Background.LIGHT_GREEN))
                .appendItem(coloredGroup.createItem("Value4", "Porta ac consectetur ac").setBackground(Background.AMBER))
                .appendItem(coloredGroup.createItem("Value5", "Vestibulum at eros").setBackground(Background.DEEP_PURPLE));

        row.addColumn(column.copy().addElement(Card.create("MATERIAL DESIGN COLORS", "Use Material design background colors to style list items.")
                .appendContent(coloredGroup.asElement()).asElement()));

        element.appendChild(Card.createCodeCard("Row row = Row.create();\n" +
                "Column column = Column.create()\n" +
                "        .onLarge(Column.OnLarge.six)\n" +
                "        .onMedium(Column.OnMedium.six)\n" +
                "        .onSmall(Column.OnSmall.twelve)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "element.appendChild(row.asElement());\n" +
                "\n" +
                "ListGroup<String> contextualGroup = ListGroup.create();\n" +
                "contextualGroup\n" +
                "        .appendItem(contextualGroup.createItem(\"Value1\", \"Cras justo odio\").select().success())\n" +
                "        .appendItem(contextualGroup.createItem(\"Value2\", \"Dapibus ac facilisis in\").info())\n" +
                "        .appendItem(contextualGroup.createItem(\"Value3\", \"Morbi leo risus\").warning())\n" +
                "        .appendItem(contextualGroup.createItem(\"Value4\", \"Porta ac consectetur ac\").error())\n" +
                "        .appendItem(contextualGroup.createItem(\"Value5\", \"Vestibulum at eros\"));\n" +
                "\n" +
                "row.addColumn(column.addElement(Card.create(\"CONTEXTUAL CLASSES\", \"Use contextual classes to style list items.\")\n" +
                "        .appendContent(contextualGroup.asElement()).asElement()));\n" +
                "\n" +
                "ListGroup<String> coloredGroup = ListGroup.create();\n" +
                "coloredGroup\n" +
                "        .appendItem(coloredGroup.createItem(\"Value1\", \"Cras justo odio\").disable().setBackground(Background.PINK))\n" +
                "        .appendItem(coloredGroup.createItem(\"Value2\", \"Dapibus ac facilisis in\").setBackground(Background.TEAL))\n" +
                "        .appendItem(coloredGroup.createItem(\"Value3\", \"Morbi leo risus\").setBackground(Background.LIGHT_GREEN))\n" +
                "        .appendItem(coloredGroup.createItem(\"Value4\", \"Porta ac consectetur ac\").setBackground(Background.AMBER))\n" +
                "        .appendItem(coloredGroup.createItem(\"Value5\", \"Vestibulum at eros\").setBackground(Background.DEEP_PURPLE));\n" +
                "\n" +
                "row.addColumn(column.copy().addElement(Card.create(\"MATERIAL DESIGN COLORS\", \"Use Material design background colors to style list items.\")\n" +
                "        .appendContent(coloredGroup.asElement()).asElement()));")
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

        element.appendChild(Card.createCodeCard("ListGroup<String> listGroup = ListGroup.create();\n" +
                "listGroup\n" +
                "        .appendItem(listGroup.createItem(\"value1\", SAMPLE_CONTENT).setHeading(\"Cras justo odio\"))\n" +
                "        .appendItem(listGroup.createItem(\"value2\", SAMPLE_CONTENT).setHeading(\"Dapibus ac facilisis in\"))\n" +
                "        .appendItem(listGroup.createItem(\"value3\", SAMPLE_CONTENT).setHeading(\"Morbi leo risus\"))\n" +
                "        .appendItem(listGroup.createItem(\"value4\", SAMPLE_CONTENT).setHeading(\"Porta ac consectetur ac\").select())\n" +
                "        .appendItem(listGroup.createItem(\"value5\", SAMPLE_CONTENT).setHeading(\"Vestibulum at eros\"));\n" +
                "\n" +
                "element.appendChild(Card.create(\"RICH ITEMS\", \"Add rich items with header and description.\")\n" +
                "        .appendContent(listGroup.asElement()).asElement());")
                .asElement());
    }

    @Override
    public void showIn(Content content) {
        HTMLElement contentElement = Js.cast(content.get());
        contentElement.appendChild(element);
    }
}