package org.dominokit.domino.componentcase.client.ui.views;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class PR {
    public static native String prettyPrintOne(String code, String langExtension, boolean lineNumbers);
}
