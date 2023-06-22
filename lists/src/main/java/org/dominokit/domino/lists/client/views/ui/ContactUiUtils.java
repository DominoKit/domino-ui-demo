package org.dominokit.domino.lists.client.views.ui;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.elements.IElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.uidemoserver.shared.model.Contact;
import org.dominokit.domino.uidemoserver.shared.model.EyeColor;
import org.dominokit.domino.uidemoserver.shared.model.Gender;

import static org.dominokit.domino.ui.utils.ElementsFactory.elements;


public class ContactUiUtils {



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

    public static HTMLElement getGenderElement(Contact contact) {
        if (Gender.male.equals(contact.getGender())) {
            return Icons.human_male().element();
        } else {
            return Icons.human_female().element();
        }
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

    public static String getAvatarUrl(Contact value) {
        return value.getPicture().replace("gender", ContactUiUtils.getGenderIconName(value)).replace("index", ContactUiUtils.getAvatarIndex(value));
    }

    public static  String getGenderIconName(Contact contact) {
        if (Gender.male.equals(contact.getGender()))
            return "men";
        return "women";
    }

    public static  String getAvatarIndex(Contact contact) {
        return (contact.getIndex() % 99) + "";
    }
}
