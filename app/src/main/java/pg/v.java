package pg;

import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes2.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final LockFreeLinkedListNode f17731a;

    public v(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.f17731a = lockFreeLinkedListNode;
    }

    public String toString() {
        return "Removed[" + this.f17731a + ']';
    }
}
