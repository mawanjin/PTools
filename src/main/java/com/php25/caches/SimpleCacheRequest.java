package com.php25.caches;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;

/**
 * Created by jack on 2014/8/30.
 */
public class SimpleCacheRequest extends CacheRequest {
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Override
    public OutputStream getBody() throws IOException {
        return out;
    }

    @Override
    public void abort() {
        out = null;
    }
    public byte[] getData() {
        if (out == null) return null;
        else return out.toByteArray();
    }
}
