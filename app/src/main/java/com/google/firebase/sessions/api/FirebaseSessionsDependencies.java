package com.google.firebase.sessions.api;

import android.util.Log;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import tg.a;
import tg.b;
import zf.f;
import zf.i;

/* compiled from: FirebaseSessionsDependencies.kt */
/* loaded from: classes.dex */
public final class FirebaseSessionsDependencies {

    /* renamed from: a, reason: collision with root package name */
    public static final FirebaseSessionsDependencies f9965a = new FirebaseSessionsDependencies();

    /* renamed from: b, reason: collision with root package name */
    public static final Map<SessionSubscriber.Name, a> f9966b = Collections.synchronizedMap(new LinkedHashMap());

    /* compiled from: FirebaseSessionsDependencies.kt */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final tg.a f9967a;

        /* renamed from: b, reason: collision with root package name */
        public SessionSubscriber f9968b;

        public a(tg.a aVar, SessionSubscriber sessionSubscriber) {
            i.checkNotNullParameter(aVar, "mutex");
            this.f9967a = aVar;
            this.f9968b = sessionSubscriber;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return i.areEqual(this.f9967a, aVar.f9967a) && i.areEqual(this.f9968b, aVar.f9968b);
        }

        public final tg.a getMutex() {
            return this.f9967a;
        }

        public final SessionSubscriber getSubscriber() {
            return this.f9968b;
        }

        public int hashCode() {
            int iHashCode = this.f9967a.hashCode() * 31;
            SessionSubscriber sessionSubscriber = this.f9968b;
            return iHashCode + (sessionSubscriber == null ? 0 : sessionSubscriber.hashCode());
        }

        public final void setSubscriber(SessionSubscriber sessionSubscriber) {
            this.f9968b = sessionSubscriber;
        }

        public String toString() {
            return "Dependency(mutex=" + this.f9967a + ", subscriber=" + this.f9968b + ')';
        }

