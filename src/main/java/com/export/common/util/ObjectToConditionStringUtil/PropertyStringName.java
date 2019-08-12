package com.export.common.util.ObjectToConditionStringUtil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author KingBoy
 * @Date 2017/2/8 18:11
 * @Description ${DESCRIPTION}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE})
public @interface PropertyStringName {
    String name() default "";
}

