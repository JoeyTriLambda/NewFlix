package z3;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: ScaleXYParser.java */
/* loaded from: classes.dex */
public final class a0 implements h0<b4.d> {

    /* renamed from: a, reason: collision with root package name */
    public static final a0 f22564a = new a0();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // z3.h0
    public b4.d parse(JsonReader jsonReader, float f10) throws IOException {
        boolean z10 = jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY;
        if (z10) {
            jsonReader.beginArray();
        }
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z10) {
            jsonReader.endArray();
        }
        return new b4.d((fNextDouble / 100.0f) * f10, (fNextDouble2 / 100.0f) * f10);
    }
}
