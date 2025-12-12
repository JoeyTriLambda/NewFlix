package com.comcast.viper.hlsparserj.tags.master;

import com.comcast.viper.hlsparserj.tags.Tag;

/* loaded from: classes.dex */
public class StreamInf extends Tag {
    private static final String AUDIO = "AUDIO";
    private static final String BANDWIDTH = "BANDWIDTH";
    private static final String CLOSEDCAPTIONS = "CLOSEDCAPTIONS";
    private static final String CODECS = "CODECS";
    private static final String PROGRAMID = "PROGRAM-ID";
    private static final String RESOLUTION = "RESOLUTION";
    private static final String SUBTITLE = "SUBTITLE";
    private static final String VIDEO = "VIDEO";

    public String getAudio() {
        return this.tag.getAttributes().get(AUDIO);
    }

    public int getBandwidth() {
        return Integer.valueOf(this.tag.getAttributes().get(BANDWIDTH)).intValue();
    }

    public String getClosedCaptions() {
        return this.tag.getAttributes().get(CLOSEDCAPTIONS);
    }

    public String getCodecs() {
        return this.tag.getAttributes().get(CODECS);
    }

    public int getProgramId() {
        return Integer.valueOf(this.tag.getAttributes().get(PROGRAMID)).intValue();
    }

    public String getResolution() {
        return this.tag.getAttributes().get(RESOLUTION);
    }

    public String getSubtitle() {
        return this.tag.getAttributes().get(SUBTITLE);
    }

    public String getURI() {
        return this.tag.getURI();
    }

    public String getVideo() {
        return this.tag.getAttributes().get(VIDEO);
    }
}
