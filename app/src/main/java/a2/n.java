package a2;

import a2.a;
import a2.a.d;
import a2.a.e;
import a2.i;
import a2.m;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import com.unity3d.services.core.request.metrics.MetricCommonTags;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: MediaRouter.java */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: c, reason: collision with root package name */
    public static a2.a f186c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f187a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f188b = new ArrayList<>();

    /* compiled from: MediaRouter.java */
    public static abstract class a {
        @Deprecated
        public void onRouteSelected(n nVar, g gVar) {
        }

        @Deprecated
        public void onRouteUnselected(n nVar, g gVar) {
        }

        public void onRouteSelected(n nVar, g gVar, int i10) {
            onRouteSelected(nVar, gVar);
        }

        public void onRouteUnselected(n nVar, g gVar, int i10) {
            onRouteUnselected(nVar, gVar);
        }

        public void onRouteSelected(n nVar, g gVar, int i10, g gVar2) {
            onRouteSelected(nVar, gVar, i10);
        }

        public void onProviderAdded(n nVar, f fVar) {
        }

        public void onProviderChanged(n nVar, f fVar) {
        }

        public void onProviderRemoved(n nVar, f fVar) {
        }

        public void onRouteAdded(n nVar, g gVar) {
        }

        public void onRouteChanged(n nVar, g gVar) {
        }

        public void onRoutePresentationDisplayChanged(n nVar, g gVar) {
        }

        public void onRouteRemoved(n nVar, g gVar) {
        }

        public void onRouteVolumeChanged(n nVar, g gVar) {
        }

        public void onRouterParamsChanged(n nVar, u uVar) {
        }
    }

    /* compiled from: MediaRouter.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final n f189a;

        /* renamed from: b, reason: collision with root package name */
        public final a f190b;

        /* renamed from: c, reason: collision with root package name */
        public m f191c = m.f182c;

        /* renamed from: d, reason: collision with root package name */
        public int f192d;

        /* renamed from: e, reason: collision with root package name */
        public long f193e;

        public b(n nVar, a aVar) {
            this.f189a = nVar;
            this.f190b = aVar;
        }

        public boolean filterRouteEvent(g gVar, int i10, g gVar2, int i11) {
            if ((this.f192d & 2) != 0 || gVar.matchesSelector(this.f191c)) {
                return true;
            }
            u uVar = n.b().f60p;
            if ((uVar == null ? false : uVar.isTransferToLocalEnabled()) && gVar.isDefaultOrBluetooth() && i10 == 262 && i11 == 3 && gVar2 != null) {
                return !gVar2.isDefaultOrBluetooth();
            }
            return false;
        }
    }

    /* compiled from: MediaRouter.java */
    public interface d {
        e8.c<Void> onPrepareTransfer(g gVar, g gVar2);
    }

    /* compiled from: MediaRouter.java */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final i.e f194a;

        /* renamed from: b, reason: collision with root package name */
        public final int f195b;

        /* renamed from: c, reason: collision with root package name */
        public final g f196c;

        /* renamed from: d, reason: collision with root package name */
        public final g f197d;

        /* renamed from: e, reason: collision with root package name */
        public final g f198e;

        /* renamed from: f, reason: collision with root package name */
        public final ArrayList f199f;

        /* renamed from: g, reason: collision with root package name */
        public final WeakReference<a2.a> f200g;

        /* renamed from: h, reason: collision with root package name */
        public e8.c<Void> f201h = null;

        /* renamed from: i, reason: collision with root package name */
        public boolean f202i = false;

        /* renamed from: j, reason: collision with root package name */
        public boolean f203j = false;

        public e(a2.a aVar, g gVar, i.e eVar, int i10, g gVar2, Collection<i.b.C0003b> collection) {
            this.f200g = new WeakReference<>(aVar);
            this.f197d = gVar;
            this.f194a = eVar;
            this.f195b = i10;
            this.f196c = aVar.f63s;
            this.f198e = gVar2;
            this.f199f = collection != null ? new ArrayList(collection) : null;
            aVar.f57m.postDelayed(new o(this, 0), 15000L);
        }

        public final void a() {
            if (this.f202i || this.f203j) {
                return;
            }
            this.f203j = true;
            i.e eVar = this.f194a;
            if (eVar != null) {
                eVar.onUnselect(0);
                eVar.onRelease();
            }
        }

        public final void b() {
            e8.c<Void> cVar;
            n.a();
            if (this.f202i || this.f203j) {
                return;
            }
            WeakReference<a2.a> weakReference = this.f200g;
            a2.a aVar = weakReference.get();
            if (aVar == null || aVar.B != this || ((cVar = this.f201h) != null && cVar.isCancelled())) {
                a();
                return;
            }
            this.f202i = true;
            aVar.B = null;
            a2.a aVar2 = weakReference.get();
            int i10 = this.f195b;
            g gVar = this.f196c;
            if (aVar2 != null && aVar2.f63s == gVar) {
                Message messageObtainMessage = aVar2.f57m.obtainMessage(263, gVar);
                messageObtainMessage.arg1 = i10;
                messageObtainMessage.sendToTarget();
                i.e eVar = aVar2.f64t;
                if (eVar != null) {
                    eVar.onUnselect(i10);
                    aVar2.f64t.onRelease();
                }
                HashMap map = aVar2.f67w;
                if (!map.isEmpty()) {
                    for (i.e eVar2 : map.values()) {
                        eVar2.onUnselect(i10);
                        eVar2.onRelease();
                    }
                    map.clear();
                }
                aVar2.f64t = null;
            }
            a2.a aVar3 = weakReference.get();
            if (aVar3 == null) {
                return;
            }
            g gVar2 = this.f197d;
            aVar3.f63s = gVar2;
            aVar3.f64t = this.f194a;
            a.c cVar2 = aVar3.f57m;
            g gVar3 = this.f198e;
            if (gVar3 == null) {
                Message messageObtainMessage2 = cVar2.obtainMessage(262, new w0.d(gVar, gVar2));
                messageObtainMessage2.arg1 = i10;
                messageObtainMessage2.sendToTarget();
            } else {
                Message messageObtainMessage3 = cVar2.obtainMessage(264, new w0.d(gVar3, gVar2));
                messageObtainMessage3.arg1 = i10;
                messageObtainMessage3.sendToTarget();
            }
            aVar3.f67w.clear();
            aVar3.h();
            aVar3.m();
            ArrayList arrayList = this.f199f;
            if (arrayList != null) {
                aVar3.f63s.c(arrayList);
            }
        }
    }

    /* compiled from: MediaRouter.java */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final i f204a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f205b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final boolean f206c;

        /* renamed from: d, reason: collision with root package name */
        public final i.d f207d;

        /* renamed from: e, reason: collision with root package name */
        public k f208e;

        public f(i iVar, boolean z10) {
            this.f204a = iVar;
            this.f207d = iVar.getMetadata();
            this.f206c = z10;
        }

        public final g a(String str) {
            Iterator it = this.f205b.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                if (gVar.f210b.equals(str)) {
                    return gVar;
                }
            }
            return null;
        }

        public ComponentName getComponentName() {
            return this.f207d.getComponentName();
        }

        public String getPackageName() {
            return this.f207d.getPackageName();
        }

        public i getProviderInstance() {
            n.a();
            return this.f204a;
        }

        public List<g> getRoutes() {
            n.a();
            return Collections.unmodifiableList(this.f205b);
        }

        public String toString() {
            return "MediaRouter.RouteProviderInfo{ packageName=" + getPackageName() + " }";
        }
    }

    /* compiled from: MediaRouter.java */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public final f f209a;

        /* renamed from: b, reason: collision with root package name */
        public final String f210b;

        /* renamed from: c, reason: collision with root package name */
        public final String f211c;

        /* renamed from: d, reason: collision with root package name */
        public String f212d;

        /* renamed from: e, reason: collision with root package name */
        public String f213e;

        /* renamed from: f, reason: collision with root package name */
        public Uri f214f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f215g;

        /* renamed from: h, reason: collision with root package name */
        public int f216h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f217i;

        /* renamed from: k, reason: collision with root package name */
        public int f219k;

        /* renamed from: l, reason: collision with root package name */
        public int f220l;

        /* renamed from: m, reason: collision with root package name */
        public int f221m;

        /* renamed from: n, reason: collision with root package name */
        public int f222n;

        /* renamed from: o, reason: collision with root package name */
        public int f223o;

        /* renamed from: p, reason: collision with root package name */
        public int f224p;

        /* renamed from: r, reason: collision with root package name */
        public Bundle f226r;

        /* renamed from: s, reason: collision with root package name */
        public IntentSender f227s;

        /* renamed from: t, reason: collision with root package name */
        public a2.g f228t;

        /* renamed from: v, reason: collision with root package name */
        public b0.b f230v;

        /* renamed from: j, reason: collision with root package name */
        public final ArrayList<IntentFilter> f218j = new ArrayList<>();

        /* renamed from: q, reason: collision with root package name */
        public int f225q = -1;

        /* renamed from: u, reason: collision with root package name */
        public ArrayList f229u = new ArrayList();

        /* compiled from: MediaRouter.java */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public final i.b.C0003b f231a;

            public a(i.b.C0003b c0003b) {
                this.f231a = c0003b;
            }

            public int getSelectionState() {
                i.b.C0003b c0003b = this.f231a;
                if (c0003b != null) {
                    return c0003b.getSelectionState();
                }
                return 1;
            }

            public boolean isGroupable() {
                i.b.C0003b c0003b = this.f231a;
                return c0003b != null && c0003b.isGroupable();
            }

            public boolean isTransferable() {
                i.b.C0003b c0003b = this.f231a;
                return c0003b != null && c0003b.isTransferable();
            }

            public boolean isUnselectable() {
                i.b.C0003b c0003b = this.f231a;
                return c0003b == null || c0003b.isUnselectable();
            }
        }

        public g(f fVar, String str, String str2) {
            this.f209a = fVar;
            this.f210b = str;
            this.f211c = str2;
        }

        public final boolean a() {
            return this.f228t != null && this.f215g;
        }

        /* JADX WARN: Removed duplicated region for block: B:126:0x00f3 A[EDGE_INSN: B:126:0x00f3->B:66:0x00f3 BREAK  A[LOOP:0: B:29:0x007f->B:129:?], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:129:? A[LOOP:0: B:29:0x007f->B:129:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00f1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int b(a2.g r13) {
            /*
                Method dump skipped, instructions count: 556
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.n.g.b(a2.g):int");
        }

        public final void c(Collection<i.b.C0003b> collection) {
            this.f229u.clear();
            if (this.f230v == null) {
                this.f230v = new b0.b();
            }
            this.f230v.clear();
            for (i.b.C0003b c0003b : collection) {
                g gVarA = getProvider().a(c0003b.getRouteDescriptor().getId());
                if (gVarA != null) {
                    this.f230v.put(gVarA.f211c, c0003b);
                    if (c0003b.getSelectionState() == 2 || c0003b.getSelectionState() == 3) {
                        this.f229u.add(gVarA);
                    }
                }
            }
            n.b().f57m.b(259, this);
        }

        public boolean canDisconnect() {
            return this.f217i;
        }

        public int getConnectionState() {
            return this.f216h;
        }

        public String getDescription() {
            return this.f213e;
        }

        public int getDeviceType() {
            return this.f221m;
        }

        public i.b getDynamicGroupController() {
            n.a();
            i.e eVar = n.b().f64t;
            if (eVar instanceof i.b) {
                return (i.b) eVar;
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a getDynamicGroupState(g gVar) {
            if (gVar == null) {
                throw new NullPointerException("route must not be null");
            }
            b0.b bVar = this.f230v;
            if (bVar == null) {
                return null;
            }
            String str = gVar.f211c;
            if (bVar.containsKey(str)) {
                return new a((i.b.C0003b) this.f230v.get(str));
            }
            return null;
        }

        public Bundle getExtras() {
            return this.f226r;
        }

        public Uri getIconUri() {
            return this.f214f;
        }

        public String getId() {
            return this.f211c;
        }

        public List<g> getMemberRoutes() {
            return Collections.unmodifiableList(this.f229u);
        }

        public String getName() {
            return this.f212d;
        }

        public int getPlaybackStream() {
            return this.f220l;
        }

        public int getPlaybackType() {
            return this.f219k;
        }

        public int getPresentationDisplayId() {
            return this.f225q;
        }

        public f getProvider() {
            return this.f209a;
        }

        public i getProviderInstance() {
            return this.f209a.getProviderInstance();
        }

        public int getVolume() {
            return this.f223o;
        }

        public int getVolumeHandling() {
            if (!isGroup() || n.isGroupVolumeUxEnabled()) {
                return this.f222n;
            }
            return 0;
        }

        public int getVolumeMax() {
            return this.f224p;
        }

        public boolean isDefault() {
            n.a();
            g gVar = n.b().f61q;
            if (gVar != null) {
                return gVar == this;
            }
            throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
        }

        public boolean isDefaultOrBluetooth() {
            if (isDefault() || this.f221m == 3) {
                return true;
            }
            return TextUtils.equals(getProviderInstance().getMetadata().getPackageName(), MetricCommonTags.METRIC_COMMON_TAG_PLATFORM_ANDROID) && supportsControlCategory("android.media.intent.category.LIVE_AUDIO") && !supportsControlCategory("android.media.intent.category.LIVE_VIDEO");
        }

        public boolean isEnabled() {
            return this.f215g;
        }

        public boolean isGroup() {
            return getMemberRoutes().size() >= 1;
        }

        public boolean isSelected() {
            n.a();
            return n.b().f() == this;
        }

        public boolean matchesSelector(m mVar) {
            if (mVar == null) {
                throw new IllegalArgumentException("selector must not be null");
            }
            n.a();
            return mVar.matchesControlFilters(this.f218j);
        }

        public void requestSetVolume(int i10) {
            i.e eVar;
            i.e eVar2;
            n.a();
            a2.a aVarB = n.b();
            int iMin = Math.min(this.f224p, Math.max(0, i10));
            if (this == aVarB.f63s && (eVar2 = aVarB.f64t) != null) {
                eVar2.onSetVolume(iMin);
                return;
            }
            HashMap map = aVarB.f67w;
            if (map.isEmpty() || (eVar = (i.e) map.get(this.f211c)) == null) {
                return;
            }
            eVar.onSetVolume(iMin);
        }

        public void requestUpdateVolume(int i10) {
            i.e eVar;
            i.e eVar2;
            n.a();
            if (i10 != 0) {
                a2.a aVarB = n.b();
                if (this == aVarB.f63s && (eVar2 = aVarB.f64t) != null) {
                    eVar2.onUpdateVolume(i10);
                    return;
                }
                HashMap map = aVarB.f67w;
                if (map.isEmpty() || (eVar = (i.e) map.get(this.f211c)) == null) {
                    return;
                }
                eVar.onUpdateVolume(i10);
            }
        }

        public void select() {
            n.a();
            n.b().j(this, 3);
        }

        public boolean supportsControlCategory(String str) {
            if (str == null) {
                throw new IllegalArgumentException("category must not be null");
            }
            n.a();
            Iterator<IntentFilter> it = this.f218j.iterator();
            while (it.hasNext()) {
                if (it.next().hasCategory(str)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("MediaRouter.RouteInfo{ uniqueId=");
            sb2.append(this.f211c);
            sb2.append(", name=");
            sb2.append(this.f212d);
            sb2.append(", description=");
            sb2.append(this.f213e);
            sb2.append(", iconUri=");
            sb2.append(this.f214f);
            sb2.append(", enabled=");
            sb2.append(this.f215g);
            sb2.append(", connectionState=");
            sb2.append(this.f216h);
            sb2.append(", canDisconnect=");
            sb2.append(this.f217i);
            sb2.append(", playbackType=");
            sb2.append(this.f219k);
            sb2.append(", playbackStream=");
            sb2.append(this.f220l);
            sb2.append(", deviceType=");
            sb2.append(this.f221m);
            sb2.append(", volumeHandling=");
            sb2.append(this.f222n);
            sb2.append(", volume=");
            sb2.append(this.f223o);
            sb2.append(", volumeMax=");
            sb2.append(this.f224p);
            sb2.append(", presentationDisplayId=");
            sb2.append(this.f225q);
            sb2.append(", extras=");
            sb2.append(this.f226r);
            sb2.append(", settingsIntent=");
            sb2.append(this.f227s);
            sb2.append(", providerPackageName=");
            sb2.append(this.f209a.getPackageName());
            if (isGroup()) {
                sb2.append(", members=[");
                int size = this.f229u.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (i10 > 0) {
                        sb2.append(", ");
                    }
                    if (this.f229u.get(i10) != this) {
                        sb2.append(((g) this.f229u.get(i10)).getId());
                    }
                }
                sb2.append(']');
            }
            sb2.append(" }");
            return sb2.toString();
        }
    }

    static {
        Log.isLoggable("AxMediaRouter", 3);
    }

    public n(Context context) {
        this.f187a = context;
    }

    public static void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("The media router service must only be accessed on the application's main thread.");
        }
    }

    public static a2.a b() {
        a2.a aVar = f186c;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("getGlobalRouter cannot be called when sGlobal is null");
    }

    public static n getInstance(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        a();
        if (f186c == null) {
            f186c = new a2.a(context.getApplicationContext());
        }
        ArrayList<WeakReference<n>> arrayList = f186c.f50f;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                n nVar = new n(context);
                arrayList.add(new WeakReference<>(nVar));
                return nVar;
            }
            n nVar2 = arrayList.get(size).get();
            if (nVar2 == null) {
                arrayList.remove(size);
            } else if (nVar2.f187a == context) {
                return nVar2;
            }
        }
    }

    public static boolean isGroupVolumeUxEnabled() {
        Bundle bundle;
        if (f186c == null) {
            return false;
        }
        u uVar = b().f60p;
        return uVar == null || (bundle = uVar.f245e) == null || bundle.getBoolean("androidx.mediarouter.media.MediaRouterParams.ENABLE_GROUP_VOLUME_UX", true);
    }

    public static boolean isMediaTransferEnabled() {
        if (f186c == null) {
            return false;
        }
        return b().g();
    }

    public void addCallback(m mVar, a aVar) {
        addCallback(mVar, aVar, 0);
    }

    public void addMemberToDynamicGroup(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("route must not be null");
        }
        a();
        a2.a aVarB = b();
        if (!(aVarB.f64t instanceof i.b)) {
            throw new IllegalStateException("There is no currently selected dynamic group route.");
        }
        g.a dynamicGroupState = aVarB.f63s.getDynamicGroupState(gVar);
        if (!aVarB.f63s.getMemberRoutes().contains(gVar) && dynamicGroupState != null && dynamicGroupState.isGroupable()) {
            ((i.b) aVarB.f64t).onAddMemberRoute(gVar.f210b);
            return;
        }
        Log.w("GlobalMediaRouter", "Ignoring attempt to add a non-groupable route to dynamic group : " + gVar);
    }

    public g getBluetoothRoute() {
        a();
        return b().f62r;
    }

    public g getDefaultRoute() {
        a();
        g gVar = b().f61q;
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
    }

    public MediaSessionCompat.Token getMediaSessionToken() {
        a2.a aVar = f186c;
        if (aVar == null) {
            return null;
        }
        a.d dVar = aVar.C;
        if (dVar != null) {
            MediaSessionCompat mediaSessionCompat = dVar.f76a;
            if (mediaSessionCompat != null) {
                return mediaSessionCompat.getSessionToken();
            }
            return null;
        }
        MediaSessionCompat mediaSessionCompat2 = aVar.D;
        if (mediaSessionCompat2 != null) {
            return mediaSessionCompat2.getSessionToken();
        }
        return null;
    }

    public u getRouterParams() {
        a();
        return b().f60p;
    }

    public List<g> getRoutes() {
        a();
        return b().f51g;
    }

    public g getSelectedRoute() {
        a();
        return b().f();
    }

    public boolean isRouteAvailable(m mVar, int i10) {
        if (mVar == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        a();
        a2.a aVarB = b();
        aVarB.getClass();
        if (mVar.isEmpty()) {
            return false;
        }
        if ((i10 & 2) != 0 || !aVarB.f58n) {
            u uVar = aVarB.f60p;
            boolean z10 = uVar != null && uVar.isOutputSwitcherEnabled() && aVarB.g();
            ArrayList<g> arrayList = aVarB.f51g;
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                g gVar = arrayList.get(i11);
                if (((i10 & 1) != 0 && gVar.isDefaultOrBluetooth()) || ((z10 && !gVar.isDefaultOrBluetooth() && gVar.getProviderInstance() != aVarB.f49e) || !gVar.matchesSelector(mVar))) {
                }
            }
            return false;
        }
        return true;
    }

    public void removeCallback(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        a();
        ArrayList<b> arrayList = this.f188b;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (arrayList.get(i10).f190b == aVar) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 >= 0) {
            arrayList.remove(i10);
            b().l();
        }
    }

    public void removeMemberFromDynamicGroup(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("route must not be null");
        }
        a();
        a2.a aVarB = b();
        if (!(aVarB.f64t instanceof i.b)) {
            throw new IllegalStateException("There is no currently selected dynamic group route.");
        }
        g.a dynamicGroupState = aVarB.f63s.getDynamicGroupState(gVar);
        if (!aVarB.f63s.getMemberRoutes().contains(gVar) || dynamicGroupState == null || !dynamicGroupState.isUnselectable()) {
            Log.w("GlobalMediaRouter", "Ignoring attempt to remove a non-unselectable member route : " + gVar);
        } else if (aVarB.f63s.getMemberRoutes().size() <= 1) {
            Log.w("GlobalMediaRouter", "Ignoring attempt to remove the last member route.");
        } else {
            ((i.b) aVarB.f64t).onRemoveMemberRoute(gVar.f210b);
        }
    }

    public void selectRoute(g gVar) {
        if (gVar == null) {
            throw new IllegalArgumentException("route must not be null");
        }
        a();
        b().j(gVar, 3);
    }

    public void setMediaSessionCompat(MediaSessionCompat mediaSessionCompat) {
        a();
        a2.a aVarB = b();
        aVarB.D = mediaSessionCompat;
        a.d dVar = mediaSessionCompat != null ? aVarB.new d(mediaSessionCompat) : null;
        a.d dVar2 = aVarB.C;
        if (dVar2 != null) {
            dVar2.a();
        }
        aVarB.C = dVar;
        if (dVar != null) {
            aVarB.m();
        }
    }

    public void setOnPrepareTransferListener(d dVar) {
        a();
        b().A = dVar;
    }

    public void setRouterParams(u uVar) {
        a();
        a2.a aVarB = b();
        u uVar2 = aVarB.f60p;
        aVarB.f60p = uVar;
        if (aVarB.g()) {
            if (aVarB.f49e == null) {
                a2.f fVar = new a2.f(aVarB.f45a, aVarB.new e());
                aVarB.f49e = fVar;
                aVarB.a(fVar, true);
                aVarB.l();
                aVarB.f47c.rescan();
            }
            boolean z10 = false;
            boolean z11 = uVar2 != null && uVar2.isTransferToLocalEnabled();
            if (uVar != null && uVar.isTransferToLocalEnabled()) {
                z10 = true;
            }
            if (z11 != z10) {
                a2.f fVar2 = aVarB.f49e;
                fVar2.f149e = aVarB.f69y;
                if (!fVar2.f150f) {
                    fVar2.f150f = true;
                    fVar2.f147c.sendEmptyMessage(2);
                }
            }
        } else {
            a2.f fVar3 = aVarB.f49e;
            if (fVar3 != null) {
                aVarB.removeProvider(fVar3);
                aVarB.f49e = null;
                aVarB.f47c.rescan();
            }
        }
        aVarB.f57m.b(769, uVar);
    }

    public void transferToRoute(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("route must not be null");
        }
        a();
        a2.a aVarB = b();
        if (!(aVarB.f64t instanceof i.b)) {
            throw new IllegalStateException("There is no currently selected dynamic group route.");
        }
        g.a dynamicGroupState = aVarB.f63s.getDynamicGroupState(gVar);
        if (dynamicGroupState == null || !dynamicGroupState.isTransferable()) {
            Log.w("GlobalMediaRouter", "Ignoring attempt to transfer to a non-transferable route.");
        } else {
            ((i.b) aVarB.f64t).onUpdateMemberRoutes(Collections.singletonList(gVar.f210b));
        }
    }

    public void unselect(int i10) {
        if (i10 < 0 || i10 > 3) {
            throw new IllegalArgumentException("Unsupported reason to unselect route");
        }
        a();
        a2.a aVarB = b();
        g gVarC = aVarB.c();
        if (aVarB.f() != gVarC) {
            aVarB.j(gVarC, i10);
        }
    }

    public void addCallback(m mVar, a aVar, int i10) {
        b bVar;
        if (mVar == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        a();
        ArrayList<b> arrayList = this.f188b;
        int size = arrayList.size();
        boolean z10 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                i11 = -1;
                break;
            } else if (arrayList.get(i11).f190b == aVar) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 < 0) {
            bVar = new b(this, aVar);
            arrayList.add(bVar);
        } else {
            bVar = arrayList.get(i11);
        }
        boolean z11 = true;
        if (i10 != bVar.f192d) {
            bVar.f192d = i10;
            z10 = true;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        bVar.f193e = jElapsedRealtime;
        if (bVar.f191c.contains(mVar)) {
            z11 = z10;
        } else {
            bVar.f191c = new m.a(bVar.f191c).addSelector(mVar).build();
        }
        if (z11) {
            b().l();
        }
    }

    /* compiled from: MediaRouter.java */
    public static abstract class c {
        public void onResult(Bundle bundle) {
        }

        public void onError(String str, Bundle bundle) {
        }
    }
}
