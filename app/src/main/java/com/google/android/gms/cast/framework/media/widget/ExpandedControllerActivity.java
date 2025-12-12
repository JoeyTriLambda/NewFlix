package com.google.android.gms.cast.framework.media.widget;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.cast.AdBreakClipInfo;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.internal.zzw;
import com.google.android.gms.cast.framework.media.uicontroller.UIMediaController;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzcr;
import com.google.android.gms.internal.cast.zzcu;
import com.google.android.gms.internal.cast.zzcv;
import com.google.android.gms.internal.cast.zzcw;
import com.google.android.gms.internal.cast.zzcx;
import com.google.android.gms.internal.cast.zzml;
import java.util.Timer;
import r.a;
import r.j;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public abstract class ExpandedControllerActivity extends j implements ControlButtonsContainer {

    /* renamed from: z0, reason: collision with root package name */
    public static final /* synthetic */ int f6650z0 = 0;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f6651a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f6652b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f6653c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f6654d0;

    /* renamed from: e0, reason: collision with root package name */
    public TextView f6655e0;

    /* renamed from: f0, reason: collision with root package name */
    public CastSeekBar f6656f0;

    /* renamed from: g0, reason: collision with root package name */
    public ImageView f6657g0;

    /* renamed from: h0, reason: collision with root package name */
    public ImageView f6658h0;

    /* renamed from: i0, reason: collision with root package name */
    public int[] f6659i0;

    /* renamed from: k0, reason: collision with root package name */
    public View f6661k0;

    /* renamed from: l0, reason: collision with root package name */
    public View f6662l0;

    /* renamed from: m0, reason: collision with root package name */
    public ImageView f6663m0;

    /* renamed from: n0, reason: collision with root package name */
    public TextView f6664n0;

    /* renamed from: o0, reason: collision with root package name */
    public TextView f6665o0;

    /* renamed from: p0, reason: collision with root package name */
    public TextView f6666p0;

    /* renamed from: q0, reason: collision with root package name */
    public TextView f6667q0;

    /* renamed from: r0, reason: collision with root package name */
    public com.google.android.gms.cast.framework.media.internal.zzb f6668r0;

    /* renamed from: s0, reason: collision with root package name */
    public UIMediaController f6669s0;

    /* renamed from: t0, reason: collision with root package name */
    public SessionManager f6670t0;

    /* renamed from: u0, reason: collision with root package name */
    public Cast.Listener f6671u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f6672v0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f6673w0;

    /* renamed from: x0, reason: collision with root package name */
    public Timer f6674x0;

    /* renamed from: y0, reason: collision with root package name */
    public String f6675y0;
    public final SessionManagerListener K = new zzr(this);
    public final RemoteMediaClient.Listener L = new zzp(this);

    /* renamed from: j0, reason: collision with root package name */
    public final ImageView[] f6660j0 = new ImageView[4];

    public final RemoteMediaClient d() {
        CastSession currentCastSession = this.f6670t0.getCurrentCastSession();
        if (currentCastSession == null || !currentCastSession.isConnected()) {
            return null;
        }
        return currentCastSession.getRemoteMediaClient();
    }

    public final void e(View view, int i10, int i11, UIMediaController uIMediaController) {
        ImageView imageView = (ImageView) view.findViewById(i10);
        if (i11 == R.id.cast_button_type_empty) {
            imageView.setVisibility(4);
            return;
        }
        if (i11 == R.id.cast_button_type_play_pause_toggle) {
            imageView.setBackgroundResource(this.M);
            Drawable drawableZzb = zzs.zzb(this, this.f6651a0, this.O);
            Drawable drawableZzb2 = zzs.zzb(this, this.f6651a0, this.N);
            Drawable drawableZzb3 = zzs.zzb(this, this.f6651a0, this.P);
            imageView.setImageDrawable(drawableZzb2);
            uIMediaController.bindImageViewToPlayPauseToggle(imageView, drawableZzb2, drawableZzb, drawableZzb3, null, false);
            return;
        }
        if (i11 == R.id.cast_button_type_skip_previous) {
            imageView.setBackgroundResource(this.M);
            imageView.setImageDrawable(zzs.zzb(this, this.f6651a0, this.Q));
            imageView.setContentDescription(getResources().getString(R.string.cast_skip_prev));
            uIMediaController.bindViewToSkipPrev(imageView, 0);
            return;
        }
        if (i11 == R.id.cast_button_type_skip_next) {
            imageView.setBackgroundResource(this.M);
            imageView.setImageDrawable(zzs.zzb(this, this.f6651a0, this.R));
            imageView.setContentDescription(getResources().getString(R.string.cast_skip_next));
            uIMediaController.bindViewToSkipNext(imageView, 0);
            return;
        }
        if (i11 == R.id.cast_button_type_rewind_30_seconds) {
            imageView.setBackgroundResource(this.M);
            imageView.setImageDrawable(zzs.zzb(this, this.f6651a0, this.S));
            imageView.setContentDescription(getResources().getString(R.string.cast_rewind_30));
            uIMediaController.bindViewToRewind(imageView, 30000L);
            return;
        }
        if (i11 == R.id.cast_button_type_forward_30_seconds) {
            imageView.setBackgroundResource(this.M);
            imageView.setImageDrawable(zzs.zzb(this, this.f6651a0, this.T));
            imageView.setContentDescription(getResources().getString(R.string.cast_forward_30));
            uIMediaController.bindViewToForward(imageView, 30000L);
            return;
        }
        if (i11 == R.id.cast_button_type_mute_toggle) {
            imageView.setBackgroundResource(this.M);
            imageView.setImageDrawable(zzs.zzb(this, this.f6651a0, this.U));
            uIMediaController.bindImageViewToMuteToggle(imageView);
        } else if (i11 == R.id.cast_button_type_closed_caption) {
            imageView.setBackgroundResource(this.M);
            imageView.setImageDrawable(zzs.zzb(this, this.f6651a0, this.V));
            uIMediaController.bindViewToClosedCaption(imageView);
        }
    }

    public final void f(RemoteMediaClient remoteMediaClient) {
        MediaStatus mediaStatus;
        if (this.f6672v0 || (mediaStatus = remoteMediaClient.getMediaStatus()) == null || remoteMediaClient.isBuffering()) {
            return;
        }
        this.f6666p0.setVisibility(8);
        this.f6667q0.setVisibility(8);
        AdBreakClipInfo currentAdBreakClip = mediaStatus.getCurrentAdBreakClip();
        if (currentAdBreakClip == null || currentAdBreakClip.getWhenSkippableInMs() == -1) {
            return;
        }
        if (!this.f6673w0) {
            zzk zzkVar = new zzk(this, remoteMediaClient);
            Timer timer = new Timer();
            this.f6674x0 = timer;
            timer.scheduleAtFixedRate(zzkVar, 0L, 500L);
            this.f6673w0 = true;
        }
        if (currentAdBreakClip.getWhenSkippableInMs() - remoteMediaClient.getApproximateAdBreakClipPositionMs() > 0.0f) {
            this.f6667q0.setVisibility(0);
            this.f6667q0.setText(getResources().getString(R.string.cast_expanded_controller_skip_ad_text, Integer.valueOf((int) Math.ceil(r10 / 1000.0f))));
            this.f6666p0.setClickable(false);
        } else {
            if (this.f6673w0) {
                this.f6674x0.cancel();
                this.f6673w0 = false;
            }
            this.f6666p0.setVisibility(0);
            this.f6666p0.setClickable(true);
        }
    }

    public final void g() {
        CastDevice castDevice;
        CastSession currentCastSession = this.f6670t0.getCurrentCastSession();
        if (currentCastSession != null && (castDevice = currentCastSession.getCastDevice()) != null) {
            String friendlyName = castDevice.getFriendlyName();
            if (!TextUtils.isEmpty(friendlyName)) {
                this.f6655e0.setText(getResources().getString(R.string.cast_casting_to_device, friendlyName));
                return;
            }
        }
        this.f6655e0.setText("");
    }

    public final void h() {
        MediaInfo mediaInfo;
        MediaMetadata metadata;
        a supportActionBar;
        RemoteMediaClient remoteMediaClientD = d();
        if (remoteMediaClientD == null || !remoteMediaClientD.hasMediaSession() || (mediaInfo = remoteMediaClientD.getMediaInfo()) == null || (metadata = mediaInfo.getMetadata()) == null || (supportActionBar = getSupportActionBar()) == null) {
            return;
        }
        supportActionBar.setTitle(metadata.getString("com.google.android.gms.cast.metadata.TITLE"));
        String strZze = zzw.zze(metadata);
        if (strZze != null) {
            supportActionBar.setSubtitle(strZze);
        }
    }

    @TargetApi(23)
    public final void i() {
        MediaStatus mediaStatus;
        String string;
        Drawable drawable;
        Bitmap bitmap;
        Bitmap bitmapZza;
        RemoteMediaClient remoteMediaClientD = d();
        if (remoteMediaClientD == null || (mediaStatus = remoteMediaClientD.getMediaStatus()) == null) {
            return;
        }
        String imageUrl = null;
        if (!mediaStatus.isPlayingAd()) {
            this.f6667q0.setVisibility(8);
            this.f6666p0.setVisibility(8);
            this.f6661k0.setVisibility(8);
            this.f6658h0.setVisibility(8);
            this.f6658h0.setImageBitmap(null);
            return;
        }
        if (this.f6658h0.getVisibility() == 8 && (drawable = this.f6657g0.getDrawable()) != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && (bitmapZza = zzs.zza(this, bitmap, 0.25f, 7.5f)) != null) {
            this.f6658h0.setImageBitmap(bitmapZza);
            this.f6658h0.setVisibility(0);
        }
        AdBreakClipInfo currentAdBreakClip = mediaStatus.getCurrentAdBreakClip();
        if (currentAdBreakClip != null) {
            String title = currentAdBreakClip.getTitle();
            imageUrl = currentAdBreakClip.getImageUrl();
            string = title;
        } else {
            string = null;
        }
        if (!TextUtils.isEmpty(imageUrl)) {
            this.f6668r0.zzd(Uri.parse(imageUrl));
            this.f6662l0.setVisibility(8);
        } else if (TextUtils.isEmpty(this.f6675y0)) {
            this.f6664n0.setVisibility(0);
            this.f6662l0.setVisibility(0);
            this.f6663m0.setVisibility(8);
        } else {
            this.f6668r0.zzd(Uri.parse(this.f6675y0));
            this.f6662l0.setVisibility(8);
        }
        TextView textView = this.f6665o0;
        if (TextUtils.isEmpty(string)) {
            string = getResources().getString(R.string.cast_ad_label);
        }
        textView.setText(string);
        if (PlatformVersion.isAtLeastM()) {
            this.f6665o0.setTextAppearance(this.f6652b0);
        } else {
            this.f6665o0.setTextAppearance(this, this.f6652b0);
        }
        this.f6661k0.setVisibility(0);
        f(remoteMediaClientD);
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalStateException, Resources.NotFoundException {
        super.onCreate(bundle);
        SessionManager sessionManager = CastContext.getSharedInstance(this).getSessionManager();
        this.f6670t0 = sessionManager;
        if (sessionManager.getCurrentCastSession() == null) {
            finish();
        }
        UIMediaController uIMediaController = new UIMediaController(this);
        this.f6669s0 = uIMediaController;
        uIMediaController.setPostRemoteMediaClientListener(this.L);
        setContentView(R.layout.cast_expanded_controller_activity);
        TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes(new int[]{androidx.appcompat.R.attr.selectableItemBackgroundBorderless});
        this.M = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = obtainStyledAttributes(null, R.styleable.CastExpandedController, R.attr.castExpandedControllerStyle, R.style.CastExpandedController);
        this.f6651a0 = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castButtonColor, 0);
        this.N = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castPlayButtonDrawable, 0);
        this.O = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castPauseButtonDrawable, 0);
        this.P = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castStopButtonDrawable, 0);
        this.Q = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castSkipPreviousButtonDrawable, 0);
        this.R = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castSkipNextButtonDrawable, 0);
        this.S = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castRewind30ButtonDrawable, 0);
        this.T = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castForward30ButtonDrawable, 0);
        this.U = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castMuteToggleButtonDrawable, 0);
        this.V = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castClosedCaptionsButtonDrawable, 0);
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castControlButtons, 0);
        if (resourceId != 0) {
            TypedArray typedArrayObtainTypedArray = getResources().obtainTypedArray(resourceId);
            Preconditions.checkArgument(typedArrayObtainTypedArray.length() == 4);
            this.f6659i0 = new int[typedArrayObtainTypedArray.length()];
            for (int i10 = 0; i10 < typedArrayObtainTypedArray.length(); i10++) {
                this.f6659i0[i10] = typedArrayObtainTypedArray.getResourceId(i10, 0);
            }
            typedArrayObtainTypedArray.recycle();
        } else {
            int i11 = R.id.cast_button_type_empty;
            this.f6659i0 = new int[]{i11, i11, i11, i11};
        }
        this.Z = typedArrayObtainStyledAttributes2.getColor(R.styleable.CastExpandedController_castExpandedControllerLoadingIndicatorColor, 0);
        this.W = getResources().getColor(typedArrayObtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castAdLabelColor, 0));
        this.X = getResources().getColor(typedArrayObtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castAdInProgressTextColor, 0));
        this.Y = getResources().getColor(typedArrayObtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castAdLabelTextColor, 0));
        this.f6652b0 = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castAdLabelTextAppearance, 0);
        this.f6653c0 = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castAdInProgressLabelTextAppearance, 0);
        this.f6654d0 = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castAdInProgressText, 0);
        int resourceId2 = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castDefaultAdPosterUrl, 0);
        if (resourceId2 != 0) {
            this.f6675y0 = getApplicationContext().getResources().getString(resourceId2);
        }
        typedArrayObtainStyledAttributes2.recycle();
        View viewFindViewById = findViewById(R.id.expanded_controller_layout);
        UIMediaController uIMediaController2 = this.f6669s0;
        this.f6657g0 = (ImageView) viewFindViewById.findViewById(R.id.background_image_view);
        this.f6658h0 = (ImageView) viewFindViewById.findViewById(R.id.blurred_background_image_view);
        View viewFindViewById2 = viewFindViewById.findViewById(R.id.background_place_holder_image_view);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        uIMediaController2.zzb(this.f6657g0, new ImageHints(4, displayMetrics.widthPixels, displayMetrics.heightPixels), viewFindViewById2, new zzn(this));
        this.f6655e0 = (TextView) viewFindViewById.findViewById(R.id.status_text);
        ProgressBar progressBar = (ProgressBar) viewFindViewById.findViewById(R.id.loading_indicator);
        Drawable indeterminateDrawable = progressBar.getIndeterminateDrawable();
        int i12 = this.Z;
        if (i12 != 0) {
            indeterminateDrawable.setColorFilter(i12, PorterDuff.Mode.SRC_IN);
        }
        uIMediaController2.bindViewToLoadingIndicator(progressBar);
        TextView textView = (TextView) viewFindViewById.findViewById(R.id.start_text);
        TextView textView2 = (TextView) viewFindViewById.findViewById(R.id.end_text);
        CastSeekBar castSeekBar = (CastSeekBar) viewFindViewById.findViewById(R.id.cast_seek_bar);
        this.f6656f0 = castSeekBar;
        uIMediaController2.bindSeekBar(castSeekBar, 1000L);
        uIMediaController2.bindViewToUIController(textView, new zzcw(textView, uIMediaController2.zza()));
        uIMediaController2.bindViewToUIController(textView2, new zzcu(textView2, uIMediaController2.zza()));
        View viewFindViewById3 = viewFindViewById.findViewById(R.id.live_indicators);
        uIMediaController2.bindViewToUIController(viewFindViewById3, new zzcv(viewFindViewById3, uIMediaController2.zza()));
        RelativeLayout relativeLayout = (RelativeLayout) viewFindViewById.findViewById(R.id.tooltip_container);
        zzcr zzcxVar = new zzcx(relativeLayout, this.f6656f0, uIMediaController2.zza());
        uIMediaController2.bindViewToUIController(relativeLayout, zzcxVar);
        uIMediaController2.zzf(zzcxVar);
        int i13 = R.id.button_0;
        ImageView imageView = (ImageView) viewFindViewById.findViewById(i13);
        ImageView[] imageViewArr = this.f6660j0;
        imageViewArr[0] = imageView;
        int i14 = R.id.button_1;
        imageViewArr[1] = (ImageView) viewFindViewById.findViewById(i14);
        int i15 = R.id.button_2;
        imageViewArr[2] = (ImageView) viewFindViewById.findViewById(i15);
        int i16 = R.id.button_3;
        imageViewArr[3] = (ImageView) viewFindViewById.findViewById(i16);
        e(viewFindViewById, i13, this.f6659i0[0], uIMediaController2);
        e(viewFindViewById, i14, this.f6659i0[1], uIMediaController2);
        e(viewFindViewById, R.id.button_play_pause_toggle, R.id.cast_button_type_play_pause_toggle, uIMediaController2);
        e(viewFindViewById, i15, this.f6659i0[2], uIMediaController2);
        e(viewFindViewById, i16, this.f6659i0[3], uIMediaController2);
        View viewFindViewById4 = findViewById(R.id.ad_container);
        this.f6661k0 = viewFindViewById4;
        this.f6663m0 = (ImageView) viewFindViewById4.findViewById(R.id.ad_image_view);
        this.f6662l0 = this.f6661k0.findViewById(R.id.ad_background_image_view);
        TextView textView3 = (TextView) this.f6661k0.findViewById(R.id.ad_label);
        this.f6665o0 = textView3;
        textView3.setTextColor(this.Y);
        this.f6665o0.setBackgroundColor(this.W);
        this.f6664n0 = (TextView) this.f6661k0.findViewById(R.id.ad_in_progress_label);
        this.f6667q0 = (TextView) findViewById(R.id.ad_skip_text);
        TextView textView4 = (TextView) findViewById(R.id.ad_skip_button);
        this.f6666p0 = textView4;
        textView4.setOnClickListener(new zzi(this));
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setHomeAsUpIndicator(R.drawable.quantum_ic_keyboard_arrow_down_white_36);
        }
        g();
        h();
        if (this.f6664n0 != null && this.f6654d0 != 0) {
            if (PlatformVersion.isAtLeastM()) {
                this.f6664n0.setTextAppearance(this.f6653c0);
            } else {
                this.f6664n0.setTextAppearance(getApplicationContext(), this.f6653c0);
            }
            this.f6664n0.setTextColor(this.X);
            this.f6664n0.setText(this.f6654d0);
        }
        com.google.android.gms.cast.framework.media.internal.zzb zzbVar = new com.google.android.gms.cast.framework.media.internal.zzb(getApplicationContext(), new ImageHints(-1, this.f6663m0.getWidth(), this.f6663m0.getHeight()));
        this.f6668r0 = zzbVar;
        zzbVar.zzc(new zzh(this));
        com.google.android.gms.internal.cast.zzo.zzd(zzml.CAF_EXPANDED_CONTROLLER);
    }

    @Override // r.j, androidx.fragment.app.p, android.app.Activity
    public void onDestroy() {
        this.f6668r0.zza();
        UIMediaController uIMediaController = this.f6669s0;
        if (uIMediaController != null) {
            uIMediaController.setPostRemoteMediaClientListener(null);
            this.f6669s0.dispose();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        finish();
        return true;
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public void onPause() {
        SessionManager sessionManager = this.f6670t0;
        if (sessionManager == null) {
            return;
        }
        CastSession currentCastSession = sessionManager.getCurrentCastSession();
        Cast.Listener listener = this.f6671u0;
        if (listener != null && currentCastSession != null) {
            currentCastSession.removeCastListener(listener);
            this.f6671u0 = null;
        }
        this.f6670t0.removeSessionManagerListener(this.K, CastSession.class);
        super.onPause();
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public void onResume() throws NullPointerException {
        SessionManager sessionManager = this.f6670t0;
        if (sessionManager == null) {
            return;
        }
        sessionManager.addSessionManagerListener(this.K, CastSession.class);
        CastSession currentCastSession = this.f6670t0.getCurrentCastSession();
        if (currentCastSession == null || !(currentCastSession.isConnected() || currentCastSession.isConnecting())) {
            finish();
        } else {
            zzl zzlVar = new zzl(this);
            this.f6671u0 = zzlVar;
            currentCastSession.addCastListener(zzlVar);
        }
        RemoteMediaClient remoteMediaClientD = d();
        boolean z10 = true;
        if (remoteMediaClientD != null && remoteMediaClientD.hasMediaSession()) {
            z10 = false;
        }
        this.f6672v0 = z10;
        g();
        i();
        super.onResume();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility() ^ 2;
            if (PlatformVersion.isAtLeastJellyBean()) {
                systemUiVisibility ^= 4;
            }
            if (PlatformVersion.isAtLeastKitKat()) {
                systemUiVisibility ^= 4096;
            }
            getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility);
            setImmersive(true);
        }
    }
}
