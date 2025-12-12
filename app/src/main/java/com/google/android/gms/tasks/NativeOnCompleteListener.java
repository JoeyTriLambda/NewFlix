package com.google.android.gms.tasks;

import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class NativeOnCompleteListener implements OnCompleteListener<Object> {
    @KeepForSdk
    public native void nativeOnComplete(long j10, Object obj, boolean z10, boolean z11, String str);

    @Override // com.google.android.gms.tasks.OnCompleteListener
    @KeepForSdk
    public void onComplete(Task<Object> task) {
        Object result;
        String message;
        Exception exception;
        if (task.isSuccessful()) {
            result = task.getResult();
            message = null;
        } else if (task.isCanceled() || (exception = task.getException()) == null) {
            result = null;
            message = null;
        } else {
            message = exception.getMessage();
            result = null;
        }
        nativeOnComplete(0L, result, task.isSuccessful(), task.isCanceled(), message);
    }
}
