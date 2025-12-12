package a2;

import a2.s;
import android.media.MediaRouter;
import android.util.Log;
import android.view.Display;

/* compiled from: MediaRouterApi17Impl.java */
/* loaded from: classes.dex */
public final class t {

    /* compiled from: MediaRouterApi17Impl.java */
    public interface a extends s.a {
        void onRoutePresentationDisplayChanged(MediaRouter.RouteInfo routeInfo);
    }

    /* compiled from: MediaRouterApi17Impl.java */
    public static class b<T extends a> extends s.b<T> {
        public b(T t10) {
            super(t10);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRoutePresentationDisplayChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            ((a) this.f239a).onRoutePresentationDisplayChanged(routeInfo);
        }
    }

    /* compiled from: MediaRouterApi17Impl.java */
    public static final class c {
        public static Display getPresentationDisplay(MediaRouter.RouteInfo routeInfo) {
            try {
                return routeInfo.getPresentationDisplay();
            } catch (NoSuchMethodError e10) {
                Log.w("MediaRouterJellybeanMr1", "Cannot get presentation display for the route.", e10);
                return null;
            }
        }

        public static boolean isEnabled(MediaRouter.RouteInfo routeInfo) {
            return routeInfo.isEnabled();
        }
    }

    public static MediaRouter.Callback createCallback(a aVar) {
        return new b(aVar);
    }
}
