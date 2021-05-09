package com.pat.think.in.spring.aop.overview;

import java.lang.reflect.Method;

/**
 * @Description: 前置拦截器
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public interface BeforeInterceptor {

    /**
     * 前置执行
     * @param proxy
     * @param method
     * @param args
     * @return
     */
    Object before(Object proxy, Method method, Object[] args);
}
