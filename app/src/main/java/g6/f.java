package g6;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import l6.u;

/* compiled from: TtmlSubtitle.java */
/* loaded from: classes.dex */
public final class f implements b6.d {

    /* renamed from: b, reason: collision with root package name */
    public final b f12771b;

    /* renamed from: m, reason: collision with root package name */
    public final long[] f12772m;

    /* renamed from: n, reason: collision with root package name */
    public final Map<String, e> f12773n;

    /* renamed from: o, reason: collision with root package name */
    public final Map<String, c> f12774o;

    public f(b bVar, Map<String, e> map, Map<String, c> map2) {
        this.f12771b = bVar;
        this.f12774o = map2;
        this.f12773n = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f12772m = bVar.getEventTimesUs();
    }

    @Override // b6.d
    public List<b6.a> getCues(long j10) {
        return this.f12771b.getCues(j10, this.f12773n, this.f12774o);
    }

    @Override // b6.d
    public long getEventTime(int i10) {
        return this.f12772m[i10];
    }

    @Override // b6.d
    public int getEventTimeCount() {
        return this.f12772m.length;
    }

    @Override // b6.d
    public int getNextEventTimeIndex(long j10) {
        long[] jArr = this.f12772m;
        int iBinarySearchCeil = u.binarySearchCeil(jArr, j10, false, false);
        if (iBinarySearchCeil < jArr.length) {
            return iBinarySearchCeil;
        }
        return -1;
    }
}
