package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.R;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.Keep;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzep;
import com.google.android.gms.internal.cast.zzeq;
import o0.a;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
class OuterHighlightDrawable extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final int f6407a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6408b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6409c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f6410d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    public final Rect f6411e = new Rect();

    /* renamed from: f, reason: collision with root package name */
    public final Paint f6412f;

    /* renamed from: g, reason: collision with root package name */
    public float f6413g;

    /* renamed from: h, reason: collision with root package name */
    public float f6414h;

    /* renamed from: i, reason: collision with root package name */
    public float f6415i;

    /* renamed from: j, reason: collision with root package name */
    public float f6416j;

    /* renamed from: k, reason: collision with root package name */
    public float f6417k;

    /* renamed from: l, reason: collision with root package name */
    public float f6418l;

    /* renamed from: m, reason: collision with root package name */
    public int f6419m;

    public OuterHighlightDrawable(Context context) throws Resources.NotFoundException {
        int color;
        Paint paint = new Paint();
        this.f6412f = paint;
        this.f6414h = 1.0f;
        this.f6417k = 0.0f;
        this.f6418l = 0.0f;
        this.f6419m = 244;
        if (PlatformVersion.isAtLeastLollipop()) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
            color = a.setAlphaComponent(typedValue.data, 244);
        } else {
            color = context.getResources().getColor(com.google.android.gms.cast.framework.R.color.cast_libraries_material_featurehighlight_outer_highlight_default_color);
        }
        paint.setColor(color);
        this.f6419m = paint.getAlpha();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Resources resources = context.getResources();
        this.f6407a = resources.getDimensionPixelSize(com.google.android.gms.cast.framework.R.dimen.cast_libraries_material_featurehighlight_center_threshold);
        this.f6408b = resources.getDimensionPixelSize(com.google.android.gms.cast.framework.R.dimen.cast_libraries_material_featurehighlight_center_horizontal_offset);
        this.f6409c = resources.getDimensionPixelSize(com.google.android.gms.cast.framework.R.dimen.cast_libraries_material_featurehighlight_outer_padding);
    }

    public static final float a(float f10, float f11, Rect rect) {
        float f12 = rect.left;
        float f13 = rect.top;
        float f14 = rect.right;
        float f15 = rect.bottom;
        float fZza = zzeq.zza(f10, f11, f12, f13);
        float fZza2 = zzeq.zza(f10, f11, f14, f13);
        float fZza3 = zzeq.zza(f10, f11, f14, f15);
        float fZza4 = zzeq.zza(f10, f11, f12, f15);
        if (fZza <= fZza2 || fZza <= fZza3 || fZza <= fZza4) {
            fZza = (fZza2 <= fZza3 || fZza2 <= fZza4) ? fZza3 <= fZza4 ? fZza4 : fZza3 : fZza2;
        }
        return (float) Math.ceil(fZza);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        canvas.drawCircle(this.f6415i + this.f6417k, this.f6416j + this.f6418l, this.f6413g * this.f6414h, this.f6412f);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f6412f.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        this.f6412f.setAlpha(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f6412f.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Keep
    public void setScale(float f10) {
        this.f6414h = f10;
        invalidateSelf();
    }

    @Keep
    public void setTranslationX(float f10) {
        this.f6417k = f10;
        invalidateSelf();
    }

    @Keep
    public void setTranslationY(float f10) {
        this.f6418l = f10;
        invalidateSelf();
    }

    public final float zza() {
        return this.f6415i;
    }

    public final float zzb() {
        return this.f6416j;
    }

    public final int zzc() {
        return this.f6412f.getColor();
    }

    public final Animator zzd(float f10, float f11) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scale", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationX", f10, 0.0f), PropertyValuesHolder.ofFloat("translationY", f11, 0.0f), PropertyValuesHolder.ofInt("alpha", 0, this.f6419m));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(zzep.zzc());
        return objectAnimatorOfPropertyValuesHolder.setDuration(350L);
    }

    public final void zze(int i10) {
        Paint paint = this.f6412f;
        paint.setColor(i10);
        this.f6419m = paint.getAlpha();
        invalidateSelf();
    }

    public final void zzf(Rect rect, Rect rect2) {
        this.f6410d.set(rect);
        this.f6411e.set(rect2);
        float fExactCenterX = rect.exactCenterX();
        float fExactCenterY = rect.exactCenterY();
        Rect bounds = getBounds();
        if (Math.min(fExactCenterY - bounds.top, bounds.bottom - fExactCenterY) < this.f6407a) {
            this.f6415i = fExactCenterX;
            this.f6416j = fExactCenterY;
        } else {
            float fExactCenterX2 = bounds.exactCenterX();
            int i10 = this.f6408b;
            this.f6415i = fExactCenterX <= fExactCenterX2 ? rect2.exactCenterX() + i10 : rect2.exactCenterX() - i10;
            fExactCenterY = rect2.exactCenterY();
            this.f6416j = fExactCenterY;
        }
        this.f6413g = this.f6409c + Math.max(a(this.f6415i, fExactCenterY, rect), a(this.f6415i, this.f6416j, rect2));
        invalidateSelf();
    }

    public final boolean zzg(float f10, float f11) {
        return zzeq.zza(f10, f11, this.f6415i, this.f6416j) < this.f6413g;
    }
}
