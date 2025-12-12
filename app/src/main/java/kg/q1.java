package kg;

/* compiled from: JobSupport.kt */
/* loaded from: classes2.dex */
public abstract class q1 extends b0 implements u0, f1 {

    /* renamed from: o, reason: collision with root package name */
    public r1 f15133o;

    @Override // kg.u0
    public void dispose() {
        getJob().removeNode$kotlinx_coroutines_core(this);
    }

    public final r1 getJob() {
        r1 r1Var = this.f15133o;
        if (r1Var != null) {
            return r1Var;
        }
        zf.i.throwUninitializedPropertyAccessException("job");
        return null;
    }

    @Override // kg.f1
    public x1 getList() {
        return null;
    }

    @Override // kg.f1
    public boolean isActive() {
        return true;
    }

    public final void setJob(r1 r1Var) {
        this.f15133o = r1Var;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return i0.getClassSimpleName(this) + '@' + i0.getHexAddress(this) + "[job@" + i0.getHexAddress(getJob()) + ']';
    }
}
