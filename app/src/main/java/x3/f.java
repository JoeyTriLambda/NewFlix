package x3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import b0.h;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import s3.n;
import s3.o;
import s3.p;
import v3.k;
import w3.i;

/* compiled from: TextLayer.java */
/* loaded from: classes.dex */
public final class f extends com.airbnb.lottie.model.layer.a {
    public final a A;
    public final b B;
    public final HashMap C;
    public final h<String> D;
    public final n E;
    public final p3.f F;
    public final p3.d G;
    public final s3.a<Integer, Integer> H;
    public p I;
    public final s3.a<Integer, Integer> J;
    public p K;
    public final s3.a<Float, Float> L;
    public p M;
    public final s3.a<Float, Float> N;
    public p O;
    public p P;

    /* renamed from: x, reason: collision with root package name */
    public final StringBuilder f21506x;

    /* renamed from: y, reason: collision with root package name */
    public final RectF f21507y;

    /* renamed from: z, reason: collision with root package name */
    public final Matrix f21508z;

    /* compiled from: TextLayer.java */
    public class a extends Paint {
        public a() {
            super(1);
            setStyle(Paint.Style.FILL);
        }
    }

    /* compiled from: TextLayer.java */
    public class b extends Paint {
        public b() {
            super(1);
            setStyle(Paint.Style.STROKE);
        }
    }

    public f(p3.f fVar, Layer layer) {
        v3.b bVar;
        v3.b bVar2;
        v3.a aVar;
        v3.a aVar2;
        super(fVar, layer);
        this.f21506x = new StringBuilder(2);
        this.f21507y = new RectF();
        this.f21508z = new Matrix();
        this.A = new a();
        this.B = new b();
        this.C = new HashMap();
        this.D = new h<>();
        this.F = fVar;
        this.G = layer.f5471b;
        n nVarCreateAnimation = layer.f5486q.createAnimation();
        this.E = nVarCreateAnimation;
        nVarCreateAnimation.addUpdateListener(this);
        addAnimation(nVarCreateAnimation);
        k kVar = layer.f5487r;
        if (kVar != null && (aVar2 = kVar.f20448a) != null) {
            s3.a<Integer, Integer> aVarCreateAnimation = aVar2.createAnimation();
            this.H = aVarCreateAnimation;
            aVarCreateAnimation.addUpdateListener(this);
            addAnimation(aVarCreateAnimation);
        }
        if (kVar != null && (aVar = kVar.f20449b) != null) {
            s3.a<Integer, Integer> aVarCreateAnimation2 = aVar.createAnimation();
            this.J = aVarCreateAnimation2;
            aVarCreateAnimation2.addUpdateListener(this);
            addAnimation(aVarCreateAnimation2);
        }
        if (kVar != null && (bVar2 = kVar.f20450c) != null) {
            s3.a<Float, Float> aVarCreateAnimation3 = bVar2.createAnimation();
            this.L = aVarCreateAnimation3;
            aVarCreateAnimation3.addUpdateListener(this);
            addAnimation(aVarCreateAnimation3);
        }
        if (kVar == null || (bVar = kVar.f20451d) == null) {
            return;
        }
        s3.a<Float, Float> aVarCreateAnimation4 = bVar.createAnimation();
        this.N = aVarCreateAnimation4;
        aVarCreateAnimation4.addUpdateListener(this);
        addAnimation(aVarCreateAnimation4);
    }

