package c6;

import java.util.Collections;
import java.util.List;

/* compiled from: CeaSubtitle.java */
/* loaded from: classes.dex */
public final class f implements b6.d {

    /* renamed from: b, reason: collision with root package name */
    public final List<b6.a> f5245b;

    public f(List<b6.a> list) {
        this.f5245b = list;
    }

    @Override // b6.d
    public List<b6.a> getCues(long j10) {
        return j10 >= 0 ? this.f5245b : Collections.emptyList();
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
}
