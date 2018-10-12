package org.dominokit.domino.profile.client.views.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.profile.client.presenters.ProfilePresenter;
import org.dominokit.domino.profile.client.views.ProfileView;
import org.dominokit.domino.ui.button.DropdownButton;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.jboss.gwt.elemento.core.Elements;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.small;

@UiView(presentable = ProfilePresenter.class)
public class ProfileViewImpl implements ProfileView {

    private final Card profile = Card.createProfile("Vegegoku", "vegegoku@bo3.com");

    public ProfileViewImpl() {
    }

    @Override
    public void setLayout(IsLayout layout) {
        profile.style().add("authors-card")
                .add("bg-theme");
        profile.setHeaderBackground(Color.TRANSPARENT);
        profile.setBodyBackground(Color.TRANSPARENT);
        profile.getHeader().style().remove("bg-theme");
        profile.getBody().style().remove("bg-theme");
        profile.getHeaderTitle().setAttribute("id", "demo-profile");
        HTMLElement leftPanel = Js.cast(layout.getLeftPanel().get());
        if (leftPanel.childElementCount > 0)
            leftPanel.insertBefore(profile.asElement(), leftPanel.firstChild);
        else
            leftPanel.appendChild(profile.asElement());

        profile.appendChild(Elements.img(GWT.getModuleBaseURL() + "/images/user.png").style("border-radius:50%;"));
        DropdownButton dropdownButton = DropdownButton.create(Icons.ALL.more_vert())
                .linkify()
                .setBackground(Color.TRANSPARENT)
                .hideCaret()
                .appendChild(DropdownAction.create("Action 1").addSelectionHandler(value -> Notification.createInfo(value).show()))
                .appendChild(DropdownAction.create("Action 2").addSelectionHandler(value -> Notification.createInfo(value).show()));

        profile.getHeaderBar().appendChild(dropdownButton
                .asElement());
        Style.of(profile).setHeight("186px");
        profile.asElement().appendChild(div().css("bg-authors").asElement());

        try {
            CodeResource.INSTANCE.build().getText(new ResourceCallback<TextResource>() {
                @Override
                public void onError(ResourceException e) {
                    DomGlobal.console.error("failed ", e);
                }

                @Override
                public void onSuccess(TextResource resource) {
                    profile.getHeaderTitle().appendChild(small().textContent(resource.getText())
                            .asElement());
                    DomGlobal.console.info(resource.getText());
                }
            });
        } catch (Exception e) {
            DomGlobal.console.error("Failed to load build time : ", e);
        }
    }
}