package z3;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: AnimatableTransformParser.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f22569a = JsonReader.a.of("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f22570b = JsonReader.a.of("k");

    /* JADX WARN: Multi-variable type inference failed */
    public static v3.l parse(JsonReader jsonReader, p3.d dVar) throws IOException {
        boolean z10 = jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT;
        if (z10) {
            jsonReader.beginObject();
        }
        v3.b bVar = null;
        v3.e eVar = null;
        v3.m<PointF, PointF> mVarA = null;
        v3.g gVar = null;
        v3.b bVar2 = null;
        v3.b bVar3 = null;
        v3.d dVarA = null;
        v3.b bVar4 = null;
        v3.b bVar5 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(f22569a)) {
                case 0:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if (jsonReader.selectName(f22570b) != 0) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            eVar = a.parse(jsonReader, dVar);
                        }
                    }
                    jsonReader.endObject();
                    continue;
                case 1:
                    mVarA = a.a(jsonReader, dVar);
                    continue;
                case 2:
                    gVar = new v3.g(r.a(1.0f, dVar, a0.f22564a, jsonReader));
                    continue;
                case 3:
                    dVar.addWarning("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    dVarA = d.a(jsonReader, dVar);
                    continue;
                case 6:
                    bVar4 = d.parseFloat(jsonReader, dVar, false);
                    continue;
                case 7:
                    bVar5 = d.parseFloat(jsonReader, dVar, false);
                    continue;
                case 8:
                    bVar2 = d.parseFloat(jsonReader, dVar, false);
                    continue;
                case 9:
                    bVar3 = d.parseFloat(jsonReader, dVar, false);
                    continue;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue;
            }
            v3.b bVar6 = d.parseFloat(jsonReader, dVar, false);
            if (bVar6.getKeyframes().isEmpty()) {
                bVar6.getKeyframes().add(new b4.a(dVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(dVar.getEndFrame())));
            } else if (((b4.a) bVar6.getKeyframes().get(0)).f4756b == 0) {
                bVar6.getKeyframes().set(0, new b4.a(dVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(dVar.getEndFrame())));
            }
            bVar = bVar6;
        }
        if (z10) {
            jsonReader.endObject();
        }
        if (eVar == null || (eVar.isStatic() && eVar.getKeyframes().get(0).f4756b.equals(0.0f, 0.0f))) {
            eVar = null;
        }
        v3.m<PointF, PointF> mVar = mVarA == null || (!(mVarA instanceof v3.i) && mVarA.isStatic() && mVarA.getKeyframes().get(0).f4756b.equals(0.0f, 0.0f)) ? null : mVarA;
        v3.b bVar7 = bVar == null || (bVar.isStatic() && (((Float) ((b4.a) bVar.getKeyframes().get(0)).f4756b).floatValue() > 0.0f ? 1 : (((Float) ((b4.a) bVar.getKeyframes().get(0)).f4756b).floatValue() == 0.0f ? 0 : -1)) == 0) ? null : bVar;
        if (gVar == null || (gVar.isStatic() && ((b4.d) ((b4.a) gVar.getKeyframes().get(0)).f4756b).equals(1.0f, 1.0f))) {
            gVar = null;
        }
        return new v3.l(eVar, mVar, gVar, bVar7, dVarA, bVar4, bVar5, bVar2 == null || (bVar2.isStatic() && (((Float) ((b4.a) bVar2.getKeyframes().get(0)).f4756b).floatValue() > 0.0f ? 1 : (((Float) ((b4.a) bVar2.getKeyframes().get(0)).f4756b).floatValue() == 0.0f ? 0 : -1)) == 0) ? null : bVar2, bVar3 == null || (bVar3.isStatic() && (((Float) ((b4.a) bVar3.getKeyframes().get(0)).f4756b).floatValue() > 0.0f ? 1 : (((Float) ((b4.a) bVar3.getKeyframes().get(0)).f4756b).floatValue() == 0.0f ? 0 : -1)) == 0) ? null : bVar3);
    }
}
