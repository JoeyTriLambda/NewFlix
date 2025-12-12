package kg;

/* compiled from: JobSupport.kt */
/* loaded from: classes2.dex */
public final class x0 implements f1 {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f15164b;

    public x0(boolean z10) {
        this.f15164b = z10;
    }

    @Override // kg.f1
    public x1 getList() {
        return null;
    }

    @Override // kg.f1
    public boolean isActive() {
        return this.f15164b;
    }

    public String toString() {
        return ac.c.n(new StringBuilder("Empty{"), isActive() ? "Active" : "New", '}');
    }
}
