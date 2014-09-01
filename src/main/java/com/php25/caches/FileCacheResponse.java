package com.php25.caches;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheResponse;
import java.net.URLConnection;
import java.util.*;

/**
 * Created by jack on 2014/8/31.
 */
public class FileCacheResponse extends CacheResponse {
    private FileCacheRequest request;
    private Date expires;
    private Map<String,List<String>> headers;

    public FileCacheResponse(FileCacheRequest request,URLConnection uc) {
        this.request = request;

        Map<String,List<String>> headers = new HashMap<String,List<String>>();
        String value = "";
        for (int i = 0;; i++) {
            String name = uc.getHeaderFieldKey(i);
            value = uc.getHeaderField(i);
            if (value == null) break;
            List<String> values = headers.get(name);
            if (values == null) {
                values = new ArrayList<String>(1);
                headers.put(name, values);
            }
            values.add(value);
        }
        long expiration = uc.getExpiration();
        if (expiration != 0) {
            this.expires = new Date(expiration);
        }
        this.headers = Collections.unmodifiableMap(headers);
    }

    public FileCacheResponse(FileCacheRequest request, Map<String,List<String>> headers) {
        this.request = request;
        this.headers = Collections.unmodifiableMap(headers);
        if(headers.containsKey("Expires"))  {
            this.expires = new Date((String)headers.get("Expires").get(0));
        }
    }


    @Override
    public Map<String, List<String>> getHeaders() throws IOException {
        return headers;
    }

    @Override
    public InputStream getBody() throws IOException {
        File file = request.getCacheFile();
        return new FileInputStream(file);
    }

    public boolean isExpired() {
        if (expires == null) return false;
        else {
            Date now = new Date();
            return expires.before(now);
        }
    }
}
