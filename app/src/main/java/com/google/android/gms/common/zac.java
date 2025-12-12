package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zaq;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
final class zac extends zaq {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7522a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GoogleApiAvailability f7523b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zac(GoogleApiAvailability googleApiAvailability, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f7523b = googleApiAvailability;
        this.f7522a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 != 1) {
            StringBuilder sb2 = new StringBuilder(50);
            sb2.append("Don't know how to handle this message: ");
            sb2.append(i10);
            Log.w("GoogleApiAvailability", sb2.toString());
            return;
        }
        GoogleApiAvailability googleApiAvailability = this.f7523b;
        Context context = this.f7522a;
        int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(context);
        if (googleApiAvailability.isUserResolvableError(iIsGooglePlayServicesAvailable)) {
            googleApiAvailability.showErrorNotification(context, iIsGooglePlayServicesAvailable);
        }
    }
}
