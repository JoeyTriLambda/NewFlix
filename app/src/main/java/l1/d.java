package l1;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.PreferencesProto$Value;
import androidx.datastore.preferences.core.MutablePreferences;
import com.unity3d.ads.metadata.MediationMetaData;
import i1.i;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k1.c;
import kotlin.NoWhenBranchMatchedException;
import l1.a;
import lf.h;
import mf.q;

/* compiled from: PreferencesSerializer.kt */
/* loaded from: classes.dex */
public final class d implements i<l1.a> {

    /* renamed from: a, reason: collision with root package name */
    public static final d f15720a = new d();

    /* compiled from: PreferencesSerializer.kt */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15721a;

        static {
            int[] iArr = new int[PreferencesProto$Value.ValueCase.values().length];
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[6] = 3;
            iArr[2] = 4;
            iArr[3] = 5;
            iArr[4] = 6;
            iArr[5] = 7;
            iArr[7] = 8;
            f15721a = iArr;
        }
    }

    public final String getFileExtension() {
        return "preferences_pb";
    }

    @Override // i1.i
    public Object readFrom(InputStream inputStream, qf.c<? super l1.a> cVar) throws IOException {
        k1.c from = k1.b.f14718a.readFrom(inputStream);
        MutablePreferences mutablePreferencesCreateMutable = b.createMutable(new a.b[0]);
        Map<String, PreferencesProto$Value> preferencesMap = from.getPreferencesMap();
        zf.i.checkNotNullExpressionValue(preferencesMap, "preferencesProto.preferencesMap");
        for (Map.Entry<String, PreferencesProto$Value> entry : preferencesMap.entrySet()) {
            String key = entry.getKey();
            PreferencesProto$Value value = entry.getValue();
            zf.i.checkNotNullExpressionValue(key, MediationMetaData.KEY_NAME);
            zf.i.checkNotNullExpressionValue(value, "value");
            PreferencesProto$Value.ValueCase valueCase = value.getValueCase();
            switch (valueCase == null ? -1 : a.f15721a[valueCase.ordinal()]) {
                case -1:
                    throw new CorruptionException("Value case is null.", null, 2, null);
                case 0:
                default:
                    throw new NoWhenBranchMatchedException();
                case 1:
                    mutablePreferencesCreateMutable.set(c.booleanKey(key), Boolean.valueOf(value.getBoolean()));
                    break;
                case 2:
                    mutablePreferencesCreateMutable.set(c.floatKey(key), Float.valueOf(value.getFloat()));
                    break;
                case 3:
                    mutablePreferencesCreateMutable.set(c.doubleKey(key), Double.valueOf(value.getDouble()));
                    break;
                case 4:
                    mutablePreferencesCreateMutable.set(c.intKey(key), Integer.valueOf(value.getInteger()));
                    break;
                case 5:
                    mutablePreferencesCreateMutable.set(c.longKey(key), Long.valueOf(value.getLong()));
                    break;
                case 6:
                    a.C0186a<String> c0186aStringKey = c.stringKey(key);
                    String string = value.getString();
                    zf.i.checkNotNullExpressionValue(string, "value.string");
                    mutablePreferencesCreateMutable.set(c0186aStringKey, string);
                    break;
                case 7:
                    a.C0186a<Set<String>> c0186aStringSetKey = c.stringSetKey(key);
                    List<String> stringsList = value.getStringSet().getStringsList();
                    zf.i.checkNotNullExpressionValue(stringsList, "value.stringSet.stringsList");
                    mutablePreferencesCreateMutable.set(c0186aStringSetKey, q.toSet(stringsList));
                    break;
                case 8:
                    throw new CorruptionException("Value not set.", null, 2, null);
            }
        }
        return mutablePreferencesCreateMutable.toPreferences();
    }

    @Override // i1.i
    public /* bridge */ /* synthetic */ Object writeTo(l1.a aVar, OutputStream outputStream, qf.c cVar) {
        return writeTo2(aVar, outputStream, (qf.c<? super h>) cVar);
    }

    @Override // i1.i
    public l1.a getDefaultValue() {
        return b.createEmpty();
    }

    /* renamed from: writeTo, reason: avoid collision after fix types in other method */
    public Object writeTo2(l1.a aVar, OutputStream outputStream, qf.c<? super h> cVar) throws IOException {
        PreferencesProto$Value preferencesProto$ValueM4build;
        Map<a.C0186a<?>, Object> mapAsMap = aVar.asMap();
        c.a aVarNewBuilder = k1.c.newBuilder();
        for (Map.Entry<a.C0186a<?>, Object> entry : mapAsMap.entrySet()) {
            a.C0186a<?> key = entry.getKey();
            Object value = entry.getValue();
            String name = key.getName();
            if (value instanceof Boolean) {
                preferencesProto$ValueM4build = PreferencesProto$Value.newBuilder().setBoolean(((Boolean) value).booleanValue()).m4build();
                zf.i.checkNotNullExpressionValue(preferencesProto$ValueM4build, "newBuilder().setBoolean(value).build()");
            } else if (value instanceof Float) {
                preferencesProto$ValueM4build = PreferencesProto$Value.newBuilder().setFloat(((Number) value).floatValue()).m4build();
                zf.i.checkNotNullExpressionValue(preferencesProto$ValueM4build, "newBuilder().setFloat(value).build()");
            } else if (value instanceof Double) {
                preferencesProto$ValueM4build = PreferencesProto$Value.newBuilder().setDouble(((Number) value).doubleValue()).m4build();
                zf.i.checkNotNullExpressionValue(preferencesProto$ValueM4build, "newBuilder().setDouble(value).build()");
            } else if (value instanceof Integer) {
                preferencesProto$ValueM4build = PreferencesProto$Value.newBuilder().setInteger(((Number) value).intValue()).m4build();
                zf.i.checkNotNullExpressionValue(preferencesProto$ValueM4build, "newBuilder().setInteger(value).build()");
            } else if (value instanceof Long) {
                preferencesProto$ValueM4build = PreferencesProto$Value.newBuilder().setLong(((Number) value).longValue()).m4build();
                zf.i.checkNotNullExpressionValue(preferencesProto$ValueM4build, "newBuilder().setLong(value).build()");
            } else if (value instanceof String) {
                preferencesProto$ValueM4build = PreferencesProto$Value.newBuilder().setString((String) value).m4build();
                zf.i.checkNotNullExpressionValue(preferencesProto$ValueM4build, "newBuilder().setString(value).build()");
            } else {
                if (!(value instanceof Set)) {
                    throw new IllegalStateException(zf.i.stringPlus("PreferencesSerializer does not support type: ", value.getClass().getName()));
                }
                preferencesProto$ValueM4build = PreferencesProto$Value.newBuilder().setStringSet(androidx.datastore.preferences.a.newBuilder().addAllStrings((Set) value)).m4build();
                zf.i.checkNotNullExpressionValue(preferencesProto$ValueM4build, "newBuilder().setStringSet(\n                    StringSet.newBuilder().addAllStrings(value as Set<String>)\n                ).build()");
            }
            aVarNewBuilder.putPreferences(name, preferencesProto$ValueM4build);
        }
        aVarNewBuilder.m4build().writeTo(outputStream);
        return h.f16056a;
    }
}
