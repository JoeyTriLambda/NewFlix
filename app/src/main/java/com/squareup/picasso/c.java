package com.squareup.picasso;

import ah.y;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.squareup.picasso.NetworkRequestHandler;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.f;
import com.squareup.picasso.m;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BitmapHunter.java */
/* loaded from: classes2.dex */
public final class c implements Runnable {
    public static final Object E = new Object();
    public static final a F = new a();
    public static final AtomicInteger G = new AtomicInteger();
    public static final b H = new b();
    public Exception A;
    public int B;
    public int C;
    public Picasso.Priority D;

    /* renamed from: b, reason: collision with root package name */
    public final int f10532b = G.incrementAndGet();

    /* renamed from: m, reason: collision with root package name */
    public final Picasso f10533m;

    /* renamed from: n, reason: collision with root package name */
    public final com.squareup.picasso.f f10534n;

    /* renamed from: o, reason: collision with root package name */
    public final sa.a f10535o;

    /* renamed from: p, reason: collision with root package name */
    public final sa.h f10536p;

    /* renamed from: q, reason: collision with root package name */
    public final String f10537q;

    /* renamed from: r, reason: collision with root package name */
    public final k f10538r;

    /* renamed from: s, reason: collision with root package name */
    public final int f10539s;

    /* renamed from: t, reason: collision with root package name */
    public int f10540t;

    /* renamed from: u, reason: collision with root package name */
    public final m f10541u;

    /* renamed from: v, reason: collision with root package name */
    public com.squareup.picasso.a f10542v;

    /* renamed from: w, reason: collision with root package name */
    public ArrayList f10543w;

    /* renamed from: x, reason: collision with root package name */
    public Bitmap f10544x;

    /* renamed from: y, reason: collision with root package name */
    public Future<?> f10545y;

    /* renamed from: z, reason: collision with root package name */
    public Picasso.LoadedFrom f10546z;

    /* compiled from: BitmapHunter.java */
    public static class a extends ThreadLocal<StringBuilder> {
        @Override // java.lang.ThreadLocal
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    }

    /* compiled from: BitmapHunter.java */
    public static class b extends m {
        @Override // com.squareup.picasso.m
        public boolean canHandleRequest(k kVar) {
            return true;
        }

        @Override // com.squareup.picasso.m
        public m.a load(k kVar, int i10) throws IOException {
            throw new IllegalStateException("Unrecognized type of request: " + kVar);
        }
    }

    /* compiled from: BitmapHunter.java */
    /* renamed from: com.squareup.picasso.c$c, reason: collision with other inner class name */
    public static class RunnableC0116c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ sa.j f10547b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ RuntimeException f10548m;

