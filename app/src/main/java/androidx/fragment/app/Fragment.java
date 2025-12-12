package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.y;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.a0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.l, androidx.lifecycle.e0, androidx.lifecycle.f, j2.c {

    /* renamed from: g0, reason: collision with root package name */
    public static final Object f2667g0 = new Object();
    public boolean A;
    public boolean B;
    public int C;
    public y D;
    public u<?> E;
    public Fragment G;
    public int H;
    public int I;
    public String J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean Q;
    public ViewGroup R;
    public View S;
    public boolean T;
    public c V;
    public boolean W;
    public boolean X;
    public String Y;

    /* renamed from: a0, reason: collision with root package name */
    public androidx.lifecycle.m f2668a0;

    /* renamed from: b0, reason: collision with root package name */
    public l0 f2670b0;

    /* renamed from: d0, reason: collision with root package name */
    public j2.b f2672d0;

    /* renamed from: e0, reason: collision with root package name */
    public final ArrayList<d> f2673e0;

    /* renamed from: f0, reason: collision with root package name */
    public final a f2674f0;

    /* renamed from: m, reason: collision with root package name */
    public Bundle f2675m;

    /* renamed from: n, reason: collision with root package name */
    public SparseArray<Parcelable> f2676n;

    /* renamed from: o, reason: collision with root package name */
    public Bundle f2677o;

    /* renamed from: p, reason: collision with root package name */
    public Boolean f2678p;

    /* renamed from: r, reason: collision with root package name */
    public Bundle f2680r;

    /* renamed from: s, reason: collision with root package name */
    public Fragment f2681s;

    /* renamed from: u, reason: collision with root package name */
    public int f2683u;

    /* renamed from: w, reason: collision with root package name */
    public boolean f2685w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f2686x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f2687y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f2688z;

    /* renamed from: b, reason: collision with root package name */
    public int f2669b = -1;

    /* renamed from: q, reason: collision with root package name */
    public String f2679q = UUID.randomUUID().toString();

    /* renamed from: t, reason: collision with root package name */
    public String f2682t = null;

    /* renamed from: v, reason: collision with root package name */
    public Boolean f2684v = null;
    public z F = new z();
    public boolean P = true;
    public boolean U = true;
    public Lifecycle.State Z = Lifecycle.State.RESUMED;

    /* renamed from: c0, reason: collision with root package name */
    public final androidx.lifecycle.r<androidx.lifecycle.l> f2671c0 = new androidx.lifecycle.r<>();

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    public class a extends d {
        public a() {
        }

        @Override // androidx.fragment.app.Fragment.d
        public final void a() {
            Fragment fragment = Fragment.this;
            fragment.f2672d0.performAttach();
            SavedStateHandleSupport.enableSavedStateHandles(fragment);
        }
    }

    public class b extends r {
        public b() {
        }

        @Override // androidx.fragment.app.r
        public View onFindViewById(int i10) {
            Fragment fragment = Fragment.this;
            View view = fragment.S;
            if (view != null) {
                return view.findViewById(i10);
            }
            throw new IllegalStateException("Fragment " + fragment + " does not have a view");
        }

        @Override // androidx.fragment.app.r
        public boolean onHasView() {
            return Fragment.this.S != null;
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f2692a;

        /* renamed from: b, reason: collision with root package name */
        public int f2693b;

        /* renamed from: c, reason: collision with root package name */
        public int f2694c;

        /* renamed from: d, reason: collision with root package name */
        public int f2695d;

        /* renamed from: e, reason: collision with root package name */
        public int f2696e;

        /* renamed from: f, reason: collision with root package name */
        public int f2697f;

        /* renamed from: g, reason: collision with root package name */
        public ArrayList<String> f2698g;

        /* renamed from: h, reason: collision with root package name */
        public ArrayList<String> f2699h;

        /* renamed from: i, reason: collision with root package name */
        public final Object f2700i;

        /* renamed from: j, reason: collision with root package name */
        public final Object f2701j;

        /* renamed from: k, reason: collision with root package name */
        public final Object f2702k;

        /* renamed from: l, reason: collision with root package name */
        public float f2703l;

        /* renamed from: m, reason: collision with root package name */
        public View f2704m;

        public c() {
            Object obj = Fragment.f2667g0;
            this.f2700i = obj;
            this.f2701j = obj;
            this.f2702k = obj;
            this.f2703l = 1.0f;
            this.f2704m = null;
        }
    }

    public static abstract class d {
        public abstract void a();
    }

    public Fragment() {
        new AtomicInteger();
        this.f2673e0 = new ArrayList<>();
        this.f2674f0 = new a();
        e();
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) throws IllegalAccessException, java.lang.InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            Fragment fragmentNewInstance = t.loadFragmentClass(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragmentNewInstance.getClass().getClassLoader());
                fragmentNewInstance.setArguments(bundle);
            }
            return fragmentNewInstance;
        } catch (IllegalAccessException e10) {
            throw new InstantiationException(ac.c.k("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e10);
        } catch (java.lang.InstantiationException e11) {
            throw new InstantiationException(ac.c.k("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e11);
        } catch (NoSuchMethodException e12) {
            throw new InstantiationException(ac.c.k("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e12);
        } catch (InvocationTargetException e13) {
            throw new InstantiationException(ac.c.k("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e13);
        }
    }

    public r a() {
        return new b();
    }

    public final c b() {
        if (this.V == null) {
            this.V = new c();
        }
        return this.V;
    }

    public final Fragment c(String str) {
        return str.equals(this.f2679q) ? this : this.F.f2940c.d(str);
    }

    public final int d() {
        Lifecycle.State state = this.Z;
        return (state == Lifecycle.State.INITIALIZED || this.G == null) ? state.ordinal() : Math.min(state.ordinal(), this.G.d());
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.H));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.I));
        printWriter.print(" mTag=");
        printWriter.println(this.J);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f2669b);
        printWriter.print(" mWho=");
        printWriter.print(this.f2679q);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.C);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f2685w);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f2686x);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f2687y);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f2688z);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.K);
        printWriter.print(" mDetached=");
        printWriter.print(this.L);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.P);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.O);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.M);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.U);
        if (this.D != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.D);
        }
        if (this.E != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.E);
        }
        if (this.G != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.G);
        }
        if (this.f2680r != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f2680r);
        }
        if (this.f2675m != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f2675m);
        }
        if (this.f2676n != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f2676n);
        }
        if (this.f2677o != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f2677o);
        }
        Fragment fragmentZ = this.f2681s;
        if (fragmentZ == null) {
            y yVar = this.D;
            fragmentZ = (yVar == null || (str2 = this.f2682t) == null) ? null : yVar.z(str2);
        }
        if (fragmentZ != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(fragmentZ);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f2683u);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        c cVar = this.V;
        printWriter.println(cVar == null ? false : cVar.f2692a);
        c cVar2 = this.V;
        if ((cVar2 == null ? 0 : cVar2.f2693b) != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            c cVar3 = this.V;
            printWriter.println(cVar3 == null ? 0 : cVar3.f2693b);
        }
        c cVar4 = this.V;
        if ((cVar4 == null ? 0 : cVar4.f2694c) != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            c cVar5 = this.V;
            printWriter.println(cVar5 == null ? 0 : cVar5.f2694c);
        }
        c cVar6 = this.V;
        if ((cVar6 == null ? 0 : cVar6.f2695d) != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            c cVar7 = this.V;
            printWriter.println(cVar7 == null ? 0 : cVar7.f2695d);
        }
        c cVar8 = this.V;
        if ((cVar8 == null ? 0 : cVar8.f2696e) != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            c cVar9 = this.V;
            printWriter.println(cVar9 != null ? cVar9.f2696e : 0);
        }
        if (this.R != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.R);
        }
        if (this.S != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.S);
        }
        if (getContext() != null) {
            v1.a.getInstance(this).dump(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.F + ":");
        this.F.dump(ac.c.B(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final void e() {
        this.f2668a0 = new androidx.lifecycle.m(this);
        this.f2672d0 = j2.b.create(this);
        ArrayList<d> arrayList = this.f2673e0;
        a aVar = this.f2674f0;
        if (arrayList.contains(aVar)) {
            return;
        }
        if (this.f2669b >= 0) {
            aVar.a();
        } else {
            arrayList.add(aVar);
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final void f() {
        e();
        this.Y = this.f2679q;
        this.f2679q = UUID.randomUUID().toString();
        this.f2685w = false;
        this.f2686x = false;
        this.f2687y = false;
        this.f2688z = false;
        this.A = false;
        this.C = 0;
        this.D = null;
        this.F = new z();
        this.E = null;
        this.H = 0;
        this.I = 0;
        this.J = null;
        this.K = false;
        this.L = false;
    }

    public final boolean g() {
        return this.C > 0;
    }

    public final p getActivity() {
        u<?> uVar = this.E;
        if (uVar == null) {
            return null;
        }
        return (p) uVar.f2927b;
    }

    public boolean getAllowEnterTransitionOverlap() {
        c cVar = this.V;
        if (cVar == null) {
            return true;
        }
        cVar.getClass();
        return true;
    }

    public boolean getAllowReturnTransitionOverlap() {
        c cVar = this.V;
        if (cVar == null) {
            return true;
        }
        cVar.getClass();
        return true;
    }

    public final Bundle getArguments() {
        return this.f2680r;
    }

    public final y getChildFragmentManager() {
        if (this.E != null) {
            return this.F;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Context getContext() {
        u<?> uVar = this.E;
        if (uVar == null) {
            return null;
        }
        return uVar.f2928m;
    }

    @Override // androidx.lifecycle.f
    public u1.a getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && y.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        u1.d dVar = new u1.d();
        if (application != null) {
            dVar.set(a0.a.f3485b, application);
        }
        dVar.set(SavedStateHandleSupport.f3465a, this);
        dVar.set(SavedStateHandleSupport.f3466b, this);
        if (getArguments() != null) {
            dVar.set(SavedStateHandleSupport.f3467c, getArguments());
        }
        return dVar;
    }

    public Object getEnterTransition() {
        c cVar = this.V;
        if (cVar == null) {
            return null;
        }
        cVar.getClass();
        return null;
    }

    public Object getExitTransition() {
        c cVar = this.V;
        if (cVar == null) {
            return null;
        }
        cVar.getClass();
        return null;
    }

    public final Object getHost() {
        u<?> uVar = this.E;
        if (uVar == null) {
            return null;
        }
        return uVar.onGetHost();
    }

    public final int getId() {
        return this.H;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        u<?> uVar = this.E;
        if (uVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterOnGetLayoutInflater = uVar.onGetLayoutInflater();
        x0.j.setFactory2(layoutInflaterOnGetLayoutInflater, this.F.f2943f);
        return layoutInflaterOnGetLayoutInflater;
    }

    @Override // androidx.lifecycle.l
    public Lifecycle getLifecycle() {
        return this.f2668a0;
    }

    public final Fragment getParentFragment() {
        return this.G;
    }

    public final y getParentFragmentManager() {
        y yVar = this.D;
        if (yVar != null) {
            return yVar;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public Object getReenterTransition() {
        c cVar = this.V;
        if (cVar == null) {
            return null;
        }
        Object obj = cVar.f2701j;
        return obj == f2667g0 ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        FragmentStrictMode.onGetRetainInstanceUsage(this);
        return this.M;
    }

    public Object getReturnTransition() {
        c cVar = this.V;
        if (cVar == null) {
            return null;
        }
        Object obj = cVar.f2700i;
        return obj == f2667g0 ? getEnterTransition() : obj;
    }

    @Override // j2.c
    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.f2672d0.getSavedStateRegistry();
    }

    public Object getSharedElementEnterTransition() {
        c cVar = this.V;
        if (cVar == null) {
            return null;
        }
        cVar.getClass();
        return null;
    }

    public Object getSharedElementReturnTransition() {
        c cVar = this.V;
        if (cVar == null) {
            return null;
        }
        Object obj = cVar.f2702k;
        return obj == f2667g0 ? getSharedElementEnterTransition() : obj;
    }

    public final String getString(int i10) {
        return getResources().getString(i10);
    }

    public final String getTag() {
        return this.J;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        String str;
        FragmentStrictMode.onGetTargetFragmentUsage(this);
        Fragment fragment = this.f2681s;
        if (fragment != null) {
            return fragment;
        }
        y yVar = this.D;
        if (yVar == null || (str = this.f2682t) == null) {
            return null;
        }
        return yVar.z(str);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        FragmentStrictMode.onGetTargetFragmentRequestCodeUsage(this);
        return this.f2683u;
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.U;
    }

    public View getView() {
        return this.S;
    }

    public LiveData<androidx.lifecycle.l> getViewLifecycleOwnerLiveData() {
        return this.f2671c0;
    }

    @Override // androidx.lifecycle.e0
    public androidx.lifecycle.d0 getViewModelStore() {
        if (this.D == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (d() == 1) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        HashMap<String, androidx.lifecycle.d0> map = this.D.M.f2765e;
        androidx.lifecycle.d0 d0Var = map.get(this.f2679q);
        if (d0Var != null) {
            return d0Var;
        }
        androidx.lifecycle.d0 d0Var2 = new androidx.lifecycle.d0();
        map.put(this.f2679q, d0Var2);
        return d0Var2;
    }

    public final boolean h(MenuItem menuItem) {
        if (this.K) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.F.i(menuItem);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean i(Menu menu, MenuInflater menuInflater) {
        boolean z10 = false;
        if (this.K) {
            return false;
        }
        if (this.O && this.P) {
            onCreateOptionsMenu(menu, menuInflater);
            z10 = true;
        }
        return z10 | this.F.j(menu, menuInflater);
    }

    public final boolean isAdded() {
        return this.E != null && this.f2685w;
    }

    public final boolean isDetached() {
        return this.L;
    }

    public final boolean isHidden() {
        if (!this.K) {
            y yVar = this.D;
            if (yVar == null) {
                return false;
            }
            Fragment fragment = this.G;
            yVar.getClass();
            if (!(fragment == null ? false : fragment.isHidden())) {
                return false;
            }
        }
        return true;
    }

    public final boolean isInLayout() {
        return this.f2688z;
    }

    public final boolean isMenuVisible() {
        if (this.P) {
            if (this.D == null) {
                return true;
            }
            Fragment fragment = this.G;
            if (fragment == null ? true : fragment.isMenuVisible()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isRemoving() {
        return this.f2686x;
    }

    public final boolean isResumed() {
        return this.f2669b >= 7;
    }

    public final boolean isStateSaved() {
        y yVar = this.D;
        if (yVar == null) {
            return false;
        }
        return yVar.isStateSaved();
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.S) == null || view.getWindowToken() == null || this.S.getVisibility() != 0) ? false : true;
    }

    public void j(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.F.H();
        this.B = true;
        this.f2670b0 = new l0(this, getViewModelStore());
        View viewOnCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.S = viewOnCreateView;
        if (viewOnCreateView == null) {
            if (this.f2670b0.f2867n != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.f2670b0 = null;
        } else {
            this.f2670b0.b();
            androidx.lifecycle.f0.set(this.S, this.f2670b0);
            androidx.lifecycle.g0.set(this.S, this.f2670b0);
            androidx.savedstate.b.set(this.S, this.f2670b0);
            this.f2671c0.setValue(this.f2670b0);
        }
    }

    public final boolean k(MenuItem menuItem) {
        if (this.K) {
            return false;
        }
        if (this.O && this.P && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.F.o(menuItem);
    }

    public final void l(Menu menu) {
        if (this.K) {
            return;
        }
        if (this.O && this.P) {
            onOptionsMenuClosed(menu);
        }
        this.F.p(menu);
    }

    public final boolean m(Menu menu) {
        boolean z10 = false;
        if (this.K) {
            return false;
        }
        if (this.O && this.P) {
            onPrepareOptionsMenu(menu);
            z10 = true;
        }
        return z10 | this.F.s(menu);
    }

    public final void n(int i10, int i11, int i12, int i13) {
        if (this.V == null && i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            return;
        }
        b().f2693b = i10;
        b().f2694c = i11;
        b().f2695d = i12;
        b().f2696e = i13;
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.Q = true;
    }

    @Deprecated
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (y.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i10 + " resultCode: " + i11 + " data: " + intent);
        }
    }

    public void onAttach(Context context) {
        this.Q = true;
        u<?> uVar = this.E;
        Activity activity = uVar == null ? null : uVar.f2927b;
        if (activity != null) {
            this.Q = false;
            onAttach(activity);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.Q = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        Parcelable parcelable;
        this.Q = true;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            this.F.M(parcelable);
            z zVar = this.F;
            zVar.F = false;
            zVar.G = false;
            zVar.M.f2768h = false;
            zVar.t(1);
        }
        z zVar2 = this.F;
        if (zVar2.f2957t >= 1) {
            return;
        }
        zVar2.F = false;
        zVar2.G = false;
        zVar2.M.f2768h = false;
        zVar2.t(1);
    }

    public Animation onCreateAnimation(int i10, boolean z10, int i11) {
        return null;
    }

    public Animator onCreateAnimator(int i10, boolean z10, int i11) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void onDestroy() {
        this.Q = true;
    }

    public void onDestroyView() {
        this.Q = true;
    }

    public void onDetach() {
        this.Q = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.Q = true;
        u<?> uVar = this.E;
        Activity activity = uVar == null ? null : uVar.f2927b;
        if (activity != null) {
            this.Q = false;
            onInflate(activity, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.Q = true;
    }

    @Deprecated
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onPause() {
        this.Q = true;
    }

    public void onResume() {
        this.Q = true;
    }

    public void onStart() {
        this.Q = true;
    }

    public void onStop() {
        this.Q = true;
    }

    public void onViewStateRestored(Bundle bundle) {
        this.Q = true;
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public final p requireActivity() {
        p activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public void setArguments(Bundle bundle) {
        if (this.D != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f2680r = bundle;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean z10) {
        if (this.O != z10) {
            this.O = z10;
            if (!isAdded() || isHidden()) {
                return;
            }
            this.E.onSupportInvalidateOptionsMenu();
        }
    }

    public void setMenuVisibility(boolean z10) {
        if (this.P != z10) {
            this.P = z10;
            if (this.O && isAdded() && !isHidden()) {
                this.E.onSupportInvalidateOptionsMenu();
            }
        }
    }

    @Deprecated
    public void setRetainInstance(boolean z10) {
        FragmentStrictMode.onSetRetainInstanceUsage(this);
        this.M = z10;
        y yVar = this.D;
        if (yVar == null) {
            this.N = true;
        } else if (z10) {
            yVar.M.a(this);
        } else {
            yVar.M.d(this);
        }
    }

    @Deprecated
    public void setUserVisibleHint(boolean z10) {
        FragmentStrictMode.onSetUserVisibleHint(this, z10);
        if (!this.U && z10 && this.f2669b < 5 && this.D != null && isAdded() && this.X) {
            y yVar = this.D;
            e0 e0VarF = yVar.f(this);
            Fragment fragment = e0VarF.f2794c;
            if (fragment.T) {
                if (yVar.f2939b) {
                    yVar.I = true;
                } else {
                    fragment.T = false;
                    e0VarF.k();
                }
            }
        }
        this.U = z10;
        this.T = this.f2669b < 5 && !z10;
        if (this.f2675m != null) {
            this.f2678p = Boolean.valueOf(z10);
        }
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i10) {
        startActivityForResult(intent, i10, null);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(getClass().getSimpleName());
        sb2.append("{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} (");
        sb2.append(this.f2679q);
        if (this.H != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.H));
        }
        if (this.J != null) {
            sb2.append(" tag=");
            sb2.append(this.J);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        u<?> uVar = this.E;
        if (uVar != null) {
            uVar.onStartActivityFromFragment(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i10, Bundle bundle) {
        if (this.E == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        y parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.A == null) {
            parentFragmentManager.f2958u.onStartActivityFromFragment(this, intent, i10, bundle);
            return;
        }
        parentFragmentManager.D.addLast(new y.k(this.f2679q, i10));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        parentFragmentManager.A.launch(intent);
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.Q = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.Q = true;
    }

    @Deprecated
    public void onDestroyOptionsMenu() {
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    public void onHiddenChanged(boolean z10) {
    }

    public void onMultiWindowModeChanged(boolean z10) {
    }

    @Deprecated
    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPictureInPictureModeChanged(boolean z10) {
    }

    @Deprecated
    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z10) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    @Deprecated
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
    }
}
