package org.dominokit.domino;


import java.lang.annotation.*;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD, ElementType.TYPE_USE})
@Documented
public @interface SampleMethod {
}
