package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ListFieldSchema.java */
/* loaded from: classes.dex */
public abstract class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f2401a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final b f2402b = new b();

    /* compiled from: ListFieldSchema.java */
    public static final class a extends b0 {

        /* renamed from: c, reason: collision with root package name */
        public static final Class<?> f2403c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        /* JADX WARN: Multi-variable type inference failed */
        public static List d(long j10, int i10, Object obj) {
            z zVar;
            List list = (List) j1.n(obj, j10);
            if (list.isEmpty()) {
                List zVar2 = list instanceof a0 ? new z(i10) : ((list instanceof t0) && (list instanceof w.h)) ? ((w.h) list).mutableCopyWithCapacity2(i10) : new ArrayList(i10);
                j1.u(obj, j10, zVar2);
                return zVar2;
            }
            if (f2403c.isAssignableFrom(list.getClass())) {
                ArrayList arrayList = new ArrayList(list.size() + i10);
                arrayList.addAll(list);
                j1.u(obj, j10, arrayList);
                zVar = arrayList;
            } else {
                if (!(list instanceof i1)) {
                    if (!(list instanceof t0) || !(list instanceof w.h)) {
                        return list;
                    }
                    w.h hVar = (w.h) list;
                    if (hVar.isModifiable()) {
                        return list;
                    }
                    w.h hVarMutableCopyWithCapacity2 = hVar.mutableCopyWithCapacity2(list.size() + i10);
                    j1.u(obj, j10, hVarMutableCopyWithCapacity2);
                    return hVarMutableCopyWithCapacity2;
                }
                z zVar3 = new z(list.size() + i10);
                zVar3.addAll((i1) list);
                j1.u(obj, j10, zVar3);
                zVar = zVar3;
            }
            return zVar;
        }

        @Override // androidx.datastore.preferences.protobuf.b0
        public final void a(long j10, Object obj) {
            Object objUnmodifiableList;
            List list = (List) j1.n(obj, j10);
            if (list instanceof a0) {
                objUnmodifiableList = ((a0) list).getUnmodifiableView();
            } else {
                if (f2403c.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof t0) && (list instanceof w.h)) {
                    w.h hVar = (w.h) list;
                    if (hVar.isModifiable()) {
                        hVar.makeImmutable();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            j1.u(obj, j10, objUnmodifiableList);
        }

        @Override // androidx.datastore.preferences.protobuf.b0
        public final void b(Object obj, long j10, Object obj2) {
            List list = (List) j1.n(obj2, j10);
            List listD = d(j10, list.size(), obj);
            int size = listD.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                listD.addAll(list);
            }
            if (size > 0) {
                list = listD;
            }
            j1.u(obj, j10, list);
        }

        @Override // androidx.datastore.preferences.protobuf.b0
        public final List c(long j10, Object obj) {
            return d(j10, 10, obj);
        }
    }

    /* compiled from: ListFieldSchema.java */
    public static final class b extends b0 {
        @Override // androidx.datastore.preferences.protobuf.b0
        public final void a(long j10, Object obj) {
            ((w.h) j1.n(obj, j10)).makeImmutable();
        }

        @Override // androidx.datastore.preferences.protobuf.b0
        public final void b(Object obj, long j10, Object obj2) {
            w.h hVarMutableCopyWithCapacity2 = (w.h) j1.n(obj, j10);
            w.h hVar = (w.h) j1.n(obj2, j10);
            int size = hVarMutableCopyWithCapacity2.size();
            int size2 = hVar.size();
            if (size > 0 && size2 > 0) {
                if (!hVarMutableCopyWithCapacity2.isModifiable()) {
                    hVarMutableCopyWithCapacity2 = hVarMutableCopyWithCapacity2.mutableCopyWithCapacity2(size2 + size);
                }
                hVarMutableCopyWithCapacity2.addAll(hVar);
            }
            if (size > 0) {
                hVar = hVarMutableCopyWithCapacity2;
            }
            j1.u(obj, j10, hVar);
        }

        @Override // androidx.datastore.preferences.protobuf.b0
        public final List c(long j10, Object obj) {
            w.h hVar = (w.h) j1.n(obj, j10);
            if (hVar.isModifiable()) {
                return hVar;
            }
            int size = hVar.size();
            w.h hVarMutableCopyWithCapacity2 = hVar.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            j1.u(obj, j10, hVarMutableCopyWithCapacity2);
            return hVarMutableCopyWithCapacity2;
        }
    }

    public abstract void a(long j10, Object obj);

    public abstract void b(Object obj, long j10, Object obj2);

    public abstract List c(long j10, Object obj);
}
