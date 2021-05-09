package com.pat.thinking.in.spring.conversion;

import java.beans.PropertyEditor;

/**
 * @Description: {@link PropertyEditor} 示例
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @see PropertyEditor
 * @since
 */
public class PropertyEditorDemo {

    public static void main(String[] args) {
        String text = "name = 风尘";

        PropertyEditor propertyEditor = new StringToPropertiesPropertyEditor();

        propertyEditor.setAsText(text);
        System.out.println(propertyEditor.getValue());

        System.out.println(propertyEditor.getAsText());
    }
}
