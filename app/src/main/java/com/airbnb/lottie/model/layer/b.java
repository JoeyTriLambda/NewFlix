package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import b0.h;
import java.util.ArrayList;
import java.util.List;
import p3.d;
import p3.f;
import p3.k;
import s3.p;
import x3.c;
import x3.e;

/* compiled from: CompositionLayer.java */
/* loaded from: classes.dex */
public final class b extends a {
    public final RectF A;
    public final Paint B;

    /* renamed from: x, reason: collision with root package name */
    public s3.a<Float, Float> f5522x;

    /* renamed from: y, reason: collision with root package name */
    public final ArrayList f5523y;

    /* renamed from: z, reason: collision with root package name */
    public final RectF f5524z;

    public b(f fVar, Layer layer, List<Layer> list, d dVar) {
        int i10;
        a aVar;
        a bVar;
        super(fVar, layer);
        this.f5523y = new ArrayList();
        this.f5524z = new RectF();
        this.A = new RectF();
        this.B = new Paint();
        v3.b bVar2 = layer.f5488s;
        if (bVar2 != null) {
            s3.a<Float, Float> aVarCreateAnimation = bVar2.createAnimation();
            this.f5522x = aVarCreateAnimation;
            addAnimation(aVarCreateAnimation);
            this.f5522x.addUpdateListener(this);
        } else {
            this.f5522x = null;
        }
        h hVar = new h(dVar.getLayers().size());
        int size = list.size() - 1;
        a aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            int iOrdinal = layer2.getLayerType().ordinal();
            if (iOrdinal == 0) {
                bVar = new b(fVar, layer2, dVar.getPrecomps(layer2.f5476g), dVar);
            } else if (iOrdinal == 1) {
                bVar = new e(fVar, layer2);
            } else if (iOrdinal == 2) {
                bVar = new x3.b(fVar, layer2);
            } else if (iOrdinal == 3) {
                bVar = new c(fVar, layer2);
            } else if (iOrdinal == 4) {
                bVar = new x3.d(fVar, layer2);
            } else if (iOrdinal != 5) {
                a4.d.warning("Unknown layer type " + layer2.getLayerType());
                bVar = null;
            } else {
                bVar = new x3.f(fVar, layer2);
            }
            if (bVar != null) {
                hVar.put(bVar.f5513o.getId(), bVar);
                if (aVar2 != null) {
                    aVar2.f5516r = bVar;
                    aVar2 = null;
                } else {
                    this.f5523y.add(0, bVar);
                    int iOrdinal2 = layer2.f5490u.ordinal();
                    if (iOrdinal2 == 1 || iOrdinal2 == 2) {
                        aVar2 = bVar;
                    }
                }
            }
            size--;
        }
        for (i10 = 0; i10 < hVar.size(); i10++) {
            a aVar3 = (a) hVar.get(hVar.keyAt(i10));
            if (aVar3 != null && (aVar = (a) hVar.get(aVar3.f5513o.f5475f)) != null) {
                aVar3.f5517s = aVar;
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, u3.e
    public <T> void addValueCallback(T t10, b4.c<T> cVar) {
        super.addValueCallback(t10, cVar);
        if (t10 == k.A) {
            if (cVar == null) {
                s3.a<Float, Float> aVar = this.f5522x;
                if (aVar != null) {
                    aVar.setValueCallback(null);
                    return;
                }
                return;
            }
            p pVar = new p(cVar);
            this.f5522x = pVar;
            pVar.addUpdateListener(this);
            addAnimation(this.f5522x);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public final void drawLayer(Canvas canvas, Matrix matrix, int i10) {
        p3.c.beginSection("CompositionLayer#draw");
        RectF rectF = this.A;
        Layer layer = this.f5513o;
        rectF.set(0.0f, 0.0f, layer.f5484o, layer.f5485p);
        matrix.mapRect(rectF);
        boolean zIsApplyingOpacityToLayersEnabled = this.f5512n.isApplyingOpacityToLayersEnabled();
        ArrayList arrayList = this.f5523y;
        boolean z10 = zIsApplyingOpacityToLayersEnabled && arrayList.size() > 1 && i10 != 255;
        if (z10) {
            Paint paint = this.B;
            paint.setAlpha(i10);
            a4.h.saveLayerCompat(canvas, rectF, paint);
        } else {
            canvas.save();
        }
        if (z10) {
            i10 = 255;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (!rectF.isEmpty() ? canvas.clipRect(rectF) : true) {
                ((a) arrayList.get(size)).draw(canvas, matrix, i10);
            }
        }
        canvas.restore();
        p3.c.endSection("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.model.layer.a, r3.e
    public void getBounds(RectF rectF, Matrix matrix, boolean z10) {
        super.getBounds(rectF, matrix, z10);
        ArrayList arrayList = this.f5523y;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            RectF rectF2 = this.f5524z;
            rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
            ((a) arrayList.get(size)).getBounds(rectF2, this.f5511m, true);
            rectF.union(rectF2);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void resolveChildKeyPath(u3.d dVar, int i10, List<u3.d> list, u3.d dVar2) {
        int i11 = 0;
        while (true) {
            ArrayList arrayList = this.f5523y;
            if (i11 >= arrayList.size()) {
                return;
            }
            ((a) arrayList.get(i11)).resolveKeyPath(dVar, i10, list, dVar2);
            i11++;
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void setProgress(float f10) {
        super.setProgress(f10);
        s3.a<Float, Float> aVar = this.f5522x;
        Layer layer = this.f5513o;
        if (aVar != null) {
            f10 = ((layer.f5471b.getFrameRate() * this.f5522x.getValue().floatValue()) - layer.f5471b.getStartFrame()) / (this.f5512n.getComposition().getDurationFrames() + 0.01f);
        }
        if (this.f5522x == null) {
            f10 -= layer.f5483n / layer.f5471b.getDurationFrames();
        }
        float f11 = layer.f5482m;
        if (f11 != 0.0f) {
            f10 /= f11;
        }
        ArrayList arrayList = this.f5523y;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                ((a) arrayList.get(size)).setProgress(f10);
            }
        }
    }
}
