package com.pat.thinking.in.spring.generic;

import org.springframework.core.GenericTypeResolver;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.core.GenericTypeResolver.resolveReturnTypeArgument;

/**
 * @Description: {@link GenericTypeResolver} 示例
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 * @see GenericTypeResolver
 */
public class GenericTypeResolverDemo {

    public static void main(String[] args) throws NoSuchMethodException {

        // String Comparable<String> 具体化
        displayReturnTypeGenericInfo(GenericTypeResolverDemo.class,Comparable.class, "getString");

        // ArrayList<Object> 是 List 泛型参数类型的具体化
        displayReturnTypeGenericInfo(GenericTypeResolverDemo.class,List.class, "getList");

        // StringList 也是 List 泛型参数类型的具体化
        displayReturnTypeGenericInfo(GenericTypeResolverDemo.class,List.class, "getStringList");

        // 具备 ParameterizedType 返回， 否则 null

        // TypeVariable
        Map<TypeVariable, Type> typeVariableMap = GenericTypeResolver.getTypeVariableMap(StringList.class);

        System.out.println(typeVariableMap);

    }

    public static StringList getStringList() {
        return null;
    }

    public static ArrayList<Object> getList() {
        return null;
    }

    public static String getString() {
        return null;
    }

    private static void displayReturnTypeGenericInfo(Class<?> containingClass, Class<?> genericIfc, String methodName, Class... argumentTypes) throws NoSuchMethodException {
        Method method = containingClass.getMethod(methodName, argumentTypes);
        Class<?> returnType = GenericTypeResolver.resolveReturnType(method, containingClass);

        // 常规类作为方法值返回
        System.out.printf(" GenericTypeResolver.resolveReturnType(%s, %s) = %s\n", methodName, containingClass.getSimpleName(), returnType);

        // 常规类不具备泛型类型 List<E>
        Class<?> typeArgument = resolveReturnTypeArgument(method, genericIfc);
        System.out.printf(" GenericTypeResolver.resolveReturnTypeArgument(%s, %s) = %s\n", methodName, containingClass.getSimpleName(), typeArgument);
    }

}
