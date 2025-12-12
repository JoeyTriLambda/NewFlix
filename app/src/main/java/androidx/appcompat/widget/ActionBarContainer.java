package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public boolean f1069b;

    /* renamed from: m, reason: collision with root package name */
    public v0 f1070m;

    /* renamed from: n, reason: collision with root package name */
    public View f1071n;

    /* renamed from: o, reason: collision with root package name */
    public View f1072o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f1073p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f1074q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f1075r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f1076s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1077t;

    /* renamed from: u, reason: collision with root package name */
    public final int f1078u;

    public static class a {
        public static void invalidateOutline(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        x0.j0.setBackground(this, new b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.f1073p = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.f1074q = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.f1078u = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        boolean z10 = true;
        if (getId() == R.id.split_action_bar) {
            this.f1076s = true;
            this.f1075r = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f1076s ? this.f1073p != null || this.f1074q != null : this.f1075r != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
    }

    public static int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1073p;
        if (drawable != null && drawable.isStateful()) {
            this.f1073p.setState(getDrawableState());
        }
        Drawable drawable2 = this.f1074q;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f1074q.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1075r;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f1075r.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f1070m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1073p;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1074q;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1075r;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1071n = findViewById(R.id.action_bar);
        this.f1072o = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1069b || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        Drawable drawable;
        super.onLayout(z10, i10, i11, i12, i13);
        v0 v0Var = this.f1070m;
        boolean z11 = true;
        boolean z12 = false;
        boolean z13 = (v0Var == null || v0Var.getVisibility() == 8) ? false : true;
        if (v0Var != null && v0Var.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) v0Var.getLayoutParams();
            int measuredHeight2 = measuredHeight - v0Var.getMeasuredHeight();
            int i14 = layoutParams.bottomMargin;
            v0Var.layout(i10, measuredHeight2 - i14, i12, measuredHeight - i14);
        }
        if (this.f1076s) {
            Drawable drawable2 = this.f1075r;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z11 = false;
            }
        } else {
            if (this.f1073p != null) {
                if (this.f1071n.getVisibility() == 0) {
                    this.f1073p.setBounds(this.f1071n.getLeft(), this.f1071n.getTop(), this.f1071n.getRight(), this.f1071n.getBottom());
                } else {
                    View view = this.f1072o;
                    if (view == null || view.getVisibility() != 0) {
                        this.f1073p.setBounds(0, 0, 0, 0);
                    } else {
                        this.f1073p.setBounds(this.f1072o.getLeft(), this.f1072o.getTop(), this.f1072o.getRight(), this.f1072o.getBottom());
                    }
                }
                z12 = true;
            }
            this.f1077t = z13;
            if (!z13 || (drawable = this.f1074q) == null) {
                z11 = z12;
            } else {
                drawable.setBounds(v0Var.getLeft(), v0Var.getTop(), v0Var.getRight(), v0Var.getBottom());
            }
        }
        if (z11) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        if (this.f1071n == null && View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE && (i12 = this.f1078u) >= 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(i12, View.MeasureSpec.getSize(i11)), Integer.MIN_VALUE);
        }
        super.onMeasure(i10, i11);
        if (this.f1071n == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        v0 v0Var = this.f1070m;
        if (v0Var == null || v0Var.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        View view = this.f1071n;
        boolean z10 = true;
        int iA = 0;
        if (view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0) {
            View view2 = this.f1072o;
            if (view2 != null && view2.getVisibility() != 8 && view2.getMeasuredHeight() != 0) {
                z10 = false;
            }
            if (!z10) {
                iA = a(this.f1072o);
            }
        } else {
            iA = a(this.f1071n);
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(a(this.f1070m) + iA, mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i11) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f1073p;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f1073p);
        }
        this.f1073p = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1071n;
            if (view != null) {
                this.f1073p.setBounds(view.getLeft(), this.f1071n.getTop(), this.f1071n.getRight(), this.f1071n.getBottom());
            }
        }
        boolean z10 = true;
        if (!this.f1076s ? this.f1073p != null || this.f1074q != null : this.f1075r != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
        invalidate();
        a.invalidateOutline(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1075r;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1075r);
        }
        this.f1075r = drawable;
        boolean z10 = this.f1076s;
        boolean z11 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z10 && (drawable2 = this.f1075r) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z10 ? !(this.f1073p != null || this.f1074q != null) : this.f1075r == null) {
            z11 = true;
        }
        setWillNotDraw(z11);
        invalidate();
        a.invalidateOutline(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1074q;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1074q);
        }
        this.f1074q = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1077t && (drawable2 = this.f1074q) != null) {
                drawable2.setBounds(this.f1070m.getLeft(), this.f1070m.getTop(), this.f1070m.getRight(), this.f1070m.getBottom());
            }
        }
        setWillNotDraw(!this.f1076s ? !(this.f1073p == null && this.f1074q == null) : this.f1075r != null);
        invalidate();
        a.invalidateOutline(this);
    }

    public void setTabContainer(v0 v0Var) {
        v0 v0Var2 = this.f1070m;
        if (v0Var2 != null) {
            removeView(v0Var2);
        }
        this.f1070m = v0Var;
        if (v0Var != null) {
            addView(v0Var);
            ViewGroup.LayoutParams layoutParams = v0Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            v0Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z10) {
        this.f1069b = z10;
        setDescendantFocusability(z10 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f1073p;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
        Drawable drawable2 = this.f1074q;
        if (drawable2 != null) {
            drawable2.setVisible(z10, false);
        }
        Drawable drawable3 = this.f1075r;
        if (drawable3 != null) {
            drawable3.setVisible(z10, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1073p;
        boolean z10 = this.f1076s;
        return (drawable == drawable2 && !z10) || (drawable == this.f1074q && this.f1077t) || ((drawable == this.f1075r && z10) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i10) {
        if (i10 != 0) {
            return super.startActionModeForChild(view, callback, i10);
        }
        return null;
    }
}
