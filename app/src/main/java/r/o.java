package r;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.k1;
import java.lang.reflect.InvocationTargetException;
import x0.j0;
import x0.y0;

/* compiled from: AppCompatDelegateImpl.java */
/* loaded from: classes.dex */
public final class o implements x0.v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f18321a;

    public o(n nVar) {
        this.f18321a = nVar;
    }

    @Override // x0.v
    public y0 onApplyWindowInsets(View view, y0 y0Var) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z10;
        View view2;
        y0 y0VarReplaceSystemWindowInsets;
        boolean z11;
        int systemWindowInsetTop = y0Var.getSystemWindowInsetTop();
        n nVar = this.f18321a;
        nVar.getClass();
        int systemWindowInsetTop2 = y0Var.getSystemWindowInsetTop();
        ActionBarContextView actionBarContextView = nVar.G;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z10 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) nVar.G.getLayoutParams();
            if (nVar.G.isShown()) {
                if (nVar.f18274o0 == null) {
                    nVar.f18274o0 = new Rect();
                    nVar.f18275p0 = new Rect();
                }
                Rect rect = nVar.f18274o0;
                Rect rect2 = nVar.f18275p0;
                rect.set(y0Var.getSystemWindowInsetLeft(), y0Var.getSystemWindowInsetTop(), y0Var.getSystemWindowInsetRight(), y0Var.getSystemWindowInsetBottom());
                k1.computeFitSystemWindows(nVar.M, rect, rect2);
                int i10 = rect.top;
                int i11 = rect.left;
                int i12 = rect.right;
                y0 rootWindowInsets = j0.getRootWindowInsets(nVar.M);
                int systemWindowInsetLeft = rootWindowInsets == null ? 0 : rootWindowInsets.getSystemWindowInsetLeft();
                int systemWindowInsetRight = rootWindowInsets == null ? 0 : rootWindowInsets.getSystemWindowInsetRight();
                if (marginLayoutParams.topMargin == i10 && marginLayoutParams.leftMargin == i11 && marginLayoutParams.rightMargin == i12) {
                    z11 = false;
                } else {
                    marginLayoutParams.topMargin = i10;
                    marginLayoutParams.leftMargin = i11;
                    marginLayoutParams.rightMargin = i12;
                    z11 = true;
                }
                Context context = nVar.f18280v;
                if (i10 <= 0 || nVar.O != null) {
                    View view3 = nVar.O;
                    if (view3 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
                        int i13 = marginLayoutParams2.height;
                        int i14 = marginLayoutParams.topMargin;
                        if (i13 != i14 || marginLayoutParams2.leftMargin != systemWindowInsetLeft || marginLayoutParams2.rightMargin != systemWindowInsetRight) {
                            marginLayoutParams2.height = i14;
                            marginLayoutParams2.leftMargin = systemWindowInsetLeft;
                            marginLayoutParams2.rightMargin = systemWindowInsetRight;
                            nVar.O.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view4 = new View(context);
                    nVar.O = view4;
                    view4.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = systemWindowInsetLeft;
                    layoutParams.rightMargin = systemWindowInsetRight;
                    nVar.M.addView(nVar.O, -1, layoutParams);
                }
                View view5 = nVar.O;
                z10 = view5 != null;
                if (z10 && view5.getVisibility() != 0) {
                    View view6 = nVar.O;
                    view6.setBackgroundColor((j0.getWindowSystemUiVisibility(view6) & 8192) != 0 ? m0.a.getColor(context, R.color.abc_decor_view_status_guard_light) : m0.a.getColor(context, R.color.abc_decor_view_status_guard));
                }
                if (!nVar.T && z10) {
                    systemWindowInsetTop2 = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                } else {
                    z = false;
                }
                z11 = z;
                z10 = false;
            }
            if (z11) {
                nVar.G.setLayoutParams(marginLayoutParams);
            }
        }
        View view7 = nVar.O;
        if (view7 != null) {
            view7.setVisibility(z10 ? 0 : 8);
        }
        if (systemWindowInsetTop != systemWindowInsetTop2) {
            y0VarReplaceSystemWindowInsets = y0Var.replaceSystemWindowInsets(y0Var.getSystemWindowInsetLeft(), systemWindowInsetTop2, y0Var.getSystemWindowInsetRight(), y0Var.getSystemWindowInsetBottom());
            view2 = view;
        } else {
            view2 = view;
            y0VarReplaceSystemWindowInsets = y0Var;
        }
        return j0.onApplyWindowInsets(view2, y0VarReplaceSystemWindowInsets);
    }
}
