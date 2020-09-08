package com.pat.thinking.in.spring.bean.lifecycle;

import com.pat.thinking.in.spring.ioc.overview.domain.SuperUser;
import com.pat.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/7
 * @Modify
 * @since
 */
class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("superUser", beanName) && SuperUser.class.equals(beanClass)) {
            // 把配置完成的 SuperUser Bean 覆盖
            return new SuperUser();
        }
        return null; // 保持 Spring IOC 容器实例化
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("user", beanName) && User.class.equals(bean.getClass())) {
            User user = (User) bean;
            user.setId(7L);
            user.setName("不负青云");
            // "user" 对象不允许属性赋值（配置元信息 -> 属性值）
            return false;
        }
        return true;
    }

    // user 是跳过 Bean 属性赋值（填入）
    // superUser 也是完全跳过 Bean 实例化（Bean 属性赋值填入）
    // userHolder
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansException {
        // 对 UserHolder 进行拦截
        if (ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())) {
            // 假设 <property name="number" value="1"/> 配置的话，那么在 PropertyValues 就包含 PropertyValue（number=1）
            final MutablePropertyValues propertyValues;
            if (pvs instanceof MutablePropertyValues) {
                propertyValues = (MutablePropertyValues) pvs;
            } else {
                propertyValues = new MutablePropertyValues();
            }
            propertyValues.addPropertyValue("number", 1);
            // <property name="description" value="The user Holder"/> 原始配置

            // 如果存在 description
            if (propertyValues.contains("description")) {
                // PropertyValue 值是不可变的
//                    PropertyValue propertyValue = (PropertyValue) propertyValues.get("description");
                propertyValues.removePropertyValue("description");
                propertyValues.addPropertyValue("description", "The user Holder v2");
            }
            return propertyValues;
        }
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())) {
            UserHolder userHolder = (UserHolder) bean;
//            UserHolder description = The user Holder v2
            userHolder.setDescription("The user Holder v3");
            return userHolder;
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())) {
            UserHolder userHolder = (UserHolder) bean;
//            UserHolder description = The user Holder v2
            userHolder.setDescription("The user Holder v7");
            return userHolder;
        }
        return bean;
    }
}
