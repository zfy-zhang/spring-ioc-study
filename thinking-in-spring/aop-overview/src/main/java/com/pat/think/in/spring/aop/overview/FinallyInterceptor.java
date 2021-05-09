package com.pat.think.in.spring.aop.overview;

import java.lang.reflect.Method;

/**
 * @Description: 最终执行后置拦截器
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public interface FinallyInterceptor {
    /**
     * 最终执行
     * @param proxy
     * @param method
     * @param args
     * @param returnResult 执行方法返回结果s
     * @return
     */
    Object finalize(Object proxy, Method method, Object[] args, Object returnResult);
}
