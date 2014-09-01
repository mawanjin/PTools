package com.php25.tools;

import com.php25.tools.impl.StringToolImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 2014/9/1.
 */
public interface FileTool {

    /**
     * 读取文件内容
     *
     * @param filePath
     * @param charsetName
     * @return 文件内容，如果文件不存在返回null
     * @throws java.lang.RuntimeException
     */
    public StringBuilder readFile(String filePath, String charsetName);

    /**
     * 写入文件操作
     *
     * @param filePath 写入文件路径
     * @param content  写入的内容
     * @param append   是否在文件末尾追加
     * @return 写入成功返回true, 如果写入内容为null或者""返回false
     * @throws java.lang.RuntimeException
     */
    public boolean writeFile(String filePath, String content, boolean append);

    /**
     * 写入文件操作
     *
     * @param filePath    写入文件路径
     * @param contentList 写入的内容
     * @param append      是否在文件末尾追加
     * @return 写入成功返回true, 如果写入内容为null或者""返回false
     * @throws java.lang.RuntimeException
     */
    public boolean writeFile(String filePath, List<String> contentList, boolean append);

    /**
     * 写入文件操作，从文件起始位置开始写入
     *
     * @param filePath
     * @param content
     * @return 写入成功返回true, 如果写入内容为null或者""返回false
     * @throws java.lang.RuntimeException
     */
    public boolean writeFile(String filePath, String content);

    /**
     * 写入文件操作，从文件起始位置开始写入
     *
     * @param filePath
     * @param contentList
     * @return 写入成功返回true, 如果写入内容为null或者""返回false
     * @throws java.lang.RuntimeException
     */
    public boolean writeFile(String filePath, List<String> contentList);

    /**
     * 写入文件操作，从文件起始位置开始写入
     *
     * @param filePath
     * @param stream
     * @return 写入文件成功返回true
     * @throws java.lang.RuntimeException
     */
    public boolean writeFile(String filePath, InputStream stream);

    /**
     * 写入文件操作
     *
     * @param filePath
     * @param stream
     * @param append   是否在文件末尾追加写入
     * @return 写入文件成功返回true
     * @throws java.lang.RuntimeException
     */
    public  boolean writeFile(String filePath, InputStream stream, boolean append);

    /**
     * 写入文件操作，从文件头开始写入
     *
     * @param file
     * @param stream
     * @return 写入成功返回true
     * @throws java.lang.RuntimeException
     */
    public  boolean writeFile(File file, InputStream stream);

    /**
     * 写入文件操作
     *
     * @param file
     * @param stream
     * @param append
     * @return 写入成功返回true
     * @throws java.lang.RuntimeException
     */
    public  boolean writeFile(File file, InputStream stream, boolean append);

    /**
     * 复制文件
     *
     * @param sourceFilePath
     * @param destFilePath
     * @return
     * @throws RuntimeException if an error occurs while operator FileOutputStream
     */
    public boolean copyFile(String sourceFilePath, String destFilePath);

    /**
     * 读取文件，以list方式返回
     *
     * @param filePath
     * @param charsetName The name of a supported {@link java.nio.charset.Charset </code>charset<code>}
     * @return if file not exist, return null, else return content of file
     * @throws RuntimeException if an error occurs while operator BufferedReader
     */
    public List<String> readFileToList(String filePath, String charsetName);

