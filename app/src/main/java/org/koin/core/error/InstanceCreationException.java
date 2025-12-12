package org.koin.core.error;

import zf.i;

/* compiled from: InstanceCreationException.kt */
/* loaded from: classes2.dex */
public final class InstanceCreationException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstanceCreationException(String str, Exception exc) {
        super(str, exc);
        i.checkNotNullParameter(str, "msg");
        i.checkNotNullParameter(exc, "parent");
    }
}
