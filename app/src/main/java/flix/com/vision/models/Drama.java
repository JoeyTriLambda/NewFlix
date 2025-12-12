package flix.com.vision.models;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class Drama implements Serializable {
    private static final long serialVersionUID = 138;

    /* renamed from: b, reason: collision with root package name */
    public String f12387b;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12388m;

    /* renamed from: n, reason: collision with root package name */
    public String f12389n = "";

    /* renamed from: o, reason: collision with root package name */
    public String f12390o = "";

    /* renamed from: p, reason: collision with root package name */
    public String f12391p = "";

    /* renamed from: q, reason: collision with root package name */
    public String f12392q = "";

    /* renamed from: r, reason: collision with root package name */
    public final String f12393r = "drama";

    public boolean equals(Object obj) {
        return this.f12391p.equals(((Drama) obj).f12391p);
    }

    public Movie toMovie() {
        Movie movie = new Movie();
        movie.setTitle(this.f12389n);
        movie.setUrl(this.f12391p);
        movie.setServer(this.f12393r);
        movie.f12397o = true;
        movie.setImage_url(this.f12392q);
        movie.setType(4);
        return movie;
    }
}
