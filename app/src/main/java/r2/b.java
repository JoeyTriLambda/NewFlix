package r2;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* compiled from: Animatable2Compat.java */
/* loaded from: classes.dex */
public final class b extends Animatable2.AnimationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f18366a;

    public b(c cVar) {
        this.f18366a = cVar;
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public void onAnimationEnd(Drawable drawable) {
        this.f18366a.onAnimationEnd(drawable);
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public void onAnimationStart(Drawable drawable) {
        this.f18366a.onAnimationStart(drawable);
    }
}