    public static void d(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    public static void e(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    @Override // com.airbnb.lottie.model.layer.a, u3.e
    public <T> void addValueCallback(T t10, b4.c<T> cVar) {
        super.addValueCallback(t10, cVar);
        if (t10 == p3.k.f17506a) {
            p pVar = this.I;
            if (pVar != null) {
                removeAnimation(pVar);
            }
            if (cVar == null) {
                this.I = null;
                return;
            }
            p pVar2 = new p(cVar);
            this.I = pVar2;
            pVar2.addUpdateListener(this);
            addAnimation(this.I);
            return;
        }
        if (t10 == p3.k.f17507b) {
            p pVar3 = this.K;
            if (pVar3 != null) {
                removeAnimation(pVar3);
            }
            if (cVar == null) {
                this.K = null;
                return;
            }
            p pVar4 = new p(cVar);
            this.K = pVar4;
            pVar4.addUpdateListener(this);
            addAnimation(this.K);
            return;
        }
        if (t10 == p3.k.f17520o) {
            p pVar5 = this.M;
            if (pVar5 != null) {
                removeAnimation(pVar5);
            }
            if (cVar == null) {
                this.M = null;
                return;
            }
            p pVar6 = new p(cVar);
            this.M = pVar6;
            pVar6.addUpdateListener(this);
            addAnimation(this.M);
            return;
        }
        if (t10 == p3.k.f17521p) {
            p pVar7 = this.O;
            if (pVar7 != null) {
                removeAnimation(pVar7);
            }
            if (cVar == null) {
                this.O = null;
                return;
            }
            p pVar8 = new p(cVar);
            this.O = pVar8;
            pVar8.addUpdateListener(this);
            addAnimation(this.O);
            return;
        }
        if (t10 == p3.k.B) {
            p pVar9 = this.P;
            if (pVar9 != null) {
                removeAnimation(pVar9);
            }
            if (cVar == null) {
                this.P = null;
                return;
            }
            p pVar10 = new p(cVar);
            this.P = pVar10;
            pVar10.addUpdateListener(this);
            addAnimation(this.P);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public final void drawLayer(Canvas canvas, Matrix matrix, int i10) {
        float f10;
        List list;
        int i11;
        String str;
        float fFloatValue;
        p3.d dVar;
        DocumentData.Justification justification;
        p3.f fVar;
        List list2;
        a aVar;
        DocumentData documentData;
        int i12;
        int i13;
        float fFloatValue2;
        b bVar;
        a aVar2;
        p3.d dVar2;
        u3.b bVar2;
        p3.f fVar2;
        canvas.save();
        p3.f fVar3 = this.F;
        if (!fVar3.useTextGlyphs()) {
            canvas.setMatrix(matrix);
        }
        DocumentData value = this.E.getValue();
        p3.d dVar3 = this.G;
        u3.b bVar3 = dVar3.getFonts().get(value.f5390b);
        if (bVar3 == null) {
            canvas.restore();
            return;
        }
        p pVar = this.I;
        a aVar3 = this.A;
        if (pVar != null) {
            aVar3.setColor(((Integer) pVar.getValue()).intValue());
        } else {
            s3.a<Integer, Integer> aVar4 = this.H;
            if (aVar4 != null) {
                aVar3.setColor(aVar4.getValue().intValue());
            } else {
                aVar3.setColor(value.f5396h);
            }
        }
        p pVar2 = this.K;
        b bVar4 = this.B;
        if (pVar2 != null) {
            bVar4.setColor(((Integer) pVar2.getValue()).intValue());
        } else {
            s3.a<Integer, Integer> aVar5 = this.J;
            if (aVar5 != null) {
                bVar4.setColor(aVar5.getValue().intValue());
            } else {
                bVar4.setColor(value.f5397i);
            }
        }
        o oVar = this.f5520v;
        int iIntValue = ((oVar.getOpacity() == null ? 100 : oVar.getOpacity().getValue().intValue()) * 255) / 100;
        aVar3.setAlpha(iIntValue);
        bVar4.setAlpha(iIntValue);
        p pVar3 = this.M;
        if (pVar3 != null) {
            bVar4.setStrokeWidth(((Float) pVar3.getValue()).floatValue());
        } else {
            s3.a<Float, Float> aVar6 = this.L;
            if (aVar6 != null) {
                bVar4.setStrokeWidth(aVar6.getValue().floatValue());
            } else {
                bVar4.setStrokeWidth(a4.h.dpScale() * value.f5398j * a4.h.getScale(matrix));
            }
        }
        boolean zUseTextGlyphs = fVar3.useTextGlyphs();
        s3.a<Float, Float> aVar7 = this.N;
        int i14 = value.f5393e;
        boolean z10 = value.f5399k;
        DocumentData.Justification justification2 = value.f5392d;
        float f11 = value.f5394f;
        int i15 = i14;
        float f12 = value.f5391c;
        String str2 = value.f5389a;
        if (zUseTextGlyphs) {
            p pVar4 = this.P;
            float fFloatValue3 = (pVar4 != null ? ((Float) pVar4.getValue()).floatValue() : f12) / 100.0f;
            b bVar5 = bVar4;
            float scale = a4.h.getScale(matrix);
            float fDpScale = a4.h.dpScale() * f11;
            List listAsList = Arrays.asList(str2.replaceAll("\r\n", StringUtils.CR).replaceAll(StringUtils.LF, StringUtils.CR).split(StringUtils.CR));
            int size = listAsList.size();
            int i16 = 0;
            while (i16 < size) {
                String str3 = (String) listAsList.get(i16);
                a aVar8 = aVar3;
                List list3 = listAsList;
                int i17 = 0;
                float width = 0.0f;
                while (i17 < str3.length()) {
                    boolean z11 = z10;
                    DocumentData documentData2 = value;
                    u3.c cVar = dVar3.getCharacters().get(u3.c.hashFor(str3.charAt(i17), bVar3.getFamily(), bVar3.getStyle()));
                    if (cVar == null) {
                        fVar2 = fVar3;
                        dVar2 = dVar3;
                        bVar2 = bVar3;
                    } else {
                        dVar2 = dVar3;
                        bVar2 = bVar3;
                        fVar2 = fVar3;
                        width = (float) ((cVar.getWidth() * fFloatValue3 * a4.h.dpScale() * scale) + width);
                    }
                    i17++;
                    dVar3 = dVar2;
                    bVar3 = bVar2;
                    z10 = z11;
                    value = documentData2;
                    fVar3 = fVar2;
                }
                p3.f fVar4 = fVar3;
                DocumentData documentData3 = value;
                p3.d dVar4 = dVar3;
                boolean z12 = z10;
                u3.b bVar6 = bVar3;
                canvas.save();
                int iOrdinal = justification2.ordinal();
                if (iOrdinal == 1) {
                    canvas.translate(-width, 0.0f);
                } else if (iOrdinal == 2) {
                    canvas.translate((-width) / 2.0f, 0.0f);
                }
                canvas.translate(0.0f, (i16 * fDpScale) - (((size - 1) * fDpScale) / 2.0f));
                int i18 = 0;
                while (i18 < str3.length()) {
                    u3.c cVar2 = dVar4.getCharacters().get(u3.c.hashFor(str3.charAt(i18), bVar6.getFamily(), bVar6.getStyle()));
                    if (cVar2 == null) {
                        dVar = dVar4;
                        justification = justification2;
                        i13 = i15;
                        aVar = aVar8;
                        fVar = fVar4;
                        documentData = documentData3;
                        i12 = size;
                    } else {
                        HashMap map = this.C;
                        if (map.containsKey(cVar2)) {
                            list2 = (List) map.get(cVar2);
                            dVar = dVar4;
                            justification = justification2;
                            fVar = fVar4;
                        } else {
                            List<i> shapes = cVar2.getShapes();
                            int size2 = shapes.size();
                            ArrayList arrayList = new ArrayList(size2);
                            dVar = dVar4;
                            int i19 = 0;
                            while (i19 < size2) {
                                arrayList.add(new r3.d(fVar4, this, shapes.get(i19)));
                                i19++;
                                size2 = size2;
                                shapes = shapes;
                                justification2 = justification2;
                            }
                            justification = justification2;
                            fVar = fVar4;
                            map.put(cVar2, arrayList);
                            list2 = arrayList;
                        }
                        int i20 = 0;
                        while (i20 < list2.size()) {
                            Path path = ((r3.d) list2.get(i20)).getPath();
                            path.computeBounds(this.f21507y, false);
                            Matrix matrix2 = this.f21508z;
                            matrix2.set(matrix);
                            List list4 = list2;
                            DocumentData documentData4 = documentData3;
                            int i21 = size;
                            matrix2.preTranslate(0.0f, (-documentData4.f5395g) * a4.h.dpScale());
                            matrix2.preScale(fFloatValue3, fFloatValue3);
                            path.transform(matrix2);
                            if (z12) {
                                aVar2 = aVar8;
                                e(path, aVar2, canvas);
                                bVar = bVar5;
                                e(path, bVar, canvas);
                            } else {
                                bVar = bVar5;
                                aVar2 = aVar8;
                                e(path, bVar, canvas);
                                e(path, aVar2, canvas);
                            }
                            i20++;
                            aVar8 = aVar2;
                            bVar5 = bVar;
                            size = i21;
                            list2 = list4;
                            documentData3 = documentData4;
                        }
                        aVar = aVar8;
                        documentData = documentData3;
                        i12 = size;
                        float fDpScale2 = a4.h.dpScale() * ((float) cVar2.getWidth()) * fFloatValue3 * scale;
                        i13 = i15;
                        float f13 = i13 / 10.0f;
                        p pVar5 = this.O;
                        if (pVar5 != null) {
                            fFloatValue2 = ((Float) pVar5.getValue()).floatValue();
                        } else {
                            if (aVar7 != null) {
                                fFloatValue2 = aVar7.getValue().floatValue();
                            }
                            canvas.translate((f13 * scale) + fDpScale2, 0.0f);
                        }
                        f13 += fFloatValue2;
                        canvas.translate((f13 * scale) + fDpScale2, 0.0f);
                    }
                    i18++;
                    i15 = i13;
                    aVar8 = aVar;
                    size = i12;
                    dVar4 = dVar;
                    documentData3 = documentData;
                    fVar4 = fVar;
                    justification2 = justification;
                }
                p3.d dVar5 = dVar4;
                canvas.restore();
                i16++;
                aVar3 = aVar8;
                fVar3 = fVar4;
                bVar3 = bVar6;
                listAsList = list3;
                z10 = z12;
                dVar3 = dVar5;
                value = documentData3;
                justification2 = justification2;
            }
        } else {
            float scale2 = a4.h.getScale(matrix);
            Typeface typeface = fVar3.getTypeface(bVar3.getFamily(), bVar3.getStyle());
            if (typeface != null) {
                fVar3.getTextDelegate();
                aVar3.setTypeface(typeface);
                p pVar6 = this.P;
                aVar3.setTextSize(a4.h.dpScale() * (pVar6 != null ? ((Float) pVar6.getValue()).floatValue() : f12));
                bVar4.setTypeface(aVar3.getTypeface());
                bVar4.setTextSize(aVar3.getTextSize());
                float fDpScale3 = a4.h.dpScale() * f11;
                List listAsList2 = Arrays.asList(str2.replaceAll("\r\n", StringUtils.CR).replaceAll(StringUtils.LF, StringUtils.CR).split(StringUtils.CR));
                int size3 = listAsList2.size();
                int i22 = 0;
                while (i22 < size3) {
                    String str4 = (String) listAsList2.get(i22);
                    float fMeasureText = bVar4.measureText(str4);
                    int iOrdinal2 = justification2.ordinal();
                    if (iOrdinal2 == 1) {
                        canvas.translate(-fMeasureText, 0.0f);
                    } else if (iOrdinal2 == 2) {
                        canvas.translate((-fMeasureText) / 2.0f, 0.0f);
                    }
                    canvas.translate(0.0f, (i22 * fDpScale3) - (((size3 - 1) * fDpScale3) / 2.0f));
                    int length = 0;
                    while (length < str4.length()) {
                        int iCodePointAt = str4.codePointAt(length);
                        int iCharCount = Character.charCount(iCodePointAt) + length;
                        while (true) {
                            if (iCharCount >= str4.length()) {
                                f10 = fDpScale3;
                                break;
                            }
                            int iCodePointAt2 = str4.codePointAt(iCharCount);
                            f10 = fDpScale3;
                            if (!(Character.getType(iCodePointAt2) == 16 || Character.getType(iCodePointAt2) == 27 || Character.getType(iCodePointAt2) == 6 || Character.getType(iCodePointAt2) == 28 || Character.getType(iCodePointAt2) == 19)) {
                                break;
                            }
                            iCharCount += Character.charCount(iCodePointAt2);
                            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
                            fDpScale3 = f10;
                        }
                        long j10 = iCodePointAt;
                        h<String> hVar = this.D;
                        if (hVar.containsKey(j10)) {
                            str = hVar.get(j10);
                            list = listAsList2;
                            i11 = size3;
                        } else {
                            StringBuilder sb2 = this.f21506x;
                            list = listAsList2;
                            sb2.setLength(0);
                            int iCharCount2 = length;
                            while (iCharCount2 < iCharCount) {
                                int i23 = size3;
                                int iCodePointAt3 = str4.codePointAt(iCharCount2);
                                sb2.appendCodePoint(iCodePointAt3);
                                iCharCount2 += Character.charCount(iCodePointAt3);
                                size3 = i23;
                            }
                            i11 = size3;
                            String string = sb2.toString();
                            hVar.put(j10, string);
                            str = string;
                        }
                        length += str.length();
                        if (z10) {
                            d(str, aVar3, canvas);
                            d(str, bVar4, canvas);
                        } else {
                            d(str, bVar4, canvas);
                            d(str, aVar3, canvas);
                        }
                        float fMeasureText2 = aVar3.measureText(str, 0, 1);
                        float f14 = i15 / 10.0f;
                        p pVar7 = this.O;
                        if (pVar7 != null) {
                            fFloatValue = ((Float) pVar7.getValue()).floatValue();
                        } else if (aVar7 != null) {
                            fFloatValue = aVar7.getValue().floatValue();
                        } else {
                            canvas.translate((f14 * scale2) + fMeasureText2, 0.0f);
                            fDpScale3 = f10;
                            listAsList2 = list;
                            size3 = i11;
                        }
                        f14 += fFloatValue;
                        canvas.translate((f14 * scale2) + fMeasureText2, 0.0f);
                        fDpScale3 = f10;
                        listAsList2 = list;
                        size3 = i11;
                    }
                    canvas.setMatrix(matrix);
                    i22++;
                    fDpScale3 = fDpScale3;
                    listAsList2 = listAsList2;
                    size3 = size3;
                }
            }
        }
        canvas.restore();
    }

    @Override // com.airbnb.lottie.model.layer.a, r3.e
    public void getBounds(RectF rectF, Matrix matrix, boolean z10) {
        super.getBounds(rectF, matrix, z10);
        p3.d dVar = this.G;
        rectF.set(0.0f, 0.0f, dVar.getBounds().width(), dVar.getBounds().height());
    }
}
