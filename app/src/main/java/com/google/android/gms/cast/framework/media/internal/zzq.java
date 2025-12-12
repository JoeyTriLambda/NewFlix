package com.google.android.gms.cast.framework.media.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.gms.cast.internal.Logger;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzq implements zza {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzv f6588a;

    public zzq(zzv zzvVar) {
        this.f6588a = zzvVar;
    }

    @Override // com.google.android.gms.cast.framework.media.internal.zza
    public final void zza(Bitmap bitmap) {
        Logger logger = zzv.f6592v;
        Bitmap bitmap2 = null;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            float f10 = width;
            int i10 = (int) (((9.0f * f10) / 16.0f) + 0.5f);
            float f11 = (i10 - r3) / 2.0f;
            RectF rectF = new RectF(0.0f, f11, f10, bitmap.getHeight() + f11);
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, i10, config);
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, (Rect) null, rectF, (Paint) null);
            bitmap2 = bitmapCreateBitmap;
        }
        this.f6588a.d(bitmap2, 0);
    }
}
