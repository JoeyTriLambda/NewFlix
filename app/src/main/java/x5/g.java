package x5;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import x5.h;

/* compiled from: Representation.java */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public final c5.i f21591a;

    /* renamed from: b, reason: collision with root package name */
    public final String f21592b;

    /* renamed from: c, reason: collision with root package name */
    public final long f21593c;

    /* renamed from: d, reason: collision with root package name */
    public final List<d> f21594d;

    /* renamed from: e, reason: collision with root package name */
    public final f f21595e;

    /* compiled from: Representation.java */
    public static class b extends g {

        /* renamed from: f, reason: collision with root package name */
        public final String f21597f;

        /* renamed from: g, reason: collision with root package name */
        public final f f21598g;

        /* renamed from: h, reason: collision with root package name */
        public final i f21599h;

        public b(String str, long j10, c5.i iVar, String str2, h.e eVar, List<d> list, String str3, long j11) {
            String string;
            super(iVar, str2, eVar, list);
            Uri.parse(str2);
            f index = eVar.getIndex();
            this.f21598g = index;
            if (str3 != null) {
                string = str3;
            } else if (str != null) {
                StringBuilder sbU = ac.c.u(str, ".");
                sbU.append(iVar.f5115b);
                sbU.append(".");
                sbU.append(j10);
                string = sbU.toString();
            } else {
                string = null;
            }
            this.f21597f = string;
            this.f21599h = index == null ? new i(new f(null, 0L, j11)) : null;
        }

        @Override // x5.g
        public String getCacheKey() {
            return this.f21597f;
        }

        @Override // x5.g
        public w5.f getIndex() {
            return this.f21599h;
        }

        @Override // x5.g
        public f getIndexUri() {
            return this.f21598g;
        }
    }

    public g() {
        throw null;
    }

    public g(c5.i iVar, String str, h hVar, List list) {
        this.f21591a = iVar;
        this.f21592b = str;
        this.f21594d = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f21595e = hVar.getInitialization(this);
        this.f21593c = hVar.getPresentationTimeOffsetUs();
    }

    public static g newInstance(String str, long j10, c5.i iVar, String str2, h hVar, List<d> list) {
        return newInstance(str, j10, iVar, str2, hVar, list, null);
    }

    public abstract String getCacheKey();

    public abstract w5.f getIndex();

    public abstract f getIndexUri();

    public f getInitializationUri() {
        return this.f21595e;
    }

    public static g newInstance(String str, long j10, c5.i iVar, String str2, h hVar, List<d> list, String str3) {
        if (hVar instanceof h.e) {
            return new b(str, j10, iVar, str2, (h.e) hVar, list, str3, -1L);
        }
        if (hVar instanceof h.a) {
            return new a(str, j10, iVar, str2, (h.a) hVar, list);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }

    /* compiled from: Representation.java */
    public static class a extends g implements w5.f {

        /* renamed from: f, reason: collision with root package name */
        public final h.a f21596f;

        public a(String str, long j10, c5.i iVar, String str2, h.a aVar, List<d> list) {
            super(iVar, str2, aVar, list);
            this.f21596f = aVar;
        }

        @Override // x5.g
        public String getCacheKey() {
            return null;
        }

        @Override // w5.f
        public long getDurationUs(int i10, long j10) {
            return this.f21596f.getSegmentDurationUs(i10, j10);
        }

        @Override // w5.f
        public int getFirstSegmentNum() {
            return this.f21596f.getFirstSegmentNum();
        }

        @Override // x5.g
        public f getIndexUri() {
            return null;
        }

        @Override // w5.f
        public int getSegmentCount(long j10) {
            return this.f21596f.getSegmentCount(j10);
        }

        @Override // w5.f
        public int getSegmentNum(long j10, long j11) {
            return this.f21596f.getSegmentNum(j10, j11);
        }

        @Override // w5.f
        public f getSegmentUrl(int i10) {
            return this.f21596f.getSegmentUrl(this, i10);
        }

        @Override // w5.f
        public long getTimeUs(int i10) {
            return this.f21596f.getSegmentTimeUs(i10);
        }

        @Override // w5.f
        public boolean isExplicit() {
            return this.f21596f.isExplicit();
        }

        @Override // x5.g
        public w5.f getIndex() {
            return this;
        }
    }
}
