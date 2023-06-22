package org.dominokit.domino.helpers.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.helpers.client.presenters.HelpersProxy;
import org.dominokit.domino.helpers.client.views.HelpersView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.typography.BlockHeader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@UiView(presentable = HelpersProxy.class)
@SampleClass
public class HelpersViewImpl extends BaseDemoView<HTMLDivElement> implements HelpersView {

    private static final String SAMPLE_TEXT = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    private DivElement element = div();

    @Override
    protected HTMLDivElement init() {

        element.appendChild(LinkToSourceCode.createLink("helpers", this.getClass()));
        element.appendChild(BlockHeader.create("HELPER CLASSES"));

        heightClasses();
        widthClasses();
        marginClasses();
        paddingClasses();

//        textStyles();
//        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.textStyles()));

//        fontSize();
//        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.fontSize()));
//
//        textAligns();
//        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.textAligns()));
//
//        marginAndPaddingSpaces();
//        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.marginAndPaddingSpaces()));

        return element.element();
    }

    private void heightClasses() {
        List<CssClass> heightClasses = Arrays.asList(dui_h_0,
                dui_h_px,
                dui_h_2px,
                dui_h_4px,
                dui_h_8px,
                dui_h_0_5,
                dui_h_1,
                dui_h_1_5,
                dui_h_2,
                dui_h_2_5,
                dui_h_3,
                dui_h_3_5,
                dui_h_4,
                dui_h_5,
                dui_h_6,
                dui_h_7,
                dui_h_8,
                dui_h_9,
                dui_h_10,
                dui_h_11,
                dui_h_12,
                dui_h_14,
                dui_h_16,
                dui_h_20,
                dui_h_24,
                dui_h_28,
                dui_h_32,
                dui_h_36,
                dui_h_40,
                dui_h_44,
                dui_h_48,
                dui_h_52,
                dui_h_56,
                dui_h_60,
                dui_h_64,
                dui_h_72,
                dui_h_80,
                dui_h_96,
                dui_h_1_2p,
                dui_h_1_3p,
                dui_h_1_4p,
                dui_h_2_3p,
                dui_h_3_4p,
                dui_h_full);

        element
                .appendChild(Card.create("HEIGHT CSS CLASSES")
                        .setCollapsible(true)
                        .appendChild(div().addCss(dui_flex, dui_gap_4, dui_flex_wrap)
                                .apply(self -> {
                                    heightClasses.forEach(cssClass -> {
                                        self.appendChild(div().addCss(dui_flex, dui_flex_col, dui_justify_center, dui_gap_1)
                                                .appendChild(span().textContent(cssClass.getCssClass()))
                                                .appendChild(div().addCss(dui_flex, dui_justify_center)
                                                        .setHeight("500px")
                                                        .appendChild(div().addCss(dui_bg_accent, dui_w_4, cssClass)))

                                        );
                                    });
                                })
                        )

                );
    }

    private void widthClasses() {
        List<CssClass> heightClasses = Arrays.asList(dui_w_0,
                dui_w_px,
                dui_w_2px,
                dui_w_4px,
                dui_w_8px,
                dui_w_0_5,
                dui_w_1,
                dui_w_1_5,
                dui_w_2,
                dui_w_2_5,
                dui_w_3,
                dui_w_3_5,
                dui_w_4,
                dui_w_5,
                dui_w_6,
                dui_w_7,
                dui_w_8,
                dui_w_9,
                dui_w_10,
                dui_w_11,
                dui_w_12,
                dui_w_14,
                dui_w_16,
                dui_w_20,
                dui_w_24,
                dui_w_28,
                dui_w_32,
                dui_w_36,
                dui_w_40,
                dui_w_44,
                dui_w_48,
                dui_w_52,
                dui_w_56,
                dui_w_60,
                dui_w_64,
                dui_w_72,
                dui_w_80,
                dui_w_96,
                dui_w_1_2p,
                dui_w_1_3p,
                dui_w_1_4p,
                dui_w_2_3p,
                dui_w_3_4p,
                dui_w_full);

        element
                .appendChild(Card.create("WIDTH CSS CLASSES")
                        .setCollapsible(true)
                        .appendChild(div().addCss(dui_flex, dui_gap_4, dui_flex_col)
                                .apply(self -> {
                                    heightClasses.forEach(cssClass -> {
                                        self
                                                .appendChild(span().textContent(cssClass.getCssClass()))
                                                .appendChild(div().addCss(dui_bg_accent, dui_h_4, cssClass));
                                    });
                                })
                        )

                );
    }

