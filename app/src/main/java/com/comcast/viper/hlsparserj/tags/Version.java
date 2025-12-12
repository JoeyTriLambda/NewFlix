package com.comcast.viper.hlsparserj.tags;

/* loaded from: classes.dex */
public class Version extends Tag {
    public int getVersion() {
        return Integer.valueOf(this.tag.getAttributes().get("NONAME0")).intValue();
    }
}
