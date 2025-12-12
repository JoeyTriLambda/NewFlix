package com.google.firebase.sessions;

import android.content.Context;
import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.PreferencesKt;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import i1.d;
import java.util.concurrent.atomic.AtomicReference;
import kg.g0;
import kg.h0;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.PropertyReference2Impl;
import l1.a;
import l1.b;
import lf.f;
import lf.h;
import org.apache.commons.lang3.ClassUtils;
import qf.c;
import r9.g;
import r9.j;
import r9.k;
import yf.l;
import yf.p;
import zf.i;

/* compiled from: SessionDatastore.kt */
/* loaded from: classes.dex */
public final class SessionDatastoreImpl implements k {

    /* renamed from: f, reason: collision with root package name */
    public static final a f9894f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    @Deprecated
    public static final cg.a<Context, d<l1.a>> f9895g = PreferenceDataStoreDelegateKt.preferencesDataStore$default(j.f18866a.getSESSIONS_CONFIG_NAME(), new j1.b(new l<CorruptionException, l1.a>() { // from class: com.google.firebase.sessions.SessionDatastoreImpl$Companion$dataStore$2
        @Override // yf.l
        public final l1.a invoke(CorruptionException corruptionException) {
            i.checkNotNullParameter(corruptionException, "ex");
            Log.w("FirebaseSessionsRepo", "CorruptionException in sessions DataStore in " + r9.i.f18865a.getProcessName$com_google_firebase_firebase_sessions() + ClassUtils.PACKAGE_SEPARATOR_CHAR, corruptionException);
            return b.createEmpty();
        }
    }), null, null, 12, null);

    /* renamed from: b, reason: collision with root package name */
    public final Context f9896b;

    /* renamed from: c, reason: collision with root package name */
    public final CoroutineContext f9897c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference<g> f9898d;

    /* renamed from: e, reason: collision with root package name */
    public final SessionDatastoreImpl$special$$inlined$map$1 f9899e;

