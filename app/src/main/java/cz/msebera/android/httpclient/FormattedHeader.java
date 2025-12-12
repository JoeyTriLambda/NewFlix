package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.util.CharArrayBuffer;

/* loaded from: classes2.dex */
public interface FormattedHeader extends Header {
    CharArrayBuffer getBuffer();

    int getValuePos();
}
