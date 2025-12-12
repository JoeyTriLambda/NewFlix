package pl.droidsonroids.gif;

import ai.b;
import ai.e;
import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.util.TypedValue;
import android.widget.MediaController;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: GifDrawable.java */
/* loaded from: classes2.dex */
public final class a extends Drawable implements Animatable, MediaController.MediaPlayerControl {
    public ScheduledFuture<?> A;
    public final int B;
    public final int C;

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f17749b;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f17750m;

    /* renamed from: n, reason: collision with root package name */
    public long f17751n;

    /* renamed from: o, reason: collision with root package name */
    public final Rect f17752o;

    /* renamed from: p, reason: collision with root package name */
    public final Paint f17753p;

    /* renamed from: q, reason: collision with root package name */
    public final Bitmap f17754q;

    /* renamed from: r, reason: collision with root package name */
    public final GifInfoHandle f17755r;

    /* renamed from: s, reason: collision with root package name */
    public final ConcurrentLinkedQueue<ai.a> f17756s;

    /* renamed from: t, reason: collision with root package name */
    public ColorStateList f17757t;

    /* renamed from: u, reason: collision with root package name */
    public PorterDuffColorFilter f17758u;

    /* renamed from: v, reason: collision with root package name */
    public PorterDuff.Mode f17759v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f17760w;

    /* renamed from: x, reason: collision with root package name */
    public final ai.c f17761x;

    /* renamed from: y, reason: collision with root package name */
    public final d f17762y;

    /* renamed from: z, reason: collision with root package name */
    public final Rect f17763z;

    /* compiled from: GifDrawable.java */
    /* renamed from: pl.droidsonroids.gif.a$a, reason: collision with other inner class name */
    public class C0226a extends e {
        public C0226a(a aVar) {
            super(aVar);
        }

        @Override // ai.e
        public void doWork() {
            a aVar = a.this;
            if (aVar.f17755r.o()) {
                aVar.start();
            }
        }
    }

    /* compiled from: GifDrawable.java */
    public class b extends e {

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f17765m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i10) {
            super(aVar);
            this.f17765m = i10;
        }

