package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.f;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
public abstract class y {
    public androidx.activity.result.c<Intent> A;
    public androidx.activity.result.c<androidx.activity.result.f> B;
    public androidx.activity.result.c<String[]> C;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public ArrayList<androidx.fragment.app.a> J;
    public ArrayList<Boolean> K;
    public ArrayList<Fragment> L;
    public b0 M;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2939b;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<androidx.fragment.app.a> f2941d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<Fragment> f2942e;

    /* renamed from: g, reason: collision with root package name */
    public OnBackPressedDispatcher f2944g;

    /* renamed from: o, reason: collision with root package name */
    public final x f2952o;

    /* renamed from: p, reason: collision with root package name */
    public final x f2953p;

    /* renamed from: q, reason: collision with root package name */
    public final x f2954q;

    /* renamed from: r, reason: collision with root package name */
    public final x f2955r;

    /* renamed from: u, reason: collision with root package name */
    public u<?> f2958u;

    /* renamed from: v, reason: collision with root package name */
    public r f2959v;

    /* renamed from: w, reason: collision with root package name */
    public Fragment f2960w;

    /* renamed from: x, reason: collision with root package name */
    public Fragment f2961x;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<l> f2938a = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final f0 f2940c = new f0(0);

    /* renamed from: f, reason: collision with root package name */
    public final v f2943f = new v(this);

    /* renamed from: h, reason: collision with root package name */
    public final b f2945h = new b();

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f2946i = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    public final Map<String, androidx.fragment.app.c> f2947j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k, reason: collision with root package name */
    public final Map<String, Bundle> f2948k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l, reason: collision with root package name */
    public final Map<String, Object> f2949l = Collections.synchronizedMap(new HashMap());

    /* renamed from: m, reason: collision with root package name */
    public final w f2950m = new w(this);

    /* renamed from: n, reason: collision with root package name */
    public final CopyOnWriteArrayList<c0> f2951n = new CopyOnWriteArrayList<>();

    /* renamed from: s, reason: collision with root package name */
    public final c f2956s = new c();

    /* renamed from: t, reason: collision with root package name */
    public int f2957t = -1;

    /* renamed from: y, reason: collision with root package name */
    public final d f2962y = new d();

    /* renamed from: z, reason: collision with root package name */
    public final e f2963z = new e();
    public ArrayDeque<k> D = new ArrayDeque<>();
    public final f N = new f();

    /* compiled from: FragmentManager.java */
    public class a implements androidx.activity.result.b<Map<String, Boolean>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f2964a;

        public a(z zVar) {
            this.f2964a = zVar;
        }

        @Override // androidx.activity.result.b
        @SuppressLint({"SyntheticAccessor"})
        public void onActivityResult(Map<String, Boolean> map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                iArr[i10] = ((Boolean) arrayList.get(i10)).booleanValue() ? 0 : -1;
            }
            y yVar = this.f2964a;
            k kVarPollFirst = yVar.D.pollFirst();
            if (kVarPollFirst == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            f0 f0Var = yVar.f2940c;
            String str = kVarPollFirst.f2972b;
            Fragment fragmentD = f0Var.d(str);
            if (fragmentD != null) {
                fragmentD.onRequestPermissionsResult(kVarPollFirst.f2973m, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    /* compiled from: FragmentManager.java */
    public class b extends androidx.activity.k {
        public b() {
            super(false);
        }

        @Override // androidx.activity.k
        public void handleOnBackPressed() {
            y yVar = y.this;
            yVar.w(true);
            if (yVar.f2945h.isEnabled()) {
                yVar.popBackStackImmediate();
            } else {
                yVar.f2944g.onBackPressed();
            }
        }
    }

    /* compiled from: FragmentManager.java */
    public class c implements x0.o {
        public c() {
        }

        @Override // x0.o
        public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
            y.this.j(menu, menuInflater);
        }

        @Override // x0.o
        public void onMenuClosed(Menu menu) {
            y.this.p(menu);
        }

        @Override // x0.o
        public boolean onMenuItemSelected(MenuItem menuItem) {
            return y.this.o(menuItem);
        }

        @Override // x0.o
        public void onPrepareMenu(Menu menu) {
            y.this.s(menu);
        }
    }

    /* compiled from: FragmentManager.java */
    public class d extends t {
        public d() {
        }

        @Override // androidx.fragment.app.t
        public Fragment instantiate(ClassLoader classLoader, String str) {
            y yVar = y.this;
            return yVar.getHost().instantiate(yVar.getHost().f2928m, str, null);
        }
    }

    /* compiled from: FragmentManager.java */
    public class e implements n0 {
        public SpecialEffectsController createController(ViewGroup viewGroup) {
            return new androidx.fragment.app.m(viewGroup);
        }
    }

    /* compiled from: FragmentManager.java */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.w(true);
        }
    }

    /* compiled from: FragmentManager.java */
    public class g implements c0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f2969b;

        public g(Fragment fragment) {
            this.f2969b = fragment;
        }

