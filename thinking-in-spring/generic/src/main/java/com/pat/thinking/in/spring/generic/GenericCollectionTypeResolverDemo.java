package com.pat.thinking.in.spring.generic;

import org.springframework.core.GenericCollectionTypeResolver;

/**
 * @Description: {@link GenericCollectionTypeResolver}
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public class GenericCollectionTypeResolverDemo {

    public static void main(String[] args) {
        System.out.println(GenericCollectionTypeResolver.getCollectionType(StringList.class));
    }
}
