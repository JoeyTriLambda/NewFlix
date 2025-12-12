package a2;

import a2.g;
import a2.i;
import a2.k;
import a2.n;
import a2.s;
import a2.t;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.media.MediaRouter;
import android.os.Build;
import android.view.Display;
import androidx.mediarouter.R;
import com.unity3d.services.core.request.metrics.MetricCommonTags;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: SystemMediaRouteProvider.java */
/* loaded from: classes.dex */
public abstract class c0 extends i {

    /* compiled from: SystemMediaRouteProvider.java */
    public static class a extends d {
        public a(Context context, e eVar) {
            super(context, eVar);
        }

        @Override // a2.c0.d, a2.c0.c, a2.c0.b
        @SuppressLint({"WrongConstant"})
        public void onBuildSystemRouteDescriptor(b.C0001b c0001b, g.a aVar) {
            super.onBuildSystemRouteDescriptor(c0001b, aVar);
            aVar.setDeviceType(c0001b.f103a.getDeviceType());
        }
    }

    /* compiled from: SystemMediaRouteProvider.java */
    public static class c extends b implements t.a {
        public c(Context context, e eVar) {
            super(context, eVar);
        }

        @Override // a2.c0.b
        public MediaRouter.Callback createCallback() {
            return t.createCallback(this);
        }

        public boolean isConnecting(b.C0001b c0001b) {
            throw null;
        }

        @Override // a2.c0.b
        public void onBuildSystemRouteDescriptor(b.C0001b c0001b, g.a aVar) {
            super.onBuildSystemRouteDescriptor(c0001b, aVar);
            if (!t.c.isEnabled(c0001b.f103a)) {
                aVar.setEnabled(false);
            }
            if (isConnecting(c0001b)) {
                aVar.setConnectionState(1);
            }
            Display presentationDisplay = t.c.getPresentationDisplay(c0001b.f103a);
            if (presentationDisplay != null) {
                aVar.setPresentationDisplayId(presentationDisplay.getDisplayId());
            }
        }

        @Override // a2.t.a
        public void onRoutePresentationDisplayChanged(MediaRouter.RouteInfo routeInfo) {
            int iFindSystemRouteRecord = findSystemRouteRecord(routeInfo);
            if (iFindSystemRouteRecord >= 0) {
                b.C0001b c0001b = this.f100q.get(iFindSystemRouteRecord);
                Display presentationDisplay = t.c.getPresentationDisplay(routeInfo);
                int displayId = presentationDisplay != null ? presentationDisplay.getDisplayId() : -1;
                if (displayId != c0001b.f105c.getPresentationDisplayId()) {
                    c0001b.f105c = new g.a(c0001b.f105c).setPresentationDisplayId(displayId).build();
                    publishRoutes();
                }
            }
        }
    }

    /* compiled from: SystemMediaRouteProvider.java */
    public static class d extends c {
        public d(Context context, e eVar) {
            super(context, eVar);
        }

        @Override // a2.c0.c
        public boolean isConnecting(b.C0001b c0001b) {
            return c0001b.f103a.isConnecting();
        }

        @Override // a2.c0.c, a2.c0.b
        public void onBuildSystemRouteDescriptor(b.C0001b c0001b, g.a aVar) {
            super.onBuildSystemRouteDescriptor(c0001b, aVar);
            CharSequence description = c0001b.f103a.getDescription();
            if (description != null) {
                aVar.setDescription(description.toString());
            }
        }

        @Override // a2.c0.b
        public void selectRoute(MediaRouter.RouteInfo routeInfo) {
            s.selectRoute(this.f93j, 8388611, routeInfo);
        }

        @Override // a2.c0.b
        public void updateCallback() {
            boolean z10 = this.f99p;
            MediaRouter.Callback callback = this.f94k;
            MediaRouter mediaRouter = this.f93j;
            if (z10) {
                s.removeCallback(mediaRouter, callback);
            }
            this.f99p = true;
            mediaRouter.addCallback(this.f97n, callback, (this.f98o ? 1 : 0) | 2);
        }

        @Override // a2.c0.b
        public void updateUserRouteProperties(b.c cVar) {
            super.updateUserRouteProperties(cVar);
            cVar.f107b.setDescription(cVar.f106a.getDescription());
        }

