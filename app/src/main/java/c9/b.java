package c9;

import b9.d;
import c9.b;

/* compiled from: EncoderConfig.java */
/* loaded from: classes.dex */
public interface b<T extends b<T>> {
    <U> T registerEncoder(Class<U> cls, d<? super U> dVar);
}
