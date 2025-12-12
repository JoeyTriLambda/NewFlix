package r;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: LayoutIncludeDetector.java */
/* loaded from: classes.dex */
public class z {

    /* renamed from: b, reason: collision with root package name */
    public Serializable f18349b;

    public z(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                this.f18349b = new ArrayDeque();
            } else {
                this.f18349b = new AtomicInteger();
            }
        }
    }
}
