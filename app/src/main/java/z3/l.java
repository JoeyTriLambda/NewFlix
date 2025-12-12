package z3;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: GradientColorParser.java */
/* loaded from: classes.dex */
public final class l implements h0<w3.c> {

    /* renamed from: a, reason: collision with root package name */
    public int f22586a;

    public l(int i10) {
        this.f22586a = i10;
    }

    @Override // z3.h0
    public w3.c parse(JsonReader jsonReader, float f10) throws IOException {
        double dLerp;
        ArrayList arrayList = new ArrayList();
        boolean z10 = jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY;
        if (z10) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (z10) {
            jsonReader.endArray();
        }
        if (this.f22586a == -1) {
            this.f22586a = arrayList.size() / 4;
        }
        int i10 = this.f22586a;
        float[] fArr = new float[i10];
        int[] iArr = new int[i10];
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < this.f22586a * 4; i13++) {
            int i14 = i13 / 4;
            double dFloatValue = ((Float) arrayList.get(i13)).floatValue();
            int i15 = i13 % 4;
            if (i15 == 0) {
                fArr[i14] = (float) dFloatValue;
            } else if (i15 == 1) {
                i11 = (int) (dFloatValue * 255.0d);
            } else if (i15 == 2) {
                i12 = (int) (dFloatValue * 255.0d);
            } else if (i15 == 3) {
                iArr[i14] = Color.argb(255, i11, i12, (int) (dFloatValue * 255.0d));
            }
        }
        w3.c cVar = new w3.c(fArr, iArr);
        int i16 = this.f22586a * 4;
        if (arrayList.size() > i16) {
            int size = (arrayList.size() - i16) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i17 = 0;
            while (i16 < arrayList.size()) {
                if (i16 % 2 == 0) {
                    dArr[i17] = ((Float) arrayList.get(i16)).floatValue();
                } else {
                    dArr2[i17] = ((Float) arrayList.get(i16)).floatValue();
                    i17++;
                }
                i16++;
            }
            for (int i18 = 0; i18 < cVar.getSize(); i18++) {
                int i19 = cVar.getColors()[i18];
                double d10 = cVar.getPositions()[i18];
                int i20 = 1;
                while (true) {
                    if (i20 >= size) {
                        dLerp = dArr2[size - 1];
                        break;
                    }
                    int i21 = i20 - 1;
                    double d11 = dArr[i21];
                    double d12 = dArr[i20];
                    if (d12 >= d10) {
                        dLerp = a4.g.lerp(dArr2[i21], dArr2[i20], (d10 - d11) / (d12 - d11));
                        break;
                    }
                    i20++;
                }
                cVar.getColors()[i18] = Color.argb((int) (dLerp * 255.0d), Color.red(i19), Color.green(i19), Color.blue(i19));
            }
        }
        return cVar;
    }
}
