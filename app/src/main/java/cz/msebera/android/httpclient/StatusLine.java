package cz.msebera.android.httpclient;

/* loaded from: classes2.dex */
public interface StatusLine {
    ProtocolVersion getProtocolVersion();

    String getReasonPhrase();

    int getStatusCode();
}
