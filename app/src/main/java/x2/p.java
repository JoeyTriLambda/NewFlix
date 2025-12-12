package x2;

import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import m8.f;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements Callable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21458b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f21459m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f21460n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f21461o;

    public /* synthetic */ p(int i10, Object obj, Object obj2, Object obj3) {
        this.f21458b = i10;
        this.f21459m = obj;
        this.f21460n = obj2;
        this.f21461o = obj3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i10 = this.f21458b;
        Object obj = this.f21461o;
        Object obj2 = this.f21460n;
        Object obj3 = this.f21459m;
        switch (i10) {
            case 0:
                String str = (String) obj;
                WorkDatabase workDatabase = ((r) obj3).f21470p;
                ((ArrayList) obj2).addAll(workDatabase.workTagDao().getTagsForWorkSpecId(str));
                return workDatabase.workSpecDao().getWorkSpec(str);
            default:
                m8.e eVar = (m8.e) obj3;
                eVar.getClass();
                return eVar.f16219b.submit(new r.x(16, (Callable) obj2, (f.b) obj));
        }
    }
}
