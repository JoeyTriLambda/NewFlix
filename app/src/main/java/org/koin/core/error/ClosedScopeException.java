package org.koin.core.error;

import zf.i;

/* compiled from: ClosedScopeException.kt */
/* loaded from: classes2.dex */
public final class ClosedScopeException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClosedScopeException(String str) {
        super(str);
        i.checkNotNullParameter(str, "msg");
    }
}
