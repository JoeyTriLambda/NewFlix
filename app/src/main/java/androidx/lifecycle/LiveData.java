package androidx.lifecycle;

import androidx.fragment.app.n;
import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f3437k = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Object f3438a;

    /* renamed from: b, reason: collision with root package name */
    public final z.b<s<? super T>, LiveData<T>.c> f3439b;

    /* renamed from: c, reason: collision with root package name */
    public int f3440c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3441d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f3442e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f3443f;

    /* renamed from: g, reason: collision with root package name */
    public int f3444g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3445h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3446i;

    /* renamed from: j, reason: collision with root package name */
    public final a f3447j;

    public class LifecycleBoundObserver extends LiveData<T>.c implements j {
        @Override // androidx.lifecycle.LiveData.c
        public final void b() {
            throw null;
        }

        @Override // androidx.lifecycle.LiveData.c
        public final boolean c() {
            throw null;
        }

        @Override // androidx.lifecycle.j
        public void onStateChanged(l lVar, Lifecycle.Event event) {
            throw null;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f3438a) {
                obj = LiveData.this.f3443f;
                LiveData.this.f3443f = LiveData.f3437k;
            }
            LiveData.this.setValue(obj);
        }
    }

    public class b extends LiveData<T>.c {
        public b(LiveData liveData, s<? super T> sVar) {
            super(sVar);
        }

        @Override // androidx.lifecycle.LiveData.c
        public final boolean c() {
            return true;
        }
    }

    public LiveData(T t10) {
        this.f3438a = new Object();
        this.f3439b = new z.b<>();
        this.f3440c = 0;
        this.f3443f = f3437k;
        this.f3447j = new a();
        this.f3442e = t10;
        this.f3444g = 0;
    }

    public static void a(String str) {
        if (!y.b.getInstance().isMainThread()) {
            throw new IllegalStateException(ac.c.k("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(LiveData<T>.c cVar) {
        if (cVar.f3450m) {
            if (!cVar.c()) {
                cVar.a(false);
                return;
            }
            int i10 = cVar.f3451n;
            int i11 = this.f3444g;
            if (i10 >= i11) {
                return;
            }
            cVar.f3451n = i11;
            ((n.d) cVar.f3449b).onChanged(this.f3442e);
        }
    }

    public final void c(LiveData<T>.c cVar) {
        if (this.f3445h) {
            this.f3446i = true;
            return;
        }
        this.f3445h = true;
        do {
            this.f3446i = false;
            if (cVar != null) {
                b(cVar);
                cVar = null;
            } else {
                z.b<s<? super T>, LiveData<T>.c>.d dVarIteratorWithAdditions = this.f3439b.iteratorWithAdditions();
                while (dVarIteratorWithAdditions.hasNext()) {
                    b((c) dVarIteratorWithAdditions.next().getValue());
                    if (this.f3446i) {
                        break;
                    }
                }
            }
        } while (this.f3446i);
        this.f3445h = false;
    }

    public void observeForever(s<? super T> sVar) {
        a("observeForever");
        b bVar = new b(this, sVar);
        LiveData<T>.c cVarPutIfAbsent = this.f3439b.putIfAbsent(sVar, bVar);
        if (cVarPutIfAbsent instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVarPutIfAbsent != null) {
            return;
        }
        bVar.a(true);
    }

    public void postValue(T t10) {
        boolean z10;
        synchronized (this.f3438a) {
            z10 = this.f3443f == f3437k;
            this.f3443f = t10;
        }
        if (z10) {
            y.b.getInstance().postToMainThread(this.f3447j);
        }
    }

    public void removeObserver(s<? super T> sVar) {
        a("removeObserver");
        LiveData<T>.c cVarRemove = this.f3439b.remove(sVar);
        if (cVarRemove == null) {
            return;
        }
        cVarRemove.b();
        cVarRemove.a(false);
    }

    public void setValue(T t10) {
        a("setValue");
        this.f3444g++;
        this.f3442e = t10;
        c(null);
    }

    public LiveData() {
        this.f3438a = new Object();
        this.f3439b = new z.b<>();
        this.f3440c = 0;
        Object obj = f3437k;
        this.f3443f = obj;
        this.f3447j = new a();
        this.f3442e = obj;
        this.f3444g = -1;
    }

    public abstract class c {

        /* renamed from: b, reason: collision with root package name */
        public final s<? super T> f3449b;

        /* renamed from: m, reason: collision with root package name */
        public boolean f3450m;

        /* renamed from: n, reason: collision with root package name */
        public int f3451n = -1;

        public c(s<? super T> sVar) {
            this.f3449b = sVar;
        }

        public final void a(boolean z10) {
            if (z10 == this.f3450m) {
                return;
            }
            this.f3450m = z10;
            int i10 = z10 ? 1 : -1;
            LiveData liveData = LiveData.this;
            int i11 = liveData.f3440c;
            liveData.f3440c = i10 + i11;
            if (!liveData.f3441d) {
                liveData.f3441d = true;
                while (true) {
                    try {
                        int i12 = liveData.f3440c;
                        if (i11 == i12) {
                            break;
                        }
                        boolean z11 = i11 == 0 && i12 > 0;
                        boolean z12 = i11 > 0 && i12 == 0;
                        if (z11) {
                            liveData.onActive();
                        } else if (z12) {
                            liveData.onInactive();
                        }
                        i11 = i12;
                    } finally {
                        liveData.f3441d = false;
                    }
                }
            }
            if (this.f3450m) {
                liveData.c(this);
            }
        }

        public abstract boolean c();

        public void b() {
        }
    }

    public void onActive() {
    }

    public void onInactive() {
    }
}
