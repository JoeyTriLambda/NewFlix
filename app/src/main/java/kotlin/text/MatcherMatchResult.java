package kotlin.text;

import ig.f;
import java.util.List;
import java.util.regex.Matcher;
import zf.i;

/* compiled from: Regex.kt */
/* loaded from: classes2.dex */
public final class MatcherMatchResult implements f {

    /* renamed from: a, reason: collision with root package name */
    public final Matcher f15265a;

    /* renamed from: b, reason: collision with root package name */
    public a f15266b;

    /* compiled from: Regex.kt */
    public static final class a extends mf.a<String> {
        public a() {
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return contains((String) obj);
            }
            return false;
        }

        @Override // kotlin.collections.AbstractCollection
        public int getSize() {
            return MatcherMatchResult.this.f15265a.groupCount() + 1;
        }

        @Override // mf.a, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return indexOf((String) obj);
            }
            return -1;
        }

        @Override // mf.a, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return lastIndexOf((String) obj);
            }
            return -1;
        }

        public /* bridge */ boolean contains(String str) {
            return super.contains((a) str);
        }

        @Override // mf.a, java.util.List
        public String get(int i10) {
            String strGroup = MatcherMatchResult.this.f15265a.group(i10);
            return strGroup == null ? "" : strGroup;
        }

        public /* bridge */ int indexOf(String str) {
            return super.indexOf((a) str);
        }

        public /* bridge */ int lastIndexOf(String str) {
            return super.lastIndexOf((a) str);
        }
    }

    public MatcherMatchResult(Matcher matcher, CharSequence charSequence) {
        i.checkNotNullParameter(matcher, "matcher");
        i.checkNotNullParameter(charSequence, "input");
        this.f15265a = matcher;
        new MatcherMatchResult$groups$1(this);
    }

    @Override // ig.f
    public List<String> getGroupValues() {
        if (this.f15266b == null) {
            this.f15266b = new a();
        }
        a aVar = this.f15266b;
        i.checkNotNull(aVar);
        return aVar;
    }

    @Override // ig.f
    public String getValue() {
        String strGroup = this.f15265a.group();
        i.checkNotNullExpressionValue(strGroup, "matchResult.group()");
        return strGroup;
    }
}
