package okhttp3.internal.cache;

import ah.w;
import java.io.IOException;

/* compiled from: CacheRequest.kt */
/* loaded from: classes2.dex */
public interface CacheRequest {
    void abort();

    w body() throws IOException;
}
