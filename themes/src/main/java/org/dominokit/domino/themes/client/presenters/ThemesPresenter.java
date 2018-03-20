package org.dominokit.domino.themes.client.presenters;

import org.dominokit.domino.api.client.annotations.InjectContext;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.BaseClientPresenter;
import org.dominokit.domino.api.shared.history.DominoHistory;
import org.dominokit.domino.api.shared.history.HistoryToken;
import org.dominokit.domino.api.shared.history.TokenFilter;
import org.dominokit.domino.layout.shared.extension.LayoutContext;
import org.dominokit.domino.layout.shared.extension.LayoutExtensionPoint;
import org.dominokit.domino.themes.client.views.ThemesView;
import org.dominokit.domino.themes.client.views.ThemesView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Objects.nonNull;

@Presenter
public class ThemesPresenter extends BaseClientPresenter<ThemesView> implements ThemesView.ThemeAppliedHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(ThemesPresenter.class);

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

    @InjectContext(extensionPoint=LayoutExtensionPoint.class)
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