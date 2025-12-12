package okhttp3.internal.http1;

import ah.e;
import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import okhttp3.Headers;
import zf.f;
import zf.i;

/* compiled from: HeadersReader.kt */
/* loaded from: classes2.dex */
public final class HeadersReader {
    public static final Companion Companion = new Companion(null);
    private static final int HEADER_LIMIT = 262144;
    private long headerLimit;
    private final e source;

    /* compiled from: HeadersReader.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public HeadersReader(e eVar) {
        i.checkNotNullParameter(eVar, "source");
        this.source = eVar;
        this.headerLimit = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    }

    public final e getSource() {
        return this.source;
    }

    public final Headers readHeaders() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String line = readLine();
            if (line.length() == 0) {
                return builder.build();
            }
            builder.addLenient$okhttp(line);
        }
    }

    public final String readLine() throws IOException {
        String utf8LineStrict = this.source.readUtf8LineStrict(this.headerLimit);
        this.headerLimit -= utf8LineStrict.length();
        return utf8LineStrict;
    }
}
