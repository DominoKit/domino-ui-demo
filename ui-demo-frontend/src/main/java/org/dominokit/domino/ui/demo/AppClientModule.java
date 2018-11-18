package org.dominokit.domino.ui.demo;


import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.advancedforms.client.AdvancedFormsModuleConfiguration;
import org.dominokit.domino.alerts.client.AlertsModuleConfiguration;
import org.dominokit.domino.animation.client.AnimationModuleConfiguration;
import org.dominokit.domino.api.client.ClientApp;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.applayout.client.AppLayoutModuleConfiguration;
import org.dominokit.domino.badges.client.BadgesModuleConfiguration;
import org.dominokit.domino.basicforms.client.BasicFormsModuleConfiguration;
import org.dominokit.domino.breadcrumb.client.BreadcrumbModuleConfiguration;
import org.dominokit.domino.buttons.client.ButtonsModuleConfiguration;
import org.dominokit.domino.cards.client.CardsModuleConfiguration;
import org.dominokit.domino.carousel.client.CarouselModuleConfiguration;
import org.dominokit.domino.chips.client.ChipsModuleConfiguration;
import org.dominokit.domino.collapse.client.CollapseModuleConfiguration;
import org.dominokit.domino.colors.client.ColorsModuleConfiguration;
import org.dominokit.domino.componentcase.client.ComponentCaseModuleConfiguration;
import org.dominokit.domino.componentcase.client.ComponentCaseUIModuleConfiguration;
import org.dominokit.domino.components.client.ComponentsModuleConfiguration;
import org.dominokit.domino.datatable.client.DatatableModuleConfiguration;
import org.dominokit.domino.datepicker.client.DatePickerModuleConfiguration;
import org.dominokit.domino.dialogs.client.DialogsModuleConfiguration;
import org.dominokit.domino.flexlayout.client.FlexLayoutModuleConfiguration;
import org.dominokit.domino.forms.client.FormsModuleConfiguration;
import org.dominokit.domino.forms.client.FormsUIModuleConfiguration;
import org.dominokit.domino.formsamples.client.FormSamplesModuleConfiguration;
import org.dominokit.domino.formsvalidations.client.FormsValidationsModuleConfiguration;
import org.dominokit.domino.gridLayout.client.GridLayoutModuleConfiguration;
import org.dominokit.domino.grids.client.GridsModuleConfiguration;
import org.dominokit.domino.gwt.client.app.CoreModule;
import org.dominokit.domino.helpers.client.HelpersModuleConfiguration;
import org.dominokit.domino.home.client.HomeModuleConfiguration;
import org.dominokit.domino.icons.client.IconsModuleConfiguration;
import org.dominokit.domino.infobox.client.InfoBoxModuleConfiguration;
import org.dominokit.domino.inputfields.client.InputFieldsModuleConfiguration;
import org.dominokit.domino.labels.client.LabelsModuleConfiguration;
import org.dominokit.domino.layout.client.LayoutModuleConfiguration;
import org.dominokit.domino.layout.client.LayoutUIModuleConfiguration;
import org.dominokit.domino.layouts.client.LayoutsModuleConfiguration;
import org.dominokit.domino.lists.client.ListsModuleConfiguration;
import org.dominokit.domino.loaders.client.LoadersModuleConfiguration;
import org.dominokit.domino.login.client.LoginModuleConfiguration;
import org.dominokit.domino.mdiicons.client.MdiIconsModuleConfiguration;
import org.dominokit.domino.media.client.MediaModuleConfiguration;
import org.dominokit.domino.menu.client.MenuModuleConfiguration;
import org.dominokit.domino.modals.client.ModalsModuleConfiguration;
import org.dominokit.domino.notifications.client.NotificationsModuleConfiguration;
import org.dominokit.domino.pagination.client.PaginationModuleConfiguration;
import org.dominokit.domino.popover.client.PopoverModuleConfiguration;
import org.dominokit.domino.preloaders.client.PreloadersModuleConfiguration;
import org.dominokit.domino.profile.client.ProfileModuleConfiguration;
import org.dominokit.domino.progress.client.ProgressModuleConfiguration;
import org.dominokit.domino.samples.client.SamplesModuleConfiguration;
import org.dominokit.domino.setup.client.SetupModuleConfiguration;
import org.dominokit.domino.sliders.client.SlidersModuleConfiguration;
import org.dominokit.domino.spin.client.SpinSelectModuleConfiguration;
import org.dominokit.domino.splitPanel.client.SplitPanelModuleConfiguration;
import org.dominokit.domino.steppers.client.SteppersModuleConfiguration;
import org.dominokit.domino.tabs.client.TabsModuleConfiguration;
import org.dominokit.domino.themes.client.ThemesModuleConfiguration;
import org.dominokit.domino.thumbnails.client.ThumbnailsModuleConfiguration;
import org.dominokit.domino.timepicker.client.TimePickerModuleConfiguration;
import org.dominokit.domino.tree.client.TreeModuleConfiguration;
import org.dominokit.domino.typography.client.TypographyModuleConfiguration;
import org.dominokit.domino.waves.client.WavesModuleConfiguration;

import java.util.logging.Logger;

public class AppClientModule implements EntryPoint {

