package com.google.android.gms.cast.framework.media.uicontroller;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.g0;
import androidx.fragment.app.p;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.TracksChooserDialogFragment;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzbt;
import com.google.android.gms.internal.cast.zzbu;
import com.google.android.gms.internal.cast.zzbv;
import com.google.android.gms.internal.cast.zzbz;
import com.google.android.gms.internal.cast.zzca;
import com.google.android.gms.internal.cast.zzcb;
import com.google.android.gms.internal.cast.zzcc;
import com.google.android.gms.internal.cast.zzce;
import com.google.android.gms.internal.cast.zzcg;
import com.google.android.gms.internal.cast.zzch;
import com.google.android.gms.internal.cast.zzci;
import com.google.android.gms.internal.cast.zzcj;
import com.google.android.gms.internal.cast.zzcm;
import com.google.android.gms.internal.cast.zzcn;
import com.google.android.gms.internal.cast.zzco;
import com.google.android.gms.internal.cast.zzcr;
import com.google.android.gms.internal.cast.zzct;
import com.google.android.gms.internal.cast.zzml;
import com.google.android.gms.internal.cast.zzo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public class UIMediaController implements RemoteMediaClient.Listener, SessionManagerListener<CastSession> {

    /* renamed from: h, reason: collision with root package name */
    public static final Logger f6615h = new Logger("UIMediaController");

    /* renamed from: a, reason: collision with root package name */
    public final Activity f6616a;

    /* renamed from: b, reason: collision with root package name */
    public final SessionManager f6617b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f6618c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f6619d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    public final zza f6620e = zza.zzf();

    /* renamed from: f, reason: collision with root package name */
    public RemoteMediaClient.Listener f6621f;

    /* renamed from: g, reason: collision with root package name */
    public RemoteMediaClient f6622g;

    public UIMediaController(Activity activity) throws IllegalStateException, NullPointerException {
        this.f6616a = activity;
        CastContext castContextZza = CastContext.zza(activity);
        zzo.zzd(zzml.UI_MEDIA_CONTROLLER);
        SessionManager sessionManager = castContextZza != null ? castContextZza.getSessionManager() : null;
        this.f6617b = sessionManager;
        if (sessionManager != null) {
            sessionManager.addSessionManagerListener(this, CastSession.class);
            b(sessionManager.getCurrentCastSession());
        }
    }

    public final void a() {
        if (isActive()) {
            this.f6620e.f6623a = null;
            Iterator it = this.f6618c.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((List) it.next()).iterator();
                while (it2.hasNext()) {
                    ((UIController) it2.next()).onSessionEnded();
                }
            }
            Preconditions.checkNotNull(this.f6622g);
            this.f6622g.removeListener(this);
            this.f6622g = null;
        }
    }

    public final void b(Session session) {
        if (isActive() || session == null || !session.isConnected()) {
            return;
        }
        CastSession castSession = (CastSession) session;
        RemoteMediaClient remoteMediaClient = castSession.getRemoteMediaClient();
        this.f6622g = remoteMediaClient;
        if (remoteMediaClient != null) {
            remoteMediaClient.addListener(this);
            zza zzaVar = this.f6620e;
            Preconditions.checkNotNull(zzaVar);
            zzaVar.f6623a = castSession.getRemoteMediaClient();
            Iterator it = this.f6618c.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((List) it.next()).iterator();
                while (it2.hasNext()) {
                    ((UIController) it2.next()).onSessionConnected(castSession);
                }
            }
            f();
        }
    }

    public void bindImageViewToImageOfCurrentItem(ImageView imageView, ImageHints imageHints, int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        e(imageView, new zzca(imageView, this.f6616a, imageHints, i10, null, null));
    }

    public void bindImageViewToMuteToggle(ImageView imageView) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        imageView.setOnClickListener(new zzb(this));
        e(imageView, new zzcg(imageView, this.f6616a));
    }

    public void bindImageViewToPlayPauseToggle(ImageView imageView, Drawable drawable, Drawable drawable2, Drawable drawable3, View view, boolean z10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzo.zzd(zzml.PAUSE_CONTROLLER);
        imageView.setOnClickListener(new zzc(this));
        e(imageView, new zzch(imageView, this.f6616a, drawable, drawable2, drawable3, view, z10));
    }

    public void bindProgressBar(ProgressBar progressBar) {
        bindProgressBar(progressBar, 1000L);
    }

    public void bindSeekBar(CastSeekBar castSeekBar, long j10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzo.zzd(zzml.SEEK_CONTROLLER);
        castSeekBar.f6640q = new zzh(this);
        e(castSeekBar, new zzbt(castSeekBar, j10, this.f6620e));
    }

    public void bindTextViewToMetadataOfCurrentItem(TextView textView, String str) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        bindTextViewToMetadataOfCurrentItem(textView, Collections.singletonList(str));
    }

    public void bindTextViewToSmartSubtitle(TextView textView) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        e(textView, new zzco(textView));
    }

    public void bindViewToClosedCaption(View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzk(this));
        e(view, new zzbu(view, this.f6616a));
    }

    public void bindViewToForward(View view, long j10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzf(this, j10));
        e(view, new zzbv(view, this.f6620e));
    }

    public void bindViewToLaunchExpandedController(View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzj(this));
        e(view, new zzcb(view));
    }

    public void bindViewToLoadingIndicator(View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        e(view, new zzcc(view));
    }

    public void bindViewToRewind(View view, long j10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzg(this, j10));
        e(view, new zzcj(view, this.f6620e));
    }

    public void bindViewToSkipNext(View view, int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzd(this));
        e(view, new zzcm(view, i10));
    }

    public void bindViewToSkipPrev(View view, int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zze(this));
        e(view, new zzcn(view, i10));
    }

    public void bindViewToUIController(View view, UIController uIController) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        e(view, uIController);
    }

    public void bindViewVisibilityToMediaSession(View view, int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        e(view, new zzct(view, i10));
    }

    public final void c(int i10, boolean z10) {
        if (z10) {
            Iterator it = this.f6619d.iterator();
            while (it.hasNext()) {
                ((zzcr) it.next()).zzb(this.f6620e.zze() + i10);
            }
        }
    }

    public final void d(int i10) {
        Iterator it = this.f6619d.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else {
                ((zzcr) it.next()).zza(true);
            }
        }
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return;
        }
        long j10 = i10;
        zza zzaVar = this.f6620e;
        long jZze = zzaVar.zze() + j10;
        MediaSeekOptions.Builder builder = new MediaSeekOptions.Builder();
        builder.setPosition(jZze);
        builder.setIsSeekToInfinite(remoteMediaClient.isLiveStream() && zzaVar.zzn(jZze));
        remoteMediaClient.seek(builder.build());
    }

    public void dispose() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        a();
        this.f6618c.clear();
        SessionManager sessionManager = this.f6617b;
        if (sessionManager != null) {
            sessionManager.removeSessionManagerListener(this, CastSession.class);
        }
        this.f6621f = null;
    }

    public final void e(View view, UIController uIController) {
        SessionManager sessionManager = this.f6617b;
        if (sessionManager == null) {
            return;
        }
        HashMap map = this.f6618c;
        List arrayList = (List) map.get(view);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(view, arrayList);
        }
        arrayList.add(uIController);
        if (isActive()) {
            uIController.onSessionConnected((CastSession) Preconditions.checkNotNull(sessionManager.getCurrentCastSession()));
            f();
        }
    }

    public final void f() {
        Iterator it = this.f6618c.values().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
                ((UIController) it2.next()).onMediaStatusUpdated();
            }
        }
    }

    public RemoteMediaClient getRemoteMediaClient() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.f6622g;
    }

    public boolean isActive() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.f6622g != null;
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public void onAdBreakStatusUpdated() {
        f();
        RemoteMediaClient.Listener listener = this.f6621f;
        if (listener != null) {
            listener.onAdBreakStatusUpdated();
        }
    }

    public void onClosedCaptionClicked(View view) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return;
        }
        Activity activity = this.f6616a;
        if (activity instanceof p) {
            TracksChooserDialogFragment tracksChooserDialogFragmentNewInstance = TracksChooserDialogFragment.newInstance();
            p pVar = (p) activity;
            g0 g0VarBeginTransaction = pVar.getSupportFragmentManager().beginTransaction();
            Fragment fragmentFindFragmentByTag = pVar.getSupportFragmentManager().findFragmentByTag("TRACKS_CHOOSER_DIALOG_TAG");
            if (fragmentFindFragmentByTag != null) {
                g0VarBeginTransaction.remove(fragmentFindFragmentByTag);
            }
            tracksChooserDialogFragmentNewInstance.show(g0VarBeginTransaction, "TRACKS_CHOOSER_DIALOG_TAG");
        }
    }

    public void onForwardClicked(View view, long j10) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return;
        }
        if (!remoteMediaClient.zzw()) {
            remoteMediaClient.seek(remoteMediaClient.getApproximateStreamPosition() + j10);
            return;
        }
        remoteMediaClient.seek(Math.min(remoteMediaClient.getApproximateStreamPosition() + j10, this.f6620e.zze() + r6.zzc()));
    }

    public void onLaunchExpandedControllerClicked(View view) {
        Activity activity = this.f6616a;
        CastMediaOptions castMediaOptions = CastContext.getSharedInstance(activity).getCastOptions().getCastMediaOptions();
        if (castMediaOptions == null || TextUtils.isEmpty(castMediaOptions.getExpandedControllerActivityClassName())) {
            return;
        }
        ComponentName componentName = new ComponentName(activity.getApplicationContext(), castMediaOptions.getExpandedControllerActivityClassName());
        Intent intent = new Intent();
        intent.setComponent(componentName);
        activity.startActivity(intent);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public void onMetadataUpdated() {
        f();
        RemoteMediaClient.Listener listener = this.f6621f;
        if (listener != null) {
            listener.onMetadataUpdated();
        }
    }

    public void onMuteToggleClicked(ImageView imageView) {
        CastSession currentCastSession = CastContext.getSharedInstance(this.f6616a.getApplicationContext()).getSessionManager().getCurrentCastSession();
        if (currentCastSession == null || !currentCastSession.isConnected()) {
            return;
        }
        try {
            currentCastSession.setMute(!currentCastSession.isMute());
        } catch (IOException | IllegalArgumentException e10) {
            f6615h.e("Unable to call CastSession.setMute(boolean).", e10);
        }
    }

    public void onPlayPauseToggleClicked(ImageView imageView) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return;
        }
        remoteMediaClient.togglePlayback();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public void onPreloadStatusUpdated() {
        f();
        RemoteMediaClient.Listener listener = this.f6621f;
        if (listener != null) {
            listener.onPreloadStatusUpdated();
        }
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public void onQueueStatusUpdated() {
        f();
        RemoteMediaClient.Listener listener = this.f6621f;
        if (listener != null) {
            listener.onQueueStatusUpdated();
        }
    }

    public void onRewindClicked(View view, long j10) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return;
        }
        if (!remoteMediaClient.zzw()) {
            remoteMediaClient.seek(remoteMediaClient.getApproximateStreamPosition() - j10);
            return;
        }
        remoteMediaClient.seek(Math.max(remoteMediaClient.getApproximateStreamPosition() - j10, this.f6620e.zze() + r6.zzd()));
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public void onSendingRemoteMediaRequest() {
        Iterator it = this.f6618c.values().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
                ((UIController) it2.next()).onSendingRemoteMediaRequest();
            }
        }
        RemoteMediaClient.Listener listener = this.f6621f;
        if (listener != null) {
            listener.onSendingRemoteMediaRequest();
        }
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionEnded(CastSession castSession, int i10) {
        a();
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionEnding(CastSession castSession) {
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionResumeFailed(CastSession castSession, int i10) {
        a();
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionResumed(CastSession castSession, boolean z10) {
        b(castSession);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionResuming(CastSession castSession, String str) {
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionStartFailed(CastSession castSession, int i10) {
        a();
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionStarted(CastSession castSession, String str) {
        b(castSession);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionStarting(CastSession castSession) {
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionSuspended(CastSession castSession, int i10) {
    }

    public void onSkipNextClicked(View view) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return;
        }
        remoteMediaClient.queueNext(null);
    }

    public void onSkipPrevClicked(View view) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return;
        }
        remoteMediaClient.queuePrev(null);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public void onStatusUpdated() {
        f();
        RemoteMediaClient.Listener listener = this.f6621f;
        if (listener != null) {
            listener.onStatusUpdated();
        }
    }

    public void setPostRemoteMediaClientListener(RemoteMediaClient.Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.f6621f = listener;
    }

    public final zza zza() {
        return this.f6620e;
    }

    public final void zzb(ImageView imageView, ImageHints imageHints, View view, zzbz zzbzVar) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        e(imageView, new zzca(imageView, this.f6616a, imageHints, 0, view, zzbzVar));
    }

    public final void zzc(CastSeekBar castSeekBar, int i10, boolean z10) {
        c(i10, z10);
    }

    public final void zzd(CastSeekBar castSeekBar) {
        Iterator it = this.f6619d.iterator();
        while (it.hasNext()) {
            ((zzcr) it.next()).zza(false);
        }
    }

    public final void zze(CastSeekBar castSeekBar) {
        d(castSeekBar.getProgress());
    }

    public final void zzf(zzcr zzcrVar) {
        this.f6619d.add(zzcrVar);
    }

    public void bindProgressBar(ProgressBar progressBar, long j10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        e(progressBar, new zzci(progressBar, j10));
    }

    public void bindTextViewToMetadataOfCurrentItem(TextView textView, List<String> list) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        e(textView, new zzce(textView, list));
    }
}
