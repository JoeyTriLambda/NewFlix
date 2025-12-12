package hg;

import c8.i;
import java.util.Iterator;

/* compiled from: Sequences.kt */
/* loaded from: classes2.dex */
public class e extends i {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    public static final class a<T> implements d<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f13077a;

        public a(Iterator it) {
            this.f13077a = it;
        }

        @Override // hg.d
        public Iterator<T> iterator() {
            return this.f13077a;
        }
    }

    public static final <T> d<T> asSequence(Iterator<? extends T> it) {
        zf.i.checkNotNullParameter(it, "<this>");
        return constrainOnce(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> d<T> constrainOnce(d<? extends T> dVar) {
        zf.i.checkNotNullParameter(dVar, "<this>");
        return dVar instanceof hg.a ? dVar : new hg.a(dVar);
    }
}
