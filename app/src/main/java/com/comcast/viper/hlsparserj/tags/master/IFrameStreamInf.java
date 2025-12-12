package com.comcast.viper.hlsparserj.tags.master;

/* loaded from: classes.dex */
public class IFrameStreamInf extends StreamInf {
    private static final String URI = "URI";

    @Override // com.comcast.viper.hlsparserj.tags.master.StreamInf
    public String getAudio() {
        throw new UnsupportedOperationException("AUDIO is not supported");
    }

    @Override // com.comcast.viper.hlsparserj.tags.master.StreamInf
    public String getClosedCaptions() {
        throw new UnsupportedOperationException("CLOSEDCAPTIONS is not supported");
    }

    @Override // com.comcast.viper.hlsparserj.tags.master.StreamInf
    public String getSubtitle() {
        throw new UnsupportedOperationException("SUBTITLE is not supported");
    }

    @Override // com.comcast.viper.hlsparserj.tags.master.StreamInf
    public String getURI() {
        return this.tag.getAttributes().get(URI);
    }

    @Override // com.comcast.viper.hlsparserj.tags.master.StreamInf
    public String getVideo() {
        throw new UnsupportedOperationException("VIDEO is not supported");
    }
}
