package com.pat.thinking.in.spring.event;

import org.springframework.context.support.GenericApplicationContext;

/**
 * @Description: 自定义 ApplicationEvent
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/14
 * @Modify
 * @since
 */
public class CustomizedSpringEventDemo {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();

        context.addApplicationListener(new MySpringEventListener());

        context.refresh();

        context.publishEvent(new MySpringEvent("Hello World!"));

        context.close();
    }

}