    private void marginClasses() {
        List<CssClass> heightClasses = Arrays.asList(dui_m_0,
                dui_m_px,
                dui_m_2px,
                dui_m_4px,
                dui_m_8px,
                dui_m_0_5,
                dui_m_1,
                dui_m_1_5,
                dui_m_2,
                dui_m_2_5,
                dui_m_3,
                dui_m_3_5,
                dui_m_4,
                dui_m_5,
                dui_m_6,
                dui_m_7,
                dui_m_8,
                dui_m_9,
                dui_m_10,
                dui_m_11,
                dui_m_12,
                dui_m_14,
                dui_m_16,
                dui_m_20,
                dui_m_24,
                dui_m_28,
                dui_m_32,
                dui_m_36,
                dui_m_40,
                dui_m_44,
                dui_m_48,
                dui_m_52,
                dui_m_56,
                dui_m_60,
                dui_m_64,
                dui_m_72,
                dui_m_80,
                dui_m_96,
                dui_m_auto,

                dui_m_b_0,
                dui_m_b_px,
                dui_m_b_2px,
                dui_m_b_4px,
                dui_m_b_8px,
                dui_m_b_0_5,
                dui_m_b_1,
                dui_m_b_1_5,
                dui_m_b_2,
                dui_m_b_2_5,
                dui_m_b_3,
                dui_m_b_3_5,
                dui_m_b_4,
                dui_m_b_5,
                dui_m_b_6,
                dui_m_b_7,
                dui_m_b_8,
                dui_m_b_9,
                dui_m_b_10,
                dui_m_b_11,
                dui_m_b_12,
                dui_m_b_14,
                dui_m_b_16,
                dui_m_b_20,
                dui_m_b_24,
                dui_m_b_28,
                dui_m_b_32,
                dui_m_b_36,
                dui_m_b_40,
                dui_m_b_44,
                dui_m_b_48,
                dui_m_b_52,
                dui_m_b_56,
                dui_m_b_60,
                dui_m_b_64,
                dui_m_b_72,
                dui_m_b_80,
                dui_m_b_96,
                dui_m_b_auto,

                dui_m_l_0,
                dui_m_l_px,
                dui_m_l_2px,
                dui_m_l_4px,
                dui_m_l_8px,
                dui_m_l_0_5,
                dui_m_l_1,
                dui_m_l_1_5,
                dui_m_l_2,
                dui_m_l_2_5,
                dui_m_l_3,
                dui_m_l_3_5,
                dui_m_l_4,
                dui_m_l_5,
                dui_m_l_6,
                dui_m_l_7,
                dui_m_l_8,
                dui_m_l_9,
                dui_m_l_10,
                dui_m_l_11,
                dui_m_l_12,
                dui_m_l_14,
                dui_m_l_16,
                dui_m_l_20,
                dui_m_l_24,
                dui_m_l_28,
                dui_m_l_32,
                dui_m_l_36,
                dui_m_l_40,
                dui_m_l_44,
                dui_m_l_48,
                dui_m_l_52,
                dui_m_l_56,
                dui_m_l_60,
                dui_m_l_64,
                dui_m_l_72,
                dui_m_l_80,
                dui_m_l_96,
                dui_m_l_auto,

                dui_m_r_0,
                dui_m_r_px,
                dui_m_r_2px,
                dui_m_r_4px,
                dui_m_r_8px,
                dui_m_r_0_5,
                dui_m_r_1,
                dui_m_r_1_5,
                dui_m_r_2,
                dui_m_r_2_5,
                dui_m_r_3,
                dui_m_r_3_5,
                dui_m_r_4,
                dui_m_r_5,
                dui_m_r_6,
                dui_m_r_7,
                dui_m_r_8,
                dui_m_r_9,
                dui_m_r_10,
                dui_m_r_11,
                dui_m_r_12,
                dui_m_r_14,
                dui_m_r_16,
                dui_m_r_20,
                dui_m_r_24,
                dui_m_r_28,
                dui_m_r_32,
                dui_m_r_36,
                dui_m_r_40,
                dui_m_r_44,
                dui_m_r_48,
                dui_m_r_52,
                dui_m_r_56,
                dui_m_r_60,
                dui_m_r_64,
                dui_m_r_72,
                dui_m_r_80,
                dui_m_r_96,
                dui_m_r_auto,

                dui_m_t_0,
                dui_m_t_px,
                dui_m_t_2px,
                dui_m_t_4px,
                dui_m_t_8px,
                dui_m_t_0_5,
                dui_m_t_1,
                dui_m_t_1_5,
                dui_m_t_2,
                dui_m_t_2_5,
                dui_m_t_3,
                dui_m_t_3_5,
                dui_m_t_4,
                dui_m_t_5,
                dui_m_t_6,
                dui_m_t_7,
                dui_m_t_8,
                dui_m_t_9,
                dui_m_t_10,
                dui_m_t_11,
                dui_m_t_12,
                dui_m_t_14,
                dui_m_t_16,
                dui_m_t_20,
                dui_m_t_24,
                dui_m_t_28,
                dui_m_t_32,
                dui_m_t_36,
                dui_m_t_40,
                dui_m_t_44,
                dui_m_t_48,
                dui_m_t_52,
                dui_m_t_56,
                dui_m_t_60,
                dui_m_t_64,
                dui_m_t_72,
                dui_m_t_80,
                dui_m_t_96,
                dui_m_t_auto,

                dui_m_x_0,
                dui_m_x_px,
                dui_m_x_2px,
                dui_m_x_4px,
                dui_m_x_8px,
                dui_m_x_0_5,
                dui_m_x_1,
                dui_m_x_1_5,
                dui_m_x_2,
                dui_m_x_2_5,
                dui_m_x_3,
                dui_m_x_3_5,
                dui_m_x_4,
                dui_m_x_5,
                dui_m_x_6,
                dui_m_x_7,
                dui_m_x_8,
                dui_m_x_9,
                dui_m_x_10,
                dui_m_x_11,
                dui_m_x_12,
                dui_m_x_14,
                dui_m_x_16,
                dui_m_x_20,
                dui_m_x_24,
                dui_m_x_28,
                dui_m_x_32,
                dui_m_x_36,
                dui_m_x_40,
                dui_m_x_44,
                dui_m_x_48,
                dui_m_x_52,
                dui_m_x_56,
                dui_m_x_60,
                dui_m_x_64,
                dui_m_x_72,
                dui_m_x_80,
                dui_m_x_96,
                dui_m_x_auto,

                dui_m_y_0,
                dui_m_y_px,
                dui_m_y_2px,
                dui_m_y_4px,
                dui_m_y_8px,
                dui_m_y_0_5,
                dui_m_y_1,
                dui_m_y_1_5,
                dui_m_y_2,
                dui_m_y_2_5,
                dui_m_y_3,
                dui_m_y_3_5,
                dui_m_y_4,
                dui_m_y_5,
                dui_m_y_6,
                dui_m_y_7,
                dui_m_y_8,
                dui_m_y_9,
                dui_m_y_10,
                dui_m_y_11,
                dui_m_y_12,
                dui_m_y_14,
                dui_m_y_16,
                dui_m_y_20,
                dui_m_y_24,
                dui_m_y_28,
                dui_m_y_32,
                dui_m_y_36,
                dui_m_y_40,
                dui_m_y_44,
                dui_m_y_48,
                dui_m_y_52,
                dui_m_y_56,
                dui_m_y_60,
                dui_m_y_64,
                dui_m_y_72,
                dui_m_y_80,
                dui_m_y_96,
                dui_m_y_auto);

        element
                .appendChild(Card.create("MARGIN CSS CLASSES")
                        .setCollapsible(true)
                        .appendChild(div().addCss(dui_flex, dui_gap_4, dui_flex_col)
                                .apply(self -> {
                                    heightClasses.forEach(cssClass -> {
                                        self
                                                .appendChild(span().textContent(cssClass.getCssClass()))
                                                .appendChild(div()
                                                        .addCss(dui_border, dui_border_accent, dui_border_solid, dui_w_fit, dui_h_fit)
                                                        .appendChild(div().addCss(dui_bg_accent, dui_h_12, dui_w_12, cssClass))
                                                );
                                    });
                                })
                        )

                );
    }
    private void paddingClasses() {
        List<CssClass> heightClasses = Arrays.asList(dui_p_0,
                dui_p_px,
                dui_p_2px,
                dui_p_4px,
                dui_p_8px,
                dui_p_0_5,
                dui_p_1,
                dui_p_1_5,
                dui_p_2,
                dui_p_2_5,
                dui_p_3,
                dui_p_3_5,
                dui_p_4,
                dui_p_5,
                dui_p_6,
                dui_p_7,
                dui_p_8,
                dui_p_9,
                dui_p_10,
                dui_p_11,
                dui_p_12,
                dui_p_14,
                dui_p_16,
                dui_p_20,
                dui_p_24,
                dui_p_28,
                dui_p_32,
                dui_p_36,
                dui_p_40,
                dui_p_44,
                dui_p_48,
                dui_p_52,
                dui_p_56,
                dui_p_60,
                dui_p_64,
                dui_p_72,
                dui_p_80,
                dui_p_96,

                dui_p_b_0,
                dui_p_b_px,
                dui_p_b_2px,
                dui_p_b_4px,
                dui_p_b_8px,
                dui_p_b_0_5,
                dui_p_b_1,
                dui_p_b_1_5,
                dui_p_b_2,
                dui_p_b_2_5,
                dui_p_b_3,
                dui_p_b_3_5,
                dui_p_b_4,
                dui_p_b_5,
                dui_p_b_6,
                dui_p_b_7,
                dui_p_b_8,
                dui_p_b_9,
                dui_p_b_10,
                dui_p_b_11,
                dui_p_b_12,
                dui_p_b_14,
                dui_p_b_16,
                dui_p_b_20,
                dui_p_b_24,
                dui_p_b_28,
                dui_p_b_32,
                dui_p_b_36,
                dui_p_b_40,
                dui_p_b_44,
                dui_p_b_48,
                dui_p_b_52,
                dui_p_b_56,
                dui_p_b_60,
                dui_p_b_64,
                dui_p_b_72,
                dui_p_b_80,
                dui_p_b_96,

                dui_p_l_0,
                dui_p_l_px,
                dui_p_l_2px,
                dui_p_l_4px,
                dui_p_l_8px,
                dui_p_l_0_5,
                dui_p_l_1,
                dui_p_l_1_5,
                dui_p_l_2,
                dui_p_l_2_5,
                dui_p_l_3,
                dui_p_l_3_5,
                dui_p_l_4,
                dui_p_l_5,
                dui_p_l_6,
                dui_p_l_7,
                dui_p_l_8,
                dui_p_l_9,
                dui_p_l_10,
                dui_p_l_11,
                dui_p_l_12,
                dui_p_l_14,
                dui_p_l_16,
                dui_p_l_20,
                dui_p_l_24,
                dui_p_l_28,
                dui_p_l_32,
                dui_p_l_36,
                dui_p_l_40,
                dui_p_l_44,
                dui_p_l_48,
                dui_p_l_52,
                dui_p_l_56,
                dui_p_l_60,
                dui_p_l_64,
                dui_p_l_72,
                dui_p_l_80,
                dui_p_l_96,

                dui_p_r_0,
                dui_p_r_px,
                dui_p_r_2px,
                dui_p_r_4px,
                dui_p_r_8px,
                dui_p_r_0_5,
                dui_p_r_1,
                dui_p_r_1_5,
                dui_p_r_2,
                dui_p_r_2_5,
                dui_p_r_3,
                dui_p_r_3_5,
                dui_p_r_4,
                dui_p_r_5,
                dui_p_r_6,
                dui_p_r_7,
                dui_p_r_8,
                dui_p_r_9,
                dui_p_r_10,
                dui_p_r_11,
                dui_p_r_12,
                dui_p_r_14,
                dui_p_r_16,
                dui_p_r_20,
                dui_p_r_24,
                dui_p_r_28,
                dui_p_r_32,
                dui_p_r_36,
                dui_p_r_40,
                dui_p_r_44,
                dui_p_r_48,
                dui_p_r_52,
                dui_p_r_56,
                dui_p_r_60,
                dui_p_r_64,
                dui_p_r_72,
                dui_p_r_80,
                dui_p_r_96,

                dui_p_t_0,
                dui_p_t_px,
                dui_p_t_2px,
                dui_p_t_4px,
                dui_p_t_8px,
                dui_p_t_0_5,
                dui_p_t_1,
                dui_p_t_1_5,
                dui_p_t_2,
                dui_p_t_2_5,
                dui_p_t_3,
                dui_p_t_3_5,
                dui_p_t_4,
                dui_p_t_5,
                dui_p_t_6,
                dui_p_t_7,
                dui_p_t_8,
                dui_p_t_9,
                dui_p_t_10,
                dui_p_t_11,
                dui_p_t_12,
                dui_p_t_14,
                dui_p_t_16,
                dui_p_t_20,
                dui_p_t_24,
                dui_p_t_28,
                dui_p_t_32,
                dui_p_t_36,
                dui_p_t_40,
                dui_p_t_44,
                dui_p_t_48,
                dui_p_t_52,
                dui_p_t_56,
                dui_p_t_60,
                dui_p_t_64,
                dui_p_t_72,
                dui_p_t_80,
                dui_p_t_96,

                dui_p_x_0,
                dui_p_x_px,
                dui_p_x_2px,
                dui_p_x_4px,
                dui_p_x_8px,
                dui_p_x_0_5,
                dui_p_x_1,
                dui_p_x_1_5,
                dui_p_x_2,
                dui_p_x_2_5,
                dui_p_x_3,
                dui_p_x_3_5,
                dui_p_x_4,
                dui_p_x_5,
                dui_p_x_6,
                dui_p_x_7,
                dui_p_x_8,
                dui_p_x_9,
                dui_p_x_10,
                dui_p_x_11,
                dui_p_x_12,
                dui_p_x_14,
                dui_p_x_16,
                dui_p_x_20,
                dui_p_x_24,
                dui_p_x_28,
                dui_p_x_32,
                dui_p_x_36,
                dui_p_x_40,
                dui_p_x_44,
                dui_p_x_48,
                dui_p_x_52,
                dui_p_x_56,
                dui_p_x_60,
                dui_p_x_64,
                dui_p_x_72,
                dui_p_x_80,
                dui_p_x_96,

                dui_p_y_0,
                dui_p_y_px,
                dui_p_y_2px,
                dui_p_y_4px,
                dui_p_y_8px,
                dui_p_y_0_5,
                dui_p_y_1,
                dui_p_y_1_5,
                dui_p_y_2,
                dui_p_y_2_5,
                dui_p_y_3,
                dui_p_y_3_5,
                dui_p_y_4,
                dui_p_y_5,
                dui_p_y_6,
                dui_p_y_7,
                dui_p_y_8,
                dui_p_y_9,
                dui_p_y_10,
                dui_p_y_11,
                dui_p_y_12,
                dui_p_y_14,
                dui_p_y_16,
                dui_p_y_20,
                dui_p_y_24,
                dui_p_y_28,
                dui_p_y_32,
                dui_p_y_36,
                dui_p_y_40,
                dui_p_y_44,
                dui_p_y_48,
                dui_p_y_52,
                dui_p_y_56,
                dui_p_y_60,
                dui_p_y_64,
                dui_p_y_72,
                dui_p_y_80,
                dui_p_y_96);

        element
                .appendChild(Card.create("PADDING CSS CLASSES")
                        .setCollapsible(true)
                        .appendChild(div().addCss(dui_flex, dui_gap_4, dui_flex_col)
                                .apply(self -> {
                                    heightClasses.forEach(cssClass -> {
                                        self
                                                .appendChild(span().textContent(cssClass.getCssClass()))
                                                .appendChild(div().addCss(dui_border, dui_border_solid, dui_border_accent, dui_bg_accent, cssClass)
                                                        .addCss(dui_w_fit, dui_h_fit)
                                                        .appendChild(div().addCss(dui_bg_white, dui_h_12, dui_w_12))
                                                );
                                    });
                                })
                        )

                );
    }

