package com.google.android.material.floatingactionbutton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.d;

/* compiled from: FloatingActionButton.java */
/* loaded from: classes.dex */
public final class a implements d.f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FloatingActionButton.a f9132a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FloatingActionButton f9133b;

    public a(FloatingActionButton floatingActionButton, FloatingActionButton.a aVar) {
        this.f9133b = floatingActionButton;
        this.f9132a = aVar;
    }

    public void onHidden() {
        this.f9132a.onHidden(this.f9133b);
    }

    public void onShown() {
        this.f9132a.onShown(this.f9133b);
    }
}
