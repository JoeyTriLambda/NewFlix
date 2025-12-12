package x3;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.model.layer.Layer;
import p3.k;
import s3.p;

/* compiled from: SolidLayer.java */
/* loaded from: classes.dex */
public final class e extends com.airbnb.lottie.model.layer.a {
    public final Path A;
    public final Layer B;
    public p C;

    /* renamed from: x, reason: collision with root package name */
    public final RectF f21503x;

    /* renamed from: y, reason: collision with root package name */
    public final q3.a f21504y;

    /* renamed from: z, reason: collision with root package name */
    public final float[] f21505z;

    public e(p3.f fVar, Layer layer) {
        super(fVar, layer);
        this.f21503x = new RectF();
        q3.a aVar = new q3.a();
        this.f21504y = aVar;
        this.f21505z = new float[8];
        this.A = new Path();
        this.B = layer;
        aVar.setAlpha(0);
        aVar.setStyle(Paint.Style.FILL);
        aVar.setColor(layer.f5481l);
    }

    @Override // com.airbnb.lottie.model.layer.a, u3.e
    public <T> void addValueCallback(T t10, b4.c<T> cVar) {
        super.addValueCallback(t10, cVar);
        if (t10 == k.C) {
            if (cVar == null) {
                this.C = null;
            } else {
                this.C = new p(cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void drawLayer(Canvas canvas, Matrix matrix, int i10) {
        Layer layer = this.B;
        int iAlpha = Color.alpha(layer.f5481l);
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((((iAlpha / 255.0f) * (this.f5520v.getOpacity() == null ? 100 : r2.getOpacity().getValue().intValue())) / 100.0f) * (i10 / 255.0f) * 255.0f);
        q3.a aVar = this.f21504y;
        aVar.setAlpha(iIntValue);
        p pVar = this.C;
        if (pVar != null) {
            aVar.setColorFilter((ColorFilter) pVar.getValue());
        }
        if (iIntValue > 0) {
            float[] fArr = this.f21505z;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            float f10 = layer.f5479j;
            fArr[2] = f10;
            fArr[3] = 0.0f;
            fArr[4] = f10;
            float f11 = layer.f5480k;
            fArr[5] = f11;
            fArr[6] = 0.0f;
            fArr[7] = f11;
            matrix.mapPoints(fArr);
            Path path = this.A;
            path.reset();
            path.moveTo(fArr[0], fArr[1]);
            path.lineTo(fArr[2], fArr[3]);
            path.lineTo(fArr[4], fArr[5]);
            path.lineTo(fArr[6], fArr[7]);
            path.lineTo(fArr[0], fArr[1]);
            path.close();
            canvas.drawPath(path, aVar);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, r3.e
    public void getBounds(RectF rectF, Matrix matrix, boolean z10) {
        super.getBounds(rectF, matrix, z10);
        RectF rectF2 = this.f21503x;
        Layer layer = this.B;
        rectF2.set(0.0f, 0.0f, layer.f5479j, layer.f5480k);
        this.f5511m.mapRect(rectF2);
        rectF.set(rectF2);
    }
}