    @SampleMethod
    private void textStyles() {

//        element.appendChild(Card.create("TEXT STYLES", "Use ready classes to style your paragraphs.")
//                .appendChild(Row.create()
//                        .appendchild(Column.span2()
//                                .appendChild(p().appendChild(b().textContent("Normal")))
//                                .appendChild(p("Default text"))
//                                .appendChild(p("Text pink color").setColor(Color.PINK))
//                                .appendChild(p("Text cyan color").setColor(Color.CYAN))
//                                .appendChild(p("Text teal color").setColor(Color.TEAL))
//                                .appendChild(p("Text orange color").setColor(Color.ORANGE))
//                                .appendChild(p("Text blue grey color").setColor(Color.BLUE_GREY))
//                        )
//
//                        .appendchild(Column.span2()
//                                .appendChild(p().appendChild(b().textContent("Bold")))
//                                .appendChild(p("Default text").bold())
//                                .appendChild(p("Text pink color").bold().setColor(Color.PINK))
//                                .appendChild(p("Text cyan color").bold().setColor(Color.CYAN))
//                                .appendChild(p("Text teal color").bold().setColor(Color.TEAL))
//                                .appendChild(p("Text orange color").bold().setColor(Color.ORANGE))
//                                .appendChild(p("Text blue grey color").bold().setColor(Color.BLUE_GREY))
//                        )
//
//                        .appendchild(Column.span2()
//                                .appendChild(p().appendChild(b().textContent("Italic")))
//                                .appendChild(p("Default text").italic())
//                                .appendChild(p("Text pink color").italic().setColor(Color.PINK))
//                                .appendChild(p("Text cyan color").italic().setColor(Color.CYAN))
//                                .appendChild(p("Text teal color").italic().setColor(Color.TEAL))
//                                .appendChild(p("Text orange color").italic().setColor(Color.ORANGE))
//                                .appendChild(p("Text blue grey color").italic().setColor(Color.BLUE_GREY))
//                        )
//
//                        .appendchild(Column.span2()
//                                .appendChild(p().appendChild(b().textContent("Underline")))
//                                .appendChild(p("Default text").underLine())
//                                .appendChild(p("Text pink color").underLine().setColor(Color.PINK))
//                                .appendChild(p("Text cyan color").underLine().setColor(Color.CYAN))
//                                .appendChild(p("Text teal color").underLine().setColor(Color.TEAL))
//                                .appendChild(p("Text orange color").underLine().setColor(Color.ORANGE))
//                                .appendChild(p("Text blue grey color").underLine().setColor(Color.BLUE_GREY))
//                        )
//
//                        .appendchild(Column.span2()
//                                .appendChild(p().appendChild(b().textContent("Line through")))
//                                .appendChild(p("Default text").lineThrough())
//                                .appendChild(p("Text pink color").lineThrough().setColor(Color.PINK))
//                                .appendChild(p("Text cyan color").lineThrough().setColor(Color.CYAN))
//                                .appendChild(p("Text teal color").lineThrough().setColor(Color.TEAL))
//                                .appendChild(p("Text orange color").lineThrough().setColor(Color.ORANGE))
//                                .appendChild(p("Text blue grey color").lineThrough().setColor(Color.BLUE_GREY))
//                        )
//
//                        .appendchild(Column.span2()
//                                .appendChild(p().appendChild(b().textContent("Over line")))
//                                .appendChild(p("Default text").overLine())
//                                .appendChild(p("Text pink color").overLine().setColor(Color.PINK))
//                                .appendChild(p("Text cyan color").overLine().setColor(Color.CYAN))
//                                .appendChild(p("Text teal color").overLine().setColor(Color.TEAL))
//                                .appendChild(p("Text orange color").overLine().setColor(Color.ORANGE))
//                                .appendChild(p("Text blue grey color").overLine().setColor(Color.BLUE_GREY))
//                        )
//                        )
//                );


    }

