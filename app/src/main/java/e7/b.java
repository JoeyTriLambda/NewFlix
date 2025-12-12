package e7;

import android.graphics.drawable.Drawable;
import t.c;

/* compiled from: ScaledDrawableWrapper.java */
/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: m, reason: collision with root package name */
    public final int f11167m;

    /* renamed from: n, reason: collision with root package name */
    public final int f11168n;

    public b(Drawable drawable, int i10, int i11) {
        super(drawable);
        this.f11167m = i10;
        this.f11168n = i11;
    }

    @Override // t.c, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f11168n;
    }

    @Override // t.c, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f11167m;
    }
}
