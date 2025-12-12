package r8;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;
import r8.i0;

/* compiled from: IdManager.java */
/* loaded from: classes.dex */
public final class h0 implements i0 {

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f18700g = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: h, reason: collision with root package name */
    public static final String f18701h = Pattern.quote("/");

    /* renamed from: a, reason: collision with root package name */
    public final r.z f18702a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f18703b;

    /* renamed from: c, reason: collision with root package name */
    public final String f18704c;

    /* renamed from: d, reason: collision with root package name */
    public final i9.c f18705d;

    /* renamed from: e, reason: collision with root package name */
    public final d0 f18706e;

    /* renamed from: f, reason: collision with root package name */
    public i0.a f18707f;

    public h0(Context context, String str, i9.c cVar, d0 d0Var) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.f18703b = context;
        this.f18704c = str;
        this.f18705d = cVar;
        this.f18706e = d0Var;
        this.f18702a = new r.z(1);
    }

    public final synchronized String a(SharedPreferences sharedPreferences, String str) {
        String lowerCase;
        String string = UUID.randomUUID().toString();
        lowerCase = string == null ? null : f18700g.matcher(string).replaceAll("").toLowerCase(Locale.US);
        o8.e.getLogger().v("Created new Crashlytics installation ID: " + lowerCase + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", lowerCase).putString("firebase.installation.id", str).apply();
        return lowerCase;
    }

    public String fetchTrueFid() {
        try {
            return (String) p0.awaitEvenIfOnMainThread(this.f18705d.getId());
        } catch (Exception e10) {
            o8.e.getLogger().w("Failed to retrieve Firebase Installation ID.", e10);
            return null;
        }
    }

    public String getAppIdentifier() {
        return this.f18704c;
    }

    public synchronized i0.a getInstallIds() {
        i0.a aVar = this.f18707f;
        boolean z10 = true;
        if (!(aVar == null || (aVar.getFirebaseInstallationId() == null && this.f18706e.isAutomaticDataCollectionEnabled()))) {
            return this.f18707f;
        }
        o8.e.getLogger().v("Determining Crashlytics installation ID...");
        SharedPreferences sharedPrefs = CommonUtils.getSharedPrefs(this.f18703b);
        String string = sharedPrefs.getString("firebase.installation.id", null);
        o8.e.getLogger().v("Cached Firebase Installation ID: " + string);
        if (this.f18706e.isAutomaticDataCollectionEnabled()) {
            String strFetchTrueFid = fetchTrueFid();
            o8.e.getLogger().v("Fetched Firebase Installation ID: " + strFetchTrueFid);
            if (strFetchTrueFid == null) {
                if (string == null) {
                    strFetchTrueFid = "SYN_" + UUID.randomUUID().toString();
                } else {
                    strFetchTrueFid = string;
                }
            }
            if (strFetchTrueFid.equals(string)) {
                this.f18707f = new c(sharedPrefs.getString("crashlytics.installation.id", null), strFetchTrueFid);
            } else {
                this.f18707f = new c(a(sharedPrefs, strFetchTrueFid), strFetchTrueFid);
            }
        } else {
            if (string == null || !string.startsWith("SYN_")) {
                z10 = false;
            }
            if (z10) {
                this.f18707f = i0.a.createWithoutFid(sharedPrefs.getString("crashlytics.installation.id", null));
            } else {
                this.f18707f = i0.a.createWithoutFid(a(sharedPrefs, "SYN_" + UUID.randomUUID().toString()));
            }
        }
        o8.e.getLogger().v("Install IDs: " + this.f18707f);
        return this.f18707f;
    }

    public String getInstallerPackageName() {
        String str;
        r.z zVar = this.f18702a;
        Context context = this.f18703b;
        synchronized (zVar) {
            if (((String) zVar.f18349b) == null) {
                String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                if (installerPackageName == null) {
                    installerPackageName = "";
                }
                zVar.f18349b = installerPackageName;
            }
            str = "".equals((String) zVar.f18349b) ? null : (String) zVar.f18349b;
        }
        return str;
    }

    public String getModelName() {
        Locale locale = Locale.US;
        String str = Build.MANUFACTURER;
        String str2 = f18701h;
        return String.format(locale, "%s/%s", str.replaceAll(str2, ""), Build.MODEL.replaceAll(str2, ""));
    }

    public String getOsBuildVersionString() {
        return Build.VERSION.INCREMENTAL.replaceAll(f18701h, "");
    }

    public String getOsDisplayVersionString() {
        return Build.VERSION.RELEASE.replaceAll(f18701h, "");
    }
}
