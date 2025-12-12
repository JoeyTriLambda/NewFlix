package a2;

import a2.c0;
import a2.f;
import a2.i;
import a2.m;
import a2.n;
import a2.y;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.media.MediaRouter2;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: GlobalMediaRouter.java */
/* loaded from: classes.dex */
public final class a implements c0.e, y.d {
    public static final /* synthetic */ int F = 0;
    public n.d A;
    public n.e B;
    public d C;
    public MediaSessionCompat D;
    public final b E;

    /* renamed from: a, reason: collision with root package name */
    public final Context f45a;

    /* renamed from: b, reason: collision with root package name */
    public final c0 f46b;

    /* renamed from: c, reason: collision with root package name */
    public y f47c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f48d;

    /* renamed from: e, reason: collision with root package name */
    public a2.f f49e;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f58n;

    /* renamed from: o, reason: collision with root package name */
    public r f59o;

    /* renamed from: p, reason: collision with root package name */
    public u f60p;

    /* renamed from: q, reason: collision with root package name */
    public n.g f61q;

    /* renamed from: r, reason: collision with root package name */
    public n.g f62r;

    /* renamed from: s, reason: collision with root package name */
    public n.g f63s;

    /* renamed from: t, reason: collision with root package name */
    public i.e f64t;

    /* renamed from: u, reason: collision with root package name */
    public n.g f65u;

    /* renamed from: v, reason: collision with root package name */
    public i.b f66v;

    /* renamed from: x, reason: collision with root package name */
    public h f68x;

    /* renamed from: y, reason: collision with root package name */
    public h f69y;

    /* renamed from: z, reason: collision with root package name */
    public int f70z;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList<WeakReference<n>> f50f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList<n.g> f51g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f52h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList<n.f> f53i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList<g> f54j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    public final a0 f55k = new a0();

    /* renamed from: l, reason: collision with root package name */
    public final f f56l = new f();

    /* renamed from: m, reason: collision with root package name */
    public final c f57m = new c();

    /* renamed from: w, reason: collision with root package name */
    public final HashMap f67w = new HashMap();

    /* compiled from: GlobalMediaRouter.java */
    /* renamed from: a2.a$a, reason: collision with other inner class name */
    public class C0000a implements MediaSessionCompat.OnActiveChangeListener {
        public C0000a() {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.OnActiveChangeListener
        public void onActiveChanged() {
            a.this.getClass();
        }
    }

    /* compiled from: GlobalMediaRouter.java */
    public class b implements i.b.c {
        public b() {
        }

        public void onRoutesChanged(i.b bVar, a2.g gVar, Collection<i.b.C0003b> collection) {
            a aVar = a.this;
            if (bVar != aVar.f66v || gVar == null) {
                if (bVar == aVar.f64t) {
                    if (gVar != null) {
                        aVar.o(aVar.f63s, gVar);
                    }
                    aVar.f63s.c(collection);
                    return;
                }
                return;
            }
            n.f provider = aVar.f65u.getProvider();
            String id2 = gVar.getId();
            n.g gVar2 = new n.g(provider, id2, aVar.b(provider, id2));
            gVar2.b(gVar);
            if (aVar.f63s == gVar2) {
                return;
            }
            aVar.i(aVar, gVar2, aVar.f66v, 3, aVar.f65u, collection);
            aVar.f65u = null;
            aVar.f66v = null;
        }
    }

