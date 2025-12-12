package androidx.mediarouter.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: MediaRouteControllerDialog.java */
/* loaded from: classes.dex */
public final class i extends Animation {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3682b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f3683m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ View f3684n;

    public i(int i10, int i11, ViewGroup viewGroup) {
        this.f3682b = i10;
        this.f3683m = i11;
        this.f3684n = viewGroup;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f10, Transformation transformation) {
        int i10 = this.f3683m;
        h.j(this.f3684n, this.f3682b - ((int) ((r0 - i10) * f10)));
    }
}
