package z3;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: AnimatableTextPropertiesParser.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f22565a = JsonReader.a.of("a");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f22566b = JsonReader.a.of("fc", "sc", "sw", "t");

    public static v3.k parse(JsonReader jsonReader, p3.d dVar) throws IOException {
        jsonReader.beginObject();
        v3.k kVar = null;
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(f22565a) != 0) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                jsonReader.beginObject();
                v3.a aVar = null;
                v3.a aVar2 = null;
                v3.b bVar = null;
                v3.b bVar2 = null;
                while (jsonReader.hasNext()) {
                    int iSelectName = jsonReader.selectName(f22566b);
                    f fVar = f.f22575a;
                    if (iSelectName == 0) {
                        aVar = new v3.a(r.a(1.0f, dVar, fVar, jsonReader));
                    } else if (iSelectName == 1) {
                        aVar2 = new v3.a(r.a(1.0f, dVar, fVar, jsonReader));
                    } else if (iSelectName == 2) {
                        bVar = d.parseFloat(jsonReader, dVar);
                    } else if (iSelectName != 3) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                    } else {
                        bVar2 = d.parseFloat(jsonReader, dVar);
                    }
                }
                jsonReader.endObject();
                kVar = new v3.k(aVar, aVar2, bVar, bVar2);
            }
        }
        jsonReader.endObject();
        return kVar == null ? new v3.k(null, null, null, null) : kVar;
    }
}
