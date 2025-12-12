package androidx.leanback.widget;

import android.util.Property;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Parallax.java */
/* loaded from: classes.dex */
public abstract class c0<PropertyT extends Property> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3194a;

    /* renamed from: b, reason: collision with root package name */
    public final List<PropertyT> f3195b;

    /* renamed from: c, reason: collision with root package name */
    public final float[] f3196c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f3197d;

    public c0() {
        ArrayList arrayList = new ArrayList();
        this.f3194a = arrayList;
        this.f3195b = Collections.unmodifiableList(arrayList);
        this.f3196c = new float[4];
        this.f3197d = new ArrayList(4);
    }

    public void updateValues() {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f3197d;
            if (i10 >= arrayList.size()) {
                return;
            }
            ((d0) arrayList.get(i10)).performMapping(this);
            i10++;
        }
    }
}
