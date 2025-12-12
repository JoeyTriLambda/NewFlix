package v3;

import java.util.Arrays;
import java.util.List;

/* compiled from: BaseAnimatableValue.java */
/* loaded from: classes.dex */
public abstract class n<V, O> implements m<V, O> {

    /* renamed from: a, reason: collision with root package name */
    public final List<b4.a<V>> f20461a;

    public n(List<b4.a<V>> list) {
        this.f20461a = list;
    }

    @Override // v3.m
    public List<b4.a<V>> getKeyframes() {
        return this.f20461a;
    }

    @Override // v3.m
    public boolean isStatic() {
        List<b4.a<V>> list = this.f20461a;
        if (list.isEmpty()) {
            return true;
        }
        return list.size() == 1 && list.get(0).isStatic();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        List<b4.a<V>> list = this.f20461a;
        if (!list.isEmpty()) {
            sb2.append("values=");
            sb2.append(Arrays.toString(list.toArray()));
        }
        return sb2.toString();
    }
}
