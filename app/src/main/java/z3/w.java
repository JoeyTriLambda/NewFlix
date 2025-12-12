package z3;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: PointFParser.java */
/* loaded from: classes.dex */
public final class w implements h0<PointF> {

    /* renamed from: a, reason: collision with root package name */
    public static final w f22607a = new w();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // z3.h0
    public PointF parse(JsonReader jsonReader, float f10) throws IOException {
        JsonReader.Token tokenPeek = jsonReader.peek();
        if (tokenPeek == JsonReader.Token.BEGIN_ARRAY) {
            return p.b(jsonReader, f10);
        }
        if (tokenPeek == JsonReader.Token.BEGIN_OBJECT) {
            return p.b(jsonReader, f10);
        }
        if (tokenPeek != JsonReader.Token.NUMBER) {
            throw new IllegalArgumentException("Cannot convert json to point. Next token is " + tokenPeek);
        }
        PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f10, ((float) jsonReader.nextDouble()) * f10);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return pointF;
    }
}
