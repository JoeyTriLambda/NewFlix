package a2;

import a2.a;
import a2.g;
import a2.i;
import a2.k;
import a2.m;
import a2.n;
import android.content.Context;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.media.RouteDiscoveryPreference;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.SparseArray;
import androidx.mediarouter.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: MediaRoute2Provider.java */
/* loaded from: classes.dex */
public final class f extends i {

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f110r = 0;

    /* renamed from: i, reason: collision with root package name */
    public final MediaRouter2 f111i;

    /* renamed from: j, reason: collision with root package name */
    public final a f112j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayMap f113k;

    /* renamed from: l, reason: collision with root package name */
    public final MediaRouter2.RouteCallback f114l;

    /* renamed from: m, reason: collision with root package name */
    public final g f115m;

    /* renamed from: n, reason: collision with root package name */
    public final b f116n;

    /* renamed from: o, reason: collision with root package name */
    public final a2.e f117o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f118p;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayMap f119q;

    /* compiled from: MediaRoute2Provider.java */
    public static abstract class a {
        public abstract void onReleaseController(i.e eVar);

        public abstract void onSelectFallbackRoute(int i10);

        public abstract void onSelectRoute(String str, int i10);
    }

    /* compiled from: MediaRoute2Provider.java */
    public class b extends MediaRouter2.ControllerCallback {
        public b() {
        }

        @Override // android.media.MediaRouter2.ControllerCallback
        public void onControllerUpdated(MediaRouter2.RoutingController routingController) {
            f.this.b(routingController);
        }
    }

    /* compiled from: MediaRoute2Provider.java */
    public class c extends i.b {

        /* renamed from: f, reason: collision with root package name */
        public final String f121f;

        /* renamed from: g, reason: collision with root package name */
        public final MediaRouter2.RoutingController f122g;

        /* renamed from: h, reason: collision with root package name */
        public final Messenger f123h;

        /* renamed from: i, reason: collision with root package name */
        public final Messenger f124i;

        /* renamed from: k, reason: collision with root package name */
        public final Handler f126k;

        /* renamed from: o, reason: collision with root package name */
        public a2.g f130o;

        /* renamed from: j, reason: collision with root package name */
        public final SparseArray<n.c> f125j = new SparseArray<>();

        /* renamed from: l, reason: collision with root package name */
        public final AtomicInteger f127l = new AtomicInteger(1);

        /* renamed from: m, reason: collision with root package name */
        public final androidx.activity.d f128m = new androidx.activity.d(this, 7);

        /* renamed from: n, reason: collision with root package name */
        public int f129n = -1;

        /* compiled from: MediaRoute2Provider.java */
        public class a extends Handler {
            public a() {
                super(Looper.getMainLooper());
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i10 = message.what;
                int i11 = message.arg1;
                Object obj = message.obj;
                Bundle bundlePeekData = message.peekData();
                c cVar = c.this;
                n.c cVar2 = cVar.f125j.get(i11);
                if (cVar2 == null) {
                    Log.w("MR2Provider", "Pending callback not found for control request.");
                    return;
                }
                cVar.f125j.remove(i11);
                if (i10 == 3) {
                    cVar2.onResult((Bundle) obj);
                } else {
                    if (i10 != 4) {
                        return;
                    }
                    cVar2.onError(bundlePeekData == null ? null : bundlePeekData.getString("error"), (Bundle) obj);
                }
            }
        }

        public c(MediaRouter2.RoutingController routingController, String str) {
            Bundle controlHints;
            this.f122g = routingController;
            this.f121f = str;
            int i10 = f.f110r;
            Messenger messenger = (routingController == null || (controlHints = routingController.getControlHints()) == null) ? null : (Messenger) controlHints.getParcelable("androidx.mediarouter.media.KEY_MESSENGER");
            this.f123h = messenger;
            this.f124i = messenger != null ? new Messenger(new a()) : null;
            this.f126k = new Handler(Looper.getMainLooper());
        }

        public String getGroupRouteId() {
            a2.g gVar = this.f130o;
            return gVar != null ? gVar.getId() : this.f122g.getId();
        }

