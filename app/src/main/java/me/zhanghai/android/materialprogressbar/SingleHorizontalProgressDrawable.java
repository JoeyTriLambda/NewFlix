package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import me.zhanghai.android.materialprogressbar.internal.ThemeUtils;

/* loaded from: classes2.dex */
class SingleHorizontalProgressDrawable extends ProgressDrawableBase {
    private static final int LEVEL_MAX = 10000;
    private static final float PADDED_INTRINSIC_HEIGHT_DP = 16.0f;
    private static final float PROGRESS_INTRINSIC_HEIGHT_DP = 3.2f;
    private static final RectF RECT_BOUND = new RectF(-180.0f, -1.0f, 180.0f, 1.0f);
    private static final RectF RECT_PADDED_BOUND = new RectF(-180.0f, -5.0f, 180.0f, 5.0f);
    private int mPaddedIntrinsicHeight;
    private int mProgressIntrinsicHeight;
    private boolean mShowTrack;
    private float mTrackAlpha;

    public SingleHorizontalProgressDrawable(Context context) {
        super(context);
        this.mShowTrack = true;
        float f10 = context.getResources().getDisplayMetrics().density;
        this.mProgressIntrinsicHeight = Math.round(PROGRESS_INTRINSIC_HEIGHT_DP * f10);
        this.mPaddedIntrinsicHeight = Math.round(f10 * PADDED_INTRINSIC_HEIGHT_DP);
        this.mTrackAlpha = ThemeUtils.getFloatFromAttrRes(android.R.attr.disabledAlpha, context);
    }

    private void drawProgressRect(Canvas canvas, Paint paint) {
        int level = getLevel();
        if (level == 0) {
            return;
        }
        int iSave = canvas.save();
        RectF rectF = RECT_BOUND;
        canvas.scale(level / 10000.0f, 1.0f, rectF.left, 0.0f);
        canvas.drawRect(rectF, paint);
        canvas.restoreToCount(iSave);
    }

    private static void drawTrackRect(Canvas canvas, Paint paint) {
        canvas.drawRect(RECT_BOUND, paint);
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

    public boolean getShowTrack() {
        return this.mShowTrack;
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
        drawProgressRect(canvas, paint);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        invalidateSelf();
        return true;
    }

    @Override // me.zhanghai.android.materialprogressbar.ProgressDrawableBase
    public void onPreparePaint(Paint paint) {
        paint.setStyle(Paint.Style.FILL);
    }

    public void setShowTrack(boolean z10) {
        if (this.mShowTrack != z10) {
            this.mShowTrack = z10;
            invalidateSelf();
        }
    }
}
