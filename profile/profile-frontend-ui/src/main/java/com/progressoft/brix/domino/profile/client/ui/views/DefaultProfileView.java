package com.progressoft.brix.domino.profile.client.ui.views;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.layout.shared.extension.IsLayout;
import com.progressoft.brix.domino.profile.client.presenters.ProfilePresenter;
import com.progressoft.brix.domino.profile.client.views.ProfileView;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.icons.Icon;
import com.progressoft.brix.domino.ui.icons.Icons;
import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import jsinterop.base.Js;

import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.img;
import static org.jboss.gwt.elemento.core.Elements.li;


@UiView(presentable = ProfilePresenter.class)
public class DefaultProfileView implements ProfileView{

    private final Card profile=Card.createProfile("Vegegoku", "vegegoku@bo3.com");

    public DefaultProfileView() {
    }

    @Override
    public void setLayout(IsLayout layout) {
        HTMLElement leftPanel= Js.cast(layout.getLeftPanel().get());
        if(leftPanel.childElementCount>0)
            leftPanel.insertBefore(profile.asElement(), leftPanel.firstChild);
        else
            leftPanel.appendChild(profile.asElement());

        profile.getBody().appendChild(img("/static/images/user.png").asElement());
        profile.getHeaderBar().appendChild(createIcon(Icons.ALL.more_vert()));
        profile.asElement().style.height= CSSProperties.HeightUnionType.of(300);
    }

    private HTMLLIElement createIcon(Icon icon) {
        return li().add(
                a().attr("href", "javascript:void(0);")
                        .add(icon.asElement()))
                .asElement();
    }
}