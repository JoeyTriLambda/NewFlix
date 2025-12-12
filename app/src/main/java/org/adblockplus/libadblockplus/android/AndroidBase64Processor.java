package org.adblockplus.libadblockplus.android;

import android.util.Base64;
import org.adblockplus.libadblockplus.util.Base64Exception;
import org.adblockplus.libadblockplus.util.Base64Processor;

/* loaded from: classes2.dex */
public class AndroidBase64Processor implements Base64Processor {
    private static final int DEFAULT_FLAGS = 2;

    @Override // org.adblockplus.libadblockplus.util.Base64Processor
    public byte[] decode(byte[] bArr) throws Base64Exception {
        try {
            return Base64.decode(bArr, 0);
        } catch (Throwable th2) {
            throw new Base64Exception(th2);
        }
    }

    @Override // org.adblockplus.libadblockplus.util.Base64Processor
    public byte[] encode(byte[] bArr) throws Base64Exception {
        try {
            return Base64.encode(bArr, 2);
        } catch (Throwable th2) {
            throw new Base64Exception(th2);
        }
    }

    @Override // org.adblockplus.libadblockplus.util.Base64Processor
    public String encodeToString(byte[] bArr) throws Base64Exception {
        try {
            return Base64.encodeToString(bArr, 2);
        } catch (Throwable th2) {
            throw new Base64Exception(th2);
        }
    }
}
