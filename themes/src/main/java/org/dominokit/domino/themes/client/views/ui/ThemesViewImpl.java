package org.dominokit.domino.themes.client.views.ui;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.themes.client.presenters.ThemesPresenter;
import org.dominokit.domino.themes.client.views.ThemesView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.themes.Theme;
import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import jsinterop.base.Js;
import org.jboss.gwt.elemento.core.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

@UiView(presentable = ThemesPresenter.class)
public class ThemesViewImpl implements ThemesView {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThemesViewImpl.class);

    private ThemesPanel themesPanel = ThemesPanel.create();

    private HTMLLIElement activeTheme;
    private Map<String, HTMLLIElement> themesElements=new HashMap<>();
    private Card card=Card.create("Themes", "Select theme to apply.");
    private ThemeAppliedHandler themeAppliedHandler;

    public ThemesViewImpl() {

    }

    @Override
    public void setLayout(final IsLayout layout) {

        HTMLLIElement hideElement = makeIcon(Icons.HARDWARE_ICONS.keyboard_tab());
        hideElement.addEventListener("click", e->{
            if(nonNull(Elements.label()))
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
        return Elements.li().add(
                Elements.a().add(icon.asElement()))
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

        HTMLLIElement themeElement = Elements.li().add(Elements.div().css(theme.getThemeStyle().replace("theme-",""))).add(Elements.span().textContent(theme.getName())).asElement();
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