package flix.com.vision.models;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class Anime implements Serializable {
    private static final long serialVersionUID = 128;

    /* renamed from: b, reason: collision with root package name */
    public String f12378b;

    /* renamed from: m, reason: collision with root package name */
    public String f12379m = "";

    /* renamed from: n, reason: collision with root package name */
    public String f12380n = "";

    /* renamed from: o, reason: collision with root package name */
    public String f12381o = "";

    /* renamed from: p, reason: collision with root package name */
    public String f12382p = "";

    /* renamed from: q, reason: collision with root package name */
    public String f12383q = "";

    /* renamed from: r, reason: collision with root package name */
    public String f12384r = "";

    /* renamed from: s, reason: collision with root package name */
    public String f12385s = "";

    /* renamed from: t, reason: collision with root package name */
    public String f12386t = "";

    public Movie toMovie() {
        Movie movie = new Movie();
        movie.setTitle(this.f12380n);
        movie.setUrl(this.f12382p);
        movie.setPlot(this.f12384r);
        movie.setServer(this.f12385s);
        movie.setCast(this.f12379m);
        movie.f12396n = true;
        movie.setImage_url(this.f12383q);
        movie.setRating(this.f12386t);
        movie.setQuality(this.f12381o);
        movie.setType(3);
        return movie;
    }
}
