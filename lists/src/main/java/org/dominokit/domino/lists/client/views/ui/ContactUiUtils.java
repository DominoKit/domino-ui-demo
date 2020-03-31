package org.dominokit.domino.lists.client.views.ui;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.progress.Progress;
import org.dominokit.domino.ui.progress.ProgressBar;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.uidemoserver.shared.model.Contact;
import org.dominokit.domino.uidemoserver.shared.model.EyeColor;
import org.dominokit.domino.uidemoserver.shared.model.Gender;

import static org.jboss.elemento.Elements.i;

public class ContactUiUtils {

    public static HTMLElement getBalanceElement(Contact contact) {
        double doubleBalance = contact.getBalance();
        Progress progress = Progress.create()
                .appendChild(ProgressBar.create(4000)
                        .setValue(doubleBalance)
                        .setBackground(getBalanceColor(doubleBalance).color())
                )
                .style()
                .setMargin("0px").get();
        Tooltip.create(progress, contact.stringBalance());
        return progress.element();
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
        return getBalanceColor(contact.getBalance());
    }

    public static  HTMLElement getGenderElement(Contact contact) {
        if (Gender.male.equals(contact.getGender())) {
            return i().css("fas fa-male fa-lg").element();
        } else {
            return i().css("fas fa-female fa-lg").element();
        }
    }

    public static  HTMLElement getEyeColorElement(Contact contact) {
        HTMLElement element = i().css("fas fa-eye fa-lg").element();

        if (EyeColor.blue.equals(contact.getEyeColor())) {
            return Style.of(element).setColor(Color.BLUE.getHex()).element();
        } else if (EyeColor.green.equals(contact.getEyeColor())) {
            return Style.of(element).setColor(Color.GREEN.getHex()).element();
        } else if (EyeColor.brown.equals(contact.getEyeColor())) {
            return Style.of(element).setColor(Color.BROWN.getHex()).element();
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

    public static String getAvatarUrl(Contact value) {
        return value.getPicture().replace("gender", ContactUiUtils.getGenderIconName(value)).replace("index", ContactUiUtils.getAvatarIndex(value));
    }
}
