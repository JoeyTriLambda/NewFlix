package com.uwetrottmann.trakt5.entities;

import com.uwetrottmann.trakt5.enums.Audio;
import com.uwetrottmann.trakt5.enums.AudioChannels;
import com.uwetrottmann.trakt5.enums.Hdr;
import com.uwetrottmann.trakt5.enums.MediaType;
import com.uwetrottmann.trakt5.enums.Resolution;
import u9.b;

/* loaded from: classes2.dex */
public class Metadata {
    public Audio audio;
    public AudioChannels audio_channels;
    public Hdr hdr;

    @b("3d")
    public Boolean is3d;
    public MediaType media_type;
    public Resolution resolution;
}
