package androidx.datastore.core;

import java.io.IOException;
import zf.f;
import zf.i;

/* compiled from: Serializer.kt */
/* loaded from: classes.dex */
public final class CorruptionException extends IOException {
    public /* synthetic */ CorruptionException(String str, Throwable th2, int i10, f fVar) {
        this(str, (i10 & 2) != 0 ? null : th2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CorruptionException(String str, Throwable th2) {
        super(str, th2);
        i.checkNotNullParameter(str, "message");
    }
}
