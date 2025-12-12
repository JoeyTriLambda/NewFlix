package kotlin.jvm.internal;

import gg.a;
import gg.f;
import zf.k;

/* loaded from: classes2.dex */
public abstract class PropertyReference2 extends PropertyReference implements f {
    public PropertyReference2(Class cls, String str, String str2, int i10) {
        super(CallableReference.f15248r, cls, str, str2, i10);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public a computeReflected() {
        return k.property2(this);
    }

    @Override // gg.f
    public f.a getGetter() {
        ((f) getReflected()).getGetter();
        return null;
    }

    @Override // yf.p
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }
}
