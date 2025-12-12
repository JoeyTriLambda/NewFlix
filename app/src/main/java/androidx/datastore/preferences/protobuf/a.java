package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.a;
import androidx.datastore.preferences.protobuf.a.AbstractC0023a;
import androidx.datastore.preferences.protobuf.k0;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/* compiled from: AbstractMessageLite.java */
/* loaded from: classes.dex */
public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0023a<MessageType, BuilderType>> implements k0 {
    protected int memoizedHashCode = 0;

    /* compiled from: AbstractMessageLite.java */
    /* renamed from: androidx.datastore.preferences.protobuf.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0023a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0023a<MessageType, BuilderType>> implements k0.a {
        public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
            Charset charset = w.f2545a;
            iterable.getClass();
            if (iterable instanceof a0) {
                List<?> underlyingElements = ((a0) iterable).getUnderlyingElements();
                a0 a0Var = (a0) list;
                int size = list.size();
                for (Object obj : underlyingElements) {
                    if (obj == null) {
                        String str = "Element at index " + (a0Var.size() - size) + " is null.";
                        for (int size2 = a0Var.size() - 1; size2 >= size; size2--) {
                            a0Var.remove(size2);
                        }
                        throw new NullPointerException(str);
                    }
                    if (obj instanceof ByteString) {
                        a0Var.add((ByteString) obj);
                    } else {
                        a0Var.add((a0) obj);
                    }
                }
                return;
            }
            if (iterable instanceof t0) {
                list.addAll((Collection) iterable);
                return;
            }
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
            }
            int size3 = list.size();
            for (T t10 : iterable) {
                if (t10 == null) {
                    String str2 = "Element at index " + (list.size() - size3) + " is null.";
                    int size4 = list.size();
                    while (true) {
                        size4--;
                        if (size4 < size3) {
                            throw new NullPointerException(str2);
                        }
                        list.remove(size4);
                    }
                } else {
                    list.add(t10);
                }
            }
        }

        public static UninitializedMessageException newUninitializedMessageException(k0 k0Var) {
            return new UninitializedMessageException(k0Var);
        }

        public abstract BuilderType internalMergeFrom(MessageType messagetype);

        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType m7mergeFrom(k0 k0Var) {
            if (((GeneratedMessageLite.a) this).getDefaultInstanceForType().getClass().isInstance(k0Var)) {
                return (BuilderType) internalMergeFrom((a) k0Var);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        AbstractC0023a.addAll(iterable, list);
    }

    public int a() {
        throw new UnsupportedOperationException();
    }

    public final int b(y0 y0Var) {
        int iA = a();
        if (iA != -1) {
            return iA;
        }
        int serializedSize = y0Var.getSerializedSize(this);
        c(serializedSize);
        return serializedSize;
    }

    public void c(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.datastore.preferences.protobuf.k0
    public ByteString toByteString() {
        try {
            int serializedSize = getSerializedSize();
            ByteString byteString = ByteString.f2316m;
            ByteString.f fVar = new ByteString.f(serializedSize);
            writeTo(fVar.getCodedOutput());
            return fVar.build();
        } catch (IOException e10) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e10);
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        Logger logger = CodedOutputStream.f2327b;
        if (serializedSize > 4096) {
            serializedSize = 4096;
        }
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(outputStream, serializedSize);
        writeTo(codedOutputStreamNewInstance);
        codedOutputStreamNewInstance.flush();
    }
}
