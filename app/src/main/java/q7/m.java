package q7;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import q7.g;

/* compiled from: ShapeAppearancePathProvider.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final o[] f17992a = new o[4];

    /* renamed from: b, reason: collision with root package name */
    public final Matrix[] f17993b = new Matrix[4];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix[] f17994c = new Matrix[4];

    /* renamed from: d, reason: collision with root package name */
    public final PointF f17995d = new PointF();

    /* renamed from: e, reason: collision with root package name */
    public final Path f17996e = new Path();

    /* renamed from: f, reason: collision with root package name */
    public final Path f17997f = new Path();

    /* renamed from: g, reason: collision with root package name */
    public final o f17998g = new o();

    /* renamed from: h, reason: collision with root package name */
    public final float[] f17999h = new float[2];

    /* renamed from: i, reason: collision with root package name */
    public final float[] f18000i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    public final Path f18001j = new Path();

    /* renamed from: k, reason: collision with root package name */
    public final Path f18002k = new Path();

    /* renamed from: l, reason: collision with root package name */
    public final boolean f18003l = true;

    /* compiled from: ShapeAppearancePathProvider.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final m f18004a = new m();
    }

    /* compiled from: ShapeAppearancePathProvider.java */
    public interface b {
    }

    public m() {
        for (int i10 = 0; i10 < 4; i10++) {
            this.f17992a[i10] = new o();
            this.f17993b[i10] = new Matrix();
            this.f17994c[i10] = new Matrix();
        }
    }

    public static m getInstance() {
        return a.f18004a;
    }

    public final boolean a(Path path, int i10) {
        Path path2 = this.f18002k;
        path2.reset();
        this.f17992a[i10].applyToPath(this.f17993b[i10], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    public void calculatePath(l lVar, float f10, RectF rectF, Path path) {
        calculatePath(lVar, f10, rectF, null, path);
    }

    public void calculatePath(l lVar, float f10, RectF rectF, b bVar, Path path) {
        int i10;
        Matrix[] matrixArr;
        float[] fArr;
        Matrix[] matrixArr2;
        o[] oVarArr;
        path.rewind();
        Path path2 = this.f17996e;
        path2.rewind();
        Path path3 = this.f17997f;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        char c10 = 0;
        int i11 = 0;
        while (true) {
            i10 = 4;
            matrixArr = this.f17994c;
            fArr = this.f17999h;
            matrixArr2 = this.f17993b;
            oVarArr = this.f17992a;
            if (i11 >= 4) {
                break;
            }
            (i11 != 1 ? i11 != 2 ? i11 != 3 ? lVar.getTopRightCorner() : lVar.getTopLeftCorner() : lVar.getBottomLeftCorner() : lVar.getBottomRightCorner()).getCornerPath(oVarArr[i11], 90.0f, f10, rectF, i11 != 1 ? i11 != 2 ? i11 != 3 ? lVar.getTopRightCornerSize() : lVar.getTopLeftCornerSize() : lVar.getBottomLeftCornerSize() : lVar.getBottomRightCornerSize());
            int i12 = i11 + 1;
            float f11 = (i12 % 4) * 90;
            matrixArr2[i11].reset();
            PointF pointF = this.f17995d;
            if (i11 == 1) {
                pointF.set(rectF.right, rectF.bottom);
            } else if (i11 == 2) {
                pointF.set(rectF.left, rectF.bottom);
            } else if (i11 != 3) {
                pointF.set(rectF.right, rectF.top);
            } else {
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i11].setTranslate(pointF.x, pointF.y);
            matrixArr2[i11].preRotate(f11);
            o oVar = oVarArr[i11];
            fArr[0] = oVar.f18009c;
            fArr[1] = oVar.f18010d;
            matrixArr2[i11].mapPoints(fArr);
            matrixArr[i11].reset();
            matrixArr[i11].setTranslate(fArr[0], fArr[1]);
            matrixArr[i11].preRotate(f11);
            i11 = i12;
        }
        int i13 = 0;
        while (i13 < i10) {
            o oVar2 = oVarArr[i13];
            fArr[c10] = oVar2.f18007a;
            fArr[1] = oVar2.f18008b;
            matrixArr2[i13].mapPoints(fArr);
            if (i13 == 0) {
                path.moveTo(fArr[c10], fArr[1]);
            } else {
                path.lineTo(fArr[c10], fArr[1]);
            }
            oVarArr[i13].applyToPath(matrixArr2[i13], path);
            if (bVar != null) {
                ((g.a) bVar).onCornerPathCreated(oVarArr[i13], matrixArr2[i13], i13);
            }
            int i14 = i13 + 1;
            int i15 = i14 % 4;
            o oVar3 = oVarArr[i13];
            fArr[c10] = oVar3.f18009c;
            fArr[1] = oVar3.f18010d;
            matrixArr2[i13].mapPoints(fArr);
            o oVar4 = oVarArr[i15];
            float f12 = oVar4.f18007a;
            float[] fArr2 = this.f18000i;
            fArr2[c10] = f12;
            fArr2[1] = oVar4.f18008b;
            matrixArr2[i15].mapPoints(fArr2);
            float fMax = Math.max(((float) Math.hypot(fArr[c10] - fArr2[c10], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
            o oVar5 = oVarArr[i13];
            fArr[0] = oVar5.f18009c;
            fArr[1] = oVar5.f18010d;
            matrixArr2[i13].mapPoints(fArr);
            float fAbs = (i13 == 1 || i13 == 3) ? Math.abs(rectF.centerX() - fArr[0]) : Math.abs(rectF.centerY() - fArr[1]);
            o oVar6 = this.f17998g;
            oVar6.reset(0.0f, 0.0f);
            (i13 != 1 ? i13 != 2 ? i13 != 3 ? lVar.getRightEdge() : lVar.getTopEdge() : lVar.getLeftEdge() : lVar.getBottomEdge()).getEdgePath(fMax, fAbs, f10, oVar6);
            Path path4 = this.f18001j;
            path4.reset();
            oVar6.applyToPath(matrixArr[i13], path4);
            if (this.f18003l && (a(path4, i13) || a(path4, i15))) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr[0] = oVar6.f18007a;
                fArr[1] = oVar6.f18008b;
                matrixArr[i13].mapPoints(fArr);
                path2.moveTo(fArr[0], fArr[1]);
                oVar6.applyToPath(matrixArr[i13], path2);
            } else {
                oVar6.applyToPath(matrixArr[i13], path);
            }
            if (bVar != null) {
                ((g.a) bVar).onEdgePathCreated(oVar6, matrixArr[i13], i13);
            }
            i13 = i14;
            i10 = 4;
            c10 = 0;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }
}
