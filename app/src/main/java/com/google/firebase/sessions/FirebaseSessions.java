package com.google.firebase.sessions;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.firebase.sessions.settings.SessionsSettings;
import g8.f;
import kg.g0;
import kg.h0;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.h;
import org.apache.commons.lang3.ClassUtils;
import qf.c;
import r9.s;
import sf.d;
import yf.p;
import zf.i;

/* compiled from: FirebaseSessions.kt */
/* loaded from: classes.dex */
public final class FirebaseSessions {

    /* renamed from: a, reason: collision with root package name */
    public final f f9879a;

    /* renamed from: b, reason: collision with root package name */
    public final SessionsSettings f9880b;

    /* compiled from: FirebaseSessions.kt */
    @d(c = "com.google.firebase.sessions.FirebaseSessions$1", f = "FirebaseSessions.kt", l = {44, 48}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.FirebaseSessions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<g0, c<? super h>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public int f9881b;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ CoroutineContext f9883n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CoroutineContext coroutineContext, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.f9883n = coroutineContext;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return FirebaseSessions.this.new AnonymousClass1(this.f9883n, cVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = rf.a.getCOROUTINE_SUSPENDED()
                int r1 = r6.f9881b
                java.lang.String r2 = "FirebaseSessions"
                r3 = 2
                com.google.firebase.sessions.FirebaseSessions r4 = com.google.firebase.sessions.FirebaseSessions.this
                r5 = 1
                if (r1 == 0) goto L22
                if (r1 == r5) goto L1e
                if (r1 != r3) goto L16
                lf.f.throwOnFailure(r7)
                goto L72
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1e:
                lf.f.throwOnFailure(r7)
                goto L30
            L22:
                lf.f.throwOnFailure(r7)
                com.google.firebase.sessions.api.FirebaseSessionsDependencies r7 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.f9965a
                r6.f9881b = r5
                java.lang.Object r7 = r7.getRegisteredSubscribers$com_google_firebase_firebase_sessions(r6)
                if (r7 != r0) goto L30
                return r0
            L30:
                java.util.Map r7 = (java.util.Map) r7
                java.util.Collection r7 = r7.values()
                java.lang.Iterable r7 = (java.lang.Iterable) r7
                boolean r1 = r7 instanceof java.util.Collection
                if (r1 == 0) goto L46
                r1 = r7
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L46
                goto L5d
            L46:
                java.util.Iterator r7 = r7.iterator()
            L4a:
                boolean r1 = r7.hasNext()
                if (r1 == 0) goto L5d
                java.lang.Object r1 = r7.next()
                com.google.firebase.sessions.api.SessionSubscriber r1 = (com.google.firebase.sessions.api.SessionSubscriber) r1
                boolean r1 = r1.isDataCollectionEnabled()
                if (r1 == 0) goto L4a
                r5 = 0
            L5d:
                if (r5 == 0) goto L65
                java.lang.String r7 = "No Sessions subscribers. Not listening to lifecycle events."
                android.util.Log.d(r2, r7)
                goto L9f
            L65:
                com.google.firebase.sessions.settings.SessionsSettings r7 = com.google.firebase.sessions.FirebaseSessions.access$getSettings$p(r4)
                r6.f9881b = r3
                java.lang.Object r7 = r7.updateSettings(r6)
                if (r7 != r0) goto L72
                return r0
            L72:
                com.google.firebase.sessions.settings.SessionsSettings r7 = com.google.firebase.sessions.FirebaseSessions.access$getSettings$p(r4)
                boolean r7 = r7.getSessionsEnabled()
                if (r7 != 0) goto L82
                java.lang.String r7 = "Sessions SDK disabled. Not listening to lifecycle events."
                android.util.Log.d(r2, r7)
                goto L9f
            L82:
                com.google.firebase.sessions.a r7 = new com.google.firebase.sessions.a
                kotlin.coroutines.CoroutineContext r0 = r6.f9883n
                r7.<init>(r0)
                r7.bindToService()
                r9.s r0 = r9.s.f18892b
                r0.setLifecycleClient(r7)
                g8.f r7 = com.google.firebase.sessions.FirebaseSessions.access$getFirebaseApp$p(r4)
                u8.a r0 = new u8.a
                r1 = 8
                r0.<init>(r1)
                r7.addLifecycleEventListener(r0)
            L9f:
                lf.h r7 = lf.h.f16056a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.FirebaseSessions.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super h> cVar) {
            return ((AnonymousClass1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    /* compiled from: FirebaseSessions.kt */
    public static final class a {
        public a(zf.f fVar) {
        }
    }

    static {
        new a(null);
    }

    public FirebaseSessions(f fVar, SessionsSettings sessionsSettings, CoroutineContext coroutineContext) {
        i.checkNotNullParameter(fVar, "firebaseApp");
        i.checkNotNullParameter(sessionsSettings, "settings");
        i.checkNotNullParameter(coroutineContext, "backgroundDispatcher");
        this.f9879a = fVar;
        this.f9880b = sessionsSettings;
        Log.d("FirebaseSessions", "Initializing Firebase Sessions SDK.");
        Context applicationContext = fVar.getApplicationContext().getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(s.f18892b);
            kg.h.launch$default(h0.CoroutineScope(coroutineContext), null, null, new AnonymousClass1(coroutineContext, null), 3, null);
        } else {
            Log.e("FirebaseSessions", "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
    }
}
