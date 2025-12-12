package x0;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.appbar.AppBarLayout;
import java.util.Iterator;
import r.e0;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class p0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21294b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f21295m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f21296n;

    public /* synthetic */ p0(int i10, Object obj, Object obj2) {
        this.f21294b = i10;
        this.f21295m = obj;
        this.f21296n = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i10 = this.f21294b;
        Object obj = this.f21296n;
        Object obj2 = this.f21295m;
        switch (i10) {
            case 0:
                ((e0.c) ((u0) obj2)).onAnimationUpdate((View) obj);
                break;
            default:
                AppBarLayout appBarLayout = (AppBarLayout) obj2;
                q7.g gVar = (q7.g) obj;
                int i11 = AppBarLayout.K;
                appBarLayout.getClass();
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                gVar.setElevation(fFloatValue);
                Drawable drawable = appBarLayout.G;
                if (drawable instanceof q7.g) {
                    ((q7.g) drawable).setElevation(fFloatValue);
                }
                Iterator it = appBarLayout.C.iterator();
                while (it.hasNext()) {
                    ((AppBarLayout.f) it.next()).onUpdate(fFloatValue, gVar.getResolvedTintColor());
                }
                break;
        }
    }
}
