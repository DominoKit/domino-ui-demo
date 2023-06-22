package org.dominokit.domino.profile.client.views.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.profile.client.presenters.ProfileProxy;
import org.dominokit.domino.profile.client.views.ProfileView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.icons.LabeledIcon;
import org.dominokit.domino.ui.style.Calc;
import org.dominokit.domino.ui.utils.Unit;
import org.dominokit.domino.view.BaseElementView;


@UiView(presentable = ProfileProxy.class)
public class ProfileViewImpl extends BaseElementView<HTMLDivElement> implements ProfileView {

    private DivElement root;

    @Override
    protected HTMLDivElement init() {

        root = div()
                .addCss(dui_flex, dui_flex_col, dui_order_10, dui_overflow_visible)
                .appendChild(div()
                        .addCss(dui_bg_accent_d_1, dui_h_16, dui_relative)
                        .appendChild(img(GWT.getModuleBaseURL() + "/images/logo/128.png")
                                .addCss(dui_bg_yellow_d_1,
                                        dui_border_4,
                                        dui_border_accent_l_4,
                                        dui_border_solid,
                                        dui_rounded_full,
                                        dui_absolute,
                                        dui_w_24,
                                        dui_h_24,
                                        dui_top_4)
                                .setLeft(Calc.sub(Unit.percent.of(50), Unit.em.of(3)))
                        )
                )
                .appendChild(div()
                        .addCss(dui_bg_accent_l_4, dui_h_48, dui_flex, dui_flex_col, dui_font_size_3_5, dui_p_14)
                        .apply(div-> {
                            try {
                                CodeResource.INSTANCE.build().getText(new ResourceCallback<TextResource>() {
                                    @Override
                                    public void onError(ResourceException e) {
                                        DomGlobal.console.error("failed ", e);
                                    }

                                    @Override
                                    public void onSuccess(TextResource resource) {
                                        String[] buildInfo = resource.getText().split(",");
                                        div
                                                .appendChild(div().addCss(dui_flex, dui_flex_col, dui_p_l_4)
                                                        .appendChild(LabeledIcon.create(Icons.email().addCss(dui_fg_accent_d_3), "info@dominokit.com"))
                                                        .appendChild(LabeledIcon.create(Icons.clock_outline().addCss(dui_fg_accent_d_3), buildInfo[0]))
                                                        .appendChild(LabeledIcon.create(Icons.source_branch().addCss(dui_fg_accent_d_3), buildInfo[1]))
                                                )
                                                .appendChild(div()
                                                        .addCss(dui_flex,
                                                                dui_justify_center,
                                                                dui_gap_4,
                                                                dui_font_size_8,
                                                                dui_fg_accent_d_3,
                                                                dui_p_t_6)
                                                        .appendChild(Icons.github().clickable())
                                                        .appendChild(Icons.patreon().clickable())
                                                        .appendChild(Icons.twitter().clickable())
                                                        .appendChild(Icons.linkedin().clickable())
                                                )
                                        ;
                                    }
                                });
                            } catch (Exception e) {
                                DomGlobal.console.error("Failed to load build time : ", e);
                            }
                        })

                );

        return root.element();
    }
}