package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.youtube.player.internal.i;
import com.google.android.youtube.player.internal.w;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f9567a;

    static {
        a bVar;
        try {
            try {
                bVar = (a) Class.forName("com.google.android.youtube.api.locallylinked.LocallyLinkedFactory").asSubclass(a.class).newInstance();
            } catch (IllegalAccessException e10) {
                throw new IllegalStateException(e10);
            } catch (InstantiationException e11) {
                throw new IllegalStateException(e11);
            }
        } catch (ClassNotFoundException unused) {
            bVar = new b();
        }
        f9567a = bVar;
    }

    public static a a() {
        return f9567a;
    }

    public abstract a8.b a(Context context, String str, i.a aVar, i.b bVar);

    public abstract d a(Activity activity, a8.b bVar, boolean z10) throws w.a;
}
