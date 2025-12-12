package com.github.ybq.android.spinkit;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import i4.a;
import l4.f;

/* loaded from: classes.dex */
public class SpinKitView extends ProgressBar {

    /* renamed from: b, reason: collision with root package name */
    public int f5602b;

    /* renamed from: m, reason: collision with root package name */
    public f f5603m;

    public SpinKitView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.SpinKitViewStyle);
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i10) {
        f fVar;
        super.onScreenStateChanged(i10);
        if (i10 != 0 || (fVar = this.f5603m) == null) {
            return;
        }
        fVar.stop();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10 && this.f5603m != null && getVisibility() == 0) {
            this.f5603m.start();
        }
    }

    public void setColor(int i10) {
        this.f5602b = i10;
        f fVar = this.f5603m;
        if (fVar != null) {
            fVar.setColor(i10);
        }
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (!(drawable instanceof f)) {
            throw new IllegalArgumentException("this d must be instanceof Sprite");
        }
        setIndeterminateDrawable((f) drawable);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        super.unscheduleDrawable(drawable);
        if (drawable instanceof f) {
            ((f) drawable).stop();
        }
    }

    public SpinKitView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, R.style.SpinKitView);
    }

    @Override // android.widget.ProgressBar
    public f getIndeterminateDrawable() {
        return this.f5603m;
    }

    @TargetApi(21)
    public SpinKitView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SpinKitView, i10, i11);
        Style style = Style.values()[typedArrayObtainStyledAttributes.getInt(R.styleable.SpinKitView_SpinKit_Style, 0)];
        this.f5602b = typedArrayObtainStyledAttributes.getColor(R.styleable.SpinKitView_SpinKit_Color, -1);
        typedArrayObtainStyledAttributes.recycle();
        f fVarCreate = a.create(style);
        fVarCreate.setColor(this.f5602b);
        setIndeterminateDrawable(fVarCreate);
        setIndeterminate(true);
    }

    public void setIndeterminateDrawable(f fVar) {
        super.setIndeterminateDrawable((Drawable) fVar);
        this.f5603m = fVar;
        if (fVar.getColor() == 0) {
            this.f5603m.setColor(this.f5602b);
        }
        onSizeChanged(getWidth(), getHeight(), getWidth(), getHeight());
        if (getVisibility() == 0) {
            this.f5603m.start();
        }
    }
}
