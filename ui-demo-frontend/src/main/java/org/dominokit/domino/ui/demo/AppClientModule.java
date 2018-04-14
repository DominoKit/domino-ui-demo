package org.dominokit.domino.ui.demo;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ClientApp;
import org.gwtproject.i18n.client.LocalizedNames;
import org.gwtproject.i18n.client.impl.cldr.LocalizedNames_factory;
import org.gwtproject.i18n.shared.DateTimeFormatInfo;
import org.gwtproject.i18n.shared.impl.cldr.DateTimeFormatInfoImpl_ar;
import org.gwtproject.i18n.shared.impl.cldr.DateTimeFormatInfoImpl_en;
import org.gwtproject.i18n.shared.impl.cldr.DateTimeFormatInfoImpl_fr;
import org.gwtproject.i18n.shared.impl.cldr.DateTimeFormatInfo_factory;

import java.util.logging.Logger;

public class AppClientModule implements EntryPoint {

    private static final Logger LOGGER = Logger.getLogger(AppClientModule.class.getName());

    public void onModuleLoad() {

        DateTimeFormatInfo info_en = new DateTimeFormatInfoImpl_en();
        DateTimeFormatInfo info_ar = new DateTimeFormatInfoImpl_ar();
        DateTimeFormatInfo info_fr = new DateTimeFormatInfoImpl_fr();

        DateTimeFormatInfo dateTimeFormatInfo = DateTimeFormatInfo_factory.create();
        LocalizedNames localizedNames = LocalizedNames_factory.create();
        LOGGER.info(info_en.weekdaysFull() + "");
        LOGGER.info(info_ar.weekdaysFull() + "");
        LOGGER.info(info_fr.weekdaysFull() + "");
        ClientApp.make().run();
        LOGGER.info("ui-demo Application frontend have been initialized.");
    }
}
