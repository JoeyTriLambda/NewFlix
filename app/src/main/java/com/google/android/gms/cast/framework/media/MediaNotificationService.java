package com.google.android.gms.cast.framework.media;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.internal.CastUtils;
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
public class MediaNotificationService extends Service {

    /* renamed from: z, reason: collision with root package name */
    public static final Logger f6464z = new Logger("MediaNotificationService");

    /* renamed from: b, reason: collision with root package name */
    public NotificationOptions f6465b;

    /* renamed from: m, reason: collision with root package name */
    public ImagePicker f6466m;

    /* renamed from: n, reason: collision with root package name */
    public ComponentName f6467n;

    /* renamed from: o, reason: collision with root package name */
    public ComponentName f6468o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f6469p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    public int[] f6470q;

    /* renamed from: r, reason: collision with root package name */
    public long f6471r;

    /* renamed from: s, reason: collision with root package name */
    public com.google.android.gms.cast.framework.media.internal.zzb f6472s;

    /* renamed from: t, reason: collision with root package name */
    public ImageHints f6473t;

    /* renamed from: u, reason: collision with root package name */
    public Resources f6474u;

    /* renamed from: v, reason: collision with root package name */
    public zzm f6475v;

    /* renamed from: w, reason: collision with root package name */
    public zzn f6476w;

    /* renamed from: x, reason: collision with root package name */
    public NotificationManager f6477x;

    /* renamed from: y, reason: collision with root package name */
    public Notification f6478y;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final l0.o.a a(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.MediaNotificationService.a(java.lang.String):l0.o$a");
    }

