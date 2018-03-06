package com.progressoft.brix.domino.badges.client.views.ui;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.badges.client.presenters.BadgesPresenter;
import com.progressoft.brix.domino.badges.client.views.BadgesView;
import com.progressoft.brix.domino.badges.client.views.CodeResource;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentView;
import com.progressoft.brix.domino.ui.badges.Badge;
import com.progressoft.brix.domino.ui.button.Button;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.column.Column;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.lists.ListGroup;
import com.progressoft.brix.domino.ui.row.Row;
import com.progressoft.brix.domino.ui.style.Background;
import elemental2.dom.HTMLDivElement;
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
                        .addColumn(column.addElement(Button.create("GREEN").setBackground(Background.GREEN).large().block()
                                .appendContent(Badge.create("2").asElement())
                                .asElement()))
                        .addColumn(column.copy().addElement(Button.create("BLUE").setBackground(Background.BLUE).large().block()
                                .appendContent(Badge.create("10+").asElement())
                                .asElement()))
                        .addColumn(column.copy().addElement(Button.create("RED").setBackground(Background.RED).large().block()
                                .appendContent(Badge.create("13").asElement())
                                .asElement()))
                        .addColumn(column.copy().addElement(Button.create("ORANGE").setBackground(Background.ORANGE).large().block()
                                .appendContent(Badge.create("5").asElement())
                                .asElement()))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(Button.create("PINK").setBackground(Background.PINK).large().block()
                                .appendContent(Badge.create("14").asElement())
                                .asElement()))
                        .addColumn(column.copy().addElement(Button.create("CYAN").setBackground(Background.CYAN).large().block()
                                .appendContent(Badge.create("99+").asElement())
                                .asElement()))
                        .addColumn(column.copy().addElement(Button.create("TEAL").setBackground(Background.TEAL).large().block()
                                .appendContent(Badge.create("26").asElement())
                                .asElement()))
                        .addColumn(column.copy().addElement(Button.create("PURPLE").setBackground(Background.PURPLE).large().block()
                                .appendContent(Badge.create("47").asElement())
                                .asElement()))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.buttonExamplesWithMaterialDesignColors()).asElement());
    }

    private void listExample() {

        ListGroup<String> listGroup = ListGroup.create();
        listGroup.addItem("SomeValue").setText("Cras justo odio").appendContent(Badge.create("14 new").setBackground(Background.RED).asElement());
        listGroup.addItem("SomeValue").setText("Dapibus ac facilisis in").appendContent(Badge.create("99 unread").setBackground(Background.CYAN).asElement());
        listGroup.addItem("SomeValue").setText("Morbi leo risus").appendContent(Badge.create("99+").setBackground(Background.TEAL).asElement());
        listGroup.addItem("SomeValue").setText("Porta ac consectetur ac").appendContent(Badge.create("21").setBackground(Background.ORANGE).asElement());
        listGroup.addItem("SomeValue").setText("Vestibulum at eros").appendContent(Badge.create("18").setBackground(Background.PURPLE).asElement());

        element.appendChild(Card.create("LIST EXAMPLE", "You can also put badge to list and use the material design colors.")
                .appendContent(listGroup.asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.listExample())
                .asElement());
    }

}