        public RunnableC0116c(sa.j jVar, RuntimeException runtimeException) {
            this.f10547b = jVar;
            this.f10548m = runtimeException;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw new RuntimeException("Transformation " + this.f10547b.key() + " crashed with exception.", this.f10548m);
        }
    }

    /* compiled from: BitmapHunter.java */
    public static class d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f10549b;

        public d(StringBuilder sb2) {
            this.f10549b = sb2;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw new NullPointerException(this.f10549b.toString());
        }
    }

    /* compiled from: BitmapHunter.java */
    public static class e implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ sa.j f10550b;

        public e(sa.j jVar) {
            this.f10550b = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw new IllegalStateException("Transformation " + this.f10550b.key() + " returned input Bitmap but recycled it.");
        }
    }

    /* compiled from: BitmapHunter.java */
    public static class f implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ sa.j f10551b;

        public f(sa.j jVar) {
            this.f10551b = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw new IllegalStateException("Transformation " + this.f10551b.key() + " mutated input Bitmap but failed to recycle the original.");
        }
    }

    public c(Picasso picasso, com.squareup.picasso.f fVar, sa.a aVar, sa.h hVar, com.squareup.picasso.a aVar2, m mVar) {
        this.f10533m = picasso;
        this.f10534n = fVar;
        this.f10535o = aVar;
        this.f10536p = hVar;
        this.f10542v = aVar2;
        this.f10537q = aVar2.f10524i;
        k kVar = aVar2.f10517b;
        this.f10538r = kVar;
        this.D = kVar.f10599r;
        this.f10539s = aVar2.f10520e;
        this.f10540t = aVar2.f10521f;
        this.f10541u = mVar;
        this.C = mVar.c();
    }

    public static Bitmap a(List<sa.j> list, Bitmap bitmap) {
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            sa.j jVar = list.get(i10);
            try {
                Bitmap bitmapTransform = jVar.transform(bitmap);
                if (bitmapTransform == null) {
                    StringBuilder sbR = ac.c.r("Transformation ");
                    sbR.append(jVar.key());
                    sbR.append(" returned null after ");
                    sbR.append(i10);
                    sbR.append(" previous transformation(s).\n\nTransformation list:\n");
                    Iterator<sa.j> it = list.iterator();
                    while (it.hasNext()) {
                        sbR.append(it.next().key());
                        sbR.append('\n');
                    }
                    Picasso.f10484m.post(new d(sbR));
                    return null;
                }
                if (bitmapTransform == bitmap && bitmap.isRecycled()) {
                    Picasso.f10484m.post(new e(jVar));
                    return null;
                }
                if (bitmapTransform != bitmap && !bitmap.isRecycled()) {
                    Picasso.f10484m.post(new f(jVar));
                    return null;
                }
                i10++;
                bitmap = bitmapTransform;
            } catch (RuntimeException e10) {
                Picasso.f10484m.post(new RunnableC0116c(jVar, e10));
                return null;
            }
        }
        return bitmap;
    }

    public static Bitmap c(y yVar, k kVar) throws IOException {
        ah.e eVarBuffer = ah.m.buffer(yVar);
        boolean z10 = eVarBuffer.rangeEquals(0L, o.f10622b) && eVarBuffer.rangeEquals(8L, o.f10623c);
        boolean z11 = kVar.f10597p;
        BitmapFactory.Options optionsB = m.b(kVar);
        boolean z12 = optionsB != null && optionsB.inJustDecodeBounds;
        int i10 = kVar.f10588g;
        int i11 = kVar.f10587f;
        if (z10) {
            byte[] byteArray = eVarBuffer.readByteArray();
            if (z12) {
                BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, optionsB);
                m.a(i11, i10, optionsB.outWidth, optionsB.outHeight, optionsB, kVar);
            }
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, optionsB);
        }
        InputStream inputStream = eVarBuffer.inputStream();
        if (z12) {
            sa.f fVar = new sa.f(inputStream);
            fVar.allowMarksToExpire(false);
            long jSavePosition = fVar.savePosition(1024);
            BitmapFactory.decodeStream(fVar, null, optionsB);
            m.a(i11, i10, optionsB.outWidth, optionsB.outHeight, optionsB, kVar);
            fVar.reset(jSavePosition);
            fVar.allowMarksToExpire(true);
            inputStream = fVar;
        }
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, optionsB);
        if (bitmapDecodeStream != null) {
            return bitmapDecodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap f(com.squareup.picasso.k r26, android.graphics.Bitmap r27, int r28) {
        /*
            Method dump skipped, instructions count: 628
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.c.f(com.squareup.picasso.k, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    public static void g(k kVar) {
        Uri uri = kVar.f10584c;
        String strValueOf = uri != null ? String.valueOf(uri.getPath()) : Integer.toHexString(kVar.f10585d);
        StringBuilder sb2 = F.get();
        sb2.ensureCapacity(strValueOf.length() + 8);
        sb2.replace(8, sb2.length(), strValueOf);
        Thread.currentThread().setName(sb2.toString());
    }

    public final boolean b() {
        Future<?> future;
        if (this.f10542v != null) {
            return false;
        }
        ArrayList arrayList = this.f10543w;
        return (arrayList == null || arrayList.isEmpty()) && (future = this.f10545y) != null && future.cancel(false);
    }

    public final void d(com.squareup.picasso.a aVar) {
        boolean zRemove;
        boolean z10 = true;
        if (this.f10542v == aVar) {
            this.f10542v = null;
            zRemove = true;
        } else {
            ArrayList arrayList = this.f10543w;
            zRemove = arrayList != null ? arrayList.remove(aVar) : false;
        }
        if (zRemove && aVar.f10517b.f10599r == this.D) {
            Picasso.Priority priority = Picasso.Priority.LOW;
            ArrayList arrayList2 = this.f10543w;
            boolean z11 = (arrayList2 == null || arrayList2.isEmpty()) ? false : true;
            com.squareup.picasso.a aVar2 = this.f10542v;
            if (aVar2 == null && !z11) {
                z10 = false;
            }
            if (z10) {
                if (aVar2 != null) {
                    priority = aVar2.f10517b.f10599r;
                }
                if (z11) {
                    int size = this.f10543w.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        Picasso.Priority priority2 = ((com.squareup.picasso.a) this.f10543w.get(i10)).f10517b.f10599r;
                        if (priority2.ordinal() > priority.ordinal()) {
                            priority = priority2;
                        }
                    }
                }
            }
            this.D = priority;
        }
        if (this.f10533m.f10497l) {
            o.d("Hunter", "removed", aVar.f10517b.a(), o.b(this, "from "));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Bitmap e() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.c.e():android.graphics.Bitmap");
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    g(this.f10538r);
                    if (this.f10533m.f10497l) {
                        o.c("Hunter", "executing", o.a(this));
                    }
                    Bitmap bitmapE = e();
                    this.f10544x = bitmapE;
                    if (bitmapE == null) {
                        f.a aVar = this.f10534n.f10562h;
                        aVar.sendMessage(aVar.obtainMessage(6, this));
                    } else {
                        this.f10534n.b(this);
                    }
                } catch (NetworkRequestHandler.ResponseException e10) {
                    if (!NetworkPolicy.isOfflineOnly(e10.f10483m) || e10.f10482b != 504) {
                        this.A = e10;
                    }
                    f.a aVar2 = this.f10534n.f10562h;
                    aVar2.sendMessage(aVar2.obtainMessage(6, this));
                } catch (Exception e11) {
                    this.A = e11;
                    f.a aVar3 = this.f10534n.f10562h;
                    aVar3.sendMessage(aVar3.obtainMessage(6, this));
                }
            } catch (IOException e12) {
                this.A = e12;
                f.a aVar4 = this.f10534n.f10562h;
                aVar4.sendMessageDelayed(aVar4.obtainMessage(5, this), 500L);
            } catch (OutOfMemoryError e13) {
                StringWriter stringWriter = new StringWriter();
                this.f10536p.a().dump(new PrintWriter(stringWriter));
                this.A = new RuntimeException(stringWriter.toString(), e13);
                f.a aVar5 = this.f10534n.f10562h;
                aVar5.sendMessage(aVar5.obtainMessage(6, this));
            }
            Thread.currentThread().setName("Picasso-Idle");
        } catch (Throwable th2) {
            Thread.currentThread().setName("Picasso-Idle");
            throw th2;
        }
    }
}
