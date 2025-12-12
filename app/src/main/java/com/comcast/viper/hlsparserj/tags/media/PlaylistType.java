package com.comcast.viper.hlsparserj.tags.media;

import com.comcast.viper.hlsparserj.tags.Tag;

/* loaded from: classes.dex */
public class PlaylistType extends Tag {
    public String getType() {
        return this.tag.getAttributes().get("NONAME0");
    }
}
