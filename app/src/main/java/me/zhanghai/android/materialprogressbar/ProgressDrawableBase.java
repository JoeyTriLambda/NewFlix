package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import me.zhanghai.android.materialprogressbar.internal.ThemeUtils;
import p0.a;

/* loaded from: classes2.dex */
abstract class ProgressDrawableBase extends Drawable implements IntrinsicPaddingDrawable, TintableDrawable {
    protected ColorFilter mColorFilter;
    private Paint mPaint;
    protected PorterDuffColorFilter mTintFilter;
    protected ColorStateList mTintList;
    protected boolean mUseIntrinsicPadding = true;
    protected int mAlpha = 255;
    protected PorterDuff.Mode mTintMode = PorterDuff.Mode.SRC_IN;

    public ProgressDrawableBase(Context context) {
        setTint(ThemeUtils.getColorFromAttrRes(R.attr.colorControlActivated, context));
    }

    private PorterDuffColorFilter makeTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private boolean needMirroring() {
        return a.isAutoMirrored(this) && a.getLayoutDirection(this) == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.width() == 0 || bounds.height() == 0) {
            return;
        }
        if (this.mPaint == null) {
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setColor(-16777216);
            onPreparePaint(this.mPaint);
        }
        this.mPaint.setAlpha(this.mAlpha);
        ColorFilter colorFilter = this.mColorFilter;
        if (colorFilter == null) {
            colorFilter = this.mTintFilter;
        }
        this.mPaint.setColorFilter(colorFilter);
        int iSave = canvas.save();
        canvas.translate(bounds.left, bounds.top);
        if (needMirroring()) {
            canvas.translate(bounds.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        onDraw(canvas, bounds.width(), bounds.height(), this.mPaint);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mColorFilter;
    }

    public boolean getUseIntrinsicPadding() {
        return this.mUseIntrinsicPadding;
    }

    public abstract void onDraw(Canvas canvas, int i10, int i11, Paint paint);

    public abstract void onPreparePaint(Paint paint);

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.mAlpha != i10) {
            this.mAlpha = i10;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable
    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable
    public void setTintList(ColorStateList colorStateList) {
        this.mTintList = colorStateList;
        this.mTintFilter = makeTintFilter(colorStateList, this.mTintMode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.mTintMode = mode;
        this.mTintFilter = makeTintFilter(this.mTintList, mode);
        invalidateSelf();
    }

    public void setUseIntrinsicPadding(boolean z10) {
        if (this.mUseIntrinsicPadding != z10) {
            this.mUseIntrinsicPadding = z10;
            invalidateSelf();
        }
    }
}
