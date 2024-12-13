package com.springleaf.domain.strategy.service.annotation;


import com.springleaf.domain.strategy.service.rule.filter.factory.DefaultLogicFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 策略自定义枚举
 */
@Target({ElementType.TYPE}) //表示这个注解可以应用于类型（类、接口、枚举等）。
@Retention(RetentionPolicy.RUNTIME) //说明这个注解在运行时仍然可用，能够通过反射方式访问。
public @interface LogicStrategy {

    DefaultLogicFactory.LogicModel logicMode();

}