    /* compiled from: GlobalMediaRouter.java */
    public final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList<n.b> f73a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f74b = new ArrayList();

        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void a(n.b bVar, int i10, Object obj, int i11) {
            n nVar = bVar.f189a;
            int i12 = 65280 & i10;
            n.a aVar = bVar.f190b;
            if (i12 != 256) {
                if (i12 != 512) {
                    if (i12 == 768 && i10 == 769) {
                        aVar.onRouterParamsChanged(nVar, (u) obj);
                        return;
                    }
                    return;
                }
                n.f fVar = (n.f) obj;
                switch (i10) {
                    case 513:
                        aVar.onProviderAdded(nVar, fVar);
                        break;
                    case 514:
                        aVar.onProviderRemoved(nVar, fVar);
                        break;
                    case 515:
                        aVar.onProviderChanged(nVar, fVar);
                        break;
                }
            }
            n.g gVar = (i10 == 264 || i10 == 262) ? (n.g) ((w0.d) obj).f20844b : (n.g) obj;
            n.g gVar2 = (i10 == 264 || i10 == 262) ? (n.g) ((w0.d) obj).f20843a : null;
            if (gVar == null || !bVar.filterRouteEvent(gVar, i10, gVar2, i11)) {
                return;
            }
            switch (i10) {
                case 257:
                    aVar.onRouteAdded(nVar, gVar);
                    break;
                case 258:
                    aVar.onRouteRemoved(nVar, gVar);
                    break;
                case 259:
                    aVar.onRouteChanged(nVar, gVar);
                    break;
                case 260:
                    aVar.onRouteVolumeChanged(nVar, gVar);
                    break;
                case 261:
                    aVar.onRoutePresentationDisplayChanged(nVar, gVar);
                    break;
                case 262:
                    aVar.onRouteSelected(nVar, gVar, i11, gVar);
                    break;
                case 263:
                    aVar.onRouteUnselected(nVar, gVar, i11);
                    break;
                case 264:
                    aVar.onRouteSelected(nVar, gVar, i11, gVar2);
                    break;
            }
        }

