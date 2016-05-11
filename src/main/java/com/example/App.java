package com.example;

import com.example.processor.JAXBRssProcessor;
import com.example.processor.RssProcessor;

import java.util.Arrays;

/**
 * Created by johnlim on 10/5/16.
 */
public class App {
    public static void main(String[] args){
        new JAXBRssProcessor().process("http://tech.uzabase.com/rss");
    }
}
