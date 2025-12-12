package kg;

/* compiled from: Executors.kt */
/* loaded from: classes2.dex */
public final class d2 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final kotlinx.coroutines.b f15101b;

    /* renamed from: m, reason: collision with root package name */
    public final l<lf.h> f15102m;

    /* JADX WARN: Multi-variable type inference failed */
    public d2(kotlinx.coroutines.b bVar, l<? super lf.h> lVar) {
        this.f15101b = bVar;
        this.f15102m = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15102m.resumeUndispatched(this.f15101b, lf.h.f16056a);
    }
}
