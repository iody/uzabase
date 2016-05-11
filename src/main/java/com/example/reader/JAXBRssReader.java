package com.example.reader;

import com.example.core.Rss;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by johnlim on 9/5/16.
 */
public class JAXBRssReader implements RssReader<Rss>{

    private JAXBContext jaxbContext;
    public JAXBRssReader(JAXBContext jaxbContext){
        this.jaxbContext=jaxbContext;
    }


    public Rss read(String url) throws JAXBException,MalformedURLException{
        Unmarshaller unmarshaller =jaxbContext.createUnmarshaller();
        Rss rss= (Rss)unmarshaller.unmarshal(new URL(url));
        return rss;
    }


}
