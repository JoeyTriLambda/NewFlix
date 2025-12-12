package cz.msebera.android.httpclient.extras;

import android.util.Log;

/* loaded from: classes2.dex */
public class HttpClientAndroidLog {
    private String logTag;
    private boolean debugEnabled = false;
    private boolean errorEnabled = false;
    private boolean traceEnabled = false;
    private boolean warnEnabled = false;
    private boolean infoEnabled = false;

    public HttpClientAndroidLog(Object obj) {
        this.logTag = obj.toString();
    }

    public void debug(Object obj) {
        if (isDebugEnabled()) {
            Log.d(this.logTag, obj.toString());
        }
    }

    public void enableDebug(boolean z10) {
        this.debugEnabled = z10;
    }

    public void enableError(boolean z10) {
        this.errorEnabled = z10;
    }

    public void enableInfo(boolean z10) {
        this.infoEnabled = z10;
    }

    public void enableTrace(boolean z10) {
        this.traceEnabled = z10;
    }

    public void enableWarn(boolean z10) {
        this.warnEnabled = z10;
    }

    public void error(Object obj) {
        if (isErrorEnabled()) {
            Log.e(this.logTag, obj.toString());
        }
    }

    public void info(Object obj) {
        if (isInfoEnabled()) {
            Log.i(this.logTag, obj.toString());
        }
    }

    public boolean isDebugEnabled() {
        return this.debugEnabled;
    }

    public boolean isErrorEnabled() {
        return this.errorEnabled;
    }

    public boolean isInfoEnabled() {
        return this.infoEnabled;
    }

    public boolean isTraceEnabled() {
        return this.traceEnabled;
    }

    public boolean isWarnEnabled() {
        return this.warnEnabled;
    }

    public void trace(Object obj) {
        if (isTraceEnabled()) {
            Log.i(this.logTag, obj.toString());
        }
    }

    public void warn(Object obj) {
        if (isWarnEnabled()) {
            Log.w(this.logTag, obj.toString());
        }
    }

    public void debug(Object obj, Throwable th2) {
        if (isDebugEnabled()) {
            Log.d(this.logTag, obj.toString(), th2);
        }
    }

    public void error(Object obj, Throwable th2) {
        if (isErrorEnabled()) {
            Log.e(this.logTag, obj.toString(), th2);
        }
    }

    public void info(Object obj, Throwable th2) {
        if (isInfoEnabled()) {
            Log.i(this.logTag, obj.toString(), th2);
        }
    }

    public void trace(Object obj, Throwable th2) {
        if (isTraceEnabled()) {
            Log.i(this.logTag, obj.toString(), th2);
        }
    }

    public void warn(Object obj, Throwable th2) {
        if (isWarnEnabled()) {
            Log.w(this.logTag, obj.toString(), th2);
        }
    }
}
