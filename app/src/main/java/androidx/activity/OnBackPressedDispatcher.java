package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.Lifecycle;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: OnBackPressedDispatcher.kt */
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f776a;

    /* renamed from: b, reason: collision with root package name */
    public final w0.a<Boolean> f777b;

    /* renamed from: c, reason: collision with root package name */
    public final mf.f<k> f778c;

    /* renamed from: d, reason: collision with root package name */
    public k f779d;

    /* renamed from: e, reason: collision with root package name */
    public final OnBackInvokedCallback f780e;

    /* renamed from: f, reason: collision with root package name */
    public OnBackInvokedDispatcher f781f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f782g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f783h;

    /* compiled from: OnBackPressedDispatcher.kt */
    public final class LifecycleOnBackPressedCancellable implements androidx.lifecycle.j, androidx.activity.c {

        /* renamed from: b, reason: collision with root package name */
        public final Lifecycle f789b;

        /* renamed from: m, reason: collision with root package name */
        public final k f790m;

        /* renamed from: n, reason: collision with root package name */
        public androidx.activity.c f791n;

        /* renamed from: o, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f792o;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, k kVar) {
            zf.i.checkNotNullParameter(lifecycle, "lifecycle");
            zf.i.checkNotNullParameter(kVar, "onBackPressedCallback");
            this.f792o = onBackPressedDispatcher;
            this.f789b = lifecycle;
            this.f790m = kVar;
            lifecycle.addObserver(this);
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f789b.removeObserver(this);
            this.f790m.removeCancellable(this);
            androidx.activity.c cVar = this.f791n;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f791n = null;
        }

        @Override // androidx.lifecycle.j
        public void onStateChanged(androidx.lifecycle.l lVar, Lifecycle.Event event) {
            zf.i.checkNotNullParameter(lVar, "source");
            zf.i.checkNotNullParameter(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.f791n = this.f792o.addCancellableCallback$activity_release(this.f790m);
                return;
            }
            if (event != Lifecycle.Event.ON_STOP) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.c cVar = this.f791n;
                if (cVar != null) {
                    cVar.cancel();
                }
            }
        }
    }

    /* compiled from: OnBackPressedDispatcher.kt */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f793a = new a();

        public final OnBackInvokedCallback createOnBackInvokedCallback(yf.a<lf.h> aVar) {
            zf.i.checkNotNullParameter(aVar, "onBackInvoked");
            return new l(aVar, 0);
        }

        public final void registerOnBackInvokedCallback(Object obj, int i10, Object obj2) {
            zf.i.checkNotNullParameter(obj, "dispatcher");
            zf.i.checkNotNullParameter(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i10, (OnBackInvokedCallback) obj2);
        }

        public final void unregisterOnBackInvokedCallback(Object obj, Object obj2) {
            zf.i.checkNotNullParameter(obj, "dispatcher");
            zf.i.checkNotNullParameter(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* compiled from: OnBackPressedDispatcher.kt */
    /* renamed from: androidx.activity.OnBackPressedDispatcher$addCallback$1, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C03381 extends FunctionReferenceImpl implements yf.a<lf.h> {
        public C03381(Object obj) {
            super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        @Override // yf.a
        public /* bridge */ /* synthetic */ lf.h invoke() {
            invoke2();
            return lf.h.f16056a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((OnBackPressedDispatcher) this.f15250m).b();
        }
    }

    /* compiled from: OnBackPressedDispatcher.kt */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f794a = new b();

        /* compiled from: OnBackPressedDispatcher.kt */
        public static final class a implements OnBackAnimationCallback {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ yf.l<androidx.activity.b, lf.h> f795a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ yf.l<androidx.activity.b, lf.h> f796b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ yf.a<lf.h> f797c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ yf.a<lf.h> f798d;

            /* JADX WARN: Multi-variable type inference failed */
            public a(yf.l<? super androidx.activity.b, lf.h> lVar, yf.l<? super androidx.activity.b, lf.h> lVar2, yf.a<lf.h> aVar, yf.a<lf.h> aVar2) {
                this.f795a = lVar;
                this.f796b = lVar2;
                this.f797c = aVar;
                this.f798d = aVar2;
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackCancelled() {
                this.f798d.invoke();
            }

            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                this.f797c.invoke();
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackProgressed(BackEvent backEvent) {
                zf.i.checkNotNullParameter(backEvent, "backEvent");
                this.f796b.invoke(new androidx.activity.b(backEvent));
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackStarted(BackEvent backEvent) {
                zf.i.checkNotNullParameter(backEvent, "backEvent");
                this.f795a.invoke(new androidx.activity.b(backEvent));
            }
        }

        public final OnBackInvokedCallback createOnBackAnimationCallback(yf.l<? super androidx.activity.b, lf.h> lVar, yf.l<? super androidx.activity.b, lf.h> lVar2, yf.a<lf.h> aVar, yf.a<lf.h> aVar2) {
            zf.i.checkNotNullParameter(lVar, "onBackStarted");
            zf.i.checkNotNullParameter(lVar2, "onBackProgressed");
            zf.i.checkNotNullParameter(aVar, "onBackInvoked");
            zf.i.checkNotNullParameter(aVar2, "onBackCancelled");
            return new a(lVar, lVar2, aVar, aVar2);
        }
    }

    /* compiled from: OnBackPressedDispatcher.kt */
    public final class c implements androidx.activity.c {

        /* renamed from: b, reason: collision with root package name */
        public final k f799b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f800m;

        public c(OnBackPressedDispatcher onBackPressedDispatcher, k kVar) {
            zf.i.checkNotNullParameter(kVar, "onBackPressedCallback");
            this.f800m = onBackPressedDispatcher;
            this.f799b = kVar;
        }

        @Override // androidx.activity.c
        public void cancel() {
            OnBackPressedDispatcher onBackPressedDispatcher = this.f800m;
            mf.f fVar = onBackPressedDispatcher.f778c;
            k kVar = this.f799b;
            fVar.remove(kVar);
            if (zf.i.areEqual(onBackPressedDispatcher.f779d, kVar)) {
                kVar.handleOnBackCancelled();
                onBackPressedDispatcher.f779d = null;
            }
            kVar.removeCancellable(this);
            yf.a<lf.h> enabledChangedCallback$activity_release = kVar.getEnabledChangedCallback$activity_release();
            if (enabledChangedCallback$activity_release != null) {
                enabledChangedCallback$activity_release.invoke();
            }
            kVar.setEnabledChangedCallback$activity_release(null);
        }
    }

    public OnBackPressedDispatcher() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final void access$onBackCancelled(OnBackPressedDispatcher onBackPressedDispatcher) {
        k kVarPrevious;
        mf.f<k> fVar = onBackPressedDispatcher.f778c;
        ListIterator<k> listIterator = fVar.listIterator(fVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                kVarPrevious = null;
                break;
            } else {
                kVarPrevious = listIterator.previous();
                if (kVarPrevious.isEnabled()) {
                    break;
                }
            }
        }
        k kVar = kVarPrevious;
        onBackPressedDispatcher.f779d = null;
        if (kVar != null) {
            kVar.handleOnBackCancelled();
        }
    }

    public static final void access$onBackProgressed(OnBackPressedDispatcher onBackPressedDispatcher, androidx.activity.b bVar) {
        k kVarPrevious;
        mf.f<k> fVar = onBackPressedDispatcher.f778c;
        ListIterator<k> listIterator = fVar.listIterator(fVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                kVarPrevious = null;
                break;
            } else {
                kVarPrevious = listIterator.previous();
                if (kVarPrevious.isEnabled()) {
                    break;
                }
            }
        }
        k kVar = kVarPrevious;
        if (kVar != null) {
            kVar.handleOnBackProgressed(bVar);
        }
    }

    public static final void access$onBackStarted(OnBackPressedDispatcher onBackPressedDispatcher, androidx.activity.b bVar) {
        k kVarPrevious;
        mf.f<k> fVar = onBackPressedDispatcher.f778c;
        ListIterator<k> listIterator = fVar.listIterator(fVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                kVarPrevious = null;
                break;
            } else {
                kVarPrevious = listIterator.previous();
                if (kVarPrevious.isEnabled()) {
                    break;
                }
            }
        }
        k kVar = kVarPrevious;
        onBackPressedDispatcher.f779d = kVar;
        if (kVar != null) {
            kVar.handleOnBackStarted(bVar);
        }
    }

    public final void a(boolean z10) {
        OnBackInvokedCallback onBackInvokedCallback;
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f781f;
        if (onBackInvokedDispatcher == null || (onBackInvokedCallback = this.f780e) == null) {
            return;
        }
        a aVar = a.f793a;
        if (z10 && !this.f782g) {
            aVar.registerOnBackInvokedCallback(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f782g = true;
        } else {
            if (z10 || !this.f782g) {
                return;
            }
            aVar.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f782g = false;
        }
    }

    public final void addCallback(androidx.lifecycle.l lVar, k kVar) {
        zf.i.checkNotNullParameter(lVar, "owner");
        zf.i.checkNotNullParameter(kVar, "onBackPressedCallback");
        Lifecycle lifecycle = lVar.getLifecycle();
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        kVar.addCancellable(new LifecycleOnBackPressedCancellable(this, lifecycle, kVar));
        b();
        kVar.setEnabledChangedCallback$activity_release(new C03381(this));
    }

    public final androidx.activity.c addCancellableCallback$activity_release(k kVar) {
        zf.i.checkNotNullParameter(kVar, "onBackPressedCallback");
        this.f778c.add(kVar);
        c cVar = new c(this, kVar);
        kVar.addCancellable(cVar);
        b();
        kVar.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return cVar;
    }

    public final void b() {
        boolean z10 = this.f783h;
        mf.f<k> fVar = this.f778c;
        boolean z11 = false;
        if (!(fVar instanceof Collection) || !fVar.isEmpty()) {
            Iterator<k> it = fVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().isEnabled()) {
                    z11 = true;
                    break;
                }
            }
        }
        this.f783h = z11;
        if (z11 != z10) {
            w0.a<Boolean> aVar = this.f777b;
            if (aVar != null) {
                aVar.accept(Boolean.valueOf(z11));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                a(z11);
            }
        }
    }

    public final void onBackPressed() {
        k kVarPrevious;
        mf.f<k> fVar = this.f778c;
        ListIterator<k> listIterator = fVar.listIterator(fVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                kVarPrevious = null;
                break;
            } else {
                kVarPrevious = listIterator.previous();
                if (kVarPrevious.isEnabled()) {
                    break;
                }
            }
        }
        k kVar = kVarPrevious;
        this.f779d = null;
        if (kVar != null) {
            kVar.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.f776a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void setOnBackInvokedDispatcher(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        zf.i.checkNotNullParameter(onBackInvokedDispatcher, "invoker");
        this.f781f = onBackInvokedDispatcher;
        a(this.f783h);
    }

    public OnBackPressedDispatcher(Runnable runnable, w0.a<Boolean> aVar) {
        this.f776a = runnable;
        this.f777b = aVar;
        this.f778c = new mf.f<>();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            this.f780e = i10 >= 34 ? b.f794a.createOnBackAnimationCallback(new yf.l<androidx.activity.b, lf.h>() { // from class: androidx.activity.OnBackPressedDispatcher.1
                {
                    super(1);
                }

                @Override // yf.l
                public /* bridge */ /* synthetic */ lf.h invoke(androidx.activity.b bVar) {
                    invoke2(bVar);
                    return lf.h.f16056a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(androidx.activity.b bVar) {
                    zf.i.checkNotNullParameter(bVar, "backEvent");
                    OnBackPressedDispatcher.access$onBackStarted(OnBackPressedDispatcher.this, bVar);
                }
            }, new yf.l<androidx.activity.b, lf.h>() { // from class: androidx.activity.OnBackPressedDispatcher.2
                {
                    super(1);
                }

                @Override // yf.l
                public /* bridge */ /* synthetic */ lf.h invoke(androidx.activity.b bVar) {
                    invoke2(bVar);
                    return lf.h.f16056a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(androidx.activity.b bVar) {
                    zf.i.checkNotNullParameter(bVar, "backEvent");
                    OnBackPressedDispatcher.access$onBackProgressed(OnBackPressedDispatcher.this, bVar);
                }
            }, new yf.a<lf.h>() { // from class: androidx.activity.OnBackPressedDispatcher.3
                {
                    super(0);
                }

                @Override // yf.a
                public /* bridge */ /* synthetic */ lf.h invoke() {
                    invoke2();
                    return lf.h.f16056a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    OnBackPressedDispatcher.this.onBackPressed();
                }
            }, new yf.a<lf.h>() { // from class: androidx.activity.OnBackPressedDispatcher.4
                {
                    super(0);
                }

                @Override // yf.a
                public /* bridge */ /* synthetic */ lf.h invoke() {
                    invoke2();
                    return lf.h.f16056a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    OnBackPressedDispatcher.access$onBackCancelled(OnBackPressedDispatcher.this);
                }
            }) : a.f793a.createOnBackInvokedCallback(new yf.a<lf.h>() { // from class: androidx.activity.OnBackPressedDispatcher.5
                {
                    super(0);
                }

                @Override // yf.a
                public /* bridge */ /* synthetic */ lf.h invoke() {
                    invoke2();
                    return lf.h.f16056a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    OnBackPressedDispatcher.this.onBackPressed();
                }
            });
        }
    }

    public /* synthetic */ OnBackPressedDispatcher(Runnable runnable, int i10, zf.f fVar) {
        this((i10 & 1) != 0 ? null : runnable);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this(runnable, null);
    }
}
