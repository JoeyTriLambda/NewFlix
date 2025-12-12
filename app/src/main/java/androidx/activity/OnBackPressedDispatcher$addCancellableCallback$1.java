package androidx.activity;

import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: OnBackPressedDispatcher.kt */
/* loaded from: classes.dex */
public /* synthetic */ class OnBackPressedDispatcher$addCancellableCallback$1 extends FunctionReferenceImpl implements yf.a<lf.h> {
    public OnBackPressedDispatcher$addCancellableCallback$1(Object obj) {
        super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
    }

    @Override // yf.a
    public /* bridge */ /* synthetic */ lf.h invoke() {
        invoke2();
        return lf.h.f16056a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((OnBackPressedDispatcher) this.f15250m).b();
    }
}
