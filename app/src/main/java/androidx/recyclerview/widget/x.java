package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: ViewInfoStore.java */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final b0.k<RecyclerView.z, a> f4260a = new b0.k<>();

    /* renamed from: b, reason: collision with root package name */
    public final b0.h<RecyclerView.z> f4261b = new b0.h<>();

    /* compiled from: ViewInfoStore.java */
    public static class a {

        /* renamed from: d, reason: collision with root package name */
        public static final w0.f f4262d = new w0.f(20);

        /* renamed from: a, reason: collision with root package name */
        public int f4263a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.i.c f4264b;

        /* renamed from: c, reason: collision with root package name */
        public RecyclerView.i.c f4265c;

        /* JADX WARN: Multi-variable type inference failed */
        public static a a() {
            a aVar = (a) f4262d.acquire();
            return aVar == null ? new a() : aVar;
        }
    }

    public final void a(RecyclerView.z zVar, RecyclerView.i.c cVar) {
        b0.k<RecyclerView.z, a> kVar = this.f4260a;
        a aVarA = kVar.get(zVar);
        if (aVarA == null) {
            aVarA = a.a();
            kVar.put(zVar, aVarA);
        }
        aVarA.f4265c = cVar;
        aVarA.f4263a |= 8;
    }

    public final RecyclerView.i.c b(RecyclerView.z zVar, int i10) {
        a aVarValueAt;
        RecyclerView.i.c cVar;
        b0.k<RecyclerView.z, a> kVar = this.f4260a;
        int iIndexOfKey = kVar.indexOfKey(zVar);
        if (iIndexOfKey >= 0 && (aVarValueAt = kVar.valueAt(iIndexOfKey)) != null) {
            int i11 = aVarValueAt.f4263a;
            if ((i11 & i10) != 0) {
                int i12 = i11 & (~i10);
                aVarValueAt.f4263a = i12;
                if (i10 == 4) {
                    cVar = aVarValueAt.f4264b;
                } else {
                    if (i10 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    cVar = aVarValueAt.f4265c;
                }
                if ((i12 & 12) == 0) {
                    kVar.removeAt(iIndexOfKey);
                    aVarValueAt.f4263a = 0;
                    aVarValueAt.f4264b = null;
                    aVarValueAt.f4265c = null;
                    a.f4262d.release(aVarValueAt);
                }
                return cVar;
            }
        }
        return null;
    }

    public final void c(RecyclerView.z zVar) {
        a aVar = this.f4260a.get(zVar);
        if (aVar == null) {
            return;
        }
        aVar.f4263a &= -2;
    }

    public final void d(RecyclerView.z zVar) {
        b0.h<RecyclerView.z> hVar = this.f4261b;
        int size = hVar.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (zVar == hVar.valueAt(size)) {
                hVar.removeAt(size);
                break;
            }
        }
        a aVarRemove = this.f4260a.remove(zVar);
        if (aVarRemove != null) {
            aVarRemove.f4263a = 0;
            aVarRemove.f4264b = null;
            aVarRemove.f4265c = null;
            a.f4262d.release(aVarRemove);
        }
    }

    public void onViewDetached(RecyclerView.z zVar) {
        c(zVar);
    }
}
