package com.google.firebase.sessions.api;

import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.Iterator;
import java.util.Map;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import sf.d;
import tg.a;

/* compiled from: FirebaseSessionsDependencies.kt */
@d(c = "com.google.firebase.sessions.api.FirebaseSessionsDependencies", f = "FirebaseSessionsDependencies.kt", l = {124}, m = "getRegisteredSubscribers$com_google_firebase_firebase_sessions")
/* loaded from: classes.dex */
public final class FirebaseSessionsDependencies$getRegisteredSubscribers$1 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public Map f9969b;

    /* renamed from: m, reason: collision with root package name */
    public Iterator f9970m;

    /* renamed from: n, reason: collision with root package name */
    public SessionSubscriber.Name f9971n;

    /* renamed from: o, reason: collision with root package name */
    public a f9972o;

    /* renamed from: p, reason: collision with root package name */
    public Map f9973p;

    /* renamed from: q, reason: collision with root package name */
    public Object f9974q;

    /* renamed from: r, reason: collision with root package name */
    public /* synthetic */ Object f9975r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ FirebaseSessionsDependencies f9976s;

    /* renamed from: t, reason: collision with root package name */
    public int f9977t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirebaseSessionsDependencies$getRegisteredSubscribers$1(FirebaseSessionsDependencies firebaseSessionsDependencies, c<? super FirebaseSessionsDependencies$getRegisteredSubscribers$1> cVar) {
        super(cVar);
        this.f9976s = firebaseSessionsDependencies;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9975r = obj;
        this.f9977t |= Integer.MIN_VALUE;
        return this.f9976s.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
    }
}
