package org.dominokit.domino.themes.client.views.ui;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.themes.client.presenters.ThemesProxy;
import org.dominokit.domino.themes.client.views.ThemesView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.themes.Theme;
import org.dominokit.domino.view.BaseElementView;
import org.jboss.gwt.elemento.core.Elements;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

@UiView(presentable = ThemesProxy.class)
public class ThemesViewImpl extends BaseElementView<HTMLDivElement> implements ThemesView {

    private ThemesPanel themesPanel = ThemesPanel.create();

    private HTMLLIElement activeTheme;
    private Map<String, HTMLLIElement> themesElements = new HashMap<>();
    private Card card;
    private ThemesUiHandlers uiHandlers;

    @Override
    protected void init(HTMLDivElement root) {
        card.addHeaderAction(Icons.HARDWARE_ICONS.keyboard_tab(), evt -> uiHandlers.onHideThemes());
        card.style().setMarginBottom("0px");
        card.fitContent();
        card.appendChild(themesPanel);
    }

    @Override
    public HTMLDivElement createRoot() {
        card = Card.create("Themes", "Select theme to apply.");
        return card.element();
    }

    @Override
    public void setUiHandlers(ThemesUiHandlers uiHandlers) {
        this.uiHandlers = uiHandlers;
    }

    @Override
    public void registerTheme(String theme) {
        registerTheme(theme, false);
    }

    @Override
    public void registerTheme(String theme, boolean active) {
        addTheme(of(theme), active);
    }

    private HTMLLIElement addTheme(Theme theme, boolean active) {

        HTMLLIElement themeElement = Elements.li().add(Elements.div().css(theme.getThemeStyle().replace("theme-", ""))).add(Elements.span().textContent(theme.getName())).element();
        themesElements.put(theme.getName(), themeElement);
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
        HTMLLIElement themeElement = themesElements.get(theme.getName());
        this.activeTheme = themeElement;
        themeElement.classList.add("active");
        theme.apply();
        uiHandlers.onThemeApplied(theme.getName());
    }

    @Override
    public void applyTheme(String theme) {
        if (nonNull(of(theme)))
            applyTheme(of(theme));
    }


    private static Theme of(String themeKey) {
        switch (themeKey) {
            case "red":
                return ColorScheme.RED.theme();

            case "pink":
                return ColorScheme.PINK.theme();

            case "purple":
                return ColorScheme.PURPLE.theme();

            case "deep_purple":
                return ColorScheme.DEEP_PURPLE.theme();

            case "indigo":
                return ColorScheme.INDIGO.theme();

            case "blue":
                return ColorScheme.BLUE.theme();

            case "light_blue":
                return ColorScheme.LIGHT_BLUE.theme();

            case "cyan":
                return ColorScheme.CYAN.theme();

            case "teal":
                return ColorScheme.TEAL.theme();

            case "green":
                return ColorScheme.GREEN.theme();

            case "light_green":
                return ColorScheme.LIGHT_GREEN.theme();

            case "lime":
                return ColorScheme.LIME.theme();

            case "yellow":
                return ColorScheme.YELLOW.theme();

            case "amber":
                return ColorScheme.AMBER.theme();

            case "orange":
                return ColorScheme.ORANGE.theme();

            case "deep_orange":
                return ColorScheme.DEEP_ORANGE.theme();

            case "brown":
                return ColorScheme.BROWN.theme();

            case "grey":
                return ColorScheme.GREY.theme();

            case "blue_grey":
                return ColorScheme.BLUE_GREY.theme();

            case "black":
                return ColorScheme.BLACK.theme();
            default:
                return Theme.currentTheme;
        }
    }
}