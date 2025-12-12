package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* compiled from: FragmentTransitionImpl.java */
/* loaded from: classes.dex */
public final class j0 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2857b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2858m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2859n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2860o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2861p;

    public j0(int i10, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f2857b = i10;
        this.f2858m = arrayList;
        this.f2859n = arrayList2;
        this.f2860o = arrayList3;
        this.f2861p = arrayList4;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i10 = 0; i10 < this.f2857b; i10++) {
            x0.j0.setTransitionName((View) this.f2858m.get(i10), (String) this.f2859n.get(i10));
            x0.j0.setTransitionName((View) this.f2860o.get(i10), (String) this.f2861p.get(i10));
        }
    }
}
