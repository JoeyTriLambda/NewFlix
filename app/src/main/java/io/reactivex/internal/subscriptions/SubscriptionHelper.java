package io.reactivex.internal.subscriptions;

import cf.b;
import ff.a;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import zh.c;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class SubscriptionHelper implements c {

    /* renamed from: b, reason: collision with root package name */
    public static final SubscriptionHelper f14534b;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ SubscriptionHelper[] f14535m;

    static {
        SubscriptionHelper subscriptionHelper = new SubscriptionHelper();
        f14534b = subscriptionHelper;
        f14535m = new SubscriptionHelper[]{subscriptionHelper};
    }

    public static void deferredRequest(AtomicReference<c> atomicReference, AtomicLong atomicLong, long j10) {
        c cVar = atomicReference.get();
        if (cVar != null) {
            cVar.request(j10);
            return;
        }
        if (validate(j10)) {
            b.add(atomicLong, j10);
            c cVar2 = atomicReference.get();
            if (cVar2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    cVar2.request(andSet);
                }
            }
        }
    }

    public static boolean deferredSetOnce(AtomicReference<c> atomicReference, AtomicLong atomicLong, c cVar) {
        if (!setOnce(atomicReference, cVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0L);
        if (andSet == 0) {
            return true;
        }
        cVar.request(andSet);
        return true;
    }

    public static void reportSubscriptionSet() {
        a.onError(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean setOnce(AtomicReference<c> atomicReference, c cVar) {
        boolean z10;
        ue.a.requireNonNull(cVar, "s is null");
        while (true) {
            if (atomicReference.compareAndSet(null, cVar)) {
                z10 = true;
                break;
            }
            if (atomicReference.get() != null) {
                z10 = false;
                break;
            }
        }
        if (z10) {
            return true;
        }
        cVar.cancel();
        if (atomicReference.get() != f14534b) {
            reportSubscriptionSet();
        }
        return false;
    }

    public static boolean validate(c cVar, c cVar2) {
        if (cVar2 == null) {
            a.onError(new NullPointerException("next is null"));
            return false;
        }
        if (cVar == null) {
            return true;
        }
        cVar2.cancel();
        reportSubscriptionSet();
        return false;
    }

    public static SubscriptionHelper valueOf(String str) {
        return (SubscriptionHelper) Enum.valueOf(SubscriptionHelper.class, str);
    }

    public static SubscriptionHelper[] values() {
        return (SubscriptionHelper[]) f14535m.clone();
    }

    @Override // zh.c
    public void cancel() {
    }

    public static boolean cancel(AtomicReference<c> atomicReference) {
        c andSet;
        c cVar = atomicReference.get();
        SubscriptionHelper subscriptionHelper = f14534b;
        if (cVar == subscriptionHelper || (andSet = atomicReference.getAndSet(subscriptionHelper)) == subscriptionHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static boolean validate(long j10) {
        if (j10 > 0) {
            return true;
        }
        a.onError(new IllegalArgumentException(ac.c.h("n > 0 required but it was ", j10)));
        return false;
    }

    @Override // zh.c
    public void request(long j10) {
    }
}
