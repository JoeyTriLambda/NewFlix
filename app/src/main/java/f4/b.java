package f4;

import android.util.Log;
import android.view.View;

/* compiled from: ShadowRippleGenerator.java */
/* loaded from: classes.dex */
public final class b implements View.OnAttachStateChangeListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f11465b;

    public b(f fVar) {
        this.f11465b = fVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Log.i("ShadowGenerator", "Attached");
        f fVar = this.f11465b;
        f.a(fVar, fVar.f11477h);
        fVar.f11470a.invalidate();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}
