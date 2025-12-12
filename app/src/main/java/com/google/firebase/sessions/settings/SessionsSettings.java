package com.google.firebase.sessions.settings;

import android.content.Context;
import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import g8.c;
import g8.h;
import gg.g;
import i1.d;
import j1.b;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.time.DurationUnit;
import l1.a;
import org.apache.commons.lang3.ClassUtils;
import r9.j;
import r9.n;
import yf.l;
import zf.f;
import zf.i;
import zf.k;

/* compiled from: SessionsSettings.kt */
/* loaded from: classes.dex */
public final class SessionsSettings {

    /* renamed from: c, reason: collision with root package name */
    public static final a f10007c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final cg.a<Context, d<l1.a>> f10008d = PreferenceDataStoreDelegateKt.preferencesDataStore$default(j.f18866a.getSETTINGS_CONFIG_NAME(), new b(new l<CorruptionException, l1.a>() { // from class: com.google.firebase.sessions.settings.SessionsSettings$Companion$dataStore$2
        @Override // yf.l
        public final a invoke(CorruptionException corruptionException) {
            i.checkNotNullParameter(corruptionException, "ex");
            Log.w("SessionsSettings", "CorruptionException in settings DataStore in " + r9.i.f18865a.getProcessName$com_google_firebase_firebase_sessions() + ClassUtils.PACKAGE_SEPARATOR_CHAR, corruptionException);
            return l1.b.createEmpty();
        }
    }), null, null, 12, null);

    /* renamed from: a, reason: collision with root package name */
    public final s9.d f10009a;

    /* renamed from: b, reason: collision with root package name */
    public final s9.d f10010b;

    /* compiled from: SessionsSettings.kt */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ g<Object>[] f10012a = {k.property2(new PropertyReference2Impl(a.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public static final d access$getDataStore(a aVar, Context context) {
            aVar.getClass();
            return (d) SessionsSettings.f10008d.getValue(context, f10012a[0]);
        }

        public final SessionsSettings getInstance() {
            Object obj = h.getApp(c.f12778a).get(SessionsSettings.class);
            i.checkNotNullExpressionValue(obj, "Firebase.app[SessionsSettings::class.java]");
            return (SessionsSettings) obj;
        }
    }

    /* compiled from: SessionsSettings.kt */
    @sf.d(c = "com.google.firebase.sessions.settings.SessionsSettings", f = "SessionsSettings.kt", l = {138, 139}, m = "updateSettings")
    /* renamed from: com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: b, reason: collision with root package name */
        public SessionsSettings f10013b;

        /* renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f10014m;

        /* renamed from: o, reason: collision with root package name */
        public int f10016o;

        public AnonymousClass1(qf.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f10014m = obj;
            this.f10016o |= Integer.MIN_VALUE;
            return SessionsSettings.this.updateSettings(this);
        }
    }

    public SessionsSettings(s9.d dVar, s9.d dVar2) {
        i.checkNotNullParameter(dVar, "localOverrideSettings");
        i.checkNotNullParameter(dVar2, "remoteSettings");
        this.f10009a = dVar;
        this.f10010b = dVar2;
    }

    public final double getSamplingRate() {
        Double samplingRate = this.f10009a.getSamplingRate();
        if (samplingRate != null) {
            double dDoubleValue = samplingRate.doubleValue();
            if (0.0d <= dDoubleValue && dDoubleValue <= 1.0d) {
                return dDoubleValue;
            }
        }
        Double samplingRate2 = this.f10010b.getSamplingRate();
        if (samplingRate2 != null) {
            double dDoubleValue2 = samplingRate2.doubleValue();
            if (0.0d <= dDoubleValue2 && dDoubleValue2 <= 1.0d) {
                return dDoubleValue2;
            }
        }
        return 1.0d;
    }

    /* renamed from: getSessionRestartTimeout-UwyO8pc, reason: not valid java name */
    public final long m21getSessionRestartTimeoutUwyO8pc() {
        jg.a aVarMo20getSessionRestartTimeoutFghU774 = this.f10009a.mo20getSessionRestartTimeoutFghU774();
        if (aVarMo20getSessionRestartTimeoutFghU774 != null) {
            long jM56unboximpl = aVarMo20getSessionRestartTimeoutFghU774.m56unboximpl();
            if (jg.a.m51isPositiveimpl(jM56unboximpl) && jg.a.m48isFiniteimpl(jM56unboximpl)) {
                return jM56unboximpl;
            }
        }
        jg.a aVarMo20getSessionRestartTimeoutFghU7742 = this.f10010b.mo20getSessionRestartTimeoutFghU774();
        if (aVarMo20getSessionRestartTimeoutFghU7742 != null) {
            long jM56unboximpl2 = aVarMo20getSessionRestartTimeoutFghU7742.m56unboximpl();
            if (jg.a.m51isPositiveimpl(jM56unboximpl2) && jg.a.m48isFiniteimpl(jM56unboximpl2)) {
                return jM56unboximpl2;
            }
        }
        int i10 = jg.a.f14696o;
        return jg.c.toDuration(30, DurationUnit.MINUTES);
    }

    public final boolean getSessionsEnabled() {
        Boolean sessionEnabled = this.f10009a.getSessionEnabled();
        if (sessionEnabled != null) {
            return sessionEnabled.booleanValue();
        }
        Boolean sessionEnabled2 = this.f10010b.getSessionEnabled();
        if (sessionEnabled2 != null) {
            return sessionEnabled2.booleanValue();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateSettings(qf.c<? super lf.h> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.google.firebase.sessions.settings.SessionsSettings.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1 r0 = (com.google.firebase.sessions.settings.SessionsSettings.AnonymousClass1) r0
            int r1 = r0.f10016o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10016o = r1
            goto L18
        L13:
            com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1 r0 = new com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f10014m
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.f10016o
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            lf.f.throwOnFailure(r6)
            goto L59
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            com.google.firebase.sessions.settings.SessionsSettings r2 = r0.f10013b
            lf.f.throwOnFailure(r6)
            goto L4b
        L3a:
            lf.f.throwOnFailure(r6)
            r0.f10013b = r5
            r0.f10016o = r4
            s9.d r6 = r5.f10009a
            java.lang.Object r6 = r6.updateSettings(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            r2 = r5
        L4b:
            s9.d r6 = r2.f10010b
            r2 = 0
            r0.f10013b = r2
            r0.f10016o = r3
            java.lang.Object r6 = r6.updateSettings(r0)
            if (r6 != r1) goto L59
            return r1
        L59:
            lf.h r6 = lf.h.f16056a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SessionsSettings.updateSettings(qf.c):java.lang.Object");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SessionsSettings(g8.f fVar, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, i9.c cVar) {
        i.checkNotNullParameter(fVar, "firebaseApp");
        i.checkNotNullParameter(coroutineContext, "blockingDispatcher");
        i.checkNotNullParameter(coroutineContext2, "backgroundDispatcher");
        i.checkNotNullParameter(cVar, "firebaseInstallationsApi");
        Context applicationContext = fVar.getApplicationContext();
        i.checkNotNullExpressionValue(applicationContext, "firebaseApp.applicationContext");
        r9.b applicationInfo = n.f18878a.getApplicationInfo(fVar);
        this(new s9.b(applicationContext), new RemoteSettings(coroutineContext2, cVar, applicationInfo, new RemoteSettingsFetcher(applicationInfo, coroutineContext, null, 4, null), a.access$getDataStore(f10007c, applicationContext)));
    }
}
