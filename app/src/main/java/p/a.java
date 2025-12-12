package p;

import android.content.Context;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import zf.i;

/* compiled from: ContextAwareHelper.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet f17402a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    public volatile Context f17403b;

    public final void addOnContextAvailableListener(b bVar) {
        i.checkNotNullParameter(bVar, "listener");
        Context context = this.f17403b;
        if (context != null) {
            bVar.onContextAvailable(context);
        }
        this.f17402a.add(bVar);
    }

    public final void clearAvailableContext() {
        this.f17403b = null;
    }

    public final void dispatchOnContextAvailable(Context context) {
        i.checkNotNullParameter(context, "context");
        this.f17403b = context;
        Iterator it = this.f17402a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).onContextAvailable(context);
        }
    }
}
