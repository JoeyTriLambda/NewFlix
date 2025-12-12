package mf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Pair;

/* compiled from: _Collections.kt */
/* loaded from: classes2.dex */
public class q extends p {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    public static final class a<T> implements hg.d<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f16308a;

        public a(Iterable iterable) {
            this.f16308a = iterable;
        }

        @Override // hg.d
        public Iterator<T> iterator() {
            return this.f16308a.iterator();
        }
    }

    public static final <T> hg.d<T> asSequence(Iterable<? extends T> iterable) {
        zf.i.checkNotNullParameter(iterable, "<this>");
        return new a(iterable);
    }

    public static final <T> boolean contains(Iterable<? extends T> iterable, T t10) {
        zf.i.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(t10) : indexOf(iterable, t10) >= 0;
    }

    public static final <T> List<T> dropLast(List<? extends T> list, int i10) {
        zf.i.checkNotNullParameter(list, "<this>");
        if (i10 >= 0) {
            return take(list, fg.h.coerceAtLeast(list.size() - i10, 0));
        }
        throw new IllegalArgumentException(o1.a.d("Requested element count ", i10, " is less than zero.").toString());
    }

    public static final <T> List<T> filterNotNull(Iterable<? extends T> iterable) {
        zf.i.checkNotNullParameter(iterable, "<this>");
        return (List) filterNotNullTo(iterable, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(Iterable<? extends T> iterable, C c10) {
        zf.i.checkNotNullParameter(iterable, "<this>");
        zf.i.checkNotNullParameter(c10, "destination");
        for (T t10 : iterable) {
            if (t10 != null) {
                c10.add(t10);
            }
        }
        return c10;
    }

    public static final <T> T first(Iterable<? extends T> iterable) {
        zf.i.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) first((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T firstOrNull(List<? extends T> list) {
        zf.i.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final <T> int indexOf(Iterable<? extends T> iterable, T t10) {
        zf.i.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t10);
        }
        int i10 = 0;
        for (T t11 : iterable) {
            if (i10 < 0) {
                k.throwIndexOverflow();
            }
            if (zf.i.areEqual(t10, t11)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final <T, A extends Appendable> A joinTo(Iterable<? extends T> iterable, A a10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, yf.l<? super T, ? extends CharSequence> lVar) throws IOException {
        zf.i.checkNotNullParameter(iterable, "<this>");
        zf.i.checkNotNullParameter(a10, "buffer");
        zf.i.checkNotNullParameter(charSequence, "separator");
        zf.i.checkNotNullParameter(charSequence2, "prefix");
        zf.i.checkNotNullParameter(charSequence3, "postfix");
        zf.i.checkNotNullParameter(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (T t10 : iterable) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            ig.h.appendElement(a10, t10, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    public static final <T> String joinToString(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, yf.l<? super T, ? extends CharSequence> lVar) {
        zf.i.checkNotNullParameter(iterable, "<this>");
        zf.i.checkNotNullParameter(charSequence, "separator");
        zf.i.checkNotNullParameter(charSequence2, "prefix");
        zf.i.checkNotNullParameter(charSequence3, "postfix");
        zf.i.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, lVar)).toString();
        zf.i.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, yf.l lVar, int i11, Object obj) {
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
        return joinToString(iterable, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    public static final <T> T last(List<? extends T> list) {
        zf.i.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(k.getLastIndex(list));
    }

    public static final <T extends Comparable<? super T>> T minOrNull(Iterable<? extends T> iterable) {
        zf.i.checkNotNullParameter(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T> List<T> plus(Collection<? extends T> collection, T t10) {
        zf.i.checkNotNullParameter(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t10);
        return arrayList;
    }

    public static final <T> T single(Iterable<? extends T> iterable) {
        zf.i.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) single((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final <T extends Comparable<? super T>> List<T> sorted(Iterable<? extends T> iterable) {
        zf.i.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List<T> mutableList = toMutableList(iterable);
            n.sort(mutableList);
            return mutableList;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return toList(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        h.sort((Comparable[]) array);
        return h.asList(array);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> sortedWith(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        zf.i.checkNotNullParameter(iterable, "<this>");
        zf.i.checkNotNullParameter(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> mutableList = toMutableList(iterable);
            n.sortWith(mutableList, comparator);
            return mutableList;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return toList(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        h.sortWith(array, comparator);
        return h.asList(array);
    }

    public static final <T> List<T> take(Iterable<? extends T> iterable, int i10) {
        zf.i.checkNotNullParameter(iterable, "<this>");
        int i11 = 0;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(o1.a.d("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k.emptyList();
        }
        if (iterable instanceof Collection) {
            if (i10 >= ((Collection) iterable).size()) {
                return toList(iterable);
            }
            if (i10 == 1) {
                return j.listOf(first(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i10);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return k.optimizeReadOnlyList(arrayList);
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Iterable<? extends T> iterable, C c10) {
        zf.i.checkNotNullParameter(iterable, "<this>");
        zf.i.checkNotNullParameter(c10, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c10.add(it.next());
        }
        return c10;
    }

    public static final int[] toIntArray(Collection<Integer> collection) {
        zf.i.checkNotNullParameter(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArr[i10] = it.next().intValue();
            i10++;
        }
        return iArr;
    }

    public static final <T> List<T> toList(Iterable<? extends T> iterable) {
        zf.i.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return k.optimizeReadOnlyList(toMutableList(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return k.emptyList();
        }
        if (size != 1) {
            return toMutableList(collection);
        }
        return j.listOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> List<T> toMutableList(Iterable<? extends T> iterable) {
        zf.i.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? toMutableList((Collection) iterable) : (List) toCollection(iterable, new ArrayList());
    }

    public static final <T> Set<T> toSet(Iterable<? extends T> iterable) {
        zf.i.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return z.optimizeReadOnlySet((Set) toCollection(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return z.emptySet();
        }
        if (size != 1) {
            return (Set) toCollection(iterable, new LinkedHashSet(x.mapCapacity(collection.size())));
        }
        return y.setOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T, R> List<Pair<T, R>> zip(Iterable<? extends T> iterable, Iterable<? extends R> iterable2) {
        zf.i.checkNotNullParameter(iterable, "<this>");
        zf.i.checkNotNullParameter(iterable2, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(l.collectionSizeOrDefault(iterable, 10), l.collectionSizeOrDefault(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(lf.g.to(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static final <T> List<T> plus(Collection<? extends T> collection, T[] tArr) {
        zf.i.checkNotNullParameter(collection, "<this>");
        zf.i.checkNotNullParameter(tArr, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + tArr.length);
        arrayList.addAll(collection);
        o.addAll(arrayList, tArr);
        return arrayList;
    }

    public static final <T> List<T> toMutableList(Collection<? extends T> collection) {
        zf.i.checkNotNullParameter(collection, "<this>");
        return new ArrayList(collection);
    }

    public static final <T> T first(List<? extends T> list) {
        zf.i.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> List<T> plus(Collection<? extends T> collection, Iterable<? extends T> iterable) {
        zf.i.checkNotNullParameter(collection, "<this>");
        zf.i.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            Collection collection2 = (Collection) iterable;
            ArrayList arrayList = new ArrayList(collection2.size() + collection.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        o.addAll(arrayList2, iterable);
        return arrayList2;
    }

    public static final <T> T single(List<? extends T> list) {
        zf.i.checkNotNullParameter(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }
}
