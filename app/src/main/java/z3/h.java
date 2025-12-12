package z3;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: DocumentDataParser.java */
/* loaded from: classes.dex */
public final class h implements h0<DocumentData> {

    /* renamed from: a, reason: collision with root package name */
    public static final h f22580a = new h();

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f22581b = JsonReader.a.of("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // z3.h0
    public DocumentData parse(JsonReader jsonReader, float f10) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.beginObject();
        DocumentData.Justification justification2 = justification;
        String strNextString = null;
        String strNextString2 = null;
        float fNextDouble = 0.0f;
        int iNextInt = 0;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        int iA = 0;
        int iA2 = 0;
        float fNextDouble4 = 0.0f;
        boolean zNextBoolean = true;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(f22581b)) {
                case 0:
                    strNextString = jsonReader.nextString();
                    break;
                case 1:
                    strNextString2 = jsonReader.nextString();
                    break;
                case 2:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 3:
                    int iNextInt2 = jsonReader.nextInt();
                    if (iNextInt2 <= 2 && iNextInt2 >= 0) {
                        justification2 = DocumentData.Justification.values()[iNextInt2];
                        break;
                    } else {
                        justification2 = justification;
                        break;
                    }
                    break;
                case 4:
                    iNextInt = jsonReader.nextInt();
                    break;
                case 5:
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    break;
                case 6:
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    break;
                case 7:
                    iA = p.a(jsonReader);
                    break;
                case 8:
                    iA2 = p.a(jsonReader);
                    break;
                case 9:
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    break;
                case 10:
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new DocumentData(strNextString, strNextString2, fNextDouble, justification2, iNextInt, fNextDouble2, fNextDouble3, iA, iA2, fNextDouble4, zNextBoolean);
    }
}
