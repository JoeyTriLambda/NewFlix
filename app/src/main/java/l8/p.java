package l8;

import a2.x;
import h9.a;

/* compiled from: OptionalProvider.java */
/* loaded from: classes.dex */
public final class p<T> implements h9.b<T>, h9.a<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final pd.a f15983c = new pd.a(25);

    /* renamed from: d, reason: collision with root package name */
    public static final i f15984d = new i(1);

    /* renamed from: a, reason: collision with root package name */
    public a.InterfaceC0161a<T> f15985a;

    /* renamed from: b, reason: collision with root package name */
    public volatile h9.b<T> f15986b;

    public p(pd.a aVar, h9.b bVar) {
        this.f15985a = aVar;
        this.f15986b = bVar;
    }

    @Override // h9.b
    public T get() {
        return this.f15986b.get();
    }

    public void whenAvailable(a.InterfaceC0161a<T> interfaceC0161a) {
        h9.b<T> bVar;
        h9.b<T> bVar2;
        h9.b<T> bVar3 = this.f15986b;
        i iVar = f15984d;
        if (bVar3 != iVar) {
            interfaceC0161a.handle(bVar3);
            return;
        }
        synchronized (this) {
            bVar = this.f15986b;
            if (bVar != iVar) {
                bVar2 = bVar;
            } else {
                this.f15985a = new x(4, this.f15985a, interfaceC0161a);
                bVar2 = null;
            }
        }
        if (bVar2 != null) {
            interfaceC0161a.handle(bVar);
        }
    }
}
