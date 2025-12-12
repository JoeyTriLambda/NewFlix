package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.a0;
import androidx.lifecycle.d0;
import androidx.lifecycle.e0;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import l0.u;
import l0.v;
import l0.x;
import q.a;

/* loaded from: classes.dex */
public class ComponentActivity extends l0.j implements e0, androidx.lifecycle.f, j2.c, m, androidx.activity.result.e, m0.b, m0.c, u, v, x0.l, j {
    public boolean A;
    public boolean B;

    /* renamed from: n, reason: collision with root package name */
    public final x0.m f740n;

    /* renamed from: p, reason: collision with root package name */
    public final j2.b f742p;

    /* renamed from: q, reason: collision with root package name */
    public d0 f743q;

    /* renamed from: r, reason: collision with root package name */
    public OnBackPressedDispatcher f744r;

    /* renamed from: s, reason: collision with root package name */
    public final f f745s;

    /* renamed from: t, reason: collision with root package name */
    public final i f746t;

    /* renamed from: u, reason: collision with root package name */
    public final a f747u;

    /* renamed from: v, reason: collision with root package name */
    public final CopyOnWriteArrayList<w0.a<Configuration>> f748v;

    /* renamed from: w, reason: collision with root package name */
    public final CopyOnWriteArrayList<w0.a<Integer>> f749w;

    /* renamed from: x, reason: collision with root package name */
    public final CopyOnWriteArrayList<w0.a<Intent>> f750x;

    /* renamed from: y, reason: collision with root package name */
    public final CopyOnWriteArrayList<w0.a<l0.l>> f751y;

    /* renamed from: z, reason: collision with root package name */
    public final CopyOnWriteArrayList<w0.a<x>> f752z;

    /* renamed from: m, reason: collision with root package name */
    public final p.a f739m = new p.a();

    /* renamed from: o, reason: collision with root package name */
    public final androidx.lifecycle.m f741o = new androidx.lifecycle.m(this);

    public class a extends androidx.activity.result.d {

        /* renamed from: androidx.activity.ComponentActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0012a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f758b;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ a.C0227a f759m;

            public RunnableC0012a(int i10, a.C0227a c0227a) {
                this.f758b = i10;
                this.f759m = c0227a;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.dispatchResult(this.f758b, this.f759m.getValue());
            }
        }

        public class b implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f761b;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ IntentSender.SendIntentException f762m;

            public b(int i10, IntentSender.SendIntentException sendIntentException) {
                this.f761b = i10;
                this.f762m = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.dispatchResult(this.f761b, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f762m));
            }
        }

        public a() {
        }

        @Override // androidx.activity.result.d
        public <I, O> void onLaunch(int i10, q.a<I, O> aVar, I i11, l0.c cVar) {
            Bundle bundle;
            ComponentActivity componentActivity = ComponentActivity.this;
            a.C0227a<O> synchronousResult = aVar.getSynchronousResult(componentActivity, i11);
            if (synchronousResult != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0012a(i10, synchronousResult));
                return;
            }
            Intent intentCreateIntent = aVar.createIntent(componentActivity, i11);
            if (intentCreateIntent.getExtras() != null && intentCreateIntent.getExtras().getClassLoader() == null) {
                intentCreateIntent.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (intentCreateIntent.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                Bundle bundleExtra = intentCreateIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                intentCreateIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                bundle = bundleExtra;
            } else {
                bundle = null;
            }
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentCreateIntent.getAction())) {
                String[] stringArrayExtra = intentCreateIntent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                l0.a.requestPermissions(componentActivity, stringArrayExtra, i10);
                return;
            }
            if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentCreateIntent.getAction())) {
                l0.a.startActivityForResult(componentActivity, intentCreateIntent, i10, bundle);
                return;
            }
            androidx.activity.result.f fVar = (androidx.activity.result.f) intentCreateIntent.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                l0.a.startIntentSenderForResult(componentActivity, fVar.getIntentSender(), i10, fVar.getFillInIntent(), fVar.getFlagsMask(), fVar.getFlagsValues(), 0, bundle);
            } catch (IntentSender.SendIntentException e10) {
                new Handler(Looper.getMainLooper()).post(new b(i10, e10));
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e10) {
                if (!TextUtils.equals(e10.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e10;
                }
            } catch (NullPointerException e11) {
                if (!TextUtils.equals(e11.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                    throw e11;
                }
            }
        }
    }

    public static class c {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public Object f765a;

        /* renamed from: b, reason: collision with root package name */
        public d0 f766b;
    }

