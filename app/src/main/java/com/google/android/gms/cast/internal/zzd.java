package com.google.android.gms.cast.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public class zzd extends zzp {

    /* renamed from: d, reason: collision with root package name */
    public final List f6854d;

    public zzd(String str, String str2, String str3) {
        super(str, "MediaControlChannel", null);
        this.f6854d = Collections.synchronizedList(new ArrayList());
    }

    public final List zza() {
        return this.f6854d;
    }

    public final void zzb() {
        synchronized (this.f6854d) {
            Iterator it = this.f6854d.iterator();
            while (it.hasNext()) {
                ((zzau) it.next()).zzc(2002);
            }
        }
    }

    public final void zzc(zzau zzauVar) {
        this.f6854d.add(zzauVar);
    }
}
