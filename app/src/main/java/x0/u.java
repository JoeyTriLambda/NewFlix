package x0;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: NestedScrollingParentHelper.java */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public int f21305a;

    /* renamed from: b, reason: collision with root package name */
    public int f21306b;

    public u(ViewGroup viewGroup) {
    }

    public int getNestedScrollAxes() {
        return this.f21305a | this.f21306b;
    }

    public void onNestedScrollAccepted(View view, View view2, int i10) {
        onNestedScrollAccepted(view, view2, i10, 0);
    }

    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        if (i11 == 1) {
            this.f21306b = i10;
        } else {
            this.f21305a = i10;
        }
    }

    public void onStopNestedScroll(View view, int i10) {
        if (i10 == 1) {
            this.f21306b = 0;
        } else {
            this.f21305a = 0;
        }
    }
}
