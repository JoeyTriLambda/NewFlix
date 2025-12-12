package a4;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;
import r3.k;

/* compiled from: MiscUtils.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final PointF f323a = new PointF();

    public static int a(float f10, float f11) {
        int i10 = (int) f10;
        int i11 = (int) f11;
        int i12 = i10 / i11;
        int i13 = i10 % i11;
        if (!((i10 ^ i11) >= 0) && i13 != 0) {
            i12--;
        }
        return i10 - (i11 * i12);
    }

    public static PointF addPoints(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static int clamp(int i10, int i11, int i12) {
        return Math.max(i11, Math.min(i12, i10));
    }

    public static boolean contains(float f10, float f11, float f12) {
        return f10 >= f11 && f10 <= f12;
    }

    public static void getPathFromData(w3.g gVar, Path path) {
        path.reset();
        PointF initialPoint = gVar.getInitialPoint();
        path.moveTo(initialPoint.x, initialPoint.y);
        PointF pointF = f323a;
        pointF.set(initialPoint.x, initialPoint.y);
        for (int i10 = 0; i10 < gVar.getCurves().size(); i10++) {
            u3.a aVar = gVar.getCurves().get(i10);
            PointF controlPoint1 = aVar.getControlPoint1();
            PointF controlPoint2 = aVar.getControlPoint2();
            PointF vertex = aVar.getVertex();
            if (controlPoint1.equals(pointF) && controlPoint2.equals(vertex)) {
                path.lineTo(vertex.x, vertex.y);
            } else {
                path.cubicTo(controlPoint1.x, controlPoint1.y, controlPoint2.x, controlPoint2.y, vertex.x, vertex.y);
            }
            pointF.set(vertex.x, vertex.y);
        }
        if (gVar.isClosed()) {
            path.close();
        }
    }

    public static double lerp(double d10, double d11, double d12) {
        return ((d11 - d10) * d12) + d10;
    }

    public static void resolveKeyPath(u3.d dVar, int i10, List<u3.d> list, u3.d dVar2, k kVar) {
        if (dVar.fullyResolvesTo(kVar.getName(), i10)) {
            list.add(dVar2.addKey(kVar.getName()).resolve(kVar));
        }
    }

    public static float clamp(float f10, float f11, float f12) {
        return Math.max(f11, Math.min(f12, f10));
    }

    public static float lerp(float f10, float f11, float f12) {
        return o1.a.a(f11, f10, f12, f10);
    }

    public static int lerp(int i10, int i11, float f10) {
        return (int) ((f10 * (i11 - i10)) + i10);
    }
}
