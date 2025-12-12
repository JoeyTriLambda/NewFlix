package t6;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import y0.g;

/* compiled from: BottomSheetBehavior.java */
/* loaded from: classes.dex */
public final class c implements g {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19462b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f19463m;

    public c(BottomSheetBehavior bottomSheetBehavior, int i10) {
        this.f19463m = bottomSheetBehavior;
        this.f19462b = i10;
    }

    @Override // y0.g
    public boolean perform(View view, g.a aVar) {
        this.f19463m.setState(this.f19462b);
        return true;
    }
}
