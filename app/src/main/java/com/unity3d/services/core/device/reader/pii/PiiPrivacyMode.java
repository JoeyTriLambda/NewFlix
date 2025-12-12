package com.unity3d.services.core.device.reader.pii;

import java.util.Locale;

/* loaded from: classes2.dex */
public enum PiiPrivacyMode {
    APP,
    NONE,
    MIXED,
    UNDEFINED,
    NULL;

    public static PiiPrivacyMode getPiiPrivacyMode(String str) {
        if (str == null) {
            return NULL;
        }
        PiiPrivacyMode piiPrivacyMode = UNDEFINED;
        try {
            return valueOf(str.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException unused) {
            return piiPrivacyMode;
        }
    }
}
