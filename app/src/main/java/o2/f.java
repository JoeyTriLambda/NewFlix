package o2;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* compiled from: SwipeRefreshLayout.java */
/* loaded from: classes.dex */
public final class f extends Animation {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f16988b;

    public f(SwipeRefreshLayout swipeRefreshLayout) {
        this.f16988b = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f10, Transformation transformation) {
        this.f16988b.setAnimationProgress(1.0f - f10);
    }
}
