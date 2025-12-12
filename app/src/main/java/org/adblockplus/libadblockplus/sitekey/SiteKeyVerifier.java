package org.adblockplus.libadblockplus.sitekey;

import bi.a;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import org.adblockplus.libadblockplus.HttpClient;
import org.adblockplus.libadblockplus.android.Utils;
import org.adblockplus.libadblockplus.security.JavaSignatureVerifier;
import org.adblockplus.libadblockplus.security.SignatureVerificationException;
import org.adblockplus.libadblockplus.security.SignatureVerifier;
import org.adblockplus.libadblockplus.util.Base64Exception;
import org.adblockplus.libadblockplus.util.Base64Processor;

/* loaded from: classes2.dex */
public class SiteKeyVerifier {
    private static final byte ZERO_BYTE = 0;
    private final Base64Processor base64Processor;
    private final PublicKeyHolder publicKeyHolder;
    private final SignatureVerifier signatureVerifier;

    public SiteKeyVerifier(SignatureVerifier signatureVerifier, PublicKeyHolder publicKeyHolder, Base64Processor base64Processor) {
        this.signatureVerifier = signatureVerifier;
        this.publicKeyHolder = publicKeyHolder;
        this.base64Processor = base64Processor;
    }

    private byte[] decodeBase64(String str) throws SiteKeyException {
        try {
            return this.base64Processor.decode(str.getBytes());
        } catch (Base64Exception e10) {
            throw new SiteKeyException(e10);
        }
    }

    public byte[] buildData(String str, String str2) throws SiteKeyException, URISyntaxException {
        try {
            URI uri = new URI(str);
            if (uri.getHost() == null) {
                throw new URISyntaxException(str, "Can't extract host from URI");
            }
            StringBuilder sb2 = new StringBuilder((uri.getPath() == null || uri.getPath().isEmpty()) ? "/" : uri.getPath());
            if (uri.getQuery() != null) {
                sb2.append("?");
                sb2.append(uri.getRawQuery());
            }
            byte[] bytes = sb2.toString().getBytes();
            byte[] bytes2 = uri.getAuthority().getBytes();
            byte[] bytes3 = str2 != null ? str2.getBytes() : new byte[0];
            byte[] bArr = new byte[bytes.length + 1 + bytes2.length + 1 + bytes3.length];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            bArr[bytes.length] = 0;
            System.arraycopy(bytes2, 0, bArr, bytes.length + 1, bytes2.length);
            bArr[bytes.length + 1 + bytes2.length] = 0;
            System.arraycopy(bytes3, 0, bArr, bytes.length + 1 + bytes2.length + 1, bytes3.length);
            return bArr;
        } catch (URISyntaxException e10) {
            throw new SiteKeyException(e10);
        }
    }

    public boolean verify(String str, String str2, String str3) throws SiteKeyException, URISyntaxException {
        String[] strArrSplit = str3.split("_");
        if (strArrSplit.length != 2) {
            throw new SiteKeyException("Value is expected to be in format: publicKey_signature, but actual parts count is " + strArrSplit.length);
        }
        String str4 = strArrSplit[0];
        String str5 = strArrSplit[1];
        byte[] bArrDecodeBase64 = decodeBase64(str4);
        byte[] bArrDecodeBase642 = decodeBase64(str5);
        try {
            if (!this.signatureVerifier.verify(JavaSignatureVerifier.publicKeyFromDer(JavaSignatureVerifier.KEY_ALGORITHM, bArrDecodeBase64), buildData(str, str2), bArrDecodeBase642)) {
                return false;
            }
            this.publicKeyHolder.put(str, str4);
            return true;
        } catch (SignatureVerificationException e10) {
            throw new SiteKeyException(e10);
        }
    }

    public void verifyInHeaders(String str, Map<String, String> map, Map<String, String> map2) {
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            if (entry.getKey().equals(HttpClient.HEADER_SITEKEY)) {
                try {
                    if (verify(Utils.getUrlWithoutFragment(str), map.get("User-Agent"), entry.getValue())) {
                        a.d("Url %s public key verified successfully", str);
                    } else {
                        a.e("Url %s public key is not verified", str);
                    }
                    return;
                } catch (SiteKeyException e10) {
                    a.e(e10, "Failed to verify sitekey header", new Object[0]);
                    return;
                }
            }
        }
    }
}
