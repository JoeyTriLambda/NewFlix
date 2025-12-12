package com.google.android.gms.cast.framework.media.internal;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.ImagePicker;
import com.google.android.gms.cast.framework.media.MediaIntentReceiver;
import com.google.android.gms.cast.framework.media.NotificationAction;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzdy;
import com.google.android.gms.internal.cast.zzml;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l0.o;
import l0.z;
import y1.c;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzo {

    /* renamed from: w, reason: collision with root package name */
    public static final Logger f6564w = new Logger("MediaNotificationProxy");

    /* renamed from: a, reason: collision with root package name */
    public final Context f6565a;

    /* renamed from: b, reason: collision with root package name */
    public final NotificationManager f6566b;

    /* renamed from: c, reason: collision with root package name */
    public final NotificationOptions f6567c;

    /* renamed from: d, reason: collision with root package name */
    public final ImagePicker f6568d;

    /* renamed from: e, reason: collision with root package name */
    public final ComponentName f6569e;

    /* renamed from: f, reason: collision with root package name */
    public final ComponentName f6570f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f6571g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public int[] f6572h;

    /* renamed from: i, reason: collision with root package name */
    public final long f6573i;

    /* renamed from: j, reason: collision with root package name */
    public final zzb f6574j;

    /* renamed from: k, reason: collision with root package name */
    public final ImageHints f6575k;

    /* renamed from: l, reason: collision with root package name */
    public final Resources f6576l;

    /* renamed from: m, reason: collision with root package name */
    public zzm f6577m;

    /* renamed from: n, reason: collision with root package name */
    public zzn f6578n;

    /* renamed from: o, reason: collision with root package name */
    public o.a f6579o;

    /* renamed from: p, reason: collision with root package name */
    public o.a f6580p;

    /* renamed from: q, reason: collision with root package name */
    public o.a f6581q;

    /* renamed from: r, reason: collision with root package name */
    public o.a f6582r;

    /* renamed from: s, reason: collision with root package name */
    public o.a f6583s;

    /* renamed from: t, reason: collision with root package name */
    public o.a f6584t;

    /* renamed from: u, reason: collision with root package name */
    public o.a f6585u;

    /* renamed from: v, reason: collision with root package name */
    public o.a f6586v;

    public zzo(Context context) throws Resources.NotFoundException {
        this.f6565a = context;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        this.f6566b = notificationManager;
        CastMediaOptions castMediaOptions = (CastMediaOptions) Preconditions.checkNotNull(((CastOptions) Preconditions.checkNotNull(((CastContext) Preconditions.checkNotNull(CastContext.getSharedInstance())).getCastOptions())).getCastMediaOptions());
        NotificationOptions notificationOptions = (NotificationOptions) Preconditions.checkNotNull(castMediaOptions.getNotificationOptions());
        this.f6567c = notificationOptions;
        this.f6568d = castMediaOptions.getImagePicker();
        Resources resources = context.getResources();
        this.f6576l = resources;
        this.f6569e = new ComponentName(context.getApplicationContext(), castMediaOptions.getMediaIntentReceiverClassName());
        if (TextUtils.isEmpty(notificationOptions.getTargetActivityClassName())) {
            this.f6570f = null;
        } else {
            this.f6570f = new ComponentName(context.getApplicationContext(), notificationOptions.getTargetActivityClassName());
        }
        this.f6573i = notificationOptions.getSkipStepMs();
        int dimensionPixelSize = resources.getDimensionPixelSize(notificationOptions.zze());
        ImageHints imageHints = new ImageHints(1, dimensionPixelSize, dimensionPixelSize);
        this.f6575k = imageHints;
        this.f6574j = new zzb(context.getApplicationContext(), imageHints);
        if (PlatformVersion.isAtLeastO() && notificationManager != null) {
            NotificationChannel notificationChannel = new NotificationChannel("cast_media_notification", ((Context) Preconditions.checkNotNull(context)).getResources().getString(R.string.media_notification_channel_name), 2);
            notificationChannel.setShowBadge(false);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        com.google.android.gms.internal.cast.zzo.zzd(zzml.CAF_MEDIA_NOTIFICATION_PROXY);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final l0.o.a a(java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 582
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.internal.zzo.a(java.lang.String):l0.o$a");
    }

    public final void b() {
        PendingIntent pendingIntent;
        o.a aVarA;
        NotificationManager notificationManager = this.f6566b;
        if (notificationManager == null || this.f6577m == null) {
            return;
        }
        zzn zznVar = this.f6578n;
        Bitmap bitmap = zznVar == null ? null : zznVar.f6563b;
        Context context = this.f6565a;
        o.d largeIcon = new o.d(context, "cast_media_notification").setLargeIcon(bitmap);
        NotificationOptions notificationOptions = this.f6567c;
        o.d visibility = largeIcon.setSmallIcon(notificationOptions.getSmallIconDrawableResId()).setContentTitle(this.f6577m.f6558d).setContentText(this.f6576l.getString(notificationOptions.getCastingToDeviceStringResId(), this.f6577m.f6559e)).setOngoing(true).setShowWhen(false).setVisibility(1);
        ComponentName componentName = this.f6570f;
        if (componentName == null) {
            pendingIntent = null;
        } else {
            Intent intent = new Intent();
            intent.putExtra("targetActivity", componentName);
            intent.setAction(componentName.flattenToString());
            intent.setComponent(componentName);
            z zVarCreate = z.create(context);
            zVarCreate.addNextIntentWithParentStack(intent);
            pendingIntent = zVarCreate.getPendingIntent(1, zzdy.zza | 134217728);
        }
        if (pendingIntent != null) {
            visibility.setContentIntent(pendingIntent);
        }
        com.google.android.gms.cast.framework.media.zzg zzgVarZzm = notificationOptions.zzm();
        Logger logger = f6564w;
        if (zzgVarZzm != null) {
            logger.d("actionsProvider != null", new Object[0]);
            int[] iArrZzg = zzw.zzg(zzgVarZzm);
            this.f6572h = iArrZzg != null ? (int[]) iArrZzg.clone() : null;
            List<NotificationAction> listZzf = zzw.zzf(zzgVarZzm);
            this.f6571g = new ArrayList();
            if (listZzf != null) {
                for (NotificationAction notificationAction : listZzf) {
                    String action = notificationAction.getAction();
                    if (action.equals(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK) || action.equals(MediaIntentReceiver.ACTION_SKIP_NEXT) || action.equals(MediaIntentReceiver.ACTION_SKIP_PREV) || action.equals(MediaIntentReceiver.ACTION_FORWARD) || action.equals(MediaIntentReceiver.ACTION_REWIND) || action.equals(MediaIntentReceiver.ACTION_STOP_CASTING) || action.equals(MediaIntentReceiver.ACTION_DISCONNECT)) {
                        aVarA = a(notificationAction.getAction());
                    } else {
                        Intent intent2 = new Intent(notificationAction.getAction());
                        intent2.setComponent(this.f6569e);
                        aVarA = new o.a.C0185a(notificationAction.getIconResId(), notificationAction.getContentDescription(), PendingIntent.getBroadcast(context, 0, intent2, zzdy.zza)).build();
                    }
                    if (aVarA != null) {
                        this.f6571g.add(aVarA);
                    }
                }
            }
        } else {
            logger.d("actionsProvider == null", new Object[0]);
            this.f6571g = new ArrayList();
            Iterator<String> it = notificationOptions.getActions().iterator();
            while (it.hasNext()) {
                o.a aVarA2 = a(it.next());
                if (aVarA2 != null) {
                    this.f6571g.add(aVarA2);
                }
            }
            this.f6572h = (int[]) notificationOptions.getCompatActionIndices().clone();
        }
        Iterator it2 = this.f6571g.iterator();
        while (it2.hasNext()) {
            visibility.addAction((o.a) it2.next());
        }
        c cVar = new c();
        int[] iArr = this.f6572h;
        if (iArr != null) {
            cVar.setShowActionsInCompactView(iArr);
        }
        MediaSessionCompat.Token token = this.f6577m.f6555a;
        if (token != null) {
            cVar.setMediaSession(token);
        }
        visibility.setStyle(cVar);
        notificationManager.notify("castMediaNotification", 1, visibility.build());
    }
}
