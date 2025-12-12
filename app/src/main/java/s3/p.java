package s3;

import java.util.Collections;

/* compiled from: ValueCallbackKeyframeAnimation.java */
/* loaded from: classes.dex */
public final class p<K, A> extends a<K, A> {

    /* renamed from: i, reason: collision with root package name */
    public final A f19063i;

    public p(b4.c<A> cVar) {
        this(cVar, null);
    }

    @Override // s3.a
    public final float a() {
        return 1.0f;
    }

    @Override // s3.a
    public A getValue() {
        b4.c<A> cVar = this.f19022e;
        A a10 = this.f19063i;
        return cVar.getValueInternal(0.0f, 0.0f, a10, a10, getProgress(), getProgress(), getProgress());
    }

    @Override // s3.a
    public void notifyListeners() {
        if (this.f19022e != null) {
            super.notifyListeners();
        }
    }

    @Override // s3.a
    public void setProgress(float f10) {
        this.f19021d = f10;
    }

    public p(b4.c<A> cVar, A a10) {
        super(Collections.emptyList());
        new b4.b();
        setValueCallback(cVar);
        this.f19063i = a10;
    }

    @Override // s3.a
    public final A getValue(b4.a<K> aVar, float f10) {
        return getValue();
    }
}
