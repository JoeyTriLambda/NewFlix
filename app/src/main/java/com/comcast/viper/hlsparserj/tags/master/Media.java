package com.comcast.viper.hlsparserj.tags.master;

import com.comcast.viper.hlsparserj.tags.Tag;

/* loaded from: classes.dex */
public class Media extends Tag {
    private static final String ASSOCLANGUAGE = "ASSOC-LANGUAGE";
    private static final String AUTOSELECT = "AUTOSELECT";
    private static final String CHARACTERISTICS = "CHARACTERISTICS";
    private static final String DEFAULT = "DEFAULT";
    private static final String FORCED = "FORCED";
    private static final String GROUPID = "GROUP-ID";
    private static final String INSTREAMID = "INSTREAM-ID";
    private static final String LANGUAGE = "LANGUAGE";
    private static final String NAME = "NAME";
    private static final String TYPE = "TYPE";
    private static final String URI = "URI";

    public String getAssocLanguage() {
        return this.tag.getAttributes().get(ASSOCLANGUAGE);
    }

    public boolean getAutoSelect() {
        return yesNoBoolean(this.tag.getAttributes().get(AUTOSELECT));
    }

    public String getCharacteristics() {
        return this.tag.getAttributes().get(CHARACTERISTICS);
    }

    public boolean getDefault() {
        return yesNoBoolean(this.tag.getAttributes().get(DEFAULT));
    }

    public boolean getForced() {
        return yesNoBoolean(this.tag.getAttributes().get(FORCED));
    }

    public String getGroupId() {
        return this.tag.getAttributes().get(GROUPID);
    }

    public String getInstreamId() {
        return this.tag.getAttributes().get(INSTREAMID);
    }

    public String getLanguage() {
        return this.tag.getAttributes().get(LANGUAGE);
    }

    public String getName() {
        return this.tag.getAttributes().get(NAME);
    }

    public String getType() {
        return this.tag.getAttributes().get(TYPE);
    }

    public String getURI() {
        return this.tag.getAttributes().get(URI);
    }
}
