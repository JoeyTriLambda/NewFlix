package z3;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: JsonUtils.java */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f22593a = JsonReader.a.of("x", "y");

    public static int a(JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        int iNextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int iNextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int iNextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return Color.argb(255, iNextDouble, iNextDouble2, iNextDouble3);
    }

    public static PointF b(JsonReader jsonReader, float f10) throws IOException {
        int iOrdinal = jsonReader.peek().ordinal();
        if (iOrdinal == 0) {
            jsonReader.beginArray();
            float fNextDouble = (float) jsonReader.nextDouble();
            float fNextDouble2 = (float) jsonReader.nextDouble();
            while (jsonReader.peek() != JsonReader.Token.END_ARRAY) {
                jsonReader.skipValue();
            }
            jsonReader.endArray();
            return new PointF(fNextDouble * f10, fNextDouble2 * f10);
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 6) {
                throw new IllegalArgumentException("Unknown point starts with " + jsonReader.peek());
            }
            float fNextDouble3 = (float) jsonReader.nextDouble();
            float fNextDouble4 = (float) jsonReader.nextDouble();
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return new PointF(fNextDouble3 * f10, fNextDouble4 * f10);
        }
        jsonReader.beginObject();
        float fD = 0.0f;
        float fD2 = 0.0f;
        while (jsonReader.hasNext()) {
            int iSelectName = jsonReader.selectName(f22593a);
            if (iSelectName == 0) {
                fD = d(jsonReader);
            } else if (iSelectName != 1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                fD2 = d(jsonReader);
            }
        }
        jsonReader.endObject();
        return new PointF(fD * f10, fD2 * f10);
    }

    public static ArrayList c(JsonReader jsonReader, float f10) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(b(jsonReader, f10));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    public static float d(JsonReader jsonReader) throws IOException {
        JsonReader.Token tokenPeek = jsonReader.peek();
        int iOrdinal = tokenPeek.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 6) {
                return (float) jsonReader.nextDouble();
            }
            throw new IllegalArgumentException("Unknown value for token of type " + tokenPeek);
        }
        jsonReader.beginArray();
        float fNextDouble = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return fNextDouble;
    }
}
