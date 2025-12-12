package org.adblockplus.libadblockplus.security;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: classes2.dex */
public class JavaSignatureVerifier implements SignatureVerifier {
    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
    private String signatureAlgorithm;

    public JavaSignatureVerifier(String str) {
        this.signatureAlgorithm = str;
    }

    public static PublicKey publicKeyFromDer(String str, byte[] bArr) throws SignatureVerificationException {
        try {
            return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(bArr));
        } catch (Throwable th2) {
            throw new SignatureVerificationException(th2);
        }
    }

    @Override // org.adblockplus.libadblockplus.security.SignatureVerifier
    public boolean verify(PublicKey publicKey, byte[] bArr, byte[] bArr2) throws SignatureVerificationException {
        try {
            Signature signature = Signature.getInstance(this.signatureAlgorithm);
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (Throwable th2) {
            throw new SignatureVerificationException(th2);
        }
    }

    public JavaSignatureVerifier() {
        this(SIGNATURE_ALGORITHM);
    }
}
