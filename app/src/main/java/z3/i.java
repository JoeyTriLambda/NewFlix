package z3;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: FloatParser.java */
/* loaded from: classes.dex */
public final class i implements h0<Float> {

    /* renamed from: a, reason: collision with root package name */
    public static final i f22582a = new i();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // z3.h0
    public Float parse(JsonReader jsonReader, float f10) throws IOException {
        return Float.valueOf(p.d(jsonReader) * f10);
    }
}
