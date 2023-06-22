package org.dominokit.domino.themes.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.presenter.ViewablePresenter;
import org.dominokit.domino.history.HistoryToken;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.layout.shared.extension.LayoutStoreImpl;
import org.dominokit.domino.themes.client.views.ThemesView;

import java.util.List;

import static java.util.Objects.nonNull;

@PresenterProxy
@AutoRoute(routeOnce = true)
@Singleton
@AutoReveal
@Slot(IsLayout.Slots.RIGHT_PANEL)
@DependsOn(@EventsGroup(LayoutEvent.class))
public class ThemesProxy extends ViewablePresenter<ThemesView> implements ThemesView.ThemesUiHandlers {

    @QueryParameter("theme")
    List<String> theme;

    private IsLayout layout;

    @OnBeforeReveal
    public void getLayout() {


    }

    @OnReveal
    public void initView() {

    }

    @Override
    public void onThemeApplied(String theme) {

    }
}