        @Override // a2.i.b
        public void onAddMemberRoute(String str) {
            if (str == null || str.isEmpty()) {
                Log.w("MR2Provider", "onAddMemberRoute: Ignoring null or empty routeId.");
                return;
            }
            MediaRoute2Info mediaRoute2InfoA = f.this.a(str);
            if (mediaRoute2InfoA == null) {
                Log.w("MR2Provider", "onAddMemberRoute: Specified route not found. routeId=".concat(str));
            } else {
                this.f122g.selectRoute(mediaRoute2InfoA);
            }
        }

        @Override // a2.i.e
        public void onRelease() {
            this.f122g.release();
        }

        @Override // a2.i.b
        public void onRemoveMemberRoute(String str) {
            if (str == null || str.isEmpty()) {
                Log.w("MR2Provider", "onRemoveMemberRoute: Ignoring null or empty routeId.");
                return;
            }
            MediaRoute2Info mediaRoute2InfoA = f.this.a(str);
            if (mediaRoute2InfoA == null) {
                Log.w("MR2Provider", "onRemoveMemberRoute: Specified route not found. routeId=".concat(str));
            } else {
                this.f122g.deselectRoute(mediaRoute2InfoA);
            }
        }

        @Override // a2.i.e
        public void onSetVolume(int i10) {
            MediaRouter2.RoutingController routingController = this.f122g;
            if (routingController == null) {
                return;
            }
            routingController.setVolume(i10);
            this.f129n = i10;
            Handler handler = this.f126k;
            androidx.activity.d dVar = this.f128m;
            handler.removeCallbacks(dVar);
            handler.postDelayed(dVar, 1000L);
        }

        @Override // a2.i.b
        public void onUpdateMemberRoutes(List<String> list) {
            if (list == null || list.isEmpty()) {
                Log.w("MR2Provider", "onUpdateMemberRoutes: Ignoring null or empty routeIds.");
                return;
            }
            String str = list.get(0);
            f fVar = f.this;
            MediaRoute2Info mediaRoute2InfoA = fVar.a(str);
            if (mediaRoute2InfoA != null) {
                fVar.f111i.transferTo(mediaRoute2InfoA);
                return;
            }
            Log.w("MR2Provider", "onUpdateMemberRoutes: Specified route not found. routeId=" + str);
        }

        @Override // a2.i.e
        public void onUpdateVolume(int i10) {
            MediaRouter2.RoutingController routingController = this.f122g;
            if (routingController == null) {
                return;
            }
            int volume = this.f129n;
            if (volume < 0) {
                volume = routingController.getVolume();
            }
            int iMax = Math.max(0, Math.min(volume + i10, routingController.getVolumeMax()));
            this.f129n = iMax;
            routingController.setVolume(iMax);
            Handler handler = this.f126k;
            androidx.activity.d dVar = this.f128m;
            handler.removeCallbacks(dVar);
            handler.postDelayed(dVar, 1000L);
        }
    }

    /* compiled from: MediaRoute2Provider.java */
    public class d extends i.e {

        /* renamed from: a, reason: collision with root package name */
        public final String f133a;

        /* renamed from: b, reason: collision with root package name */
        public final c f134b;

        public d(String str, c cVar) {
            this.f133a = str;
            this.f134b = cVar;
        }

        @Override // a2.i.e
        public void onSetVolume(int i10) throws RemoteException {
            c cVar;
            MediaRouter2.RoutingController routingController;
            Messenger messenger;
            String str = this.f133a;
            if (str == null || (cVar = this.f134b) == null || (routingController = cVar.f122g) == null || routingController.isReleased() || (messenger = cVar.f123h) == null) {
                return;
            }
            int andIncrement = cVar.f127l.getAndIncrement();
            Message messageObtain = Message.obtain();
            messageObtain.what = 7;
            messageObtain.arg1 = andIncrement;
            Bundle bundle = new Bundle();
            bundle.putInt("volume", i10);
            bundle.putString("routeId", str);
            messageObtain.setData(bundle);
            messageObtain.replyTo = cVar.f124i;
            try {
                messenger.send(messageObtain);
            } catch (DeadObjectException unused) {
            } catch (RemoteException e10) {
                Log.e("MR2Provider", "Could not send control request to service.", e10);
            }
        }

