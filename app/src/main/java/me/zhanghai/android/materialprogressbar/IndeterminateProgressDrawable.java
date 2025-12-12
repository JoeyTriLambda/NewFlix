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

/* loaded from: classes2.dex */
public class IndeterminateProgressDrawable extends IndeterminateProgressDrawableBase {
    private static final float PADDED_INTRINSIC_SIZE_DP = 16.0f;
    private static final float PROGRESS_INTRINSIC_SIZE_DP = 3.2f;
    private static final RectF RECT_BOUND = new RectF(-21.0f, -21.0f, 21.0f, 21.0f);
    private static final RectF RECT_PADDED_BOUND = new RectF(-24.0f, -24.0f, 24.0f, 24.0f);
    private static final RectF RECT_PROGRESS = new RectF(-19.0f, -19.0f, 19.0f, 19.0f);
    private int mPaddedIntrinsicSize;
    private int mProgressIntrinsicSize;
    private RingPathTransform mRingPathTransform;
    private RingRotation mRingRotation;

    public static class RingPathTransform {
        public float mTrimPathEnd;
        public float mTrimPathOffset;
        public float mTrimPathStart;

        private RingPathTransform() {
        }

        @Keep
        public void setTrimPathEnd(float f10) {
            this.mTrimPathEnd = f10;
        }

        @Keep
        public void setTrimPathOffset(float f10) {
            this.mTrimPathOffset = f10;
        }

        @Keep
        public void setTrimPathStart(float f10) {
            this.mTrimPathStart = f10;
        }
    }

    public static class RingRotation {
        private float mRotation;

        private RingRotation() {
        }

        @Keep
        public void setRotation(float f10) {
            this.mRotation = f10;
        }
    }

    public IndeterminateProgressDrawable(Context context) {
        super(context);
        this.mRingPathTransform = new RingPathTransform();
        this.mRingRotation = new RingRotation();
        float f10 = context.getResources().getDisplayMetrics().density;
        this.mProgressIntrinsicSize = Math.round(PROGRESS_INTRINSIC_SIZE_DP * f10);
        this.mPaddedIntrinsicSize = Math.round(f10 * PADDED_INTRINSIC_SIZE_DP);
        this.mAnimators = new Animator[]{Animators.createIndeterminate(this.mRingPathTransform), Animators.createIndeterminateRotation(this.mRingRotation)};
    }

    private void drawRing(Canvas canvas, Paint paint) {
        int iSave = canvas.save();
        canvas.rotate(this.mRingRotation.mRotation);
        RingPathTransform ringPathTransform = this.mRingPathTransform;
        float f10 = ringPathTransform.mTrimPathOffset;
        canvas.drawArc(RECT_PROGRESS, ((f10 + r3) * 360.0f) - 90.0f, (ringPathTransform.mTrimPathEnd - ringPathTransform.mTrimPathStart) * 360.0f, false, paint);
        canvas.restoreToCount(iSave);
    }

    private int getIntrinsicSize() {
        return this.mUseIntrinsicPadding ? this.mPaddedIntrinsicSize : this.mProgressIntrinsicSize;
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
        return getIntrinsicSize();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return getIntrinsicSize();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        int i10 = this.mAlpha;
        if (i10 == 0) {
            return -2;
        }
        return i10 == 255 ? -1 : -3;
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
        drawRing(canvas, paint);
    }

    @Override // me.zhanghai.android.materialprogressbar.ProgressDrawableBase
    public void onPreparePaint(Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4.0f);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setStrokeJoin(Paint.Join.MITER);
    }

    @Override // me.zhanghai.android.materialprogressbar.ProgressDrawableBase, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i10) {
        super.setAlpha(i10);
    }

    @Override // me.zhanghai.android.materialprogressbar.ProgressDrawableBase, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
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
}
