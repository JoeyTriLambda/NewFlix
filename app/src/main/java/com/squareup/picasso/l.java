package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.k;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: RequestCreator.java */
/* loaded from: classes2.dex */
public final class l {

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicInteger f10610f = new AtomicInteger();

    /* renamed from: a, reason: collision with root package name */
    public final Picasso f10611a;

    /* renamed from: b, reason: collision with root package name */
    public final k.a f10612b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10613c;

    /* renamed from: d, reason: collision with root package name */
    public int f10614d;

    /* renamed from: e, reason: collision with root package name */
    public int f10615e;

    public l(Picasso picasso, Uri uri, int i10) {
        picasso.getClass();
        this.f10611a = picasso;
        this.f10612b = new k.a(uri, i10, picasso.f10495j);
    }

    public l centerCrop() {
        this.f10612b.centerCrop(17);
        return this;
    }

    public l centerInside() {
        this.f10612b.centerInside();
        return this;
    }

    public l error(int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Error image resource invalid.");
        }
        this.f10615e = i10;
        return this;
    }

    public l fit() {
        this.f10613c = true;
        return this;
    }

    public void into(ImageView imageView) {
        into(imageView, null);
    }

    public l placeholder(int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        }
        this.f10614d = i10;
        return this;
    }

    public l resize(int i10, int i11) {
        this.f10612b.resize(i10, i11);
        return this;
    }

    public l transform(sa.j jVar) {
        this.f10612b.transform(jVar);
        return this;
    }

    public void into(ImageView imageView, sa.b bVar) {
        long jNanoTime = System.nanoTime();
        StringBuilder sb2 = o.f10621a;
        if (!(Looper.getMainLooper().getThread() == Thread.currentThread())) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
        if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        }
        k.a aVar = this.f10612b;
        if (!((aVar.f10600a == null && aVar.f10601b == 0) ? false : true)) {
            this.f10611a.cancelRequest(imageView);
            int i10 = this.f10614d;
            i.b(imageView, i10 != 0 ? this.f10611a.f10488c.getDrawable(i10) : null);
            return;
        }
        if (this.f10613c) {
            if ((aVar.f10602c == 0 && aVar.f10603d == 0) ? false : true) {
                throw new IllegalStateException("Fit cannot be used with resize.");
            }
            int width = imageView.getWidth();
            int height = imageView.getHeight();
            if (width == 0 || height == 0) {
                int i11 = this.f10614d;
                i.b(imageView, i11 != 0 ? this.f10611a.f10488c.getDrawable(i11) : null);
                Picasso picasso = this.f10611a;
                sa.c cVar = new sa.c(this, imageView, bVar);
                WeakHashMap weakHashMap = picasso.f10493h;
                if (weakHashMap.containsKey(imageView)) {
                    picasso.a(imageView);
                }
                weakHashMap.put(imageView, cVar);
                return;
            }
            this.f10612b.resize(width, height);
        }
        int andIncrement = f10610f.getAndIncrement();
        k kVarBuild = this.f10612b.build();
        kVarBuild.f10582a = andIncrement;
        kVarBuild.f10583b = jNanoTime;
        boolean z10 = this.f10611a.f10497l;
        if (z10) {
            o.d("Main", "created", kVarBuild.c(), kVarBuild.toString());
        }
        Picasso.d dVar = this.f10611a.f10486a;
        k kVarTransformRequest = ((Picasso.d.a) dVar).transformRequest(kVarBuild);
        if (kVarTransformRequest == null) {
            throw new IllegalStateException("Request transformer " + dVar.getClass().getCanonicalName() + " returned null for " + kVarBuild);
        }
        if (kVarTransformRequest != kVarBuild) {
            kVarTransformRequest.f10582a = andIncrement;
            kVarTransformRequest.f10583b = jNanoTime;
            if (z10) {
                o.d("Main", "changed", kVarTransformRequest.a(), "into " + kVarTransformRequest);
            }
        }
        StringBuilder sb3 = o.f10621a;
        Uri uri = kVarTransformRequest.f10584c;
        if (uri != null) {
            String string = uri.toString();
            sb3.ensureCapacity(string.length() + 50);
            sb3.append(string);
        } else {
            sb3.ensureCapacity(50);
            sb3.append(kVarTransformRequest.f10585d);
        }
        sb3.append('\n');
        float f10 = kVarTransformRequest.f10593l;
        if (f10 != 0.0f) {
            sb3.append("rotation:");
            sb3.append(f10);
            if (kVarTransformRequest.f10596o) {
                sb3.append('@');
                sb3.append(kVarTransformRequest.f10594m);
                sb3.append('x');
                sb3.append(kVarTransformRequest.f10595n);
            }
            sb3.append('\n');
        }
        if (kVarTransformRequest.hasSize()) {
            sb3.append("resize:");
            sb3.append(kVarTransformRequest.f10587f);
            sb3.append('x');
            sb3.append(kVarTransformRequest.f10588g);
            sb3.append('\n');
        }
        if (kVarTransformRequest.f10589h) {
            sb3.append("centerCrop:");
            sb3.append(kVarTransformRequest.f10590i);
            sb3.append('\n');
        } else if (kVarTransformRequest.f10591j) {
            sb3.append("centerInside");
            sb3.append('\n');
        }
        List<sa.j> list = kVarTransformRequest.f10586e;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                sb3.append(list.get(i12).key());
                sb3.append('\n');
            }
        }
        String string2 = sb3.toString();
        sb3.setLength(0);
        Picasso picasso2 = this.f10611a;
        Bitmap bitmap = ((sa.e) picasso2.f10490e).get(string2);
        sa.h hVar = picasso2.f10491f;
        if (bitmap != null) {
            hVar.f19197b.sendEmptyMessage(0);
        } else {
            hVar.f19197b.sendEmptyMessage(1);
        }
        if (bitmap == null) {
            int i13 = this.f10614d;
            i.b(imageView, i13 != 0 ? this.f10611a.f10488c.getDrawable(i13) : null);
            this.f10611a.c(new h(this.f10611a, imageView, kVarTransformRequest, this.f10615e, string2, bVar));
            return;
        }
        this.f10611a.cancelRequest(imageView);
        Picasso picasso3 = this.f10611a;
        Context context = picasso3.f10488c;
        Picasso.LoadedFrom loadedFrom = Picasso.LoadedFrom.MEMORY;
        i.a(imageView, context, bitmap, loadedFrom, false, picasso3.f10496k);
        if (this.f10611a.f10497l) {
            o.d("Main", "completed", kVarTransformRequest.c(), "from " + loadedFrom);
        }
        if (bVar != null) {
            bVar.onSuccess();
        }
    }
}
