package androidx.work;

import androidx.work.b;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import w2.e;
import zf.i;

/* compiled from: ArrayCreatingInputMerger.kt */
/* loaded from: classes.dex */
public final class ArrayCreatingInputMerger extends e {
    @Override // w2.e
    public b merge(List<b> list) throws Throwable {
        Object objNewInstance;
        i.checkNotNullParameter(list, "inputs");
        b.a aVar = new b.a();
        HashMap map = new HashMap();
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            Map<String, Object> keyValueMap = it.next().getKeyValueMap();
            i.checkNotNullExpressionValue(keyValueMap, "input.keyValueMap");
            for (Map.Entry<String, Object> entry : keyValueMap.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Class cls = value != null ? value.getClass() : String.class;
                Object obj = map.get(key);
                i.checkNotNullExpressionValue(key, "key");
                if (obj != null) {
                    Class<?> cls2 = obj.getClass();
                    if (i.areEqual(cls2, cls)) {
                        i.checkNotNullExpressionValue(value, "value");
                        int length = Array.getLength(obj);
                        int length2 = Array.getLength(value);
                        Class<?> componentType = obj.getClass().getComponentType();
                        i.checkNotNull(componentType);
                        Object objNewInstance2 = Array.newInstance(componentType, length + length2);
                        System.arraycopy(obj, 0, objNewInstance2, 0, length);
                        System.arraycopy(value, 0, objNewInstance2, length, length2);
                        i.checkNotNullExpressionValue(objNewInstance2, "newArray");
                        value = objNewInstance2;
                    } else {
                        if (!i.areEqual(cls2.getComponentType(), cls)) {
                            throw new IllegalArgumentException();
                        }
                        int length3 = Array.getLength(obj);
                        objNewInstance = Array.newInstance(cls, length3 + 1);
                        System.arraycopy(obj, 0, objNewInstance, 0, length3);
                        Array.set(objNewInstance, length3, value);
                        i.checkNotNullExpressionValue(objNewInstance, "newArray");
                        value = objNewInstance;
                    }
                } else if (!cls.isArray()) {
                    objNewInstance = Array.newInstance(cls, 1);
                    Array.set(objNewInstance, 0, value);
                    i.checkNotNullExpressionValue(objNewInstance, "newArray");
                    value = objNewInstance;
                }
                i.checkNotNullExpressionValue(value, "if (existingValue == nul…      }\n                }");
                map.put(key, value);
            }
        }
        aVar.putAll(map);
        b bVarBuild = aVar.build();
        i.checkNotNullExpressionValue(bVarBuild, "output.build()");
        return bVarBuild;
    }
}
