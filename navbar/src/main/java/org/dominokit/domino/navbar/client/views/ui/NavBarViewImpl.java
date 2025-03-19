package org.dominokit.domino.navbar.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.navbar.client.presenters.NavBarProxy;
import org.dominokit.domino.navbar.client.views.NavBarView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.search.SearchBox;
import org.dominokit.domino.ui.tabs.Tab;
import org.dominokit.domino.ui.tabs.TabsPanel;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

import static org.dominokit.domino.ui.utils.Domino.*;

@UiView(presentable = NavBarProxy.class)
@SampleClass
public class NavBarViewImpl extends BaseDemoView<HTMLDivElement> implements NavBarView {

    private DivElement element = div();

    @Override
    protected HTMLDivElement init() {

        element.appendChild(LinkToSourceCode.createLink("navbar", NavBarViewImpl.class));
        element.appendChild(BlockHeader.create("Navigation bar"));

        basicNavBar();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.basicNavBar()));

        basicWithPrefixAndPostfix();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.basicWithPrefixAndPostfix()));

        withBody();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.withBody()));

        return element.element();
    }

    @SampleMethod
    private void basicNavBar() {
        element
                .appendChild(Card.create("SIMPLE NAVBAR", "A very simple NavBar with a title")
                        .setCollapsible(true)
                        .appendChild(div().addCss(dui_flex, dui_flex_col, dui_gap_4)
                                .appendChild(NavBar.create("Section title")
                                        .addCss(dui_accent, dui_h_12, dui_p_x_4)
                                )
                                .appendChild(NavBar.create("Section title")
                                        .addCss(dui_accent, dui_h_12, dui_p_x_4)
                                        .setDescription("description goes here")
                                )
                        )

                );
    }

    @SampleMethod
    private void basicWithPrefixAndPostfix() {
        element
                .appendChild(Card.create("PRE/POST ADDONS NAVBAR", "Navigation bars can have prefix and postfix addons")
                        .setCollapsible(true)
                        .appendChild(div().addCss(dui_flex, dui_flex_col, dui_gap_4)
                                .appendChild(NavBar.create("Section title")
                                        .addCss(dui_accent, dui_h_12, dui_p_x_4)
                                        .appendChild(PrefixAddOn.of(Icons.view_headline().clickable()))
                                        .appendChild(PostfixAddOn.of(Icons.bell().clickable()))
                                        .appendChild(PostfixAddOn.of(Icons.cog().clickable()))
                                )
                                .appendChild(NavBar.create("Section title")
                                        .addCss(dui_accent, dui_h_12, dui_p_x_4)
                                        .setDescription("description goes here")
                                        .withPrefixElement((parent, self) ->
                                                self.appendChild(Icons.view_headline().clickable())
                                        )
                                        .withPostfixElement((parent, self) -> self
                                                .appendChild(Icons.bell().clickable())
                                                .appendChild(Icons.cog().clickable())
                                        )
                                )
                        )

                );
    }

    @SampleMethod
    private void withBody() {
        element
                .appendChild(Card.create("NAVBAR BODY", "Elements can be attached to NavBar body")
                        .setCollapsible(true)
                        .appendChild(div().addCss(dui_flex, dui_flex_col, dui_gap_4)
                                .appendChild(NavBar.create("Section title")
                                        .addCss(dui_accent, dui_h_16, dui_p_x_4)
                                        .appendChild(PrefixAddOn.of(Icons.view_headline().clickable()))
                                        .appendChild(PostfixAddOn.of(Icons.bell().clickable()))
                                        .appendChild(PostfixAddOn.of(Icons.cog().clickable()))
                                        .withBody((parent, body) -> {
                                            body
                                                    .addCss(dui_flex, dui_justify_center, dui_items_center)
                                                    .appendChild(SearchBox.create()
                                                            .addCss(dui_w_72, dui_bg_l_1, dui_rounded_md, dui_fg_white, dui_h_12)
                                                            .setCssProperty("--dui-form-field-placeholder-color", "var(--dui-color-5")
                                                    );
                                        })
                                )
                        )

                );
    }


}