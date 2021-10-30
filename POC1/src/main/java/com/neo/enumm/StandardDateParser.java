package com.neo.enumm;
import java.text.SimpleDateFormat;

public enum StandardDateParser {
    YYYY_MM_DD(new SimpleDateFormat("yyyy-MM-dd"), "yyyy-MM-dd"),
    YYYYMMDD(new SimpleDateFormat("yyyyMMdd"), "yyyyMMdd"),
    YYYY_MM_DD_HH_MM_SS(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss"),
    YYYY_MM_DDTHH_MM_SSZ(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"), "yyyy-MM-dd'T'HH:mm:ssZ");

    SimpleDateFormat parser;
    private String displayName;

    StandardDateParser(SimpleDateFormat parser, String displayName) {
        this.parser = parser;
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

    public SimpleDateFormat getParser() {
        return this.parser;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}