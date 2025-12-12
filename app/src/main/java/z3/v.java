package z3;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: PathParser.java */
/* loaded from: classes.dex */
public final class v implements h0<PointF> {

    /* renamed from: a, reason: collision with root package name */
    public static final v f22606a = new v();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // z3.h0
    public PointF parse(JsonReader jsonReader, float f10) throws IOException {
        return p.b(jsonReader, f10);
    }
}
