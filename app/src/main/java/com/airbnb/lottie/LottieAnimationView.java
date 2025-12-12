package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.q;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import p3.e;
import p3.f;
import p3.h;
import p3.j;
import p3.k;
import p3.n;
import p3.o;
import p3.p;
import x0.j0;

/* loaded from: classes.dex */
public class LottieAnimationView extends q {
    public static final a G = new a();
    public boolean A;
    public RenderMode B;
    public final HashSet C;
    public int D;
    public n<p3.d> E;
    public p3.d F;

    /* renamed from: o, reason: collision with root package name */
    public final b f5365o;

    /* renamed from: p, reason: collision with root package name */
    public final c f5366p;

    /* renamed from: q, reason: collision with root package name */
    public h<Throwable> f5367q;

    /* renamed from: r, reason: collision with root package name */
    public int f5368r;

    /* renamed from: s, reason: collision with root package name */
    public final f f5369s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f5370t;

    /* renamed from: u, reason: collision with root package name */
    public String f5371u;

    /* renamed from: v, reason: collision with root package name */
    public int f5372v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f5373w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f5374x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f5375y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f5376z;

    public class a implements h<Throwable> {
        @Override // p3.h
        public void onResult(Throwable th2) {
            if (!a4.h.isNetworkException(th2)) {
                throw new IllegalStateException("Unable to parse composition", th2);
            }
            a4.d.warning("Unable to load composition.", th2);
        }
    }

    public class b implements h<p3.d> {
        public b() {
        }

        @Override // p3.h
        public void onResult(p3.d dVar) {
            LottieAnimationView.this.setComposition(dVar);
        }
    }

    public class c implements h<Throwable> {
        public c() {
        }

        @Override // p3.h
        public void onResult(Throwable th2) {
            LottieAnimationView lottieAnimationView = LottieAnimationView.this;
            int i10 = lottieAnimationView.f5368r;
            if (i10 != 0) {
                lottieAnimationView.setImageResource(i10);
            }
            h hVar = lottieAnimationView.f5367q;
            if (hVar == null) {
                hVar = LottieAnimationView.G;
            }
            hVar.onResult(th2);
        }
    }

    public static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public String f5379b;

        /* renamed from: m, reason: collision with root package name */
        public int f5380m;

        /* renamed from: n, reason: collision with root package name */
        public float f5381n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f5382o;

        /* renamed from: p, reason: collision with root package name */
        public String f5383p;

        /* renamed from: q, reason: collision with root package name */
        public int f5384q;

        /* renamed from: r, reason: collision with root package name */
        public int f5385r;

