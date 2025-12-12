package x5;

import java.util.Collections;
import java.util.List;

/* compiled from: AdaptationSet.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f21557a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21558b;

    /* renamed from: c, reason: collision with root package name */
    public final List<g> f21559c;

    /* renamed from: d, reason: collision with root package name */
    public final List<d> f21560d;

    /* renamed from: e, reason: collision with root package name */
    public final List<d> f21561e;

    public a(int i10, int i11, List<g> list, List<d> list2, List<d> list3) {
        this.f21557a = i10;
        this.f21558b = i11;
        this.f21559c = Collections.unmodifiableList(list);
        this.f21560d = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f21561e = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
    }
}
