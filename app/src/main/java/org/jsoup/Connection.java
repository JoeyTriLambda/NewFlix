package org.jsoup;

import java.io.InputStream;
import java.net.URL;

/* loaded from: classes2.dex */
public interface Connection {

    public enum Method {
        GET(false),
        /* JADX INFO: Fake field, exist only in values array */
        POST(true),
        /* JADX INFO: Fake field, exist only in values array */
        PUT(true),
        /* JADX INFO: Fake field, exist only in values array */
        DELETE(false),
        /* JADX INFO: Fake field, exist only in values array */
        PATCH(true),
        HEAD(false),
        /* JADX INFO: Fake field, exist only in values array */
        OPTIONS(false),
        /* JADX INFO: Fake field, exist only in values array */
        TRACE(false);


        /* renamed from: b, reason: collision with root package name */
        public final boolean f17119b;

        Method(boolean z10) {
            this.f17119b = z10;
        }

        public final boolean hasBody() {
            return this.f17119b;
        }
    }

    public interface a<T extends a> {
        T method(Method method);

        T url(URL url);
    }

    public interface b {
        String contentType();

        boolean hasInputStream();

        InputStream inputStream();

        String key();

        String value();
    }

    public interface c extends a<c> {
        gh.d parser();

        c timeout(int i10);
    }

    public interface d extends a<d> {
    }

    Connection url(String str);
}
