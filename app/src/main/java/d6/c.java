package d6;

import b6.d;
import java.util.List;

/* compiled from: DvbSubtitle.java */
/* loaded from: classes.dex */
public final class c implements d {

    /* renamed from: b, reason: collision with root package name */
    public final List<b6.a> f10948b;

    public c(List<b6.a> list) {
        this.f10948b = list;
    }

    @Override // b6.d
    public List<b6.a> getCues(long j10) {
        return this.f10948b;
    }

    @Override // b6.d
    public long getEventTime(int i10) {
        return 0L;
    }

    @Override // b6.d
    public int getEventTimeCount() {
        return 1;
    }

    @Override // b6.d
    public int getNextEventTimeIndex(long j10) {
        return -1;
    }
}
