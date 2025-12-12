package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

/* compiled from: FragmentController.java */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final u<?> f2911a;

    public s(u<?> uVar) {
        this.f2911a = uVar;
    }

    public static s createController(u<?> uVar) {
        return new s((u) w0.h.checkNotNull(uVar, "callbacks == null"));
    }

    public void attachHost(Fragment fragment) {
        u<?> uVar = this.f2911a;
        uVar.f2930o.b(uVar, uVar, fragment);
    }

    public void dispatchActivityCreated() {
        z zVar = this.f2911a.f2930o;
        zVar.F = false;
        zVar.G = false;
        zVar.M.f2768h = false;
        zVar.t(4);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.f2911a.f2930o.i(menuItem);
    }

    public void dispatchCreate() {
        z zVar = this.f2911a.f2930o;
        zVar.F = false;
        zVar.G = false;
        zVar.M.f2768h = false;
        zVar.t(1);
    }

    public void dispatchDestroy() {
        this.f2911a.f2930o.k();
    }

    public void dispatchPause() {
        this.f2911a.f2930o.t(5);
    }

    public void dispatchResume() {
        z zVar = this.f2911a.f2930o;
        zVar.F = false;
        zVar.G = false;
        zVar.M.f2768h = false;
        zVar.t(7);
    }

    public void dispatchStart() {
        z zVar = this.f2911a.f2930o;
        zVar.F = false;
        zVar.G = false;
        zVar.M.f2768h = false;
        zVar.t(5);
    }

    public void dispatchStop() {
        z zVar = this.f2911a.f2930o;
        zVar.G = true;
        zVar.M.f2768h = true;
        zVar.t(4);
    }

    public boolean execPendingActions() {
        return this.f2911a.f2930o.w(true);
    }

    public y getSupportFragmentManager() {
        return this.f2911a.f2930o;
    }

    public void noteStateNotSaved() {
        this.f2911a.f2930o.H();
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f2911a.f2930o.f2943f.onCreateView(view, str, context, attributeSet);
    }
}
