package org.adblockplus.libadblockplus.util;

/* loaded from: classes2.dex */
public interface Base64Processor {
    byte[] decode(byte[] bArr) throws Base64Exception;

    byte[] encode(byte[] bArr) throws Base64Exception;

    String encodeToString(byte[] bArr) throws Base64Exception;
}
