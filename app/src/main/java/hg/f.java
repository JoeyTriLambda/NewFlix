package hg;

import ig.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mf.k;
import yf.l;
import zf.i;

/* compiled from: _Sequences.kt */
/* loaded from: classes2.dex */
public class f extends e {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterables.kt */
    public static final class a<T> implements Iterable<T>, ag.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f13078b;

        public a(d dVar) {
            this.f13078b = dVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f13078b.iterator();
        }
    }

    public static final <T> Iterable<T> asIterable(d<? extends T> dVar) {
        i.checkNotNullParameter(dVar, "<this>");
        return new a(dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> d<T> drop(d<? extends T> dVar, int i10) {
        i.checkNotNullParameter(dVar, "<this>");
        if (i10 >= 0) {
            return i10 == 0 ? dVar : dVar instanceof c ? ((c) dVar).drop(i10) : new b(dVar, i10);
        }
        throw new IllegalArgumentException(o1.a.d("Requested element count ", i10, " is less than zero.").toString());
    }

    public static final <T, A extends Appendable> A joinTo(d<? extends T> dVar, A a10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, l<? super T, ? extends CharSequence> lVar) throws IOException {
        i.checkNotNullParameter(dVar, "<this>");
        i.checkNotNullParameter(a10, "buffer");
        i.checkNotNullParameter(charSequence, "separator");
        i.checkNotNullParameter(charSequence2, "prefix");
        i.checkNotNullParameter(charSequence3, "postfix");
        i.checkNotNullParameter(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (T t10 : dVar) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            h.appendElement(a10, t10, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    public static final <T> String joinToString(d<? extends T> dVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, l<? super T, ? extends CharSequence> lVar) {
        i.checkNotNullParameter(dVar, "<this>");
        i.checkNotNullParameter(charSequence, "separator");
        i.checkNotNullParameter(charSequence2, "prefix");
        i.checkNotNullParameter(charSequence3, "postfix");
        i.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(dVar, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, lVar)).toString();
        i.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(d dVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        int i12 = (i11 & 8) != 0 ? -1 : i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return joinToString(dVar, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    public static final <T, R> d<R> map(d<? extends T> dVar, l<? super T, ? extends R> lVar) {
        i.checkNotNullParameter(dVar, "<this>");
        i.checkNotNullParameter(lVar, "transform");
        return new g(dVar, lVar);
    }

    public static final <T, C extends Collection<? super T>> C toCollection(d<? extends T> dVar, C c10) {
        i.checkNotNullParameter(dVar, "<this>");
        i.checkNotNullParameter(c10, "destination");
        Iterator<? extends T> it = dVar.iterator();
        while (it.hasNext()) {
            c10.add(it.next());
        }
        return c10;
    }

    public static final <T> List<T> toList(d<? extends T> dVar) {
        i.checkNotNullParameter(dVar, "<this>");
        return k.optimizeReadOnlyList(toMutableList(dVar));
    }

    public static final <T> List<T> toMutableList(d<? extends T> dVar) {
        i.checkNotNullParameter(dVar, "<this>");
        return (List) toCollection(dVar, new ArrayList());
    }
}
