package com.example.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * not using this class, using customr transfromaer instead
 * Created by johnlim on 9/5/16.
 */
public class StringAdapter extends XmlAdapter<String,String> {
    @Override
    public String unmarshal(String v) throws Exception {
            return v;
    }

    @Override
    public String marshal(String v) throws Exception {

        /**
         * ok we dont want to use this as this is redundant already
         */
       // return v.replaceAll("NewsPick","");
        return v;
    }
}
