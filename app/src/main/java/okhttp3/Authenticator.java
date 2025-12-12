package okhttp3;

import java.io.IOException;
import okhttp3.internal.authenticator.JavaNetAuthenticator;
import zf.i;

/* compiled from: Authenticator.kt */
/* loaded from: classes2.dex */
public interface Authenticator {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final Authenticator NONE = new Companion.AuthenticatorNone();
    public static final Authenticator JAVA_NET_AUTHENTICATOR = new JavaNetAuthenticator(null, 1, null);

    /* compiled from: Authenticator.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* compiled from: Authenticator.kt */
        public static final class AuthenticatorNone implements Authenticator {
            @Override // okhttp3.Authenticator
            public Request authenticate(Route route, Response response) {
                i.checkNotNullParameter(response, "response");
                return null;
            }
        }

        private Companion() {
        }
    }

    Request authenticate(Route route, Response response) throws IOException;
}
