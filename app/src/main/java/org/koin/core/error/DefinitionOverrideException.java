package org.koin.core.error;

import zf.i;

/* compiled from: DefinitionOverrideException.kt */
/* loaded from: classes2.dex */
public final class DefinitionOverrideException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefinitionOverrideException(String str) {
        super(str);
        i.checkNotNullParameter(str, "msg");
    }
}
