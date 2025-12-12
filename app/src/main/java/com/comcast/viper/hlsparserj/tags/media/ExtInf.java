package com.comcast.viper.hlsparserj.tags.media;

/* loaded from: classes.dex */
public class ExtInf extends Segment {
    public float getDuration() {
        return Float.valueOf(this.tag.getAttributes().get("NONAME0")).floatValue();
    }

    public String getTitle() {
        return this.tag.getAttributes().get("NONAME1");
    }
}
