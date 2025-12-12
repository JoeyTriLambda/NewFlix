package com.comcast.viper.hlsparserj.tags.media;

import com.comcast.viper.hlsparserj.tags.Tag;

/* loaded from: classes.dex */
public class Key extends Tag {
    private static final String IV = "IV";
    private static final String KEYFORMAT = "KEYFORMAT";
    private static final String KEYFORMATVERSIONS = "KEYFORMATVERSIONS";
    private static final String METHOD = "METHOD";
    private static final String URI = "URI";

    public String getIV() {
        return this.tag.getAttributes().get(IV);
    }

    public String getKeyFormat() {
        return this.tag.getAttributes().get(KEYFORMAT);
    }

    public String getKeyFormatVersions() {
        return this.tag.getAttributes().get(KEYFORMATVERSIONS);
    }

    public String getMethod() {
        return this.tag.getAttributes().get(METHOD);
    }

    public String getURI() {
        return this.tag.getAttributes().get(URI);
    }
}
