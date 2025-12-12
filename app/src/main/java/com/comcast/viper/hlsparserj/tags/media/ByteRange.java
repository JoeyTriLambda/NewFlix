package com.comcast.viper.hlsparserj.tags.media;

/* loaded from: classes.dex */
public class ByteRange extends Segment {
    public int getLength() {
        return Integer.valueOf(this.tag.getAttributes().get("NONAME0").split("@")[0]).intValue();
    }

    public int getOffset() {
        String[] strArrSplit = this.tag.getAttributes().get("NONAME0").split("@");
        if (strArrSplit.length > 1) {
            return Integer.valueOf(strArrSplit[1]).intValue();
        }
        return 0;
    }

    @Override // com.comcast.viper.hlsparserj.tags.media.Segment
    public String getURI() {
        return this.tag.getURI();
    }
}
