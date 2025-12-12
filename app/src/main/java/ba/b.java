package ba;

import android.view.View;
import android.view.ViewGroup;
import ba.a;
import la.k;

/* compiled from: SwipeDismissRecyclerViewTouchListener.java */
/* loaded from: classes.dex */
public final class b extends la.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f4820a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4821b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f4822c;

    public b(a aVar, int i10, View view) {
        this.f4822c = aVar;
        this.f4820a = view;
        this.f4821b = i10;
    }

    @Override // la.b, la.a.InterfaceC0190a
    public void onAnimationEnd(la.a aVar) {
        super.onAnimationEnd(aVar);
        a aVar2 = this.f4822c;
        aVar2.getClass();
        View view = this.f4820a;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int height = view.getHeight();
        k duration = k.ofInt(height, 1).setDuration(aVar2.f4805o);
        duration.addListener(new c(aVar2, height));
        duration.addUpdateListener(new d(layoutParams, view));
        aVar2.f4809s.add(new a.c(aVar2, this.f4821b, view));
        duration.start();
    }
}
