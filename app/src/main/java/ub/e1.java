package ub;

import com.google.android.material.tabs.TabLayout;
import flix.com.vision.activities.MainActivity;

/* compiled from: MainActivity.java */
/* loaded from: classes2.dex */
public final class e1 implements TabLayout.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainActivity f20172a;

    public e1(MainActivity mainActivity) {
        this.f20172a = mainActivity;
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabReselected(TabLayout.f fVar) {
        MainActivity.d(this.f20172a, fVar);
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabSelected(TabLayout.f fVar) {
        MainActivity.d(this.f20172a, fVar);
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabUnselected(TabLayout.f fVar) {
    }
}
