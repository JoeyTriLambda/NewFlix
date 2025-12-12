package f5;

import android.annotation.TargetApi;
import android.media.MediaCrypto;

/* compiled from: FrameworkMediaCrypto.java */
@TargetApi(16)
/* loaded from: classes.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    public final MediaCrypto f11517a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11518b;

    public c(MediaCrypto mediaCrypto, boolean z10) {
        this.f11517a = (MediaCrypto) l6.a.checkNotNull(mediaCrypto);
        this.f11518b = z10;
    }

    public MediaCrypto getWrappedMediaCrypto() {
        return this.f11517a;
    }

    public boolean requiresSecureDecoderComponent(String str) {
        return !this.f11518b && this.f11517a.requiresSecureDecoderComponent(str);
    }
}
