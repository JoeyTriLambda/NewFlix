package com.uwetrottmann.trakt5;

import ac.c;

/* loaded from: classes2.dex */
public class TraktLink {
    private static final String PATH_EPISODES = "/episodes/";
    private static final String PATH_SEASONS = "/seasons/";
    private static final String URL_COMMENT = "https://trakt.tv/comments/";
    private static final String URL_EPISODE = "https://trakt.tv/episodes/";
    private static final String URL_IMDB = "https://trakt.tv/search/imdb/";
    private static final String URL_MOVIE = "https://trakt.tv/movies/";
    private static final String URL_PERSON = "https://trakt.tv/people/";
    private static final String URL_SEASON = "https://trakt.tv/seasons/";
    private static final String URL_SHOW = "https://trakt.tv/shows/";
    private static final String URL_TMDB = "https://trakt.tv/search/tmdb/";
    private static final String URL_TVDB = "https://trakt.tv/search/tvdb/";
    private static final String URL_TVRAGE = "https://trakt.tv/search/tvrage/";

    public static String comment(int i10) {
        return c.f(URL_COMMENT, i10);
    }

    public static String episode(int i10) {
        return c.f(URL_EPISODE, i10);
    }

    public static String imdb(String str) {
        return c.j(URL_IMDB, str);
    }

    public static String movie(String str) {
        return c.j(URL_MOVIE, str);
    }

    public static String person(String str) {
        return c.j(URL_PERSON, str);
    }

    public static String season(int i10) {
        return c.f(URL_SEASON, i10);
    }

    public static String show(String str) {
        return c.j(URL_SHOW, str);
    }

    public static String tmdb(int i10) {
        return c.f(URL_TMDB, i10);
    }

    public static String tvdb(int i10) {
        return c.f(URL_TVDB, i10);
    }

    public static String tvrage(int i10) {
        return c.f(URL_TVRAGE, i10);
    }

    public static String episode(int i10, int i11, int i12) {
        return show(String.valueOf(i10)) + PATH_SEASONS + i11 + PATH_EPISODES + i12;
    }

    public static String season(int i10, int i11) {
        return show(String.valueOf(i10)) + PATH_SEASONS + i11;
    }
}
