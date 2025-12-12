package a2;

import a2.n;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f86b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ c f87m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f88n;

    public /* synthetic */ b(c cVar, int i10, int i11) {
        this.f86b = i11;
        this.f87m = cVar;
        this.f88n = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f86b;
        int i11 = this.f88n;
        c cVar = this.f87m;
        switch (i10) {
            case 0:
                n.g gVar = a.this.f63s;
                if (gVar != null) {
                    gVar.requestUpdateVolume(i11);
                    break;
                }
                break;
            default:
                n.g gVar2 = a.this.f63s;
                if (gVar2 != null) {
                    gVar2.requestSetVolume(i11);
                    break;
                }
                break;
        }
    }
}
