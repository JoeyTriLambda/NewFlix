package org.koin.core.error;

import zf.i;

/* compiled from: KoinAppAlreadyStartedException.kt */
/* loaded from: classes2.dex */
public final class KoinAppAlreadyStartedException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KoinAppAlreadyStartedException(String str) {
        super(str);
        i.checkNotNullParameter(str, "msg");
    }
}
