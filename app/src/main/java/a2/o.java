package a2;

import a2.n;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f232b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ n.e f233m;

    public /* synthetic */ o(n.e eVar, int i10) {
        this.f232b = i10;
        this.f233m = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f232b;
        n.e eVar = this.f233m;
        switch (i10) {
            case 0:
                eVar.b();
                break;
            default:
                eVar.b();
                break;
        }
    }
}
