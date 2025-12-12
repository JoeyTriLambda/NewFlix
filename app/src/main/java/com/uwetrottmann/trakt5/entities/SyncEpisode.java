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
public class SyncEpisode {
    public Audio audio;
    public AudioChannels audio_channels;
    public OffsetDateTime collected_at;
    public Hdr hdr;
    public EpisodeIds ids;

    @b("3d")
    public Boolean is3d;
    public MediaType media_type;
    public Integer number;
    public OffsetDateTime rated_at;
    public Rating rating;
    public Resolution resolution;
    public Integer season;
    public OffsetDateTime watched_at;

    public SyncEpisode audio(Audio audio) {
        this.audio = audio;
        return this;
    }

    public SyncEpisode audioChannels(AudioChannels audioChannels) {
        this.audio_channels = audioChannels;
        return this;
    }

    public SyncEpisode collectedAt(OffsetDateTime offsetDateTime) {
        this.collected_at = offsetDateTime;
        return this;
    }

    public SyncEpisode hdr(Hdr hdr) {
        this.hdr = hdr;
        return this;
    }

    public SyncEpisode id(EpisodeIds episodeIds) {
        this.ids = episodeIds;
        return this;
    }

    public SyncEpisode is3d(Boolean bool) {
        this.is3d = bool;
        return this;
    }

    public SyncEpisode mediaType(MediaType mediaType) {
        this.media_type = mediaType;
        return this;
    }

    public SyncEpisode number(int i10) {
        this.number = Integer.valueOf(i10);
        return this;
    }

    public SyncEpisode ratedAt(OffsetDateTime offsetDateTime) {
        this.rated_at = offsetDateTime;
        return this;
    }

    public SyncEpisode rating(Rating rating) {
        this.rating = rating;
        return this;
    }

    public SyncEpisode resolution(Resolution resolution) {
        this.resolution = resolution;
        return this;
    }

    public SyncEpisode season(int i10) {
        this.season = Integer.valueOf(i10);
        return this;
    }

    public SyncEpisode watchedAt(OffsetDateTime offsetDateTime) {
        this.watched_at = offsetDateTime;
        return this;
    }
}
