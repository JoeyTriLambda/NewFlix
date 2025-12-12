package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.f0;

/* compiled from: ComponentDialog.kt */
/* loaded from: classes.dex */
public class h extends Dialog implements androidx.lifecycle.l, m, j2.c {

    /* renamed from: b, reason: collision with root package name */
    public androidx.lifecycle.m f813b;

    /* renamed from: m, reason: collision with root package name */
    public final j2.b f814m;

    /* renamed from: n, reason: collision with root package name */
    public final OnBackPressedDispatcher f815n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, int i10) {
        super(context, i10);
        zf.i.checkNotNullParameter(context, "context");
        this.f814m = j2.b.f14578d.create(this);
        this.f815n = new OnBackPressedDispatcher(new d(this, 2));
    }

    public static void a(h hVar) {
        zf.i.checkNotNullParameter(hVar, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        zf.i.checkNotNullParameter(view, "view");
        initializeViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.lifecycle.l
    public Lifecycle getLifecycle() {
        androidx.lifecycle.m mVar = this.f813b;
        if (mVar != null) {
            return mVar;
        }
        androidx.lifecycle.m mVar2 = new androidx.lifecycle.m(this);
        this.f813b = mVar2;
        return mVar2;
    }

    @Override // androidx.activity.m
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.f815n;
    }

    @Override // j2.c
    public androidx.savedstate.a getSavedStateRegistry() {
        return this.f814m.getSavedStateRegistry();
    }

    public void initializeViewTreeOwners() {
        Window window = getWindow();
        zf.i.checkNotNull(window);
        View decorView = window.getDecorView();
        zf.i.checkNotNullExpressionValue(decorView, "window!!.decorView");
        f0.set(decorView, this);
        Window window2 = getWindow();
        zf.i.checkNotNull(window2);
        View decorView2 = window2.getDecorView();
        zf.i.checkNotNullExpressionValue(decorView2, "window!!.decorView");
        o.set(decorView2, this);
        Window window3 = getWindow();
        zf.i.checkNotNull(window3);
        View decorView3 = window3.getDecorView();
        zf.i.checkNotNullExpressionValue(decorView3, "window!!.decorView");
        androidx.savedstate.b.set(decorView3, this);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.f815n.onBackPressed();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            zf.i.checkNotNullExpressionValue(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            this.f815n.setOnBackInvokedDispatcher(onBackInvokedDispatcher);
        }
        this.f814m.performRestore(bundle);
        androidx.lifecycle.m mVar = this.f813b;
        if (mVar == null) {
            mVar = new androidx.lifecycle.m(this);
            this.f813b = mVar;
        }
        mVar.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        zf.i.checkNotNullExpressionValue(bundleOnSaveInstanceState, "super.onSaveInstanceState()");
        this.f814m.performSave(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        androidx.lifecycle.m mVar = this.f813b;
        if (mVar == null) {
            mVar = new androidx.lifecycle.m(this);
            this.f813b = mVar;
        }
        mVar.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        androidx.lifecycle.m mVar = this.f813b;
        if (mVar == null) {
            mVar = new androidx.lifecycle.m(this);
            this.f813b = mVar;
        }
        mVar.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.f813b = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i10) {
        initializeViewTreeOwners();
        super.setContentView(i10);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        zf.i.checkNotNullParameter(view, "view");
        initializeViewTreeOwners();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        zf.i.checkNotNullParameter(view, "view");
        initializeViewTreeOwners();
        super.setContentView(view, layoutParams);
    }
}
