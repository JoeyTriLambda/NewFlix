package a2;

import a2.i;
import a2.n;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: RegisteredMediaRouteProvider.java */
/* loaded from: classes.dex */
public final class w extends i implements ServiceConnection {

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f250q = 0;

    /* renamed from: i, reason: collision with root package name */
    public final ComponentName f251i;

    /* renamed from: j, reason: collision with root package name */
    public final d f252j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList<c> f253k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f254l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f255m;

    /* renamed from: n, reason: collision with root package name */
    public a f256n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f257o;

    /* renamed from: p, reason: collision with root package name */
    public b f258p;

    /* compiled from: RegisteredMediaRouteProvider.java */
    public final class a implements IBinder.DeathRecipient {

        /* renamed from: a, reason: collision with root package name */
        public final Messenger f259a;

        /* renamed from: b, reason: collision with root package name */
        public final e f260b;

        /* renamed from: c, reason: collision with root package name */
        public final Messenger f261c;

        /* renamed from: f, reason: collision with root package name */
        public int f264f;

        /* renamed from: g, reason: collision with root package name */
        public int f265g;

        /* renamed from: d, reason: collision with root package name */
        public int f262d = 1;

        /* renamed from: e, reason: collision with root package name */
        public int f263e = 1;

        /* renamed from: h, reason: collision with root package name */
        public final SparseArray<n.c> f266h = new SparseArray<>();

        /* compiled from: RegisteredMediaRouteProvider.java */
        /* renamed from: a2.w$a$a, reason: collision with other inner class name */
        public class RunnableC0004a implements Runnable {
            public RunnableC0004a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SparseArray<n.c> sparseArray = a.this.f266h;
                int size = sparseArray.size();
                for (int i10 = 0; i10 < size; i10++) {
                    sparseArray.valueAt(i10).onError(null, null);
                }
                sparseArray.clear();
            }
        }

