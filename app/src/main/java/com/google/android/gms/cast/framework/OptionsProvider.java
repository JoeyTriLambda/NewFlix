package com.google.android.gms.cast.framework;

import android.content.Context;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public interface OptionsProvider {
    List<SessionProvider> getAdditionalSessionProviders(Context context);

    CastOptions getCastOptions(Context context);
}
