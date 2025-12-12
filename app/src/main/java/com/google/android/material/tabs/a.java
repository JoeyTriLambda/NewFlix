package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;
import i7.t;

/* compiled from: TabIndicatorInterpolator.java */
/* loaded from: classes.dex */
public class a {
    public static RectF a(TabLayout tabLayout, View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.isTabIndicatorFullWidth() || !(view instanceof TabLayout.h)) {
            return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        TabLayout.h hVar = (TabLayout.h) view;
        int contentWidth = hVar.getContentWidth();
        int contentHeight = hVar.getContentHeight();
        int iDpToPx = (int) t.dpToPx(hVar.getContext(), 24);
        if (contentWidth < iDpToPx) {
            contentWidth = iDpToPx;
        }
        int right = (hVar.getRight() + hVar.getLeft()) / 2;
        int bottom = (hVar.getBottom() + hVar.getTop()) / 2;
        int i10 = contentWidth / 2;
        return new RectF(right - i10, bottom - (contentHeight / 2), i10 + right, (right / 2) + bottom);
    }

    public void b(TabLayout tabLayout, View view, View view2, float f10, Drawable drawable) {
        RectF rectFA = a(tabLayout, view);
        RectF rectFA2 = a(tabLayout, view2);
        drawable.setBounds(p6.a.lerp((int) rectFA.left, (int) rectFA2.left, f10), drawable.getBounds().top, p6.a.lerp((int) rectFA.right, (int) rectFA2.right, f10), drawable.getBounds().bottom);
    }
}
