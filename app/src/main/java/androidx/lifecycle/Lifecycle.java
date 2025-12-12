package androidx.lifecycle;

import com.unity3d.services.core.request.metrics.AdOperationMetric;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Lifecycle.kt */
/* loaded from: classes.dex */
public abstract class Lifecycle {

    /* compiled from: Lifecycle.kt */
    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static final a Companion = new a(null);

        /* compiled from: Lifecycle.kt */
        public static final class a {
            public a(zf.f fVar) {
            }

            public final Event downFrom(State state) {
                zf.i.checkNotNullParameter(state, AdOperationMetric.INIT_STATE);
                int iOrdinal = state.ordinal();
                if (iOrdinal == 2) {
                    return Event.ON_DESTROY;
                }
                if (iOrdinal == 3) {
                    return Event.ON_STOP;
                }
                if (iOrdinal != 4) {
                    return null;
                }
                return Event.ON_PAUSE;
            }

            public final Event upFrom(State state) {
                zf.i.checkNotNullParameter(state, AdOperationMetric.INIT_STATE);
                int iOrdinal = state.ordinal();
                if (iOrdinal == 1) {
                    return Event.ON_CREATE;
                }
                if (iOrdinal == 2) {
                    return Event.ON_START;
                }
                if (iOrdinal != 3) {
                    return null;
                }
                return Event.ON_RESUME;
            }

            public final Event upTo(State state) {
                zf.i.checkNotNullParameter(state, AdOperationMetric.INIT_STATE);
                int iOrdinal = state.ordinal();
                if (iOrdinal == 2) {
                    return Event.ON_CREATE;
                }
                if (iOrdinal == 3) {
                    return Event.ON_START;
                }
                if (iOrdinal != 4) {
                    return null;
                }
                return Event.ON_RESUME;
            }
        }

        /* compiled from: Lifecycle.kt */
        public /* synthetic */ class b {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f3430a;

            static {
                int[] iArr = new int[Event.values().length];
                try {
                    iArr[Event.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Event.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Event.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Event.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Event.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Event.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Event.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f3430a = iArr;
            }
        }

        public final State getTargetState() {
            switch (b.f3430a[ordinal()]) {
                case 1:
                case 2:
                    return State.CREATED;
                case 3:
                case 4:
                    return State.STARTED;
                case 5:
                    return State.RESUMED;
                case 6:
                    return State.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* compiled from: Lifecycle.kt */
    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean isAtLeast(State state) {
            zf.i.checkNotNullParameter(state, AdOperationMetric.INIT_STATE);
            return compareTo(state) >= 0;
        }
    }

    public Lifecycle() {
        new AtomicReference();
    }

    public abstract void addObserver(k kVar);

    public abstract State getCurrentState();

    public abstract void removeObserver(k kVar);
}
