package org.greenrobot.eventbus.util;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import org.greenrobot.eventbus.Logger;

/* loaded from: classes2.dex */
public class ExceptionToResourceMapping {
    public final Map<Class<? extends Throwable>, Integer> throwableToMsgIdMap = new HashMap();

    public ExceptionToResourceMapping addMapping(Class<? extends Throwable> cls, int i10) {
        this.throwableToMsgIdMap.put(cls, Integer.valueOf(i10));
        return this;
    }

    public Integer mapThrowable(Throwable th2) {
        int i10 = 20;
        Throwable cause = th2;
        do {
            Integer numMapThrowableFlat = mapThrowableFlat(cause);
            if (numMapThrowableFlat != null) {
                return numMapThrowableFlat;
            }
            cause = cause.getCause();
            i10--;
            if (i10 <= 0 || cause == th2) {
                break;
            }
        } while (cause != null);
        Logger.Default.get().log(Level.FINE, "No specific message resource ID found for " + th2);
        return null;
    }

    public Integer mapThrowableFlat(Throwable th2) {
        Class<?> cls = th2.getClass();
        Integer value = this.throwableToMsgIdMap.get(cls);
        if (value == null) {
            Class<? extends Throwable> cls2 = null;
            for (Map.Entry<Class<? extends Throwable>, Integer> entry : this.throwableToMsgIdMap.entrySet()) {
                Class<? extends Throwable> key = entry.getKey();
                if (key.isAssignableFrom(cls) && (cls2 == null || cls2.isAssignableFrom(key))) {
                    value = entry.getValue();
                    cls2 = key;
                }
            }
        }
        return value;
    }
}
