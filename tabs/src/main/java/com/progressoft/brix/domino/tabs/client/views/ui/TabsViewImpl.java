package com.progressoft.brix.domino.tabs.client.views.ui;

import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentView;
import com.progressoft.brix.domino.tabs.client.views.CodeResource;
import com.progressoft.brix.domino.tabs.client.views.TabsView;
import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.tabs.client.presenters.TabsPresenter;
import com.progressoft.brix.domino.ui.Typography.Paragraph;
import com.progressoft.brix.domino.ui.animations.Transition;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.column.Column;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.icons.Icons;
import com.progressoft.brix.domino.ui.row.Row;
import com.progressoft.brix.domino.ui.style.Color;
import com.progressoft.brix.domino.ui.tabs.Tab;
import com.progressoft.brix.domino.ui.tabs.TabsPanel;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import jsinterop.base.Js;

import static org.jboss.gwt.elemento.core.Elements.b;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = TabsPresenter.class)
public class TabsViewImpl extends ComponentView<HTMLDivElement> implements TabsView {

    private static final String SAMPLE_TEXT = "Lorem ipsum dolor sit amet, ut duo atqui exerci dicunt, ius impedit mediocritatem an. Pri ut tation electram moderatius. Per te suavitate democritum. Duis nemore probatus ne quo, ad liber essent aliquid pro. Et eos nusquam accumsan, vide mentitum fabellas ne est, eu munere gubergren sadipscing mel.";

