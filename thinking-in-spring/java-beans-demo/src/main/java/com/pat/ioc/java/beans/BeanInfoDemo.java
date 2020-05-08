package com.pat.ioc.java.beans;

import java.beans.*;
import java.util.stream.Stream;

/**
 * @Description
 * @Author 不才人
 * @Create Date 2020/5/1 10:21 下午
 * @Modify
 */
public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
//                    System.out.println(propertyDescriptor);

                    // PropertyDescriptor 允许添加谁能够编辑器 - PropertyEditor
                    // GUI -》 text(String) -> PropertyType
                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    if ("age".equals(propertyDescriptor)) { // 为 age 字段/属性增加 PropertyEditor
                        // String -> Integer
                        // Integer.valueOf("")
                        propertyDescriptor.setPropertyEditorClass(StringToIntegerProperEditor.class);
//                        propertyDescriptor.createPropertyEditor();
                    }
                });
    }

    static class StringToIntegerProperEditor extends PropertyEditorSupport {
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            setValue(text);
        }
    }
}
