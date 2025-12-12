package d3;

import android.content.Context;
import java.util.LinkedHashSet;
import mf.q;
import r.x;

/* compiled from: ConstraintTracker.kt */
/* loaded from: classes.dex */
public abstract class g<T> {

    /* renamed from: a, reason: collision with root package name */
    public final i3.c f10796a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f10797b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f10798c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet<b3.a<T>> f10799d;

    /* renamed from: e, reason: collision with root package name */
    public T f10800e;

    public g(Context context, i3.c cVar) {
        zf.i.checkNotNullParameter(context, "context");
        zf.i.checkNotNullParameter(cVar, "taskExecutor");
        this.f10796a = cVar;
        Context applicationContext = context.getApplicationContext();
        zf.i.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.f10797b = applicationContext;
        this.f10798c = new Object();
        this.f10799d = new LinkedHashSet<>();
    }

    public final void addListener(b3.a<T> aVar) {
        zf.i.checkNotNullParameter(aVar, "listener");
        synchronized (this.f10798c) {
            if (this.f10799d.add(aVar)) {
                if (this.f10799d.size() == 1) {
                    this.f10800e = getInitialState();
                    w2.g.get().debug(h.f10801a, getClass().getSimpleName() + ": initial state = " + this.f10800e);
                    startTracking();
                }
                aVar.onConstraintChanged(this.f10800e);
            }
            lf.h hVar = lf.h.f16056a;
        }
    }

    public final Context getAppContext() {
        return this.f10797b;
    }

    public abstract T getInitialState();

    public final void removeListener(b3.a<T> aVar) {
        zf.i.checkNotNullParameter(aVar, "listener");
        synchronized (this.f10798c) {
            if (this.f10799d.remove(aVar) && this.f10799d.isEmpty()) {
                stopTracking();
            }
            lf.h hVar = lf.h.f16056a;
        }
    }

    public final void setState(T t10) {
        synchronized (this.f10798c) {
            T t11 = this.f10800e;
            if (t11 == null || !zf.i.areEqual(t11, t10)) {
                this.f10800e = t10;
                ((i3.d) this.f10796a).getMainThreadExecutor().execute(new x(8, q.toList(this.f10799d), this));
                lf.h hVar = lf.h.f16056a;
            }
        }
    }

    public abstract void startTracking();

    public abstract void stopTracking();
}
