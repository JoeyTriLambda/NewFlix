package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.Lifecycle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import l0.a;

/* compiled from: FragmentActivity.java */
/* loaded from: classes.dex */
public class p extends ComponentActivity implements a.e, a.f {
    public static final /* synthetic */ int H = 0;
    public boolean E;
    public boolean F;
    public final s C = s.createController(new a());
    public final androidx.lifecycle.m D = new androidx.lifecycle.m(this);
    public boolean G = true;

    /* compiled from: FragmentActivity.java */
    public class a extends u<p> implements m0.b, m0.c, l0.u, l0.v, androidx.lifecycle.e0, androidx.activity.m, androidx.activity.result.e, j2.c, c0, x0.l {
        public a() {
            super(p.this);
        }

        @Override // x0.l
        public void addMenuProvider(x0.o oVar) {
            p.this.addMenuProvider(oVar);
        }

        @Override // m0.b
        public void addOnConfigurationChangedListener(w0.a<Configuration> aVar) {
            p.this.addOnConfigurationChangedListener(aVar);
        }

        @Override // l0.u
        public void addOnMultiWindowModeChangedListener(w0.a<l0.l> aVar) {
            p.this.addOnMultiWindowModeChangedListener(aVar);
        }

        @Override // l0.v
        public void addOnPictureInPictureModeChangedListener(w0.a<l0.x> aVar) {
            p.this.addOnPictureInPictureModeChangedListener(aVar);
        }

        @Override // m0.c
        public void addOnTrimMemoryListener(w0.a<Integer> aVar) {
            p.this.addOnTrimMemoryListener(aVar);
        }

        @Override // androidx.activity.result.e
        public androidx.activity.result.d getActivityResultRegistry() {
            return p.this.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.l
        public Lifecycle getLifecycle() {
            return p.this.D;
        }

        @Override // androidx.activity.m
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return p.this.getOnBackPressedDispatcher();
        }

        @Override // j2.c
        public androidx.savedstate.a getSavedStateRegistry() {
            return p.this.getSavedStateRegistry();
        }

        @Override // androidx.lifecycle.e0
        public androidx.lifecycle.d0 getViewModelStore() {
            return p.this.getViewModelStore();
        }

        public void invalidateMenu() {
            p.this.invalidateOptionsMenu();
        }

        @Override // androidx.fragment.app.c0
        public void onAttachFragment(y yVar, Fragment fragment) {
            p.this.onAttachFragment(fragment);
        }

        @Override // androidx.fragment.app.u
        public void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            p.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.u, androidx.fragment.app.r
        public View onFindViewById(int i10) {
            return p.this.findViewById(i10);
        }

        @Override // androidx.fragment.app.u
        public LayoutInflater onGetLayoutInflater() {
            p pVar = p.this;
            return pVar.getLayoutInflater().cloneInContext(pVar);
        }

        @Override // androidx.fragment.app.u, androidx.fragment.app.r
        public boolean onHasView() {
            Window window = p.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.fragment.app.u
        public void onSupportInvalidateOptionsMenu() {
            invalidateMenu();
        }

        @Override // x0.l
        public void removeMenuProvider(x0.o oVar) {
            p.this.removeMenuProvider(oVar);
        }

        @Override // m0.b
        public void removeOnConfigurationChangedListener(w0.a<Configuration> aVar) {
            p.this.removeOnConfigurationChangedListener(aVar);
        }

        @Override // l0.u
        public void removeOnMultiWindowModeChangedListener(w0.a<l0.l> aVar) {
            p.this.removeOnMultiWindowModeChangedListener(aVar);
        }

        @Override // l0.v
        public void removeOnPictureInPictureModeChangedListener(w0.a<l0.x> aVar) {
            p.this.removeOnPictureInPictureModeChangedListener(aVar);
        }

        @Override // m0.c
        public void removeOnTrimMemoryListener(w0.a<Integer> aVar) {
            p.this.removeOnTrimMemoryListener(aVar);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.fragment.app.u
        public p onGetHost() {
            return p.this;
        }
    }

    public p() {
        final int i10 = 1;
        getSavedStateRegistry().registerSavedStateProvider("android:support:lifecycle", new androidx.activity.f(this, i10));
        final int i11 = 0;
        addOnConfigurationChangedListener(new w0.a(this) { // from class: androidx.fragment.app.o

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ p f2902b;

            {
                this.f2902b = this;
            }

            @Override // w0.a
            public final void accept(Object obj) {
                int i12 = i11;
                p pVar = this.f2902b;
                switch (i12) {
                    case 0:
                        pVar.C.noteStateNotSaved();
                        break;
                    default:
                        pVar.C.noteStateNotSaved();
                        break;
                }
            }
        });
        addOnNewIntentListener(new w0.a(this) { // from class: androidx.fragment.app.o

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ p f2902b;

            {
                this.f2902b = this;
            }

            @Override // w0.a
            public final void accept(Object obj) {
                int i12 = i10;
                p pVar = this.f2902b;
                switch (i12) {
                    case 0:
                        pVar.C.noteStateNotSaved();
                        break;
                    default:
                        pVar.C.noteStateNotSaved();
                        break;
                }
            }
        });
        addOnContextAvailableListener(new androidx.activity.g(this, i10));
    }

    public static boolean b(y yVar) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        boolean zB = false;
        for (Fragment fragment : yVar.getFragments()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    zB |= b(fragment.getChildFragmentManager());
                }
                l0 l0Var = fragment.f2670b0;
                Lifecycle.State state2 = Lifecycle.State.STARTED;
                if (l0Var != null && l0Var.getLifecycle().getCurrentState().isAtLeast(state2)) {
                    fragment.f2670b0.f2867n.setCurrentState(state);
                    zB = true;
                }
                if (fragment.f2668a0.getCurrentState().isAtLeast(state2)) {
                    fragment.f2668a0.setCurrentState(state);
                    zB = true;
                }
            }
        }
        return zB;
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (shouldDumpInternalState(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.E);
            printWriter.print(" mResumed=");
            printWriter.print(this.F);
            printWriter.print(" mStopped=");
            printWriter.print(this.G);
            if (getApplication() != null) {
                v1.a.getInstance(this).dump(str2, fileDescriptor, printWriter, strArr);
            }
            this.C.getSupportFragmentManager().dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public y getSupportFragmentManager() {
        return this.C.getSupportFragmentManager();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        this.C.noteStateNotSaved();
        super.onActivityResult(i10, i11, intent);
    }

    @Override // androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.D.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.C.dispatchCreate();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = this.C.onCreateView(view, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.C.dispatchDestroy();
        this.D.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 6) {
            return this.C.dispatchContextItemSelected(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.F = false;
        this.C.dispatchPause();
        this.D.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        this.C.noteStateNotSaved();
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        s sVar = this.C;
        sVar.noteStateNotSaved();
        super.onResume();
        this.F = true;
        sVar.execPendingActions();
    }

    public void onResumeFragments() {
        this.D.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.C.dispatchResume();
    }

    @Override // android.app.Activity
    public void onStart() {
        s sVar = this.C;
        sVar.noteStateNotSaved();
        super.onStart();
        this.G = false;
        if (!this.E) {
            this.E = true;
            sVar.dispatchActivityCreated();
        }
        sVar.execPendingActions();
        this.D.handleLifecycleEvent(Lifecycle.Event.ON_START);
        sVar.dispatchStart();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.C.noteStateNotSaved();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.G = true;
        while (b(getSupportFragmentManager())) {
        }
        this.C.dispatchStop();
        this.D.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = this.C.onCreateView(null, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewOnCreateView;
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // l0.a.f
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i10) {
    }
}
