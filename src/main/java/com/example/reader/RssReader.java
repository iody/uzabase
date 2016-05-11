package com.example.reader;

/**
 * Created by johnlim on 9/5/16.
 */
public interface RssReader<K> {
    K read(String url) throws Exception;
}
