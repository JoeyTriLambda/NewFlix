package z3;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: ShapeDataParser.java */
/* loaded from: classes.dex */
public final class b0 implements h0<w3.g> {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f22567a = new b0();

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f22568b = JsonReader.a.of("c", "v", "i", "o");

    @Override // z3.h0
    public w3.g parse(JsonReader jsonReader, float f10) throws IOException {
        if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        ArrayList arrayListC = null;
        ArrayList arrayListC2 = null;
        ArrayList arrayListC3 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            int iSelectName = jsonReader.selectName(f22568b);
            if (iSelectName == 0) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if (iSelectName == 1) {
                arrayListC = p.c(jsonReader, f10);
            } else if (iSelectName == 2) {
                arrayListC2 = p.c(jsonReader, f10);
            } else if (iSelectName != 3) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                arrayListC3 = p.c(jsonReader, f10);
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == JsonReader.Token.END_ARRAY) {
            jsonReader.endArray();
        }
        if (arrayListC == null || arrayListC2 == null || arrayListC3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (arrayListC.isEmpty()) {
            return new w3.g(new PointF(), false, Collections.emptyList());
        }
        int size = arrayListC.size();
        PointF pointF = (PointF) arrayListC.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 1; i10 < size; i10++) {
            PointF pointF2 = (PointF) arrayListC.get(i10);
            int i11 = i10 - 1;
            arrayList.add(new u3.a(a4.g.addPoints((PointF) arrayListC.get(i11), (PointF) arrayListC3.get(i11)), a4.g.addPoints(pointF2, (PointF) arrayListC2.get(i10)), pointF2));
        }
        if (zNextBoolean) {
            PointF pointF3 = (PointF) arrayListC.get(0);
            int i12 = size - 1;
            arrayList.add(new u3.a(a4.g.addPoints((PointF) arrayListC.get(i12), (PointF) arrayListC3.get(i12)), a4.g.addPoints(pointF3, (PointF) arrayListC2.get(0)), pointF3));
        }
        return new w3.g(pointF, zNextBoolean, arrayList);
    }
}