    /* compiled from: SessionDatastore.kt */
    @sf.d(c = "com.google.firebase.sessions.SessionDatastoreImpl$1", f = "SessionDatastore.kt", l = {81}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<g0, c<? super h>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public int f9907b;

        /* compiled from: SessionDatastore.kt */
        /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$1$a */
        public static final class a<T> implements ng.b {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SessionDatastoreImpl f9909b;

            public a(SessionDatastoreImpl sessionDatastoreImpl) {
                this.f9909b = sessionDatastoreImpl;
            }

            @Override // ng.b
            public /* bridge */ /* synthetic */ Object emit(Object obj, c cVar) {
                return emit((g) obj, (c<? super h>) cVar);
            }

            public final Object emit(g gVar, c<? super h> cVar) {
                this.f9909b.f9898d.set(gVar);
                return h.f16056a;
            }
        }

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return SessionDatastoreImpl.this.new AnonymousClass1(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
            int i10 = this.f9907b;
            if (i10 == 0) {
                f.throwOnFailure(obj);
                SessionDatastoreImpl sessionDatastoreImpl = SessionDatastoreImpl.this;
                ng.a aVar = sessionDatastoreImpl.f9899e;
                a aVar2 = new a(sessionDatastoreImpl);
                this.f9907b = 1;
                if (aVar.collect(aVar2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.throwOnFailure(obj);
            }
            return h.f16056a;
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super h> cVar) {
            return ((AnonymousClass1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    /* compiled from: SessionDatastore.kt */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ gg.g<Object>[] f9911a = {zf.k.property2(new PropertyReference2Impl(a.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

        public a() {
        }

        public /* synthetic */ a(zf.f fVar) {
            this();
        }

        public static final d access$getDataStore(a aVar, Context context) {
            aVar.getClass();
            return (d) SessionDatastoreImpl.f9895g.getValue(context, f9911a[0]);
        }
    }

    /* compiled from: SessionDatastore.kt */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f9912a = new b();

        /* renamed from: b, reason: collision with root package name */
        public static final a.C0186a<String> f9913b = l1.c.stringKey("session_id");

        public final a.C0186a<String> getSESSION_ID() {
            return f9913b;
        }
    }

    /* compiled from: SessionDatastore.kt */
    @sf.d(c = "com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1", f = "SessionDatastore.kt", l = {87}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03431 extends SuspendLambda implements p<g0, c<? super h>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public int f9917b;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f9919n;

        /* compiled from: SessionDatastore.kt */
        @sf.d(c = "com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1$1", f = "SessionDatastore.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01031 extends SuspendLambda implements p<MutablePreferences, c<? super h>, Object> {

            /* renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f9920b;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ String f9921m;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01031(String str, c<? super C01031> cVar) {
                super(2, cVar);
                this.f9921m = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final c<h> create(Object obj, c<?> cVar) {
                C01031 c01031 = new C01031(this.f9921m, cVar);
                c01031.f9920b = obj;
                return c01031;
            }

            @Override // yf.p
            public final Object invoke(MutablePreferences mutablePreferences, c<? super h> cVar) {
                return ((C01031) create(mutablePreferences, cVar)).invokeSuspend(h.f16056a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                rf.a.getCOROUTINE_SUSPENDED();
                f.throwOnFailure(obj);
                ((MutablePreferences) this.f9920b).set(b.f9912a.getSESSION_ID(), this.f9921m);
                return h.f16056a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03431(String str, c<? super C03431> cVar) {
            super(2, cVar);
            this.f9919n = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return SessionDatastoreImpl.this.new C03431(this.f9919n, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
            int i10 = this.f9917b;
            if (i10 == 0) {
                f.throwOnFailure(obj);
                d dVarAccess$getDataStore = a.access$getDataStore(SessionDatastoreImpl.f9894f, SessionDatastoreImpl.this.f9896b);
                C01031 c01031 = new C01031(this.f9919n, null);
                this.f9917b = 1;
                if (PreferencesKt.edit(dVarAccess$getDataStore, c01031, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.throwOnFailure(obj);
            }
            return h.f16056a;
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super h> cVar) {
            return ((C03431) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1] */
    public SessionDatastoreImpl(Context context, CoroutineContext coroutineContext) {
        i.checkNotNullParameter(context, "context");
        i.checkNotNullParameter(coroutineContext, "backgroundDispatcher");
        this.f9896b = context;
        this.f9897c = coroutineContext;
        this.f9898d = new AtomicReference<>();
        final ng.a aVarM88catch = ng.c.m88catch(a.access$getDataStore(f9894f, context).getData(), new SessionDatastoreImpl$firebaseSessionDataFlow$1(null));
        this.f9899e = new ng.a<g>() { // from class: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements ng.b {

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ ng.b f9902b;

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ SessionDatastoreImpl f9903m;

                /* compiled from: Emitters.kt */
                @sf.d(c = "com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2", f = "SessionDatastore.kt", l = {224}, m = "emit")
                /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: b, reason: collision with root package name */
                    public /* synthetic */ Object f9904b;

                    /* renamed from: m, reason: collision with root package name */
                    public int f9905m;

                    public AnonymousClass1(c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f9904b = obj;
                        this.f9905m |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(ng.b bVar, SessionDatastoreImpl sessionDatastoreImpl) {
                    this.f9902b = bVar;
                    this.f9903m = sessionDatastoreImpl;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ng.b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, qf.c r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1 r0 = (com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f9905m
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f9905m = r1
                        goto L18
                    L13:
                        com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1 r0 = new com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f9904b
                        java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
                        int r2 = r0.f9905m
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        lf.f.throwOnFailure(r6)
                        goto L47
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        lf.f.throwOnFailure(r6)
                        l1.a r5 = (l1.a) r5
                        com.google.firebase.sessions.SessionDatastoreImpl r6 = r4.f9903m
                        r9.g r5 = com.google.firebase.sessions.SessionDatastoreImpl.access$mapSessionsData(r6, r5)
                        r0.f9905m = r3
                        ng.b r6 = r4.f9902b
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L47
                        return r1
                    L47:
                        lf.h r5 = lf.h.f16056a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, qf.c):java.lang.Object");
                }
            }

            @Override // ng.a
            public Object collect(ng.b<? super g> bVar, c cVar) {
                Object objCollect = aVarM88catch.collect(new AnonymousClass2(bVar, this), cVar);
                return objCollect == rf.a.getCOROUTINE_SUSPENDED() ? objCollect : h.f16056a;
            }
        };
        kg.h.launch$default(h0.CoroutineScope(coroutineContext), null, null, new AnonymousClass1(null), 3, null);
    }

    public static final g access$mapSessionsData(SessionDatastoreImpl sessionDatastoreImpl, l1.a aVar) {
        sessionDatastoreImpl.getClass();
        return new g((String) aVar.get(b.f9912a.getSESSION_ID()));
    }

    @Override // r9.k
    public String getCurrentSessionId() {
        g gVar = this.f9898d.get();
        if (gVar != null) {
            return gVar.getSessionId();
        }
        return null;
    }

    @Override // r9.k
    public void updateSessionId(String str) {
        i.checkNotNullParameter(str, JsonStorageKeyNames.SESSION_ID_KEY);
        kg.h.launch$default(h0.CoroutineScope(this.f9897c), null, null, new C03431(str, null), 3, null);
    }
}
