package z3;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: ColorParser.java */
/* loaded from: classes.dex */
public final class f implements h0<Integer> {

    /* renamed from: a, reason: collision with root package name */
    public static final f f22575a = new f();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // z3.h0
    public Integer parse(JsonReader jsonReader, float f10) throws IOException {
        boolean z10 = jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY;
        if (z10) {
            jsonReader.beginArray();
        }
        double dNextDouble = jsonReader.nextDouble();
        double dNextDouble2 = jsonReader.nextDouble();
        double dNextDouble3 = jsonReader.nextDouble();
        double dNextDouble4 = jsonReader.nextDouble();
        if (z10) {
            jsonReader.endArray();
        }
        if (dNextDouble <= 1.0d && dNextDouble2 <= 1.0d && dNextDouble3 <= 1.0d) {
            dNextDouble *= 255.0d;
            dNextDouble2 *= 255.0d;
            dNextDouble3 *= 255.0d;
            if (dNextDouble4 <= 1.0d) {
                dNextDouble4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dNextDouble4, (int) dNextDouble, (int) dNextDouble2, (int) dNextDouble3));
    }
}
