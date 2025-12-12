package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: DefaultLifecycleObserverAdapter.kt */
/* loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements j {

    /* renamed from: b, reason: collision with root package name */
    public final c f3425b;

    /* renamed from: m, reason: collision with root package name */
    public final j f3426m;

    /* compiled from: DefaultLifecycleObserverAdapter.kt */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3427a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f3427a = iArr;
        }
    }

    public DefaultLifecycleObserverAdapter(c cVar, j jVar) {
        zf.i.checkNotNullParameter(cVar, "defaultLifecycleObserver");
        this.f3425b = cVar;
        this.f3426m = jVar;
    }

    @Override // androidx.lifecycle.j
    public void onStateChanged(l lVar, Lifecycle.Event event) {
        zf.i.checkNotNullParameter(lVar, "source");
        zf.i.checkNotNullParameter(event, "event");
        int i10 = a.f3427a[event.ordinal()];
        c cVar = this.f3425b;
        switch (i10) {
            case 1:
                cVar.onCreate(lVar);
                break;
            case 2:
                cVar.onStart(lVar);
                break;
            case 3:
                cVar.onResume(lVar);
                break;
            case 4:
                cVar.onPause(lVar);
                break;
            case 5:
                cVar.onStop(lVar);
                break;
            case 6:
                cVar.onDestroy(lVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        j jVar = this.f3426m;
        if (jVar != null) {
            jVar.onStateChanged(lVar, event);
        }
    }
}
