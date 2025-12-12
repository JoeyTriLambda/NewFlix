package j6;

import android.os.SystemClock;
import com.loopj.android.http.AsyncHttpClient;
import j6.f;
import u5.n;

/* compiled from: AdaptiveTrackSelection.java */
/* loaded from: classes.dex */
public final class a extends b {

    /* renamed from: g, reason: collision with root package name */
    public final k6.c f14621g;

    /* renamed from: h, reason: collision with root package name */
    public final int f14622h;

    /* renamed from: i, reason: collision with root package name */
    public final long f14623i;

    /* renamed from: j, reason: collision with root package name */
    public final long f14624j;

    /* renamed from: k, reason: collision with root package name */
    public final float f14625k;

    /* renamed from: l, reason: collision with root package name */
    public int f14626l;

    /* renamed from: m, reason: collision with root package name */
    public int f14627m;

    /* compiled from: AdaptiveTrackSelection.java */
    /* renamed from: j6.a$a, reason: collision with other inner class name */
    public static final class C0169a implements f.a {

        /* renamed from: a, reason: collision with root package name */
        public final k6.c f14628a;

        /* renamed from: b, reason: collision with root package name */
        public final int f14629b;

        /* renamed from: c, reason: collision with root package name */
        public final int f14630c;

        /* renamed from: d, reason: collision with root package name */
        public final int f14631d;

        /* renamed from: e, reason: collision with root package name */
        public final int f14632e;

        /* renamed from: f, reason: collision with root package name */
        public final float f14633f;

        public C0169a(k6.c cVar) {
            this(cVar, 800000, AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT, 25000, 25000, 0.75f);
        }

        public C0169a(k6.c cVar, int i10, int i11, int i12, int i13, float f10) {
            this.f14628a = cVar;
            this.f14629b = i10;
            this.f14630c = i11;
            this.f14631d = i12;
            this.f14632e = i13;
            this.f14633f = f10;
        }

        /* renamed from: createTrackSelection, reason: merged with bridge method [inline-methods] */
        public a m32createTrackSelection(n nVar, int... iArr) {
            return new a(nVar, iArr, this.f14628a, this.f14629b, this.f14630c, this.f14631d, this.f14632e, this.f14633f);
        }
    }

    public a(n nVar, int[] iArr, k6.c cVar, int i10, long j10, long j11, long j12, float f10) {
        super(nVar, iArr);
        this.f14621g = cVar;
        this.f14622h = i10;
        this.f14623i = j10 * 1000;
        this.f14624j = j11 * 1000;
        this.f14625k = f10;
        this.f14626l = a(Long.MIN_VALUE);
        this.f14627m = 1;
    }

    public final int a(long j10) {
        long bitrateEstimate = ((k6.h) this.f14621g).getBitrateEstimate();
        long j11 = bitrateEstimate == -1 ? this.f14622h : (long) (bitrateEstimate * this.f14625k);
        int i10 = 0;
        for (int i11 = 0; i11 < this.f14635b; i11++) {
            if (j10 == Long.MIN_VALUE || !isBlacklisted(i11, j10)) {
                if (getFormat(i11).f5116m <= j11) {
                    return i11;
                }
                i10 = i11;
            }
        }
        return i10;
    }

    @Override // j6.f
    public int getSelectedIndex() {
        return this.f14626l;
    }

    @Override // j6.f
    public Object getSelectionData() {
        return null;
    }

    @Override // j6.f
    public int getSelectionReason() {
        return this.f14627m;
    }

    @Override // j6.f
    public void updateSelectedTrack(long j10) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int i10 = this.f14626l;
        int iA = a(jElapsedRealtime);
        this.f14626l = iA;
        if (iA == i10) {
            return;
        }
        if (!isBlacklisted(i10, jElapsedRealtime)) {
            c5.i format = getFormat(i10);
            int i11 = getFormat(this.f14626l).f5116m;
            int i12 = format.f5116m;
            if (i11 > i12 && j10 < this.f14623i) {
                this.f14626l = i10;
            } else if (i11 < i12 && j10 >= this.f14624j) {
                this.f14626l = i10;
            }
        }
        if (this.f14626l != i10) {
            this.f14627m = 3;
        }
    }
}
