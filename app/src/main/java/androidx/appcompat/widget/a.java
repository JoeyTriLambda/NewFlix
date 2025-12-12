package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;

/* compiled from: AbsActionBarView.java */
/* loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: b, reason: collision with root package name */
    public final C0015a f1236b;

    /* renamed from: m, reason: collision with root package name */
    public final Context f1237m;

    /* renamed from: n, reason: collision with root package name */
    public ActionMenuView f1238n;

    /* renamed from: o, reason: collision with root package name */
    public c f1239o;

    /* renamed from: p, reason: collision with root package name */
    public int f1240p;

    /* renamed from: q, reason: collision with root package name */
    public x0.r0 f1241q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1242r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1243s;

    /* compiled from: AbsActionBarView.java */
    /* renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    public class C0015a implements x0.s0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1244a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f1245b;

        public C0015a() {
        }

        @Override // x0.s0
        public void onAnimationCancel(View view) {
            this.f1244a = true;
        }

        @Override // x0.s0
        public void onAnimationEnd(View view) {
            if (this.f1244a) {
                return;
            }
            a aVar = a.this;
            aVar.f1241q = null;
            a.super.setVisibility(this.f1245b);
        }

        @Override // x0.s0
        public void onAnimationStart(View view) {
            a.super.setVisibility(0);
            this.f1244a = false;
        }

        public C0015a withFinalVisibility(x0.r0 r0Var, int i10) {
            a.this.f1241q = r0Var;
            this.f1245b = i10;
            return this;
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static int next(int i10, int i11, boolean z10) {
        return z10 ? i10 - i11 : i10 + i11;
    }

    public int getAnimatedVisibility() {
        return this.f1241q != null ? this.f1236b.f1245b : getVisibility();
    }

    public int getContentHeight() {
        return this.f1240p;
    }

    public int measureChildView(View view, int i10, int i11, int i12) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), i11);
        return Math.max(0, (i10 - view.getMeasuredWidth()) - i12);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        c cVar = this.f1239o;
        if (cVar != null) {
            cVar.onConfigurationChanged(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1243s = false;
        }
        if (!this.f1243s) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f1243s = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1243s = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1242r = false;
        }
        if (!this.f1242r) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f1242r = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1242r = false;
        }
        return true;
    }

    public int positionChild(View view, int i10, int i11, int i12, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i13 = ((i12 - measuredHeight) / 2) + i11;
        if (z10) {
            view.layout(i10 - measuredWidth, i13, i10, measuredHeight + i13);
        } else {
            view.layout(i10, i13, i10 + measuredWidth, measuredHeight + i13);
        }
        return z10 ? -measuredWidth : measuredWidth;
    }

    public void setContentHeight(int i10) {
        this.f1240p = i10;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        if (i10 != getVisibility()) {
            x0.r0 r0Var = this.f1241q;
            if (r0Var != null) {
                r0Var.cancel();
            }
            super.setVisibility(i10);
        }
    }

    public x0.r0 setupAnimatorToVisibility(int i10, long j10) {
        x0.r0 r0Var = this.f1241q;
        if (r0Var != null) {
            r0Var.cancel();
        }
        C0015a c0015a = this.f1236b;
        if (i10 != 0) {
            x0.r0 r0VarAlpha = x0.j0.animate(this).alpha(0.0f);
            r0VarAlpha.setDuration(j10);
            r0VarAlpha.setListener(c0015a.withFinalVisibility(r0VarAlpha, i10));
            return r0VarAlpha;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        x0.r0 r0VarAlpha2 = x0.j0.animate(this).alpha(1.0f);
        r0VarAlpha2.setDuration(j10);
        r0VarAlpha2.setListener(c0015a.withFinalVisibility(r0VarAlpha2, i10));
        return r0VarAlpha2;
    }

    public a(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1236b = new C0015a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1237m = context;
        } else {
            this.f1237m = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}
