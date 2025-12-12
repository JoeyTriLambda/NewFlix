package q6;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.util.List;
import x0.h;
import x0.j0;
import x0.y0;

/* compiled from: HeaderScrollingViewBehavior.java */
/* loaded from: classes.dex */
public abstract class d extends e<View> {

    /* renamed from: n, reason: collision with root package name */
    public final Rect f17912n;

    /* renamed from: o, reason: collision with root package name */
    public final Rect f17913o;

    /* renamed from: p, reason: collision with root package name */
    public int f17914p;

    /* renamed from: q, reason: collision with root package name */
    public int f17915q;

    public d() {
        this.f17912n = new Rect();
        this.f17913o = new Rect();
        this.f17914p = 0;
    }

    public abstract AppBarLayout a(List list);

    public float b(View view) {
        return 1.0f;
    }

    public int c(View view) {
        return view.getMeasuredHeight();
    }

    public final int getOverlayTop() {
        return this.f17915q;
    }

    @Override // q6.e
    public void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i10) {
        AppBarLayout appBarLayoutA = a(coordinatorLayout.getDependencies(view));
        int iClamp = 0;
        if (appBarLayoutA == null) {
            super.layoutChild(coordinatorLayout, view, i10);
            this.f17914p = 0;
            return;
        }
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
        int paddingLeft = coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin;
        int bottom = appBarLayoutA.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin;
        int width = (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin;
        int bottom2 = ((appBarLayoutA.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
        Rect rect = this.f17912n;
        rect.set(paddingLeft, bottom, width, bottom2);
        y0 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && j0.getFitsSystemWindows(coordinatorLayout) && !j0.getFitsSystemWindows(view)) {
            rect.left = lastWindowInsets.getSystemWindowInsetLeft() + rect.left;
            rect.right -= lastWindowInsets.getSystemWindowInsetRight();
        }
        Rect rect2 = this.f17913o;
        int i11 = fVar.f2101c;
        h.apply(i11 == 0 ? 8388659 : i11, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i10);
        if (this.f17915q != 0) {
            float fB = b(appBarLayoutA);
            int i12 = this.f17915q;
            iClamp = r0.a.clamp((int) (fB * i12), 0, i12);
        }
        view.layout(rect2.left, rect2.top - iClamp, rect2.right, rect2.bottom - iClamp);
        this.f17914p = rect2.top - appBarLayoutA.getBottom();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int i13) {
        AppBarLayout appBarLayoutA;
        y0 lastWindowInsets;
        int i14 = view.getLayoutParams().height;
        if ((i14 != -1 && i14 != -2) || (appBarLayoutA = a(coordinatorLayout.getDependencies(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i12);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (j0.getFitsSystemWindows(appBarLayoutA) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.getSystemWindowInsetBottom() + lastWindowInsets.getSystemWindowInsetTop();
        }
        int iC = c(appBarLayoutA) + size;
        int measuredHeight = appBarLayoutA.getMeasuredHeight();
        if (shouldHeaderOverlapScrollingChild()) {
            view.setTranslationY(-measuredHeight);
        } else {
            view.setTranslationY(0.0f);
            iC -= measuredHeight;
        }
        coordinatorLayout.onMeasureChild(view, i10, i11, View.MeasureSpec.makeMeasureSpec(iC, i14 == -1 ? 1073741824 : Integer.MIN_VALUE), i13);
        return true;
    }

    public final void setOverlayTop(int i10) {
        this.f17915q = i10;
    }

    public boolean shouldHeaderOverlapScrollingChild() {
        return false;
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17912n = new Rect();
        this.f17913o = new Rect();
        this.f17914p = 0;
    }
}
