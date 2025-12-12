package androidx.mediarouter.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import r.u;

/* compiled from: MediaRouteChooserDialogFragment.java */
/* loaded from: classes.dex */
public class d extends androidx.fragment.app.n {

    /* renamed from: x0, reason: collision with root package name */
    public boolean f3621x0 = false;

    /* renamed from: y0, reason: collision with root package name */
    public u f3622y0;

    /* renamed from: z0, reason: collision with root package name */
    public a2.m f3623z0;

    public d() {
        setCancelable(true);
    }

    public a2.m getRouteSelector() {
        p();
        return this.f3623z0;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        u uVar = this.f3622y0;
        if (uVar == null) {
            return;
        }
        if (!this.f3621x0) {
            c cVar = (c) uVar;
            cVar.getWindow().setLayout(n.getDialogWidth(cVar.getContext()), -2);
            return;
        }
        o oVar = (o) uVar;
        Context context = oVar.f3695s;
        oVar.getWindow().setLayout(n.getDialogWidthForDynamicGroup(context), n.getDialogHeight(context));
    }

    public c onCreateChooserDialog(Context context, Bundle bundle) {
        return new c(context);
    }

    @Override // androidx.fragment.app.n
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f3621x0) {
            o oVarOnCreateDynamicChooserDialog = onCreateDynamicChooserDialog(getContext());
            this.f3622y0 = oVarOnCreateDynamicChooserDialog;
            oVarOnCreateDynamicChooserDialog.setRouteSelector(getRouteSelector());
        } else {
            c cVarOnCreateChooserDialog = onCreateChooserDialog(getContext(), bundle);
            this.f3622y0 = cVarOnCreateChooserDialog;
            cVarOnCreateChooserDialog.setRouteSelector(getRouteSelector());
        }
        return this.f3622y0;
    }

    public o onCreateDynamicChooserDialog(Context context) {
        return new o(context);
    }

    public final void p() {
        if (this.f3623z0 == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f3623z0 = a2.m.fromBundle(arguments.getBundle("selector"));
            }
            if (this.f3623z0 == null) {
                this.f3623z0 = a2.m.f182c;
            }
        }
    }

    public void setRouteSelector(a2.m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        p();
        if (this.f3623z0.equals(mVar)) {
            return;
        }
        this.f3623z0 = mVar;
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putBundle("selector", mVar.asBundle());
        setArguments(arguments);
        u uVar = this.f3622y0;
        if (uVar != null) {
            if (this.f3621x0) {
                ((o) uVar).setRouteSelector(mVar);
            } else {
                ((c) uVar).setRouteSelector(mVar);
            }
        }
    }
}
