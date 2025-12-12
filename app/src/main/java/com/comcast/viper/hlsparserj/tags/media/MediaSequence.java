package com.comcast.viper.hlsparserj.tags.media;

import com.comcast.viper.hlsparserj.tags.Tag;

/* loaded from: classes.dex */
public class MediaSequence extends Tag {
    public int getSequenceNumber() {
        return Integer.valueOf(this.tag.getAttributes().get("NONAME0")).intValue();
    }
}
