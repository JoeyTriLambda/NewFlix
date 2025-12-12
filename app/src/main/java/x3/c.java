package x3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.model.layer.Layer;

/* compiled from: NullLayer.java */
/* loaded from: classes.dex */
public final class c extends com.airbnb.lottie.model.layer.a {
    public c(p3.f fVar, Layer layer) {
        super(fVar, layer);
    }

    @Override // com.airbnb.lottie.model.layer.a, r3.e
    public void getBounds(RectF rectF, Matrix matrix, boolean z10) {
        super.getBounds(rectF, matrix, z10);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // com.airbnb.lottie.model.layer.a
    public final void drawLayer(Canvas canvas, Matrix matrix, int i10) {
    }
}
