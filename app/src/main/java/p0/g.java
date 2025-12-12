package p0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* compiled from: WrappedDrawableState.java */
/* loaded from: classes.dex */
public final class g extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public int f17416a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable.ConstantState f17417b;

    /* renamed from: c, reason: collision with root package name */
    public ColorStateList f17418c;

    /* renamed from: d, reason: collision with root package name */
    public PorterDuff.Mode f17419d;

    public g(g gVar) {
        this.f17418c = null;
        this.f17419d = e.f17408r;
        if (gVar != null) {
            this.f17416a = gVar.f17416a;
            this.f17417b = gVar.f17417b;
            this.f17418c = gVar.f17418c;
            this.f17419d = gVar.f17419d;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i10 = this.f17416a;
        Drawable.ConstantState constantState = this.f17417b;
        return i10 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return new f(this, resources);
    }
}
