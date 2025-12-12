package org.adblockplus.libadblockplus.android;

import bi.a;
import org.adblockplus.libadblockplus.LogSystem;

/* loaded from: classes2.dex */
public class TimberLogSystem implements LogSystem {

    /* renamed from: org.adblockplus.libadblockplus.android.TimberLogSystem$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$adblockplus$libadblockplus$LogSystem$LogLevel;

        static {
            int[] iArr = new int[LogSystem.LogLevel.values().length];
            $SwitchMap$org$adblockplus$libadblockplus$LogSystem$LogLevel = iArr;
            try {
                iArr[LogSystem.LogLevel.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$adblockplus$libadblockplus$LogSystem$LogLevel[LogSystem.LogLevel.LOG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$adblockplus$libadblockplus$LogSystem$LogLevel[LogSystem.LogLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$adblockplus$libadblockplus$LogSystem$LogLevel[LogSystem.LogLevel.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$adblockplus$libadblockplus$LogSystem$LogLevel[LogSystem.LogLevel.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // org.adblockplus.libadblockplus.LogSystem
    public void logCallback(LogSystem.LogLevel logLevel, String str, String str2) {
        int i10 = AnonymousClass1.$SwitchMap$org$adblockplus$libadblockplus$LogSystem$LogLevel[logLevel.ordinal()];
        if (i10 == 3) {
            a.i("%s: %s", str2, str);
            return;
        }
        if (i10 == 4) {
            a.w("%s: %s", str2, str);
        } else if (i10 != 5) {
            a.d("%s: %s", str2, str);
        } else {
            a.e("%s: %s", str2, str);
        }
    }
}
