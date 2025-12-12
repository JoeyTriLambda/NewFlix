package o2;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* compiled from: SwipeRefreshLayout.java */
/* loaded from: classes.dex */
public final class e extends Animation {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f16987b;

    public e(SwipeRefreshLayout swipeRefreshLayout) {
        this.f16987b = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f10, Transformation transformation) {
        this.f16987b.setAnimationProgress(f10);
    }
}