    public interface e extends Executor {
        void activityDestroyed();

        void viewCreated(View view);
    }

    public class f implements e, ViewTreeObserver.OnDrawListener, Runnable {

        /* renamed from: m, reason: collision with root package name */
        public Runnable f768m;

        /* renamed from: b, reason: collision with root package name */
        public final long f767b = SystemClock.uptimeMillis() + 10000;

        /* renamed from: n, reason: collision with root package name */
        public boolean f769n = false;

        public f() {
        }

        @Override // androidx.activity.ComponentActivity.e
        public void activityDestroyed() {
            ComponentActivity componentActivity = ComponentActivity.this;
            componentActivity.getWindow().getDecorView().removeCallbacks(this);
            componentActivity.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f768m = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            if (!this.f769n) {
                decorView.postOnAnimation(new androidx.activity.d(this, 1));
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f768m;
            ComponentActivity componentActivity = ComponentActivity.this;
            if (runnable == null) {
                if (SystemClock.uptimeMillis() > this.f767b) {
                    this.f769n = false;
                    componentActivity.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            runnable.run();
            this.f768m = null;
            if (componentActivity.f746t.isFullyDrawnReported()) {
                this.f769n = false;
                componentActivity.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // androidx.activity.ComponentActivity.e
        public void viewCreated(View view) {
            if (this.f769n) {
                return;
            }
            this.f769n = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }
    }

    public ComponentActivity() {
        int i10 = 0;
        this.f740n = new x0.m(new androidx.activity.d(this, i10));
        j2.b bVarCreate = j2.b.create(this);
        this.f742p = bVarCreate;
        this.f744r = null;
        f fVar = new f();
        this.f745s = fVar;
        this.f746t = new i(fVar, new yf.a() { // from class: androidx.activity.e
            @Override // yf.a
            public final Object invoke() {
                this.f808b.reportFullyDrawn();
                return null;
            }
        });
        new AtomicInteger();
        this.f747u = new a();
        this.f748v = new CopyOnWriteArrayList<>();
        this.f749w = new CopyOnWriteArrayList<>();
        this.f750x = new CopyOnWriteArrayList<>();
        this.f751y = new CopyOnWriteArrayList<>();
        this.f752z = new CopyOnWriteArrayList<>();
        this.A = false;
        this.B = false;
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i11 = Build.VERSION.SDK_INT;
        getLifecycle().addObserver(new androidx.lifecycle.j() { // from class: androidx.activity.ComponentActivity.2
            @Override // androidx.lifecycle.j
            public void onStateChanged(androidx.lifecycle.l lVar, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                    if (viewPeekDecorView != null) {
                        viewPeekDecorView.cancelPendingInputEvents();
                    }
                }
            }
        });
        getLifecycle().addObserver(new androidx.lifecycle.j() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.j
            public void onStateChanged(androidx.lifecycle.l lVar, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    ComponentActivity componentActivity = ComponentActivity.this;
                    componentActivity.f739m.clearAvailableContext();
                    if (!componentActivity.isChangingConfigurations()) {
                        componentActivity.getViewModelStore().clear();
                    }
                    componentActivity.f745s.activityDestroyed();
                }
            }
        });
        getLifecycle().addObserver(new androidx.lifecycle.j() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.j
            public void onStateChanged(androidx.lifecycle.l lVar, Lifecycle.Event event) {
                ComponentActivity componentActivity = ComponentActivity.this;
                if (componentActivity.f743q == null) {
                    d dVar = (d) componentActivity.getLastNonConfigurationInstance();
                    if (dVar != null) {
                        componentActivity.f743q = dVar.f766b;
                    }
                    if (componentActivity.f743q == null) {
                        componentActivity.f743q = new d0();
                    }
                }
                componentActivity.getLifecycle().removeObserver(this);
            }
        });
        bVarCreate.performAttach();
        SavedStateHandleSupport.enableSavedStateHandles(this);
        if (i11 <= 23) {
            getLifecycle().addObserver(new ImmLeaksCleaner(this));
        }
        getSavedStateRegistry().registerSavedStateProvider("android:support:activity-result", new androidx.activity.f(this, i10));
        addOnContextAvailableListener(new g(this, i10));
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.f745s.viewCreated(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // x0.l
    public void addMenuProvider(x0.o oVar) {
        this.f740n.addMenuProvider(oVar);
    }

    @Override // m0.b
    public final void addOnConfigurationChangedListener(w0.a<Configuration> aVar) {
        this.f748v.add(aVar);
    }

    public final void addOnContextAvailableListener(p.b bVar) {
        this.f739m.addOnContextAvailableListener(bVar);
    }

    @Override // l0.u
    public final void addOnMultiWindowModeChangedListener(w0.a<l0.l> aVar) {
        this.f751y.add(aVar);
    }

    public final void addOnNewIntentListener(w0.a<Intent> aVar) {
        this.f750x.add(aVar);
    }

    @Override // l0.v
    public final void addOnPictureInPictureModeChangedListener(w0.a<x> aVar) {
        this.f752z.add(aVar);
    }

    @Override // m0.c
    public final void addOnTrimMemoryListener(w0.a<Integer> aVar) {
        this.f749w.add(aVar);
    }

    @Override // androidx.activity.result.e
    public final androidx.activity.result.d getActivityResultRegistry() {
        return this.f747u;
    }

    @Override // androidx.lifecycle.f
    public u1.a getDefaultViewModelCreationExtras() {
        u1.d dVar = new u1.d();
        if (getApplication() != null) {
            dVar.set(a0.a.f3485b, getApplication());
        }
        dVar.set(SavedStateHandleSupport.f3465a, this);
        dVar.set(SavedStateHandleSupport.f3466b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            dVar.set(SavedStateHandleSupport.f3467c, getIntent().getExtras());
        }
        return dVar;
    }

    @Override // l0.j, androidx.lifecycle.l
    public Lifecycle getLifecycle() {
        return this.f741o;
    }

    @Override // androidx.activity.m
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        if (this.f744r == null) {
            this.f744r = new OnBackPressedDispatcher(new b());
            getLifecycle().addObserver(new androidx.lifecycle.j() { // from class: androidx.activity.ComponentActivity.6
                @Override // androidx.lifecycle.j
                public void onStateChanged(androidx.lifecycle.l lVar, Lifecycle.Event event) {
                    if (event != Lifecycle.Event.ON_CREATE || Build.VERSION.SDK_INT < 33) {
                        return;
                    }
                    ComponentActivity.this.f744r.setOnBackInvokedDispatcher(c.a((ComponentActivity) lVar));
                }
            });
        }
        return this.f744r;
    }

    @Override // j2.c
    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.f742p.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.e0
    public d0 getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.f743q == null) {
            d dVar = (d) getLastNonConfigurationInstance();
            if (dVar != null) {
                this.f743q = dVar.f766b;
            }
            if (this.f743q == null) {
                this.f743q = new d0();
            }
        }
        return this.f743q;
    }

