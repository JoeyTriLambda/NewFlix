package com.uwetrottmann.trakt5.entities;

import com.uwetrottmann.trakt5.enums.Audio;
import com.uwetrottmann.trakt5.enums.AudioChannels;
import com.uwetrottmann.trakt5.enums.Hdr;
import com.uwetrottmann.trakt5.enums.MediaType;
import com.uwetrottmann.trakt5.enums.Rating;
import com.uwetrottmann.trakt5.enums.Resolution;
import org.threeten.bp.OffsetDateTime;
import u9.b;

/* loaded from: classes2.dex */
public class SyncMovie {
    public Audio audio;
    public AudioChannels audio_channels;
    public OffsetDateTime collected_at;
    public Hdr hdr;
    public MovieIds ids;

    @b("3d")
    public Boolean is3d;
    public MediaType media_type;
    public OffsetDateTime rated_at;
    public Rating rating;
    public Resolution resolution;
    public OffsetDateTime watched_at;

    public SyncMovie audio(Audio audio) {
        this.audio = audio;
        return this;
    }

    public SyncMovie audioChannels(AudioChannels audioChannels) {
        this.audio_channels = audioChannels;
        return this;
    }

    public SyncMovie collectedAt(OffsetDateTime offsetDateTime) {
        this.collected_at = offsetDateTime;
        return this;
    }

    public SyncMovie hdr(Hdr hdr) {
        this.hdr = hdr;
        return this;
    }

    public SyncMovie id(MovieIds movieIds) {
        this.ids = movieIds;
        return this;
    }

    public SyncMovie is3d(Boolean bool) {
        this.is3d = bool;
        return this;
    }

    public SyncMovie mediaType(MediaType mediaType) {
        this.media_type = mediaType;
        return this;
    }

    public SyncMovie ratedAt(OffsetDateTime offsetDateTime) {
        this.rated_at = offsetDateTime;
        return this;
    }

    public SyncMovie rating(Rating rating) {
        this.rating = rating;
        return this;
    }

    public SyncMovie resolution(Resolution resolution) {
        this.resolution = resolution;
        return this;
    }

    public SyncMovie watchedAt(OffsetDateTime offsetDateTime) {
        this.watched_at = offsetDateTime;
        return this;
    }
}
