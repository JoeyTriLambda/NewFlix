package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.y.m;

/* compiled from: DialogFragment.java */
/* loaded from: classes.dex */
public class n extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: h0, reason: collision with root package name */
    public Handler f2879h0;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f2888q0;

    /* renamed from: s0, reason: collision with root package name */
    public Dialog f2890s0;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f2891t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f2892u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f2893v0;

    /* renamed from: i0, reason: collision with root package name */
    public final a f2880i0 = new a();

    /* renamed from: j0, reason: collision with root package name */
    public final b f2881j0 = new b();

    /* renamed from: k0, reason: collision with root package name */
    public final c f2882k0 = new c();

    /* renamed from: l0, reason: collision with root package name */
    public int f2883l0 = 0;

    /* renamed from: m0, reason: collision with root package name */
    public int f2884m0 = 0;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f2885n0 = true;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f2886o0 = true;

    /* renamed from: p0, reason: collision with root package name */
    public int f2887p0 = -1;

    /* renamed from: r0, reason: collision with root package name */
    public final d f2889r0 = new d();

    /* renamed from: w0, reason: collision with root package name */
    public boolean f2894w0 = false;

    /* compiled from: DialogFragment.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            n nVar = n.this;
            nVar.f2882k0.onDismiss(nVar.f2890s0);
        }
    }

    /* compiled from: DialogFragment.java */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(DialogInterface dialogInterface) {
            n nVar = n.this;
            Dialog dialog = nVar.f2890s0;
            if (dialog != null) {
                nVar.onCancel(dialog);
            }
        }
    }

    /* compiled from: DialogFragment.java */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(DialogInterface dialogInterface) {
            n nVar = n.this;
            Dialog dialog = nVar.f2890s0;
            if (dialog != null) {
                nVar.onDismiss(dialog);
            }
        }
    }

    /* compiled from: DialogFragment.java */
    public class d implements androidx.lifecycle.s<androidx.lifecycle.l> {
        public d() {
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onChanged(androidx.lifecycle.l lVar) {
            if (lVar != null) {
                n nVar = n.this;
                if (nVar.f2886o0) {
                    View viewRequireView = nVar.requireView();
                    if (viewRequireView.getParent() != null) {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                    if (nVar.f2890s0 != null) {
                        if (y.isLoggingEnabled(3)) {
                            Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + nVar.f2890s0);
                        }
                        nVar.f2890s0.setContentView(viewRequireView);
                    }
                }
            }
        }
    }

    /* compiled from: DialogFragment.java */
    public class e extends r {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r f2899b;

        public e(Fragment.b bVar) {
            this.f2899b = bVar;
        }

        @Override // androidx.fragment.app.r
        public View onFindViewById(int i10) {
            r rVar = this.f2899b;
            if (rVar.onHasView()) {
                return rVar.onFindViewById(i10);
            }
            Dialog dialog = n.this.f2890s0;
            if (dialog != null) {
                return dialog.findViewById(i10);
            }
            return null;
        }

        @Override // androidx.fragment.app.r
        public boolean onHasView() {
            return this.f2899b.onHasView() || n.this.f2894w0;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final r a() {
        return new e(new Fragment.b());
    }

    public void dismiss() {
        o(false, false);
    }

    public Dialog getDialog() {
        return this.f2890s0;
    }

    public int getTheme() {
        return this.f2884m0;
    }

    @Override // androidx.fragment.app.Fragment
    public final void j(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.j(layoutInflater, viewGroup, bundle);
        if (this.S != null || this.f2890s0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f2890s0.onRestoreInstanceState(bundle2);
    }

    public final void o(boolean z10, boolean z11) {
        if (this.f2892u0) {
            return;
        }
        this.f2892u0 = true;
        this.f2893v0 = false;
        Dialog dialog = this.f2890s0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f2890s0.dismiss();
            if (!z11) {
                if (Looper.myLooper() == this.f2879h0.getLooper()) {
                    onDismiss(this.f2890s0);
                } else {
                    this.f2879h0.post(this.f2880i0);
                }
            }
        }
        this.f2891t0 = true;
        if (this.f2887p0 >= 0) {
            y parentFragmentManager = getParentFragmentManager();
            int i10 = this.f2887p0;
            parentFragmentManager.getClass();
            if (i10 < 0) {
                throw new IllegalArgumentException(ac.c.f("Bad id: ", i10));
            }
            parentFragmentManager.u(parentFragmentManager.new m(i10), z10);
            this.f2887p0 = -1;
            return;
        }
        g0 g0VarBeginTransaction = getParentFragmentManager().beginTransaction();
        g0VarBeginTransaction.setReorderingAllowed(true);
        g0VarBeginTransaction.remove(this);
        if (z10) {
            g0VarBeginTransaction.commitAllowingStateLoss();
        } else {
            g0VarBeginTransaction.commit();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().observeForever(this.f2889r0);
        if (this.f2893v0) {
            return;
        }
        this.f2892u0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2879h0 = new Handler();
        this.f2886o0 = this.I == 0;
        if (bundle != null) {
            this.f2883l0 = bundle.getInt("android:style", 0);
            this.f2884m0 = bundle.getInt("android:theme", 0);
            this.f2885n0 = bundle.getBoolean("android:cancelable", true);
            this.f2886o0 = bundle.getBoolean("android:showsDialog", this.f2886o0);
            this.f2887p0 = bundle.getInt("android:backStackId", -1);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (y.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new androidx.activity.h(requireContext(), getTheme());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.f2890s0;
        if (dialog != null) {
            this.f2891t0 = true;
            dialog.setOnDismissListener(null);
            this.f2890s0.dismiss();
            if (!this.f2892u0) {
                onDismiss(this.f2890s0);
            }
            this.f2890s0 = null;
            this.f2894w0 = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (!this.f2893v0 && !this.f2892u0) {
            this.f2892u0 = true;
        }
        getViewLifecycleOwnerLiveData().removeObserver(this.f2889r0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f2891t0) {
            return;
        }
        if (y.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        o(true, true);
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = super.onGetLayoutInflater(bundle);
        boolean z10 = this.f2886o0;
        if (!z10 || this.f2888q0) {
            if (y.isLoggingEnabled(2)) {
                String str = "getting layout inflater for DialogFragment " + this;
                if (this.f2886o0) {
                    Log.d("FragmentManager", "mCreatingDialog = true: " + str);
                } else {
                    Log.d("FragmentManager", "mShowsDialog = false: " + str);
                }
            }
            return layoutInflaterOnGetLayoutInflater;
        }
        if (z10 && !this.f2894w0) {
            try {
                this.f2888q0 = true;
                Dialog dialogOnCreateDialog = onCreateDialog(bundle);
                this.f2890s0 = dialogOnCreateDialog;
                if (this.f2886o0) {
                    setupDialog(dialogOnCreateDialog, this.f2883l0);
                    Context context = getContext();
                    if (context instanceof Activity) {
                        this.f2890s0.setOwnerActivity((Activity) context);
                    }
                    this.f2890s0.setCancelable(this.f2885n0);
                    this.f2890s0.setOnCancelListener(this.f2881j0);
                    this.f2890s0.setOnDismissListener(this.f2882k0);
                    this.f2894w0 = true;
                } else {
                    this.f2890s0 = null;
                }
            } finally {
                this.f2888q0 = false;
            }
        }
        if (y.isLoggingEnabled(2)) {
            Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
        }
        Dialog dialog = this.f2890s0;
        return dialog != null ? layoutInflaterOnGetLayoutInflater.cloneInContext(dialog.getContext()) : layoutInflaterOnGetLayoutInflater;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.f2890s0;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i10 = this.f2883l0;
        if (i10 != 0) {
            bundle.putInt("android:style", i10);
        }
        int i11 = this.f2884m0;
        if (i11 != 0) {
            bundle.putInt("android:theme", i11);
        }
        boolean z10 = this.f2885n0;
        if (!z10) {
            bundle.putBoolean("android:cancelable", z10);
        }
        boolean z11 = this.f2886o0;
        if (!z11) {
            bundle.putBoolean("android:showsDialog", z11);
        }
        int i12 = this.f2887p0;
        if (i12 != -1) {
            bundle.putInt("android:backStackId", i12);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = this.f2890s0;
        if (dialog != null) {
            this.f2891t0 = false;
            dialog.show();
            View decorView = this.f2890s0.getWindow().getDecorView();
            androidx.lifecycle.f0.set(decorView, this);
            androidx.lifecycle.g0.set(decorView, this);
            androidx.savedstate.b.set(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Dialog dialog = this.f2890s0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.f2890s0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f2890s0.onRestoreInstanceState(bundle2);
    }

    public final Dialog requireDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void setCancelable(boolean z10) {
        this.f2885n0 = z10;
        Dialog dialog = this.f2890s0;
        if (dialog != null) {
            dialog.setCancelable(z10);
        }
    }

    public void setShowsDialog(boolean z10) {
        this.f2886o0 = z10;
    }

    public void setupDialog(Dialog dialog, int i10) {
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void show(y yVar, String str) {
        this.f2892u0 = false;
        this.f2893v0 = true;
        g0 g0VarBeginTransaction = yVar.beginTransaction();
        g0VarBeginTransaction.setReorderingAllowed(true);
        g0VarBeginTransaction.add(this, str);
        g0VarBeginTransaction.commit();
    }

    public int show(g0 g0Var, String str) {
        this.f2892u0 = false;
        this.f2893v0 = true;
        g0Var.add(this, str);
        this.f2891t0 = false;
        int iCommit = g0Var.commit();
        this.f2887p0 = iCommit;
        return iCommit;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }
}
