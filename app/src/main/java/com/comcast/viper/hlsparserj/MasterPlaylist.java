package com.comcast.viper.hlsparserj;

import com.comcast.viper.hlsparserj.tags.TagNames;
import com.comcast.viper.hlsparserj.tags.UnparsedTag;
import com.comcast.viper.hlsparserj.tags.master.IFrameStreamInf;
import com.comcast.viper.hlsparserj.tags.master.Media;
import com.comcast.viper.hlsparserj.tags.master.StreamInf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class MasterPlaylist extends AbstractPlaylist {
    public MasterPlaylist(PlaylistVersion playlistVersion, List<UnparsedTag> list) {
        super(playlistVersion, list);
    }

    public List<Media> getAlternateRenditions() {
        return getTagList(TagNames.EXTXMEDIA);
    }

    public List<IFrameStreamInf> getIFrameStreams() {
        return getTagList(TagNames.EXTXIFRAMESSTREAMINF);
    }

    public List<StreamInf> getVariantStreams() {
        return getTagList(TagNames.EXTXSTREAMINF);
    }

    @Override // com.comcast.viper.hlsparserj.AbstractPlaylist, com.comcast.viper.hlsparserj.IPlaylist
    public boolean isMasterPlaylist() {
        return true;
    }

    public void keepVariantStreamClosestToBitrate(int i10) {
        StreamInf streamInfVariantStreamClosestToBitrate = variantStreamClosestToBitrate(i10);
        List<StreamInf> variantStreams = getVariantStreams();
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < variantStreams.size(); i11++) {
            StreamInf streamInf = variantStreams.get(i11);
            if (!streamInf.equals(streamInfVariantStreamClosestToBitrate)) {
                arrayList.add(streamInf);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            removeVariantStream((StreamInf) it.next());
        }
    }

    public void removeVariantStream(StreamInf streamInf) {
        this.tags.remove(streamInf.getTag());
        this.parsedTagListCache.get(TagNames.EXTXSTREAMINF).remove(streamInf);
    }

    public StreamInf variantStreamClosestToBitrate(int i10) {
        int i11 = Integer.MAX_VALUE;
        StreamInf streamInf = null;
        for (StreamInf streamInf2 : getVariantStreams()) {
            int iAbs = Math.abs(streamInf2.getBandwidth() - i10);
            if (iAbs < i11) {
                streamInf = streamInf2;
                i11 = iAbs;
            }
        }
        return streamInf;
    }
}
