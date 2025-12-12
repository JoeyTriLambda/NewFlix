package kotlin.jvm.internal;

import gg.a;
import gg.d;
import zf.g;
import zf.i;
import zf.k;

/* loaded from: classes2.dex */
public class FunctionReference extends CallableReference implements g, d {

    /* renamed from: s, reason: collision with root package name */
    public final int f15256s;

    /* renamed from: t, reason: collision with root package name */
    public final int f15257t;

    public FunctionReference(int i10, Object obj, Class cls, String str, String str2, int i11) {
        super(obj, cls, str, str2, (i11 & 1) == 1);
        this.f15256s = i10;
        this.f15257t = i11 >> 1;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public a computeReflected() {
        return k.function(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            return getName().equals(functionReference.getName()) && getSignature().equals(functionReference.getSignature()) && this.f15257t == functionReference.f15257t && this.f15256s == functionReference.f15256s && i.areEqual(getBoundReceiver(), functionReference.getBoundReceiver()) && i.areEqual(getOwner(), functionReference.getOwner());
        }
        if (obj instanceof d) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // zf.g
    public int getArity() {
        return this.f15256s;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    public String toString() {
        a aVarCompute = compute();
        if (aVarCompute != this) {
            return aVarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }
}
