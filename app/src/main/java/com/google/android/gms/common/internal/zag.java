package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public abstract class zag implements DialogInterface.OnClickListener {
    public static zag zab(Activity activity, Intent intent, int i10) {
        return new zad(activity, intent, i10);
    }

    public static zag zad(LifecycleFragment lifecycleFragment, Intent intent, int i10) {
        return new zaf(lifecycleFragment, intent);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        try {
            zaa();
        } catch (ActivityNotFoundException e10) {
            Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e10);
        } finally {
            dialogInterface.dismiss();
        }
    }

    public abstract void zaa();
}
