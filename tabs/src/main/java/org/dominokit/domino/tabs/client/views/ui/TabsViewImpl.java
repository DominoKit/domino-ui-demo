package org.dominokit.domino.tabs.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.tabs.client.presenters.TabsPresenter;
import org.dominokit.domino.tabs.client.views.CodeResource;
import org.dominokit.domino.tabs.client.views.TabsView;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.tabs.Tab;
import org.dominokit.domino.ui.tabs.TabsPanel;
import org.dominokit.domino.ui.utils.DominoElement;

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
        element.appendChild(LinkToSourceCode.create("tabs", this.getClass()).asElement());
        element.appendChild(BlockHeader.create("TABS").asElement());

        basicSample();
        iconsOnly();
        withIconsAndTextSamlple();
        materialDesignColorsSample();
        backgroundSample();
        initDifferentContentSample();
        withAnimation();
    }

    private void basicSample() {
        element.appendChild(Card.create("EXAMPLE TAB", "Add quick, dynamic tab functionality to transition through panes of local content")
                .appendChild(TabsPanel.create()
                        .appendChild(Tab.create("HOME")
                                .appendChild(b().textContent("Home Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        .appendChild(Tab.create("PROFILE")
                                .appendChild(b().textContent("Profile Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        .appendChild(Tab.create("MESSAGES")
                                .appendChild(b().textContent("Messages Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT))
                                .activate())
                        .appendChild(Tab.create("SETTINGS")
                                .appendChild(b().textContent("Settings Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        )
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.basicSample()).asElement());
    }

    private void iconsOnly() {
        element.appendChild(Card.create("TABS WITH ONLY ICON TITLE")
                .appendChild(TabsPanel.create()
                        .appendChild(Tab.create(Icons.ALL.home())
                                .appendChild(b().textContent("Home Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        .appendChild(Tab.create(Icons.ALL.face())
                                .appendChild(b().textContent("Profile Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        .appendChild(Tab.create(Icons.ALL.email())
                                .appendChild(b().textContent("Messages Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT))
                                .activate())
                        .appendChild(Tab.create(Icons.ALL.settings())
                                .appendChild(b().textContent("Settings Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        )
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.iconsOnly()).asElement());
    }

    private void withIconsAndTextSamlple() {
        element.appendChild(Card.create("TABS WITH ICON TITLE")
                .appendChild(TabsPanel.create()
                        .appendChild(Tab.create(Icons.ALL.home(), " HOME")
                                .appendChild(b().textContent("Home Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        .appendChild(Tab.create(Icons.ALL.face(), " PROFILE")
                                .appendChild(b().textContent("Profile Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        .appendChild(Tab.create(Icons.ALL.email(), " MESSAGES")
                                .appendChild(b().textContent("Messages Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT))
                                .activate())
                        .appendChild(Tab.create(Icons.ALL.settings(), " SETTINGS")
                                .appendChild(b().textContent("Settings Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        )
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.withIconsAndTextSamlple()).asElement());
    }

    private void materialDesignColorsSample() {
        element.appendChild(Card.create("TABS WITH MATERIAL DESIGN COLORS", "You can use Material Design Colors")
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                        .setColor(Color.PINK)
                                        )
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                        .setColor(Color.TEAL)
                                        )
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                        .setColor(Color.PURPLE)
                                        )
                        )
                        .addColumn(Column.span6()
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                        .setColor(Color.RED)
                                        )
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                        .setColor(Color.ORANGE)
                                        )
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                        .setColor(Color.BLUE_GREY)
                                        )
                        )
                        )
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.materialDesignColorsSample()).asElement());
    }

    private void backgroundSample() {
        element.appendChild(Card.create("TABS WITH MATERIAL DESIGN BACKGROUNDS", "You can use Material Design backgrounds")
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .appendChild(TabsPanel.create()
                                        .setBackgroundColor(Color.INDIGO)
                                        .setColor(Color.WHITE)
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                )
                                .appendChild(TabsPanel.create()
                                        .setBackgroundColor(Color.RED)
                                        .setColor(Color.WHITE)
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                )
                                .appendChild(TabsPanel.create()
                                        .setBackgroundColor(Color.PINK)
                                        .setColor(Color.WHITE)
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                )
                        )
                        .addColumn(Column.span6()
                                .appendChild(TabsPanel.create()
                                        .setBackgroundColor(Color.GREEN)
                                        .setColor(Color.WHITE)
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                )
                                .appendChild(TabsPanel.create()
                                        .setBackgroundColor(Color.PURPLE)
                                        .setColor(Color.WHITE)
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                )
                                .appendChild(TabsPanel.create()
                                        .setBackgroundColor(Color.LIME)
                                        .setColor(Color.WHITE)
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                )
                        )
                )
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.materialDesignBackgroundsSample()).asElement());
    }

    private void initDifferentContentSample() {
        DominoElement<HTMLDivElement> contentContainer = DominoElement.of(div())
                .appendChild(BlockHeader.create("TAB CONTENT"))
                .styler(style -> style.setMarginTop("40px")
                        .setPadding("20px")
                        .add(Styles.default_shadow));
        element.appendChild(Card.create("TABS WITH CONTENT CONTAINER", "Tabs can have different content container")
                .appendChild(TabsPanel.create()
                        .setContentContainer(contentContainer)
                        .appendChild(Tab.create("HOME")
                                .appendChild(b().textContent("Home Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        .appendChild(Tab.create("PROFILE")
                                .appendChild(b().textContent("Profile Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                        .appendChild(Tab.create("MESSAGES")
                                .appendChild(b().textContent("Messages Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT))
                                .activate())
                        .appendChild(Tab.create("SETTINGS")
                                .appendChild(b().textContent("Settings Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                )
                .appendChild(contentContainer)
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.differentContentContainerSample()).asElement());
    }

    private void withAnimation() {
        element.appendChild(Card.create("TABS WITH CUSTOM ANIMATIONS", "Animate the tabs content when they show up.")
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create(Icons.ALL.home(), " HOME")
                                                .appendChild(b().textContent("Home Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                        .appendChild(Tab.create(Icons.ALL.face(), " PROFILE")
                                                .appendChild(b().textContent("Profile Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                        .appendChild(Tab.create(Icons.ALL.email(), " MESSAGES")
                                                .appendChild(b().textContent("Messages Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT))
                                                .activate())
                                        .appendChild(Tab.create(Icons.ALL.settings(), " SETTINGS")
                                                .appendChild(b().textContent("Settings Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                        .setTransition(Transition.ROTATE_IN_UP_LEFT)
                                        ))
                        .addColumn(Column.span6()
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create(Icons.ALL.home(), " HOME")
                                                .appendChild(b().textContent("Home Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                        .appendChild(Tab.create(Icons.ALL.face(), " PROFILE")
                                                .appendChild(b().textContent("Profile Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                        .appendChild(Tab.create(Icons.ALL.email(), " MESSAGES")
                                                .appendChild(b().textContent("Messages Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT))
                                                .activate())
                                        .appendChild(Tab.create(Icons.ALL.settings(), " SETTINGS")
                                                .appendChild(b().textContent("Settings Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                        .setTransition(Transition.FADE_IN_RIGHT)
                                        ))
                        )
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.withAnimation()).asElement());
    }
}