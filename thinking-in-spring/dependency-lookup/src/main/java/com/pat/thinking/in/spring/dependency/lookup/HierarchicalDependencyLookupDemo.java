package com.pat.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: 层次性依赖查找实例
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/8/31
 * @Modify
 * @since
 */
public class HierarchicalDependencyLookupDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将 AnnotationApplicationContextAsIocContainerDemo 作为配置类（Configuration Class）
        applicationContext.register(HierarchicalDependencyLookupDemo.class);

        // 1. 获取 HierarchicalBeanFactory <- ConfigurableBeanFactory <- ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        System.out.println("当前 BeanFactory 的 Parent BeanFactory ： " + beanFactory.getParentBeanFactory());

        // 2. 设置 Parent BeanFactory
        HierarchicalBeanFactory parentBeanFactory = createParentBeanFactory();
        beanFactory.setParentBeanFactory(createParentBeanFactory());
        System.out.println("当前 BeanFactory 的 Parent BeanFactory ： " + beanFactory.getParentBeanFactory());


        // 启动应用上下文
        applicationContext.refresh();

        displayContainsLocalBean(beanFactory, "user");
        displayContainsLocalBean(parentBeanFactory, "user");
        displayContainsBean(beanFactory, "user");
        displayContainsBean(parentBeanFactory, "user");


        // 关闭上下文
        applicationContext.close();
    }

    private static void displayContainsBean(HierarchicalBeanFactory beanFactory, String beanName) {
        System.out.printf("当前 BeanFactory[%s] 是否包含 bean[name : %s] : %s\n", beanFactory, beanName, beanFactory.containsBean(beanName));
    }

    /**
     *
     * @param beanFactory
     * @param beanName
     * @return
     */
    private static boolean containsBean(HierarchicalBeanFactory beanFactory, String beanName) {
        BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
        if (parentBeanFactory instanceof  HierarchicalBeanFactory) {
            HierarchicalBeanFactory parentHierarchicalBeanFactory = HierarchicalBeanFactory.class.cast(parentBeanFactory);
            if(containsBean(parentHierarchicalBeanFactory, beanName)) {
                return true;
            }
        }
        return beanFactory.containsBean(beanName);
    }

    private static void displayContainsLocalBean(HierarchicalBeanFactory beanFactory, String beanName) {
        System.out.printf("当前 BeanFactory[%s] 是否包含 bean[name : %s] : %s\n", beanFactory, beanName, beanFactory.containsLocalBean(beanName));
    }

    /**
     *
     * @return
     */
    private static HierarchicalBeanFactory createParentBeanFactory() {
        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        String location = "META-INF/dependency-lookup-context.xml";
        // 加载配置
        reader.loadBeanDefinitions(location);
        return beanFactory;
    }
}
