package p3;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import z3.s;

/* compiled from: LottieDrawable.java */
/* loaded from: classes.dex */
public final class f extends Drawable implements Drawable.Callback, Animatable {
    public boolean A;
    public final boolean B;
    public boolean C;

    /* renamed from: b, reason: collision with root package name */
    public final Matrix f17458b = new Matrix();

    /* renamed from: m, reason: collision with root package name */
    public p3.d f17459m;

    /* renamed from: n, reason: collision with root package name */
    public final a4.e f17460n;

    /* renamed from: o, reason: collision with root package name */
    public float f17461o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f17462p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f17463q;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList<o> f17464r;

    /* renamed from: s, reason: collision with root package name */
    public ImageView.ScaleType f17465s;

    /* renamed from: t, reason: collision with root package name */
    public t3.b f17466t;

    /* renamed from: u, reason: collision with root package name */
    public String f17467u;

    /* renamed from: v, reason: collision with root package name */
    public t3.a f17468v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f17469w;

    /* renamed from: x, reason: collision with root package name */
    public com.airbnb.lottie.model.layer.b f17470x;

    /* renamed from: y, reason: collision with root package name */
    public int f17471y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f17472z;

    /* compiled from: LottieDrawable.java */
    public class a implements o {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17473a;

        public a(String str) {
            this.f17473a = str;
        }

