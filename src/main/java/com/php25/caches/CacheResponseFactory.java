package com.php25.caches;

import com.php25.tools.DigestUtils;
import com.php25.tools.FileUtils;
import com.php25.tools.SerializeUtils;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * Created with penghuiping
 * User: penghuiping
 * Date: 14-9-1
 * Time: 上午11:13
 * To change this template use File | Settings | File Templates.
 */
public class CacheResponseFactory {
    public static FileCacheResponse getFileCacheResponse (FileCacheRequest request,String cacheDir,URI uri) {
        String headerFilePath = cacheDir+"/"+ DigestUtils.md5(uri.toString())+".0";
        if(FileUtils.isFileExist(headerFilePath)) {
            Map<String,List<String>> headers = (Map<String,List<String>>)SerializeUtils.deserialization(headerFilePath);
            return new FileCacheResponse(request,headers);
        }else {
            return null;
        }
    }

    public static void saveFileCacheResponse(FileCacheResponse response,String cacheDir,URI uri) {
        try {
            String headerFilePath = cacheDir+"/"+ DigestUtils.md5(uri.toString())+".0";
            SerializeUtils.serialization(headerFilePath,response.getHeaders());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
