package com.google.firebase.sessions;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import sf.d;

/* compiled from: SessionFirelogPublisher.kt */
@d(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl", f = "SessionFirelogPublisher.kt", l = {94}, m = "shouldLogSession")
/* loaded from: classes.dex */
final class SessionFirelogPublisherImpl$shouldLogSession$1 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public SessionFirelogPublisherImpl f9937b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f9938m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ SessionFirelogPublisherImpl f9939n;

    /* renamed from: o, reason: collision with root package name */
    public int f9940o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionFirelogPublisherImpl$shouldLogSession$1(SessionFirelogPublisherImpl sessionFirelogPublisherImpl, c<? super SessionFirelogPublisherImpl$shouldLogSession$1> cVar) {
        super(cVar);
        this.f9939n = sessionFirelogPublisherImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9938m = obj;
        this.f9940o |= Integer.MIN_VALUE;
        return SessionFirelogPublisherImpl.access$shouldLogSession(this.f9939n, this);
    }
}
