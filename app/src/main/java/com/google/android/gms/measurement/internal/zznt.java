package com.google.android.gms.measurement.internal;

import ac.c;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzpm;
import com.google.android.gms.internal.measurement.zzqv;
import com.unity3d.ads.metadata.MediationMetaData;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import o1.a;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zznt extends zzil {

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f8600i = {"firebase_", "google_", "ga_"};

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f8601j = {"_err"};

    /* renamed from: c, reason: collision with root package name */
    public SecureRandom f8602c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicLong f8603d;

    /* renamed from: e, reason: collision with root package name */
    public int f8604e;

    /* renamed from: f, reason: collision with root package name */
    public MeasurementManagerFutures f8605f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f8606g;

    /* renamed from: h, reason: collision with root package name */
    public Integer f8607h;

    public zznt(zzho zzhoVar) {
        super(zzhoVar);
        this.f8607h = null;
        this.f8603d = new AtomicLong(0L);
    }

    public static boolean B(Context context) {
        ServiceInfo serviceInfo;
        ServiceInfo serviceInfo2;
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (serviceInfo2 = packageManager.getServiceInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementJobService"), 0)) != null) {
                    if (serviceInfo2.enabled) {
                        return true;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return false;
        }
        try {
            PackageManager packageManager2 = context.getPackageManager();
            if (packageManager2 != null && (serviceInfo = packageManager2.getServiceInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        return false;
    }

    public static boolean D(int i10, Bundle bundle) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i10);
        return true;
    }

    public static int G() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(1000000);
    }

    public static boolean L(String str, String str2) {
        return str.equals("*") || Arrays.asList(str.split(",")).contains(str2);
    }

    public static boolean M(String str) {
        return L(zzbh.f7770v0.zza(null), str);
    }

    public static boolean N(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static boolean O(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static int R(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return ("_lgclid".equals(str) || "_gbraid".equals(str)) ? 100 : 36;
    }

    public static MessageDigest S() throws NoSuchAlgorithmException {
        MessageDigest messageDigest;
        for (int i10 = 0; i10 < 2; i10++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public static long d(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int i10 = 0;
        Preconditions.checkState(bArr.length > 0);
        long j10 = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j10 += (bArr[length] & 255) << i10;
            i10 += 8;
        }
        return j10;
    }

    public static void i(Bundle bundle, int i10, String str, Object obj) {
        if (D(i10, bundle)) {
            bundle.putString("_ev", zza(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", String.valueOf(obj).length());
                }
            }
        }
    }

    public static void m(zzns zznsVar, String str, int i10, String str2, String str3, int i11) {
        Bundle bundle = new Bundle();
        D(i10, bundle);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i10 == 6 || i10 == 7 || i10 == 2) {
            bundle.putLong("_el", i11);
        }
        zznsVar.zza(str, "_err", bundle);
    }

    public static boolean q(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean r(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    public static boolean s(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public static boolean w(String str, String str2, String str3, String str4) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (!zIsEmpty && !zIsEmpty2) {
            Preconditions.checkNotNull(str);
            return !str.equals(str2);
        }
        if (zIsEmpty && zIsEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (zIsEmpty || !zIsEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    public static boolean x(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] z(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public final Bundle A(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object objC = C(bundle.get(str), str);
                if (objC == null) {
                    zzj().zzv().zza("Param value can't be null", zzi().zzb(str));
                } else {
                    k(bundle2, str, objC);
                }
            }
        }
        return bundle2;
    }

    public final Object C(Object obj, String str) {
        if ("_ev".equals(str)) {
            return h(zze().b(null, false), obj, true, true);
        }
        return h(N(str) ? zze().b(null, false) : zze().a(null, false), obj, false, true);
    }

    public final boolean E(Context context, String str) throws IllegalStateException {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e10) {
            zzj().zzg().zza("Package name not found", e10);
            return true;
        } catch (CertificateException e11) {
            zzj().zzg().zza("Error obtaining certificate", e11);
            return true;
        }
    }

    public final boolean F(String str, String str2) throws IllegalStateException {
        if (str2 == null) {
            zzj().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            zzj().zzh().zza("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt) && iCodePointAt != 95) {
            zzj().zzh().zza("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                zzj().zzh().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final Object H(Object obj, String str) {
        return "_ldl".equals(str) ? h(R(str), obj, true, false) : h(R(str), obj, false, false);
    }

    public final boolean I(String str, String str2) throws IllegalStateException {
        if (str2 == null) {
            zzj().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            zzj().zzh().zza("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            zzj().zzh().zza("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                zzj().zzh().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean J(String str, String str2) {
        if (zzqv.zza() && zze().zza(zzbh.f7768u0) && !TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return zze().zzn().equals(str);
    }

    public final boolean K(String str) throws IllegalStateException {
        zzt();
        if (Wrappers.packageManager(zza()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzj().zzc().zza("Permission not granted", str);
        return false;
    }

    public final int P(String str) {
        if (!F("event param", str)) {
            return 3;
        }
        if (y("event param", null, null, str)) {
            return !p(40, "event param", str) ? 3 : 0;
        }
        return 14;
    }

    public final int Q(String str) {
        if (!I("event param", str)) {
            return 3;
        }
        if (y("event param", null, null, str)) {
            return !p(40, "event param", str) ? 3 : 0;
        }
        return 14;
    }

    public final SecureRandom T() {
        zzt();
        if (this.f8602c == null) {
            this.f8602c = new SecureRandom();
        }
        return this.f8602c;
    }

    public final int a(Object obj, String str) {
        return "_ldl".equals(str) ? v("user property referrer", str, R(str), obj) : v("user property", str, R(str), obj) ? 0 : 7;
    }

    public final int b(String str) {
        if (!F("event", str)) {
            return 2;
        }
        if (y("event", zzit.f8212a, zzit.f8213b, str)) {
            return !p(40, "event", str) ? 2 : 0;
        }
        return 13;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int c(java.lang.String r15, java.lang.String r16, java.lang.Object r17, android.os.Bundle r18, java.util.List r19, boolean r20, boolean r21) throws java.lang.IllegalStateException {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznt.c(java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public final Bundle e(Uri uri, boolean z10, boolean z11) throws IllegalStateException {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        String queryParameter8;
        String queryParameter9;
        String str;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                queryParameter = uri.getQueryParameter("utm_campaign");
                queryParameter2 = uri.getQueryParameter("utm_source");
                queryParameter3 = uri.getQueryParameter("utm_medium");
                queryParameter4 = uri.getQueryParameter("gclid");
                queryParameter5 = z11 ? uri.getQueryParameter("gbraid") : null;
                queryParameter6 = uri.getQueryParameter("utm_id");
                queryParameter7 = uri.getQueryParameter("dclid");
                queryParameter8 = uri.getQueryParameter("srsltid");
                queryParameter9 = z10 ? uri.getQueryParameter("sfmc_id") : null;
            } else {
                queryParameter = null;
                queryParameter2 = null;
                queryParameter3 = null;
                queryParameter4 = null;
                queryParameter5 = null;
                queryParameter6 = null;
                queryParameter7 = null;
                queryParameter8 = null;
                queryParameter9 = null;
            }
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && ((!z11 || TextUtils.isEmpty(queryParameter5)) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7) && TextUtils.isEmpty(queryParameter8) && (!z10 || TextUtils.isEmpty(queryParameter9)))) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(queryParameter)) {
                str = "sfmc_id";
            } else {
                str = "sfmc_id";
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("source", queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            if (z11 && !TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("gbraid", queryParameter5);
            }
            String queryParameter10 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter10)) {
                bundle.putString("term", queryParameter10);
            }
            String queryParameter11 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter11)) {
                bundle.putString("content", queryParameter11);
            }
            String queryParameter12 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter12)) {
                bundle.putString("aclid", queryParameter12);
            }
            String queryParameter13 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter13)) {
                bundle.putString("cp1", queryParameter13);
            }
            String queryParameter14 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter14)) {
                bundle.putString("anid", queryParameter14);
            }
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("campaign_id", queryParameter6);
            }
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("dclid", queryParameter7);
            }
            String queryParameter15 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter15)) {
                bundle.putString("source_platform", queryParameter15);
            }
            String queryParameter16 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter16)) {
                bundle.putString("creative_format", queryParameter16);
            }
            String queryParameter17 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter17)) {
                bundle.putString("marketing_tactic", queryParameter17);
            }
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("srsltid", queryParameter8);
            }
            if (z10 && !TextUtils.isEmpty(queryParameter9)) {
                bundle.putString(str, queryParameter9);
            }
            return bundle;
        } catch (UnsupportedOperationException e10) {
            zzj().zzu().zza("Install referrer url isn't a hierarchical URI", e10);
            return null;
        }
    }

    public final Bundle f(String str, Bundle bundle, List list, boolean z10) {
        int iQ;
        zznt zzntVar = this;
        boolean zX = x(str, zzit.f8215d);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int iZzg = zze().zzg();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        int i10 = 0;
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (list == null || !list.contains(str2)) {
                iQ = !z10 ? zzntVar.Q(str2) : 0;
                if (iQ == 0) {
                    iQ = zzntVar.P(str2);
                }
            } else {
                iQ = 0;
            }
            if (iQ != 0) {
                i(bundle2, iQ, str2, iQ == 3 ? str2 : null);
                bundle2.remove(str2);
            } else {
                int iC = c(str, str2, bundle.get(str2), bundle2, list, z10, zX);
                if (iC == 17) {
                    i(bundle2, iC, str2, Boolean.FALSE);
                } else if (iC != 0 && !"_ev".equals(str2)) {
                    i(bundle2, iC, iC == 21 ? str : str2, bundle.get(str2));
                    bundle2.remove(str2);
                }
                if (O(str2)) {
                    int i11 = i10 + 1;
                    if (i11 > iZzg) {
                        zzj().zzh().zza(a.d("Event can't contain more than ", iZzg, " params"), zzi().zza(str), zzi().zza(bundle));
                        D(5, bundle2);
                        bundle2.remove(str2);
                    }
                    zzntVar = this;
                    i10 = i11;
                }
            }
            zzntVar = this;
        }
        return bundle2;
    }

    public final zzbf g(String str, Bundle bundle, String str2, long j10, boolean z10) throws IllegalStateException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (b(str) != 0) {
            zzj().zzg().zza("Invalid conditional property event name", zzi().zzc(str));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str2);
        Bundle bundleF = f(str, bundle2, CollectionUtils.listOf("_o"), true);
        if (z10) {
            bundleF = A(bundleF);
        }
        Preconditions.checkNotNull(bundleF);
        return new zzbf(str, new zzba(bundleF), str2, j10);
    }

    public final Object h(int i10, Object obj, boolean z10, boolean z11) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return zza(String.valueOf(obj), i10, z10);
        }
        if (!z11 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle bundleA = A((Bundle) parcelable);
                if (!bundleA.isEmpty()) {
                    arrayList.add(bundleA);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final void j(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                zzq().k(bundle, str, bundle2.get(str));
            }
        }
    }

    public final void k(Bundle bundle, String str, Object obj) throws IllegalStateException {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            zzj().zzv().zza("Not putting event parameter. Invalid value type. name, type", zzi().zzb(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    public final void l(zzgf zzgfVar, int i10) {
        Iterator it = new TreeSet(zzgfVar.f7975d.keySet()).iterator();
        int i11 = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (O(str) && (i11 = i11 + 1) > i10) {
                String strD = a.d("Event can't contain more than ", i10, " params");
                zzgd zzgdVarZzh = zzj().zzh();
                String strZza = zzi().zza(zzgfVar.f7972a);
                zzfw zzfwVarZzi = zzi();
                Bundle bundle = zzgfVar.f7975d;
                zzgdVarZzh.zza(strD, strZza, zzfwVarZzi.zza(bundle));
                D(5, bundle);
                bundle.remove(str);
            }
        }
    }

    public final void n(String str, String str2, Bundle bundle, List list, boolean z10) throws IllegalStateException {
        int iQ;
        String str3;
        int iC;
        if (bundle == null) {
            return;
        }
        zzae zzaeVarZze = zze();
        zzaeVarZze.getClass();
        String str4 = null;
        int i10 = (zzpm.zza() && zzaeVarZze.zze().zzf(null, zzbh.B0) && zzaeVarZze.zzq().zza(231100000, true)) ? 35 : 0;
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        int i11 = 0;
        while (it.hasNext()) {
            String str5 = (String) it.next();
            if (list == null || !list.contains(str5)) {
                iQ = !z10 ? Q(str5) : 0;
                if (iQ == 0) {
                    iQ = P(str5);
                }
            } else {
                iQ = 0;
            }
            if (iQ != 0) {
                if (iQ == 3) {
                    str4 = str5;
                }
                i(bundle, iQ, str5, str4);
                bundle.remove(str5);
            } else {
                if (s(bundle.get(str5))) {
                    zzj().zzv().zza("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str, str2, str5);
                    iC = 22;
                    str3 = str5;
                } else {
                    str3 = str5;
                    iC = c(str, str5, bundle.get(str5), bundle, list, z10, false);
                }
                if (iC == 0 || "_ev".equals(str3)) {
                    if (O(str3) && !x(str3, zzis.f8211d)) {
                        int i12 = i11 + 1;
                        if (!zza(231100000, true)) {
                            zzj().zzh().zza("Item array not supported on client's version of Google Play Services (Android Only)", zzi().zza(str), zzi().zza(bundle));
                            D(23, bundle);
                            bundle.remove(str3);
                        } else if (i12 > i10) {
                            if (zzpm.zza() && zze().zza(zzbh.B0)) {
                                zzj().zzh().zza(a.d("Item can't contain more than ", i10, " item-scoped custom params"), zzi().zza(str), zzi().zza(bundle));
                                D(28, bundle);
                                bundle.remove(str3);
                            } else {
                                zzj().zzh().zza("Item cannot contain custom parameters", zzi().zza(str), zzi().zza(bundle));
                                D(23, bundle);
                                bundle.remove(str3);
                            }
                        }
                        i11 = i12;
                    }
                    str4 = null;
                } else {
                    i(bundle, iC, str3, bundle.get(str3));
                    bundle.remove(str3);
                }
            }
            str4 = null;
        }
    }

    public final void o(Parcelable[] parcelableArr, int i10, boolean z10) {
        Preconditions.checkNotNull(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            Iterator it = new TreeSet(bundle.keySet()).iterator();
            int i11 = 0;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (O(str) && !x(str, zzis.f8211d) && (i11 = i11 + 1) > i10) {
                    if (z10) {
                        zzj().zzh().zza(a.d("Param can't contain more than ", i10, " item-scoped custom parameters"), zzi().zzb(str), zzi().zza(bundle));
                        D(28, bundle);
                    } else {
                        zzj().zzh().zza("Param cannot contain item-scoped custom parameters", zzi().zzb(str), zzi().zza(bundle));
                        D(23, bundle);
                    }
                    bundle.remove(str);
                }
            }
        }
    }

    public final boolean p(int i10, String str, String str2) throws IllegalStateException {
        if (str2 == null) {
            zzj().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i10) {
            return true;
        }
        zzj().zzh().zza("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i10), str2);
        return false;
    }

    @SuppressLint({"ApplySharedPref"})
    public final boolean t(String str, double d10) throws IllegalStateException {
        try {
            SharedPreferences.Editor editorEdit = zza().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            editorEdit.putString("deeplink", str);
            editorEdit.putLong("timestamp", Double.doubleToRawLongBits(d10));
            return editorEdit.commit();
        } catch (RuntimeException e10) {
            zzj().zzg().zza("Failed to persist Deferred Deep Link. exception", e10);
            return false;
        }
    }

    public final boolean u(String str, String str2) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        zzho zzhoVar = this.f8189a;
        if (!zIsEmpty) {
            Preconditions.checkNotNull(str);
            if (str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
                return true;
            }
            if (zzhoVar.zzae()) {
                zzj().zzh().zza("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzgb.zza(str));
            }
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (zzhoVar.zzae()) {
                zzj().zzh().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
        Preconditions.checkNotNull(str2);
        if (str2.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
            return true;
        }
        zzj().zzh().zza("Invalid admob_app_id. Analytics disabled.", zzgb.zza(str2));
        return false;
    }

    public final boolean v(String str, String str2, int i10, Object obj) throws IllegalStateException {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String strValueOf = String.valueOf(obj);
            if (strValueOf.codePointCount(0, strValueOf.length()) > i10) {
                zzj().zzv().zza("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(strValueOf.length()));
                return false;
            }
        }
        return true;
    }

    public final boolean y(String str, String[] strArr, String[] strArr2, String str2) throws IllegalStateException {
        boolean z10;
        if (str2 == null) {
            zzj().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = f8600i;
        int i10 = 0;
        while (true) {
            if (i10 >= 3) {
                z10 = false;
                break;
            }
            if (str2.startsWith(strArr3[i10])) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10) {
            zzj().zzh().zza("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr == null || !x(str2, strArr) || (strArr2 != null && x(str2, strArr2))) {
            return true;
        }
        zzj().zzh().zza("Name is reserved. Type, name", str, str2);
        return false;
    }

    public final int zza(int i10) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(zza(), 12451000);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzaa() throws IllegalStateException {
        zzt();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        if (jNextLong == 0) {
            jNextLong = secureRandom.nextLong();
            if (jNextLong == 0) {
                zzj().zzu().zza("Utils falling back to Random for random id");
            }
        }
        this.f8603d.set(jNextLong);
    }

    public final int zzb(String str) {
        if (!F("user property", str)) {
            return 6;
        }
        if (y("user property", zziv.f8216a, null, str)) {
            return !p(24, "user property", str) ? 6 : 0;
        }
        return 15;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    public final int zzg() {
        if (this.f8607h == null) {
            this.f8607h = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(zza()) / 1000);
        }
        return this.f8607h.intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00cd A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzh() throws java.util.concurrent.ExecutionException, java.lang.IllegalStateException, java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            r11 = this;
            r11.zzt()
            com.google.android.gms.measurement.internal.zzho r0 = r11.f8189a
            com.google.android.gms.measurement.internal.zzfv r0 = r0.zzh()
            java.lang.String r0 = r0.a()
            com.google.android.gms.measurement.internal.zzfo<java.lang.String> r1 = com.google.android.gms.measurement.internal.zzbh.f7729b0
            r2 = 0
            java.lang.Object r1 = r1.zza(r2)
            java.lang.String r1 = (java.lang.String) r1
            boolean r0 = L(r1, r0)
            r3 = 0
            if (r0 != 0) goto L1f
            return r3
        L1f:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r0 >= r1) goto L28
            r0 = 4
            goto L48
        L28:
            int r0 = android.os.ext.SdkExtensions.getExtensionVersion(r1)
            r1 = 4
            if (r0 >= r1) goto L32
            r0 = 8
            goto L48
        L32:
            int r0 = G()
            com.google.android.gms.measurement.internal.zzfo<java.lang.Integer> r1 = com.google.android.gms.measurement.internal.zzbh.W
            java.lang.Object r1 = r1.zza(r2)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r0 >= r1) goto L47
            r0 = 16
            goto L48
        L47:
            r0 = r3
        L48:
            java.lang.String r5 = "android.permission.ACCESS_ADSERVICES_ATTRIBUTION"
            boolean r5 = r11.K(r5)
            if (r5 != 0) goto L53
            r5 = 2
            long r0 = r0 | r5
        L53:
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 != 0) goto Lc9
            java.lang.Boolean r5 = r11.f8606g
            if (r5 != 0) goto Lbe
            androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures r5 = r11.f8605f
            if (r5 != 0) goto L69
            android.content.Context r5 = r11.zza()
            androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures r5 = androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures.from(r5)
            r11.f8605f = r5
        L69:
            androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures r5 = r11.f8605f
            r6 = 0
            if (r5 != 0) goto L6f
            goto Lc4
        L6f:
            e8.c r5 = r5.getMeasurementApiStatusAsync()
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.util.concurrent.TimeoutException -> L96 java.lang.InterruptedException -> L98 java.util.concurrent.ExecutionException -> L9a java.util.concurrent.CancellationException -> L9c
            r8 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r5 = r5.get(r8, r7)     // Catch: java.util.concurrent.TimeoutException -> L96 java.lang.InterruptedException -> L98 java.util.concurrent.ExecutionException -> L9a java.util.concurrent.CancellationException -> L9c
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.util.concurrent.TimeoutException -> L96 java.lang.InterruptedException -> L98 java.util.concurrent.ExecutionException -> L9a java.util.concurrent.CancellationException -> L9c
            if (r5 == 0) goto L87
            int r2 = r5.intValue()     // Catch: java.util.concurrent.TimeoutException -> L8e java.lang.InterruptedException -> L90 java.util.concurrent.ExecutionException -> L92 java.util.concurrent.CancellationException -> L94
            r7 = 1
            if (r2 != r7) goto L87
            r6 = 1
        L87:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r6)     // Catch: java.util.concurrent.TimeoutException -> L8e java.lang.InterruptedException -> L90 java.util.concurrent.ExecutionException -> L92 java.util.concurrent.CancellationException -> L94
            r11.f8606g = r2     // Catch: java.util.concurrent.TimeoutException -> L8e java.lang.InterruptedException -> L90 java.util.concurrent.ExecutionException -> L92 java.util.concurrent.CancellationException -> L94
            goto Lb1
        L8e:
            r2 = move-exception
            goto La0
        L90:
            r2 = move-exception
            goto La0
        L92:
            r2 = move-exception
            goto La0
        L94:
            r2 = move-exception
            goto La0
        L96:
            r5 = move-exception
            goto L9d
        L98:
            r5 = move-exception
            goto L9d
        L9a:
            r5 = move-exception
            goto L9d
        L9c:
            r5 = move-exception
        L9d:
            r10 = r5
            r5 = r2
            r2 = r10
        La0:
            com.google.android.gms.measurement.internal.zzgb r6 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgd r6 = r6.zzu()
            java.lang.String r7 = "Measurement manager api exception"
            r6.zza(r7, r2)
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r11.f8606g = r2
        Lb1:
            com.google.android.gms.measurement.internal.zzgb r2 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzp()
            java.lang.String r6 = "Measurement manager api status result"
            r2.zza(r6, r5)
        Lbe:
            java.lang.Boolean r2 = r11.f8606g
            boolean r6 = r2.booleanValue()
        Lc4:
            if (r6 != 0) goto Lc9
            r5 = 64
            long r0 = r0 | r5
        Lc9:
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 != 0) goto Lcf
            r0 = 1
        Lcf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznt.zzh():long");
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    public final long zzm() {
        long andIncrement;
        long j10;
        if (this.f8603d.get() != 0) {
            synchronized (this.f8603d) {
                this.f8603d.compareAndSet(-1L, 1L);
                andIncrement = this.f8603d.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (this.f8603d) {
            long jNextLong = new Random(System.nanoTime() ^ zzb().currentTimeMillis()).nextLong();
            int i10 = this.f8604e + 1;
            this.f8604e = i10;
            j10 = jNextLong + i10;
        }
        return j10;
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final boolean zzo() {
        return true;
    }

    public final String zzp() {
        byte[] bArr = new byte[16];
        T().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    public final boolean zzw() {
        zzt();
        return zzh() == 1;
    }

    public final boolean zzx() throws ClassNotFoundException {
        try {
            zza().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean zzj(String str) {
        return !f8601j[0].equals(str);
    }

    public final boolean zzi(String str) {
        List<ResolveInfo> listQueryIntentActivities;
        return (TextUtils.isEmpty(str) || (listQueryIntentActivities = zza().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 0)) == null || listQueryIntentActivities.isEmpty()) ? false : true;
    }

    public static long zza(zzba zzbaVar) {
        long length = 0;
        if (zzbaVar == null) {
            return 0L;
        }
        Iterator<String> it = zzbaVar.iterator();
        while (it.hasNext()) {
            if (zzbaVar.f7707b.get(it.next()) instanceof Parcelable[]) {
                length += ((Parcelable[]) r3).length;
            }
        }
        return length;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    public static ArrayList<Bundle> zzb(List<zzac> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzac zzacVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzacVar.f7627b);
            bundle.putString("origin", zzacVar.f7628m);
            bundle.putLong("creation_timestamp", zzacVar.f7630o);
            bundle.putString(MediationMetaData.KEY_NAME, zzacVar.f7629n.f8589m);
            zzin.zza(bundle, Preconditions.checkNotNull(zzacVar.f7629n.zza()));
            bundle.putBoolean("active", zzacVar.f7631p);
            String str = zzacVar.f7632q;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzbf zzbfVar = zzacVar.f7633r;
            if (zzbfVar != null) {
                bundle.putString("timed_out_event_name", zzbfVar.f7720b);
                zzba zzbaVar = zzbfVar.f7721m;
                if (zzbaVar != null) {
                    bundle.putBundle("timed_out_event_params", zzbaVar.zzb());
                }
            }
            bundle.putLong("trigger_timeout", zzacVar.f7634s);
            zzbf zzbfVar2 = zzacVar.f7635t;
            if (zzbfVar2 != null) {
                bundle.putString("triggered_event_name", zzbfVar2.f7720b);
                zzba zzbaVar2 = zzbfVar2.f7721m;
                if (zzbaVar2 != null) {
                    bundle.putBundle("triggered_event_params", zzbaVar2.zzb());
                }
            }
            bundle.putLong("triggered_timestamp", zzacVar.f7629n.f8590n);
            bundle.putLong("time_to_live", zzacVar.f7636u);
            zzbf zzbfVar3 = zzacVar.f7637v;
            if (zzbfVar3 != null) {
                bundle.putString("expired_event_name", zzbfVar3.f7720b);
                zzba zzbaVar3 = zzbfVar3.f7721m;
                if (zzbaVar3 != null) {
                    bundle.putBundle("expired_event_params", zzbaVar3.zzb());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static long zza(long j10, long j11) {
        return ((j11 * DateUtils.MILLIS_PER_MINUTE) + j10) / DateUtils.MILLIS_PER_DAY;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public static Bundle zza(List<zzno> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (zzno zznoVar : list) {
            String str = zznoVar.f8592p;
            String str2 = zznoVar.f8589m;
            if (str != null) {
                bundle.putString(str2, str);
            } else {
                Long l10 = zznoVar.f8591o;
                if (l10 != null) {
                    bundle.putLong(str2, l10.longValue());
                } else {
                    Double d10 = zznoVar.f8594r;
                    if (d10 != null) {
                        bundle.putDouble(str2, d10.doubleValue());
                    }
                }
            }
        }
        return bundle;
    }

    public static Bundle zza(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i10 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i10 < parcelableArr.length) {
                        if (parcelableArr[i10] instanceof Bundle) {
                            parcelableArr[i10] = new Bundle((Bundle) parcelableArr[i10]);
                        }
                        i10++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i10 < list.size()) {
                        Object obj2 = list.get(i10);
                        if (obj2 instanceof Bundle) {
                            list.set(i10, new Bundle((Bundle) obj2));
                        }
                        i10++;
                    }
                }
            }
        }
        return bundle2;
    }

    public static String zza(String str, int i10, boolean z10) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i10) {
            return str;
        }
        if (z10) {
            return c.B(str.substring(0, str.offsetByCodePoints(0, i10)), "...");
        }
        return null;
    }

    public final URL zza(long j10, String str, String str2, long j11, String str3) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String strConcat = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", Long.valueOf(j10), Integer.valueOf(zzg())), str2, str, Long.valueOf(j11));
            if (str.equals(zze().zzo())) {
                strConcat = strConcat.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    strConcat = strConcat.concat("&");
                }
                strConcat = strConcat.concat(str3);
            }
            return new URL(strConcat);
        } catch (IllegalArgumentException | MalformedURLException e10) {
            zzj().zzg().zza("Failed to create BOW URL for Deferred Deep Link. exception", e10.getMessage());
            return null;
        }
    }

    public final void zza(Bundle bundle, long j10) {
        long j11 = bundle.getLong("_et");
        if (j11 != 0) {
            zzj().zzu().zza("Params already contained engagement", Long.valueOf(j11));
        }
        bundle.putLong("_et", j10 + j11);
    }

    public static void zza(zzks zzksVar, Bundle bundle, boolean z10) {
        if (bundle == null || zzksVar == null || (bundle.containsKey("_sc") && !z10)) {
            if (bundle != null && zzksVar == null && z10) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
                return;
            }
            return;
        }
        String str = zzksVar.f8351a;
        if (str != null) {
            bundle.putString("_sn", str);
        } else {
            bundle.remove("_sn");
        }
        String str2 = zzksVar.f8352b;
        if (str2 != null) {
            bundle.putString("_sc", str2);
        } else {
            bundle.remove("_sc");
        }
        bundle.putLong("_si", zzksVar.f8353c);
    }

    public static void zza(zzns zznsVar, int i10, String str, String str2, int i11) {
        m(zznsVar, null, i10, str, str2, i11);
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, boolean z10) throws IllegalStateException {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z10);
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e10) {
            this.f8189a.zzj().zzu().zza("Error returning boolean value to wrapper", e10);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, ArrayList<Bundle> arrayList) throws IllegalStateException {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e10) {
            this.f8189a.zzj().zzu().zza("Error returning bundle list to wrapper", e10);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, Bundle bundle) throws IllegalStateException {
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e10) {
            this.f8189a.zzj().zzu().zza("Error returning bundle value to wrapper", e10);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, byte[] bArr) throws IllegalStateException {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e10) {
            this.f8189a.zzj().zzu().zza("Error returning byte array to wrapper", e10);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, int i10) throws IllegalStateException {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i10);
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e10) {
            this.f8189a.zzj().zzu().zza("Error returning int value to wrapper", e10);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, long j10) throws IllegalStateException {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j10);
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e10) {
            this.f8189a.zzj().zzu().zza("Error returning long value to wrapper", e10);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, String str) throws IllegalStateException {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e10) {
            this.f8189a.zzj().zzu().zza("Error returning string value to wrapper", e10);
        }
    }

    public final boolean zza(int i10, boolean z10) {
        Boolean bool = this.f8189a.zzr().f8387e;
        if (zzg() < i10 / 1000) {
            return (bool == null || bool.booleanValue()) ? false : true;
        }
        return true;
    }
}
