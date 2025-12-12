package com.google.firebase.sessions;

import android.util.Log;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.Map;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;
import sf.d;
import yf.p;

/* compiled from: SessionLifecycleClient.kt */
@d(c = "com.google.firebase.sessions.SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1", f = "SessionLifecycleClient.kt", l = {74}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1 extends SuspendLambda implements p<g0, c<? super h>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public int f9948b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f9949m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1(String str, c<? super SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1> cVar) {
        super(2, cVar);
        this.f9949m = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        return new SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1(this.f9949m, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f9948b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            FirebaseSessionsDependencies firebaseSessionsDependencies = FirebaseSessionsDependencies.f9965a;
            this.f9948b = 1;
            obj = firebaseSessionsDependencies.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.throwOnFailure(obj);
        }
        for (SessionSubscriber sessionSubscriber : ((Map) obj).values()) {
            String str = this.f9949m;
            sessionSubscriber.onSessionChanged(new SessionSubscriber.a(str));
            Log.d("SessionLifecycleClient", "Notified " + sessionSubscriber.getSessionSubscriberName() + " of new session " + str);
        }
        return h.f16056a;
    }

    @Override // yf.p
    public final Object invoke(g0 g0Var, c<? super h> cVar) {
        return ((SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
    }
}
