package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.SessionState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public abstract class SessionTransferCallback {
    public static final int TRANSFER_FAILED_REASON_STORE_SESSION_STATE = 100;
    public static final int TRANSFER_FAILED_REASON_TRANSFER_TIMEOUT = 101;
    public static final int TRANSFER_TYPE_FROM_REMOTE_TO_LOCAL = 1;
    public static final int TRANSFER_TYPE_UNKNOWN = 0;

    /* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TransferFailedReason {
    }

    /* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TransferType {
    }

    public void onTransferring(int i10) {
    }

    public void onTransferFailed(int i10, int i11) {
    }

    public void onTransferred(int i10, SessionState sessionState) {
    }
}
