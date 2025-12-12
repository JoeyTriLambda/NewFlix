package androidx.leanback.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* compiled from: NonOverlappingLinearLayoutWithForeground.java */
/* loaded from: classes.dex */
public class x extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public Drawable f3407b;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3408m;

    /* renamed from: n, reason: collision with root package name */
    public final Rect f3409n;

    public x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f3407b;
        if (drawable != null) {
            if (this.f3408m) {
                this.f3408m = false;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                Rect rect = this.f3409n;
                rect.set(0, 0, right, bottom);
                drawable.setBounds(rect);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f3407b;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f3407b.setState(getDrawableState());
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f3407b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f3408m = z10 | this.f3408m;
    }

    public void setForegroundCompat(Drawable drawable) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23) {
            if (i10 >= 23) {
                setForeground(drawable);
            }
        } else if (this.f3407b != drawable) {
            this.f3407b = drawable;
            this.f3408m = true;
            setWillNotDraw(false);
            this.f3407b.setCallback(this);
            if (this.f3407b.isStateful()) {
                this.f3407b.setState(getDrawableState());
            }
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3407b;
    }

    public x(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3409n = new Rect();
        if (context.getApplicationInfo().targetSdkVersion < 23 || Build.VERSION.SDK_INT < 23) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.foreground});
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
            if (drawable != null) {
                setForegroundCompat(drawable);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
