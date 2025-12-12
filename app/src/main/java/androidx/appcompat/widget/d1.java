package androidx.appcompat.widget;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class d1 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1310b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Toolbar f1311m;

    public /* synthetic */ d1(Toolbar toolbar, int i10) {
        this.f1310b = i10;
        this.f1311m = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f1310b;
        Toolbar toolbar = this.f1311m;
        switch (i10) {
            case 0:
                toolbar.invalidateMenu();
                break;
            default:
                toolbar.collapseActionView();
                break;
        }
    }
}
