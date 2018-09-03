package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.datatable.client.views.model.EyeColor;
import org.dominokit.domino.datatable.client.views.model.Gender;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.progress.Progress;
import org.dominokit.domino.ui.progress.ProgressBar;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;

import static org.jboss.gwt.elemento.core.Elements.i;

public class ContactUiUtils {

    public static HTMLElement getBalanceElement(Contact contact) {
        double doubleBalance = contact.getDoubleBalance();
        Progress progress = Progress.create()
                .addBar(ProgressBar.create(4000)
                        .setValue(doubleBalance)
                        .setBackground(getBalanceColor(doubleBalance).color())
                )
                .style()
                .setMargin("0px").get();
        Tooltip.create(progress, contact.getBalance());
        return progress.asElement();
    }

    public static ColorScheme getBalanceColor(double balance) {
        if (balance > 3000) {
            return ColorScheme.GREEN;
        } else if (balance > 2000) {
            return ColorScheme.BLUE;
        } else if (balance > 1000) {
            return ColorScheme.ORANGE;
        } else {
            return ColorScheme.RED;
        }
    }

    public static  ColorScheme getBalanceColor(Contact contact) {
        return getBalanceColor(contact.getDoubleBalance());
    }

    public static  HTMLElement getGenderElement(Contact contact) {
        if (Gender.male.equals(contact.getGender())) {
            return i().css("fas fa-male fa-lg").asElement();
        } else {
            return i().css("fas fa-female fa-lg").asElement();
        }
    }

    public static  HTMLElement getEyeColorElement(Contact contact) {
        HTMLElement element = i().css("fas fa-eye fa-lg").asElement();

        if (EyeColor.blue.equals(contact.getEyeColor())) {
            return Style.of(element).setColor(Color.BLUE.getHex()).asElement();
        } else if (EyeColor.green.equals(contact.getEyeColor())) {
            return Style.of(element).setColor(Color.GREEN.getHex()).asElement();
        } else if (EyeColor.brown.equals(contact.getEyeColor())) {
            return Style.of(element).setColor(Color.BROWN.getHex()).asElement();
        }

        return element;
    }

    public static  Color getColor(Contact contact) {
        if (EyeColor.brown.equals(contact.getEyeColor()))
            return Color.BROWN;
        if (EyeColor.blue.equals(contact.getEyeColor()))
            return Color.BLUE;
        if (EyeColor.green.equals(contact.getEyeColor()))
            return Color.GREEN;
        return Color.BROWN;
    }

    public static  String getAvatarIndex(Contact contact) {
        return (contact.getIndex() % 99) + "";
    }

    public static  String getGenderIconName(Contact contact) {
        if (Gender.male.equals(contact.getGender()))
            return "men";
        return "women";
    }
}
