package com.example.writer;

import java.io.File;
import java.io.OutputStream;

/**
 * Created by johnlim on 9/5/16.
 */
public interface RssWriter<V> {
    void write(V rss,OutputStream os)throws Exception;
    void write(V rs, File file) throws Exception;

}