        @Override // a2.c0.b
        public MediaRouter.RouteInfo getDefaultRoute() {
            return this.f93j.getDefaultRoute();
        }
    }

    /* compiled from: SystemMediaRouteProvider.java */
    public interface e {
    }

    public c0(Context context) {
        super(context, new i.d(new ComponentName(MetricCommonTags.METRIC_COMMON_TAG_PLATFORM_ANDROID, c0.class.getName())));
    }

    public static c0 obtain(Context context, e eVar) {
        return Build.VERSION.SDK_INT >= 24 ? new a(context, eVar) : new d(context, eVar);
    }

    public void onSyncRouteAdded(n.g gVar) {
    }

    public void onSyncRouteChanged(n.g gVar) {
    }

    public void onSyncRouteRemoved(n.g gVar) {
    }

    public void onSyncRouteSelected(n.g gVar) {
    }

    /* compiled from: SystemMediaRouteProvider.java */
    public static class b extends c0 implements s.a, s.e {

        /* renamed from: s, reason: collision with root package name */
        public static final ArrayList<IntentFilter> f90s;

        /* renamed from: t, reason: collision with root package name */
        public static final ArrayList<IntentFilter> f91t;

        /* renamed from: i, reason: collision with root package name */
        public final e f92i;

        /* renamed from: j, reason: collision with root package name */
        public final MediaRouter f93j;

        /* renamed from: k, reason: collision with root package name */
        public final MediaRouter.Callback f94k;

        /* renamed from: l, reason: collision with root package name */
        public final MediaRouter.VolumeCallback f95l;

        /* renamed from: m, reason: collision with root package name */
        public final MediaRouter.RouteCategory f96m;

        /* renamed from: n, reason: collision with root package name */
        public int f97n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f98o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f99p;

        /* renamed from: q, reason: collision with root package name */
        public final ArrayList<C0001b> f100q;

        /* renamed from: r, reason: collision with root package name */
        public final ArrayList<c> f101r;

        /* compiled from: SystemMediaRouteProvider.java */
        public static final class a extends i.e {

            /* renamed from: a, reason: collision with root package name */
            public final MediaRouter.RouteInfo f102a;

            public a(MediaRouter.RouteInfo routeInfo) {
                this.f102a = routeInfo;
            }

            @Override // a2.i.e
            public void onSetVolume(int i10) {
                s.c.requestSetVolume(this.f102a, i10);
            }

            @Override // a2.i.e
            public void onUpdateVolume(int i10) {
                s.c.requestUpdateVolume(this.f102a, i10);
            }
        }

        /* compiled from: SystemMediaRouteProvider.java */
        /* renamed from: a2.c0$b$b, reason: collision with other inner class name */
        public static final class C0001b {

            /* renamed from: a, reason: collision with root package name */
            public final MediaRouter.RouteInfo f103a;

            /* renamed from: b, reason: collision with root package name */
            public final String f104b;

            /* renamed from: c, reason: collision with root package name */
            public g f105c;

            public C0001b(MediaRouter.RouteInfo routeInfo, String str) {
                this.f103a = routeInfo;
                this.f104b = str;
            }
        }

        /* compiled from: SystemMediaRouteProvider.java */
        public static final class c {

            /* renamed from: a, reason: collision with root package name */
            public final n.g f106a;

            /* renamed from: b, reason: collision with root package name */
            public final MediaRouter.UserRouteInfo f107b;

            public c(n.g gVar, MediaRouter.UserRouteInfo userRouteInfo) {
                this.f106a = gVar;
                this.f107b = userRouteInfo;
            }
        }

        static {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addCategory("android.media.intent.category.LIVE_AUDIO");
            ArrayList<IntentFilter> arrayList = new ArrayList<>();
            f90s = arrayList;
            arrayList.add(intentFilter);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addCategory("android.media.intent.category.LIVE_VIDEO");
            ArrayList<IntentFilter> arrayList2 = new ArrayList<>();
            f91t = arrayList2;
            arrayList2.add(intentFilter2);
        }

