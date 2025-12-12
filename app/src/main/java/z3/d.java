package z3;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: AnimatableValueParser.java */
/* loaded from: classes.dex */
public final class d {
    public static v3.d a(JsonReader jsonReader, p3.d dVar) throws IOException {
        return new v3.d(r.a(1.0f, dVar, o.f22592a, jsonReader));
    }

    public static v3.f b(JsonReader jsonReader, p3.d dVar) throws IOException {
        return new v3.f(r.a(a4.h.dpScale(), dVar, w.f22607a, jsonReader));
    }

    public static v3.b parseFloat(JsonReader jsonReader, p3.d dVar) throws IOException {
        return parseFloat(jsonReader, dVar, true);
    }

    public static v3.b parseFloat(JsonReader jsonReader, p3.d dVar, boolean z10) throws IOException {
        return new v3.b(r.a(z10 ? a4.h.dpScale() : 1.0f, dVar, i.f22582a, jsonReader));
    }
}
