package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.leanback.R;

/* compiled from: ShadowOverlayContainer.java */
/* loaded from: classes.dex */
public final class q0 extends FrameLayout {

    /* renamed from: s, reason: collision with root package name */
    public static final Rect f3329s = new Rect();

    /* renamed from: b, reason: collision with root package name */
    public boolean f3330b;

    /* renamed from: m, reason: collision with root package name */
    public Object f3331m;

    /* renamed from: n, reason: collision with root package name */
    public View f3332n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3333o;

    /* renamed from: p, reason: collision with root package name */
    public int f3334p;

    /* renamed from: q, reason: collision with root package name */
    public Paint f3335q;

    /* renamed from: r, reason: collision with root package name */
    public int f3336r;

    public q0(Context context, int i10, boolean z10, float f10, float f11, int i11) {
        super(context);
        this.f3334p = 1;
        if (this.f3330b) {
            throw new IllegalStateException();
        }
        this.f3330b = true;
        this.f3333o = i11 > 0;
        this.f3334p = i10;
        if (i10 == 2) {
            setLayoutMode(1);
            LayoutInflater.from(getContext()).inflate(R.layout.lb_shadow, (ViewGroup) this, true);
            x0 x0Var = new x0();
            x0Var.f3410a = findViewById(R.id.lb_shadow_normal);
            x0Var.f3411b = findViewById(R.id.lb_shadow_focused);
            this.f3331m = x0Var;
        } else if (i10 == 3) {
            this.f3331m = p0.addDynamicShadow(this, f10, f11, i11);
        }
        if (!z10) {
            setWillNotDraw(true);
            this.f3335q = null;
            return;
        }
        setWillNotDraw(false);
        this.f3336r = 0;
        Paint paint = new Paint();
        this.f3335q = paint;
        paint.setColor(this.f3336r);
        this.f3335q.setStyle(Paint.Style.FILL);
    }

    public static boolean supportsDynamicShadow() {
        return true;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f3335q == null || this.f3336r == 0) {
            return;
        }
        canvas.drawRect(this.f3332n.getLeft(), this.f3332n.getTop(), this.f3332n.getRight(), this.f3332n.getBottom(), this.f3335q);
    }

    public int getShadowType() {
        return this.f3334p;
    }

    public View getWrappedView() {
        return this.f3332n;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View view;
        super.onLayout(z10, i10, i11, i12, i13);
        if (!z10 || (view = this.f3332n) == null) {
            return;
        }
        int pivotX = (int) view.getPivotX();
        Rect rect = f3329s;
        rect.left = pivotX;
        rect.top = (int) this.f3332n.getPivotY();
        offsetDescendantRectToMyCoords(this.f3332n, rect);
        setPivotX(rect.left);
        setPivotY(rect.top);
    }

    public void setOverlayColor(int i10) {
        Paint paint = this.f3335q;
        if (paint == null || i10 == this.f3336r) {
            return;
        }
        this.f3336r = i10;
        paint.setColor(i10);
        invalidate();
    }

    public void setShadowFocusLevel(float f10) {
        Object obj = this.f3331m;
        if (obj != null) {
            r0.a(obj, this.f3334p, f10);
        }
    }

    public void wrap(View view) {
        if (!this.f3330b || this.f3332n != null) {
            throw new IllegalStateException();
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
            layoutParams.width = layoutParams.width == -1 ? -1 : -2;
            layoutParams.height = layoutParams.height == -1 ? -1 : -2;
            setLayoutParams(layoutParams);
            addView(view, layoutParams2);
        } else {
            addView(view);
        }
        if (this.f3333o && this.f3334p != 3) {
            i0.setClipToRoundedOutline(this, true, getResources().getDimensionPixelSize(R.dimen.lb_rounded_rect_corner_radius));
        }
        this.f3332n = view;
    }
}
