package com.squareup.picasso;

import ah.y;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.picasso.Picasso;
import java.io.IOException;

/* compiled from: RequestHandler.java */
/* loaded from: classes2.dex */
public abstract class m {
    public static void a(int i10, int i11, int i12, int i13, BitmapFactory.Options options, k kVar) {
        int iMax;
        double dFloor;
        if (i13 > i11 || i12 > i10) {
            if (i11 == 0) {
                dFloor = Math.floor(i12 / i10);
            } else if (i10 == 0) {
                dFloor = Math.floor(i13 / i11);
            } else {
                int iFloor = (int) Math.floor(i13 / i11);
                int iFloor2 = (int) Math.floor(i12 / i10);
                iMax = kVar.f10591j ? Math.max(iFloor, iFloor2) : Math.min(iFloor, iFloor2);
            }
            iMax = (int) dFloor;
        } else {
            iMax = 1;
        }
        options.inSampleSize = iMax;
        options.inJustDecodeBounds = false;
    }

    public static BitmapFactory.Options b(k kVar) {
        boolean zHasSize = kVar.hasSize();
        Bitmap.Config config = kVar.f10598q;
        boolean z10 = config != null;
        boolean z11 = kVar.f10597p;
        if (!zHasSize && !z10 && !z11) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = zHasSize;
        options.inInputShareable = z11;
        options.inPurgeable = z11;
        if (z10) {
            options.inPreferredConfig = config;
        }
        return options;
    }

    public int c() {
        return 0;
    }

    public abstract boolean canHandleRequest(k kVar);

    public boolean d(NetworkInfo networkInfo) {
        return false;
    }

    public abstract a load(k kVar, int i10) throws IOException;

    /* compiled from: RequestHandler.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Picasso.LoadedFrom f10616a;

        /* renamed from: b, reason: collision with root package name */
        public final Bitmap f10617b;

        /* renamed from: c, reason: collision with root package name */
        public final y f10618c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10619d;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
            this(bitmap, null, loadedFrom, 0);
            StringBuilder sb2 = o.f10621a;
            if (bitmap == null) {
                throw new NullPointerException("bitmap == null");
            }
        }

        public Bitmap getBitmap() {
            return this.f10617b;
        }

        public Picasso.LoadedFrom getLoadedFrom() {
            return this.f10616a;
        }

        public y getSource() {
            return this.f10618c;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(y yVar, Picasso.LoadedFrom loadedFrom) {
            this(null, yVar, loadedFrom, 0);
            StringBuilder sb2 = o.f10621a;
            if (yVar == null) {
                throw new NullPointerException("source == null");
            }
        }

        public a(Bitmap bitmap, y yVar, Picasso.LoadedFrom loadedFrom, int i10) {
            if ((bitmap != null) != (yVar != null)) {
                this.f10617b = bitmap;
                this.f10618c = yVar;
                StringBuilder sb2 = o.f10621a;
                if (loadedFrom != null) {
                    this.f10616a = loadedFrom;
                    this.f10619d = i10;
                    return;
                }
                throw new NullPointerException("loadedFrom == null");
            }
            throw new AssertionError();
        }
    }
}
