package com.pat.think.in.spring.aop.overview;

import java.lang.reflect.Method;

/**
 * @Description: （方法返回）后置拦截器
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public interface AfterReturnInterceptor {
    /**
     * 后置执行
     * @param proxy
     * @param method
     * @param args
     * @param returnResult 执行方法返回结果s
     * @return
     */
    Object after(Object proxy, Method method, Object[] args, Object returnResult);
}
