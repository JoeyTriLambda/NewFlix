package u8;

import android.util.JsonReader;
import d9.c;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import t8.f0;

/* compiled from: CrashlyticsReportJsonTransform.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b9.a f20138a = new c().configureWith(t8.a.f19469a).ignoreNullValues(true).build();

    /* compiled from: CrashlyticsReportJsonTransform.java */
    public interface a<T> {
        T parse(JsonReader jsonReader) throws IOException;
    }

    public static f0.e.d.a.b.AbstractC0271e.AbstractC0273b a(JsonReader jsonReader) throws IOException {
        f0.e.d.a.b.AbstractC0271e.AbstractC0273b.AbstractC0274a abstractC0274aBuilder = f0.e.d.a.b.AbstractC0271e.AbstractC0273b.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "offset":
                    abstractC0274aBuilder.setOffset(jsonReader.nextLong());
                    break;
                case "symbol":
                    abstractC0274aBuilder.setSymbol(jsonReader.nextString());
                    break;
                case "pc":
                    abstractC0274aBuilder.setPc(jsonReader.nextLong());
                    break;
                case "file":
                    abstractC0274aBuilder.setFile(jsonReader.nextString());
                    break;
                case "importance":
                    abstractC0274aBuilder.setImportance(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0274aBuilder.build();
    }

    public static f0.c b(JsonReader jsonReader) throws IOException {
        f0.c.a aVarBuilder = f0.c.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (strNextName.equals("key")) {
                aVarBuilder.setKey(jsonReader.nextString());
            } else if (strNextName.equals("value")) {
                aVarBuilder.setValue(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return aVarBuilder.build();
    }

    public static f0.a c(JsonReader jsonReader) throws IOException {
        int i10;
        f0.a.b bVarBuilder = f0.a.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            i10 = 2;
            switch (strNextName) {
                case "buildIdMappingForArch":
                    bVarBuilder.setBuildIdMappingForArch(d(jsonReader, new u8.a(i10)));
                    break;
                case "pid":
                    bVarBuilder.setPid(jsonReader.nextInt());
                    break;
                case "pss":
                    bVarBuilder.setPss(jsonReader.nextLong());
                    break;
                case "rss":
                    bVarBuilder.setRss(jsonReader.nextLong());
                    break;
                case "timestamp":
                    bVarBuilder.setTimestamp(jsonReader.nextLong());
                    break;
                case "processName":
                    bVarBuilder.setProcessName(jsonReader.nextString());
                    break;
                case "reasonCode":
                    bVarBuilder.setReasonCode(jsonReader.nextInt());
                    break;
                case "traceFile":
                    bVarBuilder.setTraceFile(jsonReader.nextString());
                    break;
                case "importance":
                    bVarBuilder.setImportance(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVarBuilder.build();
    }

    public static <T> List<T> d(JsonReader jsonReader, a<T> aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(aVar.parse(jsonReader));
        }
        jsonReader.endArray();
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:111:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static t8.f0.e.d e(android.util.JsonReader r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1032
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: u8.b.e(android.util.JsonReader):t8.f0$e$d");
    }

    public static f0.e.d.a.b.c f(JsonReader jsonReader) throws IOException {
        f0.e.d.a.b.c.AbstractC0268a abstractC0268aBuilder = f0.e.d.a.b.c.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "frames":
                    abstractC0268aBuilder.setFrames(d(jsonReader, new u8.a(6)));
                    break;
                case "reason":
                    abstractC0268aBuilder.setReason(jsonReader.nextString());
                    break;
                case "type":
                    abstractC0268aBuilder.setType(jsonReader.nextString());
                    break;
                case "causedBy":
                    abstractC0268aBuilder.setCausedBy(f(jsonReader));
                    break;
                case "overflowCount":
                    abstractC0268aBuilder.setOverflowCount(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0268aBuilder.build();
    }

    public static f0.e.d.a.c g(JsonReader jsonReader) throws IOException {
        f0.e.d.a.c.AbstractC0275a abstractC0275aBuilder = f0.e.d.a.c.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "pid":
                    abstractC0275aBuilder.setPid(jsonReader.nextInt());
                    break;
                case "processName":
                    abstractC0275aBuilder.setProcessName(jsonReader.nextString());
                    break;
                case "defaultProcess":
                    abstractC0275aBuilder.setDefaultProcess(jsonReader.nextBoolean());
                    break;
                case "importance":
                    abstractC0275aBuilder.setImportance(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0275aBuilder.build();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static t8.f0 h(android.util.JsonReader r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1456
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: u8.b.h(android.util.JsonReader):t8.f0");
    }

    public f0.e.d eventFromJson(String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                f0.e.d dVarE = e(jsonReader);
                jsonReader.close();
                return dVarE;
            } finally {
            }
        } catch (IllegalStateException e10) {
            throw new IOException(e10);
        }
    }

    public String eventToJson(f0.e.d dVar) {
        return ((c.a) f20138a).encode(dVar);
    }

    public f0 reportFromJson(String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                f0 f0VarH = h(jsonReader);
                jsonReader.close();
                return f0VarH;
            } finally {
            }
        } catch (IllegalStateException e10) {
            throw new IOException(e10);
        }
    }

    public String reportToJson(f0 f0Var) {
        return ((c.a) f20138a).encode(f0Var);
    }
}
