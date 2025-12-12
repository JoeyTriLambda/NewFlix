package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import f5.b;

@TargetApi(16)
/* loaded from: classes.dex */
public interface DrmSession<T extends f5.b> {

    public static class DrmSessionException extends Exception {
        public DrmSessionException(Throwable th2) {
            super(th2);
        }
    }
}
