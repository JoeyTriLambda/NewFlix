package g3;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicMarkableReference;
import s8.m;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Callable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f12644b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f12645m;

    public /* synthetic */ e(Object obj, int i10) {
        this.f12644b = i10;
        this.f12645m = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Map<String, String> keys;
        switch (this.f12644b) {
            case 0:
                g gVar = (g) this.f12645m;
                zf.i.checkNotNullParameter(gVar, "this$0");
                return Integer.valueOf(h.access$nextId(gVar.f12649a, "next_alarm_manager_id"));
            default:
                m.a aVar = (m.a) this.f12645m;
                aVar.f19173b.set(null);
                synchronized (aVar) {
                    if (aVar.f19172a.isMarked()) {
                        keys = aVar.f19172a.getReference().getKeys();
                        AtomicMarkableReference<s8.d> atomicMarkableReference = aVar.f19172a;
                        atomicMarkableReference.set(atomicMarkableReference.getReference(), false);
                    } else {
                        keys = null;
                    }
                }
                if (keys != null) {
                    s8.m mVar = s8.m.this;
                    mVar.f19165a.writeKeyData(mVar.f19167c, keys, aVar.f19174c);
                }
                return null;
        }
    }
}
