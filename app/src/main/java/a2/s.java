package a2;

import android.content.Context;
import android.media.MediaRouter;
import android.media.RemoteControlClient;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MediaRouterApi16Impl.java */
/* loaded from: classes.dex */
public final class s {

    /* compiled from: MediaRouterApi16Impl.java */
    public interface a {
        void onRouteAdded(MediaRouter.RouteInfo routeInfo);

        void onRouteChanged(MediaRouter.RouteInfo routeInfo);

        void onRouteGrouped(MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup, int i10);

        void onRouteRemoved(MediaRouter.RouteInfo routeInfo);

        void onRouteSelected(int i10, MediaRouter.RouteInfo routeInfo);

        void onRouteUngrouped(MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup);

        void onRouteUnselected(int i10, MediaRouter.RouteInfo routeInfo);

        void onRouteVolumeChanged(MediaRouter.RouteInfo routeInfo);
    }

    /* compiled from: MediaRouterApi16Impl.java */
    public static class b<T extends a> extends MediaRouter.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final T f239a;

        public b(T t10) {
            this.f239a = t10;
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.f239a.onRouteAdded(routeInfo);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.f239a.onRouteChanged(routeInfo);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteGrouped(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup, int i10) {
            this.f239a.onRouteGrouped(routeInfo, routeGroup, i10);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.f239a.onRouteRemoved(routeInfo);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteSelected(MediaRouter mediaRouter, int i10, MediaRouter.RouteInfo routeInfo) {
            this.f239a.onRouteSelected(i10, routeInfo);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteUngrouped(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup) {
            this.f239a.onRouteUngrouped(routeInfo, routeGroup);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteUnselected(MediaRouter mediaRouter, int i10, MediaRouter.RouteInfo routeInfo) {
            this.f239a.onRouteUnselected(i10, routeInfo);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteVolumeChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.f239a.onRouteVolumeChanged(routeInfo);
        }
    }

    /* compiled from: MediaRouterApi16Impl.java */
    public static final class c {
        public static CharSequence getName(MediaRouter.RouteInfo routeInfo, Context context) {
            return routeInfo.getName(context);
        }

        public static int getPlaybackStream(MediaRouter.RouteInfo routeInfo) {
            return routeInfo.getPlaybackStream();
        }

        public static int getPlaybackType(MediaRouter.RouteInfo routeInfo) {
            return routeInfo.getPlaybackType();
        }

        public static int getSupportedTypes(MediaRouter.RouteInfo routeInfo) {
            return routeInfo.getSupportedTypes();
        }

        public static Object getTag(MediaRouter.RouteInfo routeInfo) {
            return routeInfo.getTag();
        }

        public static int getVolume(MediaRouter.RouteInfo routeInfo) {
            return routeInfo.getVolume();
        }

        public static int getVolumeHandling(MediaRouter.RouteInfo routeInfo) {
            return routeInfo.getVolumeHandling();
        }

        public static int getVolumeMax(MediaRouter.RouteInfo routeInfo) {
            return routeInfo.getVolumeMax();
        }

        public static void requestSetVolume(MediaRouter.RouteInfo routeInfo, int i10) {
            routeInfo.requestSetVolume(i10);
        }

        public static void requestUpdateVolume(MediaRouter.RouteInfo routeInfo, int i10) {
            routeInfo.requestUpdateVolume(i10);
        }

        public static void setTag(MediaRouter.RouteInfo routeInfo, Object obj) {
            routeInfo.setTag(obj);
        }
    }

    /* compiled from: MediaRouterApi16Impl.java */
    public static final class d {
        public static void setName(MediaRouter.UserRouteInfo userRouteInfo, CharSequence charSequence) {
            userRouteInfo.setName(charSequence);
        }

        public static void setPlaybackStream(MediaRouter.UserRouteInfo userRouteInfo, int i10) {
            userRouteInfo.setPlaybackStream(i10);
        }

        public static void setPlaybackType(MediaRouter.UserRouteInfo userRouteInfo, int i10) {
            userRouteInfo.setPlaybackType(i10);
        }

        public static void setRemoteControlClient(MediaRouter.UserRouteInfo userRouteInfo, RemoteControlClient remoteControlClient) {
            userRouteInfo.setRemoteControlClient(remoteControlClient);
        }

        public static void setVolume(MediaRouter.UserRouteInfo userRouteInfo, int i10) {
            userRouteInfo.setVolume(i10);
        }

        public static void setVolumeCallback(MediaRouter.UserRouteInfo userRouteInfo, MediaRouter.VolumeCallback volumeCallback) {
            userRouteInfo.setVolumeCallback(volumeCallback);
        }

        public static void setVolumeHandling(MediaRouter.UserRouteInfo userRouteInfo, int i10) {
            userRouteInfo.setVolumeHandling(i10);
        }

        public static void setVolumeMax(MediaRouter.UserRouteInfo userRouteInfo, int i10) {
            userRouteInfo.setVolumeMax(i10);
        }
    }

    /* compiled from: MediaRouterApi16Impl.java */
    public interface e {
        void onVolumeSetRequest(MediaRouter.RouteInfo routeInfo, int i10);

        void onVolumeUpdateRequest(MediaRouter.RouteInfo routeInfo, int i10);
    }

    /* compiled from: MediaRouterApi16Impl.java */
    public static class f<T extends e> extends MediaRouter.VolumeCallback {

        /* renamed from: a, reason: collision with root package name */
        public final T f240a;

        public f(T t10) {
            this.f240a = t10;
        }

        @Override // android.media.MediaRouter.VolumeCallback
        public void onVolumeSetRequest(MediaRouter.RouteInfo routeInfo, int i10) {
            this.f240a.onVolumeSetRequest(routeInfo, i10);
        }

        @Override // android.media.MediaRouter.VolumeCallback
        public void onVolumeUpdateRequest(MediaRouter.RouteInfo routeInfo, int i10) {
            this.f240a.onVolumeUpdateRequest(routeInfo, i10);
        }
    }

    public static void addCallback(MediaRouter mediaRouter, int i10, MediaRouter.Callback callback) {
        mediaRouter.addCallback(i10, callback);
    }

    public static void addUserRoute(MediaRouter mediaRouter, MediaRouter.UserRouteInfo userRouteInfo) {
        mediaRouter.addUserRoute(userRouteInfo);
    }

    public static MediaRouter.Callback createCallback(a aVar) {
        return new b(aVar);
    }

    public static MediaRouter.RouteCategory createRouteCategory(MediaRouter mediaRouter, String str, boolean z10) {
        return mediaRouter.createRouteCategory(str, z10);
    }

    public static MediaRouter.UserRouteInfo createUserRoute(MediaRouter mediaRouter, MediaRouter.RouteCategory routeCategory) {
        return mediaRouter.createUserRoute(routeCategory);
    }

    public static MediaRouter.VolumeCallback createVolumeCallback(e eVar) {
        return new f(eVar);
    }

    public static MediaRouter getMediaRouter(Context context) {
        return (MediaRouter) context.getSystemService("media_router");
    }

    public static List<MediaRouter.RouteInfo> getRoutes(MediaRouter mediaRouter) {
        int routeCount = mediaRouter.getRouteCount();
        ArrayList arrayList = new ArrayList(routeCount);
        for (int i10 = 0; i10 < routeCount; i10++) {
            arrayList.add(mediaRouter.getRouteAt(i10));
        }
        return arrayList;
    }

    public static MediaRouter.RouteInfo getSelectedRoute(MediaRouter mediaRouter, int i10) {
        return mediaRouter.getSelectedRoute(i10);
    }

    public static void removeCallback(MediaRouter mediaRouter, MediaRouter.Callback callback) {
        mediaRouter.removeCallback(callback);
    }

    public static void removeUserRoute(MediaRouter mediaRouter, MediaRouter.UserRouteInfo userRouteInfo) {
        try {
            mediaRouter.removeUserRoute(userRouteInfo);
        } catch (IllegalArgumentException e10) {
            Log.w("MediaRouterJellybean", "Failed to remove user route", e10);
        }
    }

    public static void selectRoute(MediaRouter mediaRouter, int i10, MediaRouter.RouteInfo routeInfo) {
        mediaRouter.selectRoute(i10, routeInfo);
    }
}
