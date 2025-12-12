package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.util.Args;
import java.util.Queue;

/* loaded from: classes2.dex */
public class AuthState {
    private Queue<AuthOption> authOptions;
    private AuthScheme authScheme;
    private AuthScope authScope;
    private Credentials credentials;
    private AuthProtocolState state = AuthProtocolState.UNCHALLENGED;

    public Queue<AuthOption> getAuthOptions() {
        return this.authOptions;
    }

    public AuthScheme getAuthScheme() {
        return this.authScheme;
    }

    @Deprecated
    public AuthScope getAuthScope() {
        return this.authScope;
    }

    public Credentials getCredentials() {
        return this.credentials;
    }

    public AuthProtocolState getState() {
        return this.state;
    }

    public boolean hasAuthOptions() {
        Queue<AuthOption> queue = this.authOptions;
        return (queue == null || queue.isEmpty()) ? false : true;
    }

    @Deprecated
    public void invalidate() {
        reset();
    }

    public boolean isConnectionBased() {
        AuthScheme authScheme = this.authScheme;
        return authScheme != null && authScheme.isConnectionBased();
    }

    @Deprecated
    public boolean isValid() {
        return this.authScheme != null;
    }

    public void reset() {
        this.state = AuthProtocolState.UNCHALLENGED;
        this.authOptions = null;
        this.authScheme = null;
        this.authScope = null;
        this.credentials = null;
    }

    @Deprecated
    public void setAuthScheme(AuthScheme authScheme) {
        if (authScheme == null) {
            reset();
        } else {
            this.authScheme = authScheme;
        }
    }

    @Deprecated
    public void setAuthScope(AuthScope authScope) {
        this.authScope = authScope;
    }

    @Deprecated
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public void setState(AuthProtocolState authProtocolState) {
        if (authProtocolState == null) {
            authProtocolState = AuthProtocolState.UNCHALLENGED;
        }
        this.state = authProtocolState;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("state:");
        sb2.append(this.state);
        sb2.append(";");
        if (this.authScheme != null) {
            sb2.append("auth scheme:");
            sb2.append(this.authScheme.getSchemeName());
            sb2.append(";");
        }
        if (this.credentials != null) {
            sb2.append("credentials present");
        }
        return sb2.toString();
    }

    public void update(AuthScheme authScheme, Credentials credentials) {
        Args.notNull(authScheme, "Auth scheme");
        Args.notNull(credentials, "Credentials");
        this.authScheme = authScheme;
        this.credentials = credentials;
        this.authOptions = null;
    }

    public void update(Queue<AuthOption> queue) {
        Args.notEmpty(queue, "Queue of auth options");
        this.authOptions = queue;
        this.authScheme = null;
        this.credentials = null;
    }
}
