package com.pat.thinking.in.spring.conversion;

import com.pat.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * @Description: 自定义 {@link PropertyEditorRegistrar} 实现
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @see PropertyEditorRegistrar
 * @since
 */
public class CustomizedPropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {

        // 1、通用类型转化

        // 2、Java Bean 属性类型转换
        registry.registerCustomEditor(User.class, "context", new StringToPropertiesPropertyEditor());

    }
}
