package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.k;
import androidx.appcompat.widget.s0;
import java.lang.ref.WeakReference;

/* compiled from: TintResources.java */
/* loaded from: classes.dex */
public final class b1 extends t0 {

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference<Context> f1271b;

    public b1(Context context, Resources resources) {
        super(resources);
        this.f1271b = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i10) throws Resources.NotFoundException {
        s0.f fVar;
        Drawable drawableA = a(i10);
        Context context = this.f1271b.get();
        if (drawableA != null && context != null && (fVar = s0.get().f1517g) != null) {
            ((k.a) fVar).tintDrawableUsingColorFilter(context, i10, drawableA);
        }
        return drawableA;
    }
}