        @Override // a2.i.e
        public void onUpdateVolume(int i10) throws RemoteException {
            c cVar;
            MediaRouter2.RoutingController routingController;
            Messenger messenger;
            String str = this.f133a;
            if (str == null || (cVar = this.f134b) == null || (routingController = cVar.f122g) == null || routingController.isReleased() || (messenger = cVar.f123h) == null) {
                return;
            }
            int andIncrement = cVar.f127l.getAndIncrement();
            Message messageObtain = Message.obtain();
            messageObtain.what = 8;
            messageObtain.arg1 = andIncrement;
            Bundle bundle = new Bundle();
            bundle.putInt("volume", i10);
            bundle.putString("routeId", str);
            messageObtain.setData(bundle);
            messageObtain.replyTo = cVar.f124i;
            try {
                messenger.send(messageObtain);
            } catch (DeadObjectException unused) {
            } catch (RemoteException e10) {
                Log.e("MR2Provider", "Could not send control request to service.", e10);
            }
        }
    }

    /* compiled from: MediaRoute2Provider.java */
    public class e extends MediaRouter2.RouteCallback {
        public e() {
        }

        @Override // android.media.MediaRouter2.RouteCallback
        public void onRoutesAdded(List<MediaRoute2Info> list) {
            f.this.refreshRoutes();
        }

        @Override // android.media.MediaRouter2.RouteCallback
        public void onRoutesChanged(List<MediaRoute2Info> list) {
            f.this.refreshRoutes();
        }

        @Override // android.media.MediaRouter2.RouteCallback
        public void onRoutesRemoved(List<MediaRoute2Info> list) {
            f.this.refreshRoutes();
        }
    }

    /* compiled from: MediaRoute2Provider.java */
    /* renamed from: a2.f$f, reason: collision with other inner class name */
    public class C0002f extends MediaRouter2.RouteCallback {
        public C0002f() {
        }

        @Override // android.media.MediaRouter2.RouteCallback
        public void onRoutesUpdated(List<MediaRoute2Info> list) {
            f.this.refreshRoutes();
        }
    }

    /* compiled from: MediaRoute2Provider.java */
    public class g extends MediaRouter2.TransferCallback {
        public g() {
        }

        @Override // android.media.MediaRouter2.TransferCallback
        public void onStop(MediaRouter2.RoutingController routingController) {
            i.e eVar = (i.e) f.this.f113k.remove(routingController);
            if (eVar != null) {
                f.this.f112j.onReleaseController(eVar);
                return;
            }
            Log.w("MR2Provider", "onStop: No matching routeController found. routingController=" + routingController);
        }

        @Override // android.media.MediaRouter2.TransferCallback
        public void onTransfer(MediaRouter2.RoutingController routingController, MediaRouter2.RoutingController routingController2) {
            f.this.f113k.remove(routingController);
            if (routingController2 == f.this.f111i.getSystemController()) {
                f.this.f112j.onSelectFallbackRoute(3);
                return;
            }
            List selectedRoutes = routingController2.getSelectedRoutes();
            if (selectedRoutes.isEmpty()) {
                Log.w("MR2Provider", "Selected routes are empty. This shouldn't happen.");
                return;
            }
            String id2 = ((MediaRoute2Info) selectedRoutes.get(0)).getId();
            f.this.f113k.put(routingController2, f.this.new c(routingController2, id2));
            f.this.f112j.onSelectRoute(id2, 3);
            f.this.b(routingController2);
        }

        @Override // android.media.MediaRouter2.TransferCallback
        public void onTransferFailure(MediaRoute2Info mediaRoute2Info) {
            Log.w("MR2Provider", "Transfer failed. requestedRoute=" + mediaRoute2Info);
        }
    }

    static {
        Log.isLoggable("MR2Provider", 3);
    }

