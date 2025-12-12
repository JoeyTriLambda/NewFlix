package com.comcast.viper.hlsparserj.tags;

import com.comcast.viper.hlsparserj.tags.master.IFrameStreamInf;
import com.comcast.viper.hlsparserj.tags.master.Media;
import com.comcast.viper.hlsparserj.tags.master.StreamInf;
import com.comcast.viper.hlsparserj.tags.media.AllowCache;
import com.comcast.viper.hlsparserj.tags.media.ByteRange;
import com.comcast.viper.hlsparserj.tags.media.ExtInf;
import com.comcast.viper.hlsparserj.tags.media.IFramesOnly;
import com.comcast.viper.hlsparserj.tags.media.Key;
import com.comcast.viper.hlsparserj.tags.media.MediaSequence;
import com.comcast.viper.hlsparserj.tags.media.PlaylistType;
import com.comcast.viper.hlsparserj.tags.media.TargetDuration;

/* loaded from: classes.dex */
public class TagNames {
    public static final String EXTINF = "EXTINF";
    public static final String EXTXALLOWCACHE = "EXT-X-ALLOW-CACHE";
    public static final String EXTXBYTERANGE = "EXT-X-BYTERANGE";
    public static final String EXTXDISCONTINUITY = "EXT-X-DISCONTINUITY";
    public static final String EXTXIFRAMESONLY = "EXT-X-I-FRAMES-ONLY";
    public static final String EXTXIFRAMESSTREAMINF = "EXT-X-I-FRAME-STREAM-INF";
    public static final String EXTXKEY = "EXT-X-KEY";
    public static final String EXTXMEDIA = "EXT-X-MEDIA";
    public static final String EXTXMEDIASEQUENCE = "EXT-X-MEDIA-SEQUENCE";
    public static final String EXTXPLAYLISTTYPE = "EXT-X-PLAYLIST-TYPE";
    public static final String EXTXPROGRAMDATETIME = "EXT-X-PROGRAM-DATE-TIME";
    public static final String EXTXSTREAMINF = "EXT-X-STREAM-INF";
    public static final String EXTXTARGETDURATION = "EXT-X-TARGETDURATION";
    public static final String EXTXVERSION = "EXT-X-VERSION";

    static {
        TagFactory.registerTag("EXT-X-VERSION", Version.class);
        TagFactory.registerTag(EXTXSTREAMINF, StreamInf.class);
        TagFactory.registerTag(EXTXMEDIA, Media.class);
        TagFactory.registerTag(EXTINF, ExtInf.class);
        TagFactory.registerTag(EXTXBYTERANGE, ByteRange.class);
        TagFactory.registerTag(EXTXTARGETDURATION, TargetDuration.class);
        TagFactory.registerTag(EXTXMEDIASEQUENCE, MediaSequence.class);
        TagFactory.registerTag(EXTXKEY, Key.class);
        TagFactory.registerTag(EXTXALLOWCACHE, AllowCache.class);
        TagFactory.registerTag(EXTXPLAYLISTTYPE, PlaylistType.class);
        TagFactory.registerTag(EXTXIFRAMESONLY, IFramesOnly.class);
        TagFactory.registerTag(EXTXIFRAMESSTREAMINF, IFrameStreamInf.class);
    }
}
