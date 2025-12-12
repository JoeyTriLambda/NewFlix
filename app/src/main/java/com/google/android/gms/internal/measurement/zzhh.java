package com.google.android.gms.internal.measurement;

import ac.c;
import android.content.Context;
import android.net.Uri;
import b0.b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzhh {
    private static final b<String, Uri> zza = new b<>();

    public static synchronized Uri zza(String str) {
        Uri uri;
        b<String, Uri> bVar = zza;
        uri = bVar.get(str);
        if (uri == null) {
            uri = Uri.parse("content://com.google.android.gms.phenotype/" + Uri.encode(str));
            bVar.put(str, uri);
        }
        return uri;
    }

    public static String zza(Context context, String str) {
        if (!str.contains("#")) {
            return c.C(str, "#", context.getPackageName());
        }
        throw new IllegalArgumentException("The passed in package cannot already have a subpackage: ".concat(str));
    }

    public static boolean zza(String str, String str2) {
        if (str.equals("eng") || str.equals("userdebug")) {
            return str2.contains("dev-keys") || str2.contains("test-keys");
        }
        return false;
    }
}