        @Override // androidx.fragment.app.c0
        public void onAttachFragment(y yVar, Fragment fragment) {
            this.f2969b.onAttachFragment(fragment);
        }
    }

    /* compiled from: FragmentManager.java */
    public class h implements androidx.activity.result.b<androidx.activity.result.a> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f2970a;

        public h(z zVar) {
            this.f2970a = zVar;
        }

        @Override // androidx.activity.result.b
        public void onActivityResult(androidx.activity.result.a aVar) {
            y yVar = this.f2970a;
            k kVarPollFirst = yVar.D.pollFirst();
            if (kVarPollFirst == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            f0 f0Var = yVar.f2940c;
            String str = kVarPollFirst.f2972b;
            Fragment fragmentD = f0Var.d(str);
            if (fragmentD == null) {
                Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
            } else {
                fragmentD.onActivityResult(kVarPollFirst.f2973m, aVar.getResultCode(), aVar.getData());
            }
        }
    }

    /* compiled from: FragmentManager.java */
    public class i implements androidx.activity.result.b<androidx.activity.result.a> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f2971a;

        public i(z zVar) {
            this.f2971a = zVar;
        }

        @Override // androidx.activity.result.b
        public void onActivityResult(androidx.activity.result.a aVar) {
            y yVar = this.f2971a;
            k kVarPollFirst = yVar.D.pollFirst();
            if (kVarPollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            f0 f0Var = yVar.f2940c;
            String str = kVarPollFirst.f2972b;
            Fragment fragmentD = f0Var.d(str);
            if (fragmentD == null) {
                Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
            } else {
                fragmentD.onActivityResult(kVarPollFirst.f2973m, aVar.getResultCode(), aVar.getData());
            }
        }
    }

    /* compiled from: FragmentManager.java */
    public static class j extends q.a<androidx.activity.result.f, androidx.activity.result.a> {
        @Override // q.a
        public Intent createIntent(Context context, androidx.activity.result.f fVar) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent fillInIntent = fVar.getFillInIntent();
            if (fillInIntent != null && (bundleExtra = fillInIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                fillInIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (fillInIntent.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    fVar = new f.a(fVar.getIntentSender()).setFillInIntent(null).setFlags(fVar.getFlagsValues(), fVar.getFlagsMask()).build();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", fVar);
            if (y.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // q.a
        public androidx.activity.result.a parseResult(int i10, Intent intent) {
            return new androidx.activity.result.a(i10, intent);
        }
    }

    /* compiled from: FragmentManager.java */
    public interface l {
        boolean generateOps(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* compiled from: FragmentManager.java */
    public class m implements l {

        /* renamed from: a, reason: collision with root package name */
        public final int f2974a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2975b = 1;

        public m(int i10) {
            this.f2974a = i10;
        }

        @Override // androidx.fragment.app.y.l
        public boolean generateOps(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = y.this.f2961x;
            if (fragment == null || this.f2974a >= 0 || !fragment.getChildFragmentManager().popBackStackImmediate()) {
                return y.this.J(arrayList, arrayList2, null, this.f2974a, this.f2975b);
            }
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [androidx.fragment.app.x] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.fragment.app.x] */
    /* JADX WARN: Type inference failed for: r0v15, types: [androidx.fragment.app.x] */
    /* JADX WARN: Type inference failed for: r0v16, types: [androidx.fragment.app.x] */
    public y() {
        final int i10 = 0;
        this.f2952o = new w0.a(this) { // from class: androidx.fragment.app.x

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ y f2937b;

            {
                this.f2937b = this;
            }

            @Override // w0.a
            public final void accept(Object obj) {
                int i11 = i10;
                y yVar = this.f2937b;
                switch (i11) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (yVar.E()) {
                            yVar.h(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (yVar.E() && num.intValue() == 80) {
                            yVar.l(false);
                            break;
                        }
                        break;
                    case 2:
                        l0.l lVar = (l0.l) obj;
                        if (yVar.E()) {
                            yVar.m(lVar.isInMultiWindowMode(), false);
                            break;
                        }
                        break;
                    default:
                        l0.x xVar = (l0.x) obj;
                        if (yVar.E()) {
                            yVar.r(xVar.isInPictureInPictureMode(), false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i11 = 1;
        this.f2953p = new w0.a(this) { // from class: androidx.fragment.app.x

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ y f2937b;

            {
                this.f2937b = this;
            }

            @Override // w0.a
            public final void accept(Object obj) {
                int i112 = i11;
                y yVar = this.f2937b;
                switch (i112) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (yVar.E()) {
                            yVar.h(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (yVar.E() && num.intValue() == 80) {
                            yVar.l(false);
                            break;
                        }
                        break;
                    case 2:
                        l0.l lVar = (l0.l) obj;
                        if (yVar.E()) {
                            yVar.m(lVar.isInMultiWindowMode(), false);
                            break;
                        }
                        break;
                    default:
                        l0.x xVar = (l0.x) obj;
                        if (yVar.E()) {
                            yVar.r(xVar.isInPictureInPictureMode(), false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i12 = 2;
        this.f2954q = new w0.a(this) { // from class: androidx.fragment.app.x

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ y f2937b;

            {
                this.f2937b = this;
            }

            @Override // w0.a
            public final void accept(Object obj) {
                int i112 = i12;
                y yVar = this.f2937b;
                switch (i112) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (yVar.E()) {
                            yVar.h(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (yVar.E() && num.intValue() == 80) {
                            yVar.l(false);
                            break;
                        }
                        break;
                    case 2:
                        l0.l lVar = (l0.l) obj;
                        if (yVar.E()) {
                            yVar.m(lVar.isInMultiWindowMode(), false);
                            break;
                        }
                        break;
                    default:
                        l0.x xVar = (l0.x) obj;
                        if (yVar.E()) {
                            yVar.r(xVar.isInPictureInPictureMode(), false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i13 = 3;
        this.f2955r = new w0.a(this) { // from class: androidx.fragment.app.x

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ y f2937b;

            {
                this.f2937b = this;
            }

            @Override // w0.a
            public final void accept(Object obj) {
                int i112 = i13;
                y yVar = this.f2937b;
                switch (i112) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (yVar.E()) {
                            yVar.h(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (yVar.E() && num.intValue() == 80) {
                            yVar.l(false);
                            break;
                        }
                        break;
                    case 2:
                        l0.l lVar = (l0.l) obj;
                        if (yVar.E()) {
                            yVar.m(lVar.isInMultiWindowMode(), false);
                            break;
                        }
                        break;
                    default:
                        l0.x xVar = (l0.x) obj;
                        if (yVar.E()) {
                            yVar.r(xVar.isInPictureInPictureMode(), false);
                            break;
                        }
                        break;
                }
            }
        };
    }

    public static boolean D(Fragment fragment) {
        boolean z10;
        if (fragment.O && fragment.P) {
            return true;
        }
        Iterator it = fragment.F.f2940c.f().iterator();
        boolean zD = false;
        while (true) {
            if (!it.hasNext()) {
                z10 = false;
                break;
            }
            Fragment fragment2 = (Fragment) it.next();
            if (fragment2 != null) {
                zD = D(fragment2);
            }
            if (zD) {
                z10 = true;
                break;
            }
        }
        return z10;
    }

    public static boolean F(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        y yVar = fragment.D;
        return fragment.equals(yVar.getPrimaryNavigationFragment()) && F(yVar.f2960w);
    }

    public static void T(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.K) {
            fragment.K = false;
            fragment.W = !fragment.W;
        }
    }

    public static boolean isLoggingEnabled(int i10) {
        return Log.isLoggable("FragmentManager", i10);
    }

    public final ViewGroup A(Fragment fragment) {
        ViewGroup viewGroup = fragment.R;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.I > 0 && this.f2959v.onHasView()) {
            View viewOnFindViewById = this.f2959v.onFindViewById(fragment.I);
            if (viewOnFindViewById instanceof ViewGroup) {
                return (ViewGroup) viewOnFindViewById;
            }
        }
        return null;
    }

    public final n0 B() {
        Fragment fragment = this.f2960w;
        return fragment != null ? fragment.D.B() : this.f2963z;
    }

    public final void C(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.K) {
            return;
        }
        fragment.K = true;
        fragment.W = true ^ fragment.W;
        S(fragment);
    }

    public final boolean E() {
        Fragment fragment = this.f2960w;
        if (fragment == null) {
            return true;
        }
        return fragment.isAdded() && this.f2960w.getParentFragmentManager().E();
    }

    public final void G(int i10, boolean z10) {
        Cloneable cloneable;
        u<?> uVar;
        if (this.f2958u == null && i10 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z10 || i10 != this.f2957t) {
            this.f2957t = i10;
            f0 f0Var = this.f2940c;
            Iterator it = ((ArrayList) f0Var.f2800a).iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                cloneable = f0Var.f2801b;
                if (!zHasNext) {
                    break;
                }
                e0 e0Var = (e0) ((HashMap) cloneable).get(((Fragment) it.next()).f2679q);
                if (e0Var != null) {
                    e0Var.k();
                }
            }
            Iterator it2 = ((HashMap) cloneable).values().iterator();
            while (true) {
                boolean z11 = false;
                if (!it2.hasNext()) {
                    break;
                }
                e0 e0Var2 = (e0) it2.next();
                if (e0Var2 != null) {
                    e0Var2.k();
                    Fragment fragment = e0Var2.f2794c;
                    if (fragment.f2686x && !fragment.g()) {
                        z11 = true;
                    }
                    if (z11) {
                        f0Var.i(e0Var2);
                    }
                }
            }
            U();
            if (this.E && (uVar = this.f2958u) != null && this.f2957t == 7) {
                uVar.onSupportInvalidateOptionsMenu();
                this.E = false;
            }
        }
    }

    public final void H() {
        if (this.f2958u == null) {
            return;
        }
        this.F = false;
        this.G = false;
        this.M.f2768h = false;
        for (Fragment fragment : this.f2940c.g()) {
            if (fragment != null) {
                fragment.F.H();
            }
        }
    }

    public final boolean I(int i10, int i11) {
        w(false);
        v(true);
        Fragment fragment = this.f2961x;
        if (fragment != null && i10 < 0 && fragment.getChildFragmentManager().popBackStackImmediate()) {
            return true;
        }
        boolean zJ = J(this.J, this.K, null, i10, i11);
        if (zJ) {
            this.f2939b = true;
            try {
                L(this.J, this.K);
            } finally {
                d();
            }
        }
        W();
        if (this.I) {
            this.I = false;
            U();
        }
        this.f2940c.b();
        return zJ;
    }

    public final boolean J(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i10, int i11) {
        boolean z10 = (i11 & 1) != 0;
        ArrayList<androidx.fragment.app.a> arrayList3 = this.f2941d;
        int size = -1;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            if (str != null || i10 >= 0) {
                int size2 = this.f2941d.size() - 1;
                while (size2 >= 0) {
                    androidx.fragment.app.a aVar = this.f2941d.get(size2);
                    if ((str != null && str.equals(aVar.getName())) || (i10 >= 0 && i10 == aVar.f2739r)) {
                        break;
                    }
                    size2--;
                }
                if (size2 >= 0) {
                    if (z10) {
                        while (size2 > 0) {
                            int i12 = size2 - 1;
                            androidx.fragment.app.a aVar2 = this.f2941d.get(i12);
                            if ((str == null || !str.equals(aVar2.getName())) && (i10 < 0 || i10 != aVar2.f2739r)) {
                                break;
                            }
                            size2 = i12;
                        }
                    } else if (size2 != this.f2941d.size() - 1) {
                        size2++;
                    }
                    size = size2;
                } else {
                    size = size2;
                }
            } else {
                size = z10 ? 0 : (-1) + this.f2941d.size();
            }
        }
        if (size < 0) {
            return false;
        }
        for (int size3 = this.f2941d.size() - 1; size3 >= size; size3--) {
            arrayList.add(this.f2941d.remove(size3));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void K(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.C);
        }
        boolean z10 = !fragment.g();
        if (!fragment.L || z10) {
            f0 f0Var = this.f2940c;
            synchronized (((ArrayList) f0Var.f2800a)) {
                ((ArrayList) f0Var.f2800a).remove(fragment);
            }
            fragment.f2685w = false;
            if (D(fragment)) {
                this.E = true;
            }
            fragment.f2686x = true;
            S(fragment);
        }
    }

    public final void L(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            if (!arrayList.get(i10).f2823o) {
                if (i11 != i10) {
                    y(arrayList, arrayList2, i11, i10);
                }
                i11 = i10 + 1;
                if (arrayList2.get(i10).booleanValue()) {
                    while (i11 < size && arrayList2.get(i11).booleanValue() && !arrayList.get(i11).f2823o) {
                        i11++;
                    }
                }
                y(arrayList, arrayList2, i10, i11);
                i10 = i11 - 1;
            }
            i10++;
        }
        if (i11 != size) {
            y(arrayList, arrayList2, i11, size);
        }
    }

    public final void M(Parcelable parcelable) {
        w wVar;
        int i10;
        e0 e0Var;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f2958u.f2928m.getClassLoader());
                this.f2948k.put(str.substring(7), bundle2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f2958u.f2928m.getClassLoader());
                arrayList.add((d0) bundle.getParcelable(AdOperationMetric.INIT_STATE));
            }
        }
        f0 f0Var = this.f2940c;
        HashMap map = (HashMap) f0Var.f2802c;
        map.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d0 d0Var = (d0) it.next();
            map.put(d0Var.f2775m, d0Var);
        }
        a0 a0Var = (a0) bundle3.getParcelable(AdOperationMetric.INIT_STATE);
        if (a0Var == null) {
            return;
        }
        Cloneable cloneable = f0Var.f2801b;
        ((HashMap) cloneable).clear();
        Iterator<String> it2 = a0Var.f2740b.iterator();
        while (true) {
            boolean zHasNext = it2.hasNext();
            wVar = this.f2950m;
            if (!zHasNext) {
                break;
            }
            d0 d0VarJ = f0Var.j(it2.next(), null);
            if (d0VarJ != null) {
                Fragment fragment = this.M.f2763c.get(d0VarJ.f2775m);
                if (fragment != null) {
                    if (isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
                    }
                    e0Var = new e0(wVar, f0Var, fragment, d0VarJ);
                } else {
                    e0Var = new e0(this.f2950m, this.f2940c, this.f2958u.f2928m.getClassLoader(), getFragmentFactory(), d0VarJ);
                }
                Fragment fragment2 = e0Var.f2794c;
                fragment2.D = this;
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragment2.f2679q + "): " + fragment2);
                }
                e0Var.m(this.f2958u.f2928m.getClassLoader());
                f0Var.h(e0Var);
                e0Var.f2796e = this.f2957t;
            }
        }
        b0 b0Var = this.M;
        b0Var.getClass();
        Iterator it3 = new ArrayList(b0Var.f2763c.values()).iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Fragment fragment3 = (Fragment) it3.next();
            if ((((HashMap) cloneable).get(fragment3.f2679q) != null ? 1 : 0) == 0) {
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment3 + " that was not found in the set of active Fragments " + a0Var.f2740b);
                }
                this.M.d(fragment3);
                fragment3.D = this;
                e0 e0Var2 = new e0(wVar, f0Var, fragment3);
                e0Var2.f2796e = 1;
                e0Var2.k();
                fragment3.f2686x = true;
                e0Var2.k();
            }
        }
        ArrayList<String> arrayList2 = a0Var.f2741m;
        ((ArrayList) f0Var.f2800a).clear();
        if (arrayList2 != null) {
            for (String str3 : arrayList2) {
                Fragment fragmentC = f0Var.c(str3);
                if (fragmentC == null) {
                    throw new IllegalStateException(ac.c.k("No instantiated fragment for (", str3, ")"));
                }
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str3 + "): " + fragmentC);
                }
                f0Var.a(fragmentC);
            }
        }
        if (a0Var.f2742n != null) {
            this.f2941d = new ArrayList<>(a0Var.f2742n.length);
            int i11 = 0;
            while (true) {
                androidx.fragment.app.b[] bVarArr = a0Var.f2742n;
                if (i11 >= bVarArr.length) {
                    break;
                }
                androidx.fragment.app.a aVarInstantiate = bVarArr[i11].instantiate(this);
                if (isLoggingEnabled(2)) {
                    StringBuilder sbS = ac.c.s("restoreAllState: back stack #", i11, " (index ");
                    sbS.append(aVarInstantiate.f2739r);
                    sbS.append("): ");
                    sbS.append(aVarInstantiate);
                    Log.v("FragmentManager", sbS.toString());
                    PrintWriter printWriter = new PrintWriter(new m0());
                    aVarInstantiate.dump("  ", printWriter, false);
                    printWriter.close();
                }
                this.f2941d.add(aVarInstantiate);
                i11++;
            }
        } else {
            this.f2941d = null;
        }
        this.f2946i.set(a0Var.f2743o);
        String str4 = a0Var.f2744p;
        if (str4 != null) {
            Fragment fragmentZ = z(str4);
            this.f2961x = fragmentZ;
            q(fragmentZ);
        }
        ArrayList<String> arrayList3 = a0Var.f2745q;
        if (arrayList3 != null) {
            while (i10 < arrayList3.size()) {
                this.f2947j.put(arrayList3.get(i10), a0Var.f2746r.get(i10));
                i10++;
            }
        }
        this.D = new ArrayDeque<>(a0Var.f2747s);
    }

    public final Bundle N() {
        int i10;
        androidx.fragment.app.b[] bVarArr;
        ArrayList<String> arrayList;
        int size;
        Bundle bundle = new Bundle();
        Iterator it = e().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SpecialEffectsController specialEffectsController = (SpecialEffectsController) it.next();
            if (specialEffectsController.f2714e) {
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
                }
                specialEffectsController.f2714e = false;
                specialEffectsController.c();
            }
        }
        Iterator it2 = e().iterator();
        while (it2.hasNext()) {
            ((SpecialEffectsController) it2.next()).e();
        }
        w(true);
        this.F = true;
        this.M.f2768h = true;
        f0 f0Var = this.f2940c;
        f0Var.getClass();
        HashMap map = (HashMap) f0Var.f2801b;
        ArrayList<String> arrayList2 = new ArrayList<>(map.size());
        for (e0 e0Var : map.values()) {
            if (e0Var != null) {
                e0Var.o();
                Fragment fragment = e0Var.f2794c;
                arrayList2.add(fragment.f2679q);
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragment.f2675m);
                }
            }
        }
        f0 f0Var2 = this.f2940c;
        f0Var2.getClass();
        ArrayList arrayList3 = new ArrayList(((HashMap) f0Var2.f2802c).values());
        if (!arrayList3.isEmpty()) {
            f0 f0Var3 = this.f2940c;
            synchronized (((ArrayList) f0Var3.f2800a)) {
                bVarArr = null;
                if (((ArrayList) f0Var3.f2800a).isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList<>(((ArrayList) f0Var3.f2800a).size());
                    Iterator it3 = ((ArrayList) f0Var3.f2800a).iterator();
                    while (it3.hasNext()) {
                        Fragment fragment2 = (Fragment) it3.next();
                        arrayList.add(fragment2.f2679q);
                        if (isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment2.f2679q + "): " + fragment2);
                        }
                    }
                }
            }
            ArrayList<androidx.fragment.app.a> arrayList4 = this.f2941d;
            if (arrayList4 != null && (size = arrayList4.size()) > 0) {
                bVarArr = new androidx.fragment.app.b[size];
                for (i10 = 0; i10 < size; i10++) {
                    bVarArr[i10] = new androidx.fragment.app.b(this.f2941d.get(i10));
                    if (isLoggingEnabled(2)) {
                        StringBuilder sbS = ac.c.s("saveAllState: adding back stack #", i10, ": ");
                        sbS.append(this.f2941d.get(i10));
                        Log.v("FragmentManager", sbS.toString());
                    }
                }
            }
            a0 a0Var = new a0();
            a0Var.f2740b = arrayList2;
            a0Var.f2741m = arrayList;
            a0Var.f2742n = bVarArr;
            a0Var.f2743o = this.f2946i.get();
            Fragment fragment3 = this.f2961x;
            if (fragment3 != null) {
                a0Var.f2744p = fragment3.f2679q;
            }
            a0Var.f2745q.addAll(this.f2947j.keySet());
            a0Var.f2746r.addAll(this.f2947j.values());
            a0Var.f2747s = new ArrayList<>(this.D);
            bundle.putParcelable(AdOperationMetric.INIT_STATE, a0Var);
            for (String str : this.f2948k.keySet()) {
                bundle.putBundle(ac.c.j("result_", str), this.f2948k.get(str));
            }
            Iterator it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                d0 d0Var = (d0) it4.next();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable(AdOperationMetric.INIT_STATE, d0Var);
                bundle.putBundle("fragment_" + d0Var.f2775m, bundle2);
            }
        } else if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return bundle;
    }

    public final void O() {
        synchronized (this.f2938a) {
            boolean z10 = true;
            if (this.f2938a.size() != 1) {
                z10 = false;
            }
            if (z10) {
                this.f2958u.getHandler().removeCallbacks(this.N);
                this.f2958u.getHandler().post(this.N);
                W();
            }
        }
    }

    public final void P(Fragment fragment, boolean z10) {
        ViewGroup viewGroupA = A(fragment);
        if (viewGroupA == null || !(viewGroupA instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupA).setDrawDisappearingViewsLast(!z10);
    }

    public final void Q(Fragment fragment, Lifecycle.State state) {
        if (fragment.equals(z(fragment.f2679q)) && (fragment.E == null || fragment.D == this)) {
            fragment.Z = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final void R(Fragment fragment) {
        if (fragment == null || (fragment.equals(z(fragment.f2679q)) && (fragment.E == null || fragment.D == this))) {
            Fragment fragment2 = this.f2961x;
            this.f2961x = fragment;
            q(fragment2);
            q(this.f2961x);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final void S(Fragment fragment) {
        ViewGroup viewGroupA = A(fragment);
        if (viewGroupA != null) {
            Fragment.c cVar = fragment.V;
            if ((cVar == null ? 0 : cVar.f2696e) + (cVar == null ? 0 : cVar.f2695d) + (cVar == null ? 0 : cVar.f2694c) + (cVar == null ? 0 : cVar.f2693b) > 0) {
                int i10 = R.id.visible_removing_fragment_view_tag;
                if (viewGroupA.getTag(i10) == null) {
                    viewGroupA.setTag(i10, fragment);
                }
                Fragment fragment2 = (Fragment) viewGroupA.getTag(i10);
                Fragment.c cVar2 = fragment.V;
                boolean z10 = cVar2 != null ? cVar2.f2692a : false;
                if (fragment2.V == null) {
                    return;
                }
                fragment2.b().f2692a = z10;
            }
        }
    }

    public final void U() {
        Iterator it = this.f2940c.e().iterator();
        while (it.hasNext()) {
            e0 e0Var = (e0) it.next();
            Fragment fragment = e0Var.f2794c;
            if (fragment.T) {
                if (this.f2939b) {
                    this.I = true;
                } else {
                    fragment.T = false;
                    e0Var.k();
                }
            }
        }
    }

    public final void V(IllegalStateException illegalStateException) {
        Log.e("FragmentManager", illegalStateException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new m0());
        u<?> uVar = this.f2958u;
        if (uVar != null) {
            try {
                uVar.onDump("  ", null, printWriter, new String[0]);
                throw illegalStateException;
            } catch (Exception e10) {
                Log.e("FragmentManager", "Failed dumping state", e10);
                throw illegalStateException;
            }
        }
        try {
            dump("  ", null, printWriter, new String[0]);
            throw illegalStateException;
        } catch (Exception e11) {
            Log.e("FragmentManager", "Failed dumping state", e11);
            throw illegalStateException;
        }
    }

    public final void W() {
        synchronized (this.f2938a) {
            if (this.f2938a.isEmpty()) {
                this.f2945h.setEnabled(getBackStackEntryCount() > 0 && F(this.f2960w));
            } else {
                this.f2945h.setEnabled(true);
            }
        }
    }

    public final e0 a(Fragment fragment) {
        String str = fragment.Y;
        if (str != null) {
            FragmentStrictMode.onFragmentReuse(fragment, str);
        }
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        e0 e0VarF = f(fragment);
        fragment.D = this;
        f0 f0Var = this.f2940c;
        f0Var.h(e0VarF);
        if (!fragment.L) {
            f0Var.a(fragment);
            fragment.f2686x = false;
            if (fragment.S == null) {
                fragment.W = false;
            }
            if (D(fragment)) {
                this.E = true;
            }
        }
        return e0VarF;
    }

    public void addFragmentOnAttachListener(c0 c0Var) {
        this.f2951n.add(c0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SyntheticAccessor"})
    public final void b(u<?> uVar, r rVar, Fragment fragment) {
        if (this.f2958u != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f2958u = uVar;
        this.f2959v = rVar;
        this.f2960w = fragment;
        if (fragment != null) {
            addFragmentOnAttachListener(new g(fragment));
        } else if (uVar instanceof c0) {
            addFragmentOnAttachListener((c0) uVar);
        }
        if (this.f2960w != null) {
            W();
        }
        if (uVar instanceof androidx.activity.m) {
            androidx.activity.m mVar = (androidx.activity.m) uVar;
            OnBackPressedDispatcher onBackPressedDispatcher = mVar.getOnBackPressedDispatcher();
            this.f2944g = onBackPressedDispatcher;
            androidx.lifecycle.l lVar = mVar;
            if (fragment != null) {
                lVar = fragment;
            }
            onBackPressedDispatcher.addCallback(lVar, this.f2945h);
        }
        if (fragment != null) {
            b0 b0Var = fragment.D.M;
            HashMap<String, b0> map = b0Var.f2764d;
            b0 b0Var2 = map.get(fragment.f2679q);
            if (b0Var2 == null) {
                b0Var2 = new b0(b0Var.f2766f);
                map.put(fragment.f2679q, b0Var2);
            }
            this.M = b0Var2;
        } else if (uVar instanceof androidx.lifecycle.e0) {
            this.M = (b0) new androidx.lifecycle.a0(((androidx.lifecycle.e0) uVar).getViewModelStore(), b0.f2762i).get(b0.class);
        } else {
            this.M = new b0(false);
        }
        this.M.f2768h = isStateSaved();
        this.f2940c.f2803d = this.M;
        Object obj = this.f2958u;
        if ((obj instanceof j2.c) && fragment == null) {
            androidx.savedstate.a savedStateRegistry = ((j2.c) obj).getSavedStateRegistry();
            savedStateRegistry.registerSavedStateProvider("android:support:fragments", new androidx.activity.f(this, 2));
            Bundle bundleConsumeRestoredStateForKey = savedStateRegistry.consumeRestoredStateForKey("android:support:fragments");
            if (bundleConsumeRestoredStateForKey != null) {
                M(bundleConsumeRestoredStateForKey);
            }
        }
        Object obj2 = this.f2958u;
        if (obj2 instanceof androidx.activity.result.e) {
            androidx.activity.result.d activityResultRegistry = ((androidx.activity.result.e) obj2).getActivityResultRegistry();
            String strJ = ac.c.j("FragmentManager:", fragment != null ? ac.c.o(new StringBuilder(), fragment.f2679q, ":") : "");
            z zVar = (z) this;
            this.A = activityResultRegistry.register(ac.c.B(strJ, "StartActivityForResult"), new q.c(), new h(zVar));
            this.B = activityResultRegistry.register(ac.c.B(strJ, "StartIntentSenderForResult"), new j(), new i(zVar));
            this.C = activityResultRegistry.register(ac.c.B(strJ, "RequestPermissions"), new q.b(), new a(zVar));
        }
        Object obj3 = this.f2958u;
        if (obj3 instanceof m0.b) {
            ((m0.b) obj3).addOnConfigurationChangedListener(this.f2952o);
        }
        Object obj4 = this.f2958u;
        if (obj4 instanceof m0.c) {
            ((m0.c) obj4).addOnTrimMemoryListener(this.f2953p);
        }
        Object obj5 = this.f2958u;
        if (obj5 instanceof l0.u) {
            ((l0.u) obj5).addOnMultiWindowModeChangedListener(this.f2954q);
        }
        Object obj6 = this.f2958u;
        if (obj6 instanceof l0.v) {
            ((l0.v) obj6).addOnPictureInPictureModeChangedListener(this.f2955r);
        }
        Object obj7 = this.f2958u;
        if ((obj7 instanceof x0.l) && fragment == null) {
            ((x0.l) obj7).addMenuProvider(this.f2956s);
        }
    }

    public g0 beginTransaction() {
        return new androidx.fragment.app.a(this);
    }

    public final void c(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.L) {
            fragment.L = false;
            if (fragment.f2685w) {
                return;
            }
            this.f2940c.a(fragment);
            if (isLoggingEnabled(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (D(fragment)) {
                this.E = true;
            }
        }
    }

    public final void d() {
        this.f2939b = false;
        this.K.clear();
        this.J.clear();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String strB = ac.c.B(str, "    ");
        f0 f0Var = this.f2940c;
        f0Var.getClass();
        String str2 = str + "    ";
        HashMap map = (HashMap) f0Var.f2801b;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (e0 e0Var : map.values()) {
                printWriter.print(str);
                if (e0Var != null) {
                    Fragment fragment = e0Var.f2794c;
                    printWriter.println(fragment);
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        ArrayList arrayList = (ArrayList) f0Var.f2800a;
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i10 = 0; i10 < size3; i10++) {
                Fragment fragment2 = (Fragment) arrayList.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList<Fragment> arrayList2 = this.f2942e;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i11 = 0; i11 < size2; i11++) {
                Fragment fragment3 = this.f2942e.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList<androidx.fragment.app.a> arrayList3 = this.f2941d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i12 = 0; i12 < size; i12++) {
                androidx.fragment.app.a aVar = this.f2941d.get(i12);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i12);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.dump(strB, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f2946i.get());
        synchronized (this.f2938a) {
            int size4 = this.f2938a.size();
            if (size4 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i13 = 0; i13 < size4; i13++) {
                    Object obj = (l) this.f2938a.get(i13);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i13);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f2958u);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f2959v);
        if (this.f2960w != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f2960w);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f2957t);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.F);
        printWriter.print(" mStopped=");
        printWriter.print(this.G);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.H);
        if (this.E) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.E);
        }
    }

    public final HashSet e() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f2940c.e().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((e0) it.next()).f2794c.R;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.g(viewGroup, B()));
            }
        }
        return hashSet;
    }

    public final e0 f(Fragment fragment) {
        String str = fragment.f2679q;
        f0 f0Var = this.f2940c;
        e0 e0Var = (e0) ((HashMap) f0Var.f2801b).get(str);
        if (e0Var != null) {
            return e0Var;
        }
        e0 e0Var2 = new e0(this.f2950m, f0Var, fragment);
        e0Var2.m(this.f2958u.f2928m.getClassLoader());
        e0Var2.f2796e = this.f2957t;
        return e0Var2;
    }

    public Fragment findFragmentById(int i10) {
        f0 f0Var = this.f2940c;
        ArrayList arrayList = (ArrayList) f0Var.f2800a;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                for (e0 e0Var : ((HashMap) f0Var.f2801b).values()) {
                    if (e0Var != null) {
                        Fragment fragment = e0Var.f2794c;
                        if (fragment.H == i10) {
                            return fragment;
                        }
                    }
                }
                return null;
            }
            Fragment fragment2 = (Fragment) arrayList.get(size);
            if (fragment2 != null && fragment2.H == i10) {
                return fragment2;
            }
        }
    }

    public Fragment findFragmentByTag(String str) {
        f0 f0Var = this.f2940c;
        if (str != null) {
            ArrayList arrayList = (ArrayList) f0Var.f2800a;
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                Fragment fragment = (Fragment) arrayList.get(size);
                if (fragment != null && str.equals(fragment.J)) {
                    return fragment;
                }
            }
        }
        if (str != null) {
            for (e0 e0Var : ((HashMap) f0Var.f2801b).values()) {
                if (e0Var != null) {
                    Fragment fragment2 = e0Var.f2794c;
                    if (str.equals(fragment2.J)) {
                        return fragment2;
                    }
                }
            }
        } else {
            f0Var.getClass();
        }
        return null;
    }

    public final void g(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.L) {
            return;
        }
        fragment.L = true;
        if (fragment.f2685w) {
            if (isLoggingEnabled(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            f0 f0Var = this.f2940c;
            synchronized (((ArrayList) f0Var.f2800a)) {
                ((ArrayList) f0Var.f2800a).remove(fragment);
            }
            fragment.f2685w = false;
            if (D(fragment)) {
                this.E = true;
            }
            S(fragment);
        }
    }

    public int getBackStackEntryCount() {
        ArrayList<androidx.fragment.app.a> arrayList = this.f2941d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public t getFragmentFactory() {
        Fragment fragment = this.f2960w;
        return fragment != null ? fragment.D.getFragmentFactory() : this.f2962y;
    }

    public List<Fragment> getFragments() {
        return this.f2940c.g();
    }

    public u<?> getHost() {
        return this.f2958u;
    }

    public Fragment getPrimaryNavigationFragment() {
        return this.f2961x;
    }

    public FragmentStrictMode.b getStrictModePolicy() {
        return null;
    }

    public final void h(boolean z10, Configuration configuration) {
        if (z10 && (this.f2958u instanceof m0.b)) {
            V(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f2940c.g()) {
            if (fragment != null) {
                fragment.onConfigurationChanged(configuration);
                if (z10) {
                    fragment.F.h(true, configuration);
                }
            }
        }
    }

    public final boolean i(MenuItem menuItem) {
        if (this.f2957t < 1) {
            return false;
        }
        for (Fragment fragment : this.f2940c.g()) {
            if (fragment != null && fragment.h(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDestroyed() {
        return this.H;
    }

    public boolean isStateSaved() {
        return this.F || this.G;
    }

    public final boolean j(Menu menu, MenuInflater menuInflater) {
        if (this.f2957t < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z10 = false;
        for (Fragment fragment : this.f2940c.g()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.i(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z10 = true;
            }
        }
        if (this.f2942e != null) {
            for (int i10 = 0; i10 < this.f2942e.size(); i10++) {
                Fragment fragment2 = this.f2942e.get(i10);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f2942e = arrayList;
        return z10;
    }

    public final void k() {
        boolean zIsChangingConfigurations = true;
        this.H = true;
        w(true);
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((SpecialEffectsController) it.next()).e();
        }
        u<?> uVar = this.f2958u;
        boolean z10 = uVar instanceof androidx.lifecycle.e0;
        f0 f0Var = this.f2940c;
        if (z10) {
            zIsChangingConfigurations = ((b0) f0Var.f2803d).f2767g;
        } else {
            Context context = uVar.f2928m;
            if (context instanceof Activity) {
                zIsChangingConfigurations = true ^ ((Activity) context).isChangingConfigurations();
            }
        }
        if (zIsChangingConfigurations) {
            Iterator<androidx.fragment.app.c> it2 = this.f2947j.values().iterator();
            while (it2.hasNext()) {
                for (String str : it2.next().f2769b) {
                    b0 b0Var = (b0) f0Var.f2803d;
                    b0Var.getClass();
                    if (isLoggingEnabled(3)) {
                        Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
                    }
                    b0Var.c(str);
                }
            }
        }
        t(-1);
        Object obj = this.f2958u;
        if (obj instanceof m0.c) {
            ((m0.c) obj).removeOnTrimMemoryListener(this.f2953p);
        }
        Object obj2 = this.f2958u;
        if (obj2 instanceof m0.b) {
            ((m0.b) obj2).removeOnConfigurationChangedListener(this.f2952o);
        }
        Object obj3 = this.f2958u;
        if (obj3 instanceof l0.u) {
            ((l0.u) obj3).removeOnMultiWindowModeChangedListener(this.f2954q);
        }
        Object obj4 = this.f2958u;
        if (obj4 instanceof l0.v) {
            ((l0.v) obj4).removeOnPictureInPictureModeChangedListener(this.f2955r);
        }
        Object obj5 = this.f2958u;
        if (obj5 instanceof x0.l) {
            ((x0.l) obj5).removeMenuProvider(this.f2956s);
        }
        this.f2958u = null;
        this.f2959v = null;
        this.f2960w = null;
        if (this.f2944g != null) {
            this.f2945h.remove();
            this.f2944g = null;
        }
        androidx.activity.result.c<Intent> cVar = this.A;
        if (cVar != null) {
            cVar.unregister();
            this.B.unregister();
            this.C.unregister();
        }
    }

    public final void l(boolean z10) {
        if (z10 && (this.f2958u instanceof m0.c)) {
            V(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f2940c.g()) {
            if (fragment != null) {
                fragment.onLowMemory();
                if (z10) {
                    fragment.F.l(true);
                }
            }
        }
    }

    public final void m(boolean z10, boolean z11) {
        if (z11 && (this.f2958u instanceof l0.u)) {
            V(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f2940c.g()) {
            if (fragment != null) {
                fragment.onMultiWindowModeChanged(z10);
                if (z11) {
                    fragment.F.m(z10, true);
                }
            }
        }
    }

    public final void n() {
        Iterator it = this.f2940c.f().iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.F.n();
            }
        }
    }

    public final boolean o(MenuItem menuItem) {
        if (this.f2957t < 1) {
            return false;
        }
        for (Fragment fragment : this.f2940c.g()) {
            if (fragment != null && fragment.k(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void p(Menu menu) {
        if (this.f2957t < 1) {
            return;
        }
        for (Fragment fragment : this.f2940c.g()) {
            if (fragment != null) {
                fragment.l(menu);
            }
        }
    }

    public boolean popBackStackImmediate() {
        return I(-1, 0);
    }

    public final void q(Fragment fragment) {
        if (fragment == null || !fragment.equals(z(fragment.f2679q))) {
            return;
        }
        fragment.D.getClass();
        boolean zF = F(fragment);
        Boolean bool = fragment.f2684v;
        if (bool == null || bool.booleanValue() != zF) {
            fragment.f2684v = Boolean.valueOf(zF);
            fragment.onPrimaryNavigationFragmentChanged(zF);
            z zVar = fragment.F;
            zVar.W();
            zVar.q(zVar.f2961x);
        }
    }

    public final void r(boolean z10, boolean z11) {
        if (z11 && (this.f2958u instanceof l0.v)) {
            V(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f2940c.g()) {
            if (fragment != null) {
                fragment.onPictureInPictureModeChanged(z10);
                if (z11) {
                    fragment.F.r(z10, true);
                }
            }
        }
    }

    public final boolean s(Menu menu) {
        boolean z10 = false;
        if (this.f2957t < 1) {
            return false;
        }
        for (Fragment fragment : this.f2940c.g()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.m(menu)) {
                z10 = true;
            }
        }
        return z10;
    }

    public final void t(int i10) {
        try {
            this.f2939b = true;
            for (e0 e0Var : ((HashMap) this.f2940c.f2801b).values()) {
                if (e0Var != null) {
                    e0Var.f2796e = i10;
                }
            }
            G(i10, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((SpecialEffectsController) it.next()).e();
            }
            this.f2939b = false;
            w(true);
        } catch (Throwable th2) {
            this.f2939b = false;
            throw th2;
        }
    }

    public String toString() {
        StringBuilder sbQ = ac.c.q(128, "FragmentManager{");
        sbQ.append(Integer.toHexString(System.identityHashCode(this)));
        sbQ.append(" in ");
        Fragment fragment = this.f2960w;
        if (fragment != null) {
            sbQ.append(fragment.getClass().getSimpleName());
            sbQ.append("{");
            sbQ.append(Integer.toHexString(System.identityHashCode(this.f2960w)));
            sbQ.append("}");
        } else {
            u<?> uVar = this.f2958u;
            if (uVar != null) {
                sbQ.append(uVar.getClass().getSimpleName());
                sbQ.append("{");
                sbQ.append(Integer.toHexString(System.identityHashCode(this.f2958u)));
                sbQ.append("}");
            } else {
                sbQ.append("null");
            }
        }
        sbQ.append("}}");
        return sbQ.toString();
    }

    public final void u(l lVar, boolean z10) {
        if (!z10) {
            if (this.f2958u == null) {
                if (!this.H) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (isStateSaved()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f2938a) {
            if (this.f2958u == null) {
                if (!z10) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.f2938a.add(lVar);
                O();
            }
        }
    }

    public final void v(boolean z10) {
        if (this.f2939b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f2958u == null) {
            if (!this.H) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f2958u.getHandler().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z10 && isStateSaved()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.J == null) {
            this.J = new ArrayList<>();
            this.K = new ArrayList<>();
        }
    }

    public final boolean w(boolean z10) {
        boolean zGenerateOps;
        v(z10);
        boolean z11 = false;
        while (true) {
            ArrayList<androidx.fragment.app.a> arrayList = this.J;
            ArrayList<Boolean> arrayList2 = this.K;
            synchronized (this.f2938a) {
                if (this.f2938a.isEmpty()) {
                    zGenerateOps = false;
                } else {
                    try {
                        int size = this.f2938a.size();
                        zGenerateOps = false;
                        for (int i10 = 0; i10 < size; i10++) {
                            zGenerateOps |= this.f2938a.get(i10).generateOps(arrayList, arrayList2);
                        }
                    } finally {
                    }
                }
            }
            if (!zGenerateOps) {
                break;
            }
            z11 = true;
            this.f2939b = true;
            try {
                L(this.J, this.K);
            } finally {
                d();
            }
        }
        W();
        if (this.I) {
            this.I = false;
            U();
        }
        this.f2940c.b();
        return z11;
    }

    public final void x(l lVar, boolean z10) {
        if (z10 && (this.f2958u == null || this.H)) {
            return;
        }
        v(z10);
        if (lVar.generateOps(this.J, this.K)) {
            this.f2939b = true;
            try {
                L(this.J, this.K);
            } finally {
                d();
            }
        }
        W();
        if (this.I) {
            this.I = false;
            U();
        }
        this.f2940c.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void y(java.util.ArrayList<androidx.fragment.app.a> r23, java.util.ArrayList<java.lang.Boolean> r24, int r25, int r26) {
        /*
            Method dump skipped, instructions count: 1234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.y.y(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    public final Fragment z(String str) {
        return this.f2940c.c(str);
    }

    /* compiled from: FragmentManager.java */
    @SuppressLint({"BanParcelableUsage"})
    public static class k implements Parcelable {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public final String f2972b;

        /* renamed from: m, reason: collision with root package name */
        public final int f2973m;

        /* compiled from: FragmentManager.java */
        public class a implements Parcelable.Creator<k> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public k createFromParcel(Parcel parcel) {
                return new k(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public k[] newArray(int i10) {
                return new k[i10];
            }
        }

        public k(String str, int i10) {
            this.f2972b = str;
            this.f2973m = i10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f2972b);
            parcel.writeInt(this.f2973m);
        }

        public k(Parcel parcel) {
            this.f2972b = parcel.readString();
            this.f2973m = parcel.readInt();
        }
    }
}
