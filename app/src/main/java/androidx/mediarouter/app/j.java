package androidx.mediarouter.app;

import a2.n;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import androidx.mediarouter.app.OverlayListView;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: MediaRouteControllerDialog.java */
/* loaded from: classes.dex */
public final class j implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f3685b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Map f3686m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ h f3687n;

    public j(h hVar, HashMap map, HashMap map2) {
        this.f3687n = hVar;
        this.f3685b = map;
        this.f3686m = map2;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Map map;
        Map map2;
        OverlayListView.a animationEndListener;
        Map map3;
        h hVar = this.f3687n;
        hVar.R.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        Set<n.g> set = hVar.U;
        if (set == null || hVar.V == null) {
            return;
        }
        int size = set.size() - hVar.V.size();
        k kVar = new k(hVar);
        int firstVisiblePosition = hVar.R.getFirstVisiblePosition();
        int i10 = 0;
        boolean z10 = false;
        while (true) {
            int childCount = hVar.R.getChildCount();
            map = this.f3685b;
            map2 = this.f3686m;
            if (i10 >= childCount) {
                break;
            }
            View childAt = hVar.R.getChildAt(i10);
            n.g item = hVar.S.getItem(firstVisiblePosition + i10);
            Rect rect = (Rect) map.get(item);
            int top = childAt.getTop();
            int i11 = rect != null ? rect.top : (hVar.f3629b0 * size) + top;
            AnimationSet animationSet = new AnimationSet(true);
            Set<n.g> set2 = hVar.U;
            if (set2 == null || !set2.contains(item)) {
                map3 = map;
            } else {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
                map3 = map;
                alphaAnimation.setDuration(hVar.f3654v0);
                animationSet.addAnimation(alphaAnimation);
                i11 = top;
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, i11 - top, 0.0f);
            translateAnimation.setDuration(hVar.f3652u0);
            animationSet.addAnimation(translateAnimation);
            animationSet.setFillAfter(true);
            animationSet.setFillEnabled(true);
            animationSet.setInterpolator(hVar.f3658x0);
            if (!z10) {
                animationSet.setAnimationListener(kVar);
                z10 = true;
            }
            childAt.clearAnimation();
            childAt.startAnimation(animationSet);
            map3.remove(item);
            map2.remove(item);
            i10++;
        }
        for (Map.Entry entry : map2.entrySet()) {
            n.g gVar = (n.g) entry.getKey();
            BitmapDrawable bitmapDrawable = (BitmapDrawable) entry.getValue();
            Rect rect2 = (Rect) map.get(gVar);
            if (hVar.V.contains(gVar)) {
                animationEndListener = new OverlayListView.a(bitmapDrawable, rect2).setAlphaAnimation(1.0f, 0.0f).setDuration(hVar.f3656w0).setInterpolator(hVar.f3658x0);
            } else {
                animationEndListener = new OverlayListView.a(bitmapDrawable, rect2).setTranslateYAnimation(hVar.f3629b0 * size).setDuration(hVar.f3652u0).setInterpolator(hVar.f3658x0).setAnimationEndListener(new e(hVar, gVar));
                hVar.W.add(gVar);
            }
            hVar.R.addOverlayObject(animationEndListener);
        }
    }
}
