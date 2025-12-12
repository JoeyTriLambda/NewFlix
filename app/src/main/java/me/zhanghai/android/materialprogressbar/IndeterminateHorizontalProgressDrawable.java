package me.zhanghai.android.materialprogressbar;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import androidx.annotation.Keep;
import me.zhanghai.android.materialprogressbar.internal.ThemeUtils;

/* loaded from: classes2.dex */
public class IndeterminateHorizontalProgressDrawable extends IndeterminateProgressDrawableBase implements ShowTrackDrawable {
    private static final float PADDED_INTRINSIC_HEIGHT_DP = 16.0f;
    private static final float PROGRESS_INTRINSIC_HEIGHT_DP = 3.2f;
    private int mPaddedIntrinsicHeight;
    private int mProgressIntrinsicHeight;
    private RectTransformX mRect1TransformX;
    private RectTransformX mRect2TransformX;
    private boolean mShowTrack;
    private float mTrackAlpha;
    private static final RectF RECT_BOUND = new RectF(-180.0f, -1.0f, 180.0f, 1.0f);
    private static final RectF RECT_PADDED_BOUND = new RectF(-180.0f, -5.0f, 180.0f, 5.0f);
    private static final RectF RECT_PROGRESS = new RectF(-144.0f, -1.0f, 144.0f, 1.0f);
    private static final RectTransformX RECT_1_TRANSFORM_X = new RectTransformX(-522.6f, 0.1f);
    private static final RectTransformX RECT_2_TRANSFORM_X = new RectTransformX(-197.6f, 0.1f);

    public IndeterminateHorizontalProgressDrawable(Context context) {
        super(context);
        this.mShowTrack = true;
        this.mRect1TransformX = new RectTransformX(RECT_1_TRANSFORM_X);
        this.mRect2TransformX = new RectTransformX(RECT_2_TRANSFORM_X);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.mProgressIntrinsicHeight = Math.round(PROGRESS_INTRINSIC_HEIGHT_DP * f10);
        this.mPaddedIntrinsicHeight = Math.round(f10 * PADDED_INTRINSIC_HEIGHT_DP);
        this.mTrackAlpha = ThemeUtils.getFloatFromAttrRes(android.R.attr.disabledAlpha, context);
        this.mAnimators = new Animator[]{Animators.createIndeterminateHorizontalRect1(this.mRect1TransformX), Animators.createIndeterminateHorizontalRect2(this.mRect2TransformX)};
    }

    private static void drawProgressRect(Canvas canvas, RectTransformX rectTransformX, Paint paint) {
        int iSave = canvas.save();
        canvas.translate(rectTransformX.mTranslateX, 0.0f);
        canvas.scale(rectTransformX.mScaleX, 1.0f);
        canvas.drawRect(RECT_PROGRESS, paint);
        canvas.restoreToCount(iSave);
    }

    private static void drawTrackRect(Canvas canvas, Paint paint) {
        canvas.drawRect(RECT_BOUND, paint);
    }

    @Override // me.zhanghai.android.materialprogressbar.IndeterminateProgressDrawableBase, me.zhanghai.android.materialprogressbar.ProgressDrawableBase, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // me.zhanghai.android.materialprogressbar.ProgressDrawableBase, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mUseIntrinsicPadding ? this.mPaddedIntrinsicHeight : this.mProgressIntrinsicHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        int i10 = this.mAlpha;
        if (i10 == 0) {
            return -2;
        }
        if (i10 == 255) {
            return (!this.mShowTrack || this.mTrackAlpha == 1.0f) ? -1 : -3;
        }
        return -3;
    }

    @Override // me.zhanghai.android.materialprogressbar.ShowTrackDrawable
    public boolean getShowTrack() {
        return this.mShowTrack;
    }

    @Override // me.zhanghai.android.materialprogressbar.ProgressDrawableBase, me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable
    public /* bridge */ /* synthetic */ boolean getUseIntrinsicPadding() {
        return super.getUseIntrinsicPadding();
    }

    @Override // me.zhanghai.android.materialprogressbar.IndeterminateProgressDrawableBase, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // me.zhanghai.android.materialprogressbar.ProgressDrawableBase
    public void onDraw(Canvas canvas, int i10, int i11, Paint paint) {
        if (this.mUseIntrinsicPadding) {
            RectF rectF = RECT_PADDED_BOUND;
            canvas.scale(i10 / rectF.width(), i11 / rectF.height());
            canvas.translate(rectF.width() / 2.0f, rectF.height() / 2.0f);
        } else {
            RectF rectF2 = RECT_BOUND;
            canvas.scale(i10 / rectF2.width(), i11 / rectF2.height());
            canvas.translate(rectF2.width() / 2.0f, rectF2.height() / 2.0f);
        }
        if (this.mShowTrack) {
            paint.setAlpha(Math.round(this.mAlpha * this.mTrackAlpha));
            drawTrackRect(canvas, paint);
            paint.setAlpha(this.mAlpha);
        }
        drawProgressRect(canvas, this.mRect2TransformX, paint);
        drawProgressRect(canvas, this.mRect1TransformX, paint);
    }

    @Override // me.zhanghai.android.materialprogressbar.ProgressDrawableBase
    public void onPreparePaint(Paint paint) {
        paint.setStyle(Paint.Style.FILL);
    }

    @Override // me.zhanghai.android.materialprogressbar.ProgressDrawableBase, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i10) {
        super.setAlpha(i10);
    }

    @Override // me.zhanghai.android.materialprogressbar.ProgressDrawableBase, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // me.zhanghai.android.materialprogressbar.ShowTrackDrawable
    public void setShowTrack(boolean z10) {
        if (this.mShowTrack != z10) {
            this.mShowTrack = z10;
            invalidateSelf();
        }
    }

    @Override // me.zhanghai.android.materialprogressbar.ProgressDrawableBase, android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable
    public /* bridge */ /* synthetic */ void setTint(int i10) {
        super.setTint(i10);
    }

    @Override // me.zhanghai.android.materialprogressbar.ProgressDrawableBase, android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // me.zhanghai.android.materialprogressbar.ProgressDrawableBase, android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // me.zhanghai.android.materialprogressbar.ProgressDrawableBase, me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable
    public /* bridge */ /* synthetic */ void setUseIntrinsicPadding(boolean z10) {
        super.setUseIntrinsicPadding(z10);
    }

    @Override // me.zhanghai.android.materialprogressbar.IndeterminateProgressDrawableBase, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // me.zhanghai.android.materialprogressbar.IndeterminateProgressDrawableBase, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    public static class RectTransformX {
        public float mScaleX;
        public float mTranslateX;

        public RectTransformX(float f10, float f11) {
            this.mTranslateX = f10;
            this.mScaleX = f11;
        }

        @Keep
        public void setScaleX(float f10) {
            this.mScaleX = f10;
        }

        @Keep
        public void setTranslateX(float f10) {
            this.mTranslateX = f10;
        }

        public RectTransformX(RectTransformX rectTransformX) {
            this.mTranslateX = rectTransformX.mTranslateX;
            this.mScaleX = rectTransformX.mScaleX;
        }
    }
}
