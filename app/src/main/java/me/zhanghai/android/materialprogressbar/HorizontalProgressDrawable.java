package me.zhanghai.android.materialprogressbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import me.zhanghai.android.materialprogressbar.internal.ThemeUtils;

/* loaded from: classes2.dex */
public class HorizontalProgressDrawable extends LayerDrawable implements IntrinsicPaddingDrawable, ShowTrackDrawable, TintableDrawable {
    private SingleHorizontalProgressDrawable mProgressDrawable;
    private int mSecondaryAlpha;
    private SingleHorizontalProgressDrawable mSecondaryProgressDrawable;
    private SingleHorizontalProgressDrawable mTrackDrawable;

    public HorizontalProgressDrawable(Context context) {
        super(new Drawable[]{new SingleHorizontalProgressDrawable(context), new SingleHorizontalProgressDrawable(context), new SingleHorizontalProgressDrawable(context)});
        setId(0, android.R.id.background);
        this.mTrackDrawable = (SingleHorizontalProgressDrawable) getDrawable(0);
        setId(1, android.R.id.secondaryProgress);
        this.mSecondaryProgressDrawable = (SingleHorizontalProgressDrawable) getDrawable(1);
        int iRound = Math.round(ThemeUtils.getFloatFromAttrRes(android.R.attr.disabledAlpha, context) * 255.0f);
        this.mSecondaryAlpha = iRound;
        this.mSecondaryProgressDrawable.setAlpha(iRound);
        this.mSecondaryProgressDrawable.setShowTrack(false);
        setId(2, android.R.id.progress);
        SingleHorizontalProgressDrawable singleHorizontalProgressDrawable = (SingleHorizontalProgressDrawable) getDrawable(2);
        this.mProgressDrawable = singleHorizontalProgressDrawable;
        singleHorizontalProgressDrawable.setShowTrack(false);
    }

    @Override // me.zhanghai.android.materialprogressbar.ShowTrackDrawable
    public boolean getShowTrack() {
        return this.mTrackDrawable.getShowTrack();
    }

    @Override // me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable
    public boolean getUseIntrinsicPadding() {
        return this.mTrackDrawable.getUseIntrinsicPadding();
    }

    @Override // me.zhanghai.android.materialprogressbar.ShowTrackDrawable
    public void setShowTrack(boolean z10) {
        if (this.mTrackDrawable.getShowTrack() != z10) {
            this.mTrackDrawable.setShowTrack(z10);
            this.mSecondaryProgressDrawable.setAlpha(z10 ? this.mSecondaryAlpha : this.mSecondaryAlpha * 2);
        }
    }

    @Override // android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable
    @SuppressLint({"NewApi"})
    public void setTint(int i10) {
        this.mTrackDrawable.setTint(i10);
        this.mSecondaryProgressDrawable.setTint(i10);
        this.mProgressDrawable.setTint(i10);
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable
    @SuppressLint({"NewApi"})
    public void setTintList(ColorStateList colorStateList) {
        this.mTrackDrawable.setTintList(colorStateList);
        this.mSecondaryProgressDrawable.setTintList(colorStateList);
        this.mProgressDrawable.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable
    @SuppressLint({"NewApi"})
    public void setTintMode(PorterDuff.Mode mode) {
        this.mTrackDrawable.setTintMode(mode);
        this.mSecondaryProgressDrawable.setTintMode(mode);
        this.mProgressDrawable.setTintMode(mode);
    }

    @Override // me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable
    public void setUseIntrinsicPadding(boolean z10) {
        this.mTrackDrawable.setUseIntrinsicPadding(z10);
        this.mSecondaryProgressDrawable.setUseIntrinsicPadding(z10);
        this.mProgressDrawable.setUseIntrinsicPadding(z10);
    }
}
