/**
 * @fileoverview transpiled from com.google.gwt.core.client.EntryPoint.
 *
 * @suppress {const, extraRequire, missingOverride, missingRequire, suspiciousCode, transitionalSuspiciousCodeWarnings, unusedLocalVariables, uselessCode}
 */
goog.module('com.google.gwt.core.client.EntryPoint$impl');


const $Util = goog.require('nativebootstrap.Util$impl');

let $LambdaAdaptor = goog.forwardDeclare('com.google.gwt.core.client.EntryPoint.$LambdaAdaptor$impl');


/**
 * @interface
 */
class EntryPoint {
  /**
   * @abstract
   * @return {void}
   * @public
   */
  m_onModuleLoad__() {
  }
  
  /**
   * @param {?function():void} fn
   * @return {EntryPoint}
   * @public
   */
  static $adapt(fn) {
    EntryPoint.$clinit();
    return new $LambdaAdaptor(fn);
  }
  
  /**
   * @param {Function} classConstructor
   * @public
   */
  static $markImplementor(classConstructor) {
    /**
     * @public {boolean}
     */
    classConstructor.prototype.$implements__com_google_gwt_core_client_EntryPoint = true;
  }
  
  /**
   * @param {?} instance
   * @return {boolean}
   * @public
   */
  static $isInstance(instance) {
    return instance != null && !!instance.$implements__com_google_gwt_core_client_EntryPoint;
  }
  
  /**
   * @param {Function} classConstructor
   * @return {boolean}
   * @public
   */
  static $isAssignableFrom(classConstructor) {
    return classConstructor != null && !!classConstructor.prototype.$implements__com_google_gwt_core_client_EntryPoint;
  }
  
  /**
   * @public
   */
  static $clinit() {
    EntryPoint.$clinit = function() {};
    $LambdaAdaptor = goog.module.get('com.google.gwt.core.client.EntryPoint.$LambdaAdaptor$impl');
  }
  
  
};

$Util.$setClassMetadataForInterface(EntryPoint, $Util.$makeClassName('com.google.gwt.core.client.EntryPoint'));


EntryPoint.$markImplementor(/** @type {Function} */ (EntryPoint));


exports = EntryPoint; 
//# sourceMappingURL=EntryPoint.js.map