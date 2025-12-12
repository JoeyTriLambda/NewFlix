package com.unity3d.scar.adapter.common;

/* compiled from: DispatchGroup.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f10669a = 0;

    /* renamed from: b, reason: collision with root package name */
    public Runnable f10670b;

    public synchronized void enter() {
        this.f10669a++;
    }

    public synchronized void leave() {
        Runnable runnable;
        int i10 = this.f10669a - 1;
        this.f10669a = i10;
        if (i10 <= 0 && (runnable = this.f10670b) != null) {
            runnable.run();
        }
    }

    public void notify(Runnable runnable) {
        this.f10670b = runnable;
        if (this.f10669a > 0 || runnable == null) {
            return;
        }
        runnable.run();
    }
}
