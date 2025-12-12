package androidx.activity;

import android.window.OnBackInvokedCallback;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements OnBackInvokedCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f824a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f825b;

    public /* synthetic */ l(Object obj, int i10) {
        this.f824a = i10;
        this.f825b = obj;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        switch (this.f824a) {
            case 0:
                yf.a aVar = (yf.a) this.f825b;
                zf.i.checkNotNullParameter(aVar, "$onBackInvoked");
                aVar.invoke();
                break;
            case 1:
                ((Runnable) this.f825b).run();
                break;
            default:
                ((k7.b) this.f825b).handleBackInvoked();
                break;
        }
    }
}
