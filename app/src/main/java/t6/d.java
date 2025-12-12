package t6;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import x0.x0;
import x0.y0;

/* compiled from: InsetsAnimationCallback.java */
/* loaded from: classes.dex */
public final class d extends x0.b {

    /* renamed from: c, reason: collision with root package name */
    public final View f19464c;

    /* renamed from: d, reason: collision with root package name */
    public int f19465d;

    /* renamed from: e, reason: collision with root package name */
    public int f19466e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f19467f;

    public d(View view) {
        super(0);
        this.f19467f = new int[2];
        this.f19464c = view;
    }

    @Override // x0.x0.b
    public void onEnd(x0 x0Var) {
        this.f19464c.setTranslationY(0.0f);
    }

    @Override // x0.x0.b
    public void onPrepare(x0 x0Var) {
        View view = this.f19464c;
        int[] iArr = this.f19467f;
        view.getLocationOnScreen(iArr);
        this.f19465d = iArr[1];
    }

    @Override // x0.x0.b
    public y0 onProgress(y0 y0Var, List<x0> list) {
        Iterator<x0> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if ((it.next().getTypeMask() & y0.m.ime()) != 0) {
                this.f19464c.setTranslationY(p6.a.lerp(this.f19466e, 0, r0.getInterpolatedFraction()));
                break;
            }
        }
        return y0Var;
    }

    @Override // x0.x0.b
    public x0.a onStart(x0 x0Var, x0.a aVar) {
        View view = this.f19464c;
        int[] iArr = this.f19467f;
        view.getLocationOnScreen(iArr);
        int i10 = this.f19465d - iArr[1];
        this.f19466e = i10;
        view.setTranslationY(i10);
        return aVar;
    }
}
