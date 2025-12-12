package com.google.android.material.tabs;

import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* compiled from: TabLayout.java */
/* loaded from: classes.dex */
public final class c implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f9403a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TabLayout.h f9404b;

    public c(TabLayout.h hVar, View view) {
        this.f9404b = hVar;
        this.f9403a = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        View view2 = this.f9403a;
        if (view2.getVisibility() == 0) {
            this.f9404b.c(view2);
        }
    }
}
