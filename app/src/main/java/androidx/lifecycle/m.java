package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.lifecycle.Lifecycle;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: LifecycleRegistry.kt */
/* loaded from: classes.dex */
public final class m extends Lifecycle {

    /* renamed from: i, reason: collision with root package name */
    public static final a f3491i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3492a;

    /* renamed from: b, reason: collision with root package name */
    public z.a<k, b> f3493b;

    /* renamed from: c, reason: collision with root package name */
    public Lifecycle.State f3494c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakReference<l> f3495d;

    /* renamed from: e, reason: collision with root package name */
    public int f3496e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3497f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3498g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList<Lifecycle.State> f3499h;

    /* compiled from: LifecycleRegistry.kt */
    public static final class a {
        public a(zf.f fVar) {
        }

        public final Lifecycle.State min$lifecycle_runtime_release(Lifecycle.State state, Lifecycle.State state2) {
            zf.i.checkNotNullParameter(state, "state1");
            return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
        }
    }

    /* compiled from: LifecycleRegistry.kt */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public Lifecycle.State f3500a;

        /* renamed from: b, reason: collision with root package name */
        public final j f3501b;

        public b(k kVar, Lifecycle.State state) {
            zf.i.checkNotNullParameter(state, "initialState");
            zf.i.checkNotNull(kVar);
            this.f3501b = p.lifecycleEventObserver(kVar);
            this.f3500a = state;
        }

        public final void dispatchEvent(l lVar, Lifecycle.Event event) {
            zf.i.checkNotNullParameter(event, "event");
            Lifecycle.State targetState = event.getTargetState();
            this.f3500a = m.f3491i.min$lifecycle_runtime_release(this.f3500a, targetState);
            zf.i.checkNotNull(lVar);
            this.f3501b.onStateChanged(lVar, event);
            this.f3500a = targetState;
        }

        public final Lifecycle.State getState() {
            return this.f3500a;
        }
    }

    public m(l lVar) {
        zf.i.checkNotNullParameter(lVar, "provider");
        this.f3492a = true;
        this.f3493b = new z.a<>();
        this.f3494c = Lifecycle.State.INITIALIZED;
        this.f3499h = new ArrayList<>();
        this.f3495d = new WeakReference<>(lVar);
    }

    public final Lifecycle.State a(k kVar) {
        b value;
        Map.Entry<k, b> entryCeil = this.f3493b.ceil(kVar);
        Lifecycle.State state = (entryCeil == null || (value = entryCeil.getValue()) == null) ? null : value.getState();
        ArrayList<Lifecycle.State> arrayList = this.f3499h;
        Lifecycle.State state2 = arrayList.isEmpty() ^ true ? arrayList.get(arrayList.size() - 1) : null;
        Lifecycle.State state3 = this.f3494c;
        a aVar = f3491i;
        return aVar.min$lifecycle_runtime_release(aVar.min$lifecycle_runtime_release(state3, state), state2);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(k kVar) {
        l lVar;
        zf.i.checkNotNullParameter(kVar, "observer");
        b("addObserver");
        Lifecycle.State state = this.f3494c;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        b bVar = new b(kVar, state2);
        if (this.f3493b.putIfAbsent(kVar, bVar) == null && (lVar = this.f3495d.get()) != null) {
            boolean z10 = this.f3496e != 0 || this.f3497f;
            Lifecycle.State stateA = a(kVar);
            this.f3496e++;
            while (bVar.getState().compareTo(stateA) < 0 && this.f3493b.contains(kVar)) {
                Lifecycle.State state3 = bVar.getState();
                ArrayList<Lifecycle.State> arrayList = this.f3499h;
                arrayList.add(state3);
                Lifecycle.Event eventUpFrom = Lifecycle.Event.Companion.upFrom(bVar.getState());
                if (eventUpFrom == null) {
                    throw new IllegalStateException("no event up from " + bVar.getState());
                }
                bVar.dispatchEvent(lVar, eventUpFrom);
                arrayList.remove(arrayList.size() - 1);
                stateA = a(kVar);
            }
            if (!z10) {
                d();
            }
            this.f3496e--;
        }
    }

    @SuppressLint({"RestrictedApi"})
    public final void b(String str) {
        if (this.f3492a && !y.b.getInstance().isMainThread()) {
            throw new IllegalStateException(ac.c.k("Method ", str, " must be called on the main thread").toString());
        }
    }

    public final void c(Lifecycle.State state) {
        Lifecycle.State state2 = this.f3494c;
        if (state2 == state) {
            return;
        }
        Lifecycle.State state3 = Lifecycle.State.INITIALIZED;
        Lifecycle.State state4 = Lifecycle.State.DESTROYED;
        if (!((state2 == state3 && state == state4) ? false : true)) {
            throw new IllegalStateException(("no event down from " + this.f3494c + " in component " + this.f3495d.get()).toString());
        }
        this.f3494c = state;
        if (this.f3497f || this.f3496e != 0) {
            this.f3498g = true;
            return;
        }
        this.f3497f = true;
        d();
        this.f3497f = false;
        if (this.f3494c == state4) {
            this.f3493b = new z.a<>();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d() {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.m.d():void");
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State getCurrentState() {
        return this.f3494c;
    }

    public void handleLifecycleEvent(Lifecycle.Event event) {
        zf.i.checkNotNullParameter(event, "event");
        b("handleLifecycleEvent");
        c(event.getTargetState());
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(k kVar) {
        zf.i.checkNotNullParameter(kVar, "observer");
        b("removeObserver");
        this.f3493b.remove(kVar);
    }

    public void setCurrentState(Lifecycle.State state) {
        zf.i.checkNotNullParameter(state, AdOperationMetric.INIT_STATE);
        b("setCurrentState");
        c(state);
    }
}
