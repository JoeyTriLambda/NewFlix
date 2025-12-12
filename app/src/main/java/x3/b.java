package x3;

import a4.h;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.model.layer.Layer;
import p3.k;
import s3.p;

/* compiled from: ImageLayer.java */
/* loaded from: classes.dex */
public final class b extends com.airbnb.lottie.model.layer.a {
    public p A;

    /* renamed from: x, reason: collision with root package name */
    public final q3.a f21499x;

    /* renamed from: y, reason: collision with root package name */
    public final Rect f21500y;

    /* renamed from: z, reason: collision with root package name */
    public final Rect f21501z;

    public b(p3.f fVar, Layer layer) {
        super(fVar, layer);
        this.f21499x = new q3.a(3);
        this.f21500y = new Rect();
        this.f21501z = new Rect();
    }

    @Override // com.airbnb.lottie.model.layer.a, u3.e
    public <T> void addValueCallback(T t10, b4.c<T> cVar) {
        super.addValueCallback(t10, cVar);
        if (t10 == k.C) {
            if (cVar == null) {
                this.A = null;
            } else {
                this.A = new p(cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void drawLayer(Canvas canvas, Matrix matrix, int i10) {
        Bitmap imageAsset = this.f5512n.getImageAsset(this.f5513o.f5476g);
        if (imageAsset == null || imageAsset.isRecycled()) {
            return;
        }
        float fDpScale = h.dpScale();
        q3.a aVar = this.f21499x;
        aVar.setAlpha(i10);
        p pVar = this.A;
        if (pVar != null) {
            aVar.setColorFilter((ColorFilter) pVar.getValue());
        }
        canvas.save();
        canvas.concat(matrix);
        int width = imageAsset.getWidth();
        int height = imageAsset.getHeight();
        Rect rect = this.f21500y;
        rect.set(0, 0, width, height);
        int width2 = (int) (imageAsset.getWidth() * fDpScale);
        int height2 = (int) (imageAsset.getHeight() * fDpScale);
        Rect rect2 = this.f21501z;
        rect2.set(0, 0, width2, height2);
        canvas.drawBitmap(imageAsset, rect, rect2, aVar);
        canvas.restore();
    }

    @Override // com.airbnb.lottie.model.layer.a, r3.e
    public void getBounds(RectF rectF, Matrix matrix, boolean z10) {
        super.getBounds(rectF, matrix, z10);
        if (this.f5512n.getImageAsset(this.f5513o.f5476g) != null) {
            rectF.set(0.0f, 0.0f, h.dpScale() * r3.getWidth(), h.dpScale() * r3.getHeight());
            this.f5511m.mapRect(rectF);
        }
    }
}
