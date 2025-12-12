package com.comcast.viper.hlsparserj;

import com.comcast.viper.hlsparserj.tags.UnparsedTag;
import com.comcast.viper.hlsparserj.tags.Version;
import java.util.List;

/* loaded from: classes.dex */
public interface IPlaylist {
    List<UnparsedTag> getTags();

    Version getVersion();

    boolean isMasterPlaylist();
}
