package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.InvalidCredentialsException;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.auth.NTCredentials;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;

/* loaded from: classes2.dex */
public class NTLMScheme extends AuthSchemeBase {
    private String challenge;
    private final NTLMEngine engine;
    private State state;

    public enum State {
        UNINITIATED,
        CHALLENGE_RECEIVED,
        MSG_TYPE1_GENERATED,
        MSG_TYPE2_RECEVIED,
        MSG_TYPE3_GENERATED,
        FAILED
    }

    public NTLMScheme(NTLMEngine nTLMEngine) {
        Args.notNull(nTLMEngine, "NTLM engine");
        this.engine = nTLMEngine;
        this.state = State.UNINITIATED;
        this.challenge = null;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public Header authenticate(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        String strGenerateType3Msg;
        try {
            NTCredentials nTCredentials = (NTCredentials) credentials;
            State state = this.state;
            if (state == State.FAILED) {
                throw new AuthenticationException("NTLM authentication failed");
            }
            if (state == State.CHALLENGE_RECEIVED) {
                strGenerateType3Msg = this.engine.generateType1Msg(nTCredentials.getDomain(), nTCredentials.getWorkstation());
                this.state = State.MSG_TYPE1_GENERATED;
            } else {
                if (state != State.MSG_TYPE2_RECEVIED) {
                    throw new AuthenticationException("Unexpected state: " + this.state);
                }
                strGenerateType3Msg = this.engine.generateType3Msg(nTCredentials.getUserName(), nTCredentials.getPassword(), nTCredentials.getDomain(), nTCredentials.getWorkstation(), this.challenge);
                this.state = State.MSG_TYPE3_GENERATED;
            }
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
            if (isProxy()) {
                charArrayBuffer.append("Proxy-Authorization");
            } else {
                charArrayBuffer.append("Authorization");
            }
            charArrayBuffer.append(": NTLM ");
            charArrayBuffer.append(strGenerateType3Msg);
            return new BufferedHeader(charArrayBuffer);
        } catch (ClassCastException unused) {
            throw new InvalidCredentialsException("Credentials cannot be used for NTLM authentication: ".concat(credentials.getClass().getName()));
        }
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public String getParameter(String str) {
        return null;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public String getRealm() {
        return null;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public String getSchemeName() {
        return "ntlm";
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public boolean isComplete() {
        State state = this.state;
        return state == State.MSG_TYPE3_GENERATED || state == State.FAILED;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public boolean isConnectionBased() {
        return true;
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase
    public void parseChallenge(CharArrayBuffer charArrayBuffer, int i10, int i11) throws MalformedChallengeException {
        String strSubstringTrimmed = charArrayBuffer.substringTrimmed(i10, i11);
        this.challenge = strSubstringTrimmed;
        if (strSubstringTrimmed.isEmpty()) {
            if (this.state == State.UNINITIATED) {
                this.state = State.CHALLENGE_RECEIVED;
                return;
            } else {
                this.state = State.FAILED;
                return;
            }
        }
        State state = this.state;
        State state2 = State.MSG_TYPE1_GENERATED;
        if (state.compareTo(state2) < 0) {
            this.state = State.FAILED;
            throw new MalformedChallengeException("Out of sequence NTLM response message");
        }
        if (this.state == state2) {
            this.state = State.MSG_TYPE2_RECEVIED;
        }
    }

    public NTLMScheme() {
        this(new NTLMEngineImpl());
    }
}
