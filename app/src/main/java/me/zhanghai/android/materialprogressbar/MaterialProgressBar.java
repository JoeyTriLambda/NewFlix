package me.zhanghai.android.materialprogressbar;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ProgressBar;
import me.zhanghai.android.materialprogressbar.internal.DrawableCompat;

/* loaded from: classes2.dex */
public class MaterialProgressBar extends ProgressBar {
    public static final int PROGRESS_STYLE_CIRCULAR = 0;
    public static final int PROGRESS_STYLE_HORIZONTAL = 1;
    private static final String TAG = "MaterialProgressBar";
    private int mProgressStyle;
    private TintInfo mProgressTint;

    public static class TintInfo {
        boolean mHasTintList;
        boolean mHasTintMode;
        ColorStateList mTintList;
        PorterDuff.Mode mTintMode;

        private TintInfo() {
        }
    }

    public MaterialProgressBar(Context context) {
        super(context);
        this.mProgressTint = new TintInfo();
        init(context, null, 0, 0);
    }

    private void applyDeterminateProgressTint() {
        Drawable progressDrawable;
        TintInfo tintInfo = this.mProgressTint;
        if ((tintInfo.mHasTintList || tintInfo.mHasTintMode) && (progressDrawable = getProgressDrawable()) != null) {
            applyTintForDrawable(progressDrawable, this.mProgressTint);
        }
    }

    private void applyIndeterminateProgressTint() {
        Drawable indeterminateDrawable;
        TintInfo tintInfo = this.mProgressTint;
        if ((tintInfo.mHasTintList || tintInfo.mHasTintMode) && (indeterminateDrawable = getIndeterminateDrawable()) != null) {
            applyTintForDrawable(indeterminateDrawable, this.mProgressTint);
        }
    }

    private void applyProgressTint() {
        applyDeterminateProgressTint();
        applyIndeterminateProgressTint();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"NewApi"})
    private void applyTintForDrawable(Drawable drawable, TintInfo tintInfo) {
        boolean z10 = tintInfo.mHasTintList;
        if (z10 || tintInfo.mHasTintMode) {
            if (z10) {
                if (drawable instanceof TintableDrawable) {
                    ((TintableDrawable) drawable).setTintList(tintInfo.mTintList);
                } else {
                    Log.w(TAG, "drawable did not implement TintableDrawable, it won't be tinted below Lollipop");
                    drawable.setTintList(tintInfo.mTintList);
                }
            }
            if (tintInfo.mHasTintMode) {
                if (drawable instanceof TintableDrawable) {
                    ((TintableDrawable) drawable).setTintMode(tintInfo.mTintMode);
                } else {
                    Log.w(TAG, "drawable did not implement TintableDrawable, it won't be tinted below Lollipop");
                    drawable.setTintMode(tintInfo.mTintMode);
                }
            }
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
        }
    }

    private void init(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialProgressBar, i10, i11);
        this.mProgressStyle = typedArrayObtainStyledAttributes.getInt(R.styleable.MaterialProgressBar_mpb_progressStyle, 0);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialProgressBar_mpb_setBothDrawables, false);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialProgressBar_mpb_useIntrinsicPadding, true);
        boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialProgressBar_mpb_showTrack, this.mProgressStyle == 1);
        int i12 = R.styleable.MaterialProgressBar_android_tint;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            this.mProgressTint.mTintList = typedArrayObtainStyledAttributes.getColorStateList(i12);
            this.mProgressTint.mHasTintList = true;
        }
        int i13 = R.styleable.MaterialProgressBar_mpb_tintMode;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            this.mProgressTint.mTintMode = DrawableCompat.parseTintMode(typedArrayObtainStyledAttributes.getInt(i13, -1), null);
            this.mProgressTint.mHasTintMode = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        int i14 = this.mProgressStyle;
        if (i14 != 0) {
            if (i14 != 1) {
                throw new IllegalArgumentException("Unknown progress style: " + this.mProgressStyle);
            }
            if (isIndeterminate() || z10) {
                setIndeterminateDrawable(new IndeterminateHorizontalProgressDrawable(context));
            }
            if (!isIndeterminate() || z10) {
                setProgressDrawable(new HorizontalProgressDrawable(context));
            }
        } else {
            if (!isIndeterminate() || z10) {
                throw new UnsupportedOperationException("Determinate circular drawable is not yet supported");
            }
            setIndeterminateDrawable(new IndeterminateProgressDrawable(context));
        }
        setUseIntrinsicPadding(z11);
        setShowTrack(z12);
    }

    public Drawable getDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getProgressStyle() {
        return this.mProgressStyle;
    }

    @Override // android.widget.ProgressBar
    public ColorStateList getProgressTintList() {
        return this.mProgressTint.mTintList;
    }

    @Override // android.widget.ProgressBar
    public PorterDuff.Mode getProgressTintMode() {
        return this.mProgressTint.mTintMode;
    }

    public boolean getShowTrack() {
        Object drawable = getDrawable();
        if (drawable instanceof ShowTrackDrawable) {
            return ((ShowTrackDrawable) drawable).getShowTrack();
        }
        return false;
    }

    public boolean getUseIntrinsicPadding() {
        Object drawable = getDrawable();
        if (drawable instanceof IntrinsicPaddingDrawable) {
            return ((IntrinsicPaddingDrawable) drawable).getUseIntrinsicPadding();
        }
        throw new IllegalStateException("Drawable does not implement IntrinsicPaddingDrawable");
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        super.setIndeterminateDrawable(drawable);
        if (this.mProgressTint != null) {
            applyIndeterminateProgressTint();
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        super.setProgressDrawable(drawable);
        if (this.mProgressTint != null) {
            applyDeterminateProgressTint();
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgressTintList(ColorStateList colorStateList) {
        TintInfo tintInfo = this.mProgressTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        applyProgressTint();
    }

    @Override // android.widget.ProgressBar
    public void setProgressTintMode(PorterDuff.Mode mode) {
        TintInfo tintInfo = this.mProgressTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        applyProgressTint();
    }

    public void setShowTrack(boolean z10) {
        Object drawable = getDrawable();
        if (drawable instanceof ShowTrackDrawable) {
            ((ShowTrackDrawable) drawable).setShowTrack(z10);
        } else if (z10) {
            throw new IllegalStateException("Drawable does not implement ShowTrackDrawable");
        }
    }

    public void setUseIntrinsicPadding(boolean z10) {
        Object drawable = getDrawable();
        if (!(drawable instanceof IntrinsicPaddingDrawable)) {
            throw new IllegalStateException("Drawable does not implement IntrinsicPaddingDrawable");
        }
        ((IntrinsicPaddingDrawable) drawable).setUseIntrinsicPadding(z10);
    }

    public MaterialProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgressTint = new TintInfo();
        init(context, attributeSet, 0, 0);
    }

    public MaterialProgressBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mProgressTint = new TintInfo();
        init(context, attributeSet, i10, 0);
    }

    @TargetApi(21)
    public MaterialProgressBar(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mProgressTint = new TintInfo();
        init(context, attributeSet, i10, i11);
    }
}
