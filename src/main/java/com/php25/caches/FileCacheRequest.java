package com.php25.caches;

import com.php25.tools.DigestUtils;
import com.php25.tools.FileUtils;

import java.io.*;
import java.net.CacheRequest;

/**
 * Created by jack on 2014/8/31.
 */
public class FileCacheRequest extends CacheRequest {
    private File cacheFile;
    private OutputStream out;


    public FileCacheRequest(String cachePath,String url) {
        try {
            String filePath = cachePath+"/"+DigestUtils.md5(url)+".1";
            this.cacheFile = new File(filePath);
            if(FileUtils.isFileExist(filePath)){
                out = new FileOutputStream(cacheFile,true);
            }else {

                out = new FileOutputStream(this.cacheFile);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    @Override
    public OutputStream getBody() throws IOException {
        return this.out;
    }


    public File getCacheFile() {
        return cacheFile;
    }

    @Override
    public void abort() {
        try {
            if(null != out) {
                out.close();
                out = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
