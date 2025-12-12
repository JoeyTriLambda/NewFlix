package i6;

import java.util.Collections;
import java.util.List;

/* compiled from: Mp4WebvttSubtitle.java */
/* loaded from: classes.dex */
public final class c implements b6.d {

    /* renamed from: b, reason: collision with root package name */
    public final List<b6.a> f13220b;

    public c(List<b6.a> list) {
        this.f13220b = Collections.unmodifiableList(list);
    }

    @Override // b6.d
    public List<b6.a> getCues(long j10) {
        return j10 >= 0 ? this.f13220b : Collections.emptyList();
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
