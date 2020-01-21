package org.dominokit.domino.tabs.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.tabs.client.presenters.TabsProxy;
import org.dominokit.domino.tabs.client.views.TabsView;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.tabs.*;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;

import static org.dominokit.domino.ui.style.Unit.px;
import static org.jboss.gwt.elemento.core.Elements.b;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = TabsProxy.class)
@SampleClass
public class TabsViewImpl extends BaseDemoView<HTMLDivElement> implements TabsView {

    private static final String SAMPLE_TEXT = "Lorem ipsum dolor sit amet, ut duo atqui exerci dicunt, ius impedit mediocritatem an. Pri ut tation electram moderatius. Per te suavitate democritum. Duis nemore probatus ne quo, ad liber essent aliquid pro. Et eos nusquam accumsan, vide mentitum fabellas ne est, eu munere gubergren sadipscing mel.";

    private HTMLDivElement element = div().element();

    @Override
    protected HTMLDivElement init() {
        element.appendChild(LinkToSourceCode.create("tabs", this.getClass()).element());
        element.appendChild(BlockHeader.create("TABS").element());

        basicSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.basicSample()).element());

        iconsOnly();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.iconsOnly()).element());

        withIconsAndTextSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.withIconsAndTextSample()).element());

        closableTabsSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.closableTabsSample()).element());

        materialDesignColorsSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.materialDesignColorsSample()).element());

        backgroundSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.backgroundSample()).element());

        initDifferentContentSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initDifferentContentSample()).element());

        withAnimation();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.withAnimation()).element());

        verticalTabs();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.verticalTabs()).element());

        return element;
    }

    @SampleMethod
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
                .element());


    }

    @SampleMethod
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
                .element());

    }

    @SampleMethod
    private void withIconsAndTextSample() {
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
                .element());


    }

    @SampleMethod
    private void closableTabsSample() {
        element.appendChild(Card.create("CLOSABLE TABS")
                .appendChild(TabsPanel.create()
                        .appendChild(Tab.create(Icons.ALL.home(), " HOME")
                                .appendChild(b().textContent("Home Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT))
                                .setClosable(true)
                        )

                        .appendChild(Tab.create(Icons.ALL.face(), " PROFILE")
                                .appendChild(b().textContent("Profile Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT))
                                .setClosable(true)
                        )

                        .appendChild(Tab.create(Icons.ALL.email(), " MESSAGES")
                                .appendChild(b().textContent("Messages Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT))
                                .activate()
                                .setClosable(true)
                        )

                        .appendChild(Tab.create(Icons.ALL.settings(), " SETTINGS")
                                .appendChild(b().textContent("Settings Content"))
                                .appendChild(Paragraph.create(SAMPLE_TEXT))
                                .setClosable(true)
                        )
                )
                .element());


    }

    @SampleMethod
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
                .element());


    }

    @SampleMethod
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
                .element());


    }

    @SampleMethod
    private void initDifferentContentSample() {
        DominoElement<HTMLDivElement> contentContainer = DominoElement.of(div())
                .appendChild(BlockHeader.create("TAB CONTENT"))
                .styler(style -> style.setMarginTop("40px")
                        .setPadding("20px"))
                .elevate(Elevation.LEVEL_1);
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
                .element());


    }

    @SampleMethod
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
                .element());


    }

    @SampleMethod
    private void verticalTabs() {
        element.appendChild(Card.create("VERTICAL TABS")
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(VerticalTabsPanel.create()
                                        .apply(element -> element.getTabsContent().css(Styles.p_l_10))
                                        .appendChild(VerticalTab.create("HOME")
                                                .appendChild(b().textContent("Home Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                        .appendChild(VerticalTab.create("PROFILE")
                                                .appendChild(b().textContent("Profile Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                        .appendChild(VerticalTab.create("MESSAGES")
                                                .appendChild(b().textContent("Messages Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT))
                                                .activate())
                                        .appendChild(VerticalTab.create("SETTINGS")
                                                .appendChild(b().textContent("Settings Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                )
                        )
                        .appendChild(Column.span6()
                                .appendChild(VerticalTabsPanel.create()
                                        .apply(element -> element.getTabsContent().css(Styles.p_l_10))
                                        .appendChild(VerticalTab.create("HOME", Icons.ALL.home())
                                                .appendChild(b().textContent("Home Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                        .appendChild(VerticalTab.create("PROFILE", Icons.ALL.face())
                                                .appendChild(b().textContent("Profile Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                        .appendChild(VerticalTab.create("MESSAGES", Icons.ALL.message())
                                                .appendChild(b().textContent("Messages Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT))
                                                .activate())
                                        .appendChild(VerticalTab.create("SETTINGS", Icons.ALL.settings())
                                                .appendChild(b().textContent("Settings Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(VerticalTabsPanel.create()
                                        .styler(style -> style.setHeight(px.of(400)))
                                        .textBelowIcon()
                                        .setTransition(Transition.FADE_IN)
                                        .apply(element -> element.getTabsContent().css(Styles.p_l_10))
                                        .appendChild(VerticalTab.create("HOME", Icons.ALL.home())
                                                .appendChild(b().textContent("Home Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                        .appendChild(VerticalTab.create("PROFILE", Icons.ALL.face())
                                                .appendChild(b().textContent("Profile Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                        .appendChild(VerticalTab.create("MESSAGES", Icons.ALL.message())
                                                .appendChild(b().textContent("Messages Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT))
                                                .activate())
                                        .appendChild(FillItem.create())
                                        .appendChild(VerticalTab.create("SETTINGS", Icons.ALL.settings())
                                                .appendChild(b().textContent("Settings Content"))
                                                .appendChild(Paragraph.create(SAMPLE_TEXT)))
                                )
                        )
                )
                .element());


    }
}