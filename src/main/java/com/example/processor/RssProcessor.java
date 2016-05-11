package com.example.processor;

import com.example.core.Rss;
import com.example.reader.RssReader;
import com.example.transform.RssTransformer;
import com.example.writer.RssWriter;

/**
 * Created by johnlim on 9/5/16.
 */
public abstract class RssProcessor {
   protected RssReader rssReader;
   protected RssTransformer rssTransformer;
   protected RssWriter rssWriter;

   public RssProcessor(RssReader rssReader, RssTransformer rssTransformer,RssWriter rssWriter){
      this.rssReader=rssReader;
      this.rssTransformer= rssTransformer;
      this.rssWriter=rssWriter;
   }

   public abstract  void process(String... urls);
}
