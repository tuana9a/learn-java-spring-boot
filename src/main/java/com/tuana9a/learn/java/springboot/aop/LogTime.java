package com.tuana9a.learn.java.springboot.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


@Target({ElementType.METHOD})
public @interface LogTime {

}
