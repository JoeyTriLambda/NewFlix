package com.google.firebase.sessions;

import com.google.firebase.sessions.InstallationId;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import sf.d;

/* compiled from: InstallationId.kt */
@d(c = "com.google.firebase.sessions.InstallationId$Companion", f = "InstallationId.kt", l = {32, 40}, m = "create")
/* loaded from: classes.dex */
public final class InstallationId$Companion$create$1 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public Object f9887b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f9888m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ InstallationId.Companion f9889n;

    /* renamed from: o, reason: collision with root package name */
    public int f9890o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstallationId$Companion$create$1(InstallationId.Companion companion, c<? super InstallationId$Companion$create$1> cVar) {
        super(cVar);
        this.f9889n = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9888m = obj;
        this.f9890o |= Integer.MIN_VALUE;
        return this.f9889n.create(null, this);
    }
}
