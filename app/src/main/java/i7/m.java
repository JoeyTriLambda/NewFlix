package i7;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.R;
import x0.j0;
import x0.y0;

/* compiled from: ScrimInsetsFrameLayout.java */
/* loaded from: classes.dex */
public class m extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public Drawable f13303b;

    /* renamed from: m, reason: collision with root package name */
    public Rect f13304m;

    /* renamed from: n, reason: collision with root package name */
    public final Rect f13305n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f13306o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f13307p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f13308q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f13309r;

    /* compiled from: ScrimInsetsFrameLayout.java */
    public class a implements x0.v {
        public a() {
        }

        @Override // x0.v
        public y0 onApplyWindowInsets(View view, y0 y0Var) {
            m mVar = m.this;
            if (mVar.f13304m == null) {
                mVar.f13304m = new Rect();
            }
            mVar.f13304m.set(y0Var.getSystemWindowInsetLeft(), y0Var.getSystemWindowInsetTop(), y0Var.getSystemWindowInsetRight(), y0Var.getSystemWindowInsetBottom());
            mVar.onInsetsChanged(y0Var);
            mVar.setWillNotDraw(!y0Var.hasSystemWindowInsets() || mVar.f13303b == null);
            j0.postInvalidateOnAnimation(mVar);
            return y0Var.consumeSystemWindowInsets();
        }
    }

    public m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f13304m == null || this.f13303b == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        boolean z10 = this.f13306o;
        Rect rect = this.f13305n;
        if (z10) {
            rect.set(0, 0, width, this.f13304m.top);
            this.f13303b.setBounds(rect);
            this.f13303b.draw(canvas);
        }
        if (this.f13307p) {
            rect.set(0, height - this.f13304m.bottom, width, height);
            this.f13303b.setBounds(rect);
            this.f13303b.draw(canvas);
        }
        if (this.f13308q) {
            Rect rect2 = this.f13304m;
            rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
            this.f13303b.setBounds(rect);
            this.f13303b.draw(canvas);
        }
        if (this.f13309r) {
            Rect rect3 = this.f13304m;
            rect.set(width - rect3.right, rect3.top, width, height - rect3.bottom);
            this.f13303b.setBounds(rect);
            this.f13303b.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f13303b;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f13303b;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z10) {
        this.f13307p = z10;
    }

    public void setDrawLeftInsetForeground(boolean z10) {
        this.f13308q = z10;
    }

    public void setDrawRightInsetForeground(boolean z10) {
        this.f13309r = z10;
    }

    public void setDrawTopInsetForeground(boolean z10) {
        this.f13306o = z10;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.f13303b = drawable;
    }

    public m(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f13305n = new Rect();
        this.f13306o = true;
        this.f13307p = true;
        this.f13308q = true;
        this.f13309r = true;
        TypedArray typedArrayObtainStyledAttributes = r.obtainStyledAttributes(context, attributeSet, R.styleable.ScrimInsetsFrameLayout, i10, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f13303b = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(true);
        j0.setOnApplyWindowInsetsListener(this, new a());
    }

    public void onInsetsChanged(y0 y0Var) {
    }
}
