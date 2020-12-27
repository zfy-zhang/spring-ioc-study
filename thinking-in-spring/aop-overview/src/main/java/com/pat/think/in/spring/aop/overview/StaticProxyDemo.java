package com.pat.think.in.spring.aop.overview;

import com.sun.java.browser.net.ProxyService;

/**
 * @Description: 静态代理: 通过组合和继承实现的
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public class StaticProxyDemo {

    public static void main(String[] args) {
        EchoService echoService = new ProxyEchoService(new DefaultEchoService());
        String echo = echoService.echo("Hello World");
        System.out.println(echo);
    }
}
