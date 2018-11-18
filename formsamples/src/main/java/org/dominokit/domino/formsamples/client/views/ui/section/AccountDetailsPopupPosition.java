package org.dominokit.domino.formsamples.client.views.ui.section;

import elemental2.dom.ClientRect;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.shared.model.CorporateAccount;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.popover.PopupPosition;

import static elemental2.dom.DomGlobal.window;

public class AccountDetailsPopupPosition implements PopupPosition {

    private final Select<CorporateAccount> accountSelect;

    public AccountDetailsPopupPosition(Select<CorporateAccount> accountSelect) {
        this.accountSelect = accountSelect;
    }

    @Override
    public void position(HTMLElement tooltip, HTMLElement target) {
        ClientRect targetRect = accountSelect.asElement().getBoundingClientRect();
        ClientRect tooltipRect = tooltip.getBoundingClientRect();
        tooltip.style.setProperty("top", ((targetRect.top + window.scrollY) - tooltipRect.height) + "px");
        tooltip.style.setProperty("left", targetRect.left + window.scrollX + ((targetRect.width - tooltipRect.width) / 2) + "px");
    }

    @Override
    public String getDirectionClass() {
        return "top";
    }
}
