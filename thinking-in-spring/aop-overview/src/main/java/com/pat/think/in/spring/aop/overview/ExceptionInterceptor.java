package com.pat.think.in.spring.aop.overview;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public interface ExceptionInterceptor {

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @param throwable 异常信息
     */
    void interceptor(Object proxy, Method method, Object[] args, Throwable throwable);
}
