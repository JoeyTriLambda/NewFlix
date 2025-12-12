package com.uwetrottmann.trakt5.entities;

import org.threeten.bp.OffsetDateTime;

/* loaded from: classes2.dex */
public class Comment {
    public String comment;
    public OffsetDateTime created_at;
    public Episode episode;

    /* renamed from: id, reason: collision with root package name */
    public Integer f10712id;
    public Integer likes;
    public Movie movie;
    public Integer parent_id;
    public Integer replies;
    public Boolean review;
    public Show show;
    public Boolean spoiler;
    public OffsetDateTime updated_at;
    public User user;
    public Integer user_rating;

    public Comment() {
    }

    public Comment(Movie movie, String str, boolean z10, boolean z11) {
        this(str, z10, z11);
        this.movie = movie;
    }

    public Comment(Show show, String str, boolean z10, boolean z11) {
        this(str, z10, z11);
        this.show = show;
    }

    public Comment(Episode episode, String str, boolean z10, boolean z11) {
        this(str, z10, z11);
        this.episode = episode;
    }

    public Comment(String str, boolean z10, boolean z11) {
        this.comment = str;
        this.spoiler = Boolean.valueOf(z10);
        this.review = Boolean.valueOf(z11);
    }
}
