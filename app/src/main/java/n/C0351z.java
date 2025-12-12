package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import xg.a;

/* renamed from: n.z, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0351z extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16397b;

    /* renamed from: m, reason: collision with root package name */
    public int f16398m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ a f16399n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0351z(a aVar, c cVar) {
        super(cVar);
        this.f16399n = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16397b = obj;
        this.f16398m |= Integer.MIN_VALUE;
        return this.f16399n.emit(null, this);
    }
}
