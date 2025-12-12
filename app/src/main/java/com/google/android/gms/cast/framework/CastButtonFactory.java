package com.google.android.gms.cast.framework;

import a2.m;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import androidx.mediarouter.app.MediaRouteActionProvider;
import androidx.mediarouter.app.MediaRouteButton;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzml;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import x0.n;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class CastButtonFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f6333a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f6334b;

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList f6335c;

    /* renamed from: d, reason: collision with root package name */
    public static final Object f6336d;

    static {
        new Logger("CastButtonFactory");
        f6333a = new ArrayList();
        f6334b = new Object();
        f6335c = new ArrayList();
        f6336d = new Object();
    }

    private CastButtonFactory() {
    }

    public static MenuItem setUpMediaRouteButton(Context context, Menu menu, int i10) {
        m mergedSelector;
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(menu);
        MenuItem menuItemFindItem = menu.findItem(i10);
        if (menuItemFindItem == null) {
            throw new IllegalArgumentException(String.format(Locale.ROOT, "menu doesn't contain a menu item whose ID is %d.", Integer.valueOf(i10)));
        }
        try {
            Preconditions.checkMainThread("Must be called from the main thread.");
            MediaRouteActionProvider mediaRouteActionProvider = (MediaRouteActionProvider) n.getActionProvider(menuItemFindItem);
            if (mediaRouteActionProvider == null) {
                mediaRouteActionProvider = null;
            }
            if (mediaRouteActionProvider == null) {
                throw new IllegalArgumentException("cannot refreshButtonSelector with null mediaRouteActionProvider");
            }
            CastContext castContextZza = CastContext.zza(context);
            if (castContextZza != null && (mergedSelector = castContextZza.getMergedSelector()) != null) {
                mediaRouteActionProvider.setRouteSelector(mergedSelector);
            }
            synchronized (f6334b) {
                f6333a.add(new WeakReference(menuItemFindItem));
            }
            com.google.android.gms.internal.cast.zzo.zzd(zzml.CAST_DEFAULT_MEDIA_ROUTER_DIALOG);
            return menuItemFindItem;
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(String.format(Locale.ROOT, "menu item with ID %d doesn't have a MediaRouteActionProvider.", Integer.valueOf(i10)), e10);
        }
    }

    public static void setUpMediaRouteButton(Context context, MediaRouteButton mediaRouteButton) {
        m mergedSelector;
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (mediaRouteButton != null) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            CastContext castContextZza = CastContext.zza(context);
            if (castContextZza != null && (mergedSelector = castContextZza.getMergedSelector()) != null) {
                mediaRouteButton.setRouteSelector(mergedSelector);
            }
            synchronized (f6336d) {
                f6335c.add(new WeakReference(mediaRouteButton));
            }
        }
        com.google.android.gms.internal.cast.zzo.zzd(zzml.CAST_DEFAULT_MEDIA_ROUTER_DIALOG);
    }
}
