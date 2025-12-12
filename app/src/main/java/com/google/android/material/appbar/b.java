package com.google.android.material.appbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import y0.d;

/* compiled from: AppBarLayout.java */
/* loaded from: classes.dex */
public final class b extends x0.a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f8776d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f8777e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f8778f;

    public b(CoordinatorLayout coordinatorLayout, AppBarLayout.BaseBehavior baseBehavior, AppBarLayout appBarLayout) {
        this.f8778f = baseBehavior;
        this.f8776d = appBarLayout;
        this.f8777e = coordinatorLayout;
    }

    @Override // x0.a
    public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
        super.onInitializeAccessibilityNodeInfo(view, dVar);
        dVar.setClassName(ScrollView.class.getName());
        AppBarLayout appBarLayout = this.f8776d;
        if (appBarLayout.getTotalScrollRange() == 0) {
            return;
        }
        CoordinatorLayout coordinatorLayout = this.f8777e;
        AppBarLayout.BaseBehavior baseBehavior = this.f8778f;
        View viewH = AppBarLayout.BaseBehavior.h(baseBehavior, coordinatorLayout);
        if (viewH == null) {
            return;
        }
        baseBehavior.getClass();
        int childCount = appBarLayout.getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            if (((AppBarLayout.e) appBarLayout.getChildAt(i10).getLayoutParams()).f8744a != 0) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10) {
            if (baseBehavior.d() != (-appBarLayout.getTotalScrollRange())) {
                dVar.addAction(d.a.f21823h);
                dVar.setScrollable(true);
            }
            if (baseBehavior.d() != 0) {
                if (!viewH.canScrollVertically(-1)) {
                    dVar.addAction(d.a.f21824i);
                    dVar.setScrollable(true);
                } else if ((-appBarLayout.getDownNestedPreScrollRange()) != 0) {
                    dVar.addAction(d.a.f21824i);
                    dVar.setScrollable(true);
                }
            }
        }
    }

    @Override // x0.a
    public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
        AppBarLayout appBarLayout = this.f8776d;
        if (i10 == 4096) {
            appBarLayout.setExpanded(false);
            return true;
        }
        if (i10 != 8192) {
            return super.performAccessibilityAction(view, i10, bundle);
        }
        AppBarLayout.BaseBehavior baseBehavior = this.f8778f;
        if (baseBehavior.d() != 0) {
            View viewH = AppBarLayout.BaseBehavior.h(baseBehavior, this.f8777e);
            if (!viewH.canScrollVertically(-1)) {
                appBarLayout.setExpanded(true);
                return true;
            }
            int i11 = -appBarLayout.getDownNestedPreScrollRange();
            if (i11 != 0) {
                this.f8778f.onNestedPreScroll(this.f8777e, (CoordinatorLayout) this.f8776d, viewH, 0, i11, new int[]{0, 0}, 1);
                return true;
            }
        }
        return false;
    }
}