        /* compiled from: RegisteredMediaRouteProvider.java */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() throws RemoteException {
                a aVar = a.this;
                w wVar = w.this;
                if (wVar.f256n == aVar) {
                    wVar.c();
                }
            }
        }

        public a(Messenger messenger) {
            this.f259a = messenger;
            e eVar = new e(this);
            this.f260b = eVar;
            this.f261c = new Messenger(eVar);
        }

        public final boolean a(int i10, int i11, int i12, Bundle bundle, Bundle bundle2) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i10;
            messageObtain.arg1 = i11;
            messageObtain.arg2 = i12;
            messageObtain.obj = bundle;
            messageObtain.setData(bundle2);
            messageObtain.replyTo = this.f261c;
            try {
                this.f259a.send(messageObtain);
                return true;
            } catch (DeadObjectException unused) {
                return false;
            } catch (RemoteException e10) {
                if (i10 == 2) {
                    return false;
                }
                Log.e("MediaRouteProviderProxy", "Could not send message to service.", e10);
                return false;
            }
        }

        public void addMemberRoute(int i10, String str) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("memberRouteId", str);
            int i11 = this.f262d;
            this.f262d = i11 + 1;
            a(12, i11, i10, null, bundle);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            w.this.f252j.post(new b());
        }

        public int createDynamicGroupRouteController(String str, n.c cVar) throws RemoteException {
            int i10 = this.f263e;
            this.f263e = i10 + 1;
            int i11 = this.f262d;
            this.f262d = i11 + 1;
            Bundle bundle = new Bundle();
            bundle.putString("memberRouteId", str);
            a(11, i11, i10, null, bundle);
            this.f266h.put(i11, cVar);
            return i10;
        }

        public int createRouteController(String str, String str2) throws RemoteException {
            int i10 = this.f263e;
            this.f263e = i10 + 1;
            Bundle bundle = new Bundle();
            bundle.putString("routeId", str);
            bundle.putString("routeGroupId", str2);
            int i11 = this.f262d;
            this.f262d = i11 + 1;
            a(3, i11, i10, null, bundle);
            return i10;
        }

        public void dispose() throws RemoteException {
            a(2, 0, 0, null, null);
            this.f260b.dispose();
            this.f259a.getBinder().unlinkToDeath(this, 0);
            w.this.f252j.post(new RunnableC0004a());
        }

        public boolean onControlRequestFailed(int i10, String str, Bundle bundle) {
            SparseArray<n.c> sparseArray = this.f266h;
            n.c cVar = sparseArray.get(i10);
            if (cVar == null) {
                return false;
            }
            sparseArray.remove(i10);
            cVar.onError(str, bundle);
            return true;
        }

        public boolean onControlRequestSucceeded(int i10, Bundle bundle) {
            SparseArray<n.c> sparseArray = this.f266h;
            n.c cVar = sparseArray.get(i10);
            if (cVar == null) {
                return false;
            }
            sparseArray.remove(i10);
            cVar.onResult(bundle);
            return true;
        }

        public void onControllerReleasedByProvider(int i10) throws RemoteException {
            c next;
            w wVar = w.this;
            if (wVar.f256n == this) {
                ArrayList<c> arrayList = wVar.f253k;
                Iterator<c> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (next.getControllerId() == i10) {
                            break;
                        }
                    }
                }
                b bVar = wVar.f258p;
                if (bVar != null && (next instanceof i.e)) {
                    ((x) bVar).a((i.e) next);
                }
                arrayList.remove(next);
                next.detachConnection();
                wVar.e();
            }
        }

        public boolean onDescriptorChanged(Bundle bundle) {
            if (this.f264f == 0) {
                return false;
            }
            k kVarFromBundle = k.fromBundle(bundle);
            w wVar = w.this;
            if (wVar.f256n != this) {
                return true;
            }
            wVar.setDescriptor(kVarFromBundle);
            return true;
        }

        public void onDynamicGroupRouteControllerCreated(int i10, Bundle bundle) {
            SparseArray<n.c> sparseArray = this.f266h;
            n.c cVar = sparseArray.get(i10);
            if (bundle == null || !bundle.containsKey("routeId")) {
                cVar.onError("DynamicGroupRouteController is created without valid route id.", bundle);
            } else {
                sparseArray.remove(i10);
                cVar.onResult(bundle);
            }
        }

        public boolean onDynamicRouteDescriptorsChanged(int i10, Bundle bundle) {
            if (this.f264f == 0) {
                return false;
            }
            Bundle bundle2 = (Bundle) bundle.getParcelable("groupRoute");
            c cVar = null;
            a2.g gVarFromBundle = bundle2 != null ? a2.g.fromBundle(bundle2) : null;
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("dynamicRoutes");
            ArrayList arrayList = new ArrayList();
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                Bundle bundle3 = (Bundle) it.next();
                arrayList.add(bundle3 == null ? null : new i.b.C0003b(a2.g.fromBundle(bundle3.getBundle("mrDescriptor")), bundle3.getInt("selectionState", 1), bundle3.getBoolean("isUnselectable", false), bundle3.getBoolean("isGroupable", false), bundle3.getBoolean("isTransferable", false)));
            }
            w wVar = w.this;
            if (wVar.f256n == this) {
                Iterator<c> it2 = wVar.f253k.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    c next = it2.next();
                    if (next.getControllerId() == i10) {
                        cVar = next;
                        break;
                    }
                }
                if (cVar instanceof f) {
                    ((f) cVar).notifyDynamicRoutesChanged(gVarFromBundle, arrayList);
                }
            }
            return true;
        }

        public void onGenericFailure(int i10) throws RemoteException {
            if (i10 == this.f265g) {
                this.f265g = 0;
                w wVar = w.this;
                if (wVar.f256n == this) {
                    wVar.d();
                }
            }
            SparseArray<n.c> sparseArray = this.f266h;
            n.c cVar = sparseArray.get(i10);
            if (cVar != null) {
                sparseArray.remove(i10);
                cVar.onError(null, null);
            }
        }

        public boolean onRegistered(int i10, int i11, Bundle bundle) throws RemoteException {
            if (this.f264f != 0 || i10 != this.f265g || i11 < 1) {
                return false;
            }
            this.f265g = 0;
            this.f264f = i11;
            k kVarFromBundle = k.fromBundle(bundle);
            w wVar = w.this;
            if (wVar.f256n == this) {
                wVar.setDescriptor(kVarFromBundle);
            }
            if (wVar.f256n == this) {
                wVar.f257o = true;
                ArrayList<c> arrayList = wVar.f253k;
                int size = arrayList.size();
                for (int i12 = 0; i12 < size; i12++) {
                    arrayList.get(i12).attachConnection(wVar.f256n);
                }
                h discoveryRequest = wVar.getDiscoveryRequest();
                if (discoveryRequest != null) {
                    wVar.f256n.setDiscoveryRequest(discoveryRequest);
                }
            }
            return true;
        }

        public boolean register() throws RemoteException {
            int i10 = this.f262d;
            this.f262d = i10 + 1;
            this.f265g = i10;
            if (!a(1, i10, 4, null, null)) {
                return false;
            }
            try {
                this.f259a.getBinder().linkToDeath(this, 0);
                return true;
            } catch (RemoteException unused) {
                binderDied();
                return false;
            }
        }

        public void releaseRouteController(int i10) throws RemoteException {
            int i11 = this.f262d;
            this.f262d = i11 + 1;
            a(4, i11, i10, null, null);
        }

        public void removeMemberRoute(int i10, String str) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("memberRouteId", str);
            int i11 = this.f262d;
            this.f262d = i11 + 1;
            a(13, i11, i10, null, bundle);
        }

        public void selectRoute(int i10) throws RemoteException {
            int i11 = this.f262d;
            this.f262d = i11 + 1;
            a(5, i11, i10, null, null);
        }

        public void setDiscoveryRequest(h hVar) throws RemoteException {
            int i10 = this.f262d;
            this.f262d = i10 + 1;
            a(10, i10, 0, hVar != null ? hVar.asBundle() : null, null);
        }

        public void setVolume(int i10, int i11) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putInt("volume", i11);
            int i12 = this.f262d;
            this.f262d = i12 + 1;
            a(7, i12, i10, null, bundle);
        }

        public void unselectRoute(int i10, int i11) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putInt("unselectReason", i11);
            int i12 = this.f262d;
            this.f262d = i12 + 1;
            a(6, i12, i10, null, bundle);
        }

        public void updateMemberRoutes(int i10, List<String> list) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("memberRouteIds", new ArrayList<>(list));
            int i11 = this.f262d;
            this.f262d = i11 + 1;
            a(14, i11, i10, null, bundle);
        }

        public void updateVolume(int i10, int i11) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putInt("volume", i11);
            int i12 = this.f262d;
            this.f262d = i12 + 1;
            a(8, i12, i10, null, bundle);
        }
    }

    /* compiled from: RegisteredMediaRouteProvider.java */
    public interface b {
    }

    /* compiled from: RegisteredMediaRouteProvider.java */
    public interface c {
        void attachConnection(a aVar);

        void detachConnection();

        int getControllerId();
    }

    /* compiled from: RegisteredMediaRouteProvider.java */
    public static final class d extends Handler {
    }

    /* compiled from: RegisteredMediaRouteProvider.java */
    public static final class e extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<a> f270a;

        public e(a aVar) {
            this.f270a = new WeakReference<>(aVar);
        }

        public void dispose() {
            this.f270a.clear();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0082  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r7) throws android.os.RemoteException {
            /*
                r6 = this;
                java.lang.ref.WeakReference<a2.w$a> r0 = r6.f270a
                java.lang.Object r0 = r0.get()
                a2.w$a r0 = (a2.w.a) r0
                if (r0 == 0) goto L87
                int r1 = r7.what
                int r2 = r7.arg1
                int r3 = r7.arg2
                java.lang.Object r4 = r7.obj
                android.os.Bundle r7 = r7.peekData()
                r5 = 1
                switch(r1) {
                    case 0: goto L7e;
                    case 1: goto L83;
                    case 2: goto L71;
                    case 3: goto L64;
                    case 4: goto L4d;
                    case 5: goto L40;
                    case 6: goto L2e;
                    case 7: goto L21;
                    case 8: goto L1c;
                    default: goto L1a;
                }
            L1a:
                goto L82
            L1c:
                r0.onControllerReleasedByProvider(r3)
                goto L82
            L21:
                if (r4 == 0) goto L27
                boolean r7 = r4 instanceof android.os.Bundle
                if (r7 == 0) goto L82
            L27:
                android.os.Bundle r4 = (android.os.Bundle) r4
                boolean r5 = r0.onDynamicRouteDescriptorsChanged(r3, r4)
                goto L83
            L2e:
                boolean r7 = r4 instanceof android.os.Bundle
                if (r7 == 0) goto L38
                android.os.Bundle r4 = (android.os.Bundle) r4
                r0.onDynamicGroupRouteControllerCreated(r2, r4)
                goto L82
            L38:
                java.lang.String r7 = "MediaRouteProviderProxy"
                java.lang.String r0 = "No further information on the dynamic group controller"
                android.util.Log.w(r7, r0)
                goto L82
            L40:
                if (r4 == 0) goto L46
                boolean r7 = r4 instanceof android.os.Bundle
                if (r7 == 0) goto L82
            L46:
                android.os.Bundle r4 = (android.os.Bundle) r4
                boolean r5 = r0.onDescriptorChanged(r4)
                goto L83
            L4d:
                if (r4 == 0) goto L53
                boolean r1 = r4 instanceof android.os.Bundle
                if (r1 == 0) goto L82
            L53:
                if (r7 != 0) goto L57
                r7 = 0
                goto L5d
            L57:
                java.lang.String r1 = "error"
                java.lang.String r7 = r7.getString(r1)
            L5d:
                android.os.Bundle r4 = (android.os.Bundle) r4
                boolean r5 = r0.onControlRequestFailed(r2, r7, r4)
                goto L83
            L64:
                if (r4 == 0) goto L6a
                boolean r7 = r4 instanceof android.os.Bundle
                if (r7 == 0) goto L82
            L6a:
                android.os.Bundle r4 = (android.os.Bundle) r4
                boolean r5 = r0.onControlRequestSucceeded(r2, r4)
                goto L83
            L71:
                if (r4 == 0) goto L77
                boolean r7 = r4 instanceof android.os.Bundle
                if (r7 == 0) goto L82
            L77:
                android.os.Bundle r4 = (android.os.Bundle) r4
                boolean r5 = r0.onRegistered(r2, r3, r4)
                goto L83
            L7e:
                r0.onGenericFailure(r2)
                goto L83
            L82:
                r5 = 0
            L83:
                if (r5 != 0) goto L87
                int r7 = a2.w.f250q
            L87:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.w.e.handleMessage(android.os.Message):void");
        }
    }

    /* compiled from: RegisteredMediaRouteProvider.java */
    public final class f extends i.b implements c {

        /* renamed from: f, reason: collision with root package name */
        public final String f271f;

        /* renamed from: g, reason: collision with root package name */
        public String f272g;

        /* renamed from: h, reason: collision with root package name */
        public String f273h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f274i;

        /* renamed from: k, reason: collision with root package name */
        public int f276k;

        /* renamed from: l, reason: collision with root package name */
        public a f277l;

        /* renamed from: j, reason: collision with root package name */
        public int f275j = -1;

        /* renamed from: m, reason: collision with root package name */
        public int f278m = -1;

        /* compiled from: RegisteredMediaRouteProvider.java */
        public class a extends n.c {
            public a() {
            }

            @Override // a2.n.c
            public void onError(String str, Bundle bundle) {
                Log.d("MediaRouteProviderProxy", "Error: " + str + ", data: " + bundle);
            }

            @Override // a2.n.c
            public void onResult(Bundle bundle) {
                String string = bundle.getString("groupableTitle");
                f fVar = f.this;
                fVar.f272g = string;
                fVar.f273h = bundle.getString("transferableTitle");
            }
        }

        public f(String str) {
            this.f271f = str;
        }

        @Override // a2.w.c
        public void attachConnection(a aVar) throws RemoteException {
            a aVar2 = new a();
            this.f277l = aVar;
            int iCreateDynamicGroupRouteController = aVar.createDynamicGroupRouteController(this.f271f, aVar2);
            this.f278m = iCreateDynamicGroupRouteController;
            if (this.f274i) {
                aVar.selectRoute(iCreateDynamicGroupRouteController);
                int i10 = this.f275j;
                if (i10 >= 0) {
                    aVar.setVolume(this.f278m, i10);
                    this.f275j = -1;
                }
                int i11 = this.f276k;
                if (i11 != 0) {
                    aVar.updateVolume(this.f278m, i11);
                    this.f276k = 0;
                }
            }
        }

        @Override // a2.w.c
        public void detachConnection() throws RemoteException {
            a aVar = this.f277l;
            if (aVar != null) {
                aVar.releaseRouteController(this.f278m);
                this.f277l = null;
                this.f278m = 0;
            }
        }

        @Override // a2.w.c
        public int getControllerId() {
            return this.f278m;
        }

        @Override // a2.i.b
        public String getGroupableSelectionTitle() {
            return this.f272g;
        }

        @Override // a2.i.b
        public String getTransferableSectionTitle() {
            return this.f273h;
        }

        @Override // a2.i.b
        public void onAddMemberRoute(String str) throws RemoteException {
            a aVar = this.f277l;
            if (aVar != null) {
                aVar.addMemberRoute(this.f278m, str);
            }
        }

        @Override // a2.i.e
        public void onRelease() throws RemoteException {
            w wVar = w.this;
            wVar.f253k.remove(this);
            detachConnection();
            wVar.e();
        }

        @Override // a2.i.b
        public void onRemoveMemberRoute(String str) throws RemoteException {
            a aVar = this.f277l;
            if (aVar != null) {
                aVar.removeMemberRoute(this.f278m, str);
            }
        }

        @Override // a2.i.e
        public void onSelect() throws RemoteException {
            this.f274i = true;
            a aVar = this.f277l;
            if (aVar != null) {
                aVar.selectRoute(this.f278m);
            }
        }

        @Override // a2.i.e
        public void onSetVolume(int i10) throws RemoteException {
            a aVar = this.f277l;
            if (aVar != null) {
                aVar.setVolume(this.f278m, i10);
            } else {
                this.f275j = i10;
                this.f276k = 0;
            }
        }

        @Override // a2.i.e
        public void onUnselect() throws RemoteException {
            onUnselect(0);
        }

        @Override // a2.i.b
        public void onUpdateMemberRoutes(List<String> list) throws RemoteException {
            a aVar = this.f277l;
            if (aVar != null) {
                aVar.updateMemberRoutes(this.f278m, list);
            }
        }

        @Override // a2.i.e
        public void onUpdateVolume(int i10) throws RemoteException {
            a aVar = this.f277l;
            if (aVar != null) {
                aVar.updateVolume(this.f278m, i10);
            } else {
                this.f276k += i10;
            }
        }

        @Override // a2.i.e
        public void onUnselect(int i10) throws RemoteException {
            this.f274i = false;
            a aVar = this.f277l;
            if (aVar != null) {
                aVar.unselectRoute(this.f278m, i10);
            }
        }
    }

    /* compiled from: RegisteredMediaRouteProvider.java */
    public final class g extends i.e implements c {

        /* renamed from: a, reason: collision with root package name */
        public final String f281a;

        /* renamed from: b, reason: collision with root package name */
        public final String f282b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f283c;

        /* renamed from: d, reason: collision with root package name */
        public int f284d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f285e;

        /* renamed from: f, reason: collision with root package name */
        public a f286f;

        /* renamed from: g, reason: collision with root package name */
        public int f287g;

        public g(String str, String str2) {
            this.f281a = str;
            this.f282b = str2;
        }

        @Override // a2.w.c
        public void attachConnection(a aVar) throws RemoteException {
            this.f286f = aVar;
            int iCreateRouteController = aVar.createRouteController(this.f281a, this.f282b);
            this.f287g = iCreateRouteController;
            if (this.f283c) {
                aVar.selectRoute(iCreateRouteController);
                int i10 = this.f284d;
                if (i10 >= 0) {
                    aVar.setVolume(this.f287g, i10);
                    this.f284d = -1;
                }
                int i11 = this.f285e;
                if (i11 != 0) {
                    aVar.updateVolume(this.f287g, i11);
                    this.f285e = 0;
                }
            }
        }

        @Override // a2.w.c
        public void detachConnection() throws RemoteException {
            a aVar = this.f286f;
            if (aVar != null) {
                aVar.releaseRouteController(this.f287g);
                this.f286f = null;
                this.f287g = 0;
            }
        }

        @Override // a2.w.c
        public int getControllerId() {
            return this.f287g;
        }

        @Override // a2.i.e
        public void onRelease() throws RemoteException {
            w wVar = w.this;
            wVar.f253k.remove(this);
            detachConnection();
            wVar.e();
        }

        @Override // a2.i.e
        public void onSelect() throws RemoteException {
            this.f283c = true;
            a aVar = this.f286f;
            if (aVar != null) {
                aVar.selectRoute(this.f287g);
            }
        }

        @Override // a2.i.e
        public void onSetVolume(int i10) throws RemoteException {
            a aVar = this.f286f;
            if (aVar != null) {
                aVar.setVolume(this.f287g, i10);
            } else {
                this.f284d = i10;
                this.f285e = 0;
            }
        }

        @Override // a2.i.e
        public void onUnselect() throws RemoteException {
            onUnselect(0);
        }

        @Override // a2.i.e
        public void onUpdateVolume(int i10) throws RemoteException {
            a aVar = this.f286f;
            if (aVar != null) {
                aVar.updateVolume(this.f287g, i10);
            } else {
                this.f285e += i10;
            }
        }

        @Override // a2.i.e
        public void onUnselect(int i10) throws RemoteException {
            this.f283c = false;
            a aVar = this.f286f;
            if (aVar != null) {
                aVar.unselectRoute(this.f287g, i10);
            }
        }
    }

    static {
        Log.isLoggable("MediaRouteProviderProxy", 3);
    }

    public w(Context context, ComponentName componentName) {
        super(context, new i.d(componentName));
        this.f253k = new ArrayList<>();
        this.f251i = componentName;
        this.f252j = new d();
    }

    public final void a() {
        if (this.f255m) {
            return;
        }
        Intent intent = new Intent("android.media.MediaRouteProviderService");
        intent.setComponent(this.f251i);
        try {
            this.f255m = getContext().bindService(intent, this, Build.VERSION.SDK_INT >= 29 ? 4097 : 1);
        } catch (SecurityException unused) {
        }
    }

    public final g b(String str, String str2) throws RemoteException {
        k descriptor = getDescriptor();
        if (descriptor == null) {
            return null;
        }
        List<a2.g> routes = descriptor.getRoutes();
        int size = routes.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (routes.get(i10).getId().equals(str)) {
                g gVar = new g(str, str2);
                this.f253k.add(gVar);
                if (this.f257o) {
                    gVar.attachConnection(this.f256n);
                }
                e();
                return gVar;
            }
        }
        return null;
    }

    public final void c() throws RemoteException {
        if (this.f256n != null) {
            setDescriptor(null);
            this.f257o = false;
            ArrayList<c> arrayList = this.f253k;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                arrayList.get(i10).detachConnection();
            }
            this.f256n.dispose();
            this.f256n = null;
        }
    }

    public final void d() throws RemoteException {
        if (this.f255m) {
            this.f255m = false;
            c();
            try {
                getContext().unbindService(this);
            } catch (IllegalArgumentException e10) {
                Log.e("MediaRouteProviderProxy", this + ": unbindService failed", e10);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e() throws android.os.RemoteException {
        /*
            r2 = this;
            boolean r0 = r2.f254l
            if (r0 == 0) goto L15
            a2.h r0 = r2.getDiscoveryRequest()
            r1 = 1
            if (r0 == 0) goto Lc
            goto L16
        Lc:
            java.util.ArrayList<a2.w$c> r0 = r2.f253k
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L15
            goto L16
        L15:
            r1 = 0
        L16:
            if (r1 == 0) goto L1c
            r2.a()
            goto L1f
        L1c:
            r2.d()
        L1f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.w.e():void");
    }

    public boolean hasComponentName(String str, String str2) {
        ComponentName componentName = this.f251i;
        return componentName.getPackageName().equals(str) && componentName.getClassName().equals(str2);
    }

    @Override // a2.i
    public i.b onCreateDynamicGroupRouteController(String str) throws RemoteException {
        if (str == null) {
            throw new IllegalArgumentException("initialMemberRouteId cannot be null.");
        }
        k descriptor = getDescriptor();
        if (descriptor != null) {
            List<a2.g> routes = descriptor.getRoutes();
            int size = routes.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (routes.get(i10).getId().equals(str)) {
                    f fVar = new f(str);
                    this.f253k.add(fVar);
                    if (this.f257o) {
                        fVar.attachConnection(this.f256n);
                    }
                    e();
                    return fVar;
                }
            }
        }
        return null;
    }

    @Override // a2.i
    public i.e onCreateRouteController(String str) {
        if (str != null) {
            return b(str, null);
        }
        throw new IllegalArgumentException("routeId cannot be null");
    }

    @Override // a2.i
    public void onDiscoveryRequestChanged(h hVar) throws RemoteException {
        if (this.f257o) {
            this.f256n.setDiscoveryRequest(hVar);
        }
        e();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws RemoteException {
        if (this.f255m) {
            c();
            Messenger messenger = iBinder != null ? new Messenger(iBinder) : null;
            if (l.isValidRemoteMessenger(messenger)) {
                a aVar = new a(messenger);
                if (aVar.register()) {
                    this.f256n = aVar;
                    return;
                }
                return;
            }
            Log.e("MediaRouteProviderProxy", this + ": Service returned invalid messenger binder");
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) throws RemoteException {
        c();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void rebindIfDisconnected() {
        /*
            r2 = this;
            a2.w$a r0 = r2.f256n
            if (r0 != 0) goto L22
            boolean r0 = r2.f254l
            if (r0 == 0) goto L19
            a2.h r0 = r2.getDiscoveryRequest()
            r1 = 1
            if (r0 == 0) goto L10
            goto L1a
        L10:
            java.util.ArrayList<a2.w$c> r0 = r2.f253k
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L19
            goto L1a
        L19:
            r1 = 0
        L1a:
            if (r1 == 0) goto L22
            r2.d()
            r2.a()
        L22:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.w.rebindIfDisconnected():void");
    }

    public void setControllerCallback(b bVar) {
        this.f258p = bVar;
    }

    public void start() {
        if (this.f254l) {
            return;
        }
        this.f254l = true;
        e();
    }

    public void stop() {
        if (this.f254l) {
            this.f254l = false;
            e();
        }
    }

    public String toString() {
        return "Service connection " + this.f251i.flattenToShortString();
    }

    @Override // a2.i
    public i.e onCreateRouteController(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        }
        if (str2 != null) {
            return b(str, str2);
        }
        throw new IllegalArgumentException("routeGroupId cannot be null");
    }
}
