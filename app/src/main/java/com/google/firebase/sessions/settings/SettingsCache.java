package com.google.firebase.sessions.settings;

import i1.d;
import kg.g;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import l1.a;
import lf.f;
import lf.h;
import s9.c;
import yf.p;
import zf.i;

/* compiled from: SettingsCache.kt */
/* loaded from: classes.dex */
public final class SettingsCache {

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final a.C0186a<Boolean> f10017c;

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final a.C0186a<Double> f10018d;

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final a.C0186a<Integer> f10019e;

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    public static final a.C0186a<Integer> f10020f;

    /* renamed from: g, reason: collision with root package name */
    @Deprecated
    public static final a.C0186a<Long> f10021g;

    /* renamed from: a, reason: collision with root package name */
    public final d<l1.a> f10022a;

    /* renamed from: b, reason: collision with root package name */
    public c f10023b;

    /* compiled from: SettingsCache.kt */
    @sf.d(c = "com.google.firebase.sessions.settings.SettingsCache$1", f = "SettingsCache.kt", l = {46}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.settings.SettingsCache$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<g0, qf.c<? super h>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public SettingsCache f10024b;

        /* renamed from: m, reason: collision with root package name */
        public int f10025m;

        public AnonymousClass1(qf.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qf.c<h> create(Object obj, qf.c<?> cVar) {
            return SettingsCache.this.new AnonymousClass1(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            SettingsCache settingsCache;
            Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
            int i10 = this.f10025m;
            if (i10 == 0) {
                f.throwOnFailure(obj);
                SettingsCache settingsCache2 = SettingsCache.this;
                ng.a data = settingsCache2.f10022a.getData();
                this.f10024b = settingsCache2;
                this.f10025m = 1;
                Object objFirst = ng.c.first(data, this);
                if (objFirst == coroutine_suspended) {
                    return coroutine_suspended;
                }
                settingsCache = settingsCache2;
                obj = objFirst;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                settingsCache = this.f10024b;
                f.throwOnFailure(obj);
            }
            SettingsCache.access$updateSessionConfigs(settingsCache, ((l1.a) obj).toPreferences());
            return h.f16056a;
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, qf.c<? super h> cVar) {
            return ((AnonymousClass1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    /* compiled from: SettingsCache.kt */
    public static final class a {
        public a(zf.f fVar) {
        }
    }

    static {
        new a(null);
        f10017c = l1.c.booleanKey("firebase_sessions_enabled");
        f10018d = l1.c.doubleKey("firebase_sessions_sampling_rate");
        f10019e = l1.c.intKey("firebase_sessions_restart_timeout");
        f10020f = l1.c.intKey("firebase_sessions_cache_duration");
        f10021g = l1.c.longKey("firebase_sessions_cache_updated_time");
    }

    public SettingsCache(d<l1.a> dVar) throws InterruptedException {
        i.checkNotNullParameter(dVar, "dataStore");
        this.f10022a = dVar;
        g.runBlocking$default(null, new AnonymousClass1(null), 1, null);
    }

    public static final void access$updateSessionConfigs(SettingsCache settingsCache, l1.a aVar) {
        settingsCache.getClass();
        settingsCache.f10023b = new c((Boolean) aVar.get(f10017c), (Double) aVar.get(f10018d), (Integer) aVar.get(f10019e), (Integer) aVar.get(f10020f), (Long) aVar.get(f10021g));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> java.lang.Object a(l1.a.C0186a<T> r6, T r7, qf.c<? super lf.h> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1
            if (r0 == 0) goto L13
            r0 = r8
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = (com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1) r0
            int r1 = r0.f10029n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10029n = r1
            goto L18
        L13:
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f10027b
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.f10029n
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            lf.f.throwOnFailure(r8)     // Catch: java.io.IOException -> L29
            goto L5a
        L29:
            r6 = move-exception
            goto L47
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            lf.f.throwOnFailure(r8)
            i1.d<l1.a> r8 = r5.f10022a     // Catch: java.io.IOException -> L29
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2 r2 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2     // Catch: java.io.IOException -> L29
            r4 = 0
            r2.<init>(r5, r6, r7, r4)     // Catch: java.io.IOException -> L29
            r0.f10029n = r3     // Catch: java.io.IOException -> L29
            java.lang.Object r6 = androidx.datastore.preferences.core.PreferencesKt.edit(r8, r2, r0)     // Catch: java.io.IOException -> L29
            if (r6 != r1) goto L5a
            return r1
        L47:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Failed to update cache config value: "
            r7.<init>(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "SettingsCache"
            android.util.Log.w(r7, r6)
        L5a:
            lf.h r6 = lf.h.f16056a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SettingsCache.a(l1.a$a, java.lang.Object, qf.c):java.lang.Object");
    }

    public final boolean hasCacheExpired$com_google_firebase_firebase_sessions() {
        c cVar = this.f10023b;
        c cVar2 = null;
        if (cVar == null) {
            i.throwUninitializedPropertyAccessException("sessionConfigs");
            cVar = null;
        }
        Long cacheUpdatedTime = cVar.getCacheUpdatedTime();
        c cVar3 = this.f10023b;
        if (cVar3 == null) {
            i.throwUninitializedPropertyAccessException("sessionConfigs");
        } else {
            cVar2 = cVar3;
        }
        Integer cacheDuration = cVar2.getCacheDuration();
        return cacheUpdatedTime == null || cacheDuration == null || (System.currentTimeMillis() - cacheUpdatedTime.longValue()) / ((long) 1000) >= ((long) cacheDuration.intValue());
    }

    public final Integer sessionRestartTimeout() {
        c cVar = this.f10023b;
        if (cVar == null) {
            i.throwUninitializedPropertyAccessException("sessionConfigs");
            cVar = null;
        }
        return cVar.getSessionRestartTimeout();
    }

    public final Double sessionSamplingRate() {
        c cVar = this.f10023b;
        if (cVar == null) {
            i.throwUninitializedPropertyAccessException("sessionConfigs");
            cVar = null;
        }
        return cVar.getSessionSamplingRate();
    }

    public final Boolean sessionsEnabled() {
        c cVar = this.f10023b;
        if (cVar == null) {
            i.throwUninitializedPropertyAccessException("sessionConfigs");
            cVar = null;
        }
        return cVar.getSessionEnabled();
    }

    public final Object updateSamplingRate(Double d10, qf.c<? super h> cVar) throws Throwable {
        Object objA = a(f10018d, d10, cVar);
        return objA == rf.a.getCOROUTINE_SUSPENDED() ? objA : h.f16056a;
    }

    public final Object updateSessionCacheDuration(Integer num, qf.c<? super h> cVar) throws Throwable {
        Object objA = a(f10020f, num, cVar);
        return objA == rf.a.getCOROUTINE_SUSPENDED() ? objA : h.f16056a;
    }

    public final Object updateSessionCacheUpdatedTime(Long l10, qf.c<? super h> cVar) throws Throwable {
        Object objA = a(f10021g, l10, cVar);
        return objA == rf.a.getCOROUTINE_SUSPENDED() ? objA : h.f16056a;
    }

    public final Object updateSessionRestartTimeout(Integer num, qf.c<? super h> cVar) throws Throwable {
        Object objA = a(f10019e, num, cVar);
        return objA == rf.a.getCOROUTINE_SUSPENDED() ? objA : h.f16056a;
    }

    public final Object updateSettingsEnabled(Boolean bool, qf.c<? super h> cVar) throws Throwable {
        Object objA = a(f10017c, bool, cVar);
        return objA == rf.a.getCOROUTINE_SUSPENDED() ? objA : h.f16056a;
    }
}
