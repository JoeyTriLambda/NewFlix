package oh;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import zf.i;

/* compiled from: ExtensionManager.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<String, b> f17099a;

    public a(kh.a aVar) {
        i.checkNotNullParameter(aVar, "_koin");
        this.f17099a = new HashMap<>();
    }

    public final void close() {
        Collection<b> collectionValues = this.f17099a.values();
        i.checkNotNullExpressionValue(collectionValues, "extensions.values");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((b) it.next()).onClose();
        }
    }
}
