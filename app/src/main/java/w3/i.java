package w3;

import java.util.Arrays;
import java.util.List;

/* compiled from: ShapeGroup.java */
/* loaded from: classes.dex */
public final class i implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f20926a;

    /* renamed from: b, reason: collision with root package name */
    public final List<b> f20927b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f20928c;

    public i(String str, List<b> list, boolean z10) {
        this.f20926a = str;
        this.f20927b = list;
        this.f20928c = z10;
    }

    public List<b> getItems() {
        return this.f20927b;
    }

    public String getName() {
        return this.f20926a;
    }

    public boolean isHidden() {
        return this.f20928c;
    }

    @Override // w3.b
    public r3.c toContent(p3.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r3.d(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f20926a + "' Shapes: " + Arrays.toString(this.f20927b.toArray()) + '}';
    }
}
