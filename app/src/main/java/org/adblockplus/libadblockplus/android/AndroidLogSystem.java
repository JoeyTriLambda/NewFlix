package org.adblockplus.libadblockplus.android;

import android.util.Log;
import org.adblockplus.libadblockplus.LogSystem;

/* loaded from: classes2.dex */
public class AndroidLogSystem implements LogSystem {

    /* renamed from: org.adblockplus.libadblockplus.android.AndroidLogSystem$1, reason: invalid class name */
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

    private static int abpLogLevelToAndroid(LogSystem.LogLevel logLevel) {
        int i10 = AnonymousClass1.$SwitchMap$org$adblockplus$libadblockplus$LogSystem$LogLevel[logLevel.ordinal()];
        if (i10 == 3) {
            return 4;
        }
        if (i10 != 4) {
            return i10 != 5 ? 2 : 6;
        }
        return 5;
    }

    @Override // org.adblockplus.libadblockplus.LogSystem
    public void logCallback(LogSystem.LogLevel logLevel, String str, String str2) {
        Log.println(abpLogLevelToAndroid(logLevel), str2, str);
    }
}
