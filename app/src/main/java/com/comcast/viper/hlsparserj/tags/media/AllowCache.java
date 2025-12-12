package com.comcast.viper.hlsparserj.tags.media;

import com.comcast.viper.hlsparserj.tags.Tag;

/* loaded from: classes.dex */
public class AllowCache extends Tag {
    public boolean allowCache() {
        return yesNoBoolean(this.tag.getAttributes().get("NONAME0"));
    }
}
