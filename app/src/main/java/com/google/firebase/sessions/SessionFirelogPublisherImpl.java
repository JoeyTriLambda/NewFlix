package com.google.firebase.sessions;

import android.util.Log;
import com.google.firebase.sessions.settings.SessionsSettings;
import g8.f;
import i9.c;
import kg.g0;
import kg.h0;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.h;
import r9.l;
import r9.m;
import r9.n;
import r9.o;
import sf.d;
import yf.p;
import zf.i;

/* compiled from: SessionFirelogPublisher.kt */
/* loaded from: classes.dex */
public final class SessionFirelogPublisherImpl implements o {

    /* renamed from: g, reason: collision with root package name */
    public static final double f9922g;

    /* renamed from: b, reason: collision with root package name */
    public final f f9923b;

    /* renamed from: c, reason: collision with root package name */
    public final c f9924c;

    /* renamed from: d, reason: collision with root package name */
    public final SessionsSettings f9925d;

    /* renamed from: e, reason: collision with root package name */
    public final r9.f f9926e;

    /* renamed from: f, reason: collision with root package name */
    public final CoroutineContext f9927f;

    /* compiled from: SessionFirelogPublisher.kt */
    public static final class a {
        public a(zf.f fVar) {
        }
    }

    /* compiled from: SessionFirelogPublisher.kt */
    @d(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1", f = "SessionFirelogPublisher.kt", l = {63, 64, 70}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<g0, qf.c<? super h>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public InstallationId f9928b;

        /* renamed from: m, reason: collision with root package name */
        public SessionFirelogPublisherImpl f9929m;

        /* renamed from: n, reason: collision with root package name */
        public n f9930n;

        /* renamed from: o, reason: collision with root package name */
        public f f9931o;

        /* renamed from: p, reason: collision with root package name */
        public l f9932p;

        /* renamed from: q, reason: collision with root package name */
        public SessionsSettings f9933q;

        /* renamed from: r, reason: collision with root package name */
        public int f9934r;

        /* renamed from: t, reason: collision with root package name */
        public final /* synthetic */ l f9936t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(l lVar, qf.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.f9936t = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qf.c<h> create(Object obj, qf.c<?> cVar) {
            return SessionFirelogPublisherImpl.this.new AnonymousClass1(this.f9936t, cVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0082 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0083  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                r10 = this;
                java.lang.Object r0 = rf.a.getCOROUTINE_SUSPENDED()
                int r1 = r10.f9934r
                r2 = 3
                r3 = 2
                r4 = 1
                com.google.firebase.sessions.SessionFirelogPublisherImpl r5 = com.google.firebase.sessions.SessionFirelogPublisherImpl.this
                if (r1 == 0) goto L3a
                if (r1 == r4) goto L36
                if (r1 == r3) goto L32
                if (r1 != r2) goto L2a
                com.google.firebase.sessions.settings.SessionsSettings r0 = r10.f9933q
                r9.l r1 = r10.f9932p
                g8.f r2 = r10.f9931o
                r9.n r3 = r10.f9930n
                com.google.firebase.sessions.SessionFirelogPublisherImpl r5 = r10.f9929m
                com.google.firebase.sessions.InstallationId r4 = r10.f9928b
                lf.f.throwOnFailure(r11)
                r7 = r5
                r8 = r3
                r3 = r0
                r0 = r8
                r9 = r2
                r2 = r1
                r1 = r9
                goto L89
            L2a:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L32:
                lf.f.throwOnFailure(r11)
                goto L5d
            L36:
                lf.f.throwOnFailure(r11)
                goto L46
            L3a:
                lf.f.throwOnFailure(r11)
                r10.f9934r = r4
                java.lang.Object r11 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$shouldLogSession(r5, r10)
                if (r11 != r0) goto L46
                return r0
            L46:
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                boolean r11 = r11.booleanValue()
                if (r11 == 0) goto L9b
                com.google.firebase.sessions.InstallationId$Companion r11 = com.google.firebase.sessions.InstallationId.f9884c
                i9.c r1 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$getFirebaseInstallations$p(r5)
                r10.f9934r = r3
                java.lang.Object r11 = r11.create(r1, r10)
                if (r11 != r0) goto L5d
                return r0
            L5d:
                r4 = r11
                com.google.firebase.sessions.InstallationId r4 = (com.google.firebase.sessions.InstallationId) r4
                r9.n r3 = r9.n.f18878a
                g8.f r11 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$getFirebaseApp$p(r5)
                com.google.firebase.sessions.settings.SessionsSettings r1 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$getSessionSettings$p(r5)
                com.google.firebase.sessions.api.FirebaseSessionsDependencies r6 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.f9965a
                r10.f9928b = r4
                r10.f9929m = r5
                r10.f9930n = r3
                r10.f9931o = r11
                r9.l r7 = r10.f9936t
                r10.f9932p = r7
                r10.f9933q = r1
                r10.f9934r = r2
                java.lang.Object r2 = r6.getRegisteredSubscribers$com_google_firebase_firebase_sessions(r10)
                if (r2 != r0) goto L83
                return r0
            L83:
                r0 = r3
                r3 = r1
                r1 = r11
                r11 = r2
                r2 = r7
                r7 = r5
            L89:
                java.util.Map r11 = (java.util.Map) r11
                java.lang.String r5 = r4.getFid()
                java.lang.String r6 = r4.getAuthToken()
                r4 = r11
                r9.m r11 = r0.buildSession(r1, r2, r3, r4, r5, r6)
                com.google.firebase.sessions.SessionFirelogPublisherImpl.access$attemptLoggingSessionEvent(r7, r11)
            L9b:
                lf.h r11 = lf.h.f16056a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionFirelogPublisherImpl.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, qf.c<? super h> cVar) {
            return ((AnonymousClass1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    static {
        new a(null);
        f9922g = Math.random();
    }

    public SessionFirelogPublisherImpl(f fVar, c cVar, SessionsSettings sessionsSettings, r9.f fVar2, CoroutineContext coroutineContext) {
        i.checkNotNullParameter(fVar, "firebaseApp");
        i.checkNotNullParameter(cVar, "firebaseInstallations");
        i.checkNotNullParameter(sessionsSettings, "sessionSettings");
        i.checkNotNullParameter(fVar2, "eventGDTLogger");
        i.checkNotNullParameter(coroutineContext, "backgroundDispatcher");
        this.f9923b = fVar;
        this.f9924c = cVar;
        this.f9925d = sessionsSettings;
        this.f9926e = fVar2;
        this.f9927f = coroutineContext;
    }

    public static final void access$attemptLoggingSessionEvent(SessionFirelogPublisherImpl sessionFirelogPublisherImpl, m mVar) {
        sessionFirelogPublisherImpl.getClass();
        try {
            sessionFirelogPublisherImpl.f9926e.log(mVar);
            Log.d("SessionFirelogPublisher", "Successfully logged Session Start event: " + mVar.getSessionData().getSessionId());
        } catch (RuntimeException e10) {
            Log.e("SessionFirelogPublisher", "Error logging Session Start event to DataTransport: ", e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$shouldLogSession(com.google.firebase.sessions.SessionFirelogPublisherImpl r6, qf.c r7) throws java.lang.Throwable {
        /*
            r6.getClass()
            boolean r0 = r7 instanceof com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1
            if (r0 == 0) goto L16
            r0 = r7
            com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1 r0 = (com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1) r0
            int r1 = r0.f9940o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.f9940o = r1
            goto L1b
        L16:
            com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1 r0 = new com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1
            r0.<init>(r6, r7)
        L1b:
            java.lang.Object r7 = r0.f9938m
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.f9940o
            r3 = 1
            java.lang.String r4 = "SessionFirelogPublisher"
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            com.google.firebase.sessions.SessionFirelogPublisherImpl r6 = r0.f9937b
            lf.f.throwOnFailure(r7)
            goto L4d
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            lf.f.throwOnFailure(r7)
            java.lang.String r7 = "Data Collection is enabled for at least one Subscriber"
            android.util.Log.d(r4, r7)
            r0.f9937b = r6
            r0.f9940o = r3
            com.google.firebase.sessions.settings.SessionsSettings r7 = r6.f9925d
            java.lang.Object r7 = r7.updateSettings(r0)
            if (r7 != r1) goto L4d
            goto L7f
        L4d:
            com.google.firebase.sessions.settings.SessionsSettings r7 = r6.f9925d
            boolean r7 = r7.getSessionsEnabled()
            r0 = 0
            if (r7 != 0) goto L60
            java.lang.String r6 = "Sessions SDK disabled. Events will not be sent."
            android.util.Log.d(r4, r6)
            java.lang.Boolean r1 = sf.a.boxBoolean(r0)
            goto L7f
        L60:
            com.google.firebase.sessions.settings.SessionsSettings r6 = r6.f9925d
            double r6 = r6.getSamplingRate()
            double r1 = com.google.firebase.sessions.SessionFirelogPublisherImpl.f9922g
            int r5 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r5 > 0) goto L6e
            r6 = 1
            goto L6f
        L6e:
            r6 = 0
        L6f:
            if (r6 != 0) goto L7b
            java.lang.String r6 = "Sessions SDK has dropped this session due to sampling."
            android.util.Log.d(r4, r6)
            java.lang.Boolean r1 = sf.a.boxBoolean(r0)
            goto L7f
        L7b:
            java.lang.Boolean r1 = sf.a.boxBoolean(r3)
        L7f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionFirelogPublisherImpl.access$shouldLogSession(com.google.firebase.sessions.SessionFirelogPublisherImpl, qf.c):java.lang.Object");
    }

    @Override // r9.o
    public void logSession(l lVar) {
        i.checkNotNullParameter(lVar, "sessionDetails");
        kg.h.launch$default(h0.CoroutineScope(this.f9927f), null, null, new AnonymousClass1(lVar, null), 3, null);
    }
}