        @Override // p3.f.o
        public void run(p3.d dVar) {
            f.this.setMinAndMaxFrame(this.f17473a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class b implements o {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f17475a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f17476b;

        public b(int i10, int i11) {
            this.f17475a = i10;
            this.f17476b = i11;
        }

        @Override // p3.f.o
        public void run(p3.d dVar) {
            f.this.setMinAndMaxFrame(this.f17475a, this.f17476b);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class c implements o {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f17478a;

        public c(int i10) {
            this.f17478a = i10;
        }

        @Override // p3.f.o
        public void run(p3.d dVar) {
            f.this.setFrame(this.f17478a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class d implements o {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f17480a;

        public d(float f10) {
            this.f17480a = f10;
        }

        @Override // p3.f.o
        public void run(p3.d dVar) {
            f.this.setProgress(this.f17480a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class e implements o {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u3.d f17482a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f17483b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b4.c f17484c;

        public e(u3.d dVar, Object obj, b4.c cVar) {
            this.f17482a = dVar;
            this.f17483b = obj;
            this.f17484c = cVar;
        }

        @Override // p3.f.o
        public void run(p3.d dVar) {
            f.this.addValueCallback(this.f17482a, this.f17483b, this.f17484c);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: p3.f$f, reason: collision with other inner class name */
    public class C0221f implements ValueAnimator.AnimatorUpdateListener {
        public C0221f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            f fVar = f.this;
            com.airbnb.lottie.model.layer.b bVar = fVar.f17470x;
            if (bVar != null) {
                bVar.setProgress(fVar.f17460n.getAnimatedValueAbsolute());
            }
        }
    }

    /* compiled from: LottieDrawable.java */
    public class g implements o {
        public g() {
        }

        @Override // p3.f.o
        public void run(p3.d dVar) {
            f.this.playAnimation();
        }
    }

    /* compiled from: LottieDrawable.java */
    public class h implements o {
        public h() {
        }

        @Override // p3.f.o
        public void run(p3.d dVar) {
            f.this.resumeAnimation();
        }
    }

    /* compiled from: LottieDrawable.java */
    public class i implements o {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f17489a;

        public i(int i10) {
            this.f17489a = i10;
        }

        @Override // p3.f.o
        public void run(p3.d dVar) {
            f.this.setMinFrame(this.f17489a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class j implements o {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f17491a;

        public j(float f10) {
            this.f17491a = f10;
        }

        @Override // p3.f.o
        public void run(p3.d dVar) {
            f.this.setMinProgress(this.f17491a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class k implements o {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f17493a;

        public k(int i10) {
            this.f17493a = i10;
        }

        @Override // p3.f.o
        public void run(p3.d dVar) {
            f.this.setMaxFrame(this.f17493a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class l implements o {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f17495a;

        public l(float f10) {
            this.f17495a = f10;
        }

        @Override // p3.f.o
        public void run(p3.d dVar) {
            f.this.setMaxProgress(this.f17495a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class m implements o {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17497a;

        public m(String str) {
            this.f17497a = str;
        }

        @Override // p3.f.o
        public void run(p3.d dVar) {
            f.this.setMinFrame(this.f17497a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class n implements o {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17499a;

        public n(String str) {
            this.f17499a = str;
        }

        @Override // p3.f.o
        public void run(p3.d dVar) {
            f.this.setMaxFrame(this.f17499a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public interface o {
        void run(p3.d dVar);
    }

    public f() {
        a4.e eVar = new a4.e();
        this.f17460n = eVar;
        this.f17461o = 1.0f;
        this.f17462p = true;
        this.f17463q = false;
        new HashSet();
        this.f17464r = new ArrayList<>();
        C0221f c0221f = new C0221f();
        this.f17471y = 255;
        this.B = true;
        this.C = false;
        eVar.addUpdateListener(c0221f);
    }

    public final void a(Canvas canvas) {
        float f10;
        float f11;
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        ImageView.ScaleType scaleType2 = this.f17465s;
        Matrix matrix = this.f17458b;
        int iSave = -1;
        if (scaleType != scaleType2) {
            if (this.f17470x == null) {
                return;
            }
            float f12 = this.f17461o;
            float fMin = Math.min(canvas.getWidth() / this.f17459m.getBounds().width(), canvas.getHeight() / this.f17459m.getBounds().height());
            if (f12 > fMin) {
                f10 = this.f17461o / fMin;
            } else {
                fMin = f12;
                f10 = 1.0f;
            }
            if (f10 > 1.0f) {
                iSave = canvas.save();
                float fWidth = this.f17459m.getBounds().width() / 2.0f;
                float fHeight = this.f17459m.getBounds().height() / 2.0f;
                float f13 = fWidth * fMin;
                float f14 = fHeight * fMin;
                canvas.translate((getScale() * fWidth) - f13, (getScale() * fHeight) - f14);
                canvas.scale(f10, f10, f13, f14);
            }
            matrix.reset();
            matrix.preScale(fMin, fMin);
            this.f17470x.draw(canvas, matrix, this.f17471y);
            if (iSave > 0) {
                canvas.restoreToCount(iSave);
                return;
            }
            return;
        }
        if (this.f17470x == null) {
            return;
        }
        Rect bounds = getBounds();
        float fWidth2 = bounds.width() / this.f17459m.getBounds().width();
        float fHeight2 = bounds.height() / this.f17459m.getBounds().height();
        if (this.B) {
            float fMin2 = Math.min(fWidth2, fHeight2);
            if (fMin2 < 1.0f) {
                f11 = 1.0f / fMin2;
                fWidth2 /= f11;
                fHeight2 /= f11;
            } else {
                f11 = 1.0f;
            }
            if (f11 > 1.0f) {
                iSave = canvas.save();
                float fWidth3 = bounds.width() / 2.0f;
                float fHeight3 = bounds.height() / 2.0f;
                float f15 = fWidth3 * fMin2;
                float f16 = fMin2 * fHeight3;
                canvas.translate(fWidth3 - f15, fHeight3 - f16);
                canvas.scale(f11, f11, f15, f16);
            }
        }
        matrix.reset();
        matrix.preScale(fWidth2, fHeight2);
        this.f17470x.draw(canvas, matrix, this.f17471y);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    public <T> void addValueCallback(u3.d dVar, T t10, b4.c<T> cVar) {
        if (this.f17470x == null) {
            this.f17464r.add(new e(dVar, t10, cVar));
            return;
        }
        boolean zIsEmpty = true;
        if (dVar.getResolvedElement() != null) {
            dVar.getResolvedElement().addValueCallback(t10, cVar);
        } else {
            List<u3.d> listResolveKeyPath = resolveKeyPath(dVar);
            for (int i10 = 0; i10 < listResolveKeyPath.size(); i10++) {
                listResolveKeyPath.get(i10).getResolvedElement().addValueCallback(t10, cVar);
            }
            zIsEmpty = true ^ listResolveKeyPath.isEmpty();
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (t10 == p3.k.A) {
                setProgress(getProgress());
            }
        }
    }

    public final void b() {
        if (this.f17459m == null) {
            return;
        }
        float scale = getScale();
        setBounds(0, 0, (int) (this.f17459m.getBounds().width() * scale), (int) (this.f17459m.getBounds().height() * scale));
    }

    public void cancelAnimation() {
        this.f17464r.clear();
        this.f17460n.cancel();
    }

    public void clearComposition() {
        a4.e eVar = this.f17460n;
        if (eVar.isRunning()) {
            eVar.cancel();
        }
        this.f17459m = null;
        this.f17470x = null;
        this.f17466t = null;
        eVar.clearComposition();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.C = false;
        p3.c.beginSection("Drawable#draw");
        if (this.f17463q) {
            try {
                a(canvas);
            } catch (Throwable th2) {
                a4.d.error("Lottie crashed in draw!", th2);
            }
        } else {
            a(canvas);
        }
        p3.c.endSection("Drawable#draw");
    }

    public boolean enableMergePathsForKitKatAndAbove() {
        return this.f17469w;
    }

    public void endAnimation() {
        this.f17464r.clear();
        this.f17460n.endAnimation();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f17471y;
    }

    public p3.d getComposition() {
        return this.f17459m;
    }

    public int getFrame() {
        return (int) this.f17460n.getFrame();
    }

    public Bitmap getImageAsset(String str) {
        t3.b bVar;
        if (getCallback() == null) {
            bVar = null;
        } else {
            t3.b bVar2 = this.f17466t;
            if (bVar2 != null) {
                Drawable.Callback callback = getCallback();
                if (!bVar2.hasSameContext((callback != null && (callback instanceof View)) ? ((View) callback).getContext() : null)) {
                    this.f17466t = null;
                }
            }
            if (this.f17466t == null) {
                this.f17466t = new t3.b(getCallback(), this.f17467u, null, this.f17459m.getImages());
            }
            bVar = this.f17466t;
        }
        if (bVar != null) {
            return bVar.bitmapForId(str);
        }
        return null;
    }

    public String getImageAssetsFolder() {
        return this.f17467u;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f17459m == null) {
            return -1;
        }
        return (int) (getScale() * r0.getBounds().height());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f17459m == null) {
            return -1;
        }
        return (int) (getScale() * r0.getBounds().width());
    }

    public float getMaxFrame() {
        return this.f17460n.getMaxFrame();
    }

    public float getMinFrame() {
        return this.f17460n.getMinFrame();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public p3.o getPerformanceTracker() {
        p3.d dVar = this.f17459m;
        if (dVar != null) {
            return dVar.getPerformanceTracker();
        }
        return null;
    }

    public float getProgress() {
        return this.f17460n.getAnimatedValueAbsolute();
    }

    public int getRepeatCount() {
        return this.f17460n.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.f17460n.getRepeatMode();
    }

    public float getScale() {
        return this.f17461o;
    }

    public float getSpeed() {
        return this.f17460n.getSpeed();
    }

    public q getTextDelegate() {
        return null;
    }

    public Typeface getTypeface(String str, String str2) {
        t3.a aVar;
        if (getCallback() == null) {
            aVar = null;
        } else {
            if (this.f17468v == null) {
                this.f17468v = new t3.a(getCallback(), null);
            }
            aVar = this.f17468v;
        }
        if (aVar != null) {
            return aVar.getTypeface(str, str2);
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.C) {
            return;
        }
        this.C = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isAnimating() {
        a4.e eVar = this.f17460n;
        if (eVar == null) {
            return false;
        }
        return eVar.isRunning();
    }

    public boolean isApplyingOpacityToLayersEnabled() {
        return this.A;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return isAnimating();
    }

    public void pauseAnimation() {
        this.f17464r.clear();
        this.f17460n.pauseAnimation();
    }

    public void playAnimation() {
        if (this.f17470x == null) {
            this.f17464r.add(new g());
            return;
        }
        boolean z10 = this.f17462p;
        a4.e eVar = this.f17460n;
        if (z10 || getRepeatCount() == 0) {
            eVar.playAnimation();
        }
        if (this.f17462p) {
            return;
        }
        setFrame((int) (getSpeed() < 0.0f ? getMinFrame() : getMaxFrame()));
        eVar.endAnimation();
    }

    public List<u3.d> resolveKeyPath(u3.d dVar) {
        if (this.f17470x == null) {
            a4.d.warning("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f17470x.resolveKeyPath(dVar, 0, arrayList, new u3.d(new String[0]));
        return arrayList;
    }

    public void resumeAnimation() {
        if (this.f17470x == null) {
            this.f17464r.add(new h());
            return;
        }
        boolean z10 = this.f17462p;
        a4.e eVar = this.f17460n;
        if (z10 || getRepeatCount() == 0) {
            eVar.resumeAnimation();
        }
        if (this.f17462p) {
            return;
        }
        setFrame((int) (getSpeed() < 0.0f ? getMinFrame() : getMaxFrame()));
        eVar.endAnimation();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f17471y = i10;
        invalidateSelf();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z10) {
        this.A = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        a4.d.warning("Use addColorFilter instead.");
    }

    public boolean setComposition(p3.d dVar) {
        if (this.f17459m == dVar) {
            return false;
        }
        this.C = false;
        clearComposition();
        this.f17459m = dVar;
        this.f17470x = new com.airbnb.lottie.model.layer.b(this, s.parse(dVar), this.f17459m.getLayers(), this.f17459m);
        a4.e eVar = this.f17460n;
        eVar.setComposition(dVar);
        setProgress(eVar.getAnimatedFraction());
        setScale(this.f17461o);
        b();
        ArrayList<o> arrayList = this.f17464r;
        Iterator it = new ArrayList(arrayList).iterator();
        while (it.hasNext()) {
            ((o) it.next()).run(dVar);
            it.remove();
        }
        arrayList.clear();
        dVar.setPerformanceTrackingEnabled(this.f17472z);
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof ImageView)) {
            return true;
        }
        ImageView imageView = (ImageView) callback;
        imageView.setImageDrawable(null);
        imageView.setImageDrawable(this);
        return true;
    }

    public void setFontAssetDelegate(p3.a aVar) {
        t3.a aVar2 = this.f17468v;
        if (aVar2 != null) {
            aVar2.setDelegate(aVar);
        }
    }

    public void setFrame(int i10) {
        if (this.f17459m == null) {
            this.f17464r.add(new c(i10));
        } else {
            this.f17460n.setFrame(i10);
        }
    }

    public void setImageAssetDelegate(p3.b bVar) {
        t3.b bVar2 = this.f17466t;
        if (bVar2 != null) {
            bVar2.setDelegate(bVar);
        }
    }

    public void setImagesAssetsFolder(String str) {
        this.f17467u = str;
    }

    public void setMaxFrame(int i10) {
        if (this.f17459m == null) {
            this.f17464r.add(new k(i10));
        } else {
            this.f17460n.setMaxFrame(i10 + 0.99f);
        }
    }

    public void setMaxProgress(float f10) {
        p3.d dVar = this.f17459m;
        if (dVar == null) {
            this.f17464r.add(new l(f10));
        } else {
            setMaxFrame((int) a4.g.lerp(dVar.getStartFrame(), this.f17459m.getEndFrame(), f10));
        }
    }

    public void setMinAndMaxFrame(String str) {
        p3.d dVar = this.f17459m;
        if (dVar == null) {
            this.f17464r.add(new a(str));
            return;
        }
        u3.g marker = dVar.getMarker(str);
        if (marker == null) {
            throw new IllegalArgumentException(ac.c.k("Cannot find marker with name ", str, "."));
        }
        int i10 = (int) marker.f19994b;
        setMinAndMaxFrame(i10, ((int) marker.f19995c) + i10);
    }

    public void setMinFrame(int i10) {
        if (this.f17459m == null) {
            this.f17464r.add(new i(i10));
        } else {
            this.f17460n.setMinFrame(i10);
        }
    }

    public void setMinProgress(float f10) {
        p3.d dVar = this.f17459m;
        if (dVar == null) {
            this.f17464r.add(new j(f10));
        } else {
            setMinFrame((int) a4.g.lerp(dVar.getStartFrame(), this.f17459m.getEndFrame(), f10));
        }
    }

    public void setPerformanceTrackingEnabled(boolean z10) {
        this.f17472z = z10;
        p3.d dVar = this.f17459m;
        if (dVar != null) {
            dVar.setPerformanceTrackingEnabled(z10);
        }
    }

    public void setProgress(float f10) {
        if (this.f17459m == null) {
            this.f17464r.add(new d(f10));
            return;
        }
        p3.c.beginSection("Drawable#setProgress");
        this.f17460n.setFrame(a4.g.lerp(this.f17459m.getStartFrame(), this.f17459m.getEndFrame(), f10));
        p3.c.endSection("Drawable#setProgress");
    }

    public void setRepeatCount(int i10) {
        this.f17460n.setRepeatCount(i10);
    }

    public void setRepeatMode(int i10) {
        this.f17460n.setRepeatMode(i10);
    }

    public void setSafeMode(boolean z10) {
        this.f17463q = z10;
    }

    public void setScale(float f10) {
        this.f17461o = f10;
        b();
    }

    public void setSpeed(float f10) {
        this.f17460n.setSpeed(f10);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        playAnimation();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        endAnimation();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public boolean useTextGlyphs() {
        return this.f17459m.getCharacters().size() > 0;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z10) {
        if (this.f17469w == z10) {
            return;
        }
        this.f17469w = z10;
        p3.d dVar = this.f17459m;
        if (dVar != null) {
            this.f17470x = new com.airbnb.lottie.model.layer.b(this, s.parse(dVar), this.f17459m.getLayers(), this.f17459m);
        }
    }

    public void setMaxFrame(String str) {
        p3.d dVar = this.f17459m;
        if (dVar == null) {
            this.f17464r.add(new n(str));
            return;
        }
        u3.g marker = dVar.getMarker(str);
        if (marker != null) {
            setMaxFrame((int) (marker.f19994b + marker.f19995c));
            return;
        }
        throw new IllegalArgumentException(ac.c.k("Cannot find marker with name ", str, "."));
    }

    public void setMinFrame(String str) {
        p3.d dVar = this.f17459m;
        if (dVar == null) {
            this.f17464r.add(new m(str));
            return;
        }
        u3.g marker = dVar.getMarker(str);
        if (marker != null) {
            setMinFrame((int) marker.f19994b);
            return;
        }
        throw new IllegalArgumentException(ac.c.k("Cannot find marker with name ", str, "."));
    }

    public void setMinAndMaxFrame(int i10, int i11) {
        if (this.f17459m == null) {
            this.f17464r.add(new b(i10, i11));
        } else {
            this.f17460n.setMinAndMaxFrames(i10, i11 + 0.99f);
        }
    }

    public void setTextDelegate(q qVar) {
    }
}
