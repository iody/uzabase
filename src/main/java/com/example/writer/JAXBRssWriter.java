package com.example.writer;

import com.example.core.Rss;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.OutputStream;

/**
 * Created by johnlim on 9/5/16.
 */
public class JAXBRssWriter implements RssWriter<Rss> {

    private JAXBContext jaxbContext;

    public JAXBRssWriter(JAXBContext jaxbContext) {
        this.jaxbContext=jaxbContext;
    }

    public void write(Rss rss, OutputStream os)throws Exception {
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(rss, os);
    }

    public void write(Rss rss,File file) throws Exception{
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(rss, file);
    }
}
