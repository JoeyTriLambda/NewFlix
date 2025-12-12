package com.unity3d.services.core.extensions;

import zf.i;

/* compiled from: TaskExtensions.kt */
/* loaded from: classes2.dex */
public final class AbortRetryException extends Exception {
    private final String reason;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbortRetryException(String str) {
        super(str);
        i.checkNotNullParameter(str, "reason");
        this.reason = str;
    }
}
