package com.php25.caches;

import com.php25.tools.DigestUtils;
import com.php25.tools.FileUtils;
import com.php25.tools.SerializeUtils;

import java.io.IOException;
import java.io.Serializable;
import java.net.*;
import java.util.List;
import java.util.Map;

/**
 *  http response 文件缓存，会根据http expires这个标识判断是否缓存过期，如果没有这个标识，则标识缓存永远不过期
 */
public class FileCache extends ResponseCache {
    private  long cacheSize;//10m
    private  String cacheDir;


    public FileCache(Long cacheSize,String cacheDir) {
        this.cacheDir = cacheDir;
        this.cacheSize = cacheSize;
    }

    @Override
    public CacheResponse get(URI uri, String rqstMethod, Map<String, List<String>> rqstHeaders) throws IOException {
        FileCacheRequest request = new FileCacheRequest(cacheDir,uri.toString());
        FileCacheResponse response = CacheResponseFactory.getFileCacheResponse(request,cacheDir,uri);
        if (null != response && response.isExpired()) { // check expiration date
            FileUtils.deleteFile(cacheDir+"/"+DigestUtils.md5(uri.toString())+".0");
            FileUtils.deleteFile(cacheDir+"/"+DigestUtils.md5(uri.toString())+".1");
            response = null;
        }
        return response;

    }

    @Override
    public CacheRequest put(URI uri, URLConnection conn) throws IOException {
        //如果有Cache-control：no-cache标志，则不做缓存
        String cacheControl = conn.getHeaderField("Cache-Control");
        if (cacheControl != null && cacheControl.indexOf("no-cache") >= 0) {
            return null;
        }

        FileCacheRequest request = new FileCacheRequest(cacheDir,uri.toString());
        FileCacheResponse response = new FileCacheResponse(request, conn);
        CacheResponseFactory.saveFileCacheResponse(response,cacheDir,uri);

        return request;
    }
}
