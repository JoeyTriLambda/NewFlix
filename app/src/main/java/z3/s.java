package z3;

import android.graphics.Rect;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.util.Collections;

/* compiled from: LayerParser.java */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f22598a = JsonReader.a.of("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f22599b = JsonReader.a.of("d", "a");

    /* renamed from: c, reason: collision with root package name */
    public static final JsonReader.a f22600c = JsonReader.a.of("nm");

    public static Layer parse(p3.d dVar) {
        Rect bounds = dVar.getBounds();
        return new Layer(Collections.emptyList(), dVar, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new v3.l(), 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x027b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.airbnb.lottie.model.layer.Layer parse(com.airbnb.lottie.parser.moshi.JsonReader r41, p3.d r42) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1088
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.s.parse(com.airbnb.lottie.parser.moshi.JsonReader, p3.d):com.airbnb.lottie.model.layer.Layer");
    }
}
