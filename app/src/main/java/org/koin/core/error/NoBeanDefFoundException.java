package org.koin.core.error;

import zf.i;

/* compiled from: NoBeanDefFoundException.kt */
/* loaded from: classes2.dex */
public final class NoBeanDefFoundException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoBeanDefFoundException(String str) {
        super(str);
        i.checkNotNullParameter(str, "msg");
    }
}
