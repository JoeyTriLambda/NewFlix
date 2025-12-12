package l0;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import x0.i;

/* compiled from: ComponentActivity.kt */
/* loaded from: classes.dex */
public class j extends Activity implements androidx.lifecycle.l, i.a {

    /* renamed from: b, reason: collision with root package name */
    public final androidx.lifecycle.m f15656b;

    public j() {
        new b0.k();
        this.f15656b = new androidx.lifecycle.m(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        zf.i.checkNotNullParameter(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        zf.i.checkNotNullExpressionValue(decorView, "window.decorView");
        if (x0.i.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        return x0.i.dispatchKeyEvent(this, decorView, this, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        zf.i.checkNotNullParameter(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        zf.i.checkNotNullExpressionValue(decorView, "window.decorView");
        if (x0.i.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public Lifecycle getLifecycle() {
        return this.f15656b;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.lifecycle.v.f3517m.injectIfNeededIn(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        zf.i.checkNotNullParameter(bundle, "outState");
        this.f15656b.setCurrentState(Lifecycle.State.CREATED);
        super.onSaveInstanceState(bundle);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:11:0x000f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean shouldDumpInternalState(java.lang.String[] r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            if (r4 == 0) goto Lf
            int r2 = r4.length
            if (r2 != 0) goto L9
            r2 = 1
            goto La
        L9:
            r2 = 0
        La:
            if (r2 == 0) goto Ld
            goto Lf
        Ld:
            r2 = 0
            goto L10
        Lf:
            r2 = 1
        L10:
            if (r2 != 0) goto L66
            r4 = r4[r1]
            int r2 = r4.hashCode()
            switch(r2) {
                case -645125871: goto L56;
                case 100470631: goto L46;
                case 472614934: goto L3d;
                case 1159329357: goto L2d;
                case 1455016274: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L66
        L1c:
            java.lang.String r2 = "--autofill"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L25
            goto L66
        L25:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r4 < r2) goto L66
        L2b:
            r1 = 1
            goto L66
        L2d:
            java.lang.String r2 = "--contentcapture"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L36
            goto L66
        L36:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            if (r4 < r2) goto L66
            goto L2b
        L3d:
            java.lang.String r2 = "--list-dumpables"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L4f
            goto L66
        L46:
            java.lang.String r2 = "--dump-dumpable"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L4f
            goto L66
        L4f:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 33
            if (r4 < r2) goto L66
            goto L2b
        L56:
            java.lang.String r2 = "--translation"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L5f
            goto L66
        L5f:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r4 < r2) goto L66
            goto L2b
        L66:
            r4 = r1 ^ 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.j.shouldDumpInternalState(java.lang.String[]):boolean");
    }

    @Override // x0.i.a
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        zf.i.checkNotNullParameter(keyEvent, "event");
        return super.dispatchKeyEvent(keyEvent);
    }
}
