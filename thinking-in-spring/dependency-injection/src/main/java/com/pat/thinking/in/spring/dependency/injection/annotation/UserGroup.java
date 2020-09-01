package com.pat.thinking.in.spring.dependency.injection.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * @Description: 用户组注解，扩展 {@link Qualifier @Qualifier}
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/1
 * @Modify
 * @since
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier
public @interface UserGroup {
}
