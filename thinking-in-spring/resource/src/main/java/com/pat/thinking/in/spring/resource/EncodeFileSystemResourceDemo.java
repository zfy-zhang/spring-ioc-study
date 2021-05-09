package com.pat.thinking.in.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.StreamUtils;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 * @Description: 带有字符编码的 {@link FileSystemResource} 示例
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 *
 * @see FileSystemResource
 * @see  EncodedResource
 */
public class EncodeFileSystemResourceDemo {

    public static void main(String[] args) throws IOException {

        String currentJavaFilePath = System.getProperty("user.dir") + "/resource/src/main/java/com/pat/thinking/in/spring/resource/EncodeFileSystemResourceDemo.java";
        File currentJavaFile = new File(currentJavaFilePath);
        // FileSystemResource => WritableResource => Resource
        FileSystemResource fileSystemResource = new FileSystemResource(currentJavaFile);
        EncodedResource encodedResource = new EncodedResource(fileSystemResource, "UTF-8");
        // 字符输入流
        try(Reader reader = encodedResource.getReader()) {
            System.out.println(IOUtils.toString(reader));
        }
    }
}