        public class a implements Parcelable.Creator<d> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public d[] newArray(int i10) {
                return new d[i10];
            }
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f5379b);
            parcel.writeFloat(this.f5381n);
            parcel.writeInt(this.f5382o ? 1 : 0);
            parcel.writeString(this.f5383p);
            parcel.writeInt(this.f5384q);
            parcel.writeInt(this.f5385r);
        }

        public d(Parcel parcel) {
            super(parcel);
            this.f5379b = parcel.readString();
            this.f5381n = parcel.readFloat();
            this.f5382o = parcel.readInt() == 1;
            this.f5383p = parcel.readString();
            this.f5384q = parcel.readInt();
            this.f5385r = parcel.readInt();
        }
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        String string;
        super(context, attributeSet);
        this.f5365o = new b();
        this.f5366p = new c();
        this.f5368r = 0;
        f fVar = new f();
        this.f5369s = fVar;
        this.f5373w = false;
        this.f5374x = false;
        this.f5375y = false;
        this.f5376z = false;
        this.A = true;
        this.B = RenderMode.AUTOMATIC;
        this.C = new HashSet();
        this.D = 0;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView);
        if (!isInEditMode()) {
            this.A = typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
            int i10 = R.styleable.LottieAnimationView_lottie_rawRes;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i10);
            int i11 = R.styleable.LottieAnimationView_lottie_fileName;
            boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(i11);
            int i12 = R.styleable.LottieAnimationView_lottie_url;
            boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(i12);
            if (zHasValue && zHasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
            if (zHasValue) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(i10, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (zHasValue2) {
                String string2 = typedArrayObtainStyledAttributes.getString(i11);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(i12)) != null) {
                setAnimationFromUrl(string);
            }
            setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.f5375y = true;
            this.f5376z = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
            fVar.setRepeatCount(-1);
        }
        int i13 = R.styleable.LottieAnimationView_lottie_repeatMode;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(i13, 1));
        }
        int i14 = R.styleable.LottieAnimationView_lottie_repeatCount;
        if (typedArrayObtainStyledAttributes.hasValue(i14)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(i14, -1));
        }
        int i15 = R.styleable.LottieAnimationView_lottie_speed;
        if (typedArrayObtainStyledAttributes.hasValue(i15)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(i15, 1.0f));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        enableMergePathsForKitKatAndAbove(typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        int i16 = R.styleable.LottieAnimationView_lottie_colorFilter;
        if (typedArrayObtainStyledAttributes.hasValue(i16)) {
            addValueCallback(new u3.d("**"), k.C, new b4.c(new p(typedArrayObtainStyledAttributes.getColor(i16, 0))));
        }
        int i17 = R.styleable.LottieAnimationView_lottie_scale;
        if (typedArrayObtainStyledAttributes.hasValue(i17)) {
            fVar.setScale(typedArrayObtainStyledAttributes.getFloat(i17, 1.0f));
        }
        int i18 = R.styleable.LottieAnimationView_lottie_renderMode;
        if (typedArrayObtainStyledAttributes.hasValue(i18)) {
            int i19 = typedArrayObtainStyledAttributes.getInt(i18, 0);
            setRenderMode(RenderMode.values()[i19 >= RenderMode.values().length ? 0 : i19]);
        }
        if (getScaleType() != null) {
            fVar.f17465s = getScaleType();
        }
        typedArrayObtainStyledAttributes.recycle();
        fVar.f17462p = Boolean.valueOf(a4.h.getAnimationScale(getContext()) != 0.0f).booleanValue();
        b();
        this.f5370t = true;
    }

    private void setCompositionTask(n<p3.d> nVar) {
        this.F = null;
        this.f5369s.clearComposition();
        a();
        this.E = nVar.addListener(this.f5365o).addFailureListener(this.f5366p);
    }

    public final void a() {
        n<p3.d> nVar = this.E;
        if (nVar != null) {
            nVar.removeListener(this.f5365o);
            this.E.removeFailureListener(this.f5366p);
        }
    }

    public <T> void addValueCallback(u3.d dVar, T t10, b4.c<T> cVar) {
        this.f5369s.addValueCallback(dVar, t10, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b() {
        /*
            r5 = this;
            com.airbnb.lottie.RenderMode r0 = r5.B
            int r0 = r0.ordinal()
            r1 = 2
            r2 = 1
            if (r0 == 0) goto Le
            if (r0 == r2) goto L2f
        Lc:
            r1 = 1
            goto L2f
        Le:
            p3.d r0 = r5.F
            r3 = 0
            if (r0 == 0) goto L20
            boolean r0 = r0.hasDashPattern()
            if (r0 == 0) goto L20
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r0 >= r4) goto L20
            goto L2d
        L20:
            p3.d r0 = r5.F
            if (r0 == 0) goto L2c
            int r0 = r0.getMaskAndMatteCount()
            r4 = 4
            if (r0 <= r4) goto L2c
            goto L2d
        L2c:
            r3 = 1
        L2d:
            if (r3 == 0) goto Lc
        L2f:
            int r0 = r5.getLayerType()
            if (r1 == r0) goto L39
            r0 = 0
            r5.setLayerType(r1, r0)
        L39:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.b():void");
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z10) {
        p3.c.beginSection("buildDrawingCache");
        this.D++;
        super.buildDrawingCache(z10);
        if (this.D == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z10) == null) {
            setRenderMode(RenderMode.HARDWARE);
        }
        this.D--;
        p3.c.endSection("buildDrawingCache");
    }

    public void cancelAnimation() {
        this.f5375y = false;
        this.f5374x = false;
        this.f5373w = false;
        this.f5369s.cancelAnimation();
        b();
    }

    public void enableMergePathsForKitKatAndAbove(boolean z10) {
        this.f5369s.enableMergePathsForKitKatAndAbove(z10);
    }

    public p3.d getComposition() {
        return this.F;
    }

    public long getDuration() {
        p3.d dVar = this.F;
        if (dVar != null) {
            return (long) dVar.getDuration();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f5369s.getFrame();
    }

    public String getImageAssetsFolder() {
        return this.f5369s.getImageAssetsFolder();
    }

    public float getMaxFrame() {
        return this.f5369s.getMaxFrame();
    }

    public float getMinFrame() {
        return this.f5369s.getMinFrame();
    }

    public o getPerformanceTracker() {
        return this.f5369s.getPerformanceTracker();
    }

    public float getProgress() {
        return this.f5369s.getProgress();
    }

    public int getRepeatCount() {
        return this.f5369s.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.f5369s.getRepeatMode();
    }

    public float getScale() {
        return this.f5369s.getScale();
    }

    public float getSpeed() {
        return this.f5369s.getSpeed();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        f fVar = this.f5369s;
        if (drawable2 == fVar) {
            super.invalidateDrawable(fVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean isAnimating() {
        return this.f5369s.isAnimating();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5376z || this.f5375y) {
            playAnimation();
            this.f5376z = false;
            this.f5375y = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.f5375y = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        String str = dVar.f5379b;
        this.f5371u = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.f5371u);
        }
        int i10 = dVar.f5380m;
        this.f5372v = i10;
        if (i10 != 0) {
            setAnimation(i10);
        }
        setProgress(dVar.f5381n);
        if (dVar.f5382o) {
            playAnimation();
        }
        this.f5369s.setImagesAssetsFolder(dVar.f5383p);
        setRepeatMode(dVar.f5384q);
        setRepeatCount(dVar.f5385r);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f5379b = this.f5371u;
        dVar.f5380m = this.f5372v;
        f fVar = this.f5369s;
        dVar.f5381n = fVar.getProgress();
        dVar.f5382o = fVar.isAnimating() || (!j0.isAttachedToWindow(this) && this.f5375y);
        dVar.f5383p = fVar.getImageAssetsFolder();
        dVar.f5384q = fVar.getRepeatMode();
        dVar.f5385r = fVar.getRepeatCount();
        return dVar;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        if (this.f5370t) {
            if (!isShown()) {
                if (isAnimating()) {
                    pauseAnimation();
                    this.f5374x = true;
                    return;
                }
                return;
            }
            if (this.f5374x) {
                resumeAnimation();
            } else if (this.f5373w) {
                playAnimation();
            }
            this.f5374x = false;
            this.f5373w = false;
        }
    }

    public void pauseAnimation() {
        this.f5376z = false;
        this.f5375y = false;
        this.f5374x = false;
        this.f5373w = false;
        this.f5369s.pauseAnimation();
        b();
    }

    public void playAnimation() {
        if (!isShown()) {
            this.f5373w = true;
        } else {
            this.f5369s.playAnimation();
            b();
        }
    }

    public void resumeAnimation() {
        if (isShown()) {
            this.f5369s.resumeAnimation();
            b();
        } else {
            this.f5373w = false;
            this.f5374x = true;
        }
    }

    public void setAnimation(int i10) {
        this.f5372v = i10;
        this.f5371u = null;
        setCompositionTask(this.A ? e.fromRawRes(getContext(), i10) : e.fromRawRes(getContext(), i10, null));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.A ? e.fromUrl(getContext(), str) : e.fromUrl(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z10) {
        this.f5369s.setApplyingOpacityToLayersEnabled(z10);
    }

    public void setCacheComposition(boolean z10) {
        this.A = z10;
    }

    public void setComposition(p3.d dVar) {
        f fVar = this.f5369s;
        fVar.setCallback(this);
        this.F = dVar;
        boolean composition = fVar.setComposition(dVar);
        b();
        if (getDrawable() != fVar || composition) {
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator it = this.C.iterator();
            while (it.hasNext()) {
                ((j) it.next()).onCompositionLoaded(dVar);
            }
        }
    }

    public void setFailureListener(h<Throwable> hVar) {
        this.f5367q = hVar;
    }

    public void setFallbackResource(int i10) {
        this.f5368r = i10;
    }

    public void setFontAssetDelegate(p3.a aVar) {
        this.f5369s.setFontAssetDelegate(aVar);
    }

    public void setFrame(int i10) {
        this.f5369s.setFrame(i10);
    }

    public void setImageAssetDelegate(p3.b bVar) {
        this.f5369s.setImageAssetDelegate(bVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f5369s.setImagesAssetsFolder(str);
    }

    @Override // androidx.appcompat.widget.q, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        a();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.q, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        a();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.q, android.widget.ImageView
    public void setImageResource(int i10) {
        a();
        super.setImageResource(i10);
    }

    public void setMaxFrame(int i10) {
        this.f5369s.setMaxFrame(i10);
    }

    public void setMaxProgress(float f10) {
        this.f5369s.setMaxProgress(f10);
    }

    public void setMinAndMaxFrame(String str) {
        this.f5369s.setMinAndMaxFrame(str);
    }

    public void setMinFrame(int i10) {
        this.f5369s.setMinFrame(i10);
    }

    public void setMinProgress(float f10) {
        this.f5369s.setMinProgress(f10);
    }

    public void setPerformanceTrackingEnabled(boolean z10) {
        this.f5369s.setPerformanceTrackingEnabled(z10);
    }

    public void setProgress(float f10) {
        this.f5369s.setProgress(f10);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.B = renderMode;
        b();
    }

    public void setRepeatCount(int i10) {
        this.f5369s.setRepeatCount(i10);
    }

    public void setRepeatMode(int i10) {
        this.f5369s.setRepeatMode(i10);
    }

    public void setSafeMode(boolean z10) {
        this.f5369s.setSafeMode(z10);
    }

    public void setScale(float f10) {
        f fVar = this.f5369s;
        fVar.setScale(f10);
        if (getDrawable() == fVar) {
            setImageDrawable(null);
            setImageDrawable(fVar);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        f fVar = this.f5369s;
        if (fVar != null) {
            fVar.f17465s = scaleType;
        }
    }

    public void setSpeed(float f10) {
        this.f5369s.setSpeed(f10);
    }

    public void setTextDelegate(p3.q qVar) {
        this.f5369s.setTextDelegate(qVar);
    }

    public void setAnimationFromJson(String str, String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setMaxFrame(String str) {
        this.f5369s.setMaxFrame(str);
    }

    public void setMinFrame(String str) {
        this.f5369s.setMinFrame(str);
    }

    public void setAnimation(String str) {
        this.f5371u = str;
        this.f5372v = 0;
        setCompositionTask(this.A ? e.fromAsset(getContext(), str) : e.fromAsset(getContext(), str, null));
    }

    public void setAnimation(InputStream inputStream, String str) {
        setCompositionTask(e.fromJsonInputStream(inputStream, str));
    }
}
