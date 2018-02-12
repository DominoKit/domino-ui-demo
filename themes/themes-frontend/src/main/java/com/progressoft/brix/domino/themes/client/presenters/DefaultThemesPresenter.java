package com.progressoft.brix.domino.themes.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.layout.shared.extension.LayoutContext;
import com.progressoft.brix.domino.themes.client.views.ThemesView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class DefaultThemesPresenter extends BaseClientPresenter<ThemesView> implements ThemesPresenter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultThemesPresenter.class);

    @Override
    public void initView(ThemesView view) {
        view.registerTheme("RED");
        view.registerTheme("PINK");
        view.registerTheme("PURPLE");
        view.registerTheme("DEEP_PURPLE");
        view.registerTheme("INDIGO", true);
        view.registerTheme("BLUE");
        view.registerTheme("LIGHT_BLUE");
        view.registerTheme("CYAN");
        view.registerTheme("TEAL");
        view.registerTheme("GREEN");
        view.registerTheme("LIGHT_GREEN");
        view.registerTheme("LIME");
        view.registerTheme("YELLOW");
        view.registerTheme("AMBER");
        view.registerTheme("ORANGE");
        view.registerTheme("DEEP_ORANGE");
        view.registerTheme("BROWN");
        view.registerTheme("GREY");
        view.registerTheme("BLUE_GREY");
        view.registerTheme("BLACK");
    }

    @Override
    public void contributeToLayoutModule(LayoutContext context) {
        view.setLayout(context.getLayout());
    }
}