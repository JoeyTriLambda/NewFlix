package androidx.mediarouter.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import r.u;

/* compiled from: MediaRouteControllerDialogFragment.java */
/* loaded from: classes.dex */
public class l extends androidx.fragment.app.n {

    /* renamed from: x0, reason: collision with root package name */
    public boolean f3689x0 = false;

    /* renamed from: y0, reason: collision with root package name */
    public u f3690y0;

    /* renamed from: z0, reason: collision with root package name */
    public a2.m f3691z0;

    public l() {
        setCancelable(true);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        u uVar = this.f3690y0;
        if (uVar != null) {
            if (this.f3689x0) {
                ((p) uVar).e();
            } else {
                ((h) uVar).n();
            }
        }
    }

    public h onCreateControllerDialog(Context context, Bundle bundle) {
        return new h(context);
    }

    @Override // androidx.fragment.app.n
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f3689x0) {
            p pVarOnCreateDynamicControllerDialog = onCreateDynamicControllerDialog(getContext());
            this.f3690y0 = pVarOnCreateDynamicControllerDialog;
            pVarOnCreateDynamicControllerDialog.setRouteSelector(this.f3691z0);
        } else {
            this.f3690y0 = onCreateControllerDialog(getContext(), bundle);
        }
        return this.f3690y0;
    }

    public p onCreateDynamicControllerDialog(Context context) {
        return new p(context);
    }

    @Override // androidx.fragment.app.n, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        u uVar = this.f3690y0;
        if (uVar == null || this.f3689x0) {
            return;
        }
        ((h) uVar).f(false);
    }

    public void setRouteSelector(a2.m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f3691z0 == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f3691z0 = a2.m.fromBundle(arguments.getBundle("selector"));
            }
            if (this.f3691z0 == null) {
                this.f3691z0 = a2.m.f182c;
            }
        }
        if (this.f3691z0.equals(mVar)) {
            return;
        }
        this.f3691z0 = mVar;
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            arguments2 = new Bundle();
        }
        arguments2.putBundle("selector", mVar.asBundle());
        setArguments(arguments2);
        u uVar = this.f3690y0;
        if (uVar == null || !this.f3689x0) {
            return;
        }
        ((p) uVar).setRouteSelector(mVar);
    }
}