        @Override // ai.e
        public void doWork() {
            a aVar = a.this;
            aVar.f17755r.s(aVar.f17754q, this.f17765m);
            this.f738b.f17761x.sendEmptyMessageAtTime(-1, 0L);
        }
    }

    public a(Resources resources, int i10) throws Resources.NotFoundException, IOException {
        this(resources.openRawResourceFd(i10));
        List<String> list = c.f17768a;
        TypedValue typedValue = new TypedValue();
        resources.getValue(i10, typedValue, true);
        int i11 = typedValue.density;
        if (i11 == 0) {
            i11 = 160;
        } else if (i11 == 65535) {
            i11 = 0;
        }
        int i12 = resources.getDisplayMetrics().densityDpi;
        float f10 = (i11 <= 0 || i12 <= 0) ? 1.0f : i12 / i11;
        this.C = (int) (this.f17755r.e() * f10);
        this.B = (int) (this.f17755r.j() * f10);
    }

    public final void a(long j10) {
        ai.c cVar = this.f17761x;
        if (this.f17760w) {
            this.f17751n = 0L;
            cVar.sendEmptyMessageAtTime(-1, 0L);
            return;
        }
        ScheduledFuture<?> scheduledFuture = this.A;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        cVar.removeMessages(-1);
        this.A = this.f17749b.schedule(this.f17762y, Math.max(j10, 0L), TimeUnit.MILLISECONDS);
    }

    public final PorterDuffColorFilter b(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return getNumberOfFrames() > 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return getNumberOfFrames() > 1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z10;
        PorterDuffColorFilter porterDuffColorFilter = this.f17758u;
        Paint paint = this.f17753p;
        if (porterDuffColorFilter == null || paint.getColorFilter() != null) {
            z10 = false;
        } else {
            paint.setColorFilter(this.f17758u);
            z10 = true;
        }
        canvas.drawBitmap(this.f17754q, this.f17763z, this.f17752o, paint);
        if (z10) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f17753p.getAlpha();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 100;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f17753p.getColorFilter();
    }

    public int getCurrentFrameIndex() {
        return this.f17755r.a();
    }

    public int getCurrentLoop() {
        GifInfoHandle gifInfoHandle = this.f17755r;
        int iB = gifInfoHandle.b();
        return (iB == 0 || iB < gifInfoHandle.f()) ? iB : iB - 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.f17755r.c();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.f17755r.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.C;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.B;
    }

    public int getNumberOfFrames() {
        return this.f17755r.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return (!this.f17755r.k() || this.f17753p.getAlpha() < 255) ? -2 : -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        if (this.f17760w && this.f17750m) {
            long j10 = this.f17751n;
            if (j10 != Long.MIN_VALUE) {
                long jMax = Math.max(0L, j10 - SystemClock.uptimeMillis());
                this.f17751n = Long.MIN_VALUE;
                this.f17749b.remove(this.f17762y);
                this.A = this.f17749b.schedule(this.f17762y, jMax, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.f17750m;
    }

    public boolean isRecycled() {
        return this.f17755r.l();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f17750m;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        return super.isStateful() || ((colorStateList = this.f17757t) != null && colorStateList.isStateful());
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f17752o.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f17757t;
        if (colorStateList == null || (mode = this.f17759v) == null) {
            return false;
        }
        this.f17758u = b(colorStateList, mode);
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        stop();
    }

    public void reset() {
        this.f17749b.execute(new C0226a(this));
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Position is not positive");
        }
        this.f17749b.execute(new b(this, i10));
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f17753p.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f17753p.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        this.f17753p.setDither(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z10) {
        this.f17753p.setFilterBitmap(z10);
        invalidateSelf();
    }

    public void setLoopCount(int i10) {
        this.f17755r.t(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f17757t = colorStateList;
        this.f17758u = b(colorStateList, this.f17759v);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f17759v = mode;
        this.f17758u = b(this.f17757t, mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        if (!this.f17760w) {
            if (z10) {
                if (z11) {
                    reset();
                }
                if (visible) {
                    start();
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable, android.widget.MediaController.MediaPlayerControl
    public void start() {
        synchronized (this) {
            if (this.f17750m) {
                return;
            }
            this.f17750m = true;
            a(this.f17755r.p());
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        synchronized (this) {
            if (this.f17750m) {
                this.f17750m = false;
                ScheduledFuture<?> scheduledFuture = this.A;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.f17761x.removeMessages(-1);
                this.f17755r.r();
            }
        }
    }

    public String toString() {
        Locale locale = Locale.ENGLISH;
        GifInfoHandle gifInfoHandle = this.f17755r;
        return String.format(locale, "GIF: size: %dx%d, frames: %d, error: %d", Integer.valueOf(gifInfoHandle.j()), Integer.valueOf(gifInfoHandle.e()), Integer.valueOf(gifInfoHandle.h()), Integer.valueOf(gifInfoHandle.g()));
    }

    public a(AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(new GifInfoHandle(assetFileDescriptor));
    }

    public a(ContentResolver contentResolver, Uri uri) throws IOException {
        GifInfoHandle gifInfoHandle;
        int i10 = GifInfoHandle.f17747b;
        if ("file".equals(uri.getScheme())) {
            gifInfoHandle = new GifInfoHandle(uri.getPath());
        } else {
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
            if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                gifInfoHandle = new GifInfoHandle(assetFileDescriptorOpenAssetFileDescriptor);
            } else {
                throw new IOException(ac.c.i("Could not open AssetFileDescriptor for ", uri));
            }
        }
        this(gifInfoHandle);
    }

    public a(GifInfoHandle gifInfoHandle) {
        this.f17750m = true;
        this.f17751n = Long.MIN_VALUE;
        this.f17752o = new Rect();
        this.f17753p = new Paint(6);
        this.f17756s = new ConcurrentLinkedQueue<>();
        d dVar = new d(this);
        this.f17762y = dVar;
        this.f17760w = true;
        int i10 = ai.b.f734b;
        this.f17749b = b.a.f735a;
        this.f17755r = gifInfoHandle;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(gifInfoHandle.j(), gifInfoHandle.e(), Bitmap.Config.ARGB_8888);
        this.f17754q = bitmapCreateBitmap;
        bitmapCreateBitmap.setHasAlpha(true ^ gifInfoHandle.k());
        this.f17763z = new Rect(0, 0, gifInfoHandle.j(), gifInfoHandle.e());
        this.f17761x = new ai.c(this);
        dVar.doWork();
        this.B = gifInfoHandle.j();
        this.C = gifInfoHandle.e();
    }
}
