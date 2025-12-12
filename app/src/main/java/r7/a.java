package r7;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* compiled from: LeftSheetDelegate.java */
/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: a, reason: collision with root package name */
    public final SideSheetBehavior<? extends View> f18648a;

    public a(SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f18648a = sideSheetBehavior;
    }

    @Override // r7.d
    public final int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // r7.d
    public final float b(int i10) {
        float fE = e();
        return (i10 - fE) / (d() - fE);
    }

    @Override // r7.d
    public final int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // r7.d
    public final int d() {
        SideSheetBehavior<? extends View> sideSheetBehavior = this.f18648a;
        return Math.max(0, sideSheetBehavior.f9270y + sideSheetBehavior.f9271z);
    }

    @Override // r7.d
    public final int e() {
        SideSheetBehavior<? extends View> sideSheetBehavior = this.f18648a;
        return (-sideSheetBehavior.f9268w) - sideSheetBehavior.f9271z;
    }

    @Override // r7.d
    public final int f() {
        return this.f18648a.f9271z;
    }

    @Override // r7.d
    public final int g() {
        return -this.f18648a.f9268w;
    }

    @Override // r7.d
    public int getParentInnerEdge(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getLeft();
    }

    @Override // r7.d
    public final <V extends View> int h(V v10) {
        return v10.getRight() + this.f18648a.f9271z;
    }

    @Override // r7.d
    public final int i() {
        return 1;
    }

    @Override // r7.d
    public final boolean j(float f10) {
        return f10 > 0.0f;
    }

    @Override // r7.d
    public final boolean k(View view) {
        return view.getRight() < (d() - e()) / 2;
    }

    @Override // r7.d
    public final boolean l(float f10, float f11) {
        if (Math.abs(f10) > Math.abs(f11)) {
            float fAbs = Math.abs(f10);
            this.f18648a.getClass();
            if (fAbs > 500) {
                return true;
            }
        }
        return false;
    }

    @Override // r7.d
    public final boolean m(View view, float f10) {
        return Math.abs((this.f18648a.getHideFriction() * f10) + ((float) view.getLeft())) > 0.5f;
    }

    @Override // r7.d
    public final void n(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        marginLayoutParams.leftMargin = i10;
    }

    @Override // r7.d
    public final void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11) {
        if (i10 <= this.f18648a.f9269x) {
            marginLayoutParams.leftMargin = i11;
        }
    }
}
