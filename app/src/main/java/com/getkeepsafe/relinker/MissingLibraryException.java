package com.getkeepsafe.relinker;

import ac.c;
import java.util.Arrays;

/* loaded from: classes.dex */
public class MissingLibraryException extends RuntimeException {
    /* JADX WARN: Illegal instructions before constructor call */
    public MissingLibraryException(String str, String[] strArr, String[] strArr2) {
        StringBuilder sbV = c.v("Could not find '", str, "'. Looked for: ");
        sbV.append(Arrays.toString(strArr));
        sbV.append(", but only found: ");
        super(c.o(sbV, Arrays.toString(strArr2), "."));
    }
}
