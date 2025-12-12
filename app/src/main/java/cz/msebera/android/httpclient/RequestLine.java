package cz.msebera.android.httpclient;

/* loaded from: classes2.dex */
public interface RequestLine {
    String getMethod();

    ProtocolVersion getProtocolVersion();

    String getUri();
}
