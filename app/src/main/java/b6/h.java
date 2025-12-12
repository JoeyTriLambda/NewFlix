package b6;

import java.util.List;

/* compiled from: SubtitleOutputBuffer.java */
/* loaded from: classes.dex */
public abstract class h extends e5.f implements d {

    /* renamed from: n, reason: collision with root package name */
    public d f4783n;

    /* renamed from: o, reason: collision with root package name */
    public long f4784o;

    @Override // e5.a
    public void clear() {
        super.clear();
        this.f4783n = null;
    }

    @Override // b6.d
    public List<a> getCues(long j10) {
        return this.f4783n.getCues(j10 - this.f4784o);
    }

    @Override // b6.d
    public long getEventTime(int i10) {
        return this.f4783n.getEventTime(i10) + this.f4784o;
    }

    @Override // b6.d
    public int getEventTimeCount() {
        return this.f4783n.getEventTimeCount();
    }

    @Override // b6.d
    public int getNextEventTimeIndex(long j10) {
        return this.f4783n.getNextEventTimeIndex(j10 - this.f4784o);
    }

    public abstract void release();

    public void setContent(long j10, d dVar, long j11) {
        this.f11145m = j10;
        this.f4783n = dVar;
        if (j11 != Long.MAX_VALUE) {
            j10 = j11;
        }
        this.f4784o = j10;
    }
}
