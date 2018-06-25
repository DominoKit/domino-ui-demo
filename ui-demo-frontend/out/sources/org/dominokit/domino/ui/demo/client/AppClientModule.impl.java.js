/**
 * @fileoverview transpiled from org.dominokit.domino.ui.demo.client.AppClientModule.
 *
 * @suppress {const, extraRequire, missingOverride, missingRequire, suspiciousCode, transitionalSuspiciousCodeWarnings, unusedLocalVariables, uselessCode}
 */
goog.module('org.dominokit.domino.ui.demo.client.AppClientModule$impl');


const EntryPoint = goog.require('com.google.gwt.core.client.EntryPoint$impl');
const j_l_Object = goog.require('java.lang.Object$impl');
const $Util = goog.require('nativebootstrap.Util$impl');

let Class = goog.forwardDeclare('java.lang.Class$impl');
let Logger = goog.forwardDeclare('java.util.logging.Logger$impl');
let AdvancedFormsModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.advancedforms.client.AdvancedFormsModuleConfiguration$impl');
let AlertsModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.alerts.client.AlertsModuleConfiguration$impl');
let AnimationModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.animation.client.AnimationModuleConfiguration$impl');
let ClientApp = goog.forwardDeclare('org.dominokit.domino.api.client.ClientApp$impl');
let ModuleConfigurator = goog.forwardDeclare('org.dominokit.domino.api.client.ModuleConfigurator$impl');
let BadgesModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.badges.client.BadgesModuleConfiguration$impl');
let BasicFormsModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.basicforms.client.BasicFormsModuleConfiguration$impl');
let BreadcrumbModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.breadcrumb.client.BreadcrumbModuleConfiguration$impl');
let ButtonsModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.buttons.client.ButtonsModuleConfiguration$impl');
let CardsModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.cards.client.CardsModuleConfiguration$impl');
let CollapseModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.collapse.client.CollapseModuleConfiguration$impl');
let ColorsModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.colors.client.ColorsModuleConfiguration$impl');
let ComponentCaseModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.componentcase.client.ComponentCaseModuleConfiguration$impl');
let ComponentCaseUIModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.componentcase.client.ComponentCaseUIModuleConfiguration$impl');
let ComponentsModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.components.client.ComponentsModuleConfiguration$impl');
let ComponentsUIModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.components.client.ComponentsUIModuleConfiguration$impl');
let DatePickerModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.datepicker.client.DatePickerModuleConfiguration$impl');
let DialogsModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.dialogs.client.DialogsModuleConfiguration$impl');
let FormsModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.forms.client.FormsModuleConfiguration$impl');
let FormsUIModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.forms.client.FormsUIModuleConfiguration$impl');
let FormsValidationsModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.formsvalidations.client.FormsValidationsModuleConfiguration$impl');
let CoreModule = goog.forwardDeclare('org.dominokit.domino.gwt.client.app.CoreModule$impl');
let HelpersModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.helpers.client.HelpersModuleConfiguration$impl');
let HomeModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.home.client.HomeModuleConfiguration$impl');
let IconsModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.icons.client.IconsModuleConfiguration$impl');
let InfoBoxModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.infobox.client.InfoBoxModuleConfiguration$impl');
let LabelsModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.labels.client.LabelsModuleConfiguration$impl');
let LayoutModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.layout.client.LayoutModuleConfiguration$impl');
let LayoutUIModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.layout.client.LayoutUIModuleConfiguration$impl');
let ListsModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.lists.client.ListsModuleConfiguration$impl');
let LoadersModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.loaders.client.LoadersModuleConfiguration$impl');
let MediaModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.media.client.MediaModuleConfiguration$impl');
let MenuModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.menu.client.MenuModuleConfiguration$impl');
let ModalsModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.modals.client.ModalsModuleConfiguration$impl');
let NotificationsModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.notifications.client.NotificationsModuleConfiguration$impl');
let PaginationModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.pagination.client.PaginationModuleConfiguration$impl');
let PopoverModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.popover.client.PopoverModuleConfiguration$impl');
let PreloadersModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.preloaders.client.PreloadersModuleConfiguration$impl');
let ProfileModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.profile.client.ProfileModuleConfiguration$impl');
let ProgressModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.progress.client.ProgressModuleConfiguration$impl');
let TabsModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.tabs.client.TabsModuleConfiguration$impl');
let ThemesModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.themes.client.ThemesModuleConfiguration$impl');
let ThumbnailsModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.thumbnails.client.ThumbnailsModuleConfiguration$impl');
let TimePickerModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.timepicker.client.TimePickerModuleConfiguration$impl');
let TypographyModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.typography.client.TypographyModuleConfiguration$impl');
let WavesModuleConfiguration = goog.forwardDeclare('org.dominokit.domino.waves.client.WavesModuleConfiguration$impl');


