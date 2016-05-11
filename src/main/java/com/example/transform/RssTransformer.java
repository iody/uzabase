package com.example.transform;

/**
 * Created by johnlim on 9/5/16.
 */
public interface RssTransformer<K,V> {
    V transform(K source) throws Exception;
}
