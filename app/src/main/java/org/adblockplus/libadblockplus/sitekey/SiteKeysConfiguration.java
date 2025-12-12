package org.adblockplus.libadblockplus.sitekey;

import java.util.concurrent.atomic.AtomicBoolean;
import org.adblockplus.libadblockplus.HttpClient;
import org.adblockplus.libadblockplus.security.SignatureVerifier;

/* loaded from: classes2.dex */
public class SiteKeysConfiguration {
    private AtomicBoolean forceChecks = new AtomicBoolean(false);
    private HttpClient httpClient;
    private PublicKeyHolder publicKeyHolder;
    private SignatureVerifier signatureVerifier;
    private SiteKeyVerifier siteKeyVerifier;

    public SiteKeysConfiguration(SignatureVerifier signatureVerifier, PublicKeyHolder publicKeyHolder, HttpClient httpClient, SiteKeyVerifier siteKeyVerifier) {
        this.signatureVerifier = signatureVerifier;
        this.publicKeyHolder = publicKeyHolder;
        this.httpClient = httpClient;
        this.siteKeyVerifier = siteKeyVerifier;
    }

    public boolean getForceChecks() {
        return this.forceChecks.get();
    }

    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    public PublicKeyHolder getPublicKeyHolder() {
        return this.publicKeyHolder;
    }

    public SignatureVerifier getSignatureVerifier() {
        return this.signatureVerifier;
    }

    public SiteKeyVerifier getSiteKeyVerifier() {
        return this.siteKeyVerifier;
    }

    public void setForceChecks(boolean z10) {
        this.forceChecks.set(z10);
    }
}