    public final void b() {
        PendingIntent pendingIntent;
        o.a aVarA;
        if (this.f6475v == null) {
            return;
        }
        zzn zznVar = this.f6476w;
        o.d visibility = new o.d(this, "cast_media_notification").setLargeIcon(zznVar == null ? null : zznVar.f6777b).setSmallIcon(this.f6465b.getSmallIconDrawableResId()).setContentTitle(this.f6475v.f6772d).setContentText(this.f6474u.getString(this.f6465b.getCastingToDeviceStringResId(), this.f6475v.f6773e)).setOngoing(true).setShowWhen(false).setVisibility(1);
        ComponentName componentName = this.f6468o;
        if (componentName == null) {
            pendingIntent = null;
        } else {
            Intent intent = new Intent();
            intent.putExtra("targetActivity", componentName);
            intent.setAction(componentName.flattenToString());
            intent.setComponent(componentName);
            z zVarCreate = z.create(this);
            zVarCreate.addNextIntentWithParentStack(intent);
            pendingIntent = zVarCreate.getPendingIntent(1, zzdy.zza | 134217728);
        }
        if (pendingIntent != null) {
            visibility.setContentIntent(pendingIntent);
        }
        zzg zzgVarZzm = this.f6465b.zzm();
        Logger logger = f6464z;
        if (zzgVarZzm != null) {
            logger.i("actionsProvider != null", new Object[0]);
            int[] iArrZzg = com.google.android.gms.cast.framework.media.internal.zzw.zzg(zzgVarZzm);
            this.f6470q = iArrZzg != null ? (int[]) iArrZzg.clone() : null;
            List<NotificationAction> listZzf = com.google.android.gms.cast.framework.media.internal.zzw.zzf(zzgVarZzm);
            this.f6469p = new ArrayList();
            if (listZzf != null) {
                for (NotificationAction notificationAction : listZzf) {
                    String action = notificationAction.getAction();
                    if (action.equals(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK) || action.equals(MediaIntentReceiver.ACTION_SKIP_NEXT) || action.equals(MediaIntentReceiver.ACTION_SKIP_PREV) || action.equals(MediaIntentReceiver.ACTION_FORWARD) || action.equals(MediaIntentReceiver.ACTION_REWIND) || action.equals(MediaIntentReceiver.ACTION_STOP_CASTING) || action.equals(MediaIntentReceiver.ACTION_DISCONNECT)) {
                        aVarA = a(notificationAction.getAction());
                    } else {
                        Intent intent2 = new Intent(notificationAction.getAction());
                        intent2.setComponent(this.f6467n);
                        aVarA = new o.a.C0185a(notificationAction.getIconResId(), notificationAction.getContentDescription(), PendingIntent.getBroadcast(this, 0, intent2, zzdy.zza)).build();
                    }
                    if (aVarA != null) {
                        this.f6469p.add(aVarA);
                    }
                }
            }
        } else {
            logger.i("actionsProvider == null", new Object[0]);
            this.f6469p = new ArrayList();
            Iterator<String> it = this.f6465b.getActions().iterator();
            while (it.hasNext()) {
                o.a aVarA2 = a(it.next());
                if (aVarA2 != null) {
                    this.f6469p.add(aVarA2);
                }
            }
            this.f6470q = (int[]) this.f6465b.getCompatActionIndices().clone();
        }
        Iterator it2 = this.f6469p.iterator();
        while (it2.hasNext()) {
            visibility.addAction((o.a) it2.next());
        }
        c cVar = new c();
        int[] iArr = this.f6470q;
        if (iArr != null) {
            cVar.setShowActionsInCompactView(iArr);
        }
        MediaSessionCompat.Token token = this.f6475v.f6769a;
        if (token != null) {
            cVar.setMediaSession(token);
        }
        visibility.setStyle(cVar);
        Notification notificationBuild = visibility.build();
        this.f6478y = notificationBuild;
        startForeground(1, notificationBuild);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() throws Resources.NotFoundException {
        this.f6477x = (NotificationManager) getSystemService("notification");
        CastMediaOptions castMediaOptions = (CastMediaOptions) Preconditions.checkNotNull(CastContext.getSharedInstance(this).getCastOptions().getCastMediaOptions());
        this.f6465b = (NotificationOptions) Preconditions.checkNotNull(castMediaOptions.getNotificationOptions());
        this.f6466m = castMediaOptions.getImagePicker();
        this.f6474u = getResources();
        this.f6467n = new ComponentName(getApplicationContext(), castMediaOptions.getMediaIntentReceiverClassName());
        if (TextUtils.isEmpty(this.f6465b.getTargetActivityClassName())) {
            this.f6468o = null;
        } else {
            this.f6468o = new ComponentName(getApplicationContext(), this.f6465b.getTargetActivityClassName());
        }
        this.f6471r = this.f6465b.getSkipStepMs();
        int dimensionPixelSize = this.f6474u.getDimensionPixelSize(this.f6465b.zze());
        this.f6473t = new ImageHints(1, dimensionPixelSize, dimensionPixelSize);
        this.f6472s = new com.google.android.gms.cast.framework.media.internal.zzb(getApplicationContext(), this.f6473t);
        if (PlatformVersion.isAtLeastO()) {
            NotificationChannel notificationChannel = new NotificationChannel("cast_media_notification", getResources().getString(R.string.media_notification_channel_name), 2);
            notificationChannel.setShowBadge(false);
            this.f6477x.createNotificationChannel(notificationChannel);
        }
        com.google.android.gms.internal.cast.zzo.zzd(zzml.CAF_NOTIFICATION_SERVICE);
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.google.android.gms.cast.framework.media.internal.zzb zzbVar = this.f6472s;
        if (zzbVar != null) {
            zzbVar.zza();
        }
        this.f6477x.cancel(1);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, final int i11) {
        zzm zzmVar;
        MediaInfo mediaInfo = (MediaInfo) Preconditions.checkNotNull((MediaInfo) intent.getParcelableExtra("extra_media_info"));
        MediaMetadata mediaMetadata = (MediaMetadata) Preconditions.checkNotNull(mediaInfo.getMetadata());
        zzm zzmVar2 = new zzm(intent.getIntExtra("extra_remote_media_client_player_state", 0) == 2, mediaInfo.getStreamType(), mediaMetadata.getString("com.google.android.gms.cast.metadata.TITLE"), ((CastDevice) Preconditions.checkNotNull((CastDevice) intent.getParcelableExtra("extra_cast_device"))).getFriendlyName(), (MediaSessionCompat.Token) intent.getParcelableExtra("extra_media_session_token"), intent.getBooleanExtra("extra_can_skip_next", false), intent.getBooleanExtra("extra_can_skip_prev", false));
        if (intent.getBooleanExtra("extra_media_notification_force_update", false) || (zzmVar = this.f6475v) == null || zzmVar2.f6770b != zzmVar.f6770b || zzmVar2.f6771c != zzmVar.f6771c || !CastUtils.zze(zzmVar2.f6772d, zzmVar.f6772d) || !CastUtils.zze(zzmVar2.f6773e, zzmVar.f6773e) || zzmVar2.f6774f != zzmVar.f6774f || zzmVar2.f6775g != zzmVar.f6775g) {
            this.f6475v = zzmVar2;
            b();
        }
        ImagePicker imagePicker = this.f6466m;
        zzn zznVar = new zzn(imagePicker != null ? imagePicker.onPickImage(mediaMetadata, this.f6473t) : mediaMetadata.hasImages() ? mediaMetadata.getImages().get(0) : null);
        zzn zznVar2 = this.f6476w;
        Uri uri = zznVar.f6776a;
        if (zznVar2 == null || !CastUtils.zze(uri, zznVar2.f6776a)) {
            this.f6472s.zzc(new zzl(this, zznVar));
            this.f6472s.zzd(uri);
        }
        startForeground(1, this.f6478y);
        new Runnable() { // from class: com.google.android.gms.cast.framework.media.zzk
            @Override // java.lang.Runnable
            public final void run() {
                this.f6765b.stopSelf(i11);
            }
        };
        return 2;
    }
}
