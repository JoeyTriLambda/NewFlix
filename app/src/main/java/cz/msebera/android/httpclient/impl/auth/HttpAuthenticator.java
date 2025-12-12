package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthOption;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ContextAwareAuthScheme;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

/* loaded from: classes2.dex */
public class HttpAuthenticator {
    private final HttpClientAndroidLog log;

    /* renamed from: cz.msebera.android.httpclient.impl.auth.HttpAuthenticator$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState;

        static {
            int[] iArr = new int[AuthProtocolState.values().length];
            $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState = iArr;
            try {
                iArr[AuthProtocolState.CHALLENGED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.HANDSHAKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.UNCHALLENGED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public HttpAuthenticator(HttpClientAndroidLog httpClientAndroidLog) {
        this.log = httpClientAndroidLog == null ? new HttpClientAndroidLog(getClass()) : httpClientAndroidLog;
    }

    private Header doAuth(AuthScheme authScheme, Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        return authScheme instanceof ContextAwareAuthScheme ? ((ContextAwareAuthScheme) authScheme).authenticate(credentials, httpRequest, httpContext) : authScheme.authenticate(credentials, httpRequest);
    }

    private void ensureAuthScheme(AuthScheme authScheme) {
        Asserts.notNull(authScheme, "Auth scheme");
    }

    public void generateAuthResponse(HttpRequest httpRequest, AuthState authState, HttpContext httpContext) throws HttpException, IOException {
        AuthScheme authScheme = authState.getAuthScheme();
        Credentials credentials = authState.getCredentials();
        int i10 = AnonymousClass1.$SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[authState.getState().ordinal()];
        if (i10 == 1) {
            Queue<AuthOption> authOptions = authState.getAuthOptions();
            if (authOptions != null) {
                while (!authOptions.isEmpty()) {
                    AuthOption authOptionRemove = authOptions.remove();
                    AuthScheme authScheme2 = authOptionRemove.getAuthScheme();
                    Credentials credentials2 = authOptionRemove.getCredentials();
                    authState.update(authScheme2, credentials2);
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Generating response to an authentication challenge using " + authScheme2.getSchemeName() + " scheme");
                    }
                    try {
                        httpRequest.addHeader(doAuth(authScheme2, credentials2, httpRequest, httpContext));
                        return;
                    } catch (AuthenticationException e10) {
                        if (this.log.isWarnEnabled()) {
                            this.log.warn(authScheme2 + " authentication error: " + e10.getMessage());
                        }
                    }
                }
                return;
            }
            ensureAuthScheme(authScheme);
        } else if (i10 == 3) {
            ensureAuthScheme(authScheme);
            if (authScheme.isConnectionBased()) {
                return;
            }
        } else if (i10 == 4) {
            return;
        }
        if (authScheme != null) {
            try {
                httpRequest.addHeader(doAuth(authScheme, credentials, httpRequest, httpContext));
            } catch (AuthenticationException e11) {
                if (this.log.isErrorEnabled()) {
                    this.log.error(authScheme + " authentication error: " + e11.getMessage());
                }
            }
        }
    }

    public boolean handleAuthChallenge(HttpHost httpHost, HttpResponse httpResponse, AuthenticationStrategy authenticationStrategy, AuthState authState, HttpContext httpContext) {
        Queue<AuthOption> queueSelect;
        try {
            if (this.log.isDebugEnabled()) {
                this.log.debug(httpHost.toHostString() + " requested authentication");
            }
            Map<String, Header> challenges = authenticationStrategy.getChallenges(httpHost, httpResponse, httpContext);
            if (challenges.isEmpty()) {
                this.log.debug("Response contains no authentication challenges");
                return false;
            }
            AuthScheme authScheme = authState.getAuthScheme();
            int i10 = AnonymousClass1.$SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[authState.getState().ordinal()];
            if (i10 != 1 && i10 != 2) {
                if (i10 == 3) {
                    authState.reset();
                } else {
                    if (i10 == 4) {
                        return false;
                    }
                    if (i10 != 5) {
                    }
                }
                queueSelect = authenticationStrategy.select(challenges, httpHost, httpResponse, httpContext);
                if (queueSelect != null || queueSelect.isEmpty()) {
                    return false;
                }
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Selected authentication options: " + queueSelect);
                }
                authState.setState(AuthProtocolState.CHALLENGED);
                authState.update(queueSelect);
                return true;
            }
            if (authScheme == null) {
                this.log.debug("Auth scheme is null");
                authenticationStrategy.authFailed(httpHost, null, httpContext);
                authState.reset();
                authState.setState(AuthProtocolState.FAILURE);
                return false;
            }
            if (authScheme != null) {
                Header header = challenges.get(authScheme.getSchemeName().toLowerCase(Locale.ROOT));
                if (header != null) {
                    this.log.debug("Authorization challenge processed");
                    authScheme.processChallenge(header);
                    if (!authScheme.isComplete()) {
                        authState.setState(AuthProtocolState.HANDSHAKE);
                        return true;
                    }
                    this.log.debug("Authentication failed");
                    authenticationStrategy.authFailed(httpHost, authState.getAuthScheme(), httpContext);
                    authState.reset();
                    authState.setState(AuthProtocolState.FAILURE);
                    return false;
                }
                authState.reset();
            }
            queueSelect = authenticationStrategy.select(challenges, httpHost, httpResponse, httpContext);
            if (queueSelect != null) {
            }
            return false;
        } catch (MalformedChallengeException e10) {
            if (this.log.isWarnEnabled()) {
                this.log.warn("Malformed challenge: " + e10.getMessage());
            }
            authState.reset();
            return false;
        }
    }

    public boolean isAuthenticationRequested(HttpHost httpHost, HttpResponse httpResponse, AuthenticationStrategy authenticationStrategy, AuthState authState, HttpContext httpContext) {
        if (authenticationStrategy.isAuthenticationRequested(httpHost, httpResponse, httpContext)) {
            this.log.debug("Authentication required");
            if (authState.getState() == AuthProtocolState.SUCCESS) {
                authenticationStrategy.authFailed(httpHost, authState.getAuthScheme(), httpContext);
            }
            return true;
        }
        int i10 = AnonymousClass1.$SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[authState.getState().ordinal()];
        if (i10 == 1 || i10 == 2) {
            this.log.debug("Authentication succeeded");
            authState.setState(AuthProtocolState.SUCCESS);
            authenticationStrategy.authSucceeded(httpHost, authState.getAuthScheme(), httpContext);
            return false;
        }
        if (i10 == 3) {
            return false;
        }
        authState.setState(AuthProtocolState.UNCHALLENGED);
        return false;
    }

    public HttpAuthenticator() {
        this(null);
    }
}
