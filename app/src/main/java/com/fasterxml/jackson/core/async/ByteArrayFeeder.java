package com.fasterxml.jackson.core.async;

import java.io.IOException;

/* loaded from: classes.dex */
public interface ByteArrayFeeder extends NonBlockingInputFeeder {
    void feedInput(byte[] bArr, int i10, int i11) throws IOException;
}
