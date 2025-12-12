package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.youtube.player.internal.i;
import com.google.android.youtube.player.internal.w;

/* loaded from: classes.dex */
public final class b extends a {
    @Override // com.google.android.youtube.player.internal.a
    public final a8.b a(Context context, String str, i.a aVar, i.b bVar) {
        return new g(context, str, context.getPackageName(), a8.h.d(context), aVar, bVar);
    }

    @Override // com.google.android.youtube.player.internal.a
    public final d a(Activity activity, a8.b bVar, boolean z10) throws w.a {
        return w.a(activity, bVar.a(), z10);
    }
}
