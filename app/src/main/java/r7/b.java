package r7;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* compiled from: RightSheetDelegate.java */
/* loaded from: classes.dex */
public final class b extends d {

    /* renamed from: a, reason: collision with root package name */
    public final SideSheetBehavior<? extends View> f18649a;

    public b(SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f18649a = sideSheetBehavior;
    }

    @Override // r7.d
    public final int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // r7.d
    public final float b(int i10) {
        float f10 = this.f18649a.f9269x;
        return (f10 - i10) / (f10 - d());
    }

    @Override // r7.d
    public final int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // r7.d
    public final int d() {
        SideSheetBehavior<? extends View> sideSheetBehavior = this.f18649a;
        return Math.max(0, (sideSheetBehavior.f9269x - sideSheetBehavior.f9268w) - sideSheetBehavior.f9271z);
    }

    @Override // r7.d
    public final int e() {
        return this.f18649a.f9269x;
    }

    @Override // r7.d
    public final int f() {
        return this.f18649a.f9269x;
    }

    @Override // r7.d
    public final int g() {
        return d();
    }

    @Override // r7.d
    public int getParentInnerEdge(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getRight();
    }

    @Override // r7.d
    public final <V extends View> int h(V v10) {
        return v10.getLeft() - this.f18649a.f9271z;
    }

    @Override // r7.d
    public final int i() {
        return 0;
    }

    @Override // r7.d
    public final boolean j(float f10) {
        return f10 < 0.0f;
    }

    @Override // r7.d
    public final boolean k(View view) {
        return view.getLeft() > (d() + this.f18649a.f9269x) / 2;
    }

    @Override // r7.d
    public final boolean l(float f10, float f11) {
        if (Math.abs(f10) > Math.abs(f11)) {
            float fAbs = Math.abs(f10);
            this.f18649a.getClass();
            if (fAbs > 500) {
                return true;
            }
        }
        return false;
    }

    @Override // r7.d
    public final boolean m(View view, float f10) {
        return Math.abs((this.f18649a.getHideFriction() * f10) + ((float) view.getRight())) > 0.5f;
    }

    @Override // r7.d
    public final void n(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        marginLayoutParams.rightMargin = i10;
    }

    @Override // r7.d
    public final void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11) {
        int i12 = this.f18649a.f9269x;
        if (i10 <= i12) {
            marginLayoutParams.rightMargin = i12 - i10;
        }
    }
}
