package q7;

import q7.l;

/* compiled from: MaterialShapeDrawable.java */
/* loaded from: classes.dex */
public final class h implements l.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f17965a;

    public h(float f10) {
        this.f17965a = f10;
    }

    public c apply(c cVar) {
        return cVar instanceof j ? cVar : new b(this.f17965a, cVar);
    }
}