    private static final Logger LOGGER = Logger.getLogger(AppClientModule.class.getName());

    public void onModuleLoad() {

        CoreModule.init();

        new ModuleConfigurator().configureModule(new LayoutModuleConfiguration());
        new ModuleConfigurator().configureModule(new LayoutUIModuleConfiguration());
        new ModuleConfigurator().configureModule(new ThemesModuleConfiguration());
        new ModuleConfigurator().configureModule(new ProfileModuleConfiguration());
        new ModuleConfigurator().configureModule(new MenuModuleConfiguration());
        new ModuleConfigurator().configureModule(new ComponentCaseModuleConfiguration());
        new ModuleConfigurator().configureModule(new ComponentCaseUIModuleConfiguration());
        new ModuleConfigurator().configureModule(new HomeModuleConfiguration());
        new ModuleConfigurator().configureModule(new SetupModuleConfiguration());
        new ModuleConfigurator().configureModule(new SamplesModuleConfiguration());
        new ModuleConfigurator().configureModule(new LayoutsModuleConfiguration());
        new ModuleConfigurator().configureModule(new AppLayoutModuleConfiguration());
        new ModuleConfigurator().configureModule(new GridLayoutModuleConfiguration());
        new ModuleConfigurator().configureModule(new GridsModuleConfiguration());
        new ModuleConfigurator().configureModule(new ComponentsModuleConfiguration());
        new ModuleConfigurator().configureModule(new FormsModuleConfiguration());
        new ModuleConfigurator().configureModule(new FormsUIModuleConfiguration());
        new ModuleConfigurator().configureModule(new DatatableModuleConfiguration());
        new ModuleConfigurator().configureModule(new BasicFormsModuleConfiguration());
        new ModuleConfigurator().configureModule(new AdvancedFormsModuleConfiguration());
        new ModuleConfigurator().configureModule(new FormsValidationsModuleConfiguration());
        new ModuleConfigurator().configureModule(new DatePickerModuleConfiguration());
        new ModuleConfigurator().configureModule(new TimePickerModuleConfiguration());
        new ModuleConfigurator().configureModule(new IconsModuleConfiguration());
        new ModuleConfigurator().configureModule(new MdiIconsModuleConfiguration());
        new ModuleConfigurator().configureModule(new TypographyModuleConfiguration());
        new ModuleConfigurator().configureModule(new HelpersModuleConfiguration());
        new ModuleConfigurator().configureModule(new ColorsModuleConfiguration());
        new ModuleConfigurator().configureModule(new AnimationModuleConfiguration());
        new ModuleConfigurator().configureModule(new CardsModuleConfiguration());
        new ModuleConfigurator().configureModule(new InfoBoxModuleConfiguration());
        new ModuleConfigurator().configureModule(new ButtonsModuleConfiguration());
        new ModuleConfigurator().configureModule(new AlertsModuleConfiguration());
        new ModuleConfigurator().configureModule(new BadgesModuleConfiguration());
        new ModuleConfigurator().configureModule(new LabelsModuleConfiguration());
        new ModuleConfigurator().configureModule(new ModalsModuleConfiguration());
        new ModuleConfigurator().configureModule(new ListsModuleConfiguration());
        new ModuleConfigurator().configureModule(new LoadersModuleConfiguration());
        new ModuleConfigurator().configureModule(new BreadcrumbModuleConfiguration());
        new ModuleConfigurator().configureModule(new CollapseModuleConfiguration());
        new ModuleConfigurator().configureModule(new NotificationsModuleConfiguration());
        new ModuleConfigurator().configureModule(new MediaModuleConfiguration());
        new ModuleConfigurator().configureModule(new PaginationModuleConfiguration());
        new ModuleConfigurator().configureModule(new PreloadersModuleConfiguration());
        new ModuleConfigurator().configureModule(new ProgressModuleConfiguration());
        new ModuleConfigurator().configureModule(new TabsModuleConfiguration());
        new ModuleConfigurator().configureModule(new ThumbnailsModuleConfiguration());
        new ModuleConfigurator().configureModule(new DialogsModuleConfiguration());
        new ModuleConfigurator().configureModule(new PopoverModuleConfiguration());
        new ModuleConfigurator().configureModule(new WavesModuleConfiguration());
        new ModuleConfigurator().configureModule(new SteppersModuleConfiguration());
        new ModuleConfigurator().configureModule(new FormSamplesModuleConfiguration());
        new ModuleConfigurator().configureModule(new SlidersModuleConfiguration());
        new ModuleConfigurator().configureModule(new CarouselModuleConfiguration());
        new ModuleConfigurator().configureModule(new TreeModuleConfiguration());
        new ModuleConfigurator().configureModule(new ChipsModuleConfiguration());
        new ModuleConfigurator().configureModule(new SplitPanelModuleConfiguration());
        new ModuleConfigurator().configureModule(new FlexLayoutModuleConfiguration());
        new ModuleConfigurator().configureModule(new SpinSelectModuleConfiguration());
        new ModuleConfigurator().configureModule(new InputFieldsModuleConfiguration());
        new ModuleConfigurator().configureModule(new LoginModuleConfiguration());


        ClientApp.make().run();
        LOGGER.info("ui-demo Application frontend have been initialized.");
    }
}
