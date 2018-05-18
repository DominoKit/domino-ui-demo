package org.dominokit.domino.badges.client.views.ui;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.badges.client.presenters.BadgesPresenter;
import org.dominokit.domino.badges.client.views.BadgesView;
import org.dominokit.domino.badges.client.views.CodeResource;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.lists.ListGroup;
import org.dominokit.domino.ui.row.Row;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Color;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = BadgesPresenter.class)
public class BadgesViewImpl extends ComponentView<HTMLDivElement> implements BadgesView {


    private HTMLDivElement element = Elements.div().asElement();

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {

        element.appendChild(BlockHeader.create("BADGES").asElement());

        buttonExample();
        buttonExamplesWithMaterialDesignColors();
        listExample();

    }

    private void buttonExample() {
        Column column = Column.create()
                .onLarge(Column.OnLarge.three)
                .onMedium(Column.OnMedium.three)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        this.element.appendChild(Card.create("BUTTON EXAMPLES")
                .appendContent(Row.create()
                        .addColumn(column.addElement(Button.createSuccess("SUCCESS ")
                                .large()
                                .block()
                                .appendContent(Badge.create("4").asElement())
                                .asElement()))
                        .addColumn(column.copy().addElement(Button.createPrimary("PRIMARY")
                                .large()
                                .block()
                                .appendContent(Badge.create("10+").asElement())
                                .asElement()))
                        .addColumn(column.copy().addElement(Button.createDanger("DANGER")
                                .large()
                                .block()
                                .appendContent(Badge.create("8").asElement())
                                .asElement()))
                        .addColumn(column.copy().addElement(Button.createWarning("WARNING")
                                .large()
                                .block()
                                .appendContent(Badge.create("3").asElement())
                                .asElement()))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.buttonExample()).asElement());
    }

    private void buttonExamplesWithMaterialDesignColors() {
        Column column = Column.create()
                .onLarge(Column.OnLarge.three)
                .onMedium(Column.OnMedium.three)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        this.element.appendChild(Card.create("BUTTON EXAMPLES WITH MATERIAL DESIGN COLORS")
                .appendContent(Row.create()
                        .addColumn(column.addElement(Button.create("GREEN").setBackground(Color.GREEN).large().block()
                                .appendContent(Badge.create("2").asElement())
                                .asElement()))
                        .addColumn(column.copy().addElement(Button.create("BLUE").setBackground(Color.BLUE).large().block()
                                .appendContent(Badge.create("10+").asElement())
                                .asElement()))
                        .addColumn(column.copy().addElement(Button.create("RED").setBackground(Color.RED).large().block()
                                .appendContent(Badge.create("13").asElement())
                                .asElement()))
                        .addColumn(column.copy().addElement(Button.create("ORANGE").setBackground(Color.ORANGE).large().block()
                                .appendContent(Badge.create("5").asElement())
                                .asElement()))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(Button.create("PINK").setBackground(Color.PINK).large().block()
                                .appendContent(Badge.create("14").asElement())
                                .asElement()))
                        .addColumn(column.copy().addElement(Button.create("CYAN").setBackground(Color.CYAN).large().block()
                                .appendContent(Badge.create("99+").asElement())
                                .asElement()))
                        .addColumn(column.copy().addElement(Button.create("TEAL").setBackground(Color.TEAL).large().block()
                                .appendContent(Badge.create("26").asElement())
                                .asElement()))
                        .addColumn(column.copy().addElement(Button.create("PURPLE").setBackground(Color.PURPLE).large().block()
                                .appendContent(Badge.create("47").asElement())
                                .asElement()))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.buttonExamplesWithMaterialDesignColors()).asElement());
    }

    private void listExample() {

        ListGroup<String> listGroup = ListGroup.create();
        listGroup.addItem("SomeValue").setText("Cras justo odio").appendContent(Badge.create("14 new").setBackground(Color.RED).asElement());
        listGroup.addItem("SomeValue").setText("Dapibus ac facilisis in").appendContent(Badge.create("99 unread").setBackground(Color.CYAN).asElement());
        listGroup.addItem("SomeValue").setText("Morbi leo risus").appendContent(Badge.create("99+").setBackground(Color.TEAL).asElement());
        listGroup.addItem("SomeValue").setText("Porta ac consectetur ac").appendContent(Badge.create("21").setBackground(Color.ORANGE).asElement());
        listGroup.addItem("SomeValue").setText("Vestibulum at eros").appendContent(Badge.create("18").setBackground(Color.PURPLE).asElement());

        element.appendChild(Card.create("LIST EXAMPLE", "You can also put badge to list and use the material design colors.")
                .appendContent(listGroup.asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.listExample())
                .asElement());
    }

}