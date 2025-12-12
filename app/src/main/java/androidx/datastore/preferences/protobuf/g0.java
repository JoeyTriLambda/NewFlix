package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.e0;
import java.util.Map;

/* compiled from: MapFieldSchemaLite.java */
/* loaded from: classes.dex */
public final class g0 implements f0 {
    @Override // androidx.datastore.preferences.protobuf.f0
    public Map<?, ?> forMapData(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    public e0.a<?, ?> forMapMetadata(Object obj) {
        return ((e0) obj).f2440a;
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    public Map<?, ?> forMutableMapData(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    public int getSerializedSize(int i10, Object obj, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        e0 e0Var = (e0) obj2;
        int iComputeMessageSize = 0;
        if (!mapFieldLite.isEmpty()) {
            for (Map.Entry entry : mapFieldLite.entrySet()) {
                iComputeMessageSize += e0Var.computeMessageSize(i10, entry.getKey(), entry.getValue());
            }
        }
        return iComputeMessageSize;
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    public boolean isImmutable(Object obj) {
        return !((MapFieldLite) obj).isMutable();
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    public Object mergeFrom(Object obj, Object obj2) {
        MapFieldLite mapFieldLiteMutableCopy = (MapFieldLite) obj;
        MapFieldLite mapFieldLite = (MapFieldLite) obj2;
        if (!mapFieldLite.isEmpty()) {
            if (!mapFieldLiteMutableCopy.isMutable()) {
                mapFieldLiteMutableCopy = mapFieldLiteMutableCopy.mutableCopy();
            }
            mapFieldLiteMutableCopy.mergeFrom(mapFieldLite);
        }
        return mapFieldLiteMutableCopy;
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    public Object newMapField(Object obj) {
        return MapFieldLite.emptyMapField().mutableCopy();
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    public Object toImmutable(Object obj) {
        ((MapFieldLite) obj).makeImmutable();
        return obj;
    }
}
