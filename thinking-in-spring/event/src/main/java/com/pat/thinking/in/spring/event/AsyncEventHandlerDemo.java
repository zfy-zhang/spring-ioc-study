package com.pat.thinking.in.spring.event;

import org.springframework.context.support.GenericApplicationContext;

/**
 * @Description: 异步事件处理器
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/14
 * @Modify
 * @since
 */
public class AsyncEventHandlerDemo {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();

        context.addApplicationListener(new MySpringEventListener());

        context.refresh();

        context.publishEvent(new MySpringEvent("Hello World!"));

        context.close();
    }
}
