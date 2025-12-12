package flix.com.vision.exomedia.ui.widget;

import ad.e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.unity3d.services.core.device.MimeTypes;
import flix.com.vision.R;
import flix.com.vision.exomedia.ExoMedia$RendererType;
import flix.com.vision.exomedia.core.video.scale.ScaleType;
import java.util.Map;
import nc.c;
import u5.o;
import xc.f;

/* loaded from: classes2.dex */
public class VideoView extends RelativeLayout {

    /* renamed from: b, reason: collision with root package name */
    public zc.a f12240b;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f12241m;

    /* renamed from: n, reason: collision with root package name */
    public Uri f12242n;

    /* renamed from: o, reason: collision with root package name */
    public oc.a f12243o;

    /* renamed from: p, reason: collision with root package name */
    public final ad.a f12244p;

    /* renamed from: q, reason: collision with root package name */
    public AudioManager f12245q;

    /* renamed from: r, reason: collision with root package name */
    public final b f12246r;

    /* renamed from: s, reason: collision with root package name */
    public long f12247s;

    /* renamed from: t, reason: collision with root package name */
    public final long f12248t;

    /* renamed from: u, reason: collision with root package name */
    public final e f12249u;

    /* renamed from: v, reason: collision with root package name */
    public c f12250v;

    /* renamed from: w, reason: collision with root package name */
    public nc.c f12251w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f12252x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f12253y;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f12254a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12255b;

        /* renamed from: c, reason: collision with root package name */
        public final int f12256c;

        /* renamed from: d, reason: collision with root package name */
        public final ScaleType f12257d;

        /* renamed from: e, reason: collision with root package name */
        public final Boolean f12258e;

