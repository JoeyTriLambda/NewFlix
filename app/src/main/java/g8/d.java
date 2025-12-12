package g8;

import android.content.Context;
import l8.s;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements h9.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12779a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12780b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f12781c;

    public /* synthetic */ d(int i10, Object obj, Object obj2) {
        this.f12779a = i10;
        this.f12780b = obj;
        this.f12781c = obj2;
    }

    @Override // h9.b
    public final Object get() {
        int i10 = this.f12779a;
        Object obj = this.f12781c;
        Object obj2 = this.f12780b;
        switch (i10) {
            case 0:
                f fVar = (f) obj2;
                String persistenceKey = fVar.getPersistenceKey();
                l8.j jVar = fVar.f12788d;
                jVar.getClass();
                return new n9.a((Context) obj, persistenceKey, (f9.c) l8.c.a(jVar, f9.c.class));
            case 1:
                l8.j jVar2 = (l8.j) obj2;
                l8.b bVar = (l8.b) obj;
                jVar2.getClass();
                return bVar.getFactory().create(new s(bVar, jVar2));
            default:
                return new g9.h((Context) obj, (String) obj2);
        }
    }

    public /* synthetic */ d(Context context, String str) {
        this.f12779a = 2;
        this.f12781c = context;
        this.f12780b = str;
    }
}