    public void initializeViewTreeOwners() {
        f0.set(getWindow().getDecorView(), this);
        g0.set(getWindow().getDecorView(), this);
        androidx.savedstate.b.set(getWindow().getDecorView(), this);
        o.set(getWindow().getDecorView(), this);
        n.set(getWindow().getDecorView(), this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    @Deprecated
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (this.f747u.dispatchResult(i10, i11, intent)) {
            return;
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onBackPressed() {
        getOnBackPressedDispatcher().onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<w0.a<Configuration>> it = this.f748v.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f742p.performRestore(bundle);
        this.f739m.dispatchOnContextAvailable(this);
        super.onCreate(bundle);
        androidx.lifecycle.v.injectIfNeededIn(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i10, Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i10, menu);
        this.f740n.onCreateMenu(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 0) {
            return this.f740n.onMenuItemSelected(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10) {
        if (this.A) {
            return;
        }
        Iterator<w0.a<l0.l>> it = this.f751y.iterator();
        while (it.hasNext()) {
            it.next().accept(new l0.l(z10));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<w0.a<Intent>> it = this.f750x.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
        this.f740n.onMenuClosed(menu);
        super.onPanelClosed(i10, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10) {
        if (this.B) {
            return;
        }
        Iterator<w0.a<x>> it = this.f752z.iterator();
        while (it.hasNext()) {
            it.next().accept(new x(z10));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i10, View view, Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onPreparePanel(i10, view, menu);
        this.f740n.onPrepareMenu(menu);
        return true;
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (this.f747u.dispatchResult(i10, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        d dVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        d0 d0Var = this.f743q;
        if (d0Var == null && (dVar = (d) getLastNonConfigurationInstance()) != null) {
            d0Var = dVar.f766b;
        }
        if (d0Var == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        d dVar2 = new d();
        dVar2.f765a = objOnRetainCustomNonConfigurationInstance;
        dVar2.f766b = d0Var;
        return dVar2;
    }

    @Override // l0.j, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof androidx.lifecycle.m) {
            ((androidx.lifecycle.m) lifecycle).setCurrentState(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f742p.performSave(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        Iterator<w0.a<Integer>> it = this.f749w.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i10));
        }
    }

    @Override // x0.l
    public void removeMenuProvider(x0.o oVar) {
        this.f740n.removeMenuProvider(oVar);
    }

    @Override // m0.b
    public final void removeOnConfigurationChangedListener(w0.a<Configuration> aVar) {
        this.f748v.remove(aVar);
    }

    @Override // l0.u
    public final void removeOnMultiWindowModeChangedListener(w0.a<l0.l> aVar) {
        this.f751y.remove(aVar);
    }

    @Override // l0.v
    public final void removeOnPictureInPictureModeChangedListener(w0.a<x> aVar) {
        this.f752z.remove(aVar);
    }

    @Override // m0.c
    public final void removeOnTrimMemoryListener(w0.a<Integer> aVar) {
        this.f749w.remove(aVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (p2.a.isEnabled()) {
                p2.a.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.f746t.fullyDrawnReported();
        } finally {
            p2.a.endSection();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i10) {
        initializeViewTreeOwners();
        this.f745s.viewCreated(getWindow().getDecorView());
        super.setContentView(i10);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i10) {
        super.startActivityForResult(intent, i10);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i10, Bundle bundle) {
        super.startActivityForResult(intent, i10, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10, Configuration configuration) {
        this.A = true;
        try {
            super.onMultiWindowModeChanged(z10, configuration);
            this.A = false;
            Iterator<w0.a<l0.l>> it = this.f751y.iterator();
            while (it.hasNext()) {
                it.next().accept(new l0.l(z10, configuration));
            }
        } catch (Throwable th2) {
            this.A = false;
            throw th2;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10, Configuration configuration) {
        this.B = true;
        try {
            super.onPictureInPictureModeChanged(z10, configuration);
            this.B = false;
            Iterator<w0.a<x>> it = this.f752z.iterator();
            while (it.hasNext()) {
                it.next().accept(new x(z10, configuration));
            }
        } catch (Throwable th2) {
            this.B = false;
            throw th2;
        }
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initializeViewTreeOwners();
        this.f745s.viewCreated(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.f745s.viewCreated(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }
}
