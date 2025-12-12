package z3;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: AnimatablePathValueParser.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f22563a = JsonReader.a.of("k", "x", "y");

    public static v3.m<PointF, PointF> a(JsonReader jsonReader, p3.d dVar) throws IOException {
        jsonReader.beginObject();
        v3.e eVar = null;
        v3.b bVar = null;
        v3.b bVar2 = null;
        boolean z10 = false;
        while (jsonReader.peek() != JsonReader.Token.END_OBJECT) {
            int iSelectName = jsonReader.selectName(f22563a);
            if (iSelectName != 0) {
                JsonReader.Token token = JsonReader.Token.STRING;
                if (iSelectName != 1) {
                    if (iSelectName != 2) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                    } else if (jsonReader.peek() == token) {
                        jsonReader.skipValue();
                        z10 = true;
                    } else {
                        bVar2 = d.parseFloat(jsonReader, dVar);
                    }
                } else if (jsonReader.peek() == token) {
                    jsonReader.skipValue();
                    z10 = true;
                } else {
                    bVar = d.parseFloat(jsonReader, dVar);
                }
            } else {
                eVar = parse(jsonReader, dVar);
            }
        }
        jsonReader.endObject();
        if (z10) {
            dVar.addWarning("Lottie doesn't support expressions.");
        }
        return eVar != null ? eVar : new v3.i(bVar, bVar2);
    }

    public static v3.e parse(JsonReader jsonReader, p3.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(new s3.h(dVar, q.a(jsonReader, dVar, a4.h.dpScale(), v.f22606a, jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT)));
            }
            jsonReader.endArray();
            r.setEndFrames(arrayList);
        } else {
            arrayList.add(new b4.a(p.b(jsonReader, a4.h.dpScale())));
        }
        return new v3.e(arrayList);
    }
}
