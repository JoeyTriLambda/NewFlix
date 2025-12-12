package okhttp3;

import java.io.IOException;
import zf.f;
import zf.i;

/* compiled from: Protocol.kt */
/* loaded from: classes2.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");

    public static final Companion Companion = new Companion(null);
    private final String protocol;

    /* compiled from: Protocol.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final Protocol get(String str) throws IOException {
            i.checkNotNullParameter(str, "protocol");
            Protocol protocol = Protocol.HTTP_1_0;
            if (!i.areEqual(str, protocol.protocol)) {
                protocol = Protocol.HTTP_1_1;
                if (!i.areEqual(str, protocol.protocol)) {
                    protocol = Protocol.H2_PRIOR_KNOWLEDGE;
                    if (!i.areEqual(str, protocol.protocol)) {
                        protocol = Protocol.HTTP_2;
                        if (!i.areEqual(str, protocol.protocol)) {
                            protocol = Protocol.SPDY_3;
                            if (!i.areEqual(str, protocol.protocol)) {
                                protocol = Protocol.QUIC;
                                if (!i.areEqual(str, protocol.protocol)) {
                                    throw new IOException(i.stringPlus("Unexpected protocol: ", str));
                                }
                            }
                        }
                    }
                }
            }
            return protocol;
        }
    }

    Protocol(String str) {
        this.protocol = str;
    }

    public static final Protocol get(String str) throws IOException {
        return Companion.get(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
