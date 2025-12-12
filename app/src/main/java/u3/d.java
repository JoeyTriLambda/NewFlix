package u3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: KeyPath.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final List<String> f19989a;

    /* renamed from: b, reason: collision with root package name */
    public e f19990b;

    public d(String... strArr) {
        this.f19989a = Arrays.asList(strArr);
    }

    public d addKey(String str) {
        d dVar = new d(this);
        dVar.f19989a.add(str);
        return dVar;
    }

    public boolean fullyResolvesTo(String str, int i10) {
        List<String> list = this.f19989a;
        if (i10 >= list.size()) {
            return false;
        }
        boolean z10 = i10 == list.size() - 1;
        String str2 = list.get(i10);
        if (!str2.equals("**")) {
            return (z10 || (i10 == list.size() + (-2) && list.get(list.size() + (-1)).equals("**"))) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z10 && list.get(i10 + 1).equals(str)) {
            return i10 == list.size() + (-2) || (i10 == list.size() + (-3) && list.get(list.size() + (-1)).equals("**"));
        }
        if (z10) {
            return true;
        }
        int i11 = i10 + 1;
        if (i11 < list.size() - 1) {
            return false;
        }
        return list.get(i11).equals(str);
    }

    public e getResolvedElement() {
        return this.f19990b;
    }

    public int incrementDepthBy(String str, int i10) {
        if ("__container".equals(str)) {
            return 0;
        }
        List<String> list = this.f19989a;
        if (list.get(i10).equals("**")) {
            return (i10 != list.size() - 1 && list.get(i10 + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean matches(String str, int i10) {
        if ("__container".equals(str)) {
            return true;
        }
        List<String> list = this.f19989a;
        if (i10 >= list.size()) {
            return false;
        }
        return list.get(i10).equals(str) || list.get(i10).equals("**") || list.get(i10).equals("*");
    }

    public boolean propagateToChildren(String str, int i10) {
        if ("__container".equals(str)) {
            return true;
        }
        List<String> list = this.f19989a;
        return i10 < list.size() - 1 || list.get(i10).equals("**");
    }

    public d resolve(e eVar) {
        d dVar = new d(this);
        dVar.f19990b = eVar;
        return dVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("KeyPath{keys=");
        sb2.append(this.f19989a);
        sb2.append(",resolved=");
        sb2.append(this.f19990b != null);
        sb2.append('}');
        return sb2.toString();
    }

    public d(d dVar) {
        this.f19989a = new ArrayList(dVar.f19989a);
        this.f19990b = dVar.f19990b;
    }
}