    public f(Context context, a.e eVar) {
        super(context);
        this.f113k = new ArrayMap();
        this.f115m = new g();
        this.f116n = new b();
        this.f118p = new ArrayList();
        this.f119q = new ArrayMap();
        this.f111i = MediaRouter2.getInstance(context);
        this.f112j = eVar;
        this.f117o = new a2.e(0, new Handler(Looper.getMainLooper()));
        if (Build.VERSION.SDK_INT >= 34) {
            this.f114l = new C0002f();
        } else {
            this.f114l = new e();
        }
    }

    public final MediaRoute2Info a(String str) {
        if (str == null) {
            return null;
        }
        Iterator it = this.f118p.iterator();
        while (it.hasNext()) {
            MediaRoute2Info mediaRoute2Info = (MediaRoute2Info) it.next();
            if (TextUtils.equals(mediaRoute2Info.getId(), str)) {
                return mediaRoute2Info;
            }
        }
        return null;
    }

    public final void b(MediaRouter2.RoutingController routingController) {
        c cVar = (c) this.f113k.get(routingController);
        if (cVar == null) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: No matching routeController found. routingController=" + routingController);
            return;
        }
        List selectedRoutes = routingController.getSelectedRoutes();
        if (selectedRoutes.isEmpty()) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: No selected routes. This may happen when the selected routes become invalid.routingController=" + routingController);
            return;
        }
        ArrayList arrayListA = q.a(selectedRoutes);
        a2.g mediaRouteDescriptor = q.toMediaRouteDescriptor((MediaRoute2Info) selectedRoutes.get(0));
        Bundle controlHints = routingController.getControlHints();
        String string = getContext().getString(R.string.mr_dialog_default_group_name);
        a2.g gVarFromBundle = null;
        if (controlHints != null) {
            try {
                String string2 = controlHints.getString("androidx.mediarouter.media.KEY_SESSION_NAME");
                if (!TextUtils.isEmpty(string2)) {
                    string = string2;
                }
                Bundle bundle = controlHints.getBundle("androidx.mediarouter.media.KEY_GROUP_ROUTE");
                if (bundle != null) {
                    gVarFromBundle = a2.g.fromBundle(bundle);
                }
            } catch (Exception e10) {
                Log.w("MR2Provider", "Exception while unparceling control hints.", e10);
            }
        }
        a2.g gVarBuild = (gVarFromBundle == null ? new g.a(routingController.getId(), string).setConnectionState(2).setPlaybackType(1) : new g.a(gVarFromBundle)).setVolume(routingController.getVolume()).setVolumeMax(routingController.getVolumeMax()).setVolumeHandling(routingController.getVolumeHandling()).clearControlFilters().addControlFilters(mediaRouteDescriptor.getControlFilters()).clearGroupMemberIds().addGroupMemberIds(arrayListA).build();
        ArrayList arrayListA2 = q.a(routingController.getSelectableRoutes());
        ArrayList arrayListA3 = q.a(routingController.getDeselectableRoutes());
        k descriptor = getDescriptor();
        if (descriptor == null) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: providerDescriptor is not set.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<a2.g> routes = descriptor.getRoutes();
        if (!routes.isEmpty()) {
            for (a2.g gVar : routes) {
                String id2 = gVar.getId();
                arrayList.add(new i.b.C0003b.a(gVar).setSelectionState(arrayListA.contains(id2) ? 3 : 1).setIsGroupable(arrayListA2.contains(id2)).setIsUnselectable(arrayListA3.contains(id2)).setIsTransferable(true).build());
            }
        }
        cVar.f130o = gVarBuild;
        cVar.notifyDynamicRoutesChanged(gVarBuild, arrayList);
    }

    @Override // a2.i
    public i.b onCreateDynamicGroupRouteController(String str) {
        Iterator it = this.f113k.entrySet().iterator();
        while (it.hasNext()) {
            c cVar = (c) ((Map.Entry) it.next()).getValue();
            if (TextUtils.equals(str, cVar.f121f)) {
                return cVar;
            }
        }
        return null;
    }

    @Override // a2.i
    public i.e onCreateRouteController(String str) {
        return new d((String) this.f119q.get(str), null);
    }

    @Override // a2.i
    public void onDiscoveryRequestChanged(h hVar) {
        int i10 = n.f186c == null ? 0 : n.b().f70z;
        b bVar = this.f116n;
        g gVar = this.f115m;
        MediaRouter2.RouteCallback routeCallback = this.f114l;
        MediaRouter2 mediaRouter2 = this.f111i;
        if (i10 <= 0) {
            mediaRouter2.unregisterRouteCallback(routeCallback);
            mediaRouter2.unregisterTransferCallback(gVar);
            mediaRouter2.unregisterControllerCallback(bVar);
            return;
        }
        u uVar = n.b().f60p;
        boolean zIsTransferToLocalEnabled = uVar == null ? false : uVar.isTransferToLocalEnabled();
        if (hVar == null) {
            hVar = new h(m.f182c, false);
        }
        List<String> controlCategories = hVar.getSelector().getControlCategories();
        if (!zIsTransferToLocalEnabled) {
            controlCategories.remove("android.media.intent.category.LIVE_AUDIO");
        } else if (!controlCategories.contains("android.media.intent.category.LIVE_AUDIO")) {
            controlCategories.add("android.media.intent.category.LIVE_AUDIO");
        }
        RouteDiscoveryPreference routeDiscoveryPreferenceB = q.b(new h(new m.a().addControlCategories(controlCategories).build(), hVar.isActiveScan()));
        a2.e eVar = this.f117o;
        mediaRouter2.registerRouteCallback(eVar, routeCallback, routeDiscoveryPreferenceB);
        mediaRouter2.registerTransferCallback(eVar, gVar);
        mediaRouter2.registerControllerCallback(eVar, bVar);
    }

    public void refreshRoutes() {
        ArrayList arrayList = new ArrayList();
        ArraySet arraySet = new ArraySet();
        for (MediaRoute2Info mediaRoute2Info : this.f111i.getRoutes()) {
            if (mediaRoute2Info != null && !arraySet.contains(mediaRoute2Info) && !mediaRoute2Info.isSystemRoute()) {
                arraySet.add(mediaRoute2Info);
                arrayList.add(mediaRoute2Info);
            }
        }
        if (arrayList.equals(this.f118p)) {
            return;
        }
        this.f118p = arrayList;
        ArrayMap arrayMap = this.f119q;
        arrayMap.clear();
        Iterator it = this.f118p.iterator();
        while (it.hasNext()) {
            MediaRoute2Info mediaRoute2Info2 = (MediaRoute2Info) it.next();
            Bundle extras = mediaRoute2Info2.getExtras();
            if (extras == null || extras.getString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID") == null) {
                Log.w("MR2Provider", "Cannot find the original route Id. route=" + mediaRoute2Info2);
            } else {
                arrayMap.put(mediaRoute2Info2.getId(), extras.getString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID"));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = this.f118p.iterator();
        while (it2.hasNext()) {
            MediaRoute2Info mediaRoute2Info3 = (MediaRoute2Info) it2.next();
            a2.g mediaRouteDescriptor = q.toMediaRouteDescriptor(mediaRoute2Info3);
            if (mediaRoute2Info3 != null) {
                arrayList2.add(mediaRouteDescriptor);
            }
        }
        setDescriptor(new k.a().setSupportsDynamicGroupRoute(true).addRoutes(arrayList2).build());
    }

    public void transferTo(String str) {
        MediaRoute2Info mediaRoute2InfoA = a(str);
        if (mediaRoute2InfoA != null) {
            this.f111i.transferTo(mediaRoute2InfoA);
            return;
        }
        Log.w("MR2Provider", "transferTo: Specified route not found. routeId=" + str);
    }

    @Override // a2.i
    public i.e onCreateRouteController(String str, String str2) {
        String str3 = (String) this.f119q.get(str);
        for (c cVar : this.f113k.values()) {
            if (TextUtils.equals(str2, cVar.getGroupRouteId())) {
                return new d(str3, cVar);
            }
        }
        Log.w("MR2Provider", "Could not find the matching GroupRouteController. routeId=" + str + ", routeGroupId=" + str2);
        return new d(str3, null);
    }
}
