package com.google.firebase.sessions;

import android.os.Message;
import java.util.Comparator;
import java.util.List;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.h;
import qf.c;
import sf.d;
import yf.p;

/* compiled from: SessionLifecycleClient.kt */
@d(c = "com.google.firebase.sessions.SessionLifecycleClient$sendLifecycleEvents$1", f = "SessionLifecycleClient.kt", l = {151}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class SessionLifecycleClient$sendLifecycleEvents$1 extends SuspendLambda implements p<g0, c<? super h>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public int f9950b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ com.google.firebase.sessions.a f9951m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ List<Message> f9952n;

    /* compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return of.a.compareValues(Long.valueOf(((Message) t10).getWhen()), Long.valueOf(((Message) t11).getWhen()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionLifecycleClient$sendLifecycleEvents$1(com.google.firebase.sessions.a aVar, List<Message> list, c<? super SessionLifecycleClient$sendLifecycleEvents$1> cVar) {
        super(2, cVar);
        this.f9951m = aVar;
        this.f9952n = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        return new SessionLifecycleClient$sendLifecycleEvents$1(this.f9951m, this.f9952n, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = rf.a.getCOROUTINE_SUSPENDED()
            int r1 = r5.f9950b
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            lf.f.throwOnFailure(r6)
            goto L25
        Lf:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L17:
            lf.f.throwOnFailure(r6)
            com.google.firebase.sessions.api.FirebaseSessionsDependencies r6 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.f9965a
            r5.f9950b = r2
            java.lang.Object r6 = r6.getRegisteredSubscribers$com_google_firebase_firebase_sessions(r5)
            if (r6 != r0) goto L25
            return r0
        L25:
            java.util.Map r6 = (java.util.Map) r6
            boolean r0 = r6.isEmpty()
            java.lang.String r1 = "SessionLifecycleClient"
            if (r0 == 0) goto L36
            java.lang.String r6 = "Sessions SDK did not have any dependent SDKs register as dependencies. Events will not be sent."
            android.util.Log.d(r1, r6)
            goto La9
        L36:
            java.util.Collection r6 = r6.values()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            boolean r0 = r6 instanceof java.util.Collection
            r3 = 0
            if (r0 == 0) goto L4c
            r0 = r6
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L4c
        L4a:
            r6 = 1
            goto L63
        L4c:
            java.util.Iterator r6 = r6.iterator()
        L50:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L4a
            java.lang.Object r0 = r6.next()
            com.google.firebase.sessions.api.SessionSubscriber r0 = (com.google.firebase.sessions.api.SessionSubscriber) r0
            boolean r0 = r0.isDataCollectionEnabled()
            if (r0 == 0) goto L50
            r6 = 0
        L63:
            if (r6 == 0) goto L6b
            java.lang.String r6 = "Data Collection is disabled for all subscribers. Skipping this Event"
            android.util.Log.d(r1, r6)
            goto La9
        L6b:
            r6 = 2
            android.os.Message[] r0 = new android.os.Message[r6]
            com.google.firebase.sessions.a r1 = r5.f9951m
            java.util.List<android.os.Message> r4 = r5.f9952n
            android.os.Message r6 = com.google.firebase.sessions.a.access$getLatestByCode(r1, r4, r6)
            r0[r3] = r6
            android.os.Message r6 = com.google.firebase.sessions.a.access$getLatestByCode(r1, r4, r2)
            r0[r2] = r6
            java.util.List r6 = mf.k.mutableListOf(r0)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.List r6 = mf.q.filterNotNull(r6)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            com.google.firebase.sessions.SessionLifecycleClient$sendLifecycleEvents$1$a r0 = new com.google.firebase.sessions.SessionLifecycleClient$sendLifecycleEvents$1$a
            r0.<init>()
            java.util.List r6 = mf.q.sortedWith(r6, r0)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L99:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto La9
            java.lang.Object r0 = r6.next()
            android.os.Message r0 = (android.os.Message) r0
            com.google.firebase.sessions.a.access$sendMessageToServer(r1, r0)
            goto L99
        La9:
            lf.h r6 = lf.h.f16056a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionLifecycleClient$sendLifecycleEvents$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // yf.p
    public final Object invoke(g0 g0Var, c<? super h> cVar) {
        return ((SessionLifecycleClient$sendLifecycleEvents$1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
    }
}
