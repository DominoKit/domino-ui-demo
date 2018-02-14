package com.progressoft.brix.domino.themes.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.api.shared.history.DominoHistory;
import com.progressoft.brix.domino.api.shared.history.HistoryToken;
import com.progressoft.brix.domino.api.shared.history.TokenFilter;
import com.progressoft.brix.domino.layout.shared.extension.LayoutContext;
import com.progressoft.brix.domino.themes.client.views.ThemesView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Objects.nonNull;

@Presenter
public class DefaultThemesPresenter extends BaseClientPresenter<ThemesView> implements ThemesPresenter , ThemesView.ThemeAppliedHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultThemesPresenter.class);

    @Override
    public void initView(ThemesView view) {
        view.onThemeApplied(this);

        view.registerTheme("red");
        view.registerTheme("pink");
        view.registerTheme("purple");
        view.registerTheme("deep_purple");
        view.registerTheme("indigo", !history().currentToken().hasQueryParameter("theme"));
        view.registerTheme("blue");
        view.registerTheme("light_blue");
        view.registerTheme("cyan");
        view.registerTheme("teal");
        view.registerTheme("green");
        view.registerTheme("light_green");
        view.registerTheme("lime");
        view.registerTheme("yellow");
        view.registerTheme("amber");
        view.registerTheme("orange");
        view.registerTheme("deep_orange");
        view.registerTheme("brown");
        view.registerTheme("grey");
        view.registerTheme("blue_grey");
        view.registerTheme("black");

        history()
                .listen(TokenFilter.contains("theme="), this::applyTheme)
                .onDirectUrl(this::applyTheme);
    }

    private void applyTheme(DominoHistory.State state) {
        String theme = state.token().parameterValue("theme");
        if(nonNull(theme))
            view.applyTheme(theme);
    }

    @Override
    public void contributeToLayoutModule(LayoutContext context) {
        view.setLayout(context.getLayout());
    }

    @Override
    public void onThemeApplied(String theme) {
        HistoryToken token=history().currentToken();
        if(history().currentToken().hasQueryParameter("theme"))
            token.queryParameters().put("theme", theme);
        else
            token.appendParameter("theme", theme);

        history().pushState(token.value());
    }
}