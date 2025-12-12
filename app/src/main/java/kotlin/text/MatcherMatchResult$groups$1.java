package kotlin.text;

import fg.c;
import fg.h;
import hg.f;
import ig.e;
import java.util.Iterator;
import java.util.regex.MatchResult;
import kotlin.collections.AbstractCollection;
import mf.k;
import mf.q;
import yf.l;
import zf.i;

/* compiled from: Regex.kt */
/* loaded from: classes2.dex */
public final class MatcherMatchResult$groups$1 extends AbstractCollection<e> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MatcherMatchResult f15268b;

    public MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.f15268b = matcherMatchResult;
    }

    public /* bridge */ boolean contains(e eVar) {
        return super.contains((MatcherMatchResult$groups$1) eVar);
    }

    public e get(int i10) {
        MatcherMatchResult matcherMatchResult = this.f15268b;
        MatchResult matchResult = matcherMatchResult.f15265a;
        c cVarUntil = h.until(matchResult.start(i10), matchResult.end(i10));
        if (cVarUntil.getStart().intValue() < 0) {
            return null;
        }
        String strGroup = matcherMatchResult.f15265a.group(i10);
        i.checkNotNullExpressionValue(strGroup, "matchResult.group(index)");
        return new e(strGroup, cVarUntil);
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f15268b.f15265a.groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<e> iterator() {
        return f.map(q.asSequence(k.getIndices(this)), new l<Integer, e>() { // from class: kotlin.text.MatcherMatchResult$groups$1$iterator$1
            {
                super(1);
            }

            public final e invoke(int i10) {
                return this.f15269b.get(i10);
            }

            @Override // yf.l
            public /* bridge */ /* synthetic */ e invoke(Integer num) {
                return invoke(num.intValue());
            }
        }).iterator();
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof e) {
            return contains((e) obj);
        }
        return false;
    }
}