    @SampleMethod
    private void fontSize() {

//        element.appendChild(Card.create("FONT SIZES", "Use ready classes to change text font size.")
//                .appendChild(Row.create()
//                        .appendchild(Column.span2().appendChild(div().css(Styles.font_6).textContent("font-6")))
//                        .appendchild(Column.span2().appendChild(div().css(Styles.font_10).textContent("font-10")))
//                        .appendchild(Column.span2().appendChild(div().css(Styles.font_12).textContent("font-12")))
//                        .appendchild(Column.span2().appendChild(div().css(Styles.font_15).textContent("font-15")))
//                        .appendchild(Column.span2().appendChild(div().css(Styles.font_20).textContent("font-20")))
//                        .appendchild(Column.span2().appendChild(div().css(Styles.font_24).textContent("font-24")))
//                        )
//                .appendChild(Row.create()
//                        .appendchild(Column.span2().appendChild(div().css(Styles.font_32).textContent("font-32")))
//                        .appendchild(Column.span2().appendChild(div().css(Styles.font_40).textContent("font-40")))
//                        .appendchild(Column.span2().appendChild(div().css(Styles.font_42).textContent("font-42")))
//                        .appendchild(Column.span2().appendChild(div().css(Styles.font_45).textContent("font-45")))
//                        .appendchild(Column.span2().appendChild(div().css(Styles.font_48).textContent("font-48")))
//                        .appendchild(Column.span2().appendChild(div().css(Styles.font_50).textContent("font-50")))
//                        )
//                );


    }

