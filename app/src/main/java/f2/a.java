package f2;

import androidx.profileinstaller.c;
import java.io.Serializable;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11378b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f11379m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f11380n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f11381o;

    public /* synthetic */ a(int i10, Object obj, int i11, Serializable serializable) {
        this.f11378b = i11;
        this.f11381o = obj;
        this.f11379m = i10;
        this.f11380n = serializable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f11378b;
        Object obj = this.f11380n;
        int i11 = this.f11379m;
        Object obj2 = this.f11381o;
        switch (i10) {
            case 0:
                ((androidx.profileinstaller.b) obj2).f3841c.onResultReceived(i11, obj);
                break;
            default:
                ((c.InterfaceC0037c) obj2).onResultReceived(i11, obj);
                break;
        }
    }
}
