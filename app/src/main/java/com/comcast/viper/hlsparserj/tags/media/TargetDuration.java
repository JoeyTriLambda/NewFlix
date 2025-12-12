package com.comcast.viper.hlsparserj.tags.media;

import com.comcast.viper.hlsparserj.tags.Tag;

/* loaded from: classes.dex */
public class TargetDuration extends Tag {
    public int getDuration() {
        return Integer.valueOf(this.tag.getAttributes().get("NONAME0")).intValue();
    }
}
