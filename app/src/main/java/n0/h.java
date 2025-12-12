package n0;

import ac.w;
import android.view.View;
import com.google.android.material.sidesheet.SideSheetBehavior;
import n0.g;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f16434b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f16435m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f16436n;

    public /* synthetic */ h(int i10, int i11, Object obj) {
        this.f16434b = i11;
        this.f16436n = obj;
        this.f16435m = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f16434b;
        int i11 = this.f16435m;
        Object obj = this.f16436n;
        switch (i10) {
            case 0:
                ((g.e) obj).onFontRetrievalFailed(i11);
                break;
            case 1:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                View view = (View) sideSheetBehavior.A.get();
                if (view != null) {
                    sideSheetBehavior.d(view, false, i11);
                    break;
                }
                break;
            default:
                w wVar = (w) obj;
                wVar.f592j.clearFocus();
                wVar.f592j.scrollToPosition(i11);
                break;
        }
    }
}
