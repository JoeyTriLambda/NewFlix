package com.uwetrottmann.trakt5.entities;

/* loaded from: classes2.dex */
public class EpisodeIds extends BaseIds {
    public Integer tvdb;
    public Integer tvrage;

    public static EpisodeIds imdb(String str) {
        EpisodeIds episodeIds = new EpisodeIds();
        episodeIds.imdb = str;
        return episodeIds;
    }

    public static EpisodeIds tmdb(int i10) {
        EpisodeIds episodeIds = new EpisodeIds();
        episodeIds.tmdb = Integer.valueOf(i10);
        return episodeIds;
    }

    public static EpisodeIds trakt(int i10) {
        EpisodeIds episodeIds = new EpisodeIds();
        episodeIds.trakt = Integer.valueOf(i10);
        return episodeIds;
    }

    public static EpisodeIds tvdb(int i10) {
        EpisodeIds episodeIds = new EpisodeIds();
        episodeIds.tvdb = Integer.valueOf(i10);
        return episodeIds;
    }

    public static EpisodeIds tvrage(int i10) {
        EpisodeIds episodeIds = new EpisodeIds();
        episodeIds.tvrage = Integer.valueOf(i10);
        return episodeIds;
    }
}
