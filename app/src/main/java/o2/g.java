package o2;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* compiled from: SwipeRefreshLayout.java */
/* loaded from: classes.dex */
public final class g extends Animation {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f16989b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f16990m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f16991n;

    public g(SwipeRefreshLayout swipeRefreshLayout, int i10, int i11) {
        this.f16991n = swipeRefreshLayout;
        this.f16989b = i10;
        this.f16990m = i11;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f10, Transformation transformation) {
        this.f16991n.K.setAlpha((int) (((this.f16990m - r0) * f10) + this.f16989b));
    }
}
