package androidx.datastore.preferences.protobuf;

import java.util.List;

/* compiled from: LazyStringList.java */
/* loaded from: classes.dex */
public interface a0 extends List {
    void add(ByteString byteString);

    Object getRaw(int i10);

    List<?> getUnderlyingElements();

    a0 getUnmodifiableView();
}
