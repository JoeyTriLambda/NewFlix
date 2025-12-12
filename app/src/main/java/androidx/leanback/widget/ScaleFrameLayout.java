package androidx.leanback.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ScaleFrameLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public float f3113b;

    /* renamed from: m, reason: collision with root package name */
    public float f3114m;

    /* renamed from: n, reason: collision with root package name */
    public float f3115n;

    public ScaleFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        view.setScaleX(this.f3115n);
        view.setScaleY(this.f3115n);
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        boolean zAddViewInLayout = super.addViewInLayout(view, i10, layoutParams, z10);
        if (zAddViewInLayout) {
            view.setScaleX(this.f3115n);
            view.setScaleY(this.f3115n);
        }
        return zAddViewInLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00da  */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.ScaleFrameLayout.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        float f10 = this.f3113b;
        if (f10 == 1.0f && this.f3114m == 1.0f) {
            super.onMeasure(i10, i11);
            return;
        }
        if (f10 != 1.0f) {
            i10 = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(i10) / f10) + 0.5f), View.MeasureSpec.getMode(i10));
        }
        float f11 = this.f3114m;
        if (f11 != 1.0f) {
            i11 = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(i11) / f11) + 0.5f), View.MeasureSpec.getMode(i11));
        }
        super.onMeasure(i10, i11);
        setMeasuredDimension((int) ((getMeasuredWidth() * this.f3113b) + 0.5f), (int) ((getMeasuredHeight() * this.f3114m) + 0.5f));
    }

    public void setChildScale(float f10) {
        if (this.f3115n != f10) {
            this.f3115n = f10;
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                getChildAt(i10).setScaleX(f10);
                getChildAt(i10).setScaleY(f10);
            }
        }
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        throw new UnsupportedOperationException();
    }

    public void setLayoutScaleX(float f10) {
        if (f10 != this.f3113b) {
            this.f3113b = f10;
            requestLayout();
        }
    }

    public void setLayoutScaleY(float f10) {
        if (f10 != this.f3114m) {
            this.f3114m = f10;
            requestLayout();
        }
    }

    public ScaleFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3113b = 1.0f;
        this.f3114m = 1.0f;
        this.f3115n = 1.0f;
    }
}
