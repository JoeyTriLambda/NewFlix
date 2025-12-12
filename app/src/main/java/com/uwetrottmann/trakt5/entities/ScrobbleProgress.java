package com.uwetrottmann.trakt5.entities;

/* loaded from: classes2.dex */
public class ScrobbleProgress extends GenericProgress {
    public String app_date;
    public String app_version;

    private ScrobbleProgress(String str, String str2) {
        this.app_version = str;
        this.app_date = str2;
    }

    public ScrobbleProgress(SyncEpisode syncEpisode, double d10, String str, String str2) {
        this(str, str2);
        this.episode = syncEpisode;
        this.progress = Double.valueOf(d10);
    }

    public ScrobbleProgress(SyncMovie syncMovie, double d10, String str, String str2) {
        this(str, str2);
        this.movie = syncMovie;
        this.progress = Double.valueOf(d10);
    }
}
