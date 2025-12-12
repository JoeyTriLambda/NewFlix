package i1;

import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: Serializer.kt */
/* loaded from: classes.dex */
public interface i<T> {
    T getDefaultValue();

    Object readFrom(InputStream inputStream, qf.c<? super T> cVar);

    Object writeTo(T t10, OutputStream outputStream, qf.c<? super lf.h> cVar);
}
