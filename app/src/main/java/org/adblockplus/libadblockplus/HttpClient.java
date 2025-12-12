package org.adblockplus.libadblockplus;

/* loaded from: classes2.dex */
public abstract class HttpClient {
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_CONTENT_LENGTH = "content-length";
    public static final String HEADER_CONTENT_TYPE = "content-type";
    public static final String HEADER_COOKIE = "Cookie";
    public static final String HEADER_CSP = "content-security-policy";
    public static final String HEADER_DATE = "date";
    public static final String HEADER_EXPIRES = "expires";
    public static final String HEADER_LAST_MODIFIED = "last-modified";
    public static final String HEADER_LOCATION = "Location";
    public static final String HEADER_PROXY_AUTHENTICATE = "proxy-authenticate";
    public static final String HEADER_REFERRER = "Referer";
    public static final String HEADER_REFRESH = "Refresh";
    public static final String HEADER_REQUESTED_RANGE = "Range";
    public static final String HEADER_REQUESTED_WITH = "X-Requested-With";
    public static final String HEADER_REQUESTED_WITH_XMLHTTPREQUEST = "XMLHttpRequest";
    public static final String HEADER_RETRY_AFTER = "retry-after";
    public static final String HEADER_SET_COOKIE = "set-cookie";
    public static final String HEADER_SITEKEY = "x-adblock-key";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final String HEADER_VIA = "via";
    public static final String HEADER_WWW_AUTHENTICATE = "www-authenticate";
    public static final String MIME_TYPE_TEXT_HTML = "text/html";
    public static final String REQUEST_METHOD_DELETE = "DELETE";
    public static final String REQUEST_METHOD_GET = "GET";
    public static final String REQUEST_METHOD_HEAD = "HEAD";
    public static final String REQUEST_METHOD_OPTIONS = "OPTIONS";
    public static final String REQUEST_METHOD_POST = "POST";
    public static final String REQUEST_METHOD_PUT = "PUT";
    public static final String REQUEST_METHOD_TRACE = "TRACE";
    public static final int STATUS_CODE_OK = 200;

    public interface Callback {
        void onFinished(ServerResponse serverResponse);
    }

    public static class JniCallback implements Callback, Disposable {
        private final Disposer disposer;
        protected final long ptr;

        public static final class DisposeWrapper implements Disposable {
            private final long ptr;

            public DisposeWrapper(long j10) {
                this.ptr = j10;
            }

            @Override // org.adblockplus.libadblockplus.Disposable
            public void dispose() {
                HttpClient.callbackDtor(this.ptr);
            }
        }

        public JniCallback(long j10) {
            this.ptr = j10;
            this.disposer = new Disposer(this, new DisposeWrapper(j10));
        }

        @Override // org.adblockplus.libadblockplus.Disposable
        public void dispose() {
            this.disposer.dispose();
        }

        @Override // org.adblockplus.libadblockplus.HttpClient.Callback
        public void onFinished(ServerResponse serverResponse) {
            HttpClient.callbackOnFinished(this.ptr, serverResponse);
        }
    }

    static {
        System.loadLibrary(BuildConfig.nativeLibraryName);
        registerNatives();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void callbackDtor(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void callbackOnFinished(long j10, ServerResponse serverResponse);

    public static boolean isNoContentCode(int i10) {
        return i10 == 204 || i10 == 304 || (i10 >= 100 && i10 <= 199);
    }

    public static boolean isRedirectCode(int i10) {
        return i10 >= 300 && i10 <= 399;
    }

    public static boolean isSuccessCode(int i10) {
        return i10 >= 200 && i10 <= 299;
    }

    public static boolean isValidCode(int i10) {
        return i10 >= 100 && i10 <= 599;
    }

    private static native void registerNatives();

    public abstract void request(HttpRequest httpRequest, Callback callback);
}
