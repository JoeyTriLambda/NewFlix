package com.comcast.viper.hlsparserj.v12;

import com.comcast.viper.hlsparserj.MediaPlaylist;
import com.comcast.viper.hlsparserj.PlaylistVersion;
import com.comcast.viper.hlsparserj.tags.UnparsedTag;
import java.util.List;

/* loaded from: classes.dex */
public class MediaPlaylistV12 extends MediaPlaylist {
    public MediaPlaylistV12(List<UnparsedTag> list) {
        super(PlaylistVersion.TWELVE, list);
    }
}
