package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.fragment.app.p;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zabw;
import com.google.android.gms.common.api.internal.zabx;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zag;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.base.zal;
import l0.o;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public class GoogleApiAvailability extends GoogleApiAvailabilityLight {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f7025c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final GoogleApiAvailability f7026d = new GoogleApiAvailability();

    public static AlertDialog a(Context context, int i10, zag zagVar, DialogInterface.OnCancelListener onCancelListener) {
        if (i10 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(com.google.android.gms.common.internal.zac.zad(context, i10));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String strZac = com.google.android.gms.common.internal.zac.zac(context, i10);
        if (strZac != null) {
            builder.setPositiveButton(strZac, zagVar);
        }
        String strZag = com.google.android.gms.common.internal.zac.zag(context, i10);
        if (strZag != null) {
            builder.setTitle(strZag);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i10)), new IllegalArgumentException());
        return builder.create();
    }

    public static void b(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof p) {
                SupportErrorDialogFragment.newInstance(dialog, onCancelListener).show(((p) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    public static GoogleApiAvailability getInstance() {
        return f7026d;
    }

    @TargetApi(20)
    public final void c(Context context, int i10, PendingIntent pendingIntent) {
        int i11;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i10), null), new IllegalArgumentException());
        if (i10 == 18) {
            new zac(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i10 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strZaf = com.google.android.gms.common.internal.zac.zaf(context, i10);
        String strZae = com.google.android.gms.common.internal.zac.zae(context, i10);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) Preconditions.checkNotNull(context.getSystemService("notification"));
        o.d style = new o.d(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(strZaf).setStyle(new o.b().bigText(strZae));
        if (DeviceProperties.isWearable(context)) {
            Preconditions.checkState(PlatformVersion.isAtLeastKitKatWatch());
            style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
            if (DeviceProperties.isWearableWithoutPlayStore(context)) {
                style.addAction(com.google.android.gms.base.R.drawable.common_full_open_on_phone, resources.getString(com.google.android.gms.base.R.string.common_open_on_phone), pendingIntent);
            } else {
                style.setContentIntent(pendingIntent);
            }
        } else {
            style.setSmallIcon(android.R.drawable.stat_sys_warning).setTicker(resources.getString(com.google.android.gms.base.R.string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(strZae);
        }
        if (PlatformVersion.isAtLeastO()) {
            Preconditions.checkState(PlatformVersion.isAtLeastO());
            synchronized (f7025c) {
            }
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
            String strZab = com.google.android.gms.common.internal.zac.zab(context);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", strZab, 4));
            } else if (!strZab.contentEquals(notificationChannel.getName())) {
                notificationChannel.setName(strZab);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            style.setChannelId("com.google.android.gms.availability");
        }
        Notification notificationBuild = style.build();
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            GooglePlayServicesUtilLight.f7031a.set(false);
            i11 = 10436;
        } else {
            i11 = 39789;
        }
        notificationManager.notify(i11, notificationBuild);
    }

    public Dialog getErrorDialog(Activity activity, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        return a(activity, i10, zag.zab(activity, getErrorResolutionIntent(activity, i10, "d"), i11), onCancelListener);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @ShowFirstParty
    @KeepForSdk
    public Intent getErrorResolutionIntent(Context context, int i10, String str) {
        return super.getErrorResolutionIntent(context, i10, str);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public PendingIntent getErrorResolutionPendingIntent(Context context, int i10, int i11) {
        return super.getErrorResolutionPendingIntent(context, i10, i11);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public final String getErrorString(int i10) {
        return super.getErrorString(i10);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @HideFirstParty
    public int isGooglePlayServicesAvailable(Context context) {
        return super.isGooglePlayServicesAvailable(context);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public final boolean isUserResolvableError(int i10) {
        return super.isUserResolvableError(i10);
    }

    public boolean showErrorDialogFragment(Activity activity, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        Dialog errorDialog = getErrorDialog(activity, i10, i11, onCancelListener);
        if (errorDialog == null) {
            return false;
        }
        b(activity, errorDialog, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void showErrorNotification(Context context, int i10) {
        c(context, i10, getErrorResolutionPendingIntent(context, i10, 0, "n"));
    }

    public final Dialog zab(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(com.google.android.gms.common.internal.zac.zad(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = builder.create();
        b(activity, alertDialogCreate, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return alertDialogCreate;
    }

    public final zabx zac(Context context, zabw zabwVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zabx zabxVar = new zabx(zabwVar);
        context.registerReceiver(zabxVar, intentFilter);
        zabxVar.zaa(context);
        if (isUninstalledAppPossiblyUpdating(context, "com.google.android.gms")) {
            return zabxVar;
        }
        zabwVar.zaa();
        zabxVar.zab();
        return null;
    }

    public final boolean zag(Activity activity, LifecycleFragment lifecycleFragment, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogA = a(activity, i10, zag.zad(lifecycleFragment, getErrorResolutionIntent(activity, i10, "d"), 2), onCancelListener);
        if (alertDialogA == null) {
            return false;
        }
        b(activity, alertDialogA, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean zah(Context context, ConnectionResult connectionResult, int i10) {
        PendingIntent errorResolutionPendingIntent;
        if (InstantApps.isInstantApp(context) || (errorResolutionPendingIntent = getErrorResolutionPendingIntent(context, connectionResult)) == null) {
            return false;
        }
        c(context, connectionResult.getErrorCode(), zal.zaa(context, 0, GoogleApiActivity.zaa(context, errorResolutionPendingIntent, i10, true), zal.zaa | 134217728));
        return true;
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, ConnectionResult connectionResult) {
        return connectionResult.hasResolution() ? connectionResult.getResolution() : getErrorResolutionPendingIntent(context, connectionResult.getErrorCode(), 0);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @ShowFirstParty
    @KeepForSdk
    public int isGooglePlayServicesAvailable(Context context, int i10) {
        return super.isGooglePlayServicesAvailable(context, i10);
    }
}
