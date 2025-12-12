package z3;

import android.graphics.Rect;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: LottieCompositionMoshiParser.java */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f22601a = JsonReader.a.of("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f22602b = JsonReader.a.of("id", "layers", "w", "h", "p", "u");

    /* renamed from: c, reason: collision with root package name */
    public static final JsonReader.a f22603c = JsonReader.a.of("list");

    /* renamed from: d, reason: collision with root package name */
    public static final JsonReader.a f22604d = JsonReader.a.of("cm", "tm", "dr");

    public static p3.d parse(JsonReader jsonReader) throws IOException {
        b0.l<u3.c> lVar;
        ArrayList arrayList;
        float f10;
        int i10;
        float f11;
        float f12;
        ArrayList arrayList2;
        float f13;
        int i11;
        b0.l<u3.c> lVar2;
        float fDpScale = a4.h.dpScale();
        b0.h<Layer> hVar = new b0.h<>();
        ArrayList arrayList3 = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList4 = new ArrayList();
        b0.l<u3.c> lVar3 = new b0.l<>();
        p3.d dVar = new p3.d();
        jsonReader.beginObject();
        int iNextInt = 0;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        int iNextInt2 = 0;
        while (jsonReader.hasNext()) {
            float f14 = fNextDouble3;
            switch (jsonReader.selectName(f22601a)) {
                case 0:
                    lVar = lVar3;
                    arrayList = arrayList4;
                    iNextInt2 = jsonReader.nextInt();
                    fNextDouble3 = f14;
                    arrayList4 = arrayList;
                    break;
                case 1:
                    lVar = lVar3;
                    iNextInt = jsonReader.nextInt();
                    fNextDouble3 = f14;
                    break;
                case 2:
                    lVar = lVar3;
                    arrayList = arrayList4;
                    f10 = fDpScale;
                    i10 = iNextInt;
                    fNextDouble = (float) jsonReader.nextDouble();
                    fDpScale = f10;
                    iNextInt = i10;
                    fNextDouble3 = f14;
                    arrayList4 = arrayList;
                    break;
                case 3:
                    lVar = lVar3;
                    arrayList = arrayList4;
                    f10 = fDpScale;
                    i10 = iNextInt;
                    fNextDouble2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    fDpScale = f10;
                    iNextInt = i10;
                    fNextDouble3 = f14;
                    arrayList4 = arrayList;
                    break;
                case 4:
                    lVar = lVar3;
                    arrayList = arrayList4;
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    fDpScale = fDpScale;
                    iNextInt = iNextInt;
                    arrayList4 = arrayList;
                    break;
                case 5:
                    f11 = fNextDouble;
                    f12 = fNextDouble2;
                    lVar = lVar3;
                    arrayList2 = arrayList4;
                    f13 = fDpScale;
                    i11 = iNextInt;
                    String[] strArrSplit = jsonReader.nextString().split("\\.");
                    if (!a4.h.isAtLeastVersion(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        dVar.addWarning("Lottie only supports bodymovin >= 4.4.0");
                    }
                    fDpScale = f13;
                    iNextInt = i11;
                    fNextDouble3 = f14;
                    fNextDouble = f11;
                    arrayList4 = arrayList2;
                    fNextDouble2 = f12;
                    break;
                case 6:
                    f11 = fNextDouble;
                    f12 = fNextDouble2;
                    lVar = lVar3;
                    arrayList2 = arrayList4;
                    f13 = fDpScale;
                    i11 = iNextInt;
                    jsonReader.beginArray();
                    int i12 = 0;
                    while (jsonReader.hasNext()) {
                        Layer layer = s.parse(jsonReader, dVar);
                        if (layer.getLayerType() == Layer.LayerType.IMAGE) {
                            i12++;
                        }
                        arrayList3.add(layer);
                        hVar.put(layer.getId(), layer);
                        if (i12 > 4) {
                            a4.d.warning("You have " + i12 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                        }
                    }
                    jsonReader.endArray();
                    fDpScale = f13;
                    iNextInt = i11;
                    fNextDouble3 = f14;
                    fNextDouble = f11;
                    arrayList4 = arrayList2;
                    fNextDouble2 = f12;
                    break;
                case 7:
                    f11 = fNextDouble;
                    f12 = fNextDouble2;
                    lVar = lVar3;
                    arrayList2 = arrayList4;
                    f13 = fDpScale;
                    i11 = iNextInt;
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        ArrayList arrayList5 = new ArrayList();
                        b0.h hVar2 = new b0.h();
                        jsonReader.beginObject();
                        String strNextString = null;
                        String strNextString2 = null;
                        String strNextString3 = null;
                        int iNextInt3 = 0;
                        int iNextInt4 = 0;
                        while (jsonReader.hasNext()) {
                            int iSelectName = jsonReader.selectName(f22602b);
                            if (iSelectName == 0) {
                                strNextString = jsonReader.nextString();
                            } else if (iSelectName == 1) {
                                jsonReader.beginArray();
                                while (jsonReader.hasNext()) {
                                    Layer layer2 = s.parse(jsonReader, dVar);
                                    hVar2.put(layer2.getId(), layer2);
                                    arrayList5.add(layer2);
                                }
                                jsonReader.endArray();
                            } else if (iSelectName == 2) {
                                iNextInt3 = jsonReader.nextInt();
                            } else if (iSelectName == 3) {
                                iNextInt4 = jsonReader.nextInt();
                            } else if (iSelectName == 4) {
                                strNextString2 = jsonReader.nextString();
                            } else if (iSelectName != 5) {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                            } else {
                                strNextString3 = jsonReader.nextString();
                            }
                        }
                        jsonReader.endObject();
                        if (strNextString2 != null) {
                            p3.g gVar = new p3.g(iNextInt3, iNextInt4, strNextString, strNextString2, strNextString3);
                            map2.put(gVar.getId(), gVar);
                        } else {
                            map.put(strNextString, arrayList5);
                        }
                    }
                    jsonReader.endArray();
                    fDpScale = f13;
                    iNextInt = i11;
                    fNextDouble3 = f14;
                    fNextDouble = f11;
                    arrayList4 = arrayList2;
                    fNextDouble2 = f12;
                    break;
                case 8:
                    f11 = fNextDouble;
                    f12 = fNextDouble2;
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if (jsonReader.selectName(f22603c) != 0) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                JsonReader.a aVar = k.f22585a;
                                jsonReader.beginObject();
                                String strNextString4 = null;
                                String strNextString5 = null;
                                String strNextString6 = null;
                                float fNextDouble4 = 0.0f;
                                while (jsonReader.hasNext()) {
                                    ArrayList arrayList6 = arrayList4;
                                    int iSelectName2 = jsonReader.selectName(k.f22585a);
                                    if (iSelectName2 != 0) {
                                        lVar2 = lVar3;
                                        if (iSelectName2 == 1) {
                                            strNextString5 = jsonReader.nextString();
                                        } else if (iSelectName2 == 2) {
                                            strNextString6 = jsonReader.nextString();
                                        } else if (iSelectName2 != 3) {
                                            jsonReader.skipName();
                                            jsonReader.skipValue();
                                        } else {
                                            fNextDouble4 = (float) jsonReader.nextDouble();
                                            fDpScale = fDpScale;
                                            iNextInt = iNextInt;
                                        }
                                    } else {
                                        lVar2 = lVar3;
                                        strNextString4 = jsonReader.nextString();
                                    }
                                    arrayList4 = arrayList6;
                                    lVar3 = lVar2;
                                }
                                b0.l<u3.c> lVar4 = lVar3;
                                float f15 = fDpScale;
                                jsonReader.endObject();
                                u3.b bVar = new u3.b(strNextString4, strNextString5, strNextString6, fNextDouble4);
                                map3.put(bVar.getName(), bVar);
                                fDpScale = f15;
                                iNextInt = iNextInt;
                                arrayList4 = arrayList4;
                                lVar3 = lVar4;
                            }
                            jsonReader.endArray();
                            arrayList4 = arrayList4;
                            lVar3 = lVar3;
                        }
                    }
                    lVar = lVar3;
                    arrayList2 = arrayList4;
                    f13 = fDpScale;
                    i11 = iNextInt;
                    jsonReader.endObject();
                    fDpScale = f13;
                    iNextInt = i11;
                    fNextDouble3 = f14;
                    fNextDouble = f11;
                    arrayList4 = arrayList2;
                    fNextDouble2 = f12;
                    break;
                case 9:
                    f11 = fNextDouble;
                    f12 = fNextDouble2;
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        JsonReader.a aVar2 = j.f22583a;
                        ArrayList arrayList7 = new ArrayList();
                        jsonReader.beginObject();
                        double dNextDouble = 0.0d;
                        double dNextDouble2 = 0.0d;
                        String strNextString7 = null;
                        String strNextString8 = null;
                        char cCharAt = 0;
                        while (jsonReader.hasNext()) {
                            int iSelectName3 = jsonReader.selectName(j.f22583a);
                            if (iSelectName3 == 0) {
                                cCharAt = jsonReader.nextString().charAt(0);
                            } else if (iSelectName3 == 1) {
                                dNextDouble = jsonReader.nextDouble();
                            } else if (iSelectName3 == 2) {
                                dNextDouble2 = jsonReader.nextDouble();
                            } else if (iSelectName3 == 3) {
                                strNextString7 = jsonReader.nextString();
                            } else if (iSelectName3 == 4) {
                                strNextString8 = jsonReader.nextString();
                            } else if (iSelectName3 != 5) {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                            } else {
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    if (jsonReader.selectName(j.f22584b) != 0) {
                                        jsonReader.skipName();
                                        jsonReader.skipValue();
                                    } else {
                                        jsonReader.beginArray();
                                        while (jsonReader.hasNext()) {
                                            arrayList7.add((w3.i) g.a(jsonReader, dVar));
                                        }
                                        jsonReader.endArray();
                                    }
                                }
                                jsonReader.endObject();
                            }
                        }
                        jsonReader.endObject();
                        u3.c cVar = new u3.c(arrayList7, cCharAt, dNextDouble, dNextDouble2, strNextString7, strNextString8);
                        lVar3.put(cVar.hashCode(), cVar);
                    }
                    jsonReader.endArray();
                    lVar = lVar3;
                    arrayList2 = arrayList4;
                    f13 = fDpScale;
                    i11 = iNextInt;
                    fDpScale = f13;
                    iNextInt = i11;
                    fNextDouble3 = f14;
                    fNextDouble = f11;
                    arrayList4 = arrayList2;
                    fNextDouble2 = f12;
                    break;
                case 10:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString9 = null;
                        float fNextDouble5 = 0.0f;
                        float fNextDouble6 = 0.0f;
                        while (jsonReader.hasNext()) {
                            int iSelectName4 = jsonReader.selectName(f22604d);
                            if (iSelectName4 != 0) {
                                float f16 = fNextDouble2;
                                if (iSelectName4 == 1) {
                                    fNextDouble5 = (float) jsonReader.nextDouble();
                                } else if (iSelectName4 != 2) {
                                    jsonReader.skipName();
                                    jsonReader.skipValue();
                                } else {
                                    fNextDouble6 = (float) jsonReader.nextDouble();
                                }
                                fNextDouble2 = f16;
                            } else {
                                strNextString9 = jsonReader.nextString();
                            }
                        }
                        jsonReader.endObject();
                        arrayList4.add(new u3.g(strNextString9, fNextDouble5, fNextDouble6));
                        fNextDouble = fNextDouble;
                        fNextDouble2 = fNextDouble2;
                    }
                    f11 = fNextDouble;
                    f12 = fNextDouble2;
                    jsonReader.endArray();
                    lVar = lVar3;
                    arrayList2 = arrayList4;
                    f13 = fDpScale;
                    i11 = iNextInt;
                    fDpScale = f13;
                    iNextInt = i11;
                    fNextDouble3 = f14;
                    fNextDouble = f11;
                    arrayList4 = arrayList2;
                    fNextDouble2 = f12;
                    break;
                default:
                    f11 = fNextDouble;
                    f12 = fNextDouble2;
                    lVar = lVar3;
                    arrayList2 = arrayList4;
                    f13 = fDpScale;
                    i11 = iNextInt;
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    fDpScale = f13;
                    iNextInt = i11;
                    fNextDouble3 = f14;
                    fNextDouble = f11;
                    arrayList4 = arrayList2;
                    fNextDouble2 = f12;
                    break;
            }
            lVar3 = lVar;
        }
        float f17 = fDpScale;
        dVar.init(new Rect(0, 0, (int) (iNextInt2 * f17), (int) (iNextInt * f17)), fNextDouble, fNextDouble2, fNextDouble3, arrayList3, hVar, map, map2, lVar3, map3, arrayList4);
        return dVar;
    }
}
