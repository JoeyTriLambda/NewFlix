package h6;

import b6.d;
import java.util.Collections;
import java.util.List;

/* compiled from: Tx3gSubtitle.java */
/* loaded from: classes.dex */
public final class b implements d {

    /* renamed from: m, reason: collision with root package name */
    public static final b f12942m = new b();

    /* renamed from: b, reason: collision with root package name */
    public final List<b6.a> f12943b;

    public b(b6.a aVar) {
        this.f12943b = Collections.singletonList(aVar);
    }

    @Override // b6.d
    public List<b6.a> getCues(long j10) {
        return j10 >= 0 ? this.f12943b : Collections.emptyList();
    }

    @Override // b6.d
    public long getEventTime(int i10) {
        l6.a.checkArgument(i10 == 0);
        return 0L;
    }

    @Override // b6.d
    public int getEventTimeCount() {
        return 1;
    }

    @Override // b6.d
    public int getNextEventTimeIndex(long j10) {
        return j10 < 0 ? 0 : -1;
    }

    public b() {
        this.f12943b = Collections.emptyList();
    }
}
