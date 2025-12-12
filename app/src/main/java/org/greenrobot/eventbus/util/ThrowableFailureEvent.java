package org.greenrobot.eventbus.util;

/* loaded from: classes2.dex */
public class ThrowableFailureEvent implements HasExecutionScope {
    private Object executionContext;
    protected final boolean suppressErrorUi;
    protected final Throwable throwable;

    public ThrowableFailureEvent(Throwable th2) {
        this.throwable = th2;
        this.suppressErrorUi = false;
    }

    @Override // org.greenrobot.eventbus.util.HasExecutionScope
    public Object getExecutionScope() {
        return this.executionContext;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public boolean isSuppressErrorUi() {
        return this.suppressErrorUi;
    }

    @Override // org.greenrobot.eventbus.util.HasExecutionScope
    public void setExecutionScope(Object obj) {
        this.executionContext = obj;
    }

    public ThrowableFailureEvent(Throwable th2, boolean z10) {
        this.throwable = th2;
        this.suppressErrorUi = z10;
    }
}
