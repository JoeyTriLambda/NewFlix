package z3;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: KeyframesParser.java */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f22597a = JsonReader.a.of("k");

    public static ArrayList a(float f10, p3.d dVar, h0 h0Var, JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonReader.Token.STRING) {
            dVar.addWarning("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(f22597a) != 0) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonReader.Token.NUMBER) {
                    arrayList.add(q.a(jsonReader, dVar, f10, h0Var, false));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(q.a(jsonReader, dVar, f10, h0Var, true));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(q.a(jsonReader, dVar, f10, h0Var, false));
            }
        }
        jsonReader.endObject();
        setEndFrames(arrayList);
        return arrayList;
    }

    public static <T> void setEndFrames(List<? extends b4.a<T>> list) {
        int i10;
        T t10;
        int size = list.size();
        int i11 = 0;
        while (true) {
            i10 = size - 1;
            if (i11 >= i10) {
                break;
            }
            b4.a<T> aVar = list.get(i11);
            i11++;
            b4.a<T> aVar2 = list.get(i11);
            aVar.f4760f = Float.valueOf(aVar2.f4759e);
            if (aVar.f4757c == null && (t10 = aVar2.f4756b) != null) {
                aVar.f4757c = t10;
                if (aVar instanceof s3.h) {
                    ((s3.h) aVar).createPath();
                }
            }
        }
        b4.a<T> aVar3 = list.get(i10);
        if ((aVar3.f4756b == null || aVar3.f4757c == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
