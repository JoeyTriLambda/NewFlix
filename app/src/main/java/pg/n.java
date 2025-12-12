package pg;

import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes2.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f17719a = new b0("CONDITION_FALSE");

    public static final Object getCONDITION_FALSE() {
        return f17719a;
    }

    public static final LockFreeLinkedListNode unwrap(Object obj) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        v vVar = obj instanceof v ? (v) obj : null;
        if (vVar != null && (lockFreeLinkedListNode = vVar.f17731a) != null) {
            return lockFreeLinkedListNode;
        }
        zf.i.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (LockFreeLinkedListNode) obj;
    }
}
