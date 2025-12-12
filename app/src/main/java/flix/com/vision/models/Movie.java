package flix.com.vision.models;

import ac.c;
import android.os.Build;
import android.text.Html;
import com.uwetrottmann.trakt5.TraktV2;
import flix.com.vision.helpers.Constants;
import hd.j;
import java.io.Serializable;
import java.util.ArrayList;
import u9.b;

/* loaded from: classes2.dex */
public class Movie implements Serializable, Comparable {
    private static final long serialVersionUID = 12;
    public String A;
    public int B;
    public String C;
    public int D;
    public String F;

    @b("backdrop_path")
    public String G;
    public String J;
    public String M;
    public String N;
    public String T;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12394b;

    /* renamed from: m, reason: collision with root package name */
    public int f12395m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12396n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12397o;

    /* renamed from: p, reason: collision with root package name */
    public String f12398p;

    /* renamed from: r, reason: collision with root package name */
    public String f12400r;

    /* renamed from: t, reason: collision with root package name */
    public long f12402t;

    /* renamed from: u, reason: collision with root package name */
    public int f12403u;

    /* renamed from: v, reason: collision with root package name */
    public String f12404v;

    /* renamed from: z, reason: collision with root package name */
    public long f12408z;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList<Integer> f12399q = new ArrayList<>();

    /* renamed from: w, reason: collision with root package name */
    public String f12405w = null;

    /* renamed from: x, reason: collision with root package name */
    public boolean f12406x = true;

    /* renamed from: y, reason: collision with root package name */
    public boolean f12407y = false;
    public int E = 0;
    public String H = "";
    public String I = "";
    public String U = "";
    public String S = "";
    public String R = "";
    public String O = "";
    public String P = "";
    public String L = "";
    public String K = "";
    public String Q = "";

    /* renamed from: s, reason: collision with root package name */
    public ArrayList<j> f12401s = new ArrayList<>();

    public boolean belongsToCollection() {
        return this.f12402t > 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return this.I.compareTo(((Movie) obj).I);
    }

    public boolean equals(Object obj) {
        try {
            return this.L.equals(((Movie) obj).L);
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public String getCast() {
        return this.S;
    }

    public String getCover() {
        return this.G;
    }

    public int getDuration() {
        return this.B;
    }

    public String getGenres() {
        String str = this.C;
        if (str != null && !str.isEmpty()) {
            return this.C;
        }
        ArrayList<Integer> arrayList = this.f12399q;
        if (arrayList.size() > 0) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                String genre = Constants.getGenre(arrayList.get(i10).intValue(), this.E);
                this.C = c.o(new StringBuilder(), this.C, genre);
                if (i10 < arrayList.size() - 1 && genre != null && !genre.isEmpty()) {
                    this.C = c.o(new StringBuilder(), this.C, ", ");
                }
            }
        }
        return this.C;
    }

    public String getImage_url() {
        return this.M;
    }

    public String getImdbID() {
        return this.J;
    }

    public String getInfo_url() {
        return this.O;
    }

    public long getMovieId() {
        String str;
        return ((!this.f12397o && !isAnime()) || (str = this.L) == null || this.K == null || this.M == null) ? this.f12408z : this.M.length() + this.K.length() + str.length();
    }

    public String getOverview() {
        return this.F;
    }

    public String getPlot() {
        return this.R;
    }

    public String getQuality() {
        return this.P;
    }

    public String getRating() {
        return this.Q;
    }

    public String getSeason() {
        if (this.H == null) {
            this.H = "1";
        }
        return this.H;
    }

    public int getSeason_count() {
        return this.D;
    }

    public String getServer() {
        return this.U;
    }

    public String getServerNumberNew() {
        if (this.N == null) {
            this.N = "-1";
        }
        return this.N;
    }

    public String getSimpleNameClean() {
        return this.K;
    }

    public String getTitle() {
        return this.K;
    }

    public int getType() {
        return this.E;
    }

    public String getUrl() {
        return this.L;
    }

    public String getYear() {
        return this.I;
    }

    public boolean isAnime() {
        if (this.L == null) {
            this.L = "";
        }
        if (this.U == null) {
            this.U = "";
        }
        return this.L.contains("9anime") || this.U.contains("anime");
    }

    public boolean isDrama() {
        return this.E == 4;
    }

    public boolean isSeries() {
        return this.E == 1;
    }

    public boolean released() {
        String str;
        if (isSeries()) {
            return true;
        }
        return (!this.f12406x || (str = this.I) == null || str.isEmpty()) ? false : true;
    }

    public void setCast(String str) {
        this.S = str;
    }

    public void setCover(String str) {
        this.G = str;
    }

    public void setDuration(int i10) {
        this.B = i10;
    }

    public void setGenres(String str) {
        if (str != null && str.startsWith("|")) {
            str = str.substring(1);
        }
        this.C = str.replace("|", ",");
    }

    public void setImage_url(String str) {
        this.M = str;
    }

    public void setImdbID(String str) {
        this.J = str;
    }

    public void setInfo_url(String str) {
        this.O = str;
    }

    public void setMovieId(long j10) {
        this.f12408z = j10;
    }

    public void setOverview(String str) {
        this.F = str;
    }

    public void setPlot(String str) {
        this.R = str;
    }

    public void setQuality(String str) {
        this.P = str;
    }

    public void setRating(String str) {
        this.Q = str;
    }

    public void setRawReleaseDate(String str) {
        this.A = str;
    }

    public void setSeason_count(int i10) {
        this.D = i10;
    }

    public void setServer(String str) {
        this.U = str;
    }

    public void setServerNumberNew() {
        String str = this.U.equals("solar_st_movies") ? "1" : this.U.equals("fmovies_io") ? TraktV2.API_VERSION : "1";
        if (this.U.equals("flenix")) {
            str = "0";
        }
        if (this.U.equals("hdo_movies")) {
            str = "3";
        }
        if (this.U.equals("is_movies")) {
            str = "5";
        }
        if (this.U.equals("gomovies") || this.U.equals("yes_movies") || this.U.equals("solar_movies")) {
            str = "4";
        }
        if (this.U.equals("solar_st_series")) {
            str = "6";
        }
        if (this.U.equals("fmovies_series_io")) {
            str = "7";
        }
        if (this.U.equals("hdo_series")) {
            str = "8";
        }
        if (this.U.equals("is_series")) {
            str = "10";
        }
        if (this.U.equals("yes_series")) {
            str = "9";
        }
        this.N = str;
    }

    public void setTitle(String str) {
        try {
            str = Build.VERSION.SDK_INT >= 24 ? String.valueOf(Html.fromHtml(str, 0)) : String.valueOf(Html.fromHtml(str));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        str.getClass();
        this.K = str.trim();
    }

    public void setType(int i10) {
        this.E = i10;
    }

    public void setUrl(String str) {
        this.L = str;
    }

    public Anime toAnime() {
        Anime anime = new Anime();
        anime.f12380n = this.K;
        anime.f12382p = this.L;
        anime.f12384r = this.R;
        anime.f12385s = this.U;
        anime.f12379m = this.S;
        anime.f12383q = this.M;
        anime.f12386t = this.Q;
        anime.f12381o = this.P;
        return anime;
    }

    public void parseYearfromTitle() {
    }

    public void setNSFK(boolean z10) {
    }

    public void setProduction(String str) {
    }

    public void setRevenue(long j10) {
    }

    public void setThumb(String str) {
    }
}
