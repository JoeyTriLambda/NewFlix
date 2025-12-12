package l0;

import l0.f;

/* compiled from: ActivityRecreator.java */
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f.b f15636b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f15637m;

    public d(f.b bVar, Object obj) {
        this.f15636b = bVar;
        this.f15637m = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15636b.f15649b = this.f15637m;
    }
}
