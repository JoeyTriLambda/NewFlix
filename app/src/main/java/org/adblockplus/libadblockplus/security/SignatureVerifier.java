package org.adblockplus.libadblockplus.security;

import java.security.PublicKey;

/* loaded from: classes2.dex */
public interface SignatureVerifier {
    boolean verify(PublicKey publicKey, byte[] bArr, byte[] bArr2) throws SignatureVerificationException;
}
