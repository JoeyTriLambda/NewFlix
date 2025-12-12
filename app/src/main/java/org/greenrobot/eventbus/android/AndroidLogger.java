package org.greenrobot.eventbus.android;

import ac.c;
import android.util.Log;
import java.util.logging.Level;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.Logger;

/* loaded from: classes2.dex */
public class AndroidLogger implements Logger {
    private final String tag;

    public AndroidLogger(String str) {
        this.tag = str;
    }

    private int mapLevel(Level level) {
        int iIntValue = level.intValue();
        if (iIntValue < 800) {
            return iIntValue < 500 ? 2 : 3;
        }
        if (iIntValue < 900) {
            return 4;
        }
        return iIntValue < 1000 ? 5 : 6;
    }

    @Override // org.greenrobot.eventbus.Logger
    public void log(Level level, String str) {
        if (level != Level.OFF) {
            Log.println(mapLevel(level), this.tag, str);
        }
    }

    @Override // org.greenrobot.eventbus.Logger
    public void log(Level level, String str, Throwable th2) {
        if (level != Level.OFF) {
            int iMapLevel = mapLevel(level);
            String str2 = this.tag;
            StringBuilder sbU = c.u(str, StringUtils.LF);
            sbU.append(Log.getStackTraceString(th2));
            Log.println(iMapLevel, str2, sbU.toString());
        }
    }
}
