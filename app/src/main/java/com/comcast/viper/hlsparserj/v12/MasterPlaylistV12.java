package com.comcast.viper.hlsparserj.v12;

import com.comcast.viper.hlsparserj.MasterPlaylist;
import com.comcast.viper.hlsparserj.PlaylistVersion;
import com.comcast.viper.hlsparserj.tags.UnparsedTag;
import java.util.List;

/* loaded from: classes.dex */
public class MasterPlaylistV12 extends MasterPlaylist {
    public MasterPlaylistV12(List<UnparsedTag> list) {
        super(PlaylistVersion.TWELVE, list);
    }
}