        public /* synthetic */ a(tg.a aVar, SessionSubscriber sessionSubscriber, int i10, f fVar) {
            this(aVar, (i10 & 2) != 0 ? null : sessionSubscriber);
        }
    }

    public static a a(SessionSubscriber.Name name) {
        Map<SessionSubscriber.Name, a> map = f9966b;
        i.checkNotNullExpressionValue(map, "dependencies");
        a aVar = map.get(name);
        if (aVar != null) {
            i.checkNotNullExpressionValue(aVar, "dependencies.getOrElse(s…load time.\"\n      )\n    }");
            return aVar;
        }
        throw new IllegalStateException("Cannot get dependency " + name + ". Dependencies should be added at class load time.");
    }

    public static final void addDependency(SessionSubscriber.Name name) {
        i.checkNotNullParameter(name, "subscriberName");
        if (name == SessionSubscriber.Name.PERFORMANCE) {
            throw new IllegalArgumentException("Incompatible versions of Firebase Perf and Firebase Sessions.\nA safe combination would be:\n  firebase-sessions:1.1.0\n  firebase-crashlytics:18.5.0\n  firebase-perf:20.5.0\nFor more information contact Firebase Support.");
        }
        Map<SessionSubscriber.Name, a> map = f9966b;
        if (map.containsKey(name)) {
            Log.d("SessionsDependencies", "Dependency " + name + " already added.");
            return;
        }
        i.checkNotNullExpressionValue(map, "dependencies");
        map.put(name, new a(b.Mutex(true), null, 2, 0 == true ? 1 : 0));
        Log.d("SessionsDependencies", "Dependency to " + name + " added.");
    }

    public static final void register(SessionSubscriber sessionSubscriber) {
        i.checkNotNullParameter(sessionSubscriber, "subscriber");
        SessionSubscriber.Name sessionSubscriberName = sessionSubscriber.getSessionSubscriberName();
        a aVarA = a(sessionSubscriberName);
        if (aVarA.getSubscriber() != null) {
            Log.d("SessionsDependencies", "Subscriber " + sessionSubscriberName + " already registered.");
            return;
        }
        aVarA.setSubscriber(sessionSubscriber);
        Log.d("SessionsDependencies", "Subscriber " + sessionSubscriberName + " registered.");
        a.C0282a.unlock$default(aVarA.getMutex(), null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x009c -> B:27:0x009d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getRegisteredSubscribers$com_google_firebase_firebase_sessions(qf.c<? super java.util.Map<com.google.firebase.sessions.api.SessionSubscriber.Name, ? extends com.google.firebase.sessions.api.SessionSubscriber>> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1
            if (r0 == 0) goto L13
            r0 = r11
            com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1 r0 = (com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1) r0
            int r1 = r0.f9977t
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9977t = r1
            goto L18
        L13:
            com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1 r0 = new com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.f9975r
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.f9977t
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 != r4) goto L3a
            java.lang.Object r2 = r0.f9974q
            java.util.Map r5 = r0.f9973p
            java.util.Map r5 = (java.util.Map) r5
            tg.a r6 = r0.f9972o
            com.google.firebase.sessions.api.SessionSubscriber$Name r7 = r0.f9971n
            java.util.Iterator r8 = r0.f9970m
            java.util.Map r9 = r0.f9969b
            java.util.Map r9 = (java.util.Map) r9
            lf.f.throwOnFailure(r11)
            goto L9d
        L3a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L42:
            lf.f.throwOnFailure(r11)
            java.util.Map<com.google.firebase.sessions.api.SessionSubscriber$Name, com.google.firebase.sessions.api.FirebaseSessionsDependencies$a> r11 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.f9966b
            java.lang.String r2 = "dependencies"
            zf.i.checkNotNullExpressionValue(r11, r2)
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            int r5 = r11.size()
            int r5 = mf.x.mapCapacity(r5)
            r2.<init>(r5)
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
            r8 = r11
            r5 = r2
        L63:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto Lb0
            java.lang.Object r11 = r8.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r2 = r11.getKey()
            java.lang.Object r6 = r11.getKey()
            r7 = r6
            com.google.firebase.sessions.api.SessionSubscriber$Name r7 = (com.google.firebase.sessions.api.SessionSubscriber.Name) r7
            java.lang.Object r11 = r11.getValue()
            com.google.firebase.sessions.api.FirebaseSessionsDependencies$a r11 = (com.google.firebase.sessions.api.FirebaseSessionsDependencies.a) r11
            tg.a r6 = r11.getMutex()
            r11 = r5
            java.util.Map r11 = (java.util.Map) r11
            r0.f9969b = r11
            r0.f9970m = r8
            r0.f9971n = r7
            r0.f9972o = r6
            r0.f9973p = r11
            r0.f9974q = r2
            r0.f9977t = r4
            java.lang.Object r11 = r6.lock(r3, r0)
            if (r11 != r1) goto L9c
            return r1
        L9c:
            r9 = r5
        L9d:
            com.google.firebase.sessions.api.FirebaseSessionsDependencies r11 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.f9965a     // Catch: java.lang.Throwable -> Lab
            com.google.firebase.sessions.api.SessionSubscriber r11 = r11.getSubscriber$com_google_firebase_firebase_sessions(r7)     // Catch: java.lang.Throwable -> Lab
            r6.unlock(r3)
            r5.put(r2, r11)
            r5 = r9
            goto L63
        Lab:
            r11 = move-exception
            r6.unlock(r3)
            throw r11
        Lb0:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.api.FirebaseSessionsDependencies.getRegisteredSubscribers$com_google_firebase_firebase_sessions(qf.c):java.lang.Object");
    }

    public final SessionSubscriber getSubscriber$com_google_firebase_firebase_sessions(SessionSubscriber.Name name) {
        i.checkNotNullParameter(name, "subscriberName");
        SessionSubscriber subscriber = a(name).getSubscriber();
        if (subscriber != null) {
            return subscriber;
        }
        throw new IllegalStateException("Subscriber " + name + " has not been registered.");
    }
}
