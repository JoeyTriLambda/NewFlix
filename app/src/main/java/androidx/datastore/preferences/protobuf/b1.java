package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.s;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: SmallSortedMap.java */
/* loaded from: classes.dex */
public final class b1 extends c1<Object, Object> {
    public b1(int i10) {
        super(i10);
    }

    @Override // androidx.datastore.preferences.protobuf.c1
    public void makeImmutable() {
        if (!isImmutable()) {
            for (int i10 = 0; i10 < getNumArrayEntries(); i10++) {
                Map.Entry<Object, Object> arrayEntryAt = getArrayEntryAt(i10);
                if (((s.a) arrayEntryAt.getKey()).isRepeated()) {
                    arrayEntryAt.setValue(Collections.unmodifiableList((List) arrayEntryAt.getValue()));
                }
            }
            for (Map.Entry<Object, Object> entry : getOverflowEntries()) {
                if (((s.a) entry.getKey()).isRepeated()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.makeImmutable();
    }

    @Override // androidx.datastore.preferences.protobuf.c1, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return super.put((b1) obj, (s.a) obj2);
    }
}