        public final void b(int i10, Object obj) {
            obtainMessage(i10, obj).sendToTarget();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ArrayList<n.b> arrayList = this.f73a;
            int i10 = message.what;
            Object obj = message.obj;
            int i11 = message.arg1;
            a aVar = a.this;
            if (i10 == 259 && aVar.f().getId().equals(((n.g) obj).getId())) {
                aVar.p(true);
            }
            ArrayList arrayList2 = this.f74b;
            if (i10 == 262) {
                n.g gVar = (n.g) ((w0.d) obj).f20844b;
                aVar.f46b.onSyncRouteSelected(gVar);
                if (aVar.f61q != null && gVar.isDefaultOrBluetooth()) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        aVar.f46b.onSyncRouteRemoved((n.g) it.next());
                    }
                    arrayList2.clear();
                }
            } else if (i10 != 264) {
                switch (i10) {
                    case 257:
                        aVar.f46b.onSyncRouteAdded((n.g) obj);
                        break;
                    case 258:
                        aVar.f46b.onSyncRouteRemoved((n.g) obj);
                        break;
                    case 259:
                        aVar.f46b.onSyncRouteChanged((n.g) obj);
                        break;
                }
            } else {
                n.g gVar2 = (n.g) ((w0.d) obj).f20844b;
                arrayList2.add(gVar2);
                aVar.f46b.onSyncRouteAdded(gVar2);
                aVar.f46b.onSyncRouteSelected(gVar2);
            }
            try {
                int size = aVar.f50f.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        Iterator<n.b> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            a(it2.next(), i10, obj, i11);
                        }
                        return;
                    } else {
                        ArrayList<WeakReference<n>> arrayList3 = aVar.f50f;
                        n nVar = arrayList3.get(size).get();
                        if (nVar == null) {
                            arrayList3.remove(size);
                        } else {
                            arrayList.addAll(nVar.f188b);
                        }
                    }
                }
            } finally {
                arrayList.clear();
            }
        }
    }

    /* compiled from: GlobalMediaRouter.java */
    public final class d {

        /* renamed from: a, reason: collision with root package name */
        public final MediaSessionCompat f76a;

        /* renamed from: b, reason: collision with root package name */
        public a2.c f77b;

        public d(MediaSessionCompat mediaSessionCompat) {
            this.f76a = mediaSessionCompat;
        }

        public final void a() {
            MediaSessionCompat mediaSessionCompat = this.f76a;
            if (mediaSessionCompat != null) {
                mediaSessionCompat.setPlaybackToLocal(a.this.f55k.f84d);
                this.f77b = null;
            }
        }
    }

    /* compiled from: GlobalMediaRouter.java */
    public final class e extends f.a {
        public e() {
        }

        @Override // a2.f.a
        public void onReleaseController(i.e eVar) {
            a aVar = a.this;
            if (eVar != aVar.f64t) {
                int i10 = a.F;
                return;
            }
            n.g gVarC = aVar.c();
            if (aVar.f() != gVarC) {
                aVar.k(gVarC, 2);
            }
        }

        @Override // a2.f.a
        public void onSelectFallbackRoute(int i10) {
            a aVar = a.this;
            n.g gVarC = aVar.c();
            if (aVar.f() != gVarC) {
                aVar.k(gVarC, i10);
            }
        }

        @Override // a2.f.a
        public void onSelectRoute(String str, int i10) {
            n.g next;
            a aVar = a.this;
            Iterator<n.g> it = aVar.f51g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getProviderInstance() == aVar.f49e && TextUtils.equals(str, next.f210b)) {
                    break;
                }
            }
            if (next != null) {
                aVar.k(next, i10);
                return;
            }
            Log.w("GlobalMediaRouter", "onSelectRoute: The target RouteInfo is not found for descriptorId=" + str);
        }
    }

    /* compiled from: GlobalMediaRouter.java */
    public final class f extends i.a {
        public f() {
        }

        @Override // a2.i.a
        public void onDescriptorChanged(i iVar, k kVar) {
            a aVar = a.this;
            n.f fVarD = aVar.d(iVar);
            if (fVarD != null) {
                aVar.n(fVarD, kVar);
            }
        }
    }

    /* compiled from: GlobalMediaRouter.java */
    public final class g {
        public g() {
            throw null;
        }
    }

    static {
        Log.isLoggable("GlobalMediaRouter", 3);
    }

    public a(Context context) {
        new C0000a();
        this.E = new b();
        this.f45a = context;
        this.f58n = l0.b.isLowRamDevice((ActivityManager) context.getSystemService("activity"));
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = i10 >= 30 && v.isDeclared(context);
        this.f48d = z10;
        this.f49e = (i10 < 30 || !z10) ? null : new a2.f(context, new e());
        c0 c0VarObtain = c0.obtain(context, this);
        this.f46b = c0VarObtain;
        this.f59o = new r(new androidx.activity.d(this, 6));
        a(c0VarObtain, true);
        i iVar = this.f49e;
        if (iVar != null) {
            a(iVar, true);
        }
        y yVar = new y(context, this);
        this.f47c = yVar;
        yVar.start();
    }

    public final void a(i iVar, boolean z10) {
        if (d(iVar) == null) {
            n.f fVar = new n.f(iVar, z10);
            this.f53i.add(fVar);
            this.f57m.b(513, fVar);
            n(fVar, iVar.getDescriptor());
            iVar.setCallback(this.f56l);
            iVar.setDiscoveryRequest(this.f68x);
        }
    }

    public void addProvider(i iVar) {
        a(iVar, false);
    }

    public final String b(n.f fVar, String str) {
        String strFlattenToShortString = fVar.getComponentName().flattenToShortString();
        boolean z10 = fVar.f206c;
        String strC = z10 ? str : ac.c.C(strFlattenToShortString, ":", str);
        HashMap map = this.f52h;
        if (z10 || e(strC) < 0) {
            map.put(new w0.d(strFlattenToShortString, str), strC);
            return strC;
        }
        Log.w("GlobalMediaRouter", "Either " + str + " isn't unique in " + strFlattenToShortString + " or we're trying to assign a unique ID for an already added route");
        int i10 = 2;
        while (true) {
            String str2 = String.format(Locale.US, "%s_%d", strC, Integer.valueOf(i10));
            if (e(str2) < 0) {
                map.put(new w0.d(strFlattenToShortString, str), str2);
                return str2;
            }
            i10++;
        }
    }

    public final n.g c() {
        Iterator<n.g> it = this.f51g.iterator();
        while (it.hasNext()) {
            n.g next = it.next();
            if (next != this.f61q) {
                if ((next.getProviderInstance() == this.f46b && next.supportsControlCategory("android.media.intent.category.LIVE_AUDIO") && !next.supportsControlCategory("android.media.intent.category.LIVE_VIDEO")) && next.a()) {
                    return next;
                }
            }
        }
        return this.f61q;
    }

    public final n.f d(i iVar) {
        Iterator<n.f> it = this.f53i.iterator();
        while (it.hasNext()) {
            n.f next = it.next();
            if (next.f204a == iVar) {
                return next;
            }
        }
        return null;
    }

    public final int e(String str) {
        ArrayList<n.g> arrayList = this.f51g;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (arrayList.get(i10).f211c.equals(str)) {
                return i10;
            }
        }
        return -1;
    }

    public final n.g f() {
        n.g gVar = this.f63s;
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalStateException("There is no currently selected route.  The media router has not yet been fully initialized.");
    }

    public final boolean g() {
        u uVar;
        return this.f48d && ((uVar = this.f60p) == null || uVar.isMediaTransferReceiverEnabled());
    }

    public final void h() {
        if (this.f63s.isGroup()) {
            List<n.g> memberRoutes = this.f63s.getMemberRoutes();
            HashSet hashSet = new HashSet();
            Iterator<n.g> it = memberRoutes.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().f211c);
            }
            HashMap map = this.f67w;
            Iterator it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                if (!hashSet.contains(entry.getKey())) {
                    i.e eVar = (i.e) entry.getValue();
                    eVar.onUnselect(0);
                    eVar.onRelease();
                    it2.remove();
                }
            }
            for (n.g gVar : memberRoutes) {
                if (!map.containsKey(gVar.f211c)) {
                    i.e eVarOnCreateRouteController = gVar.getProviderInstance().onCreateRouteController(gVar.f210b, this.f63s.f210b);
                    eVarOnCreateRouteController.onSelect();
                    map.put(gVar.f211c, eVarOnCreateRouteController);
                }
            }
        }
    }

    public final void i(a aVar, n.g gVar, i.e eVar, int i10, n.g gVar2, Collection<i.b.C0003b> collection) {
        n.d dVar;
        n.e eVar2 = this.B;
        if (eVar2 != null) {
            eVar2.a();
            this.B = null;
        }
        n.e eVar3 = new n.e(aVar, gVar, eVar, i10, gVar2, collection);
        this.B = eVar3;
        if (eVar3.f195b != 3 || (dVar = this.A) == null) {
            eVar3.b();
            return;
        }
        e8.c<Void> cVarOnPrepareTransfer = dVar.onPrepareTransfer(this.f63s, eVar3.f197d);
        if (cVarOnPrepareTransfer == null) {
            this.B.b();
            return;
        }
        n.e eVar4 = this.B;
        a aVar2 = eVar4.f200g.get();
        if (aVar2 == null || aVar2.B != eVar4) {
            Log.w("AxMediaRouter", "Router is released. Cancel transfer");
            eVar4.a();
        } else {
            if (eVar4.f201h != null) {
                throw new IllegalStateException("future is already set");
            }
            eVar4.f201h = cVarOnPrepareTransfer;
            o oVar = new o(eVar4, 1);
            c cVar = aVar2.f57m;
            Objects.requireNonNull(cVar);
            cVarOnPrepareTransfer.addListener(oVar, new a2.e(1, cVar));
        }
    }

    public final void j(n.g gVar, int i10) {
        if (!this.f51g.contains(gVar)) {
            Log.w("GlobalMediaRouter", "Ignoring attempt to select removed route: " + gVar);
        } else {
            if (!gVar.f215g) {
                Log.w("GlobalMediaRouter", "Ignoring attempt to select disabled route: " + gVar);
                return;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                i providerInstance = gVar.getProviderInstance();
                a2.f fVar = this.f49e;
                if (providerInstance == fVar && this.f63s != gVar) {
                    fVar.transferTo(gVar.f210b);
                    return;
                }
            }
            k(gVar, i10);
        }
    }

    public final void k(n.g gVar, int i10) {
        if (this.f63s == gVar) {
            return;
        }
        if (this.f65u != null) {
            this.f65u = null;
            i.b bVar = this.f66v;
            if (bVar != null) {
                bVar.onUnselect(3);
                this.f66v.onRelease();
                this.f66v = null;
            }
        }
        if (g()) {
            k kVar = gVar.getProvider().f208e;
            if (kVar != null && kVar.supportsDynamicGroupRoute()) {
                i.b bVarOnCreateDynamicGroupRouteController = gVar.getProviderInstance().onCreateDynamicGroupRouteController(gVar.f210b);
                if (bVarOnCreateDynamicGroupRouteController != null) {
                    Executor mainExecutor = m0.a.getMainExecutor(this.f45a);
                    b bVar2 = this.E;
                    synchronized (bVarOnCreateDynamicGroupRouteController.f153a) {
                        if (mainExecutor == null) {
                            throw new NullPointerException("Executor shouldn't be null");
                        }
                        if (bVar2 == null) {
                            throw new NullPointerException("Listener shouldn't be null");
                        }
                        bVarOnCreateDynamicGroupRouteController.f154b = mainExecutor;
                        bVarOnCreateDynamicGroupRouteController.f155c = bVar2;
                        ArrayList arrayList = bVarOnCreateDynamicGroupRouteController.f157e;
                        if (arrayList != null && !arrayList.isEmpty()) {
                            a2.g gVar2 = bVarOnCreateDynamicGroupRouteController.f156d;
                            ArrayList arrayList2 = bVarOnCreateDynamicGroupRouteController.f157e;
                            bVarOnCreateDynamicGroupRouteController.f156d = null;
                            bVarOnCreateDynamicGroupRouteController.f157e = null;
                            bVarOnCreateDynamicGroupRouteController.f154b.execute(new j(bVarOnCreateDynamicGroupRouteController, bVar2, gVar2, arrayList2));
                        }
                    }
                    this.f65u = gVar;
                    this.f66v = bVarOnCreateDynamicGroupRouteController;
                    bVarOnCreateDynamicGroupRouteController.onSelect();
                    return;
                }
                Log.w("GlobalMediaRouter", "setSelectedRouteInternal: Failed to create dynamic group route controller. route=" + gVar);
            }
        }
        i.e eVarOnCreateRouteController = gVar.getProviderInstance().onCreateRouteController(gVar.f210b);
        if (eVarOnCreateRouteController != null) {
            eVarOnCreateRouteController.onSelect();
        }
        if (this.f63s != null) {
            i(this, gVar, eVarOnCreateRouteController, i10, null, null);
            return;
        }
        this.f63s = gVar;
        this.f64t = eVarOnCreateRouteController;
        Message messageObtainMessage = this.f57m.obtainMessage(262, new w0.d(null, gVar));
        messageObtainMessage.arg1 = i10;
        messageObtainMessage.sendToTarget();
    }

    public final void l() {
        boolean z10;
        h hVar;
        m.a aVar = new m.a();
        this.f59o.reset();
        ArrayList<WeakReference<n>> arrayList = this.f50f;
        int size = arrayList.size();
        int i10 = 0;
        boolean z11 = false;
        while (true) {
            size--;
            z10 = this.f58n;
            if (size < 0) {
                break;
            }
            n nVar = arrayList.get(size).get();
            if (nVar == null) {
                arrayList.remove(size);
            } else {
                ArrayList<n.b> arrayList2 = nVar.f188b;
                int size2 = arrayList2.size();
                i10 += size2;
                int i11 = 0;
                while (i11 < size2) {
                    n.b bVar = arrayList2.get(i11);
                    aVar.addSelector(bVar.f191c);
                    boolean z12 = (bVar.f192d & 1) != 0;
                    int i12 = i10;
                    this.f59o.requestActiveScan(z12, bVar.f193e);
                    if (z12) {
                        z11 = true;
                    }
                    int i13 = bVar.f192d;
                    if ((i13 & 4) != 0 && !z10) {
                        z11 = true;
                    }
                    if ((i13 & 8) != 0) {
                        z11 = true;
                    }
                    i11++;
                    i10 = i12;
                }
            }
        }
        boolean zFinalizeActiveScanAndScheduleSuppressActiveScanRunnable = this.f59o.finalizeActiveScanAndScheduleSuppressActiveScanRunnable();
        this.f70z = i10;
        m mVarBuild = z11 ? aVar.build() : m.f182c;
        m mVarBuild2 = aVar.build();
        if (g() && ((hVar = this.f69y) == null || !hVar.getSelector().equals(mVarBuild2) || this.f69y.isActiveScan() != zFinalizeActiveScanAndScheduleSuppressActiveScanRunnable)) {
            if (!mVarBuild2.isEmpty() || zFinalizeActiveScanAndScheduleSuppressActiveScanRunnable) {
                this.f69y = new h(mVarBuild2, zFinalizeActiveScanAndScheduleSuppressActiveScanRunnable);
            } else if (this.f69y != null) {
                this.f69y = null;
            }
            this.f49e.setDiscoveryRequest(this.f69y);
        }
        h hVar2 = this.f68x;
        if (hVar2 != null && hVar2.getSelector().equals(mVarBuild) && this.f68x.isActiveScan() == zFinalizeActiveScanAndScheduleSuppressActiveScanRunnable) {
            return;
        }
        if (!mVarBuild.isEmpty() || zFinalizeActiveScanAndScheduleSuppressActiveScanRunnable) {
            this.f68x = new h(mVarBuild, zFinalizeActiveScanAndScheduleSuppressActiveScanRunnable);
        } else if (this.f68x == null) {
            return;
        } else {
            this.f68x = null;
        }
        if (z11 && !zFinalizeActiveScanAndScheduleSuppressActiveScanRunnable && z10) {
            Log.i("GlobalMediaRouter", "Forcing passive route discovery on a low-RAM device, system performance may be affected.  Please consider using CALLBACK_FLAG_REQUEST_DISCOVERY instead of CALLBACK_FLAG_FORCE_DISCOVERY.");
        }
        Iterator<n.f> it = this.f53i.iterator();
        while (it.hasNext()) {
            i iVar = it.next().f204a;
            if (iVar != this.f49e) {
                iVar.setDiscoveryRequest(this.f68x);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final void m() {
        MediaRouter2.RoutingController routingController;
        n.g gVar = this.f63s;
        if (gVar == null) {
            d dVar = this.C;
            if (dVar != null) {
                dVar.a();
                return;
            }
            return;
        }
        int volume = gVar.getVolume();
        a0 a0Var = this.f55k;
        a0Var.f81a = volume;
        a0Var.f82b = this.f63s.getVolumeMax();
        a0Var.f83c = this.f63s.getVolumeHandling();
        a0Var.f84d = this.f63s.getPlaybackStream();
        this.f63s.getPlaybackType();
        a0Var.getClass();
        if (g() && this.f63s.getProviderInstance() == this.f49e) {
            i.e eVar = this.f64t;
            int i10 = a2.f.f110r;
            a0Var.f85e = ((eVar instanceof f.c) && (routingController = ((f.c) eVar).f122g) != null) ? routingController.getId() : null;
        } else {
            a0Var.f85e = null;
        }
        Iterator<g> it = this.f54j.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw null;
        }
        d dVar2 = this.C;
        if (dVar2 != null) {
            n.g gVar2 = this.f63s;
            n.g gVar3 = this.f61q;
            if (gVar3 == null) {
                throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
            }
            if (gVar2 == gVar3 || gVar2 == this.f62r) {
                dVar2.a();
                return;
            }
            int i11 = a0Var.f83c == 1 ? 2 : 0;
            int i12 = a0Var.f82b;
            int i13 = a0Var.f81a;
            String str = a0Var.f85e;
            MediaSessionCompat mediaSessionCompat = dVar2.f76a;
            if (mediaSessionCompat != null) {
                a2.c cVar = dVar2.f77b;
                if (cVar != null && i11 == 0 && i12 == 0) {
                    cVar.setCurrentVolume(i13);
                    return;
                }
                a2.c cVar2 = new a2.c(dVar2, i11, i12, i13, str);
                dVar2.f77b = cVar2;
                mediaSessionCompat.setPlaybackToRemote(cVar2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n(n.f fVar, k kVar) {
        boolean z10;
        boolean z11;
        int i10;
        if (fVar.f208e != kVar) {
            fVar.f208e = kVar;
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            ArrayList<n.g> arrayList = this.f51g;
            ArrayList arrayList2 = fVar.f205b;
            c cVar = this.f57m;
            if (kVar == null || !(kVar.isValid() || kVar == this.f46b.getDescriptor())) {
                Log.w("GlobalMediaRouter", "Ignoring invalid provider descriptor: " + kVar);
                z11 = false;
                i10 = 0;
            } else {
                List<a2.g> routes = kVar.getRoutes();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                boolean z12 = false;
                i10 = 0;
                for (a2.g gVar : routes) {
                    if (gVar == null || !gVar.isValid()) {
                        Log.w("GlobalMediaRouter", "Ignoring invalid system route descriptor: " + gVar);
                    } else {
                        String id2 = gVar.getId();
                        int size = arrayList2.size();
                        int i11 = 0;
                        while (true) {
                            if (i11 >= size) {
                                i11 = -1;
                                break;
                            } else if (((n.g) arrayList2.get(i11)).f210b.equals(id2)) {
                                break;
                            } else {
                                i11++;
                            }
                        }
                        if (i11 < 0) {
                            n.g gVar2 = new n.g(fVar, id2, b(fVar, id2));
                            int i12 = i10 + 1;
                            arrayList2.add(i10, gVar2);
                            arrayList.add(gVar2);
                            if (gVar.getGroupMemberIds().size() > 0) {
                                arrayList3.add(new w0.d(gVar2, gVar));
                            } else {
                                gVar2.b(gVar);
                                cVar.b(257, gVar2);
                            }
                            i10 = i12;
                        } else if (i11 < i10) {
                            Log.w("GlobalMediaRouter", "Ignoring route descriptor with duplicate id: " + gVar);
                        } else {
                            n.g gVar3 = (n.g) arrayList2.get(i11);
                            int i13 = i10 + 1;
                            Collections.swap(arrayList2, i11, i10);
                            if (gVar.getGroupMemberIds().size() > 0) {
                                arrayList4.add(new w0.d(gVar3, gVar));
                            } else if (o(gVar3, gVar) != 0 && gVar3 == this.f63s) {
                                i10 = i13;
                                z12 = true;
                            }
                            i10 = i13;
                        }
                    }
                }
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    w0.d dVar = (w0.d) it.next();
                    n.g gVar4 = (n.g) dVar.f20843a;
                    gVar4.b((a2.g) dVar.f20844b);
                    cVar.b(257, gVar4);
                }
                Iterator it2 = arrayList4.iterator();
                z11 = z12;
                while (it2.hasNext()) {
                    w0.d dVar2 = (w0.d) it2.next();
                    n.g gVar5 = (n.g) dVar2.f20843a;
                    if (o(gVar5, (a2.g) dVar2.f20844b) != 0 && gVar5 == this.f63s) {
                        z11 = true;
                    }
                }
            }
            for (int size2 = arrayList2.size() - 1; size2 >= i10; size2--) {
                n.g gVar6 = (n.g) arrayList2.get(size2);
                gVar6.b(null);
                arrayList.remove(gVar6);
            }
            p(z11);
            for (int size3 = arrayList2.size() - 1; size3 >= i10; size3--) {
                cVar.b(258, (n.g) arrayList2.remove(size3));
            }
            cVar.b(515, fVar);
        }
    }

    public final int o(n.g gVar, a2.g gVar2) {
        int iB = gVar.b(gVar2);
        if (iB != 0) {
            int i10 = iB & 1;
            c cVar = this.f57m;
            if (i10 != 0) {
                cVar.b(259, gVar);
            }
            if ((iB & 2) != 0) {
                cVar.b(260, gVar);
            }
            if ((iB & 4) != 0) {
                cVar.b(261, gVar);
            }
        }
        return iB;
    }

    public void onSystemRouteSelectedByDescriptorId(String str) {
        n.g gVarA;
        this.f57m.removeMessages(262);
        n.f fVarD = d(this.f46b);
        if (fVarD == null || (gVarA = fVarD.a(str)) == null) {
            return;
        }
        gVarA.select();
    }

    public final void p(boolean z10) {
        n.g gVar = this.f61q;
        if (gVar != null && !gVar.a()) {
            Log.i("GlobalMediaRouter", "Clearing the default route because it is no longer selectable: " + this.f61q);
            this.f61q = null;
        }
        n.g gVar2 = this.f61q;
        ArrayList<n.g> arrayList = this.f51g;
        c0 c0Var = this.f46b;
        if (gVar2 == null && !arrayList.isEmpty()) {
            Iterator<n.g> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n.g next = it.next();
                if ((next.getProviderInstance() == c0Var && next.f210b.equals("DEFAULT_ROUTE")) && next.a()) {
                    this.f61q = next;
                    Log.i("GlobalMediaRouter", "Found default route: " + this.f61q);
                    break;
                }
            }
        }
        n.g gVar3 = this.f62r;
        if (gVar3 != null && !gVar3.a()) {
            Log.i("GlobalMediaRouter", "Clearing the bluetooth route because it is no longer selectable: " + this.f62r);
            this.f62r = null;
        }
        if (this.f62r == null && !arrayList.isEmpty()) {
            Iterator<n.g> it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                n.g next2 = it2.next();
                if ((next2.getProviderInstance() == c0Var && next2.supportsControlCategory("android.media.intent.category.LIVE_AUDIO") && !next2.supportsControlCategory("android.media.intent.category.LIVE_VIDEO")) && next2.a()) {
                    this.f62r = next2;
                    Log.i("GlobalMediaRouter", "Found bluetooth route: " + this.f62r);
                    break;
                }
            }
        }
        n.g gVar4 = this.f63s;
        if (gVar4 == null || !gVar4.isEnabled()) {
            Log.i("GlobalMediaRouter", "Unselecting the current route because it is no longer selectable: " + this.f63s);
            k(c(), 0);
            return;
        }
        if (z10) {
            h();
            m();
        }
    }

    public void releaseProviderController(w wVar, i.e eVar) {
        if (this.f64t == eVar) {
            j(c(), 2);
        }
    }

    public void removeProvider(i iVar) {
        n.f fVarD = d(iVar);
        if (fVarD != null) {
            iVar.setCallback(null);
            iVar.setDiscoveryRequest(null);
            n(fVarD, null);
            this.f57m.b(514, fVarD);
            this.f53i.remove(fVarD);
        }
    }
}
