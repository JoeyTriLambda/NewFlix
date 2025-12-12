package r3;

import android.graphics.Path;
import java.util.ArrayList;

/* compiled from: CompoundTrimPathContent.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f18465a = new ArrayList();

    public void apply(Path path) {
        ArrayList arrayList = this.f18465a;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                a4.h.applyTrimPathIfNeeded(path, (s) arrayList.get(size));
            }
        }
    }
}
