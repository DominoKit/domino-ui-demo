/**
 * @fileoverview transpiled from com.google.gwt.core.client.EntryPoint$$LambdaAdaptor.
 *
 * @suppress {const, extraRequire, missingOverride, missingRequire, suspiciousCode, transitionalSuspiciousCodeWarnings, unusedLocalVariables, uselessCode}
 */
goog.module('com.google.gwt.core.client.EntryPoint.$LambdaAdaptor$impl');


const EntryPoint = goog.require('com.google.gwt.core.client.EntryPoint$impl');
const j_l_Object = goog.require('java.lang.Object$impl');
const $Util = goog.require('nativebootstrap.Util$impl');


/**
 * @implements {EntryPoint}
  */
class $LambdaAdaptor extends j_l_Object {
  /**
   * JsConstructor '$LambdaAdaptor($JsFunction)'.
   * @param {?function():void} fn
   * @public
   */
  constructor(fn) {
    $LambdaAdaptor.$clinit();
    super();
    /** @public {?function():void} */
    this.f_$$fn__com_google_gwt_core_client_EntryPoint_$LambdaAdaptor;
    this.$ctor__com_google_gwt_core_client_EntryPoint_$LambdaAdaptor__com_google_gwt_core_client_EntryPoint_$JsFunction(fn);
  }
  
  /**
   * Initialization from constructor '$LambdaAdaptor($JsFunction)'.
   * @param {?function():void} fn
   * @return {void}
   * @public
   */
  $ctor__com_google_gwt_core_client_EntryPoint_$LambdaAdaptor__com_google_gwt_core_client_EntryPoint_$JsFunction(fn) {
    this.$ctor__java_lang_Object__();
    this.f_$$fn__com_google_gwt_core_client_EntryPoint_$LambdaAdaptor = fn;
  }
  
  /**
   * @return {void}
   * @public
   */
  m_onModuleLoad__() {
    {
      let $function = this.f_$$fn__com_google_gwt_core_client_EntryPoint_$LambdaAdaptor;
      $function();
    }
  }
  
  /**
   * @param {?} instance
   * @return {boolean}
   * @public
   */
  static $isInstance(instance) {
    return instance instanceof $LambdaAdaptor;
  }
  
  /**
   * @param {Function} classConstructor
   * @return {boolean}
   * @public
   */
  static $isAssignableFrom(classConstructor) {
    return $Util.$canCastClass(classConstructor, $LambdaAdaptor);
  }
  
  /**
   * @public
   */
  static $clinit() {
    $LambdaAdaptor.$clinit = function() {};
    j_l_Object.$clinit();
  }
  
  
};

$Util.$setClassMetadata($LambdaAdaptor, $Util.$makeClassName('com.google.gwt.core.client.EntryPoint$$LambdaAdaptor'));


EntryPoint.$markImplementor($LambdaAdaptor);


exports = $LambdaAdaptor; 
//# sourceMappingURL=EntryPoint$$LambdaAdaptor.js.map