package org.dominokit.domino.tabs.client.views.ui;

import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.tabs.client.views.CodeResource;
import org.dominokit.domino.tabs.client.views.TabsView;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.tabs.client.presenters.TabsPresenter;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.tabs.Tab;
import org.dominokit.domino.ui.tabs.TabsPanel;
import elemental2.dom.HTMLDivElement;

import static org.jboss.gwt.elemento.core.Elements.b;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = TabsPresenter.class)
public class TabsViewImpl extends ComponentView<HTMLDivElement> implements TabsView {

    private static final String SAMPLE_TEXT = "Lorem ipsum dolor sit amet, ut duo atqui exerci dicunt, ius impedit mediocritatem an. Pri ut tation electram moderatius. Per te suavitate democritum. Duis nemore probatus ne quo, ad liber essent aliquid pro. Et eos nusquam accumsan, vide mentitum fabellas ne est, eu munere gubergren sadipscing mel.";

    private HTMLDivElement element = div().asElement();
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
                .appendChild(TabsPanel.create()
                        .addTab(Tab.create("HOME")
                                .appendChild(b().textContent("Home Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        .addTab(Tab.create("PROFILE")
                                .appendChild(b().textContent("Profile Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        .addTab(Tab.create("MESSAGES")
                                .appendChild(b().textContent("Messages Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT))
                                .activate())
                        .addTab(Tab.create("SETTINGS")
                                .appendChild(b().textContent("Settings Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        )
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.basicSample()).asElement());
    }

    private void iconsOnly() {
        element.appendChild(Card.create("TABS WITH ONLY ICON TITLE")
                .appendChild(TabsPanel.create()
                        .addTab(Tab.create(Icons.ALL.home())
                                .appendChild(b().textContent("Home Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        .addTab(Tab.create(Icons.ALL.face())
                                .appendChild(b().textContent("Profile Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        .addTab(Tab.create(Icons.ALL.email())
                                .appendChild(b().textContent("Messages Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT))
                                .activate())
                        .addTab(Tab.create(Icons.ALL.settings())
                                .appendChild(b().textContent("Settings Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        )
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.iconsOnly()).asElement());
    }

    private void withIconsAndTextSamlple() {
        element.appendChild(Card.create("TABS WITH ICON TITLE")
                .appendChild(TabsPanel.create()
                        .addTab(Tab.create(Icons.ALL.home(), " HOME")
                                .appendChild(b().textContent("Home Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        .addTab(Tab.create(Icons.ALL.face(), " PROFILE")
                                .appendChild(b().textContent("Profile Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        .addTab(Tab.create(Icons.ALL.email(), " MESSAGES")
                                .appendChild(b().textContent("Messages Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT))
                                .activate())
                        .addTab(Tab.create(Icons.ALL.settings(), " SETTINGS")
                                .appendChild(b().textContent("Settings Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        )
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.withIconsAndTextSamlple()).asElement());
    }

    private void materialDesignColorsSample() {
        element.appendChild(Card.create("TABS WITH MATERIAL DESIGN COLORS", "You can use Material Design Colors")
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .appendChild(TabsPanel.create()
                                        .addTab(Tab.create("HOME"))
                                        .addTab(Tab.create("PROFILE"))
                                        .addTab(Tab.create("MESSAGES").activate())
                                        .addTab(Tab.create("SETTINGS"))
                                        .setColor(Color.PINK)
                                        )
                                .appendChild(TabsPanel.create()
                                        .addTab(Tab.create("HOME"))
                                        .addTab(Tab.create("PROFILE"))
                                        .addTab(Tab.create("MESSAGES").activate())
                                        .addTab(Tab.create("SETTINGS"))
                                        .setColor(Color.TEAL)
                                        )
                                .appendChild(TabsPanel.create()
                                        .addTab(Tab.create("HOME"))
                                        .addTab(Tab.create("PROFILE"))
                                        .addTab(Tab.create("MESSAGES").activate())
                                        .addTab(Tab.create("SETTINGS"))
                                        .setColor(Color.PURPLE)
                                        )
                        )
                        .addColumn(Column.span6()
                                .appendChild(TabsPanel.create()
                                        .addTab(Tab.create("HOME"))
                                        .addTab(Tab.create("PROFILE"))
                                        .addTab(Tab.create("MESSAGES").activate())
                                        .addTab(Tab.create("SETTINGS"))
                                        .setColor(Color.RED)
                                        )
                                .appendChild(TabsPanel.create()
                                        .addTab(Tab.create("HOME"))
                                        .addTab(Tab.create("PROFILE"))
                                        .addTab(Tab.create("MESSAGES").activate())
                                        .addTab(Tab.create("SETTINGS"))
                                        .setColor(Color.ORANGE)
                                        )
                                .appendChild(TabsPanel.create()
                                        .addTab(Tab.create("HOME"))
                                        .addTab(Tab.create("PROFILE"))
                                        .addTab(Tab.create("MESSAGES").activate())
                                        .addTab(Tab.create("SETTINGS"))
                                        .setColor(Color.BLUE_GREY)
                                        )
                        )
                        )
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.materialDesignColorsSample()).asElement());
    }

    private void withAnimation() {
        element.appendChild(Card.create("TABS WITH CUSTOM ANIMATIONS", "Animate the tabs content when they show up.")
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .appendChild(TabsPanel.create()
                                        .addTab(Tab.create(Icons.ALL.home(), " HOME")
                                                .appendChild(b().textContent("Home Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                        .addTab(Tab.create(Icons.ALL.face(), " PROFILE")
                                                .appendChild(b().textContent("Profile Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                        .addTab(Tab.create(Icons.ALL.email(), " MESSAGES")
                                                .appendChild(b().textContent("Messages Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT))
                                                .activate())
                                        .addTab(Tab.create(Icons.ALL.settings(), " SETTINGS")
                                                .appendChild(b().textContent("Settings Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                        .setTransition(Transition.ROTATE_IN_UP_LEFT)
                                        ))
                        .addColumn(Column.span6()
                                .appendChild(TabsPanel.create()
                                        .addTab(Tab.create(Icons.ALL.home(), " HOME")
                                                .appendChild(b().textContent("Home Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                        .addTab(Tab.create(Icons.ALL.face(), " PROFILE")
                                                .appendChild(b().textContent("Profile Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                        .addTab(Tab.create(Icons.ALL.email(), " MESSAGES")
                                                .appendChild(b().textContent("Messages Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT))
                                                .activate())
                                        .addTab(Tab.create(Icons.ALL.settings(), " SETTINGS")
                                                .appendChild(b().textContent("Settings Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                        .setTransition(Transition.FADE_IN_RIGHT)
                                        ))
                        )
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.withAnimation()).asElement());
    }
}