package q7;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q7.o;

/* compiled from: ShapePath.java */
/* loaded from: classes.dex */
public final class n extends o.f {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f18005c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Matrix f18006d;

    public n(ArrayList arrayList, Matrix matrix) {
        this.f18005c = arrayList;
        this.f18006d = matrix;
    }

    @Override // q7.o.f
    public void draw(Matrix matrix, p7.a aVar, int i10, Canvas canvas) {
        Iterator it = this.f18005c.iterator();
        while (it.hasNext()) {
            ((o.f) it.next()).draw(this.f18006d, aVar, i10, canvas);
        }
    }
}
