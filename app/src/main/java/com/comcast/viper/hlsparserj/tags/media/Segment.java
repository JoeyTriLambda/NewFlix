package com.comcast.viper.hlsparserj.tags.media;

import com.comcast.viper.hlsparserj.tags.Tag;

/* loaded from: classes.dex */
public abstract class Segment extends Tag {
    private String dateTime;
    private boolean discontinuity = false;
    private Key key;

    public String getDateTime() {
        return this.dateTime;
    }

    public boolean getDiscontinuity() {
        return this.discontinuity;
    }

    public Key getKey() {
        return this.key;
    }

    public String getURI() {
        return this.tag.getURI();
    }

    public void setDateTime(String str) {
        this.dateTime = str;
    }

    public void setDiscontinuity(boolean z10) {
        this.discontinuity = z10;
    }

    public void setKey(Key key) {
        this.key = key;
    }
}
