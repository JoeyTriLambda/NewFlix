package com.google.android.exoplayer2.source.hls.playlist;

import java.util.Collections;
import java.util.List;

/* compiled from: HlsMediaPlaylist.java */
/* loaded from: classes.dex */
public final class b extends z5.a {

    /* renamed from: c, reason: collision with root package name */
    public final int f5913c;

    /* renamed from: d, reason: collision with root package name */
    public final long f5914d;

    /* renamed from: e, reason: collision with root package name */
    public final long f5915e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f5916f;

    /* renamed from: g, reason: collision with root package name */
    public final int f5917g;

    /* renamed from: h, reason: collision with root package name */
    public final int f5918h;

    /* renamed from: i, reason: collision with root package name */
    public final int f5919i;

    /* renamed from: j, reason: collision with root package name */
    public final long f5920j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f5921k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f5922l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f5923m;

    /* renamed from: n, reason: collision with root package name */
    public final a f5924n;

    /* renamed from: o, reason: collision with root package name */
    public final List<a> f5925o;

    /* renamed from: p, reason: collision with root package name */
    public final long f5926p;

    /* compiled from: HlsMediaPlaylist.java */
    public static final class a implements Comparable<Long> {

        /* renamed from: b, reason: collision with root package name */
        public final String f5927b;

        /* renamed from: m, reason: collision with root package name */
        public final long f5928m;

        /* renamed from: n, reason: collision with root package name */
        public final int f5929n;

        /* renamed from: o, reason: collision with root package name */
        public final long f5930o;

        /* renamed from: p, reason: collision with root package name */
        public final boolean f5931p;

        /* renamed from: q, reason: collision with root package name */
        public final String f5932q;

        /* renamed from: r, reason: collision with root package name */
        public final String f5933r;

        /* renamed from: s, reason: collision with root package name */
        public final long f5934s;

        /* renamed from: t, reason: collision with root package name */
        public final long f5935t;

        public a(String str, long j10, long j11) {
            this(str, 0L, -1, -9223372036854775807L, false, null, null, j10, j11);
        }

        public a(String str, long j10, int i10, long j11, boolean z10, String str2, String str3, long j12, long j13) {
            this.f5927b = str;
            this.f5928m = j10;
            this.f5929n = i10;
            this.f5930o = j11;
            this.f5931p = z10;
            this.f5932q = str2;
            this.f5933r = str3;
            this.f5934s = j12;
            this.f5935t = j13;
        }

        @Override // java.lang.Comparable
        public int compareTo(Long l10) {
            long jLongValue = l10.longValue();
            long j10 = this.f5930o;
            if (j10 > jLongValue) {
                return 1;
            }
            return j10 < l10.longValue() ? -1 : 0;
        }
    }

    public b(int i10, String str, List<String> list, long j10, long j11, boolean z10, int i11, int i12, int i13, long j12, boolean z11, boolean z12, boolean z13, a aVar, List<a> list2) {
        super(str, list);
        this.f5913c = i10;
        this.f5915e = j11;
        this.f5916f = z10;
        this.f5917g = i11;
        this.f5918h = i12;
        this.f5919i = i13;
        this.f5920j = j12;
        this.f5921k = z11;
        this.f5922l = z12;
        this.f5923m = z13;
        this.f5924n = aVar;
        this.f5925o = Collections.unmodifiableList(list2);
        if (list2.isEmpty()) {
            this.f5926p = 0L;
        } else {
            a aVar2 = list2.get(list2.size() - 1);
            this.f5926p = aVar2.f5930o + aVar2.f5928m;
        }
        this.f5914d = j10 == -9223372036854775807L ? -9223372036854775807L : j10 >= 0 ? j10 : this.f5926p + j10;
    }

    public b copyWith(long j10, int i10) {
        return new b(this.f5913c, this.f22611a, this.f22612b, this.f5914d, j10, true, i10, this.f5918h, this.f5919i, this.f5920j, this.f5921k, this.f5922l, this.f5923m, this.f5924n, this.f5925o);
    }

    public b copyWithEndTag() {
        return this.f5922l ? this : new b(this.f5913c, this.f22611a, this.f22612b, this.f5914d, this.f5915e, this.f5916f, this.f5917g, this.f5918h, this.f5919i, this.f5920j, this.f5921k, true, this.f5923m, this.f5924n, this.f5925o);
    }

    public long getEndTimeUs() {
        return this.f5915e + this.f5926p;
    }

    public boolean isNewerThan(b bVar) {
        int i10;
        int i11;
        if (bVar == null || (i10 = this.f5918h) > (i11 = bVar.f5918h)) {
            return true;
        }
        if (i10 < i11) {
            return false;
        }
        int size = this.f5925o.size();
        int size2 = bVar.f5925o.size();
        if (size <= size2) {
            return size == size2 && this.f5922l && !bVar.f5922l;
        }
        return true;
    }
}
