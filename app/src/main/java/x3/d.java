package x3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.model.layer.Layer;
import java.util.Collections;
import java.util.List;
import w3.i;

/* compiled from: ShapeLayer.java */
/* loaded from: classes.dex */
public final class d extends com.airbnb.lottie.model.layer.a {

    /* renamed from: x, reason: collision with root package name */
    public final r3.d f21502x;

    public d(p3.f fVar, Layer layer) {
        super(fVar, layer);
        r3.d dVar = new r3.d(fVar, this, new i("__container", layer.f5470a, false));
        this.f21502x = dVar;
        dVar.setContents(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.a
    public final void drawLayer(Canvas canvas, Matrix matrix, int i10) {
        this.f21502x.draw(canvas, matrix, i10);
    }

    @Override // com.airbnb.lottie.model.layer.a, r3.e
    public void getBounds(RectF rectF, Matrix matrix, boolean z10) {
        super.getBounds(rectF, matrix, z10);
        this.f21502x.getBounds(rectF, this.f5511m, z10);
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void resolveChildKeyPath(u3.d dVar, int i10, List<u3.d> list, u3.d dVar2) {
        this.f21502x.resolveKeyPath(dVar, i10, list, dVar2);
    }
}