    private HTMLDivElement element = div().asElement();
    private final Column column = Column.create()
            .onLarge(Column.OnLarge.six)
            .onMedium(Column.OnMedium.six)
            .onSmall(Column.OnSmall.twelve)
            .onXSmall(Column.OnXSmall.twelve);

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("TABS").asElement());

        basicSample();
        iconsOnly();
        withIconsAndTextSamlple();
        materialDesignColorsSample();
        withAnimation();
    }

    private void basicSample() {
        element.appendChild(Card.create("EXAMPLE TAB", "Add quick, dynamic tab functionality to transition through panes of local content")
                .appendContent(TabsPanel.create()
                        .addTab(Tab.create("HOME")
                                .appendContent(b().textContent("Home Content").asElement())
                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))
                        .addTab(Tab.create("PROFILE")
                                .appendContent(b().textContent("Profile Content").asElement())
                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))
                        .addTab(Tab.create("MESSAGES")
                                .appendContent(b().textContent("Messages Content").asElement())
                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())
                                .activate())
                        .addTab(Tab.create("SETTINGS")
                                .appendContent(b().textContent("Settings Content").asElement())
                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.basicSample()).asElement());
    }

    private void iconsOnly() {
        element.appendChild(Card.create("TABS WITH ONLY ICON TITLE")
                .appendContent(TabsPanel.create()
                        .addTab(Tab.create(Icons.ALL.home())
                                .appendContent(b().textContent("Home Content").asElement())
                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))
                        .addTab(Tab.create(Icons.ALL.face())
                                .appendContent(b().textContent("Profile Content").asElement())
                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))
                        .addTab(Tab.create(Icons.ALL.email())
                                .appendContent(b().textContent("Messages Content").asElement())
                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())
                                .activate())
                        .addTab(Tab.create(Icons.ALL.settings())
                                .appendContent(b().textContent("Settings Content").asElement())
                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.iconsOnly()).asElement());
    }

    private void withIconsAndTextSamlple() {
        element.appendChild(Card.create("TABS WITH ICON TITLE")
                .appendContent(TabsPanel.create()
                        .addTab(Tab.create(Icons.ALL.home(), " HOME")
                                .appendContent(b().textContent("Home Content").asElement())
                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))
                        .addTab(Tab.create(Icons.ALL.face(), " PROFILE")
                                .appendContent(b().textContent("Profile Content").asElement())
                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))
                        .addTab(Tab.create(Icons.ALL.email(), " MESSAGES")
                                .appendContent(b().textContent("Messages Content").asElement())
                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())
                                .activate())
                        .addTab(Tab.create(Icons.ALL.settings(), " SETTINGS")
                                .appendContent(b().textContent("Settings Content").asElement())
                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.withIconsAndTextSamlple()).asElement());
    }

    private void materialDesignColorsSample() {
        element.appendChild(Card.create("TABS WITH MATERIAL DESIGN COLORS", "You can use Material Design Colors")
                .appendContent(Row.create()
                        .addColumn(column.copy()
                                .addElement(TabsPanel.create()
                                        .addTab(Tab.create("HOME"))
                                        .addTab(Tab.create("PROFILE"))
                                        .addTab(Tab.create("MESSAGES").activate())
                                        .addTab(Tab.create("SETTINGS"))
                                        .setColor(Color.PINK)
                                        .asElement())
                                .addElement(TabsPanel.create()
                                        .addTab(Tab.create("HOME"))
                                        .addTab(Tab.create("PROFILE"))
                                        .addTab(Tab.create("MESSAGES").activate())
                                        .addTab(Tab.create("SETTINGS"))
                                        .setColor(Color.TEAL)
                                        .asElement())
                                .addElement(TabsPanel.create()
                                        .addTab(Tab.create("HOME"))
                                        .addTab(Tab.create("PROFILE"))
                                        .addTab(Tab.create("MESSAGES").activate())
                                        .addTab(Tab.create("SETTINGS"))
                                        .setColor(Color.PURPLE)
                                        .asElement())
                        )
                        .addColumn(column.copy()
                                .addElement(TabsPanel.create()
                                        .addTab(Tab.create("HOME"))
                                        .addTab(Tab.create("PROFILE"))
                                        .addTab(Tab.create("MESSAGES").activate())
                                        .addTab(Tab.create("SETTINGS"))
                                        .setColor(Color.RED)
                                        .asElement())
                                .addElement(TabsPanel.create()
                                        .addTab(Tab.create("HOME"))
                                        .addTab(Tab.create("PROFILE"))
                                        .addTab(Tab.create("MESSAGES").activate())
                                        .addTab(Tab.create("SETTINGS"))
                                        .setColor(Color.ORANGE)
                                        .asElement())
                                .addElement(TabsPanel.create()
                                        .addTab(Tab.create("HOME"))
                                        .addTab(Tab.create("PROFILE"))
                                        .addTab(Tab.create("MESSAGES").activate())
                                        .addTab(Tab.create("SETTINGS"))
                                        .setColor(Color.BLUE_GREY)
                                        .asElement())
                        )
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.materialDesignColorsSample()).asElement());
    }

    private void withAnimation() {
        element.appendChild(Card.create("TABS WITH CUSTOM ANIMATIONS", "Animate the tabs content when they show up.")
                .appendContent(Row.create()
                        .addColumn(column.copy()
                                .addElement(TabsPanel.create()
                                        .addTab(Tab.create(Icons.ALL.home(), " HOME")
                                                .appendContent(b().textContent("Home Content").asElement())
                                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))
                                        .addTab(Tab.create(Icons.ALL.face(), " PROFILE")
                                                .appendContent(b().textContent("Profile Content").asElement())
                                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))
                                        .addTab(Tab.create(Icons.ALL.email(), " MESSAGES")
                                                .appendContent(b().textContent("Messages Content").asElement())
                                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())
                                                .activate())
                                        .addTab(Tab.create(Icons.ALL.settings(), " SETTINGS")
                                                .appendContent(b().textContent("Settings Content").asElement())
                                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))
                                        .setTransition(Transition.ROTATE_IN_UP_LEFT)
                                        .asElement()))
                        .addColumn(column.copy()
                                .addElement(TabsPanel.create()
                                        .addTab(Tab.create(Icons.ALL.home(), " HOME")
                                                .appendContent(b().textContent("Home Content").asElement())
                                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))
                                        .addTab(Tab.create(Icons.ALL.face(), " PROFILE")
                                                .appendContent(b().textContent("Profile Content").asElement())
                                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))
                                        .addTab(Tab.create(Icons.ALL.email(), " MESSAGES")
                                                .appendContent(b().textContent("Messages Content").asElement())
                                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())
                                                .activate())
                                        .addTab(Tab.create(Icons.ALL.settings(), " SETTINGS")
                                                .appendContent(b().textContent("Settings Content").asElement())
                                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))
                                        .setTransition(Transition.FADE_IN_RIGHT)
                                        .asElement()))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.withAnimation()).asElement());
    }
}