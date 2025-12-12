package com.google.firebase.sessions;

import android.util.Log;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import ng.b;
import qf.c;
import sf.d;
import yf.q;

/* compiled from: SessionDatastore.kt */
@d(c = "com.google.firebase.sessions.SessionDatastoreImpl$firebaseSessionDataFlow$1", f = "SessionDatastore.kt", l = {75}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SessionDatastoreImpl$firebaseSessionDataFlow$1 extends SuspendLambda implements q<b<? super l1.a>, Throwable, c<? super h>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public int f9914b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ b f9915m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ Throwable f9916n;

    public SessionDatastoreImpl$firebaseSessionDataFlow$1(c<? super SessionDatastoreImpl$firebaseSessionDataFlow$1> cVar) {
        super(3, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f9914b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            b bVar = this.f9915m;
            Log.e("FirebaseSessionsRepo", "Error reading stored session data.", this.f9916n);
            l1.a aVarCreateEmpty = l1.b.createEmpty();
            this.f9915m = null;
            this.f9914b = 1;
            if (bVar.emit(aVarCreateEmpty, this) == coroutine_suspended) {
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

    @Override // yf.q
    public final Object invoke(b<? super l1.a> bVar, Throwable th2, c<? super h> cVar) {
        SessionDatastoreImpl$firebaseSessionDataFlow$1 sessionDatastoreImpl$firebaseSessionDataFlow$1 = new SessionDatastoreImpl$firebaseSessionDataFlow$1(cVar);
        sessionDatastoreImpl$firebaseSessionDataFlow$1.f9915m = bVar;
        sessionDatastoreImpl$firebaseSessionDataFlow$1.f9916n = th2;
        return sessionDatastoreImpl$firebaseSessionDataFlow$1.invokeSuspend(h.f16056a);
    }
}
