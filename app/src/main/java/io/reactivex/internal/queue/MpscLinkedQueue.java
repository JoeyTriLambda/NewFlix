package io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicReference;
import ve.e;

/* loaded from: classes2.dex */
public final class MpscLinkedQueue<T> implements e<T> {

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference<LinkedQueueNode<T>> f14500b;

    /* renamed from: m, reason: collision with root package name */
    public final AtomicReference<LinkedQueueNode<T>> f14501m;

    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;

        /* renamed from: b, reason: collision with root package name */
        public E f14502b;

        public LinkedQueueNode() {
        }

        public E getAndNullValue() {
            E eLpValue = lpValue();
            spValue(null);
            return eLpValue;
        }

        public E lpValue() {
            return this.f14502b;
        }

        public LinkedQueueNode<E> lvNext() {
            return get();
        }

        public void soNext(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public void spValue(E e10) {
            this.f14502b = e10;
        }

        public LinkedQueueNode(E e10) {
            spValue(e10);
        }
    }

    public MpscLinkedQueue() {
        AtomicReference<LinkedQueueNode<T>> atomicReference = new AtomicReference<>();
        this.f14500b = atomicReference;
        AtomicReference<LinkedQueueNode<T>> atomicReference2 = new AtomicReference<>();
        this.f14501m = atomicReference2;
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>();
        atomicReference2.lazySet(linkedQueueNode);
        atomicReference.getAndSet(linkedQueueNode);
    }

    @Override // ve.f
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // ve.f
    public boolean isEmpty() {
        return this.f14501m.get() == this.f14500b.get();
    }

    @Override // ve.f
    public boolean offer(T t10) {
        if (t10 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>(t10);
        this.f14500b.getAndSet(linkedQueueNode).soNext(linkedQueueNode);
        return true;
    }

    @Override // ve.e, ve.f
    public T poll() {
        LinkedQueueNode<T> linkedQueueNodeLvNext;
        AtomicReference<LinkedQueueNode<T>> atomicReference = this.f14501m;
        LinkedQueueNode<T> linkedQueueNode = atomicReference.get();
        LinkedQueueNode<T> linkedQueueNodeLvNext2 = linkedQueueNode.lvNext();
        if (linkedQueueNodeLvNext2 != null) {
            T andNullValue = linkedQueueNodeLvNext2.getAndNullValue();
            atomicReference.lazySet(linkedQueueNodeLvNext2);
            return andNullValue;
        }
        if (linkedQueueNode == this.f14500b.get()) {
            return null;
        }
        do {
            linkedQueueNodeLvNext = linkedQueueNode.lvNext();
        } while (linkedQueueNodeLvNext == null);
        T andNullValue2 = linkedQueueNodeLvNext.getAndNullValue();
        atomicReference.lazySet(linkedQueueNodeLvNext);
        return andNullValue2;
    }
}
