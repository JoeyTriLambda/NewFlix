package kotlin.jvm.internal;

import gg.a;
import gg.e;
import zf.k;

/* loaded from: classes2.dex */
public abstract class PropertyReference0 extends PropertyReference implements e {
    public PropertyReference0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public a computeReflected() {
        return k.property0(this);
    }

    @Override // yf.a
    public Object invoke() {
        return get();
    }
}