        public b(Context context, e eVar) {
            super(context);
            this.f100q = new ArrayList<>();
            this.f101r = new ArrayList<>();
            this.f92i = eVar;
            MediaRouter mediaRouter = s.getMediaRouter(context);
            this.f93j = mediaRouter;
            this.f94k = createCallback();
            this.f95l = createVolumeCallback();
            this.f96m = s.createRouteCategory(mediaRouter, context.getResources().getString(R.string.mr_user_route_category_name), false);
            b();
        }

        public final boolean a(MediaRouter.RouteInfo routeInfo) {
            String str;
            if (getUserRouteRecord(routeInfo) != null || findSystemRouteRecord(routeInfo) >= 0) {
                return false;
            }
            String str2 = getDefaultRoute() == routeInfo ? "DEFAULT_ROUTE" : String.format(Locale.US, "ROUTE_%08x", Integer.valueOf(getRouteName(routeInfo).hashCode()));
            if (findSystemRouteRecordByDescriptorId(str2) >= 0) {
                int i10 = 2;
                while (true) {
                    str = String.format(Locale.US, "%s_%d", str2, Integer.valueOf(i10));
                    if (findSystemRouteRecordByDescriptorId(str) < 0) {
                        break;
                    }
                    i10++;
                }
                str2 = str;
            }
            C0001b c0001b = new C0001b(routeInfo, str2);
            updateSystemRouteDescriptor(c0001b);
            this.f100q.add(c0001b);
            return true;
        }

        public final void b() {
            updateCallback();
            Iterator<MediaRouter.RouteInfo> it = s.getRoutes(this.f93j).iterator();
            boolean zA = false;
            while (it.hasNext()) {
                zA |= a(it.next());
            }
            if (zA) {
                publishRoutes();
            }
        }

        public MediaRouter.Callback createCallback() {
            throw null;
        }

        public MediaRouter.VolumeCallback createVolumeCallback() {
            return s.createVolumeCallback(this);
        }

        public int findSystemRouteRecord(MediaRouter.RouteInfo routeInfo) {
            ArrayList<C0001b> arrayList = this.f100q;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (arrayList.get(i10).f103a == routeInfo) {
                    return i10;
                }
            }
            return -1;
        }

