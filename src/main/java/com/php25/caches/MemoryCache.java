package com.php25.caches;

import java.io.IOException;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jack on 2014/8/30.
 *
 * http response 内存缓存
 *
 */
public class MemoryCache extends ResponseCache{

    private Map<URI, MemoryCacheResponse> responses
            = new ConcurrentHashMap<URI, MemoryCacheResponse>();
    private int maxEntries = 100;
    public MemoryCache() {
        this(100);
    }
    public MemoryCache(int maxEntries) {
        this.maxEntries = maxEntries;
    }
    public CacheRequest put(URI uri, URLConnection uc)
            throws IOException {
        if (responses.size() >= maxEntries) return null;
        String cacheControl = uc.getHeaderField("Cache-Control");
        if (cacheControl != null && cacheControl.indexOf("no-cache") >= 0) {
            return null;
        }
        MemoryCacheRequest request = new MemoryCacheRequest();
        MemoryCacheResponse response = new MemoryCacheResponse(request, uc);
        responses.put(uri, response);
        return request;
    }
    public CacheResponse get(URI uri, String requestMethod,
                             Map<String,List<String>> requestHeaders)
            throws IOException {
        MemoryCacheResponse response = responses.get(uri);
        if (response != null && response.isExpired()) { // check expiration date
            responses.remove(response);
            response = null;
        }
        return response;
    }
}
