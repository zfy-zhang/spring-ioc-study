package com.pat.thinking.in.spring.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public class GenericAPIDemo {

    public static void main(String[] args) {

        // 原生类型 primitive types ： int long float
        Class intClass = int.class;

        // 数组类型 array types ： int[],Object[]
        Class objectArrayClass = Object[].class;

        // 原始类型 row types ： java.lang.String
        Class rowClass = String.class;

        ParameterizedType parameterizedType = (ParameterizedType) ArrayList.class.getGenericSuperclass();

        System.out.println(parameterizedType.toString());

        Type[] typeArguments = parameterizedType.getActualTypeArguments();

        Stream.of(typeArguments)
                .map(TypeVariable.class::cast)
                .forEach(System.out::println);
    }
}
