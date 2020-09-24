package com.pat.thinking.in.spring.configuration.metadata;

import com.pat.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Map;

/**
 * @Description: 基于 Java 注解 Spring IoC 容器元信息皮质示例
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/24
 * @Modify
 * @since
 */
// 当前类作为 Configuration Class
@ImportResource("classpath:/META-INF/dependency-lookup-context.xml")
@Import(User.class)
@PropertySource("classpath:/META-INF/users-bean-definitions.properties") // java 8 + @Repeatable
@PropertySource("classpath:/META-INF/users-bean-definitions.properties")
public class AnnotatedSpringIoCContainerMetadataConfigurationDemo {

    /**
     * user.name 是 Java Properties 默认存在，当前用户： alisha， 而非 配置文件中定义的 "不才人"
     * @param id
     * @param name
     * @return
     */
    @Bean
    public User configuredUser(@Value("${user.id}") Long id, @Value("${user.name}") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册当前类作为 Configuration Class
        context.register(AnnotatedSpringIoCContainerMetadataConfigurationDemo.class);
        // 启动应用上下文
        context.refresh();

        // beanName 和 bean 映射
        Map<String, User> usersMap = context.getBeansOfType(User.class);

        for (Map.Entry<String, User> entry : usersMap.entrySet()) {
            System.out.printf("User Bean name : %s , content : %s \n", entry.getKey(), entry.getValue());
        }

        // 关闭应用上下文
        context.close();


    }
}
