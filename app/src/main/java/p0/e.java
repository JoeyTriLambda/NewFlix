package p0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* compiled from: WrappedDrawableApi14.java */
/* loaded from: classes.dex */
public class e extends Drawable implements Drawable.Callback, d, c {

    /* renamed from: r, reason: collision with root package name */
    public static final PorterDuff.Mode f17408r = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public int f17409b;

    /* renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f17410m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f17411n;

    /* renamed from: o, reason: collision with root package name */
    public g f17412o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f17413p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f17414q;

    public e(g gVar, Resources resources) {
        Drawable.ConstantState constantState;
        this.f17412o = gVar;
        if (gVar == null || (constantState = gVar.f17417b) == null) {
            return;
        }
        setWrappedDrawable(constantState.newDrawable(resources));
    }

    public final boolean a(int[] iArr) {
        if (!isCompatTintEnabled()) {
            return false;
        }
        g gVar = this.f17412o;
        ColorStateList colorStateList = gVar.f17418c;
        PorterDuff.Mode mode = gVar.f17419d;
        if (colorStateList == null || mode == null) {
            this.f17411n = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f17411n || colorForState != this.f17409b || mode != this.f17410m) {
                setColorFilter(colorForState, mode);
                this.f17409b = colorForState;
                this.f17410m = mode;
                this.f17411n = true;
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f17414q.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        g gVar = this.f17412o;
        return changingConfigurations | (gVar != null ? gVar.getChangingConfigurations() : 0) | this.f17414q.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        g gVar = this.f17412o;
        if (gVar == null) {
            return null;
        }
        if (!(gVar.f17417b != null)) {
            return null;
        }
        gVar.f17416a = getChangingConfigurations();
        return this.f17412o;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f17414q.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f17414q.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f17414q.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return a.getLayoutDirection(this.f17414q);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f17414q.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f17414q.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f17414q.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f17414q.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f17414q.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f17414q.getTransparentRegion();
    }

    @Override // p0.d
    public final Drawable getWrappedDrawable() {
        return this.f17414q;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return a.isAutoMirrored(this.f17414q);
    }

    public boolean isCompatTintEnabled() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        g gVar;
        ColorStateList colorStateList = (!isCompatTintEnabled() || (gVar = this.f17412o) == null) ? null : gVar.f17418c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f17414q.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f17414q.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f17413p && super.mutate() == this) {
            this.f17412o = new g(this.f17412o);
            Drawable drawable = this.f17414q;
            if (drawable != null) {
                drawable.mutate();
            }
            g gVar = this.f17412o;
            if (gVar != null) {
                Drawable drawable2 = this.f17414q;
                gVar.f17417b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f17413p = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f17414q;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i10) {
        return a.setLayoutDirection(this.f17414q, i10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        return this.f17414q.setLevel(i10);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f17414q.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        a.setAutoMirrored(this.f17414q, z10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i10) {
        this.f17414q.setChangingConfigurations(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f17414q.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        this.f17414q.setDither(z10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z10) {
        this.f17414q.setFilterBitmap(z10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return a(iArr) || this.f17414q.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f17412o.f17418c = colorStateList;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f17412o.f17419d = mode;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        return super.setVisible(z10, z11) || this.f17414q.setVisible(z10, z11);
    }

    @Override // p0.d
    public final void setWrappedDrawable(Drawable drawable) {
        Drawable drawable2 = this.f17414q;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f17414q = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            g gVar = this.f17412o;
            if (gVar != null) {
                gVar.f17417b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public e(Drawable drawable) {
        this.f17412o = new g(this.f17412o);
        setWrappedDrawable(drawable);
    }
}
