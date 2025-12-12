package kotlin.jvm.internal;

import gg.a;
import gg.g;
import zf.i;

/* loaded from: classes2.dex */
public abstract class PropertyReference extends CallableReference implements g {

    /* renamed from: s, reason: collision with root package name */
    public final boolean f15258s;

    public PropertyReference() {
        this.f15258s = false;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public a compute() {
        return this.f15258s ? this : super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return getOwner().equals(propertyReference.getOwner()) && getName().equals(propertyReference.getName()) && getSignature().equals(propertyReference.getSignature()) && i.areEqual(getBoundReceiver(), propertyReference.getBoundReceiver());
        }
        if (obj instanceof g) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public g getReflected() {
        if (this.f15258s) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
        }
        return (g) super.getReflected();
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    public String toString() {
        a aVarCompute = compute();
        if (aVarCompute != this) {
            return aVarCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    public PropertyReference(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, (i10 & 1) == 1);
        this.f15258s = (i10 & 2) == 2;
    }
}
