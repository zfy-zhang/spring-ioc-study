package com.pat.thinking.in.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 * @Description: 带有字符编码的 {@link FileSystemResourceLoader} 示例
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 *
 * @see FileSystemResourceLoader
 * @see FileSystemResource
 * @see  EncodedResource
 */
public class EncodeFileSystemResourceLoaderDemo {

    public static void main(String[] args) throws IOException {

        String currentJavaFilePath = System.getProperty("/" + "user.dir") + "/resource/src/main/java/com/pat/thinking/in/spring/resource/EncodeFileSystemResourceLoaderDemo.java";

        FileSystemResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();

        // FileSystemResource => WritableResource => Resource
        Resource resource = fileSystemResourceLoader.getResource(currentJavaFilePath);
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        // 字符输入流
        try(Reader reader = encodedResource.getReader()) {
            System.out.println(IOUtils.toString(reader));
        }

    }
}
