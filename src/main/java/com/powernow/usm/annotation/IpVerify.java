package com.powernow.usm.annotation;

import java.lang.annotation.*;

/**
 * ip白名单验证接口
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IpVerify {

}
