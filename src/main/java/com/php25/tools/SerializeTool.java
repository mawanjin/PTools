package com.php25.tools;

/**
 * Created by jack on 2014/9/1.
 */
public interface SerializeTool {
    /**
     * 反序列化文件生成java对象
     *
     * @param filePath
     * @return
     * @throws RuntimeException if an error occurs
     */
    public Object deserialization(String filePath);


    /**
     * 把java对象序列化进文件
     *
     * @param filePath
     * @param obj
     * @return
     * @throws RuntimeException if an error occurs
     */
    public void serialization(String filePath, Object obj);
}
