package com.pat.think.in.spring.aop.overview;

/**
 * @Description: 默认 {@link EchoService} 实现
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public class DefaultEchoService implements EchoService {
    @Override
    public String echo(String message) {
        return "[ECHO] " + message;
    }
}