    @SampleMethod
    private void textAligns() {

//        element.appendChild(Card.create("TEXT ALIGNS", "You can use ready classes to change text alignment.")
//                .appendChild(Row.create()
//                        .appendchild(Column.span3()
//                                .appendChild(p().appendChild(b().textContent("Align left")).alignLeft())
//                                .appendChild(div().css(Styles.align_left).textContent(SAMPLE_TEXT))
//                        )
//                        .appendchild(Column.span3()
//                                .appendChild(p().appendChild(b().textContent("Align center")).alignCenter())
//                                .appendChild(div().css(Styles.align_center).textContent(SAMPLE_TEXT))
//                        )
//                        .appendchild(Column.span3()
//                                .appendChild(p().appendChild(b().textContent("Align right")).alignRight())
//                                .appendChild(div().css(Styles.align_right).textContent(SAMPLE_TEXT))
//                        )
//                        .appendchild(Column.span3()
//                                .appendChild(p().appendChild(b().textContent("Align justify")).alignJustify())
//                                .appendChild(div().css(Styles.align_justify).textContent(SAMPLE_TEXT))
//                        )
//                        )
//                );


    }

    @SampleMethod
    private void marginAndPaddingSpaces() {

//        element.appendChild(Card.create("MARGIN & PADDING SPACES", "Use ready classes to apply margins and padding to your elements.")
//                .appendChild(p().appendChild(b().textContent("Margins")))
//                .appendChild(Row.create()
//                        .appendchild(Column.span4()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
//                                .appendChild(TextNode.of("argin "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("T"))
//                                .appendChild(TextNode.of("op "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("10"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".m-t-10"))
//                        )
//                        .appendchild(Column.span4()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
//                                .appendChild(TextNode.of("argin "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("T"))
//                                .appendChild(TextNode.of("op "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".m-t-0"))
//                        )
//                        .appendchild(Column.span4()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
//                                .appendChild(TextNode.of("argin "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("T"))
//                                .appendChild(TextNode.of("op "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("-10"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".m-t--10"))
//                        )
//                        )
//                .appendChild(Row.create()
//                        .appendchild(Column.span4()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
//                                .appendChild(TextNode.of("argin "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("L"))
//                                .appendChild(TextNode.of("eft "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("35"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".m-l-35"))
//                        )
//                        .appendchild(Column.span4()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
//                                .appendChild(TextNode.of("argin "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("L"))
//                                .appendChild(TextNode.of("eft "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".m-l-0"))
//                        )
//                        .appendchild(Column.span4()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
//                                .appendChild(TextNode.of("argin "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("L"))
//                                .appendChild(TextNode.of("eft "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("-35"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".m-l--35"))
//                        )
//                        )
//                .appendChild(Row.create()
//                        .appendchild(Column.span4()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
//                                .appendChild(TextNode.of("argin "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("B"))
//                                .appendChild(TextNode.of("ottom "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("15"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".m-b-15"))
//                        )
//                        .appendchild(Column.span4()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
//                                .appendChild(TextNode.of("argin "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("B"))
//                                .appendChild(TextNode.of("ottom "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".m-b-0"))
//                        )
//                        .appendchild(Column.span4()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
//                                .appendChild(TextNode.of("argin "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("B"))
//                                .appendChild(TextNode.of("ottom "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("-20"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".m-l--20"))
//                        )
//                        )
//                .appendChild(Row.create()
//                        .appendchild(Column.span4()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
//                                .appendChild(TextNode.of("argin "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("R"))
//                                .appendChild(TextNode.of("ight "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("30"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".m-r-30"))
//                        )
//                        .appendchild(Column.span4()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
//                                .appendChild(TextNode.of("argin "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("R"))
//                                .appendChild(TextNode.of("ight "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".m-r-0"))
//                        )
//                        .appendchild(Column.span4()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
//                                .appendChild(TextNode.of("argin "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("R"))
//                                .appendChild(TextNode.of("ight "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("-30"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".m-r--30"))
//                        )
//                        )
//                .appendChild(Row.create()
//                        .appendchild(Column.span4()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("ALL M"))
//                                .appendChild(TextNode.of("argin "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".margin-0"))
//                        ))
//                .appendChild(p().appendChild(b().textContent("Paddings")))
//                .appendChild(Row.create()
//                        .appendchild(Column.span3()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P"))
//                                .appendChild(TextNode.of("adding "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("T"))
//                                .appendChild(TextNode.of("op "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("10"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".p-t-10"))
//                        )
//                        .appendchild(Column.span3()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P"))
//                                .appendChild(TextNode.of("adding "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("T"))
//                                .appendChild(TextNode.of("op "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".p-t-0"))
//                        )
//                        .appendchild(Column.span3()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P"))
//                                .appendChild(TextNode.of("adding "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("L"))
//                                .appendChild(TextNode.of("eft "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("35"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".p-l-35"))
//                        )
//                        .appendchild(Column.span3()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P"))
//                                .appendChild(TextNode.of("adding "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("L"))
//                                .appendChild(TextNode.of("eft "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".p-l-0"))
//                        )
//                        )
//                .appendChild(Row.create()
//                        .appendchild(Column.span3()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P"))
//                                .appendChild(TextNode.of("adding "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("B"))
//                                .appendChild(TextNode.of("ottom "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("15"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".p-b-15"))
//                        )
//                        .appendchild(Column.span3()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P"))
//                                .appendChild(TextNode.of("adding "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("B"))
//                                .appendChild(TextNode.of("ottom "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".p-b-0"))
//                        )
//                        .appendchild(Column.span3()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P"))
//                                .appendChild(TextNode.of("adding "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("R"))
//                                .appendChild(TextNode.of("ight "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("30"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".p-r-30"))
//                        )
//                        .appendchild(Column.span3()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P"))
//                                .appendChild(TextNode.of("adding "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("R"))
//                                .appendChild(TextNode.of("ight "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".p-r-0"))
//                        )
//                        )
//                    .appendChild(Row.create()
//                        .appendchild(Column.span3()
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("ALL P"))
//                                .appendChild(TextNode.of("adding "))
//                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
//                                .appendChild(TextNode.of("px → "))
//                                .appendChild(code().textContent(".padding-0"))
//                        )
//                        )
//                );
    }
}