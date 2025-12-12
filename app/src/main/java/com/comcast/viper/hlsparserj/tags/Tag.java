package com.comcast.viper.hlsparserj.tags;

/* loaded from: classes.dex */
public abstract class Tag {
    protected static final String UNNAMEDATTR0 = "NONAME0";
    protected static final String UNNAMEDATTR1 = "NONAME1";
    protected UnparsedTag tag;

    public UnparsedTag getTag() {
        return this.tag;
    }

    public void setTag(UnparsedTag unparsedTag) {
        this.tag = unparsedTag;
    }

    public boolean yesNoBoolean(String str) {
        return "yes".equalsIgnoreCase(str);
    }
}
