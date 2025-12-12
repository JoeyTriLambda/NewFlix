package com.google.android.gms.tasks;

import java.util.ArrayDeque;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzr {

    /* renamed from: a, reason: collision with root package name */
    public final Object f8704a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public ArrayDeque f8705b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8706c;

    public final void zza(zzq zzqVar) {
        synchronized (this.f8704a) {
            if (this.f8705b == null) {
                this.f8705b = new ArrayDeque();
            }
            this.f8705b.add(zzqVar);
        }
    }

    public final void zzb(Task task) {
        zzq zzqVar;
        synchronized (this.f8704a) {
            if (this.f8705b != null && !this.f8706c) {
                this.f8706c = true;
                while (true) {
                    synchronized (this.f8704a) {
                        zzqVar = (zzq) this.f8705b.poll();
                        if (zzqVar == null) {
                            this.f8706c = false;
                            return;
                        }
                    }
                    zzqVar.zzd(task);
                }
            }
        }
    }
}
