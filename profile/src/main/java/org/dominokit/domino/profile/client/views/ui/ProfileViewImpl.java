package org.dominokit.domino.profile.client.views.ui;

import com.google.gwt.core.client.GWT;
import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.profile.client.presenters.ProfilePresenter;
import org.dominokit.domino.profile.client.views.ProfileView;
import org.dominokit.domino.ui.button.DropdownAction;
import org.dominokit.domino.ui.button.DropdownButton;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.Color;
import org.jboss.gwt.elemento.core.Elements;


@UiView(presentable = ProfilePresenter.class)
public class ProfileViewImpl implements ProfileView {

    private final Card profile = Card.createProfile("Vegegoku", "vegegoku@bo3.com");

    public ProfileViewImpl() {
    }

    @Override
    public void setLayout(IsLayout layout) {
        HTMLElement leftPanel = Js.cast(layout.getLeftPanel().get());
        if (leftPanel.childElementCount > 0)
            leftPanel.insertBefore(profile.asElement(), leftPanel.firstChild);
        else
            leftPanel.appendChild(profile.asElement());

        profile.getBody().appendChild(Elements.img(GWT.getModuleBaseURL() + "/images/user.png").style("border-radius:50%;").asElement());
        DropdownButton dropdownButton = DropdownButton.create(Icons.ALL.more_vert())
                .linkify()
                .setBackground(Color.TRANSPARENT)
                .hideCaret()
                .addAction(DropdownAction.create("Action 1").addSelectionHandler(() -> Notification.createInfo("Action 1").show()))
                .addAction(DropdownAction.create("Action 2").addSelectionHandler(() -> Notification.createInfo("Action 2").show()));

        profile.getHeaderBar().appendChild(dropdownButton
                .asElement());
        profile.asElement().style.height = CSSProperties.HeightUnionType.of(300);
    }
}