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
 * Created by jack on 2014/8/31.
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
        FileCacheRequest request = new FileCacheRequest(cacheDir,uri.getRawPath());
        String headerPath = cacheDir+"/"+DigestUtils.md5(uri.getRawPath())+".0";
        if(FileUtils.isFileExist(headerPath)) {
            Map<String, List<String>> headers = ( Map<String, List<String>>)SerializeUtils.deserialization(headerPath);
            FileCacheResponse response = new FileCacheResponse(request,headers);
            if (response != null && response.isExpired()) { // check expiration date
                FileUtils.deleteFile(cacheDir+"/"+DigestUtils.md5(uri.getRawPath())+".0");
                FileUtils.deleteFile(cacheDir+"/"+DigestUtils.md5(uri.getRawPath())+".1");
                response = null;
            }
            return response;
        }else {
            return null;
        }
    }

    @Override
    public CacheRequest put(URI uri, URLConnection conn) throws IOException {
        //如果有Cache-control：no-cache标志，则不做缓存
        String cacheControl = conn.getHeaderField("Cache-Control");
        if (cacheControl != null && cacheControl.indexOf("no-cache") >= 0) {
            return null;
        }

        FileCacheRequest request = new FileCacheRequest(cacheDir,uri.getRawPath());
        FileCacheResponse response = new FileCacheResponse(request, conn);

        //保存response header
        String path = cacheDir+"/"+DigestUtils.md5(uri.getRawPath())+".0";
        SerializeUtils.serialization(path,response.getHeaders());

        return request;
    }
}
