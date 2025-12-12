package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import com.squareup.picasso.Picasso;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: Request.java */
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: s, reason: collision with root package name */
    public static final long f10581s = TimeUnit.SECONDS.toNanos(5);

    /* renamed from: a, reason: collision with root package name */
    public int f10582a;

    /* renamed from: b, reason: collision with root package name */
    public long f10583b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f10584c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10585d;

    /* renamed from: e, reason: collision with root package name */
    public final List<sa.j> f10586e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10587f;

    /* renamed from: g, reason: collision with root package name */
    public final int f10588g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f10589h;

    /* renamed from: i, reason: collision with root package name */
    public final int f10590i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f10591j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f10592k;

    /* renamed from: l, reason: collision with root package name */
    public final float f10593l;

    /* renamed from: m, reason: collision with root package name */
    public final float f10594m;

    /* renamed from: n, reason: collision with root package name */
    public final float f10595n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f10596o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f10597p;

    /* renamed from: q, reason: collision with root package name */
    public final Bitmap.Config f10598q;

    /* renamed from: r, reason: collision with root package name */
    public final Picasso.Priority f10599r;

    /* compiled from: Request.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f10600a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10601b;

        /* renamed from: c, reason: collision with root package name */
        public int f10602c;

        /* renamed from: d, reason: collision with root package name */
        public int f10603d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f10604e;

        /* renamed from: f, reason: collision with root package name */
        public int f10605f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f10606g;

        /* renamed from: h, reason: collision with root package name */
        public ArrayList f10607h;

        /* renamed from: i, reason: collision with root package name */
        public final Bitmap.Config f10608i;

        /* renamed from: j, reason: collision with root package name */
        public Picasso.Priority f10609j;

        public a(Uri uri, int i10, Bitmap.Config config) {
            this.f10600a = uri;
            this.f10601b = i10;
            this.f10608i = config;
        }

        public k build() {
            boolean z10 = this.f10606g;
            if (z10 && this.f10604e) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            }
            if (this.f10604e && this.f10602c == 0 && this.f10603d == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            }
            if (z10 && this.f10602c == 0 && this.f10603d == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            }
            if (this.f10609j == null) {
                this.f10609j = Picasso.Priority.NORMAL;
            }
            return new k(this.f10600a, this.f10601b, this.f10607h, this.f10602c, this.f10603d, this.f10604e, this.f10606g, this.f10605f, this.f10608i, this.f10609j);
        }

        public a centerCrop(int i10) {
            if (this.f10606g) {
                throw new IllegalStateException("Center crop can not be used after calling centerInside");
            }
            this.f10604e = true;
            this.f10605f = i10;
            return this;
        }

        public a centerInside() {
            if (this.f10604e) {
                throw new IllegalStateException("Center inside can not be used after calling centerCrop");
            }
            this.f10606g = true;
            return this;
        }

        public a resize(int i10, int i11) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            }
            if (i11 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            }
            if (i11 == 0 && i10 == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            }
            this.f10602c = i10;
            this.f10603d = i11;
            return this;
        }

        public a transform(sa.j jVar) {
            if (jVar == null) {
                throw new IllegalArgumentException("Transformation must not be null.");
            }
            if (jVar.key() == null) {
                throw new IllegalArgumentException("Transformation key must not be null.");
            }
            if (this.f10607h == null) {
                this.f10607h = new ArrayList(2);
            }
            this.f10607h.add(jVar);
            return this;
        }
    }

    public k(Uri uri, int i10, ArrayList arrayList, int i11, int i12, boolean z10, boolean z11, int i13, Bitmap.Config config, Picasso.Priority priority) {
        this.f10584c = uri;
        this.f10585d = i10;
        if (arrayList == null) {
            this.f10586e = null;
        } else {
            this.f10586e = Collections.unmodifiableList(arrayList);
        }
        this.f10587f = i11;
        this.f10588g = i12;
        this.f10589h = z10;
        this.f10591j = z11;
        this.f10590i = i13;
        this.f10592k = false;
        this.f10593l = 0.0f;
        this.f10594m = 0.0f;
        this.f10595n = 0.0f;
        this.f10596o = false;
        this.f10597p = false;
        this.f10598q = config;
        this.f10599r = priority;
    }

    public final String a() {
        long jNanoTime = System.nanoTime() - this.f10583b;
        if (jNanoTime > f10581s) {
            return c() + '+' + TimeUnit.NANOSECONDS.toSeconds(jNanoTime) + 's';
        }
        return c() + '+' + TimeUnit.NANOSECONDS.toMillis(jNanoTime) + "ms";
    }

    public final boolean b() {
        return hasSize() || this.f10593l != 0.0f;
    }

    public final String c() {
        return ac.c.l(new StringBuilder("[R"), this.f10582a, ']');
    }

    public boolean hasSize() {
        return (this.f10587f == 0 && this.f10588g == 0) ? false : true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Request{");
        int i10 = this.f10585d;
        if (i10 > 0) {
            sb2.append(i10);
        } else {
            sb2.append(this.f10584c);
        }
        List<sa.j> list = this.f10586e;
        if (list != null && !list.isEmpty()) {
            for (sa.j jVar : list) {
                sb2.append(TokenParser.SP);
                sb2.append(jVar.key());
            }
        }
        int i11 = this.f10587f;
        if (i11 > 0) {
            sb2.append(" resize(");
            sb2.append(i11);
            sb2.append(',');
            sb2.append(this.f10588g);
            sb2.append(')');
        }
        if (this.f10589h) {
            sb2.append(" centerCrop");
        }
        if (this.f10591j) {
            sb2.append(" centerInside");
        }
        float f10 = this.f10593l;
        if (f10 != 0.0f) {
            sb2.append(" rotation(");
            sb2.append(f10);
            if (this.f10596o) {
                sb2.append(" @ ");
                sb2.append(this.f10594m);
                sb2.append(',');
                sb2.append(this.f10595n);
            }
            sb2.append(')');
        }
        if (this.f10597p) {
            sb2.append(" purgeable");
        }
        Bitmap.Config config = this.f10598q;
        if (config != null) {
            sb2.append(TokenParser.SP);
            sb2.append(config);
        }
        sb2.append('}');
        return sb2.toString();
    }
}
