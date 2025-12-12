package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
/* loaded from: classes.dex */
public class ListenerHolders {
    public ListenerHolders() {
        Collections.newSetFromMap(new WeakHashMap());
    }

    @KeepForSdk
    public static <L> ListenerHolder<L> createListenerHolder(L l10, Looper looper, String str) {
        Preconditions.checkNotNull(l10, "Listener must not be null");
        Preconditions.checkNotNull(looper, "Looper must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        return new ListenerHolder<>(l10, looper, str);
    }
}
