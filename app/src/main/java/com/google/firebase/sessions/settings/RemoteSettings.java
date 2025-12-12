package com.google.firebase.sessions.settings;

import i9.c;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.time.DurationUnit;
import r9.b;
import s9.d;
import zf.f;
import zf.i;

/* compiled from: RemoteSettings.kt */
/* loaded from: classes.dex */
public final class RemoteSettings implements d {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f9982a;

    /* renamed from: b, reason: collision with root package name */
    public final c f9983b;

    /* renamed from: c, reason: collision with root package name */
    public final b f9984c;

    /* renamed from: d, reason: collision with root package name */
    public final s9.a f9985d;

    /* renamed from: e, reason: collision with root package name */
    public final SettingsCache f9986e;

    /* renamed from: f, reason: collision with root package name */
    public final tg.a f9987f;

    /* compiled from: RemoteSettings.kt */
    public static final class a {
        public a(f fVar) {
        }
    }

    /* compiled from: RemoteSettings.kt */
    @sf.d(c = "com.google.firebase.sessions.settings.RemoteSettings", f = "RemoteSettings.kt", l = {170, 76, 94}, m = "updateSettings")
    /* renamed from: com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: b, reason: collision with root package name */
        public Object f9988b;

        /* renamed from: m, reason: collision with root package name */
        public tg.a f9989m;

        /* renamed from: n, reason: collision with root package name */
        public /* synthetic */ Object f9990n;

        /* renamed from: p, reason: collision with root package name */
        public int f9992p;

        public AnonymousClass1(qf.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f9990n = obj;
            this.f9992p |= Integer.MIN_VALUE;
            return RemoteSettings.this.updateSettings(this);
        }
    }

    static {
        new a(null);
    }

    public RemoteSettings(CoroutineContext coroutineContext, c cVar, b bVar, s9.a aVar, i1.d<l1.a> dVar) {
        i.checkNotNullParameter(coroutineContext, "backgroundDispatcher");
        i.checkNotNullParameter(cVar, "firebaseInstallationsApi");
        i.checkNotNullParameter(bVar, "appInfo");
        i.checkNotNullParameter(aVar, "configsFetcher");
        i.checkNotNullParameter(dVar, "dataStore");
        this.f9982a = coroutineContext;
        this.f9983b = cVar;
        this.f9984c = bVar;
        this.f9985d = aVar;
        this.f9986e = new SettingsCache(dVar);
        this.f9987f = tg.b.Mutex$default(false, 1, null);
    }

    @Override // s9.d
    public Double getSamplingRate() {
        return this.f9986e.sessionSamplingRate();
    }

    @Override // s9.d
    public Boolean getSessionEnabled() {
        return this.f9986e.sessionsEnabled();
    }

    @Override // s9.d
    /* renamed from: getSessionRestartTimeout-FghU774, reason: not valid java name */
    public jg.a mo20getSessionRestartTimeoutFghU774() {
        Integer numSessionRestartTimeout = this.f9986e.sessionRestartTimeout();
        if (numSessionRestartTimeout == null) {
            return null;
        }
        int i10 = jg.a.f14696o;
        return jg.a.m33boximpl(jg.c.toDuration(numSessionRestartTimeout.intValue(), DurationUnit.SECONDS));
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b3 A[Catch: all -> 0x0163, TRY_LEAVE, TryCatch #0 {all -> 0x0163, blocks: (B:21:0x0050, B:42:0x00a7, B:44:0x00b3, B:48:0x00bf, B:34:0x0083, B:36:0x008b, B:39:0x0096), top: B:59:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Type inference failed for: r6v0, types: [int] */
    @Override // s9.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object updateSettings(qf.c<? super lf.h> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings.updateSettings(qf.c):java.lang.Object");
    }
}
