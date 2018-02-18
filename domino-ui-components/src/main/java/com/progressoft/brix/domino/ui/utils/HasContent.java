package com.progressoft.brix.domino.ui.utils;

@FunctionalInterface
public interface HasContent<T> {
    T setContent(String content);
}
