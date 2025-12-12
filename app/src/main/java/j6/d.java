package j6;

import u5.n;

/* compiled from: FixedTrackSelection.java */
/* loaded from: classes.dex */
public final class d extends b {

    /* renamed from: g, reason: collision with root package name */
    public final int f14658g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f14659h;

    public d(n nVar, int i10) {
        this(nVar, i10, 0, null);
    }

    @Override // j6.f
    public int getSelectedIndex() {
        return 0;
    }

    @Override // j6.f
    public Object getSelectionData() {
        return this.f14659h;
    }

    @Override // j6.f
    public int getSelectionReason() {
        return this.f14658g;
    }

    public d(n nVar, int i10, int i11, Object obj) {
        super(nVar, i10);
        this.f14658g = i11;
        this.f14659h = obj;
    }

    @Override // j6.f
    public void updateSelectedTrack(long j10) {
    }
}
