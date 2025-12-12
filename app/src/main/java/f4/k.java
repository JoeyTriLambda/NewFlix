package f4;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: ValueGeneratorAnim.java */
/* loaded from: classes.dex */
public final class k extends Animation {

    /* renamed from: b, reason: collision with root package name */
    public final a f11516b;

    /* compiled from: ValueGeneratorAnim.java */
    public interface a {
        void onTimeUpdate(float f10);
    }

    public k(a aVar) {
        this.f11516b = aVar;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f10, Transformation transformation) {
        this.f11516b.onTimeUpdate(f10);
    }
}
