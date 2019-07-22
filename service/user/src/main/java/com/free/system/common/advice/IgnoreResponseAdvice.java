package com.free.system.common.advice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description:
 * @author suwenguang
 * @date 2019/5/24
 * @version 1.0.0
 **/
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@SuppressWarnings("all")
public @interface IgnoreResponseAdvice {
}
