package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;

/* compiled from: MapEntryLite.java */
/* loaded from: classes.dex */
public final class e0<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final a<K, V> f2440a;

    /* renamed from: b, reason: collision with root package name */
    public final K f2441b;

    /* renamed from: c, reason: collision with root package name */
    public final V f2442c;

    /* compiled from: MapEntryLite.java */
    public static class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final WireFormat.FieldType f2443a;

        /* renamed from: b, reason: collision with root package name */
        public final K f2444b;

        /* renamed from: c, reason: collision with root package name */
        public final WireFormat.FieldType f2445c;

        /* renamed from: d, reason: collision with root package name */
        public final V f2446d;

        public a(WireFormat.FieldType fieldType, K k10, WireFormat.FieldType fieldType2, V v10) {
            this.f2443a = fieldType;
            this.f2444b = k10;
            this.f2445c = fieldType2;
            this.f2446d = v10;
        }
    }

    public e0(WireFormat.FieldType fieldType, K k10, WireFormat.FieldType fieldType2, V v10) {
        this.f2440a = new a<>(fieldType, k10, fieldType2, v10);
        this.f2441b = k10;
        this.f2442c = v10;
    }

    public static <K, V> int a(a<K, V> aVar, K k10, V v10) {
        return s.a(aVar.f2445c, 2, v10) + s.a(aVar.f2443a, 1, k10);
    }

    public static <K, V> e0<K, V> newDefaultInstance(WireFormat.FieldType fieldType, K k10, WireFormat.FieldType fieldType2, V v10) {
        return new e0<>(fieldType, k10, fieldType2, v10);
    }

    public int computeMessageSize(int i10, K k10, V v10) {
        int iComputeTagSize = CodedOutputStream.computeTagSize(i10);
        int iA = a(this.f2440a, k10, v10);
        return CodedOutputStream.computeUInt32SizeNoTag(iA) + iA + iComputeTagSize;
    }
}
