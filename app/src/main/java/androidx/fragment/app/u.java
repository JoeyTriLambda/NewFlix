package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentHostCallback.java */
/* loaded from: classes.dex */
public abstract class u<E> extends r {

    /* renamed from: b, reason: collision with root package name */
    public final Activity f2927b;

    /* renamed from: m, reason: collision with root package name */
    public final Context f2928m;

    /* renamed from: n, reason: collision with root package name */
    public final Handler f2929n;

    /* renamed from: o, reason: collision with root package name */
    public final z f2930o;

    public u(p pVar) {
        Handler handler = new Handler();
        this.f2930o = new z();
        this.f2927b = pVar;
        this.f2928m = (Context) w0.h.checkNotNull(pVar, "context == null");
        this.f2929n = (Handler) w0.h.checkNotNull(handler, "handler == null");
    }

    public Handler getHandler() {
        return this.f2929n;
    }

    @Override // androidx.fragment.app.r
    public View onFindViewById(int i10) {
        return null;
    }

    public abstract E onGetHost();

    public LayoutInflater onGetLayoutInflater() {
        return LayoutInflater.from(this.f2928m);
    }

    @Override // androidx.fragment.app.r
    public boolean onHasView() {
        return true;
    }

    public void onStartActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10, Bundle bundle) {
        if (i10 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        m0.a.startActivity(this.f2928m, intent, bundle);
    }

    public void onSupportInvalidateOptionsMenu() {
    }

    public void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }
}
