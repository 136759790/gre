package com.gre.api.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.gre.api.enums.TreeSwitchEnum;

/**
 * 转换树类型所用
 * @author Jason
 * @see TreeSwitchEnum
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Tree {
	TreeSwitchEnum value() default TreeSwitchEnum.ID;
}
