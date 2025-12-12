package org.adblockplus.libadblockplus;

/* loaded from: classes2.dex */
public interface LogSystem {

    public enum LogLevel {
        TRACE,
        LOG,
        INFO,
        WARN,
        ERROR
    }

    void logCallback(LogLevel logLevel, String str, String str2);
}
