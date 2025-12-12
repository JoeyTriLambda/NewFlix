package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import b0.k;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.R;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;
import t0.e;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zac {

    /* renamed from: a, reason: collision with root package name */
    public static final k<String, String> f7373a = new k<>();

    /* renamed from: b, reason: collision with root package name */
    public static Locale f7374b;

    public static String a(Context context, String str, String str2) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        String strB = b(context, str);
        if (strB == null) {
            strB = resources.getString(R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, strB, str2);
    }

    public static String b(Context context, String str) {
        k<String, String> kVar = f7373a;
        synchronized (kVar) {
            Locale locale = e.getLocales(context.getResources().getConfiguration()).get(0);
            if (!locale.equals(f7374b)) {
                kVar.clear();
                f7374b = locale;
            }
            String str2 = kVar.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                Log.w("GoogleApiAvailability", str.length() != 0 ? "Missing resource: ".concat(str) : new String("Missing resource: "));
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                Log.w("GoogleApiAvailability", str.length() != 0 ? "Got empty resource: ".concat(str) : new String("Got empty resource: "));
                return null;
            }
            kVar.put(str, string);
            return string;
        }
    }

    public static String zaa(Context context) {
        String packageName = context.getPackageName();
        try {
            return Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String zab(Context context) {
        return context.getResources().getString(com.google.android.gms.base.R.string.common_google_play_services_notification_channel_name);
    }

    public static String zac(Context context, int i10) {
        Resources resources = context.getResources();
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? resources.getString(android.R.string.ok) : resources.getString(com.google.android.gms.base.R.string.common_google_play_services_enable_button) : resources.getString(com.google.android.gms.base.R.string.common_google_play_services_update_button) : resources.getString(com.google.android.gms.base.R.string.common_google_play_services_install_button);
    }

    public static String zad(Context context, int i10) {
        Resources resources = context.getResources();
        String strZaa = zaa(context);
        if (i10 == 1) {
            return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_install_text, strZaa);
        }
        if (i10 == 2) {
            return DeviceProperties.isWearableWithoutPlayStore(context) ? resources.getString(com.google.android.gms.base.R.string.common_google_play_services_wear_update_text) : resources.getString(com.google.android.gms.base.R.string.common_google_play_services_update_text, strZaa);
        }
        if (i10 == 3) {
            return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_enable_text, strZaa);
        }
        if (i10 == 5) {
            return a(context, "common_google_play_services_invalid_account_text", strZaa);
        }
        if (i10 == 7) {
            return a(context, "common_google_play_services_network_error_text", strZaa);
        }
        if (i10 == 9) {
            return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_unsupported_text, strZaa);
        }
        if (i10 == 20) {
            return a(context, "common_google_play_services_restricted_profile_text", strZaa);
        }
        switch (i10) {
            case 16:
                return a(context, "common_google_play_services_api_unavailable_text", strZaa);
            case 17:
                return a(context, "common_google_play_services_sign_in_failed_text", strZaa);
            case 18:
                return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_updating_text, strZaa);
            default:
                return resources.getString(R.string.common_google_play_services_unknown_issue, strZaa);
        }
    }

    public static String zae(Context context, int i10) {
        return (i10 == 6 || i10 == 19) ? a(context, "common_google_play_services_resolution_required_text", zaa(context)) : zad(context, i10);
    }

    public static String zaf(Context context, int i10) {
        String strB = i10 == 6 ? b(context, "common_google_play_services_resolution_required_title") : zag(context, i10);
        return strB == null ? context.getResources().getString(com.google.android.gms.base.R.string.common_google_play_services_notification_ticker) : strB;
    }

    public static String zag(Context context, int i10) {
        Resources resources = context.getResources();
        switch (i10) {
            case 1:
                return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return b(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return b(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                StringBuilder sb2 = new StringBuilder(33);
                sb2.append("Unexpected error code ");
                sb2.append(i10);
                Log.e("GoogleApiAvailability", sb2.toString());
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return b(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return b(context, "common_google_play_services_restricted_profile_title");
        }
    }
}
