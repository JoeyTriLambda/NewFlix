package p3;

import java.util.HashMap;
import java.util.Iterator;

/* compiled from: PerformanceTracker.java */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public boolean f17541a = false;

    /* renamed from: b, reason: collision with root package name */
    public final b0.d f17542b = new b0.d();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f17543c = new HashMap();

    /* compiled from: PerformanceTracker.java */
    public interface a {
        void onFrameRendered(float f10);
    }

    public void recordRenderTime(String str, float f10) {
        if (this.f17541a) {
            HashMap map = this.f17543c;
            a4.f fVar = (a4.f) map.get(str);
            if (fVar == null) {
                fVar = new a4.f();
                map.put(str, fVar);
            }
            fVar.add(f10);
            if (str.equals("__container")) {
                Iterator<E> it = this.f17542b.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).onFrameRendered(f10);
                }
            }
        }
    }
}
