package com.pat.think.in.spring.aop.overview;

/**
 * @Description: Echo 服务
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public interface EchoService {
    String echo(String message) throws NullPointerException;
}