        public a(VideoView videoView, Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes;
            this.f12254a = false;
            int i10 = R.layout.exomedia_default_exo_texture_video_view;
            this.f12255b = R.layout.exomedia_default_exo_texture_video_view;
            int i11 = R.layout.exomedia_default_native_texture_video_view;
            this.f12256c = R.layout.exomedia_default_native_texture_video_view;
            if (attributeSet == null || (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VideoView)) == null) {
                return;
            }
            this.f12254a = typedArrayObtainStyledAttributes.getBoolean(1, false);
            boolean z10 = typedArrayObtainStyledAttributes.getBoolean(2, false);
            if (typedArrayObtainStyledAttributes.hasValue(3)) {
                this.f12257d = ScaleType.fromOrdinal(typedArrayObtainStyledAttributes.getInt(3, -1));
            }
            if (typedArrayObtainStyledAttributes.hasValue(0)) {
                this.f12258e = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(0, false));
            }
            i10 = z10 ? i10 : R.layout.exomedia_default_exo_surface_video_view;
            this.f12255b = i10;
            i11 = z10 ? i11 : R.layout.exomedia_default_native_surface_video_view;
            this.f12256c = i11;
            this.f12255b = typedArrayObtainStyledAttributes.getResourceId(4, i10);
            this.f12256c = typedArrayObtainStyledAttributes.getResourceId(5, i11);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public class b implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public boolean f12259a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f12260b = false;

        /* renamed from: c, reason: collision with root package name */
        public int f12261c = 0;

        public b() {
        }

        public boolean abandonFocus() {
            VideoView videoView = VideoView.this;
            if (!videoView.f12253y) {
                return true;
            }
            AudioManager audioManager = videoView.f12245q;
            if (audioManager == null) {
                return false;
            }
            this.f12259a = false;
            return 1 == audioManager.abandonAudioFocus(this);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i10) {
            VideoView videoView = VideoView.this;
            if (!videoView.f12253y || this.f12261c == i10) {
                return;
            }
            this.f12261c = i10;
            if (i10 == -3 || i10 == -2) {
                if (videoView.isPlaying()) {
                    this.f12260b = true;
                    videoView.pause(true);
                    return;
                }
                return;
            }
            if (i10 == -1) {
                if (videoView.isPlaying()) {
                    this.f12260b = true;
                    videoView.pause();
                    return;
                }
                return;
            }
            if (i10 == 1 || i10 == 2) {
                if (this.f12259a || this.f12260b) {
                    videoView.start();
                    this.f12259a = false;
                    this.f12260b = false;
                }
            }
        }

        public boolean requestFocus() {
            VideoView videoView = VideoView.this;
            if (!videoView.f12253y || this.f12261c == 1) {
                return true;
            }
            AudioManager audioManager = videoView.f12245q;
            if (audioManager == null) {
                return false;
            }
            if (1 == audioManager.requestAudioFocus(this, 3, 1)) {
                this.f12261c = 1;
                return true;
            }
            this.f12259a = true;
            return false;
        }
    }

    public class c extends c.a {

        /* renamed from: a, reason: collision with root package name */
        public f f12263a;

        public c() {
        }

        @Override // nc.c.a
        public void onExoPlayerError(pc.a aVar) {
            VideoView.this.stopPlayback();
            if (aVar != null) {
                aVar.forcePrepare();
            }
        }

        @Override // nc.c.a
        public void onMediaPlaybackEnded() {
            VideoView videoView = VideoView.this;
            videoView.setKeepScreenOn(false);
            videoView.onPlaybackEnded();
        }

        @Override // nc.c.a
        public void onPrepared() {
            VideoView videoView = VideoView.this;
            zc.a aVar = videoView.f12240b;
            if (aVar != null) {
                aVar.setDuration(videoView.getDuration());
                videoView.f12240b.finishLoading();
            }
        }

        @Override // nc.c.a
        public void onPreviewImageStateChanged(boolean z10) {
            ImageView imageView = VideoView.this.f12241m;
            if (imageView != null) {
                imageView.setVisibility(z10 ? 0 : 8);
            }
        }

        @Override // nc.c.a
        public void onSeekComplete() {
            zc.a aVar = VideoView.this.f12240b;
            if (aVar != null) {
                aVar.finishLoading();
            }
        }

        @Override // nc.c.a
        public void onVideoSizeChanged(int i10, int i11, int i12) {
            VideoView videoView = VideoView.this;
            videoView.f12243o.setVideoRotation(i12, false);
            videoView.f12243o.onVideoSizeChanged(i10, i11);
            f fVar = this.f12263a;
            if (fVar != null) {
                fVar.onVideoSizeChanged(i10, i11);
            }
        }

        @Override // nc.c.a
        public boolean shouldNotifyCompletion(long j10) {
            VideoView videoView = VideoView.this;
            return videoView.getCurrentPosition() + j10 >= videoView.getDuration();
        }
    }

    public class d extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {

        /* renamed from: b, reason: collision with root package name */
        public final GestureDetector f12265b;

        public d(Context context) {
            this.f12265b = new GestureDetector(context, this);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            VideoView videoView = VideoView.this;
            zc.a aVar = videoView.f12240b;
            if (aVar == null || !aVar.isVisible()) {
                videoView.showControls();
                return true;
            }
            videoView.f12240b.hide();
            return true;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f12265b.onTouchEvent(motionEvent);
            return true;
        }
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12244p = new ad.a();
        this.f12246r = new b();
        this.f12247s = 0L;
        this.f12248t = -1L;
        this.f12249u = new e();
        this.f12250v = new c();
        this.f12252x = true;
        this.f12253y = true;
        setup(context, attributeSet);
    }

    public Map<ExoMedia$RendererType, o> getAvailableTracks() {
        return this.f12243o.getAvailableTracks();
    }

    public Bitmap getBitmap() {
        Object obj = this.f12243o;
        if (obj instanceof TextureView) {
            return ((TextureView) obj).getBitmap();
        }
        return null;
    }

    public int getBufferPercentage() {
        return this.f12243o.getBufferedPercent();
    }

    public long getCurrentPosition() {
        return this.f12243o.getCurrentPosition() + this.f12247s;
    }

    public long getDuration() {
        long j10 = this.f12248t;
        return j10 >= 0 ? j10 : this.f12243o.getDuration();
    }

    public ImageView getPreviewImageView() {
        return this.f12241m;
    }

    public zc.a getVideoControls() {
        return this.f12240b;
    }

    public Uri getVideoUri() {
        return this.f12242n;
    }

    public int getVideoViewApiImplementation(Context context, a aVar) {
        return this.f12244p.supportsExoPlayer(context) ^ true ? aVar.f12256c : aVar.f12255b;
    }

    public void inflateVideoView(Context context, a aVar) {
        View.inflate(context, R.layout.exomedia_video_view_layout, this);
        ViewStub viewStub = (ViewStub) findViewById(R.id.video_view_api_impl_stub);
        viewStub.setLayoutResource(getVideoViewApiImplementation(context, aVar));
        viewStub.inflate();
    }

    public void initView(Context context, a aVar) {
        inflateVideoView(context, aVar);
        this.f12241m = (ImageView) findViewById(R.id.exomedia_video_preview_image);
        this.f12243o = (oc.a) findViewById(R.id.exomedia_video_view);
        c cVar = new c();
        this.f12250v = cVar;
        nc.c cVar2 = new nc.c(cVar);
        this.f12251w = cVar2;
        this.f12243o.setListenerMux(cVar2);
    }

    public boolean isPlaying() {
        return this.f12243o.isPlaying();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (isInEditMode() || !this.f12252x) {
            return;
        }
        release();
    }

    public void onPlaybackEnded() {
        stopPlayback(false);
    }

    public void pause() {
        pause(false);
    }

    public void postInit(a aVar) {
        if (aVar.f12254a) {
            setControls(this.f12244p.isDeviceTV(getContext()) ? new zc.b(getContext()) : new zc.c(getContext()));
        }
        ScaleType scaleType = aVar.f12257d;
        if (scaleType != null) {
            setScaleType(scaleType);
        }
        Boolean bool = aVar.f12258e;
        if (bool != null) {
            setMeasureBasedOnAspectRatioEnabled(bool.booleanValue());
        }
    }

    public void release() {
        this.f12240b = null;
        stopPlayback();
        this.f12249u.stop();
        this.f12243o.release();
    }

    public void reset() {
        stopPlayback();
        setVideoURI(null);
    }

    public void seekTo(long j10) {
        zc.a aVar = this.f12240b;
        if (aVar != null) {
            aVar.showLoading(false);
        }
        this.f12243o.seekTo(j10);
    }

    public void setControls(zc.a aVar) {
        zc.a aVar2 = this.f12240b;
        if (aVar2 != null && aVar2 != aVar) {
            removeView(aVar2);
        }
        if (aVar != null) {
            this.f12240b = aVar;
            aVar.setVideoView(this);
            addView(aVar);
        }
        d dVar = new d(getContext());
        if (this.f12240b == null) {
            dVar = null;
        }
        setOnTouchListener(dVar);
    }

    public void setDrmCallback(com.google.android.exoplayer2.drm.f fVar) {
        this.f12243o.setDrmCallback(fVar);
    }

    public void setHandleAudioFocus(boolean z10) {
        this.f12246r.abandonFocus();
        this.f12253y = z10;
    }

    public void setId3MetadataListener(qc.b bVar) {
        this.f12251w.setMetadataListener(bVar);
    }

    public void setMeasureBasedOnAspectRatioEnabled(boolean z10) {
        this.f12243o.setMeasureBasedOnAspectRatioEnabled(z10);
    }

    public void setOnBufferUpdateListener(xc.a aVar) {
        this.f12251w.setOnBufferUpdateListener(aVar);
    }

    public void setOnCompletionListener(xc.b bVar) {
        this.f12251w.setOnCompletionListener(bVar);
    }

    public void setOnErrorListener(xc.c cVar) {
        this.f12251w.setOnErrorListener(cVar);
    }

    public void setOnExoErrorListener(xc.c cVar) {
        this.f12251w.setOnExoErrorListener(cVar);
    }

    public void setOnPreparedListener(xc.d dVar) {
        this.f12251w.setOnPreparedListener(dVar);
    }

    public void setOnSeekCompletionListener(xc.e eVar) {
        this.f12251w.setOnSeekCompletionListener(eVar);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f12243o.setOnTouchListener(onTouchListener);
        super.setOnTouchListener(onTouchListener);
    }

    public void setOnVideoBufferingListener1(qc.a aVar) {
        this.f12251w.setOnExoBufferUpdateListener(aVar);
    }

    public void setOnVideoSizedChangedListener(f fVar) {
        this.f12250v.f12263a = fVar;
    }

    public void setPositionOffset(long j10) {
        this.f12247s = j10;
    }

    public void setPreviewImage(Drawable drawable) {
        ImageView imageView = this.f12241m;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setReleaseOnDetachFromWindow(boolean z10) {
        this.f12252x = z10;
    }

    public void setScaleType(ScaleType scaleType) {
        this.f12243o.setScaleType(scaleType);
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoRotation(int i10) {
        this.f12243o.setVideoRotation(i10, true);
    }

    public void setVideoURI(Uri uri) {
        this.f12242n = uri;
        this.f12243o.setVideoUri(uri);
        zc.a aVar = this.f12240b;
        if (aVar != null) {
            aVar.showLoading(true);
        }
    }

    public boolean setVolume(float f10) {
        return this.f12243o.setVolume(f10);
    }

    public void setup(Context context, AttributeSet attributeSet) {
        if (isInEditMode()) {
            return;
        }
        this.f12245q = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        a aVar = new a(this, context, attributeSet);
        initView(context, aVar);
        postInit(aVar);
    }

    public void showControls() {
        zc.a aVar = this.f12240b;
        if (aVar != null) {
            aVar.show();
            if (isPlaying()) {
                this.f12240b.hideDelayed();
            }
        }
    }

    public void start() {
        if (this.f12246r.requestFocus()) {
            this.f12243o.start();
            setKeepScreenOn(true);
            zc.a aVar = this.f12240b;
            if (aVar != null) {
                aVar.updatePlaybackState(true);
            }
        }
    }

    public void stopPlayback() {
        stopPlayback(true);
    }

    public void pause(boolean z10) {
        if (!z10) {
            this.f12246r.abandonFocus();
        }
        this.f12243o.pause();
        setKeepScreenOn(false);
        zc.a aVar = this.f12240b;
        if (aVar != null) {
            aVar.updatePlaybackState(false);
        }
    }

    public void stopPlayback(boolean z10) {
        this.f12246r.abandonFocus();
        this.f12243o.stopPlayback(z10);
        setKeepScreenOn(false);
        zc.a aVar = this.f12240b;
        if (aVar != null) {
            aVar.updatePlaybackState(false);
        }
    }

    public void setPreviewImage(int i10) {
        ImageView imageView = this.f12241m;
        if (imageView != null) {
            imageView.setImageResource(i10);
        }
    }

    public void setPreviewImage(Bitmap bitmap) {
        ImageView imageView = this.f12241m;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public void setPreviewImage(Uri uri) {
        ImageView imageView = this.f12241m;
        if (imageView != null) {
            imageView.setImageURI(uri);
        }
    }
}
