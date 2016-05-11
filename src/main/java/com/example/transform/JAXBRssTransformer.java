package com.example.transform;

import com.example.core.Rss;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * ok im not  using jaxb adapter using manual to transform the string
 *
 * Created by johnlim on 9/5/16.
 */
public class JAXBRssTransformer implements RssTransformer<Rss,Rss> {
    private JAXBContext jaxbContext;
    private String excludeWord="NewsPicks"; //default it

    public JAXBRssTransformer(JAXBContext jaxbContext){
        this.jaxbContext=jaxbContext;
    }

    @Override
    public Rss transform(Rss rss) throws JAXBException{
        /**
         * do your transformation stuffs here..
         */
        StringWriter writer = new StringWriter();
        jaxbContext.createMarshaller().marshal(rss,writer);
        String str = writer.toString();
        str = str.replaceAll(getExcludeWord(), "");
        return  (Rss)jaxbContext.createUnmarshaller().unmarshal(new StringReader(str));
    }

    public String getExcludeWord() {
        return excludeWord;
    }

    public void setExcludeWord(String excludeWord) {
        this.excludeWord = excludeWord;
    }
}
