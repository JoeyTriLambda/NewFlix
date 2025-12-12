package u3;

import java.util.List;
import w3.i;

/* compiled from: FontCharacter.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final List<i> f19984a;

    /* renamed from: b, reason: collision with root package name */
    public final char f19985b;

    /* renamed from: c, reason: collision with root package name */
    public final double f19986c;

    /* renamed from: d, reason: collision with root package name */
    public final String f19987d;

    /* renamed from: e, reason: collision with root package name */
    public final String f19988e;

    public c(List<i> list, char c10, double d10, double d11, String str, String str2) {
        this.f19984a = list;
        this.f19985b = c10;
        this.f19986c = d11;
        this.f19987d = str;
        this.f19988e = str2;
    }

    public static int hashFor(char c10, String str, String str2) {
        return str2.hashCode() + ac.c.b(str, (c10 + 0) * 31, 31);
    }

    public List<i> getShapes() {
        return this.f19984a;
    }

    public double getWidth() {
        return this.f19986c;
    }

    public int hashCode() {
        return hashFor(this.f19985b, this.f19988e, this.f19987d);
    }
}
