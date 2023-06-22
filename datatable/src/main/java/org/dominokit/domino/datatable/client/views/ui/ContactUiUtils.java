package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.datatable.client.views.model.EyeColor;
import org.dominokit.domino.datatable.client.views.model.Gender;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.progress.Progress;
import org.dominokit.domino.ui.progress.ProgressBar;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.ColorsCss;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.ElementsFactory;

import static org.dominokit.domino.ui.style.ColorsCss.*;
import static org.dominokit.domino.ui.style.SpacingCss.dui_m_0;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;


public class ContactUiUtils {

    public static HTMLElement getBalanceElement(Contact contact) {
        double doubleBalance = contact.getBalance();
        Progress progress = Progress.create()
                .addCss(getBalanceColor(doubleBalance).color().getAccentColor(),dui_m_0)
                .appendChild(ProgressBar.create(4000)
                                .setValue(doubleBalance)
                )
                .setTooltip(contact.stringBalance())
                ;
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

    public static ColorScheme getBalanceColor(Contact contact) {
        return getBalanceColor(contact.getBalance());
    }

    public static HTMLElement getGenderElement(Contact contact) {
        if (Gender.male.equals(contact.getGender())) {
            return Icons.human_male().element();
        } else {
            return Icons.human_female().element();
        }
    }

    public static HTMLElement getEyeColorElement(Contact contact) {
        Icon<?> icon = Icons.eye();

        if (EyeColor.blue.equals(contact.getEyeColor())) {
            return icon.addCss(dui_fg_blue).element();
        } else if (EyeColor.green.equals(contact.getEyeColor())) {
            return icon.addCss(dui_fg_green).element();
        } else if (EyeColor.brown.equals(contact.getEyeColor())) {
            return icon.addCss(dui_fg_brown).element();
        }

        return icon.element();
    }

    public static Color getColor(Contact contact) {
        if (EyeColor.brown.equals(contact.getEyeColor()))
            return Color.BROWN;
        if (EyeColor.blue.equals(contact.getEyeColor()))
            return Color.BLUE;
        if (EyeColor.green.equals(contact.getEyeColor()))
            return Color.GREEN;
        return Color.BROWN;
    }

    public static String getAvatarIndex(Contact contact) {
        return (contact.getIndex() % 99) + "";
    }

    public static String getGenderIconName(Contact contact) {
        if (Gender.male.equals(contact.getGender()))
            return "men";
        return "women";
    }
}
