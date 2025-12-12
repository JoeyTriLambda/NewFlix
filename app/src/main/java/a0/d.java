package a0;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: RoundRectDrawable.java */
/* loaded from: classes.dex */
public final class d extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public float f32a;

    /* renamed from: c, reason: collision with root package name */
    public final RectF f34c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f35d;

    /* renamed from: e, reason: collision with root package name */
    public float f36e;

    /* renamed from: h, reason: collision with root package name */
    public ColorStateList f39h;

    /* renamed from: i, reason: collision with root package name */
    public PorterDuffColorFilter f40i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f41j;

    /* renamed from: f, reason: collision with root package name */
    public boolean f37f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f38g = true;

    /* renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f42k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f33b = new Paint(5);

    public d(float f10, ColorStateList colorStateList) {
        this.f32a = f10;
        b(colorStateList);
        this.f34c = new RectF();
        this.f35d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f39h = colorStateList;
        this.f33b.setColor(colorStateList.getColorForState(getState(), this.f39h.getDefaultColor()));
    }

    public final void c(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        RectF rectF = this.f34c;
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
        Rect rect2 = this.f35d;
        rect2.set(rect);
        if (this.f37f) {
            float fA = e.a(this.f36e, this.f32a, this.f38g);
            float f10 = this.f36e;
            float f11 = this.f32a;
            if (this.f38g) {
                f10 = (float) (((1.0d - e.f43a) * f11) + f10);
            }
            rect2.inset((int) Math.ceil(f10), (int) Math.ceil(fA));
            rectF.set(rect2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z10;
        Paint paint = this.f33b;
        if (this.f40i == null || paint.getColorFilter() != null) {
            z10 = false;
        } else {
            paint.setColorFilter(this.f40i);
            z10 = true;
        }
        RectF rectF = this.f34c;
        float f10 = this.f32a;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        if (z10) {
            paint.setColorFilter(null);
        }
    }

    public ColorStateList getColor() {
        return this.f39h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f35d, this.f32a);
    }

    public float getRadius() {
        return this.f32a;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f41j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f39h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        c(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f39h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        Paint paint = this.f33b;
        boolean z10 = colorForState != paint.getColor();
        if (z10) {
            paint.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f41j;
        if (colorStateList2 == null || (mode = this.f42k) == null) {
            return z10;
        }
        this.f40i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f33b.setAlpha(i10);
    }

    public void setColor(ColorStateList colorStateList) {
        b(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f33b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f41j = colorStateList;
        this.f40i = a(colorStateList, this.f42k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f42k = mode;
        this.f40i = a(this.f41j, mode);
        invalidateSelf();
    }
}
