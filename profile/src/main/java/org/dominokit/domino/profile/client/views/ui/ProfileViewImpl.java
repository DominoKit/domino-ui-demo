package org.dominokit.domino.profile.client.views.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.profile.client.presenters.ProfileProxy;
import org.dominokit.domino.profile.client.views.ProfileView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.cards.HeaderAction;
import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.dominokit.domino.ui.dropdown.DropDownPosition;
import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.view.BaseElementView;
import org.jboss.gwt.elemento.core.Elements;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.small;

@UiView(presentable = ProfileProxy.class)
public class ProfileViewImpl extends BaseElementView<HTMLDivElement> implements ProfileView {

    private Card profile;

    @Override
    protected HTMLDivElement init() {
        profile = Card.createProfile("Vegegoku", "vegegoku@bo3.com");

        profile.style()
                .add("profile-card")
                .add("classy-card")
                .add("bg-theme");
        profile.setHeaderBackground(Color.TRANSPARENT);
        profile.setBodyBackground(Color.TRANSPARENT);
        profile.getHeader().style().remove("bg-theme");
        profile.setBodyPadding("10px");
        profile.getBody().styler(style -> style.remove("bg-theme"));
        profile.getHeaderTitle().setAttribute("id", "demo-profile");


        profile.appendChild(Elements.img(GWT.getModuleBaseURL() + "/images/user.png").style("border-radius:50%;"));
        HeaderAction headerAction=HeaderAction.create(Icons.ALL.more_vert()
                .clickable());
        DropDownMenu dropDownMenu=DropDownMenu.create(headerAction)
                .setPosition(DropDownPosition.BOTTOM)
                .addAction(DropdownAction.create("Action 1").addSelectionHandler(value -> Notification.createInfo(value).show()))
                .addAction(DropdownAction.create("Action 2").addSelectionHandler(value -> Notification.createInfo(value).show()));


        headerAction.addClickListener(evt -> {
            dropDownMenu.open();
            evt.stopPropagation();
        });

        profile.addHeaderAction(headerAction);
        Style.of(profile).setHeight("186px");
        profile.element().appendChild(div().css("bg-classy").element());

        try {
            CodeResource.INSTANCE.build().getText(new ResourceCallback<TextResource>() {
                @Override
                public void onError(ResourceException e) {
                    DomGlobal.console.error("failed ", e);
                }

                @Override
                public void onSuccess(TextResource resource) {
                    profile.getHeaderTitle().appendChild(small().textContent(resource.getText())
                            .element());
                    DomGlobal.console.info(resource.getText());
                }
            });
        } catch (Exception e) {
            DomGlobal.console.error("Failed to load build time : ", e);
        }

        return profile.element();
    }
}