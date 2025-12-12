package com.google.android.gms.cast.framework.media.internal;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.ReconnectionService;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImagePicker;
import com.google.android.gms.cast.framework.media.MediaIntentReceiver;
import com.google.android.gms.cast.framework.media.NotificationAction;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzbf;
import com.google.android.gms.internal.cast.zzdy;
import com.google.android.gms.internal.cast.zzed;
import com.unity3d.services.core.device.MimeTypes;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzv {

    /* renamed from: v, reason: collision with root package name */
    public static final Logger f6592v = new Logger("MediaSessionManager");

    /* renamed from: a, reason: collision with root package name */
    public final Context f6593a;

    /* renamed from: b, reason: collision with root package name */
    public final CastOptions f6594b;

    /* renamed from: c, reason: collision with root package name */
    public final zzbf f6595c;

    /* renamed from: d, reason: collision with root package name */
    public final SessionManager f6596d;

    /* renamed from: e, reason: collision with root package name */
    public final NotificationOptions f6597e;

    /* renamed from: f, reason: collision with root package name */
    public final ComponentName f6598f;

    /* renamed from: g, reason: collision with root package name */
    public final ComponentName f6599g;

    /* renamed from: h, reason: collision with root package name */
    public final zzb f6600h;

    /* renamed from: i, reason: collision with root package name */
    public final zzb f6601i;

    /* renamed from: j, reason: collision with root package name */
    public final zzo f6602j;

    /* renamed from: k, reason: collision with root package name */
    public final zzed f6603k;

    /* renamed from: l, reason: collision with root package name */
    public final zzp f6604l;

    /* renamed from: m, reason: collision with root package name */
    public final RemoteMediaClient.Callback f6605m;

    /* renamed from: n, reason: collision with root package name */
    public RemoteMediaClient f6606n;

    /* renamed from: o, reason: collision with root package name */
    public CastDevice f6607o;

    /* renamed from: p, reason: collision with root package name */
    public MediaSessionCompat f6608p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6609q;

    /* renamed from: r, reason: collision with root package name */
    public PlaybackStateCompat.CustomAction f6610r;

    /* renamed from: s, reason: collision with root package name */
    public PlaybackStateCompat.CustomAction f6611s;

    /* renamed from: t, reason: collision with root package name */
    public PlaybackStateCompat.CustomAction f6612t;

    /* renamed from: u, reason: collision with root package name */
    public PlaybackStateCompat.CustomAction f6613u;

    /* JADX WARN: Type inference failed for: r8v1, types: [com.google.android.gms.cast.framework.media.internal.zzp] */
    public zzv(Context context, CastOptions castOptions, zzbf zzbfVar) {
        NotificationOptions notificationOptions;
        this.f6593a = context;
        this.f6594b = castOptions;
        this.f6595c = zzbfVar;
        CastContext sharedInstance = CastContext.getSharedInstance();
        this.f6596d = sharedInstance != null ? sharedInstance.getSessionManager() : null;
        CastMediaOptions castMediaOptions = castOptions.getCastMediaOptions();
        this.f6597e = castMediaOptions == null ? null : castMediaOptions.getNotificationOptions();
        this.f6605m = new zzu(this);
        String expandedControllerActivityClassName = castMediaOptions == null ? null : castMediaOptions.getExpandedControllerActivityClassName();
        this.f6598f = !TextUtils.isEmpty(expandedControllerActivityClassName) ? new ComponentName(context, expandedControllerActivityClassName) : null;
        String mediaIntentReceiverClassName = castMediaOptions == null ? null : castMediaOptions.getMediaIntentReceiverClassName();
        this.f6599g = !TextUtils.isEmpty(mediaIntentReceiverClassName) ? new ComponentName(context, mediaIntentReceiverClassName) : null;
        zzb zzbVar = new zzb(context);
        this.f6600h = zzbVar;
        zzbVar.zzc(new zzq(this));
        zzb zzbVar2 = new zzb(context);
        this.f6601i = zzbVar2;
        zzbVar2.zzc(new zzr(this));
        this.f6603k = new zzed(Looper.getMainLooper());
        Logger logger = zzo.f6564w;
        CastMediaOptions castMediaOptions2 = castOptions.getCastMediaOptions();
        boolean z10 = false;
        if (castMediaOptions2 != null && (notificationOptions = castMediaOptions2.getNotificationOptions()) != null) {
            com.google.android.gms.cast.framework.media.zzg zzgVarZzm = notificationOptions.zzm();
            if (zzgVarZzm == null) {
                z10 = true;
            } else {
                List listZzf = zzw.zzf(zzgVarZzm);
                int[] iArrZzg = zzw.zzg(zzgVarZzm);
                int size = listZzf == null ? 0 : listZzf.size();
                Logger logger2 = zzo.f6564w;
                if (listZzf == null || listZzf.isEmpty()) {
                    logger2.e("NotificationActionsProvider".concat(" doesn't provide any action."), new Object[0]);
                } else if (listZzf.size() > 5) {
                    logger2.e("NotificationActionsProvider".concat(" provides more than 5 actions."), new Object[0]);
                } else if (iArrZzg == null || (iArrZzg.length) == 0) {
                    logger2.e("NotificationActionsProvider".concat(" doesn't provide any actions for compact view."), new Object[0]);
                } else {
                    for (int i10 : iArrZzg) {
                        if (i10 < 0 || i10 >= size) {
                            logger2.e("NotificationActionsProvider".concat("provides a compact view action whose index is out of bounds."), new Object[0]);
                            break;
                        }
                    }
                    z10 = true;
                }
            }
        }
        this.f6602j = z10 ? new zzo(context) : null;
        this.f6604l = new Runnable() { // from class: com.google.android.gms.cast.framework.media.internal.zzp
            @Override // java.lang.Runnable
            public final void run() {
                this.f6587b.f(false);
            }
        };
    }

    public static final boolean j(String str) {
        return TextUtils.equals(str, MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK) || TextUtils.equals(str, MediaIntentReceiver.ACTION_SKIP_PREV) || TextUtils.equals(str, MediaIntentReceiver.ACTION_SKIP_NEXT);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long a(int r5, java.lang.String r6, android.os.Bundle r7) {
        /*
            r4 = this;
            int r0 = r6.hashCode()
            r1 = -945151566(0xffffffffc7aa21b2, float:-87107.39)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L2a
            r1 = -945080078(0xffffffffc7ab38f2, float:-87665.89)
            if (r0 == r1) goto L20
            r1 = 235550565(0xe0a3765, float:1.7036485E-30)
            if (r0 == r1) goto L16
            goto L34
        L16:
            java.lang.String r0 = "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 0
            goto L35
        L20:
            java.lang.String r0 = "com.google.android.gms.cast.framework.action.SKIP_PREV"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 1
            goto L35
        L2a:
            java.lang.String r0 = "com.google.android.gms.cast.framework.action.SKIP_NEXT"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 2
            goto L35
        L34:
            r6 = -1
        L35:
            if (r6 == 0) goto L64
            r0 = 0
            if (r6 == r3) goto L51
            if (r6 == r2) goto L3e
            goto L70
        L3e:
            com.google.android.gms.cast.framework.media.RemoteMediaClient r5 = r4.f6606n
            if (r5 == 0) goto L4b
            boolean r5 = r5.zzt()
            if (r5 == 0) goto L4b
            r0 = 32
            goto L70
        L4b:
            java.lang.String r5 = "android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT"
            r7.putBoolean(r5, r3)
            return r0
        L51:
            com.google.android.gms.cast.framework.media.RemoteMediaClient r5 = r4.f6606n
            if (r5 == 0) goto L5e
            boolean r5 = r5.zzu()
            if (r5 == 0) goto L5e
            r0 = 16
            goto L70
        L5e:
            java.lang.String r5 = "android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS"
            r7.putBoolean(r5, r3)
            return r0
        L64:
            r6 = 3
            if (r5 != r6) goto L6b
            r0 = 514(0x202, double:2.54E-321)
            r5 = 3
            goto L6e
        L6b:
            r6 = 512(0x200, double:2.53E-321)
            r0 = r6
        L6e:
            if (r5 == r2) goto L71
        L70:
            return r0
        L71:
            r5 = 516(0x204, double:2.55E-321)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.internal.zzv.a(int, java.lang.String, android.os.Bundle):long");
    }

    public final Uri b(MediaMetadata mediaMetadata, int i10) {
        CastMediaOptions castMediaOptions = this.f6594b.getCastMediaOptions();
        ImagePicker imagePicker = castMediaOptions == null ? null : castMediaOptions.getImagePicker();
        WebImage webImageOnPickImage = imagePicker != null ? imagePicker.onPickImage(mediaMetadata, i10) : mediaMetadata.hasImages() ? mediaMetadata.getImages().get(0) : null;
        if (webImageOnPickImage == null) {
            return null;
        }
        return webImageOnPickImage.getUrl();
    }

    public final MediaMetadataCompat.Builder c() {
        MediaSessionCompat mediaSessionCompat = this.f6608p;
        MediaMetadataCompat metadata = mediaSessionCompat == null ? null : mediaSessionCompat.getController().getMetadata();
        return metadata == null ? new MediaMetadataCompat.Builder() : new MediaMetadataCompat.Builder(metadata);
    }

    public final void d(Bitmap bitmap, int i10) {
        MediaSessionCompat mediaSessionCompat = this.f6608p;
        if (mediaSessionCompat == null) {
            return;
        }
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            bitmap.eraseColor(0);
        }
        mediaSessionCompat.setMetadata(c().putBitmap(i10 == 0 ? MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON : MediaMetadataCompat.METADATA_KEY_ALBUM_ART, bitmap).build());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(android.support.v4.media.session.PlaybackStateCompat.Builder r11, java.lang.String r12, com.google.android.gms.cast.framework.media.NotificationAction r13) {
        /*
            r10 = this;
            int r0 = r12.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            java.lang.String r4 = "com.google.android.gms.cast.framework.action.FORWARD"
            java.lang.String r5 = "com.google.android.gms.cast.framework.action.DISCONNECT"
            java.lang.String r6 = "com.google.android.gms.cast.framework.action.STOP_CASTING"
            java.lang.String r7 = "com.google.android.gms.cast.framework.action.REWIND"
            switch(r0) {
                case -1699820260: goto L2b;
                case -668151673: goto L23;
                case -124479363: goto L1b;
                case 1362116196: goto L13;
                default: goto L12;
            }
        L12:
            goto L33
        L13:
            boolean r0 = r12.equals(r4)
            if (r0 == 0) goto L33
            r0 = 0
            goto L34
        L1b:
            boolean r0 = r12.equals(r5)
            if (r0 == 0) goto L33
            r0 = 3
            goto L34
        L23:
            boolean r0 = r12.equals(r6)
            if (r0 == 0) goto L33
            r0 = 2
            goto L34
        L2b:
            boolean r0 = r12.equals(r7)
            if (r0 == 0) goto L33
            r0 = 1
            goto L34
        L33:
            r0 = -1
        L34:
            android.content.Context r8 = r10.f6593a
            com.google.android.gms.cast.framework.media.NotificationOptions r9 = r10.f6597e
            if (r0 == 0) goto Lc9
            if (r0 == r3) goto La1
            if (r0 == r2) goto L7d
            if (r0 == r1) goto L58
            if (r13 == 0) goto L55
            android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder r0 = new android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder
            java.lang.String r1 = r13.getContentDescription()
            int r13 = r13.getIconResId()
            r0.<init>(r12, r1, r13)
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r12 = r0.build()
            goto Lf0
        L55:
            r12 = 0
            goto Lf0
        L58:
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r12 = r10.f6613u
            if (r12 != 0) goto L79
            if (r9 == 0) goto L79
            android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder r12 = new android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder
            android.content.res.Resources r13 = r8.getResources()
            int r0 = r9.zza()
            java.lang.String r13 = r13.getString(r0)
            int r0 = r9.getDisconnectDrawableResId()
            r12.<init>(r5, r13, r0)
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r12 = r12.build()
            r10.f6613u = r12
        L79:
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r12 = r10.f6613u
            goto Lf0
        L7d:
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r12 = r10.f6612t
            if (r12 != 0) goto L9e
            if (r9 == 0) goto L9e
            android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder r12 = new android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder
            android.content.res.Resources r13 = r8.getResources()
            int r0 = r9.zza()
            java.lang.String r13 = r13.getString(r0)
            int r0 = r9.getDisconnectDrawableResId()
            r12.<init>(r6, r13, r0)
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r12 = r12.build()
            r10.f6612t = r12
        L9e:
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r12 = r10.f6612t
            goto Lf0
        La1:
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r12 = r10.f6611s
            if (r12 != 0) goto Lc6
            if (r9 == 0) goto Lc6
            long r12 = r9.getSkipStepMs()
            int r0 = com.google.android.gms.cast.framework.media.internal.zzw.zzd(r9, r12)
            int r12 = com.google.android.gms.cast.framework.media.internal.zzw.zzc(r9, r12)
            android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder r13 = new android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder
            android.content.res.Resources r1 = r8.getResources()
            java.lang.String r0 = r1.getString(r0)
            r13.<init>(r7, r0, r12)
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r12 = r13.build()
            r10.f6611s = r12
        Lc6:
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r12 = r10.f6611s
            goto Lf0
        Lc9:
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r12 = r10.f6610r
            if (r12 != 0) goto Lee
            if (r9 == 0) goto Lee
            long r12 = r9.getSkipStepMs()
            int r0 = com.google.android.gms.cast.framework.media.internal.zzw.zzb(r9, r12)
            int r12 = com.google.android.gms.cast.framework.media.internal.zzw.zza(r9, r12)
            android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder r13 = new android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder
            android.content.res.Resources r1 = r8.getResources()
            java.lang.String r0 = r1.getString(r0)
            r13.<init>(r4, r0, r12)
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r12 = r13.build()
            r10.f6610r = r12
        Lee:
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r12 = r10.f6610r
        Lf0:
            if (r12 == 0) goto Lf5
            r11.addCustomAction(r12)
        Lf5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.internal.zzv.e(android.support.v4.media.session.PlaybackStateCompat$Builder, java.lang.String, com.google.android.gms.cast.framework.media.NotificationAction):void");
    }

    public final void f(boolean z10) {
        if (this.f6594b.getEnableReconnectionService()) {
            zzp zzpVar = this.f6604l;
            zzed zzedVar = this.f6603k;
            if (zzpVar != null) {
                zzedVar.removeCallbacks(zzpVar);
            }
            Context context = this.f6593a;
            Intent intent = new Intent(context, (Class<?>) ReconnectionService.class);
            intent.setPackage(context.getPackageName());
            try {
                context.startService(intent);
            } catch (IllegalStateException unused) {
                if (z10) {
                    zzedVar.postDelayed(zzpVar, 1000L);
                }
            }
        }
    }

    public final void g() {
        zzo zzoVar = this.f6602j;
        if (zzoVar != null) {
            f6592v.d("Stopping media notification.", new Object[0]);
            zzoVar.f6574j.zza();
            NotificationManager notificationManager = zzoVar.f6566b;
            if (notificationManager != null) {
                notificationManager.cancel("castMediaNotification", 1);
            }
        }
    }

    public final void h() {
        if (this.f6594b.getEnableReconnectionService()) {
            this.f6603k.removeCallbacks(this.f6604l);
            Context context = this.f6593a;
            Intent intent = new Intent(context, (Class<?>) ReconnectionService.class);
            intent.setPackage(context.getPackageName());
            context.stopService(intent);
        }
    }

    public final void i(MediaInfo mediaInfo, int i10) throws IllegalArgumentException {
        PlaybackStateCompat playbackStateCompatBuild;
        MediaSessionCompat mediaSessionCompat;
        MediaMetadata metadata;
        PendingIntent activity;
        MediaSessionCompat mediaSessionCompat2 = this.f6608p;
        if (mediaSessionCompat2 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        PlaybackStateCompat.Builder builder = new PlaybackStateCompat.Builder();
        RemoteMediaClient remoteMediaClient = this.f6606n;
        NotificationOptions notificationOptions = this.f6597e;
        if (remoteMediaClient == null || this.f6602j == null) {
            playbackStateCompatBuild = builder.build();
        } else {
            builder.setState(i10, (remoteMediaClient.zza() == 0 || remoteMediaClient.isLiveStream()) ? 0L : remoteMediaClient.getApproximateStreamPosition(), 1.0f);
            if (i10 == 0) {
                playbackStateCompatBuild = builder.build();
            } else {
                com.google.android.gms.cast.framework.media.zzg zzgVarZzm = notificationOptions != null ? notificationOptions.zzm() : null;
                RemoteMediaClient remoteMediaClient2 = this.f6606n;
                long jA = (remoteMediaClient2 == null || remoteMediaClient2.isLiveStream() || this.f6606n.isPlayingAd()) ? 0L : 256L;
                if (zzgVarZzm != null) {
                    List<NotificationAction> listZzf = zzw.zzf(zzgVarZzm);
                    if (listZzf != null) {
                        for (NotificationAction notificationAction : listZzf) {
                            String action = notificationAction.getAction();
                            if (j(action)) {
                                jA |= a(i10, action, bundle);
                            } else {
                                e(builder, action, notificationAction);
                            }
                        }
                    }
                } else if (notificationOptions != null) {
                    for (String str : notificationOptions.getActions()) {
                        if (j(str)) {
                            jA |= a(i10, str, bundle);
                        } else {
                            e(builder, str, null);
                        }
                    }
                }
                playbackStateCompatBuild = builder.setActions(jA).build();
            }
        }
        mediaSessionCompat2.setPlaybackState(playbackStateCompatBuild);
        if (notificationOptions != null && notificationOptions.zzp()) {
            bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", true);
        }
        if (notificationOptions != null && notificationOptions.zzo()) {
            bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", true);
        }
        if (bundle.containsKey("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS") || bundle.containsKey("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT")) {
            mediaSessionCompat2.setExtras(bundle);
        }
        if (i10 == 0) {
            mediaSessionCompat2.setMetadata(new MediaMetadataCompat.Builder().build());
            return;
        }
        if (this.f6606n != null) {
            ComponentName componentName = this.f6598f;
            if (componentName == null) {
                activity = null;
            } else {
                Intent intent = new Intent();
                intent.setComponent(componentName);
                activity = PendingIntent.getActivity(this.f6593a, 0, intent, zzdy.zza | 134217728);
            }
            if (activity != null) {
                mediaSessionCompat2.setSessionActivity(activity);
            }
        }
        if (this.f6606n == null || (mediaSessionCompat = this.f6608p) == null || mediaInfo == null || (metadata = mediaInfo.getMetadata()) == null) {
            return;
        }
        RemoteMediaClient remoteMediaClient3 = this.f6606n;
        long streamDuration = (remoteMediaClient3 == null || !remoteMediaClient3.isLiveStream()) ? mediaInfo.getStreamDuration() : 0L;
        String string = metadata.getString("com.google.android.gms.cast.metadata.TITLE");
        String string2 = metadata.getString("com.google.android.gms.cast.metadata.SUBTITLE");
        MediaMetadataCompat.Builder builderPutLong = c().putLong(MediaMetadataCompat.METADATA_KEY_DURATION, streamDuration);
        if (string != null) {
            builderPutLong.putString(MediaMetadataCompat.METADATA_KEY_TITLE, string);
            builderPutLong.putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE, string);
        }
        if (string2 != null) {
            builderPutLong.putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE, string2);
        }
        mediaSessionCompat.setMetadata(builderPutLong.build());
        Uri uriB = b(metadata, 0);
        if (uriB != null) {
            this.f6600h.zzd(uriB);
        } else {
            d(null, 0);
        }
        Uri uriB2 = b(metadata, 3);
        if (uriB2 != null) {
            this.f6601i.zzd(uriB2);
        } else {
            d(null, 3);
        }
    }

    public final void zzh(RemoteMediaClient remoteMediaClient, CastDevice castDevice) {
        ComponentName componentName;
        AudioManager audioManager;
        CastOptions castOptions = this.f6594b;
        CastMediaOptions castMediaOptions = castOptions == null ? null : castOptions.getCastMediaOptions();
        if (this.f6609q || castOptions == null || castMediaOptions == null || this.f6597e == null || remoteMediaClient == null || castDevice == null || (componentName = this.f6599g) == null) {
            f6592v.d("skip attaching media session", new Object[0]);
            return;
        }
        this.f6606n = remoteMediaClient;
        remoteMediaClient.registerCallback(this.f6605m);
        this.f6607o = castDevice;
        boolean zIsAtLeastLollipop = PlatformVersion.isAtLeastLollipop();
        Context context = this.f6593a;
        if (!zIsAtLeastLollipop && (audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO)) != null) {
            audioManager.requestAudioFocus(null, 3, 3);
        }
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(componentName);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, zzdy.zza);
        if (castMediaOptions.getMediaSessionEnabled()) {
            MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(context, "CastMediaSession", componentName, broadcast);
            this.f6608p = mediaSessionCompat;
            i(null, 0);
            CastDevice castDevice2 = this.f6607o;
            if (castDevice2 != null && !TextUtils.isEmpty(castDevice2.getFriendlyName())) {
                mediaSessionCompat.setMetadata(new MediaMetadataCompat.Builder().putString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST, context.getResources().getString(R.string.cast_casting_to_device, this.f6607o.getFriendlyName())).build());
            }
            mediaSessionCompat.setCallback(new zzs(this));
            mediaSessionCompat.setActive(true);
            this.f6595c.zzr(mediaSessionCompat);
        }
        this.f6609q = true;
        zzl(false);
    }

    public final void zzi(int i10) throws IllegalArgumentException {
        AudioManager audioManager;
        if (this.f6609q) {
            this.f6609q = false;
            RemoteMediaClient remoteMediaClient = this.f6606n;
            if (remoteMediaClient != null) {
                remoteMediaClient.unregisterCallback(this.f6605m);
            }
            if (!PlatformVersion.isAtLeastLollipop() && (audioManager = (AudioManager) this.f6593a.getSystemService(MimeTypes.BASE_TYPE_AUDIO)) != null) {
                audioManager.abandonAudioFocus(null);
            }
            this.f6595c.zzr(null);
            zzb zzbVar = this.f6600h;
            if (zzbVar != null) {
                zzbVar.zza();
            }
            zzb zzbVar2 = this.f6601i;
            if (zzbVar2 != null) {
                zzbVar2.zza();
            }
            MediaSessionCompat mediaSessionCompat = this.f6608p;
            if (mediaSessionCompat != null) {
                mediaSessionCompat.setCallback(null);
                this.f6608p.setMetadata(new MediaMetadataCompat.Builder().build());
                i(null, 0);
            }
            MediaSessionCompat mediaSessionCompat2 = this.f6608p;
            if (mediaSessionCompat2 != null) {
                mediaSessionCompat2.setActive(false);
                this.f6608p.release();
                this.f6608p = null;
            }
            this.f6606n = null;
            this.f6607o = null;
            g();
            if (i10 == 0) {
                h();
            }
        }
    }

    public final void zzk(CastDevice castDevice) {
        f6592v.i("update Cast device to %s", castDevice);
        this.f6607o = castDevice;
        zzl(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzl(boolean r23) throws java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.internal.zzv.zzl(boolean):void");
    }
}
