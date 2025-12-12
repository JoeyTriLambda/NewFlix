package org.adblockplus.libadblockplus;

import cz.msebera.android.httpclient.HttpStatus;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public final class ServerResponse {
    private String finalUrl;
    private long status = NsStatus.OK.getStatusCode();
    private int responseStatus = HttpStatus.SC_BAD_REQUEST;
    private String[] headers = null;
    private ByteBuffer response = null;
    private InputStream inputStream = null;

    public enum NsStatus {
        OK(0),
        ERROR_FAILURE(2147500037L),
        ERROR_OUT_OF_MEMORY(2147942414L),
        ERROR_MALFORMED_URI(2152398858L),
        ERROR_CONNECTION_REFUSED(2152398861L),
        ERROR_NET_TIMEOUT(2152398862L),
        ERROR_NO_CONTENT(2152398865L),
        ERROR_UNKNOWN_PROTOCOL(2152398866L),
        ERROR_NET_RESET(2152398868L),
        ERROR_UNKNOWN_HOST(2152398878L),
        ERROR_REDIRECT_LOOP(2152398879L),
        ERROR_UNKNOWN_PROXY_HOST(2152398890L),
        ERROR_NET_INTERRUPT(2152398919L),
        ERROR_UNKNOWN_PROXY_CONNECTION_REFUSED(2152398920L),
        CUSTOM_ERROR_BASE(2156199936L),
        ERROR_NOT_INITIALIZED(3253927937L);

        private static final HashMap<Long, NsStatus> ENUM_MAP = new HashMap<>();
        private final long statusCode;

        static {
            for (NsStatus nsStatus : values()) {
                ENUM_MAP.put(Long.valueOf(nsStatus.statusCode), nsStatus);
            }
        }

        NsStatus(long j10) {
            this.statusCode = j10;
        }

        public static NsStatus fromStatusCode(long j10) {
            NsStatus nsStatus = ENUM_MAP.get(Long.valueOf(j10));
            return nsStatus != null ? nsStatus : ERROR_FAILURE;
        }

        public long getStatusCode() {
            return this.statusCode;
        }
    }

    public String getFinalUrl() {
        return this.finalUrl;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public ByteBuffer getResponse() {
        return this.response;
    }

    public List<HeaderEntry> getResponseHeaders() {
        ArrayList arrayList = new ArrayList();
        if (this.headers != null) {
            int i10 = 0;
            while (true) {
                String[] strArr = this.headers;
                if (i10 >= strArr.length) {
                    break;
                }
                arrayList.add(HeaderEntry.of(strArr[i10], strArr[i10 + 1]));
                i10 += 2;
            }
        }
        return arrayList;
    }

    public int getResponseStatus() {
        return this.responseStatus;
    }

    public NsStatus getStatus() {
        return NsStatus.fromStatusCode(this.status);
    }

    public void setFinalUrl(String str) {
        this.finalUrl = str;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setResponse(ByteBuffer byteBuffer) {
        this.response = byteBuffer;
    }

    public void setResponseHeaders(List<HeaderEntry> list) {
        if (list.isEmpty()) {
            this.headers = null;
            return;
        }
        this.headers = new String[list.size() * 2];
        int i10 = 0;
        for (HeaderEntry headerEntry : list) {
            this.headers[i10] = headerEntry.getKey();
            this.headers[i10 + 1] = headerEntry.getValue();
            i10 += 2;
        }
    }

    public void setResponseStatus(int i10) {
        this.responseStatus = i10;
    }

    public void setStatus(NsStatus nsStatus) {
        this.status = nsStatus.getStatusCode();
    }
}
