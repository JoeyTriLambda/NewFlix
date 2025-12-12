package o7;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import p0.c;
import q7.g;
import q7.l;
import q7.p;

/* compiled from: RippleDrawableCompat.java */
/* loaded from: classes.dex */
public final class a extends Drawable implements p, c {

    /* renamed from: b, reason: collision with root package name */
    public C0211a f17029b;

    /* compiled from: RippleDrawableCompat.java */
    /* renamed from: o7.a$a, reason: collision with other inner class name */
    public static final class C0211a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final g f17030a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f17031b;

        public C0211a(g gVar) {
            this.f17030a = gVar;
            this.f17031b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public a newDrawable() {
            return new a(new C0211a(this));
        }

        public C0211a(C0211a c0211a) {
            this.f17030a = (g) c0211a.f17030a.getConstantState().newDrawable();
            this.f17031b = c0211a.f17031b;
        }
    }

    public a(l lVar) {
        this(new C0211a(new g(lVar)));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        C0211a c0211a = this.f17029b;
        if (c0211a.f17031b) {
            c0211a.f17030a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f17029b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f17029b.f17030a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f17029b.f17030a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f17029b.f17030a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zShouldDrawRippleCompat = b.shouldDrawRippleCompat(iArr);
        C0211a c0211a = this.f17029b;
        if (c0211a.f17031b == zShouldDrawRippleCompat) {
            return zOnStateChange;
        }
        c0211a.f17031b = zShouldDrawRippleCompat;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f17029b.f17030a.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f17029b.f17030a.setColorFilter(colorFilter);
    }

    @Override // q7.p
    public void setShapeAppearanceModel(l lVar) {
        this.f17029b.f17030a.setShapeAppearanceModel(lVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        this.f17029b.f17030a.setTint(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f17029b.f17030a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f17029b.f17030a.setTintMode(mode);
    }

    public a(C0211a c0211a) {
        this.f17029b = c0211a;
    }

    @Override // android.graphics.drawable.Drawable
    public a mutate() {
        this.f17029b = new C0211a(this.f17029b);
        return this;
    }
}