        public int findSystemRouteRecordByDescriptorId(String str) {
            ArrayList<C0001b> arrayList = this.f100q;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (arrayList.get(i10).f104b.equals(str)) {
                    return i10;
                }
            }
            return -1;
        }

        public int findUserRouteRecord(n.g gVar) {
            ArrayList<c> arrayList = this.f101r;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (arrayList.get(i10).f106a == gVar) {
                    return i10;
                }
            }
            return -1;
        }

        public Object getDefaultRoute() {
            throw null;
        }

        public String getRouteName(MediaRouter.RouteInfo routeInfo) {
            CharSequence name = s.c.getName(routeInfo, getContext());
            return name != null ? name.toString() : "";
        }

        public c getUserRouteRecord(MediaRouter.RouteInfo routeInfo) {
            Object tag = s.c.getTag(routeInfo);
            if (tag instanceof c) {
                return (c) tag;
            }
            return null;
        }

        public void onBuildSystemRouteDescriptor(C0001b c0001b, g.a aVar) {
            int supportedTypes = s.c.getSupportedTypes(c0001b.f103a);
            if ((supportedTypes & 1) != 0) {
                aVar.addControlFilters(f90s);
            }
            if ((supportedTypes & 2) != 0) {
                aVar.addControlFilters(f91t);
            }
            MediaRouter.RouteInfo routeInfo = c0001b.f103a;
            aVar.setPlaybackType(s.c.getPlaybackType(routeInfo));
            aVar.setPlaybackStream(s.c.getPlaybackStream(routeInfo));
            aVar.setVolume(s.c.getVolume(routeInfo));
            aVar.setVolumeMax(s.c.getVolumeMax(routeInfo));
            aVar.setVolumeHandling(s.c.getVolumeHandling(routeInfo));
        }

        @Override // a2.i
        public i.e onCreateRouteController(String str) {
            int iFindSystemRouteRecordByDescriptorId = findSystemRouteRecordByDescriptorId(str);
            if (iFindSystemRouteRecordByDescriptorId >= 0) {
                return new a(this.f100q.get(iFindSystemRouteRecordByDescriptorId).f103a);
            }
            return null;
        }

        @Override // a2.i
        public void onDiscoveryRequestChanged(h hVar) {
            boolean zIsActiveScan;
            int i10 = 0;
            if (hVar != null) {
                List<String> controlCategories = hVar.getSelector().getControlCategories();
                int size = controlCategories.size();
                int i11 = 0;
                while (i10 < size) {
                    String str = controlCategories.get(i10);
                    i11 = str.equals("android.media.intent.category.LIVE_AUDIO") ? i11 | 1 : str.equals("android.media.intent.category.LIVE_VIDEO") ? i11 | 2 : i11 | 8388608;
                    i10++;
                }
                zIsActiveScan = hVar.isActiveScan();
                i10 = i11;
            } else {
                zIsActiveScan = false;
            }
            if (this.f97n == i10 && this.f98o == zIsActiveScan) {
                return;
            }
            this.f97n = i10;
            this.f98o = zIsActiveScan;
            b();
        }

        @Override // a2.s.a
        public void onRouteAdded(MediaRouter.RouteInfo routeInfo) {
            if (a(routeInfo)) {
                publishRoutes();
            }
        }

        @Override // a2.s.a
        public void onRouteChanged(MediaRouter.RouteInfo routeInfo) {
            int iFindSystemRouteRecord;
            if (getUserRouteRecord(routeInfo) != null || (iFindSystemRouteRecord = findSystemRouteRecord(routeInfo)) < 0) {
                return;
            }
            updateSystemRouteDescriptor(this.f100q.get(iFindSystemRouteRecord));
            publishRoutes();
        }

        @Override // a2.s.a
        public void onRouteRemoved(MediaRouter.RouteInfo routeInfo) {
            int iFindSystemRouteRecord;
            if (getUserRouteRecord(routeInfo) != null || (iFindSystemRouteRecord = findSystemRouteRecord(routeInfo)) < 0) {
                return;
            }
            this.f100q.remove(iFindSystemRouteRecord);
            publishRoutes();
        }

        @Override // a2.s.a
        public void onRouteSelected(int i10, MediaRouter.RouteInfo routeInfo) {
            if (routeInfo != s.getSelectedRoute(this.f93j, 8388611)) {
                return;
            }
            c userRouteRecord = getUserRouteRecord(routeInfo);
            if (userRouteRecord != null) {
                userRouteRecord.f106a.select();
                return;
            }
            int iFindSystemRouteRecord = findSystemRouteRecord(routeInfo);
            if (iFindSystemRouteRecord >= 0) {
                ((a2.a) this.f92i).onSystemRouteSelectedByDescriptorId(this.f100q.get(iFindSystemRouteRecord).f104b);
            }
        }

        @Override // a2.s.a
        public void onRouteVolumeChanged(MediaRouter.RouteInfo routeInfo) {
            int iFindSystemRouteRecord;
            if (getUserRouteRecord(routeInfo) != null || (iFindSystemRouteRecord = findSystemRouteRecord(routeInfo)) < 0) {
                return;
            }
            C0001b c0001b = this.f100q.get(iFindSystemRouteRecord);
            int volume = s.c.getVolume(routeInfo);
            if (volume != c0001b.f105c.getVolume()) {
                c0001b.f105c = new g.a(c0001b.f105c).setVolume(volume).build();
                publishRoutes();
            }
        }

        @Override // a2.c0
        public void onSyncRouteAdded(n.g gVar) {
            i providerInstance = gVar.getProviderInstance();
            MediaRouter mediaRouter = this.f93j;
            if (providerInstance == this) {
                int iFindSystemRouteRecord = findSystemRouteRecord(s.getSelectedRoute(mediaRouter, 8388611));
                if (iFindSystemRouteRecord < 0 || !this.f100q.get(iFindSystemRouteRecord).f104b.equals(gVar.f210b)) {
                    return;
                }
                gVar.select();
                return;
            }
            MediaRouter.UserRouteInfo userRouteInfoCreateUserRoute = s.createUserRoute(mediaRouter, this.f96m);
            c cVar = new c(gVar, userRouteInfoCreateUserRoute);
            s.c.setTag(userRouteInfoCreateUserRoute, cVar);
            s.d.setVolumeCallback(userRouteInfoCreateUserRoute, this.f95l);
            updateUserRouteProperties(cVar);
            this.f101r.add(cVar);
            s.addUserRoute(mediaRouter, userRouteInfoCreateUserRoute);
        }

        @Override // a2.c0
        public void onSyncRouteChanged(n.g gVar) {
            int iFindUserRouteRecord;
            if (gVar.getProviderInstance() == this || (iFindUserRouteRecord = findUserRouteRecord(gVar)) < 0) {
                return;
            }
            updateUserRouteProperties(this.f101r.get(iFindUserRouteRecord));
        }

        @Override // a2.c0
        public void onSyncRouteRemoved(n.g gVar) {
            int iFindUserRouteRecord;
            if (gVar.getProviderInstance() == this || (iFindUserRouteRecord = findUserRouteRecord(gVar)) < 0) {
                return;
            }
            c cVarRemove = this.f101r.remove(iFindUserRouteRecord);
            s.c.setTag(cVarRemove.f107b, null);
            MediaRouter.UserRouteInfo userRouteInfo = cVarRemove.f107b;
            s.d.setVolumeCallback(userRouteInfo, null);
            s.removeUserRoute(this.f93j, userRouteInfo);
        }

        @Override // a2.c0
        public void onSyncRouteSelected(n.g gVar) {
            if (gVar.isSelected()) {
                if (gVar.getProviderInstance() != this) {
                    int iFindUserRouteRecord = findUserRouteRecord(gVar);
                    if (iFindUserRouteRecord >= 0) {
                        selectRoute(this.f101r.get(iFindUserRouteRecord).f107b);
                        return;
                    }
                    return;
                }
                int iFindSystemRouteRecordByDescriptorId = findSystemRouteRecordByDescriptorId(gVar.f210b);
                if (iFindSystemRouteRecordByDescriptorId >= 0) {
                    selectRoute(this.f100q.get(iFindSystemRouteRecordByDescriptorId).f103a);
                }
            }
        }

        @Override // a2.s.e
        public void onVolumeSetRequest(MediaRouter.RouteInfo routeInfo, int i10) {
            c userRouteRecord = getUserRouteRecord(routeInfo);
            if (userRouteRecord != null) {
                userRouteRecord.f106a.requestSetVolume(i10);
            }
        }

        @Override // a2.s.e
        public void onVolumeUpdateRequest(MediaRouter.RouteInfo routeInfo, int i10) {
            c userRouteRecord = getUserRouteRecord(routeInfo);
            if (userRouteRecord != null) {
                userRouteRecord.f106a.requestUpdateVolume(i10);
            }
        }

        public void publishRoutes() {
            k.a aVar = new k.a();
            ArrayList<C0001b> arrayList = this.f100q;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                aVar.addRoute(arrayList.get(i10).f105c);
            }
            setDescriptor(aVar.build());
        }

        public void selectRoute(MediaRouter.RouteInfo routeInfo) {
            throw null;
        }

        public void updateCallback() {
            throw null;
        }

        public void updateSystemRouteDescriptor(C0001b c0001b) {
            g.a aVar = new g.a(c0001b.f104b, getRouteName(c0001b.f103a));
            onBuildSystemRouteDescriptor(c0001b, aVar);
            c0001b.f105c = aVar.build();
        }

        public void updateUserRouteProperties(c cVar) {
            MediaRouter.UserRouteInfo userRouteInfo = cVar.f107b;
            n.g gVar = cVar.f106a;
            s.d.setName(userRouteInfo, gVar.getName());
            int playbackType = gVar.getPlaybackType();
            MediaRouter.UserRouteInfo userRouteInfo2 = cVar.f107b;
            s.d.setPlaybackType(userRouteInfo2, playbackType);
            s.d.setPlaybackStream(userRouteInfo2, gVar.getPlaybackStream());
            s.d.setVolume(userRouteInfo2, gVar.getVolume());
            s.d.setVolumeMax(userRouteInfo2, gVar.getVolumeMax());
            s.d.setVolumeHandling(userRouteInfo2, gVar.getVolumeHandling());
        }

        @Override // a2.s.a
        public void onRouteUngrouped(MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup) {
        }

        @Override // a2.s.a
        public void onRouteUnselected(int i10, MediaRouter.RouteInfo routeInfo) {
        }

        @Override // a2.s.a
        public void onRouteGrouped(MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup, int i10) {
        }
    }
}