    /**
     * 获取文件名，去除后缀
     * <p>
     * <pre>
     *      getFileNameWithoutExtension(null)               =   null
     *      getFileNameWithoutExtension("")                 =   ""
     *      getFileNameWithoutExtension("   ")              =   "   "
     *      getFileNameWithoutExtension("abc")              =   "abc"
     *      getFileNameWithoutExtension("a.mp3")            =   "a"
     *      getFileNameWithoutExtension("a.b.rmvb")         =   "a.b"
     *      getFileNameWithoutExtension("c:\\")              =   ""
     *      getFileNameWithoutExtension("c:\\a")             =   "a"
     *      getFileNameWithoutExtension("c:\\a.b")           =   "a"
     *      getFileNameWithoutExtension("c:a.txt\\a")        =   "a"
     *      getFileNameWithoutExtension("/home/admin")      =   "admin"
     *      getFileNameWithoutExtension("/home/admin/a.txt/b.mp3")  =   "b"
     * </pre>
     *
     * @param filePath
     * @return file name from path, not include suffix
     * @see
     */
    public String getFileNameWithoutExtension(String filePath);
    /**
     * 获取文件名
     * <p>
     * <pre>
     *      getFileName(null)               =   null
     *      getFileName("")                 =   ""
     *      getFileName("   ")              =   "   "
     *      getFileName("a.mp3")            =   "a.mp3"
     *      getFileName("a.b.rmvb")         =   "a.b.rmvb"
     *      getFileName("abc")              =   "abc"
     *      getFileName("c:\\")              =   ""
     *      getFileName("c:\\a")             =   "a"
     *      getFileName("c:\\a.b")           =   "a.b"
     *      getFileName("c:a.txt\\a")        =   "a"
     *      getFileName("/home/admin")      =   "admin"
     *      getFileName("/home/admin/a.txt/b.mp3")  =   "b.mp3"
     * </pre>
     *
     * @param filePath
     * @return file name from path, include suffix
     */
    public String getFileName(String filePath);

    /**
     * 获取文件所在的路径
     * <p>
     * <pre>
     *      getFolderName(null)               =   null
     *      getFolderName("")                 =   ""
     *      getFolderName("   ")              =   ""
     *      getFolderName("a.mp3")            =   ""
     *      getFolderName("a.b.rmvb")         =   ""
     *      getFolderName("abc")              =   ""
     *      getFolderName("c:\\")              =   "c:"
     *      getFolderName("c:\\a")             =   "c:"
     *      getFolderName("c:\\a.b")           =   "c:"
     *      getFolderName("c:a.txt\\a")        =   "c:a.txt"
     *      getFolderName("c:a\\b\\c\\d.txt")    =   "c:a\\b\\c"
     *      getFolderName("/home/admin")      =   "/home"
     *      getFolderName("/home/admin/a.txt/b.mp3")  =   "/home/admin/a.txt"
     * </pre>
     *
     * @param filePath
     * @return
     */
    public String getFolderName(String filePath);

    /**
     * 获取文件的后缀名
     * <p>
     * <pre>
     *      getFileExtension(null)               =   ""
     *      getFileExtension("")                 =   ""
     *      getFileExtension("   ")              =   "   "
     *      getFileExtension("a.mp3")            =   "mp3"
     *      getFileExtension("a.b.rmvb")         =   "rmvb"
     *      getFileExtension("abc")              =   ""
     *      getFileExtension("c:\\")              =   ""
     *      getFileExtension("c:\\a")             =   ""
     *      getFileExtension("c:\\a.b")           =   "b"
     *      getFileExtension("c:a.txt\\a")        =   ""
     *      getFileExtension("/home/admin")      =   ""
     *      getFileExtension("/home/admin/a.txt/b")  =   ""
     *      getFileExtension("/home/admin/a.txt/b.mp3")  =   "mp3"
     * </pre>
     *
     * @param filePath
     * @return
     */
    public String getFileExtension(String filePath);

    /**
     * 创建文件夹
     *
     * @param filePath
     * @return 如果创建成功返回true, 如果文件夹已存在，也返回true
     */
    public boolean makeDirs(String filePath);
    /**
     * @param filePath
     * @return
     * @see #makeDirs(String)
     */
    public boolean makeFolders(String filePath);

    /**
     * 判断文件是否存在
     *
     * @param filePath
     * @return
     */
    public boolean isFileExist(String filePath);

    /**
     * 判断文件夹是否存在
     *
     * @param directoryPath
     * @return
     */
    public boolean isFolderExist(String directoryPath);

    /**
     * 删除文件或者文件夹
     * <ul>
     * <li>if path is null or empty, return true</li>
     * <li>if path not exist, return true</li>
     * <li>if path exist, delete recursion. return true</li>
     * <ul>
     *
     * @param path
     * @return
     */
    public boolean deleteFile(String path);

    /**
     * 获取文件大小
     * <ul>
     * <li>if path is null or empty, return -1</li>
     * <li>if path exist and it is a file, return file size, else return -1</li>
     * <ul>
     *
     * @param path
     * @return returns the length of this file in bytes. returns -1 if the file does not exist.
     */
    public long getFileSize(String path);
}
