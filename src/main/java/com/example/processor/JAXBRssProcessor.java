package com.example.processor;

import com.example.reader.JAXBRssReader;
import com.example.transform.JAXBRssTransformer;
import com.example.writer.JAXBRssWriter;
import org.apache.log4j.Logger;
import com.example.core.Rss;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

/**
 * Created by johnlim on 9/5/16.
 */
public class JAXBRssProcessor extends RssProcessor{
    private static final Logger log = Logger.getLogger(JAXBRssProcessor.class);

    private static JAXBContext jaxbContext;

    private static JAXBContext getJAXBContext() {
        try {
            if (jaxbContext == null) {
                jaxbContext = JAXBContext.newInstance(Rss.class);
            }
        }catch (JAXBException jaxbe){
            log.error("Unable to initialize JAXBRssProcessor");
        }
        return jaxbContext;
    }

    public JAXBRssProcessor(){
       super( new JAXBRssReader(getJAXBContext()),
        new JAXBRssTransformer(getJAXBContext()),
        new JAXBRssWriter(getJAXBContext()));
    }

    @Override
    public void process(String... urls ){
        int i=0;
        for(String url: urls){
            try {
                Object rss = rssReader.read(url);
                rss=rssTransformer.transform(rss);
                rssWriter.write(rss,System.out); //write to console
                rssWriter.write(rss, new File("output-"+i+".xml")); // write to file
                i++;
            } catch (Exception e) {
                //ok we skip it, we dont want to screw up the batch
                log.warn("Exception occured while processing"+ url);
            }
        }
    }


}
