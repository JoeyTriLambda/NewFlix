package com.google.firebase.crashlytics.internal.settings;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
import r8.c0;
import r8.d0;
import r8.h0;
import r8.n0;
import y8.b;
import y8.c;
import y8.d;
import y8.e;
import y8.g;
import y8.h;
import y8.i;

/* compiled from: SettingsController.java */
/* loaded from: classes.dex */
public final class a implements g {

    /* renamed from: a, reason: collision with root package name */
    public final Context f9773a;

    /* renamed from: b, reason: collision with root package name */
    public final h f9774b;

    /* renamed from: c, reason: collision with root package name */
    public final e f9775c;

    /* renamed from: d, reason: collision with root package name */
    public final c0 f9776d;

    /* renamed from: e, reason: collision with root package name */
    public final y8.a f9777e;

    /* renamed from: f, reason: collision with root package name */
    public final i f9778f;

    /* renamed from: g, reason: collision with root package name */
    public final d0 f9779g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicReference<d> f9780h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicReference<TaskCompletionSource<d>> f9781i;

    /* compiled from: SettingsController.java */
    /* renamed from: com.google.firebase.crashlytics.internal.settings.a$a, reason: collision with other inner class name */
    public class C0099a implements SuccessContinuation<Void, Void> {
        public C0099a() {
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        public Task<Void> then(Void r72) throws Exception {
            a aVar = a.this;
            c cVar = (c) aVar.f9778f;
            h hVar = aVar.f9774b;
            JSONObject jSONObjectInvoke = cVar.invoke(hVar, true);
            if (jSONObjectInvoke != null) {
                d settingsJson = aVar.f9775c.parseSettingsJson(jSONObjectInvoke);
                aVar.f9777e.writeCachedSettings(settingsJson.f22024c, jSONObjectInvoke);
                o8.e.getLogger().d("Loaded settings: " + jSONObjectInvoke.toString());
                String str = hVar.f22039f;
                SharedPreferences.Editor editorEdit = CommonUtils.getSharedPrefs(aVar.f9773a).edit();
                editorEdit.putString("existing_instance_identifier", str);
                editorEdit.apply();
                aVar.f9780h.set(settingsJson);
                aVar.f9781i.get().trySetResult(settingsJson);
            }
            return Tasks.forResult(null);
        }
    }

    public a(Context context, h hVar, n0 n0Var, e eVar, y8.a aVar, c cVar, d0 d0Var) {
        AtomicReference<d> atomicReference = new AtomicReference<>();
        this.f9780h = atomicReference;
        this.f9781i = new AtomicReference<>(new TaskCompletionSource());
        this.f9773a = context;
        this.f9774b = hVar;
        this.f9776d = n0Var;
        this.f9775c = eVar;
        this.f9777e = aVar;
        this.f9778f = cVar;
        this.f9779g = d0Var;
        atomicReference.set(b.a(n0Var));
    }

    public static a create(Context context, String str, h0 h0Var, v8.b bVar, String str2, String str3, w8.b bVar2, d0 d0Var) {
        String installerPackageName = h0Var.getInstallerPackageName();
        n0 n0Var = new n0();
        return new a(context, new h(str, h0Var.getModelName(), h0Var.getOsBuildVersionString(), h0Var.getOsDisplayVersionString(), h0Var, CommonUtils.createInstanceIdFrom(CommonUtils.getMappingFileId(context), str, str3, str2), str3, str2, DeliveryMechanism.determineFrom(installerPackageName).getId()), n0Var, new e(n0Var), new y8.a(bVar2), new c(String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", str), bVar), d0Var);
    }

    public final d a(SettingsCacheBehavior settingsCacheBehavior) throws Throwable {
        d dVar = null;
        try {
            if (!SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                JSONObject cachedSettings = this.f9777e.readCachedSettings();
                if (cachedSettings != null) {
                    d settingsJson = this.f9775c.parseSettingsJson(cachedSettings);
                    if (settingsJson != null) {
                        o8.e.getLogger().d("Loaded cached settings: " + cachedSettings.toString());
                        long currentTimeMillis = ((n0) this.f9776d).getCurrentTimeMillis();
                        if (SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) || !settingsJson.isExpired(currentTimeMillis)) {
                            try {
                                o8.e.getLogger().v("Returning cached settings.");
                                dVar = settingsJson;
                            } catch (Exception e10) {
                                e = e10;
                                dVar = settingsJson;
                                o8.e.getLogger().e("Failed to get cached settings", e);
                                return dVar;
                            }
                        } else {
                            o8.e.getLogger().v("Cached settings have expired.");
                        }
                    } else {
                        o8.e.getLogger().e("Failed to parse cached settings data.", null);
                    }
                } else {
                    o8.e.getLogger().d("No cached settings data found.");
                }
            }
        } catch (Exception e11) {
            e = e11;
        }
        return dVar;
    }

    public Task<d> getSettingsAsync() {
        return this.f9781i.get().getTask();
    }

    public d getSettingsSync() {
        return this.f9780h.get();
    }

    public Task<Void> loadSettingsData(Executor executor) {
        return loadSettingsData(SettingsCacheBehavior.USE_CACHE, executor);
    }

    public Task<Void> loadSettingsData(SettingsCacheBehavior settingsCacheBehavior, Executor executor) throws Throwable {
        d dVarA;
        boolean z10 = !CommonUtils.getSharedPrefs(this.f9773a).getString("existing_instance_identifier", "").equals(this.f9774b.f22039f);
        AtomicReference<TaskCompletionSource<d>> atomicReference = this.f9781i;
        AtomicReference<d> atomicReference2 = this.f9780h;
        if (!z10 && (dVarA = a(settingsCacheBehavior)) != null) {
            atomicReference2.set(dVarA);
            atomicReference.get().trySetResult(dVarA);
            return Tasks.forResult(null);
        }
        d dVarA2 = a(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
        if (dVarA2 != null) {
            atomicReference2.set(dVarA2);
            atomicReference.get().trySetResult(dVarA2);
        }
        return this.f9779g.waitForDataCollectionPermission(executor).onSuccessTask(executor, new C0099a());
    }
}
