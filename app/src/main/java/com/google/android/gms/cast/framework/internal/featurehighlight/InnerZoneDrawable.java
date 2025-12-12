package com.google.android.gms.cast.framework.internal.featurehighlight;

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
import androidx.annotation.Keep;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.internal.cast.zzep;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
class InnerZoneDrawable extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f6396a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f6397b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f6398c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6399d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6400e;

    /* renamed from: f, reason: collision with root package name */
    public float f6401f;

    /* renamed from: g, reason: collision with root package name */
    public float f6402g;

    /* renamed from: h, reason: collision with root package name */
    public float f6403h;

    /* renamed from: i, reason: collision with root package name */
    public float f6404i;

    /* renamed from: j, reason: collision with root package name */
    public float f6405j;

    /* renamed from: k, reason: collision with root package name */
    public float f6406k;

    public InnerZoneDrawable(Context context) {
        Paint paint = new Paint();
        this.f6396a = paint;
        Paint paint2 = new Paint();
        this.f6397b = paint2;
        this.f6398c = new Rect();
        this.f6402g = 1.0f;
        Resources resources = context.getResources();
        this.f6399d = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_inner_radius);
        this.f6400e = resources.getInteger(R.integer.cast_libraries_material_featurehighlight_pulse_base_alpha);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(-1);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        float f10 = this.f6406k;
        if (f10 > 0.0f) {
            float f11 = this.f6401f * this.f6405j;
            Paint paint = this.f6397b;
            paint.setAlpha((int) (this.f6400e * f10));
            canvas.drawCircle(this.f6403h, this.f6404i, f11, paint);
        }
        canvas.drawCircle(this.f6403h, this.f6404i, this.f6401f * this.f6402g, this.f6396a);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        this.f6396a.setAlpha(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f6396a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Keep
    public void setPulseAlpha(float f10) {
        this.f6406k = f10;
        invalidateSelf();
    }

    @Keep
    public void setPulseScale(float f10) {
        this.f6405j = f10;
        invalidateSelf();
    }

    @Keep
    public void setScale(float f10) {
        this.f6402g = f10;
        invalidateSelf();
    }

    public final Animator zza() {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scale", 0.0f), PropertyValuesHolder.ofInt("alpha", 0), PropertyValuesHolder.ofFloat("pulseScale", 0.0f), PropertyValuesHolder.ofFloat("pulseAlpha", 0.0f));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(zzep.zza());
        return objectAnimatorOfPropertyValuesHolder.setDuration(200L);
    }

    public final void zzb(Rect rect) {
        Rect rect2 = this.f6398c;
        rect2.set(rect);
        this.f6403h = rect2.exactCenterX();
        this.f6404i = rect2.exactCenterY();
        this.f6401f = Math.max(this.f6399d, Math.max(rect2.width() / 2.0f, rect2.height() / 2.0f));
        invalidateSelf();
    }
}
