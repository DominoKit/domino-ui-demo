package org.dominokit.domino.profile.client.views.ui;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.profile.client.presenters.ProfilePresenter;
import org.dominokit.domino.profile.client.views.ProfileView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import jsinterop.base.Js;
import org.jboss.gwt.elemento.core.Elements;


@UiView(presentable = ProfilePresenter.class)
public class ProfileViewImpl implements ProfileView {

    private final Card profile=Card.createProfile("Vegegoku", "vegegoku@bo3.com");

    public ProfileViewImpl() {
    }

    @Override
    public void setLayout(IsLayout layout) {
        HTMLElement leftPanel= Js.cast(layout.getLeftPanel().get());
        if(leftPanel.childElementCount>0)
            leftPanel.insertBefore(profile.asElement(), leftPanel.firstChild);
        else
            leftPanel.appendChild(profile.asElement());

        profile.getBody().appendChild(Elements.img("static/images/user.png").style("border-radius:50%;").asElement());
        profile.getHeaderBar().appendChild(createIcon(Icons.ALL.more_vert()));
        profile.asElement().style.height= CSSProperties.HeightUnionType.of(300);
    }

    private HTMLLIElement createIcon(Icon icon) {
        return Elements.li().add(
                Elements.a().add(icon.asElement()))
                .asElement();
    }
}