/**
 * @implements {EntryPoint}
  */
class AppClientModule extends j_l_Object {
  /**
   * @private
   */
  constructor() {
    super();
  }
  
  /**
   * Factory method corresponding to constructor 'AppClientModule()'.
   * @return {!AppClientModule}
   * @public
   */
  static $create__() {
    AppClientModule.$clinit();
    let $instance = new AppClientModule();
    $instance.$ctor__org_dominokit_domino_ui_demo_client_AppClientModule__();
    return $instance;
  }
  
  /**
   * Initialization from constructor 'AppClientModule()'.
   * @return {void}
   * @public
   */
  $ctor__org_dominokit_domino_ui_demo_client_AppClientModule__() {
    this.$ctor__java_lang_Object__();
  }
  
  /**
   * @override
   * @return {void}
   * @public
   */
  m_onModuleLoad__() {
    CoreModule.m_init__();
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(HomeModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(FormsValidationsModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(BasicFormsModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(AlertsModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(ButtonsModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(AdvancedFormsModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(CardsModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(BadgesModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(BreadcrumbModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(ComponentCaseUIModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(ComponentsModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(ComponentsUIModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(CollapseModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(ComponentCaseModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(DatePickerModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(FormsUIModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(FormsModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(DialogsModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(IconsModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(HelpersModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(LayoutModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(LabelsModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(LayoutUIModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(InfoBoxModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(LoadersModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(ListsModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(ModalsModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(MediaModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(NotificationsModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(MenuModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(PopoverModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(PaginationModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(PreloadersModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(ProgressModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(ThumbnailsModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(WavesModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(TabsModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(TimePickerModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(ThemesModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(ProfileModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(AnimationModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(TypographyModuleConfiguration.$create__());
    ModuleConfigurator.$create__().m_configureModule__org_dominokit_domino_api_client_ModuleConfiguration(ColorsModuleConfiguration.$create__());
    ClientApp.m_make__().m_run__();
    AppClientModule.$f_LOGGER__org_dominokit_domino_ui_demo_client_AppClientModule_.m_info__java_lang_String("ui-demo Application frontend have been initialized.----999");
  }
  
  /**
   * @return {Logger}
   * @public
   */
  static get f_LOGGER__org_dominokit_domino_ui_demo_client_AppClientModule_() {
    return (AppClientModule.$clinit(), AppClientModule.$f_LOGGER__org_dominokit_domino_ui_demo_client_AppClientModule_);
  }
  
  /**
   * @param {Logger} value
   * @return {void}
   * @public
   */
  static set f_LOGGER__org_dominokit_domino_ui_demo_client_AppClientModule_(value) {
    (AppClientModule.$clinit(), AppClientModule.$f_LOGGER__org_dominokit_domino_ui_demo_client_AppClientModule_ = value);
  }
  
  /**
   * @param {?} instance
   * @return {boolean}
   * @public
   */
  static $isInstance(instance) {
    return instance instanceof AppClientModule;
  }
  
  /**
   * @param {Function} classConstructor
   * @return {boolean}
   * @public
   */
  static $isAssignableFrom(classConstructor) {
    return $Util.$canCastClass(classConstructor, AppClientModule);
  }
  
  /**
   * @public
   */
  static $clinit() {
    AppClientModule.$clinit = function() {};
    Class = goog.module.get('java.lang.Class$impl');
    Logger = goog.module.get('java.util.logging.Logger$impl');
    AdvancedFormsModuleConfiguration = goog.module.get('org.dominokit.domino.advancedforms.client.AdvancedFormsModuleConfiguration$impl');
    AlertsModuleConfiguration = goog.module.get('org.dominokit.domino.alerts.client.AlertsModuleConfiguration$impl');
    AnimationModuleConfiguration = goog.module.get('org.dominokit.domino.animation.client.AnimationModuleConfiguration$impl');
    ClientApp = goog.module.get('org.dominokit.domino.api.client.ClientApp$impl');
    ModuleConfigurator = goog.module.get('org.dominokit.domino.api.client.ModuleConfigurator$impl');
    BadgesModuleConfiguration = goog.module.get('org.dominokit.domino.badges.client.BadgesModuleConfiguration$impl');
    BasicFormsModuleConfiguration = goog.module.get('org.dominokit.domino.basicforms.client.BasicFormsModuleConfiguration$impl');
    BreadcrumbModuleConfiguration = goog.module.get('org.dominokit.domino.breadcrumb.client.BreadcrumbModuleConfiguration$impl');
    ButtonsModuleConfiguration = goog.module.get('org.dominokit.domino.buttons.client.ButtonsModuleConfiguration$impl');
    CardsModuleConfiguration = goog.module.get('org.dominokit.domino.cards.client.CardsModuleConfiguration$impl');
    CollapseModuleConfiguration = goog.module.get('org.dominokit.domino.collapse.client.CollapseModuleConfiguration$impl');
    ColorsModuleConfiguration = goog.module.get('org.dominokit.domino.colors.client.ColorsModuleConfiguration$impl');
    ComponentCaseModuleConfiguration = goog.module.get('org.dominokit.domino.componentcase.client.ComponentCaseModuleConfiguration$impl');
    ComponentCaseUIModuleConfiguration = goog.module.get('org.dominokit.domino.componentcase.client.ComponentCaseUIModuleConfiguration$impl');
    ComponentsModuleConfiguration = goog.module.get('org.dominokit.domino.components.client.ComponentsModuleConfiguration$impl');
    ComponentsUIModuleConfiguration = goog.module.get('org.dominokit.domino.components.client.ComponentsUIModuleConfiguration$impl');
    DatePickerModuleConfiguration = goog.module.get('org.dominokit.domino.datepicker.client.DatePickerModuleConfiguration$impl');
    DialogsModuleConfiguration = goog.module.get('org.dominokit.domino.dialogs.client.DialogsModuleConfiguration$impl');
    FormsModuleConfiguration = goog.module.get('org.dominokit.domino.forms.client.FormsModuleConfiguration$impl');
    FormsUIModuleConfiguration = goog.module.get('org.dominokit.domino.forms.client.FormsUIModuleConfiguration$impl');
    FormsValidationsModuleConfiguration = goog.module.get('org.dominokit.domino.formsvalidations.client.FormsValidationsModuleConfiguration$impl');
    CoreModule = goog.module.get('org.dominokit.domino.gwt.client.app.CoreModule$impl');
    HelpersModuleConfiguration = goog.module.get('org.dominokit.domino.helpers.client.HelpersModuleConfiguration$impl');
    HomeModuleConfiguration = goog.module.get('org.dominokit.domino.home.client.HomeModuleConfiguration$impl');
    IconsModuleConfiguration = goog.module.get('org.dominokit.domino.icons.client.IconsModuleConfiguration$impl');
    InfoBoxModuleConfiguration = goog.module.get('org.dominokit.domino.infobox.client.InfoBoxModuleConfiguration$impl');
    LabelsModuleConfiguration = goog.module.get('org.dominokit.domino.labels.client.LabelsModuleConfiguration$impl');
    LayoutModuleConfiguration = goog.module.get('org.dominokit.domino.layout.client.LayoutModuleConfiguration$impl');
    LayoutUIModuleConfiguration = goog.module.get('org.dominokit.domino.layout.client.LayoutUIModuleConfiguration$impl');
    ListsModuleConfiguration = goog.module.get('org.dominokit.domino.lists.client.ListsModuleConfiguration$impl');
    LoadersModuleConfiguration = goog.module.get('org.dominokit.domino.loaders.client.LoadersModuleConfiguration$impl');
    MediaModuleConfiguration = goog.module.get('org.dominokit.domino.media.client.MediaModuleConfiguration$impl');
    MenuModuleConfiguration = goog.module.get('org.dominokit.domino.menu.client.MenuModuleConfiguration$impl');
    ModalsModuleConfiguration = goog.module.get('org.dominokit.domino.modals.client.ModalsModuleConfiguration$impl');
    NotificationsModuleConfiguration = goog.module.get('org.dominokit.domino.notifications.client.NotificationsModuleConfiguration$impl');
    PaginationModuleConfiguration = goog.module.get('org.dominokit.domino.pagination.client.PaginationModuleConfiguration$impl');
    PopoverModuleConfiguration = goog.module.get('org.dominokit.domino.popover.client.PopoverModuleConfiguration$impl');
    PreloadersModuleConfiguration = goog.module.get('org.dominokit.domino.preloaders.client.PreloadersModuleConfiguration$impl');
    ProfileModuleConfiguration = goog.module.get('org.dominokit.domino.profile.client.ProfileModuleConfiguration$impl');
    ProgressModuleConfiguration = goog.module.get('org.dominokit.domino.progress.client.ProgressModuleConfiguration$impl');
    TabsModuleConfiguration = goog.module.get('org.dominokit.domino.tabs.client.TabsModuleConfiguration$impl');
    ThemesModuleConfiguration = goog.module.get('org.dominokit.domino.themes.client.ThemesModuleConfiguration$impl');
    ThumbnailsModuleConfiguration = goog.module.get('org.dominokit.domino.thumbnails.client.ThumbnailsModuleConfiguration$impl');
    TimePickerModuleConfiguration = goog.module.get('org.dominokit.domino.timepicker.client.TimePickerModuleConfiguration$impl');
    TypographyModuleConfiguration = goog.module.get('org.dominokit.domino.typography.client.TypographyModuleConfiguration$impl');
    WavesModuleConfiguration = goog.module.get('org.dominokit.domino.waves.client.WavesModuleConfiguration$impl');
    j_l_Object.$clinit();
    AppClientModule.$f_LOGGER__org_dominokit_domino_ui_demo_client_AppClientModule_ = Logger.m_getLogger__java_lang_String(Class.$get(AppClientModule).m_getName__());
  }
  
  
};

$Util.$setClassMetadata(AppClientModule, $Util.$makeClassName('org.dominokit.domino.ui.demo.client.AppClientModule'));


/** @private {Logger} */
AppClientModule.$f_LOGGER__org_dominokit_domino_ui_demo_client_AppClientModule_;


EntryPoint.$markImplementor(AppClientModule);


/* NATIVE.JS EPILOG */

const org_dominokit_domino_ui_demo_client_AppClientModule = AppClientModule;

/*
 * #%L
 * Connected
 * %%
 * Copyright (C) 2017 Vertispan
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

// Defer this command, since this will be folded into the FlowChartEntryPoint js impl,
// and if it runs right away, will not have its dependencies resolved yet (at least while
// running in BUNDLE).
setTimeout(function(){
  // Call the java "constructor" method, `new` will only work if it is a @JsType, or maybe
  // once optimized. Without this, in BUNDLE mode, `new` doesn't include the clinit, so
  // static imports haven't been resolved yet.
  var ep = AppClientModule.$create__();
  // Invoke onModuleLoad to start the app.
  ep.m_onModuleLoad__()
}, 0);



exports = AppClientModule; 
//# sourceMappingURL=AppClientModule.js.map