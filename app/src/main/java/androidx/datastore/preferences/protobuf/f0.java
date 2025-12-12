package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.e0;
import java.util.Map;

/* compiled from: MapFieldSchema.java */
/* loaded from: classes.dex */
public interface f0 {
    Map<?, ?> forMapData(Object obj);

    e0.a<?, ?> forMapMetadata(Object obj);

    Map<?, ?> forMutableMapData(Object obj);

    int getSerializedSize(int i10, Object obj, Object obj2);

    boolean isImmutable(Object obj);

    Object mergeFrom(Object obj, Object obj2);

    Object newMapField(Object obj);

    Object toImmutable(Object obj);
}
