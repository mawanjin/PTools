package com.php25.caches;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheResponse;
import java.net.URLConnection;
import java.util.*;

/**
 * Created by jack on 2014/8/30.
 */
public class MemoryCacheResponse extends CacheResponse {
    private Map<String,List<String>> headers;
    private MemoryCacheRequest request;
    private Date expires;
    public MemoryCacheResponse(MemoryCacheRequest request, URLConnection uc)
            throws IOException {
        this.request = request;
        // deliberate shadowing; we need to fill the map and
        // then make it unmodifiable
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
    public InputStream getBody() {
        return new ByteArrayInputStream(request.getData());
    }

    public Map<String,List<String>> getHeaders()
            throws IOException {
        return headers;
    }
    public boolean isExpired() {
        if (expires == null) return false;
        else {
            Date now = new Date();
            return expires.before(now);
        }
    }
}