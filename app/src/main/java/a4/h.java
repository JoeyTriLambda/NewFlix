package a4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;
import r3.s;

/* compiled from: Utils.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final PathMeasure f324a = new PathMeasure();

    /* renamed from: b, reason: collision with root package name */
    public static final Path f325b = new Path();

    /* renamed from: c, reason: collision with root package name */
    public static final Path f326c = new Path();

    /* renamed from: d, reason: collision with root package name */
    public static final float[] f327d = new float[4];

    /* renamed from: e, reason: collision with root package name */
    public static final float f328e = (float) (Math.sqrt(2.0d) / 2.0d);

    /* renamed from: f, reason: collision with root package name */
    public static float f329f = -1.0f;

    public static void applyTrimPathIfNeeded(Path path, s sVar) {
        if (sVar == null || sVar.isHidden()) {
            return;
        }
        applyTrimPathIfNeeded(path, ((s3.c) sVar.getStart()).getFloatValue() / 100.0f, ((s3.c) sVar.getEnd()).getFloatValue() / 100.0f, ((s3.c) sVar.getOffset()).getFloatValue() / 360.0f);
    }

    public static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    public static Path createPath(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f10 = pointF3.x + pointF.x;
            float f11 = pointF.y + pointF3.y;
            float f12 = pointF2.x;
            float f13 = f12 + pointF4.x;
            float f14 = pointF2.y;
            path.cubicTo(f10, f11, f13, f14 + pointF4.y, f12, f14);
        }
        return path;
    }

    public static float dpScale() {
        if (f329f == -1.0f) {
            f329f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f329f;
    }

    public static float getAnimationScale(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static float getScale(Matrix matrix) {
        float[] fArr = f327d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f10 = f328e;
        fArr[2] = f10;
        fArr[3] = f10;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static boolean hasZeroScaleAxis(Matrix matrix) {
        float[] fArr = f327d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static int hashFor(float f10, float f11, float f12, float f13) {
        int i10 = f10 != 0.0f ? (int) (527 * f10) : 17;
        if (f11 != 0.0f) {
            i10 = (int) (i10 * 31 * f11);
        }
        if (f12 != 0.0f) {
            i10 = (int) (i10 * 31 * f12);
        }
        return f13 != 0.0f ? (int) (i10 * 31 * f13) : i10;
    }

    public static boolean isAtLeastVersion(int i10, int i11, int i12, int i13, int i14, int i15) {
        if (i10 < i13) {
            return false;
        }
        if (i10 > i13) {
            return true;
        }
        if (i11 < i14) {
            return false;
        }
        return i11 > i14 || i12 >= i15;
    }

    public static boolean isNetworkException(Throwable th2) {
        return (th2 instanceof SocketException) || (th2 instanceof ClosedChannelException) || (th2 instanceof InterruptedIOException) || (th2 instanceof ProtocolException) || (th2 instanceof SSLException) || (th2 instanceof UnknownHostException) || (th2 instanceof UnknownServiceException);
    }

    public static Bitmap resizeBitmapIfNeeded(Bitmap bitmap, int i10, int i11) {
        if (bitmap.getWidth() == i10 && bitmap.getHeight() == i11) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i10, i11, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }

    public static void saveLayerCompat(Canvas canvas, RectF rectF, Paint paint) {
        saveLayerCompat(canvas, rectF, paint, 31);
    }

    public static void saveLayerCompat(Canvas canvas, RectF rectF, Paint paint, int i10) {
        p3.c.beginSection("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i10);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        p3.c.endSection("Utils#saveLayer");
    }

    public static void applyTrimPathIfNeeded(Path path, float f10, float f11, float f12) {
        p3.c.beginSection("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = f324a;
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f10 == 1.0f && f11 == 0.0f) {
            p3.c.endSection("applyTrimPathIfNeeded");
            return;
        }
        if (length >= 1.0f && Math.abs((f11 - f10) - 1.0f) >= 0.01d) {
            float f13 = f10 * length;
            float f14 = f11 * length;
            float f15 = f12 * length;
            float fMin = Math.min(f13, f14) + f15;
            float fMax = Math.max(f13, f14) + f15;
            if (fMin >= length && fMax >= length) {
                fMin = g.a(fMin, length);
                fMax = g.a(fMax, length);
            }
            if (fMin < 0.0f) {
                fMin = g.a(fMin, length);
            }
            if (fMax < 0.0f) {
                fMax = g.a(fMax, length);
            }
            if (fMin == fMax) {
                path.reset();
                p3.c.endSection("applyTrimPathIfNeeded");
                return;
            }
            if (fMin >= fMax) {
                fMin -= length;
            }
            Path path2 = f325b;
            path2.reset();
            pathMeasure.getSegment(fMin, fMax, path2, true);
            Path path3 = f326c;
            if (fMax > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, fMax % length, path3, true);
                path2.addPath(path3);
            } else if (fMin < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(fMin + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            p3.c.endSection("applyTrimPathIfNeeded");
            return;
        }
        p3.c.endSection("applyTrimPathIfNeeded");
    }
}
