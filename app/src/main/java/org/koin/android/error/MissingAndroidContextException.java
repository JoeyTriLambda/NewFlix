package org.koin.android.error;

import zf.i;

/* compiled from: MissingAndroidContextException.kt */
/* loaded from: classes2.dex */
public final class MissingAndroidContextException extends Throwable {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissingAndroidContextException(String str) {
        super(str);
        i.checkNotNullParameter(str, "s");
    }
}
