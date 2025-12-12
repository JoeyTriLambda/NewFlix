package com.google.firebase.sessions.settings;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import lf.h;
import org.json.JSONObject;
import qf.c;
import sf.d;
import yf.p;

/* compiled from: RemoteSettings.kt */
@d(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1", f = "RemoteSettings.kt", l = {125, 128, 131, 133, 134, 136}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RemoteSettings$updateSettings$2$1 extends SuspendLambda implements p<JSONObject, c<? super h>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public Ref$ObjectRef f9993b;

    /* renamed from: m, reason: collision with root package name */
    public Ref$ObjectRef f9994m;

    /* renamed from: n, reason: collision with root package name */
    public int f9995n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f9996o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ RemoteSettings f9997p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteSettings$updateSettings$2$1(RemoteSettings remoteSettings, c<? super RemoteSettings$updateSettings$2$1> cVar) {
        super(2, cVar);
        this.f9997p = remoteSettings;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(this.f9997p, cVar);
        remoteSettings$updateSettings$2$1.f9996o = obj;
        return remoteSettings$updateSettings$2$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x018d A[RETURN] */
    /* JADX WARN: Type inference failed for: r14v11, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Double] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 420
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // yf.p
    public final Object invoke(JSONObject jSONObject, c<? super h> cVar) {
        return ((RemoteSettings$updateSettings$2$1) create(jSONObject, cVar)).invokeSuspend(h.f16056a);
    }
}
