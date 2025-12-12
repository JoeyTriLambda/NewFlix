package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpStatus;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.Collection;
import java.util.Map;
import java.util.Queue;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class ProxyAuthenticationStrategy extends AuthenticationStrategyImpl {
    public static final ProxyAuthenticationStrategy INSTANCE = new ProxyAuthenticationStrategy();

    public ProxyAuthenticationStrategy() {
        super(HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED, "Proxy-Authenticate");
    }

    @Override // cz.msebera.android.httpclient.impl.client.AuthenticationStrategyImpl, cz.msebera.android.httpclient.client.AuthenticationStrategy
    public /* bridge */ /* synthetic */ void authFailed(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext) {
        super.authFailed(httpHost, authScheme, httpContext);
    }

    @Override // cz.msebera.android.httpclient.impl.client.AuthenticationStrategyImpl, cz.msebera.android.httpclient.client.AuthenticationStrategy
    public /* bridge */ /* synthetic */ void authSucceeded(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext) {
        super.authSucceeded(httpHost, authScheme, httpContext);
    }

    @Override // cz.msebera.android.httpclient.impl.client.AuthenticationStrategyImpl, cz.msebera.android.httpclient.client.AuthenticationStrategy
    public /* bridge */ /* synthetic */ Map getChallenges(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) throws MalformedChallengeException {
        return super.getChallenges(httpHost, httpResponse, httpContext);
    }

    @Override // cz.msebera.android.httpclient.impl.client.AuthenticationStrategyImpl
    public Collection<String> getPreferredAuthSchemes(RequestConfig requestConfig) {
        return requestConfig.getProxyPreferredAuthSchemes();
    }

    @Override // cz.msebera.android.httpclient.impl.client.AuthenticationStrategyImpl, cz.msebera.android.httpclient.client.AuthenticationStrategy
    public /* bridge */ /* synthetic */ boolean isAuthenticationRequested(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) {
        return super.isAuthenticationRequested(httpHost, httpResponse, httpContext);
    }

    @Override // cz.msebera.android.httpclient.impl.client.AuthenticationStrategyImpl, cz.msebera.android.httpclient.client.AuthenticationStrategy
    public /* bridge */ /* synthetic */ Queue select(Map map, HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) throws MalformedChallengeException {
        return super.select(map, httpHost, httpResponse, httpContext);
    }
}
