package com.progressoft.brix.domino.themes.client.ui.views;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.layout.shared.extension.IsLayout;
import com.progressoft.brix.domino.themes.client.presenters.ThemesPresenter;
import com.progressoft.brix.domino.themes.client.views.ThemesView;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.icons.Icon;
import com.progressoft.brix.domino.ui.icons.Icons;
import com.progressoft.brix.domino.ui.themes.Theme;
import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import jsinterop.base.Js;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

@UiView(presentable = ThemesPresenter.class)
public class DefaultThemesView implements ThemesView {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultThemesView.class);

    private ThemesPanel themesPanel = ThemesPanel.create();

    private HTMLLIElement activeTheme;
    private Map<String, HTMLLIElement> themesElements=new HashMap<>();
    private Card card=Card.create("Themes", "Select theme to apply.");
    private ThemeAppliedHandler themeAppliedHandler;

    public DefaultThemesView() {

    }

    @Override
    public void setLayout(final IsLayout layout) {

        HTMLLIElement hideElement = makeIcon(Icons.HARDWARE_ICONS.keyboard_tab());
        hideElement.addEventListener("click", e->{
            if(nonNull(label()))
                layout.hideRightPanel();
        });
        card.getHeaderBar().appendChild(hideElement);
        card.asElement().style.marginBottom= CSSProperties.MarginBottomUnionType.of(0);
        card.getBody().style.padding= CSSProperties.PaddingUnionType.of(0);
        card.getBody().appendChild(themesPanel.asElement());
        HTMLElement actionItem = Js.cast(layout.addActionItem("style").get());
        actionItem.addEventListener("click", e->{
            layout.setRightPanelContent(themesContent());
            layout.showRightPanel();
        });
    }

    private HTMLLIElement makeIcon(Icon icon) {
        return li().add(
                a().add(icon.asElement()))
                .asElement();
    }

    @Override
    public Content themesContent() {
        return (Content<HTMLDivElement>) card::asElement;
    }

    @Override
    public void registerTheme(String theme) {
        registerTheme(theme, false);
    }

    @Override
    public void registerTheme(String theme, boolean active) {
        addTheme(Theme.of(theme), active);
    }

    private HTMLLIElement addTheme(Theme theme, boolean active) {

        HTMLLIElement themeElement = li().add(div().css(theme.getThemeStyle().replace("theme-",""))).add(span().textContent(theme.getName())).asElement();
        themesElements.put(theme.getKey(), themeElement);
        if (active) {
            themeElement.classList.add("active");
            activeTheme = themeElement;
            applyTheme(theme);
        }
        themesPanel.themesContainer.appendChild(themeElement);
        themeElement.addEventListener("click", evt -> {
            applyTheme(theme);
        });

        return themeElement;
    }

    private void applyTheme(Theme theme) {
        if (nonNull(activeTheme))
            activeTheme.classList.remove("active");
        HTMLLIElement themeElement = themesElements.get(theme.getKey());
        this.activeTheme = themeElement;
        themeElement.classList.add("active");
        theme.apply();
        if(nonNull(themeAppliedHandler)){
            themeAppliedHandler.onThemeApplied(theme.getKey());
        }
    }

    @Override
    public void applyTheme(String theme) {
        if(nonNull(Theme.of(theme)))
            applyTheme(Theme.of(theme));
    }

    @Override
    public void onThemeApplied(ThemeAppliedHandler themeAppliedHandler) {
        this.themeAppliedHandler=themeAppliedHandler;
    }
}