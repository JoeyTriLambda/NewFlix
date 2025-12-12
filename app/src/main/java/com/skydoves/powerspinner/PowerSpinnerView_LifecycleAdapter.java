package com.skydoves.powerspinner;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.e;
import androidx.lifecycle.l;
import androidx.lifecycle.q;

/* loaded from: classes2.dex */
public class PowerSpinnerView_LifecycleAdapter implements e {

    /* renamed from: a, reason: collision with root package name */
    public final PowerSpinnerView f10458a;

    public PowerSpinnerView_LifecycleAdapter(PowerSpinnerView powerSpinnerView) {
        this.f10458a = powerSpinnerView;
    }

    @Override // androidx.lifecycle.e
    public void callMethods(l lVar, Lifecycle.Event event, boolean z10, q qVar) {
        boolean z11 = qVar != null;
        if (!z10 && event == Lifecycle.Event.ON_DESTROY) {
            if (!z11 || qVar.approveCall("onDestroy", 1)) {
                this.f10458a.onDestroy();
            }
        }
    }
}
