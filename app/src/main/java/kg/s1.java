package kg;

import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes2.dex */
public final class s1 extends LockFreeLinkedListNode.a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ r1 f15150d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f15151e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s1(LockFreeLinkedListNode lockFreeLinkedListNode, r1 r1Var, Object obj) {
        super(lockFreeLinkedListNode);
        this.f15150d = r1Var;
        this.f15151e = obj;
    }

    @Override // pg.b
    public Object prepare(LockFreeLinkedListNode lockFreeLinkedListNode) {
        if (this.f15150d.getState$kotlinx_coroutines_core() == this.f15151e) {
            return null;
        }
        return pg.n.getCONDITION_FALSE();
    }
}
