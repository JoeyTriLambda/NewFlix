package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public abstract class zap extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f7270b;

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onActivityResult(int i10, int i11, Intent intent) {
        throw null;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        new ConnectionResult(13, null);
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            if (bundle.getBoolean("resolving_error", false)) {
                new zam(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1));
            }
            throw null;
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        this.f7270b = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        this.f7270b = false;
    }

    public abstract void zab(ConnectionResult connectionResult, int i10);

    public abstract void zac();

    public final void zah(ConnectionResult connectionResult, int i10) {
        new zam(connectionResult, i10);
        throw null;
    }
}
