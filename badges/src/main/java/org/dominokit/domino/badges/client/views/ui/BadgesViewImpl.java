package org.dominokit.domino.badges.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.badges.client.presenters.BadgesProxy;
import org.dominokit.domino.badges.client.views.BadgesView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.lists.ListGroup;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.jboss.elemento.Elements;

@UiView(presentable = BadgesProxy.class)
@SampleClass
public class BadgesViewImpl extends BaseDemoView<HTMLDivElement> implements BadgesView {


    private HTMLDivElement element = Elements.div().element();

    @Override
    protected HTMLDivElement init() {
        element.appendChild(LinkToSourceCode.create("badges", this.getClass()).element());
        element.appendChild(BlockHeader.create("BADGES").element());

        buttonExample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.buttonExample()).element());

        buttonExamplesWithMaterialDesignColors();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.buttonExamplesWithMaterialDesignColors()).element());

        listExample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.listExample())
                .element());

        return element;
    }

    @SampleMethod
    private void buttonExample() {

        element.appendChild(Card.create("BUTTON EXAMPLES")
                .appendChild(Row.create()
                        .addColumn(Column.span3().appendChild(Button.createSuccess("SUCCESS ")
                                .large()
                                .block()
                                .appendChild(Badge.create("4"))
                                ))
                        .addColumn(Column.span3().appendChild(Button.createPrimary("PRIMARY")
                                .large()
                                .block()
                                .appendChild(Badge.create("10+"))
                                ))
                        .addColumn(Column.span3().appendChild(Button.createDanger("DANGER")
                                .large()
                                .block()
                                .appendChild(Badge.create("8"))
                                ))
                        .addColumn(Column.span3().appendChild(Button.createWarning("WARNING")
                                .large()
                                .block()
                                .appendChild(Badge.create("3"))
                                ))
                        )
                .element());
    }

    @SampleMethod
    private void buttonExamplesWithMaterialDesignColors() {

        this.element.appendChild(Card.create("BUTTON EXAMPLES WITH MATERIAL DESIGN COLORS")
                .appendChild(Row.create()
                        .addColumn(Column.span3().appendChild(Button.create("GREEN").setBackground(Color.GREEN).large().block()
                                .appendChild(Badge.create("2"))
                                ))
                        .addColumn(Column.span3().appendChild(Button.create("BLUE").setBackground(Color.BLUE).large().block()
                                .appendChild(Badge.create("10+"))
                                ))
                        .addColumn(Column.span3().appendChild(Button.create("RED").setBackground(Color.RED).large().block()
                                .appendChild(Badge.create("13"))
                                ))
                        .addColumn(Column.span3().appendChild(Button.create("ORANGE").setBackground(Color.ORANGE).large().block()
                                .appendChild(Badge.create("5"))
                                ))
                        )
                .appendChild(Row.create()
                        .addColumn(Column.span3().appendChild(Button.create("PINK").setBackground(Color.PINK).large().block()
                                .appendChild(Badge.create("14"))
                                ))
                        .addColumn(Column.span3().appendChild(Button.create("CYAN").setBackground(Color.CYAN).large().block()
                                .appendChild(Badge.create("99+"))
                                ))
                        .addColumn(Column.span3().appendChild(Button.create("TEAL").setBackground(Color.TEAL).large().block()
                                .appendChild(Badge.create("26"))
                                ))
                        .addColumn(Column.span3().appendChild(Button.create("PURPLE").setBackground(Color.PURPLE).large().block()
                                .appendChild(Badge.create("47"))
                                ))
                        )
                .element());
    }

    @SampleMethod
    private void listExample() {

        ListGroup<String> listGroup = ListGroup.create();
        listGroup.addItem("SomeValue").setText("Cras justo odio").appendChild(Badge.create("14 new").setBackground(Color.RED));
        listGroup.addItem("SomeValue").setText("Dapibus ac facilisis in").appendChild(Badge.create("99 unread").setBackground(Color.CYAN));
        listGroup.addItem("SomeValue").setText("Morbi leo risus").appendChild(Badge.create("99+").setBackground(Color.TEAL));
        listGroup.addItem("SomeValue").setText("Porta ac consectetur ac").appendChild(Badge.create("21").setBackground(Color.ORANGE));
        listGroup.addItem("SomeValue").setText("Vestibulum at eros").appendChild(Badge.create("18").setBackground(Color.PURPLE));

        element.appendChild(Card.create("LIST EXAMPLE", "You can also put badge to list and use the material design colors.")
                .appendChild(listGroup)
                .element());
    }

}