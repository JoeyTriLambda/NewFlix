package p7;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* compiled from: ShadowRenderer.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f17626i = new int[3];

    /* renamed from: j, reason: collision with root package name */
    public static final float[] f17627j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f17628k = new int[4];

    /* renamed from: l, reason: collision with root package name */
    public static final float[] f17629l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public final Paint f17630a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f17631b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f17632c;

    /* renamed from: d, reason: collision with root package name */
    public int f17633d;

    /* renamed from: e, reason: collision with root package name */
    public int f17634e;

    /* renamed from: f, reason: collision with root package name */
    public int f17635f;

    /* renamed from: g, reason: collision with root package name */
    public final Path f17636g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f17637h;

    public a() {
        this(-16777216);
    }

    public void drawCornerShadow(Canvas canvas, Matrix matrix, RectF rectF, int i10, float f10, float f11) {
        boolean z10 = f11 < 0.0f;
        Path path = this.f17636g;
        int[] iArr = f17628k;
        if (z10) {
            iArr[0] = 0;
            iArr[1] = this.f17635f;
            iArr[2] = this.f17634e;
            iArr[3] = this.f17633d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f10, f11);
            path.close();
            float f12 = -i10;
            rectF.inset(f12, f12);
            iArr[0] = 0;
            iArr[1] = this.f17633d;
            iArr[2] = this.f17634e;
            iArr[3] = this.f17635f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f13 = 1.0f - (i10 / fWidth);
        float[] fArr = f17629l;
        fArr[1] = f13;
        fArr[2] = ((1.0f - f13) / 2.0f) + f13;
        RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, iArr, fArr, Shader.TileMode.CLAMP);
        Paint paint = this.f17631b;
        paint.setShader(radialGradient);
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z10) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f17637h);
        }
        canvas.drawArc(rectF, f10, f11, true, paint);
        canvas.restore();
    }

    public void drawEdgeShadow(Canvas canvas, Matrix matrix, RectF rectF, int i10) {
        rectF.bottom += i10;
        rectF.offset(0.0f, -i10);
        int[] iArr = f17626i;
        iArr[0] = this.f17635f;
        iArr[1] = this.f17634e;
        iArr[2] = this.f17633d;
        Paint paint = this.f17632c;
        float f10 = rectF.left;
        paint.setShader(new LinearGradient(f10, rectF.top, f10, rectF.bottom, iArr, f17627j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public Paint getShadowPaint() {
        return this.f17630a;
    }

    public void setShadowColor(int i10) {
        this.f17633d = o0.a.setAlphaComponent(i10, 68);
        this.f17634e = o0.a.setAlphaComponent(i10, 20);
        this.f17635f = o0.a.setAlphaComponent(i10, 0);
        this.f17630a.setColor(this.f17633d);
    }

    public a(int i10) {
        this.f17636g = new Path();
        Paint paint = new Paint();
        this.f17637h = paint;
        this.f17630a = new Paint();
        setShadowColor(i10);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f17631b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f17632c = new Paint(paint2);
    }
}
