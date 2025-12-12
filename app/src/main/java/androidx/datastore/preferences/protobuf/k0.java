package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* compiled from: MessageLite.java */
/* loaded from: classes.dex */
public interface k0 extends l0 {

    /* compiled from: MessageLite.java */
    public interface a extends l0, Cloneable {
    }

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    ByteString toByteString();

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;
}
