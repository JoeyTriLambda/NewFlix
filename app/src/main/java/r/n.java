package r;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.c1;
import androidx.appcompat.widget.g0;
import androidx.appcompat.widget.j1;
import androidx.appcompat.widget.k1;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import n0.g;
import org.apache.commons.lang3.time.DateUtils;
import r.b0;
import r.c;
import r.d0;
import r.m;
import w.b;
import w.f;
import x0.j0;
import x0.r0;
import x0.t0;

/* compiled from: AppCompatDelegateImpl.java */
/* loaded from: classes.dex */
public final class n extends r.m implements e.a, LayoutInflater.Factory2 {

    /* renamed from: t0, reason: collision with root package name */
    public static final b0.k<String, Integer> f18256t0 = new b0.k<>();

    /* renamed from: u0, reason: collision with root package name */
    public static final int[] f18257u0 = {R.attr.windowBackground};

    /* renamed from: v0, reason: collision with root package name */
    public static final boolean f18258v0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: w0, reason: collision with root package name */
    public static final boolean f18259w0 = true;
    public w.g A;
    public CharSequence B;
    public g0 C;
    public d D;
    public p E;
    public w.b F;
    public ActionBarContextView G;
    public PopupWindow H;
    public q I;
    public boolean L;
    public ViewGroup M;
    public TextView N;
    public View O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public o[] X;
    public o Y;
    public boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f18260a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f18261b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f18262c0;

    /* renamed from: d0, reason: collision with root package name */
    public Configuration f18263d0;

    /* renamed from: e0, reason: collision with root package name */
    public final int f18264e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f18265f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f18266g0;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f18267h0;

    /* renamed from: i0, reason: collision with root package name */
    public m f18268i0;

    /* renamed from: j0, reason: collision with root package name */
    public k f18269j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f18270k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f18271l0;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f18273n0;

    /* renamed from: o0, reason: collision with root package name */
    public Rect f18274o0;

    /* renamed from: p0, reason: collision with root package name */
    public Rect f18275p0;

    /* renamed from: q0, reason: collision with root package name */
    public v f18276q0;

    /* renamed from: r0, reason: collision with root package name */
    public OnBackInvokedDispatcher f18277r0;

    /* renamed from: s0, reason: collision with root package name */
    public OnBackInvokedCallback f18278s0;

    /* renamed from: u, reason: collision with root package name */
    public final Object f18279u;

    /* renamed from: v, reason: collision with root package name */
    public final Context f18280v;

    /* renamed from: w, reason: collision with root package name */
    public Window f18281w;

    /* renamed from: x, reason: collision with root package name */
    public j f18282x;

    /* renamed from: y, reason: collision with root package name */
    public final r.k f18283y;

    /* renamed from: z, reason: collision with root package name */
    public r.a f18284z;
    public r0 J = null;
    public final boolean K = true;

    /* renamed from: m0, reason: collision with root package name */
    public final a f18272m0 = new a();

    /* compiled from: AppCompatDelegateImpl.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n nVar = n.this;
            if ((nVar.f18271l0 & 1) != 0) {
                nVar.k(0);
            }
            if ((nVar.f18271l0 & 4096) != 0) {
                nVar.k(108);
            }
            nVar.f18270k0 = false;
            nVar.f18271l0 = 0;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    public class b implements c.a {
        public b() {
        }

        @Override // r.c.a
        public Context getActionBarThemedContext() {
            return n.this.n();
        }

        @Override // r.c.a
        public Drawable getThemeUpIndicator() {
            c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(getActionBarThemedContext(), (AttributeSet) null, new int[]{androidx.appcompat.R.attr.homeAsUpIndicator});
            Drawable drawable = c1VarObtainStyledAttributes.getDrawable(0);
            c1VarObtainStyledAttributes.recycle();
            return drawable;
        }

        @Override // r.c.a
        public boolean isNavigationVisible() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            r.a supportActionBar = n.this.getSupportActionBar();
            return (supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // r.c.a
        public void setActionBarDescription(int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            r.a supportActionBar = n.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i10);
            }
        }

        @Override // r.c.a
        public void setActionBarUpIndicator(Drawable drawable, int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            r.a supportActionBar = n.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeAsUpIndicator(drawable);
                supportActionBar.setHomeActionContentDescription(i10);
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    public interface c {
    }

    /* compiled from: AppCompatDelegateImpl.java */
    public final class d implements i.a {
        public d() {
        }

        @Override // androidx.appcompat.view.menu.i.a
        public void onCloseMenu(androidx.appcompat.view.menu.e eVar, boolean z10) {
            n.this.g(eVar);
        }

