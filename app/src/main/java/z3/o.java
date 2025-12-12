package z3;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: IntegerParser.java */
/* loaded from: classes.dex */
public final class o implements h0<Integer> {

    /* renamed from: a, reason: collision with root package name */
    public static final o f22592a = new o();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // z3.h0
    public Integer parse(JsonReader jsonReader, float f10) throws IOException {
        return Integer.valueOf(Math.round(p.d(jsonReader) * f10));
    }
}
