package l7;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.ViewTreeObserver;
import i7.v;

/* compiled from: NavigationView.java */
/* loaded from: classes.dex */
public final class d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f15932b;

    public d(c cVar) {
        this.f15932b = cVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        c cVar = this.f15932b;
        cVar.getLocationOnScreen(cVar.f15925w);
        boolean z10 = true;
        boolean z11 = cVar.f15925w[1] == 0;
        cVar.f15922t.setBehindStatusBar(z11);
        cVar.setDrawTopInsetForeground(z11 && cVar.isTopInsetScrimEnabled());
        int i10 = cVar.f15925w[0];
        cVar.setDrawLeftInsetForeground(i10 == 0 || cVar.getWidth() + i10 == 0);
        Activity activity = i7.a.getActivity(cVar.getContext());
        if (activity != null) {
            Rect currentWindowBounds = v.getCurrentWindowBounds(activity);
            cVar.setDrawBottomInsetForeground((currentWindowBounds.height() - cVar.getHeight() == cVar.f15925w[1]) && (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0) && cVar.isBottomInsetScrimEnabled());
            if (currentWindowBounds.width() != cVar.f15925w[0] && currentWindowBounds.width() - cVar.getWidth() != cVar.f15925w[0]) {
                z10 = false;
            }
            cVar.setDrawRightInsetForeground(z10);
        }
    }
}