        @Override // androidx.appcompat.view.menu.i.a
        public boolean onOpenSubMenu(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackQ = n.this.q();
            if (callbackQ == null) {
                return true;
            }
            callbackQ.onMenuOpened(108, eVar);
            return true;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    public class e implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final b.a f18288a;

        /* compiled from: AppCompatDelegateImpl.java */
        public class a extends t0 {
            public a() {
            }

            @Override // x0.s0
            public void onAnimationEnd(View view) {
                e eVar = e.this;
                n.this.G.setVisibility(8);
                n nVar = n.this;
                PopupWindow popupWindow = nVar.H;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (nVar.G.getParent() instanceof View) {
                    j0.requestApplyInsets((View) n.this.G.getParent());
                }
                n.this.G.killMode();
                n.this.J.setListener(null);
                n nVar2 = n.this;
                nVar2.J = null;
                j0.requestApplyInsets(nVar2.M);
            }
        }

        public e(b.a aVar) {
            this.f18288a = aVar;
        }

        @Override // w.b.a
        public boolean onActionItemClicked(w.b bVar, MenuItem menuItem) {
            return this.f18288a.onActionItemClicked(bVar, menuItem);
        }

        @Override // w.b.a
        public boolean onCreateActionMode(w.b bVar, Menu menu) {
            return this.f18288a.onCreateActionMode(bVar, menu);
        }

        @Override // w.b.a
        public void onDestroyActionMode(w.b bVar) {
            this.f18288a.onDestroyActionMode(bVar);
            n nVar = n.this;
            if (nVar.H != null) {
                nVar.f18281w.getDecorView().removeCallbacks(nVar.I);
            }
            if (nVar.G != null) {
                r0 r0Var = nVar.J;
                if (r0Var != null) {
                    r0Var.cancel();
                }
                r0 r0VarAlpha = j0.animate(nVar.G).alpha(0.0f);
                nVar.J = r0VarAlpha;
                r0VarAlpha.setListener(new a());
            }
            r.k kVar = nVar.f18283y;
            if (kVar != null) {
                kVar.onSupportActionModeFinished(nVar.F);
            }
            nVar.F = null;
            j0.requestApplyInsets(nVar.M);
            nVar.y();
        }

        @Override // w.b.a
        public boolean onPrepareActionMode(w.b bVar, Menu menu) {
            j0.requestApplyInsets(n.this.M);
            return this.f18288a.onPrepareActionMode(bVar, menu);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    public static class f {
        public static void a(Configuration configuration, Locale locale) {
            configuration.setLayoutDirection(locale);
        }

        public static void b(Configuration configuration, Locale locale) {
            configuration.setLocale(locale);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    public static class g {
        public static String a(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    public static class h {
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        public static t0.h b(Configuration configuration) {
            return t0.h.forLanguageTags(configuration.getLocales().toLanguageTags());
        }

        public static void c(Configuration configuration, t0.h hVar) {
            configuration.setLocales(LocaleList.forLanguageTags(hVar.toLanguageTags()));
        }

        public static void setDefaultLocales(t0.h hVar) {
            LocaleList.setDefault(LocaleList.forLanguageTags(hVar.toLanguageTags()));
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    public static class i {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback b(Object obj, final n nVar) {
            Objects.requireNonNull(nVar);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: r.s
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
                    nVar.t();
                }
            };
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        public static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    public class k extends l {

        /* renamed from: c, reason: collision with root package name */
        public final PowerManager f18296c;

        public k(Context context) {
            super();
            this.f18296c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // r.n.l
        public final IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // r.n.l
        public int getApplyableNightMode() {
            return this.f18296c.isPowerSaveMode() ? 2 : 1;
        }

        @Override // r.n.l
        public void onChange() {
            n.this.applyDayNight();
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    public abstract class l {

        /* renamed from: a, reason: collision with root package name */
        public a f18298a;

        /* compiled from: AppCompatDelegateImpl.java */
        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                l.this.onChange();
            }
        }

        public l() {
        }

        public final void a() {
            a aVar = this.f18298a;
            if (aVar != null) {
                try {
                    n.this.f18280v.unregisterReceiver(aVar);
                } catch (IllegalArgumentException unused) {
                }
                this.f18298a = null;
            }
        }

        public abstract IntentFilter b();

        public final void c() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.f18298a == null) {
                this.f18298a = new a();
            }
            n.this.f18280v.registerReceiver(this.f18298a, intentFilterB);
        }

        public abstract int getApplyableNightMode();

        public abstract void onChange();
    }

    /* compiled from: AppCompatDelegateImpl.java */
    public class m extends l {

        /* renamed from: c, reason: collision with root package name */
        public final d0 f18301c;

        public m(d0 d0Var) {
            super();
            this.f18301c = d0Var;
        }

        @Override // r.n.l
        public final IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // r.n.l
        public int getApplyableNightMode() {
            Location location;
            boolean z10;
            long j10;
            d0 d0Var = this.f18301c;
            d0.a aVar = d0Var.f18199c;
            if (aVar.f18201b > System.currentTimeMillis()) {
                z10 = aVar.f18200a;
            } else {
                Context context = d0Var.f18197a;
                int iCheckSelfPermission = m0.d.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION");
                Location lastKnownLocation = null;
                LocationManager locationManager = d0Var.f18198b;
                if (iCheckSelfPermission == 0) {
                    try {
                    } catch (Exception e10) {
                        Log.d("TwilightManager", "Failed to get last known location", e10);
                    }
                    Location lastKnownLocation2 = locationManager.isProviderEnabled("network") ? locationManager.getLastKnownLocation("network") : null;
                    location = lastKnownLocation2;
                } else {
                    location = null;
                }
                if (m0.d.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                    try {
                        if (locationManager.isProviderEnabled("gps")) {
                            lastKnownLocation = locationManager.getLastKnownLocation("gps");
                        }
                    } catch (Exception e11) {
                        Log.d("TwilightManager", "Failed to get last known location", e11);
                    }
                }
                if (lastKnownLocation == null || location == null ? lastKnownLocation != null : lastKnownLocation.getTime() > location.getTime()) {
                    location = lastKnownLocation;
                }
                if (location != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (c0.f18190d == null) {
                        c0.f18190d = new c0();
                    }
                    c0 c0Var = c0.f18190d;
                    c0Var.calculateTwilight(jCurrentTimeMillis - DateUtils.MILLIS_PER_DAY, location.getLatitude(), location.getLongitude());
                    c0Var.calculateTwilight(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
                    z = c0Var.f18193c == 1;
                    long j11 = c0Var.f18192b;
                    long j12 = c0Var.f18191a;
                    c0Var.calculateTwilight(jCurrentTimeMillis + DateUtils.MILLIS_PER_DAY, location.getLatitude(), location.getLongitude());
                    long j13 = c0Var.f18192b;
                    if (j11 == -1 || j12 == -1) {
                        j10 = 43200000 + jCurrentTimeMillis;
                    } else {
                        j10 = (jCurrentTimeMillis > j12 ? j13 + 0 : jCurrentTimeMillis > j11 ? j12 + 0 : j11 + 0) + DateUtils.MILLIS_PER_MINUTE;
                    }
                    aVar.f18200a = z;
                    aVar.f18201b = j10;
                } else {
                    Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                    int i10 = Calendar.getInstance().get(11);
                    if (i10 < 6 || i10 >= 22) {
                        z = true;
                    }
                }
                z10 = z;
            }
            return z10 ? 2 : 1;
        }

        @Override // r.n.l
        public void onChange() {
            n.this.applyDayNight();
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: r.n$n, reason: collision with other inner class name */
    public class C0234n extends ContentFrameLayout {
        public C0234n(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return n.this.j(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x10 = (int) motionEvent.getX();
                int y10 = (int) motionEvent.getY();
                if (x10 < -5 || y10 < -5 || x10 > getWidth() + 5 || y10 > getHeight() + 5) {
                    n nVar = n.this;
                    nVar.h(nVar.getPanelState(0, true), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i10) {
            setBackgroundDrawable(s.a.getDrawable(getContext(), i10));
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    public static final class o {

        /* renamed from: a, reason: collision with root package name */
        public final int f18304a;

        /* renamed from: b, reason: collision with root package name */
        public int f18305b;

        /* renamed from: c, reason: collision with root package name */
        public int f18306c;

        /* renamed from: d, reason: collision with root package name */
        public int f18307d;

        /* renamed from: e, reason: collision with root package name */
        public C0234n f18308e;

        /* renamed from: f, reason: collision with root package name */
        public View f18309f;

        /* renamed from: g, reason: collision with root package name */
        public View f18310g;

        /* renamed from: h, reason: collision with root package name */
        public androidx.appcompat.view.menu.e f18311h;

        /* renamed from: i, reason: collision with root package name */
        public androidx.appcompat.view.menu.c f18312i;

        /* renamed from: j, reason: collision with root package name */
        public w.d f18313j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f18314k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f18315l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f18316m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f18317n = false;

        /* renamed from: o, reason: collision with root package name */
        public boolean f18318o;

        /* renamed from: p, reason: collision with root package name */
        public Bundle f18319p;

        public o(int i10) {
            this.f18304a = i10;
        }

        public boolean hasPanelItems() {
            if (this.f18309f == null) {
                return false;
            }
            return this.f18310g != null || this.f18312i.getAdapter().getCount() > 0;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    public final class p implements i.a {
        public p() {
        }

        @Override // androidx.appcompat.view.menu.i.a
        public void onCloseMenu(androidx.appcompat.view.menu.e eVar, boolean z10) {
            o oVar;
            androidx.appcompat.view.menu.e rootMenu = eVar.getRootMenu();
            int i10 = 0;
            boolean z11 = rootMenu != eVar;
            if (z11) {
                eVar = rootMenu;
            }
            n nVar = n.this;
            o[] oVarArr = nVar.X;
            int length = oVarArr != null ? oVarArr.length : 0;
            while (true) {
                if (i10 < length) {
                    oVar = oVarArr[i10];
                    if (oVar != null && oVar.f18311h == eVar) {
                        break;
                    } else {
                        i10++;
                    }
                } else {
                    oVar = null;
                    break;
                }
            }
            if (oVar != null) {
                if (!z11) {
                    nVar.h(oVar, z10);
                } else {
                    nVar.f(oVar.f18304a, oVar, rootMenu);
                    nVar.h(oVar, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.i.a
        public boolean onOpenSubMenu(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackQ;
            if (eVar != eVar.getRootMenu()) {
                return true;
            }
            n nVar = n.this;
            if (!nVar.R || (callbackQ = nVar.q()) == null || nVar.f18262c0) {
                return true;
            }
            callbackQ.onMenuOpened(108, eVar);
            return true;
        }
    }

    public n(Context context, Window window, r.k kVar, Object obj) {
        b0.k<String, Integer> kVar2;
        Integer num;
        r.j jVar = null;
        this.f18264e0 = -100;
        this.f18280v = context;
        this.f18283y = kVar;
        this.f18279u = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof r.j)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        } else {
                            context = ((ContextWrapper) context).getBaseContext();
                        }
                    } else {
                        jVar = (r.j) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (jVar != null) {
                this.f18264e0 = jVar.getDelegate().getLocalNightMode();
            }
        }
        if (this.f18264e0 == -100 && (num = (kVar2 = f18256t0).get(this.f18279u.getClass().getName())) != null) {
            this.f18264e0 = num.intValue();
            kVar2.remove(this.f18279u.getClass().getName());
        }
        if (window != null) {
            d(window);
        }
        androidx.appcompat.widget.k.preload();
    }

    public static t0.h e(Context context) {
        t0.h hVar;
        t0.h emptyLocaleList;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33 || (hVar = r.m.f18249n) == null) {
            return null;
        }
        t0.h hVarP = p(context.getApplicationContext().getResources().getConfiguration());
        int i11 = 0;
        if (i10 < 24) {
            emptyLocaleList = hVar.isEmpty() ? t0.h.getEmptyLocaleList() : t0.h.forLanguageTags(hVar.get(0).toString());
        } else if (hVar.isEmpty()) {
            emptyLocaleList = t0.h.getEmptyLocaleList();
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (i11 < hVarP.size() + hVar.size()) {
                Locale locale = i11 < hVar.size() ? hVar.get(i11) : hVarP.get(i11 - hVar.size());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i11++;
            }
            emptyLocaleList = t0.h.create((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
        }
        return emptyLocaleList.isEmpty() ? hVarP : emptyLocaleList;
    }

    public static Configuration i(Context context, int i10, t0.h hVar, Configuration configuration, boolean z10) {
        int i11 = i10 != 1 ? i10 != 2 ? z10 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i11 | (configuration2.uiMode & (-49));
        if (hVar != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                h.c(configuration2, hVar);
            } else {
                f.b(configuration2, hVar.get(0));
                f.a(configuration2, hVar.get(0));
            }
        }
        return configuration2;
    }

    public static t0.h p(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? h.b(configuration) : t0.h.forLanguageTags(g.a(configuration.locale));
    }

    @Override // r.m
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        l();
        ((ViewGroup) this.M.findViewById(R.id.content)).addView(view, layoutParams);
        this.f18282x.bypassOnContentChanged(this.f18281w.getCallback());
    }

    public boolean applyDayNight() {
        return c(true, true);
    }

    @Override // r.m
    public Context attachBaseContext2(final Context context) {
        this.f18260a0 = true;
        int defaultNightMode = this.f18264e0;
        if (defaultNightMode == -100) {
            defaultNightMode = r.m.getDefaultNightMode();
        }
        int iS = s(context, defaultNightMode);
        if (r.m.a(context) && r.m.a(context)) {
            if (!t0.a.isAtLeastT()) {
                synchronized (r.m.f18255t) {
                    t0.h hVar = r.m.f18249n;
                    if (hVar == null) {
                        if (r.m.f18250o == null) {
                            r.m.f18250o = t0.h.forLanguageTags(y.b(context));
                        }
                        if (!r.m.f18250o.isEmpty()) {
                            r.m.f18249n = r.m.f18250o;
                        }
                    } else if (!hVar.equals(r.m.f18250o)) {
                        t0.h hVar2 = r.m.f18249n;
                        r.m.f18250o = hVar2;
                        y.a(context, hVar2.toLanguageTags());
                    }
                }
            } else if (!r.m.f18252q) {
                r.m.f18247b.execute(new Runnable() { // from class: r.l
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        if (Build.VERSION.SDK_INT >= 33) {
                            Context context2 = context;
                            ComponentName componentName = new ComponentName(context2, "androidx.appcompat.app.AppLocalesMetadataHolderService");
                            if (context2.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                                if (m.getApplicationLocales().isEmpty()) {
                                    String strB = y.b(context2);
                                    Object systemService = context2.getSystemService("locale");
                                    if (systemService != null) {
                                        m.b.b(systemService, m.a.a(strB));
                                    }
                                }
                                context2.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
                            }
                        }
                        m.f18252q = true;
                    }
                });
            }
        }
        t0.h hVarE = e(context);
        Configuration configuration = null;
        boolean z10 = false;
        if (f18259w0 && (context instanceof ContextThemeWrapper)) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(i(context, iS, hVarE, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof w.d) {
            try {
                ((w.d) context).applyOverrideConfiguration(i(context, iS, hVarE, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f18258v0) {
            return super.attachBaseContext2(context);
        }
        int i10 = Build.VERSION.SDK_INT;
        Configuration configuration2 = new Configuration();
        configuration2.uiMode = -1;
        configuration2.fontScale = 0.0f;
        Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
        Configuration configuration4 = context.getResources().getConfiguration();
        configuration3.uiMode = configuration4.uiMode;
        if (!configuration3.equals(configuration4)) {
            configuration = new Configuration();
            configuration.fontScale = 0.0f;
            if (configuration3.diff(configuration4) != 0) {
                float f10 = configuration3.fontScale;
                float f11 = configuration4.fontScale;
                if (f10 != f11) {
                    configuration.fontScale = f11;
                }
                int i11 = configuration3.mcc;
                int i12 = configuration4.mcc;
                if (i11 != i12) {
                    configuration.mcc = i12;
                }
                int i13 = configuration3.mnc;
                int i14 = configuration4.mnc;
                if (i13 != i14) {
                    configuration.mnc = i14;
                }
                if (i10 >= 24) {
                    h.a(configuration3, configuration4, configuration);
                } else if (!w0.c.equals(configuration3.locale, configuration4.locale)) {
                    configuration.locale = configuration4.locale;
                }
                int i15 = configuration3.touchscreen;
                int i16 = configuration4.touchscreen;
                if (i15 != i16) {
                    configuration.touchscreen = i16;
                }
                int i17 = configuration3.keyboard;
                int i18 = configuration4.keyboard;
                if (i17 != i18) {
                    configuration.keyboard = i18;
                }
                int i19 = configuration3.keyboardHidden;
                int i20 = configuration4.keyboardHidden;
                if (i19 != i20) {
                    configuration.keyboardHidden = i20;
                }
                int i21 = configuration3.navigation;
                int i22 = configuration4.navigation;
                if (i21 != i22) {
                    configuration.navigation = i22;
                }
                int i23 = configuration3.navigationHidden;
                int i24 = configuration4.navigationHidden;
                if (i23 != i24) {
                    configuration.navigationHidden = i24;
                }
                int i25 = configuration3.orientation;
                int i26 = configuration4.orientation;
                if (i25 != i26) {
                    configuration.orientation = i26;
                }
                int i27 = configuration3.screenLayout & 15;
                int i28 = configuration4.screenLayout & 15;
                if (i27 != i28) {
                    configuration.screenLayout |= i28;
                }
                int i29 = configuration3.screenLayout & 192;
                int i30 = configuration4.screenLayout & 192;
                if (i29 != i30) {
                    configuration.screenLayout |= i30;
                }
                int i31 = configuration3.screenLayout & 48;
                int i32 = configuration4.screenLayout & 48;
                if (i31 != i32) {
                    configuration.screenLayout |= i32;
                }
                int i33 = configuration3.screenLayout & 768;
                int i34 = configuration4.screenLayout & 768;
                if (i33 != i34) {
                    configuration.screenLayout |= i34;
                }
                if (i10 >= 26) {
                    if ((configuration3.colorMode & 3) != (configuration4.colorMode & 3)) {
                        configuration.colorMode |= configuration4.colorMode & 3;
                    }
                    if ((configuration3.colorMode & 12) != (configuration4.colorMode & 12)) {
                        configuration.colorMode |= configuration4.colorMode & 12;
                    }
                }
                int i35 = configuration3.uiMode & 15;
                int i36 = configuration4.uiMode & 15;
                if (i35 != i36) {
                    configuration.uiMode |= i36;
                }
                int i37 = configuration3.uiMode & 48;
                int i38 = configuration4.uiMode & 48;
                if (i37 != i38) {
                    configuration.uiMode |= i38;
                }
                int i39 = configuration3.screenWidthDp;
                int i40 = configuration4.screenWidthDp;
                if (i39 != i40) {
                    configuration.screenWidthDp = i40;
                }
                int i41 = configuration3.screenHeightDp;
                int i42 = configuration4.screenHeightDp;
                if (i41 != i42) {
                    configuration.screenHeightDp = i42;
                }
                int i43 = configuration3.smallestScreenWidthDp;
                int i44 = configuration4.smallestScreenWidthDp;
                if (i43 != i44) {
                    configuration.smallestScreenWidthDp = i44;
                }
                int i45 = configuration3.densityDpi;
                int i46 = configuration4.densityDpi;
                if (i45 != i46) {
                    configuration.densityDpi = i46;
                }
            }
        }
        Configuration configurationI = i(context, iS, hVarE, configuration, true);
        w.d dVar = new w.d(context, androidx.appcompat.R.style.Theme_AppCompat_Empty);
        dVar.applyOverrideConfiguration(configurationI);
        try {
            z10 = context.getTheme() != null;
        } catch (NullPointerException unused3) {
        }
        if (z10) {
            g.f.rebase(dVar.getTheme());
        }
        return super.attachBaseContext2(dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean c(boolean r19, boolean r20) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, android.content.pm.PackageManager.NameNotFoundException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 686
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: r.n.c(boolean, boolean):boolean");
    }

    public View createView(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.f18276q0 == null) {
            int[] iArr = androidx.appcompat.R.styleable.AppCompatTheme;
            Context context2 = this.f18280v;
            String string = context2.obtainStyledAttributes(iArr).getString(androidx.appcompat.R.styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.f18276q0 = new v();
            } else {
                try {
                    this.f18276q0 = (v) context2.getClassLoader().loadClass(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th2) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th2);
                    this.f18276q0 = new v();
                }
            }
        }
        return this.f18276q0.createView(view, str, context, attributeSet, false, false, true, j1.shouldBeUsed());
    }

    public final void d(Window window) {
        if (this.f18281w != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof j) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        j jVar = new j(callback);
        this.f18282x = jVar;
        window.setCallback(jVar);
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(this.f18280v, (AttributeSet) null, f18257u0);
        Drawable drawableIfKnown = c1VarObtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            window.setBackgroundDrawable(drawableIfKnown);
        }
        c1VarObtainStyledAttributes.recycle();
        this.f18281w = window;
        if (Build.VERSION.SDK_INT < 33 || this.f18277r0 != null) {
            return;
        }
        setOnBackInvokedDispatcher(null);
    }

    public final void f(int i10, o oVar, androidx.appcompat.view.menu.e eVar) {
        if (eVar == null) {
            if (oVar == null && i10 >= 0) {
                o[] oVarArr = this.X;
                if (i10 < oVarArr.length) {
                    oVar = oVarArr[i10];
                }
            }
            if (oVar != null) {
                eVar = oVar.f18311h;
            }
        }
        if ((oVar == null || oVar.f18316m) && !this.f18262c0) {
            this.f18282x.bypassOnPanelClosed(this.f18281w.getCallback(), i10, eVar);
        }
    }

    @Override // r.m
    public <T extends View> T findViewById(int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        l();
        return (T) this.f18281w.findViewById(i10);
    }

    public final void g(androidx.appcompat.view.menu.e eVar) {
        if (this.W) {
            return;
        }
        this.W = true;
        this.C.dismissPopups();
        Window.Callback callbackQ = q();
        if (callbackQ != null && !this.f18262c0) {
            callbackQ.onPanelClosed(108, eVar);
        }
        this.W = false;
    }

    @Override // r.m
    public Context getContextForDelegate() {
        return this.f18280v;
    }

    @Override // r.m
    public final c.a getDrawerToggleDelegate() {
        return new b();
    }

    @Override // r.m
    public int getLocalNightMode() {
        return this.f18264e0;
    }

    @Override // r.m
    public MenuInflater getMenuInflater() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.A == null) {
            r();
            r.a aVar = this.f18284z;
            this.A = new w.g(aVar != null ? aVar.getThemedContext() : this.f18280v);
        }
        return this.A;
    }

    public o getPanelState(int i10, boolean z10) {
        o[] oVarArr = this.X;
        if (oVarArr == null || oVarArr.length <= i10) {
            o[] oVarArr2 = new o[i10 + 1];
            if (oVarArr != null) {
                System.arraycopy(oVarArr, 0, oVarArr2, 0, oVarArr.length);
            }
            this.X = oVarArr2;
            oVarArr = oVarArr2;
        }
        o oVar = oVarArr[i10];
        if (oVar != null) {
            return oVar;
        }
        o oVar2 = new o(i10);
        oVarArr[i10] = oVar2;
        return oVar2;
    }

    @Override // r.m
    public r.a getSupportActionBar() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        r();
        return this.f18284z;
    }

    public final void h(o oVar, boolean z10) {
        C0234n c0234n;
        g0 g0Var;
        if (z10 && oVar.f18304a == 0 && (g0Var = this.C) != null && g0Var.isOverflowMenuShowing()) {
            g(oVar.f18311h);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f18280v.getSystemService("window");
        if (windowManager != null && oVar.f18316m && (c0234n = oVar.f18308e) != null) {
            windowManager.removeView(c0234n);
            if (z10) {
                f(oVar.f18304a, oVar, null);
            }
        }
        oVar.f18314k = false;
        oVar.f18315l = false;
        oVar.f18316m = false;
        oVar.f18309f = null;
        oVar.f18317n = true;
        if (this.Y == oVar) {
            this.Y = null;
        }
        if (oVar.f18304a == 0) {
            y();
        }
    }

    @Override // r.m
    public void installViewFactory() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f18280v);
        if (layoutInflaterFrom.getFactory() == null) {
            x0.j.setFactory2(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof n) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // r.m
    public void invalidateOptionsMenu() {
        if (this.f18284z == null || getSupportActionBar().invalidateOptionsMenu()) {
            return;
        }
        this.f18271l0 |= 1;
        if (this.f18270k0) {
            return;
        }
        j0.postOnAnimation(this.f18281w.getDecorView(), this.f18272m0);
        this.f18270k0 = true;
    }

    public boolean isHandleNativeActionModesEnabled() {
        return this.K;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean j(android.view.KeyEvent r7) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: r.n.j(android.view.KeyEvent):boolean");
    }

    public final void k(int i10) {
        o panelState;
        o panelState2 = getPanelState(i10, true);
        if (panelState2.f18311h != null) {
            Bundle bundle = new Bundle();
            panelState2.f18311h.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                panelState2.f18319p = bundle;
            }
            panelState2.f18311h.stopDispatchingItemsChanged();
            panelState2.f18311h.clear();
        }
        panelState2.f18318o = true;
        panelState2.f18317n = true;
        if ((i10 != 108 && i10 != 0) || this.C == null || (panelState = getPanelState(0, false)) == null) {
            return;
        }
        panelState.f18314k = false;
        w(panelState, null);
    }

    public final void l() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ViewGroup viewGroup;
        if (this.L) {
            return;
        }
        int[] iArr = androidx.appcompat.R.styleable.AppCompatTheme;
        Context context = this.f18280v;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        int i10 = androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar;
        if (!typedArrayObtainStyledAttributes.hasValue(i10)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowNoTitle, false)) {
            requestWindowFeature(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(i10, false)) {
            requestWindowFeature(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            requestWindowFeature(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            requestWindowFeature(10);
        }
        this.U = typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        m();
        this.f18281w.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.V) {
            viewGroup = this.T ? (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.U) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.S = false;
            this.R = false;
        } else if (this.R) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new w.d(context, typedValue.resourceId) : context).inflate(androidx.appcompat.R.layout.abc_screen_toolbar, (ViewGroup) null);
            g0 g0Var = (g0) viewGroup.findViewById(androidx.appcompat.R.id.decor_content_parent);
            this.C = g0Var;
            g0Var.setWindowCallback(q());
            if (this.S) {
                this.C.initFeature(109);
            }
            if (this.P) {
                this.C.initFeature(2);
            }
            if (this.Q) {
                this.C.initFeature(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.R + ", windowActionBarOverlay: " + this.S + ", android:windowIsFloating: " + this.U + ", windowActionModeOverlay: " + this.T + ", windowNoTitle: " + this.V + " }");
        }
        j0.setOnApplyWindowInsetsListener(viewGroup, new r.o(this));
        if (this.C == null) {
            this.N = (TextView) viewGroup.findViewById(androidx.appcompat.R.id.title);
        }
        k1.makeOptionalFitsSystemWindows(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(androidx.appcompat.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f18281w.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f18281w.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new r.p(this));
        this.M = viewGroup;
        Object obj = this.f18279u;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.B;
        if (!TextUtils.isEmpty(title)) {
            g0 g0Var2 = this.C;
            if (g0Var2 != null) {
                g0Var2.setWindowTitle(title);
            } else {
                r.a aVar = this.f18284z;
                if (aVar != null) {
                    aVar.setWindowTitle(title);
                } else {
                    TextView textView = this.N;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.M.findViewById(R.id.content);
        View decorView = this.f18281w.getDecorView();
        contentFrameLayout2.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        typedArrayObtainStyledAttributes2.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.getMinWidthMajor());
        typedArrayObtainStyledAttributes2.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.getMinWidthMinor());
        int i11 = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor;
        if (typedArrayObtainStyledAttributes2.hasValue(i11)) {
            typedArrayObtainStyledAttributes2.getValue(i11, contentFrameLayout2.getFixedWidthMajor());
        }
        int i12 = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor;
        if (typedArrayObtainStyledAttributes2.hasValue(i12)) {
            typedArrayObtainStyledAttributes2.getValue(i12, contentFrameLayout2.getFixedWidthMinor());
        }
        int i13 = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor;
        if (typedArrayObtainStyledAttributes2.hasValue(i13)) {
            typedArrayObtainStyledAttributes2.getValue(i13, contentFrameLayout2.getFixedHeightMajor());
        }
        int i14 = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor;
        if (typedArrayObtainStyledAttributes2.hasValue(i14)) {
            typedArrayObtainStyledAttributes2.getValue(i14, contentFrameLayout2.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.L = true;
        o panelState = getPanelState(0, false);
        if (this.f18262c0) {
            return;
        }
        if (panelState == null || panelState.f18311h == null) {
            this.f18271l0 |= 4096;
            if (this.f18270k0) {
                return;
            }
            j0.postOnAnimation(this.f18281w.getDecorView(), this.f18272m0);
            this.f18270k0 = true;
        }
    }

    public final void m() {
        if (this.f18281w == null) {
            Object obj = this.f18279u;
            if (obj instanceof Activity) {
                d(((Activity) obj).getWindow());
            }
        }
        if (this.f18281w == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final Context n() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        r.a supportActionBar = getSupportActionBar();
        Context themedContext = supportActionBar != null ? supportActionBar.getThemedContext() : null;
        return themedContext == null ? this.f18280v : themedContext;
    }

    public final l o(Context context) {
        if (this.f18268i0 == null) {
            if (d0.f18196d == null) {
                Context applicationContext = context.getApplicationContext();
                d0.f18196d = new d0(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.f18268i0 = new m(d0.f18196d);
        }
        return this.f18268i0;
    }

    @Override // r.m
    public void onConfigurationChanged(Configuration configuration) throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException {
        r.a supportActionBar;
        if (this.R && this.L && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.onConfigurationChanged(configuration);
        }
        androidx.appcompat.widget.k kVar = androidx.appcompat.widget.k.get();
        Context context = this.f18280v;
        kVar.onConfigurationChanged(context);
        this.f18263d0 = new Configuration(context.getResources().getConfiguration());
        c(false, false);
    }

    @Override // r.m
    public void onCreate(Bundle bundle) throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException {
        String parentActivityName;
        this.f18260a0 = true;
        c(false, true);
        m();
        Object obj = this.f18279u;
        if (obj instanceof Activity) {
            try {
                parentActivityName = l0.m.getParentActivityName((Activity) obj);
            } catch (IllegalArgumentException unused) {
                parentActivityName = null;
            }
            if (parentActivityName != null) {
                r.a aVar = this.f18284z;
                if (aVar == null) {
                    this.f18273n0 = true;
                } else {
                    aVar.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
            synchronized (r.m.f18254s) {
                r.m.b(this);
                r.m.f18253r.add(new WeakReference<>(this));
            }
        }
        this.f18263d0 = new Configuration(this.f18280v.getResources().getConfiguration());
        this.f18261b0 = true;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return createView(view, str, context, attributeSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // r.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDestroy() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f18279u
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = r.m.f18254s
            monitor-enter(r0)
            r.m.b(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r1
        L11:
            boolean r0 = r3.f18270k0
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.f18281w
            android.view.View r0 = r0.getDecorView()
            r.n$a r1 = r3.f18272m0
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.f18262c0 = r0
            int r0 = r3.f18264e0
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.f18279u
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            b0.k<java.lang.String, java.lang.Integer> r0 = r.n.f18256t0
            java.lang.Object r1 = r3.f18279u
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f18264e0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            b0.k<java.lang.String, java.lang.Integer> r0 = r.n.f18256t0
            java.lang.Object r1 = r3.f18279u
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            r.a r0 = r3.f18284z
            if (r0 == 0) goto L63
            r0.a()
        L63:
            r.n$m r0 = r3.f18268i0
            if (r0 == 0) goto L6a
            r0.a()
        L6a:
            r.n$k r0 = r3.f18269j0
            if (r0 == 0) goto L71
            r0.a()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r.n.onDestroy():void");
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean onMenuItemSelected(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        o oVar;
        Window.Callback callbackQ = q();
        if (callbackQ != null && !this.f18262c0) {
            androidx.appcompat.view.menu.e rootMenu = eVar.getRootMenu();
            o[] oVarArr = this.X;
            int length = oVarArr != null ? oVarArr.length : 0;
            int i10 = 0;
            while (true) {
                if (i10 < length) {
                    oVar = oVarArr[i10];
                    if (oVar != null && oVar.f18311h == rootMenu) {
                        break;
                    }
                    i10++;
                } else {
                    oVar = null;
                    break;
                }
            }
            if (oVar != null) {
                return callbackQ.onMenuItemSelected(oVar.f18304a, menuItem);
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void onMenuModeChange(androidx.appcompat.view.menu.e eVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        g0 g0Var = this.C;
        if (g0Var == null || !g0Var.canShowOverflowMenu() || (ViewConfiguration.get(this.f18280v).hasPermanentMenuKey() && !this.C.isOverflowMenuShowPending())) {
            o panelState = getPanelState(0, true);
            panelState.f18317n = true;
            h(panelState, false);
            u(panelState, null);
            return;
        }
        Window.Callback callbackQ = q();
        if (this.C.isOverflowMenuShowing()) {
            this.C.hideOverflowMenu();
            if (this.f18262c0) {
                return;
            }
            callbackQ.onPanelClosed(108, getPanelState(0, true).f18311h);
            return;
        }
        if (callbackQ == null || this.f18262c0) {
            return;
        }
        if (this.f18270k0 && (this.f18271l0 & 1) != 0) {
            View decorView = this.f18281w.getDecorView();
            a aVar = this.f18272m0;
            decorView.removeCallbacks(aVar);
            aVar.run();
        }
        o panelState2 = getPanelState(0, true);
        androidx.appcompat.view.menu.e eVar2 = panelState2.f18311h;
        if (eVar2 == null || panelState2.f18318o || !callbackQ.onPreparePanel(0, panelState2.f18310g, eVar2)) {
            return;
        }
        callbackQ.onMenuOpened(108, panelState2.f18311h);
        this.C.showOverflowMenu();
    }

    @Override // r.m
    public void onPostCreate(Bundle bundle) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        l();
    }

    @Override // r.m
    public void onPostResume() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        r.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(true);
        }
    }

    @Override // r.m
    public void onStart() throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException {
        c(true, false);
    }

    @Override // r.m
    public void onStop() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        r.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
        }
    }

    public final Window.Callback q() {
        return this.f18281w.getCallback();
    }

    public final void r() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        l();
        if (this.R && this.f18284z == null) {
            Object obj = this.f18279u;
            if (obj instanceof Activity) {
                this.f18284z = new e0((Activity) obj, this.S);
            } else if (obj instanceof Dialog) {
                this.f18284z = new e0((Dialog) obj);
            }
            r.a aVar = this.f18284z;
            if (aVar != null) {
                aVar.setDefaultDisplayHomeAsUpEnabled(this.f18273n0);
            }
        }
    }

    @Override // r.m
    public boolean requestWindowFeature(int i10) {
        if (i10 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i10 = 108;
        } else if (i10 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i10 = 109;
        }
        if (this.V && i10 == 108) {
            return false;
        }
        if (this.R && i10 == 1) {
            this.R = false;
        }
        if (i10 == 1) {
            x();
            this.V = true;
            return true;
        }
        if (i10 == 2) {
            x();
            this.P = true;
            return true;
        }
        if (i10 == 5) {
            x();
            this.Q = true;
            return true;
        }
        if (i10 == 10) {
            x();
            this.T = true;
            return true;
        }
        if (i10 == 108) {
            x();
            this.R = true;
            return true;
        }
        if (i10 != 109) {
            return this.f18281w.requestFeature(i10);
        }
        x();
        this.S = true;
        return true;
    }

    public final int s(Context context, int i10) {
        if (i10 == -100) {
            return -1;
        }
        if (i10 != -1) {
            if (i10 == 0) {
                if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return o(context).getApplyableNightMode();
                }
                return -1;
            }
            if (i10 != 1 && i10 != 2) {
                if (i10 != 3) {
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
                if (this.f18269j0 == null) {
                    this.f18269j0 = new k(context);
                }
                return this.f18269j0.getApplyableNightMode();
            }
        }
        return i10;
    }

    @Override // r.m
    public void setContentView(View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        l();
        ViewGroup viewGroup = (ViewGroup) this.M.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f18282x.bypassOnContentChanged(this.f18281w.getCallback());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    @Override // r.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setOnBackInvokedDispatcher(android.window.OnBackInvokedDispatcher r3) {
        /*
            r2 = this;
            super.setOnBackInvokedDispatcher(r3)
            android.window.OnBackInvokedDispatcher r0 = r2.f18277r0
            if (r0 == 0) goto L11
            android.window.OnBackInvokedCallback r1 = r2.f18278s0
            if (r1 == 0) goto L11
            r.n.i.c(r0, r1)
            r0 = 0
            r2.f18278s0 = r0
        L11:
            if (r3 != 0) goto L2b
            java.lang.Object r0 = r2.f18279u
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L2b
            r1 = r0
            android.app.Activity r1 = (android.app.Activity) r1
            android.view.Window r1 = r1.getWindow()
            if (r1 == 0) goto L2b
            android.app.Activity r0 = (android.app.Activity) r0
            android.window.OnBackInvokedDispatcher r3 = r.n.i.a(r0)
            r2.f18277r0 = r3
            goto L2d
        L2b:
            r2.f18277r0 = r3
        L2d:
            r2.y()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r.n.setOnBackInvokedDispatcher(android.window.OnBackInvokedDispatcher):void");
    }

    @Override // r.m
    public void setSupportActionBar(Toolbar toolbar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Object obj = this.f18279u;
        if (obj instanceof Activity) {
            r.a supportActionBar = getSupportActionBar();
            if (supportActionBar instanceof e0) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.A = null;
            if (supportActionBar != null) {
                supportActionBar.a();
            }
            this.f18284z = null;
            if (toolbar != null) {
                b0 b0Var = new b0(toolbar, obj instanceof Activity ? ((Activity) obj).getTitle() : this.B, this.f18282x);
                this.f18284z = b0Var;
                this.f18282x.f18291m = b0Var.f18166c;
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                this.f18282x.f18291m = null;
            }
            invalidateOptionsMenu();
        }
    }

    @Override // r.m
    public void setTheme(int i10) {
        this.f18265f0 = i10;
    }

    @Override // r.m
    public final void setTitle(CharSequence charSequence) {
        this.B = charSequence;
        g0 g0Var = this.C;
        if (g0Var != null) {
            g0Var.setWindowTitle(charSequence);
            return;
        }
        r.a aVar = this.f18284z;
        if (aVar != null) {
            aVar.setWindowTitle(charSequence);
            return;
        }
        TextView textView = this.N;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public w.b startSupportActionMode(w.b.a r9) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 420
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: r.n.startSupportActionMode(w.b$a):w.b");
    }

    public final boolean t() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean z10 = this.Z;
        this.Z = false;
        o panelState = getPanelState(0, false);
        if (panelState != null && panelState.f18316m) {
            if (!z10) {
                h(panelState, true);
            }
            return true;
        }
        w.b bVar = this.F;
        if (bVar != null) {
            bVar.finish();
            return true;
        }
        r.a supportActionBar = getSupportActionBar();
        return supportActionBar != null && supportActionBar.collapseActionView();
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void u(r.n.o r14, android.view.KeyEvent r15) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: r.n.u(r.n$o, android.view.KeyEvent):void");
    }

    public final boolean v(o oVar, int i10, KeyEvent keyEvent) {
        androidx.appcompat.view.menu.e eVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((oVar.f18314k || w(oVar, keyEvent)) && (eVar = oVar.f18311h) != null) {
            return eVar.performShortcut(i10, keyEvent, 1);
        }
        return false;
    }

    public final boolean w(o oVar, KeyEvent keyEvent) {
        g0 g0Var;
        g0 g0Var2;
        Resources.Theme themeNewTheme;
        g0 g0Var3;
        g0 g0Var4;
        if (this.f18262c0) {
            return false;
        }
        if (oVar.f18314k) {
            return true;
        }
        o oVar2 = this.Y;
        if (oVar2 != null && oVar2 != oVar) {
            h(oVar2, false);
        }
        Window.Callback callbackQ = q();
        int i10 = oVar.f18304a;
        if (callbackQ != null) {
            oVar.f18310g = callbackQ.onCreatePanelView(i10);
        }
        boolean z10 = i10 == 0 || i10 == 108;
        if (z10 && (g0Var4 = this.C) != null) {
            g0Var4.setMenuPrepared();
        }
        if (oVar.f18310g == null && (!z10 || !(this.f18284z instanceof b0))) {
            androidx.appcompat.view.menu.e eVar = oVar.f18311h;
            if (eVar == null || oVar.f18318o) {
                if (eVar == null) {
                    Context context = this.f18280v;
                    if ((i10 == 0 || i10 == 108) && this.C != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = context.getTheme();
                        theme.resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            themeNewTheme = context.getResources().newTheme();
                            themeNewTheme.setTo(theme);
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                            themeNewTheme.resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme.resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
                            themeNewTheme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (themeNewTheme == null) {
                                themeNewTheme = context.getResources().newTheme();
                                themeNewTheme.setTo(theme);
                            }
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                        }
                        if (themeNewTheme != null) {
                            w.d dVar = new w.d(context, 0);
                            dVar.getTheme().setTo(themeNewTheme);
                            context = dVar;
                        }
                    }
                    androidx.appcompat.view.menu.e eVar2 = new androidx.appcompat.view.menu.e(context);
                    eVar2.setCallback(this);
                    androidx.appcompat.view.menu.e eVar3 = oVar.f18311h;
                    if (eVar2 != eVar3) {
                        if (eVar3 != null) {
                            eVar3.removeMenuPresenter(oVar.f18312i);
                        }
                        oVar.f18311h = eVar2;
                        androidx.appcompat.view.menu.c cVar = oVar.f18312i;
                        if (cVar != null) {
                            eVar2.addMenuPresenter(cVar);
                        }
                    }
                    if (oVar.f18311h == null) {
                        return false;
                    }
                }
                if (z10 && (g0Var2 = this.C) != null) {
                    if (this.D == null) {
                        this.D = new d();
                    }
                    g0Var2.setMenu(oVar.f18311h, this.D);
                }
                oVar.f18311h.stopDispatchingItemsChanged();
                if (!callbackQ.onCreatePanelMenu(i10, oVar.f18311h)) {
                    androidx.appcompat.view.menu.e eVar4 = oVar.f18311h;
                    if (eVar4 != null) {
                        if (eVar4 != null) {
                            eVar4.removeMenuPresenter(oVar.f18312i);
                        }
                        oVar.f18311h = null;
                    }
                    if (z10 && (g0Var = this.C) != null) {
                        g0Var.setMenu(null, this.D);
                    }
                    return false;
                }
                oVar.f18318o = false;
            }
            oVar.f18311h.stopDispatchingItemsChanged();
            Bundle bundle = oVar.f18319p;
            if (bundle != null) {
                oVar.f18311h.restoreActionViewStates(bundle);
                oVar.f18319p = null;
            }
            if (!callbackQ.onPreparePanel(0, oVar.f18310g, oVar.f18311h)) {
                if (z10 && (g0Var3 = this.C) != null) {
                    g0Var3.setMenu(null, this.D);
                }
                oVar.f18311h.startDispatchingItemsChanged();
                return false;
            }
            oVar.f18311h.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            oVar.f18311h.startDispatchingItemsChanged();
        }
        oVar.f18314k = true;
        oVar.f18315l = false;
        this.Y = oVar;
        return true;
    }

    public final void x() {
        if (this.L) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void y() {
        OnBackInvokedCallback onBackInvokedCallback;
        o panelState;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z10 = false;
            if (this.f18277r0 != null && (((panelState = getPanelState(0, false)) != null && panelState.f18316m) || this.F != null)) {
                z10 = true;
            }
            if (z10 && this.f18278s0 == null) {
                this.f18278s0 = i.b(this.f18277r0, this);
            } else {
                if (z10 || (onBackInvokedCallback = this.f18278s0) == null) {
                    return;
                }
                i.c(this.f18277r0, onBackInvokedCallback);
            }
        }
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* compiled from: AppCompatDelegateImpl.java */
    public class j extends w.i {

        /* renamed from: m, reason: collision with root package name */
        public c f18291m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f18292n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f18293o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f18294p;

        public j(Window.Callback callback) {
            super(callback);
        }

        public boolean bypassDispatchKeyEvent(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f18293o = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.f18293o = false;
            }
        }

        public void bypassOnContentChanged(Window.Callback callback) {
            try {
                this.f18292n = true;
                callback.onContentChanged();
            } finally {
                this.f18292n = false;
            }
        }

        public void bypassOnPanelClosed(Window.Callback callback, int i10, Menu menu) {
            try {
                this.f18294p = true;
                callback.onPanelClosed(i10, menu);
            } finally {
                this.f18294p = false;
            }
        }

        @Override // w.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f18293o ? getWrapped().dispatchKeyEvent(keyEvent) : n.this.j(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // w.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            boolean z10;
            if (super.dispatchKeyShortcutEvent(keyEvent)) {
                return true;
            }
            int keyCode = keyEvent.getKeyCode();
            n nVar = n.this;
            r.a supportActionBar = nVar.getSupportActionBar();
            if (supportActionBar == null || !supportActionBar.onKeyShortcut(keyCode, keyEvent)) {
                o oVar = nVar.Y;
                if (oVar == null || !nVar.v(oVar, keyEvent.getKeyCode(), keyEvent)) {
                    if (nVar.Y == null) {
                        o panelState = nVar.getPanelState(0, true);
                        nVar.w(panelState, keyEvent);
                        boolean zV = nVar.v(panelState, keyEvent.getKeyCode(), keyEvent);
                        panelState.f18314k = false;
                        if (zV) {
                        }
                    }
                    z10 = false;
                } else {
                    o oVar2 = nVar.Y;
                    if (oVar2 != null) {
                        oVar2.f18315l = true;
                    }
                }
                z10 = true;
            } else {
                z10 = true;
            }
            return z10;
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.f18292n) {
                getWrapped().onContentChanged();
            }
        }

        @Override // w.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i10, Menu menu) {
            if (i10 != 0 || (menu instanceof androidx.appcompat.view.menu.e)) {
                return super.onCreatePanelMenu(i10, menu);
            }
            return false;
        }

        @Override // w.i, android.view.Window.Callback
        public View onCreatePanelView(int i10) {
            View viewOnCreatePanelView;
            c cVar = this.f18291m;
            return (cVar == null || (viewOnCreatePanelView = ((b0.e) cVar).onCreatePanelView(i10)) == null) ? super.onCreatePanelView(i10) : viewOnCreatePanelView;
        }

        @Override // w.i, android.view.Window.Callback
        public boolean onMenuOpened(int i10, Menu menu) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            super.onMenuOpened(i10, menu);
            n nVar = n.this;
            if (i10 == 108) {
                r.a supportActionBar = nVar.getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.dispatchMenuVisibilityChanged(true);
                }
            } else {
                nVar.getClass();
            }
            return true;
        }

        @Override // w.i, android.view.Window.Callback
        public void onPanelClosed(int i10, Menu menu) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (this.f18294p) {
                getWrapped().onPanelClosed(i10, menu);
                return;
            }
            super.onPanelClosed(i10, menu);
            n nVar = n.this;
            if (i10 == 108) {
                r.a supportActionBar = nVar.getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.dispatchMenuVisibilityChanged(false);
                    return;
                }
                return;
            }
            if (i10 != 0) {
                nVar.getClass();
                return;
            }
            o panelState = nVar.getPanelState(i10, true);
            if (panelState.f18316m) {
                nVar.h(panelState, false);
            }
        }

        @Override // w.i, android.view.Window.Callback
        public boolean onPreparePanel(int i10, View view, Menu menu) {
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (i10 == 0 && eVar == null) {
                return false;
            }
            if (eVar != null) {
                eVar.setOverrideVisibleItems(true);
            }
            c cVar = this.f18291m;
            boolean zOnPreparePanel = cVar != null && ((b0.e) cVar).onPreparePanel(i10);
            if (!zOnPreparePanel) {
                zOnPreparePanel = super.onPreparePanel(i10, view, menu);
            }
            if (eVar != null) {
                eVar.setOverrideVisibleItems(false);
            }
            return zOnPreparePanel;
        }

        @Override // w.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i10) {
            androidx.appcompat.view.menu.e eVar;
            o panelState = n.this.getPanelState(0, true);
            if (panelState == null || (eVar = panelState.f18311h) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i10);
            } else {
                super.onProvideKeyboardShortcuts(list, eVar, i10);
            }
        }

        @Override // w.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            n nVar = n.this;
            if (!nVar.isHandleNativeActionModesEnabled()) {
                return super.onWindowStartingActionMode(callback);
            }
            f.a aVar = new f.a(nVar.f18280v, callback);
            w.b bVarStartSupportActionMode = nVar.startSupportActionMode(aVar);
            if (bVarStartSupportActionMode != null) {
                return aVar.getActionModeWrapper(bVarStartSupportActionMode);
            }
            return null;
        }

        @Override // w.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            n nVar = n.this;
            if (nVar.isHandleNativeActionModesEnabled() && i10 == 0) {
                f.a aVar = new f.a(nVar.f18280v, callback);
                w.b bVarStartSupportActionMode = nVar.startSupportActionMode(aVar);
                if (bVarStartSupportActionMode != null) {
                    return aVar.getActionModeWrapper(bVarStartSupportActionMode);
                }
                return null;
            }
            return super.onWindowStartingActionMode(callback, i10);
        }
    }

    @Override // r.m
    public void setContentView(int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        l();
        ViewGroup viewGroup = (ViewGroup) this.M.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f18280v).inflate(i10, viewGroup);
        this.f18282x.bypassOnContentChanged(this.f18281w.getCallback());
    }

    @Override // r.m
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        l();
        ViewGroup viewGroup = (ViewGroup) this.M.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f18282x.bypassOnContentChanged(this.f18281w.getCallback());
    }

    @Override // r.m
    public void onSaveInstanceState(Bundle bundle) {
    }
}
