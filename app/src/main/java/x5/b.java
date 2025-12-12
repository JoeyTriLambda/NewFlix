package x5;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* compiled from: DashManifest.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f21562a;

    /* renamed from: b, reason: collision with root package name */
    public final long f21563b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f21564c;

    /* renamed from: d, reason: collision with root package name */
    public final long f21565d;

    /* renamed from: e, reason: collision with root package name */
    public final long f21566e;

    /* renamed from: f, reason: collision with root package name */
    public final long f21567f;

    /* renamed from: g, reason: collision with root package name */
    public final k f21568g;

    /* renamed from: h, reason: collision with root package name */
    public final Uri f21569h;

    /* renamed from: i, reason: collision with root package name */
    public final List<e> f21570i;

    public b(long j10, long j11, long j12, boolean z10, long j13, long j14, long j15, k kVar, Uri uri, List<e> list) {
        this.f21562a = j10;
        this.f21563b = j11;
        this.f21564c = z10;
        this.f21565d = j13;
        this.f21566e = j14;
        this.f21567f = j15;
        this.f21568g = kVar;
        this.f21569h = uri;
        this.f21570i = list == null ? Collections.emptyList() : list;
    }

    public final e getPeriod(int i10) {
        return this.f21570i.get(i10);
    }

    public final int getPeriodCount() {
        return this.f21570i.size();
    }

    public final long getPeriodDurationMs(int i10) {
        List<e> list = this.f21570i;
        if (i10 != list.size() - 1) {
            return list.get(i10 + 1).f21585b - list.get(i10).f21585b;
        }
        long j10 = this.f21563b;
        if (j10 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j10 - list.get(i10).f21585b;
    }

    public final long getPeriodDurationUs(int i10) {
        return c5.b.msToUs(getPeriodDurationMs(i10));
    }
}
