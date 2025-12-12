package a2;

import android.os.Build;
import android.os.Bundle;

/* compiled from: MediaRouterParams.java */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final int f241a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f242b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f243c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f244d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f245e = Bundle.EMPTY;

    /* compiled from: MediaRouterParams.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f246a = 1;

        /* renamed from: b, reason: collision with root package name */
        public boolean f247b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f248c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f249d;

        public a() {
            this.f247b = Build.VERSION.SDK_INT >= 30;
        }

        public u build() {
            return new u(this);
        }

        public a setMediaTransferReceiverEnabled(boolean z10) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f247b = z10;
            }
            return this;
        }

        public a setOutputSwitcherEnabled(boolean z10) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f248c = z10;
            }
            return this;
        }

        public a setTransferToLocalEnabled(boolean z10) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f249d = z10;
            }
            return this;
        }
    }

    public u(a aVar) {
        this.f241a = aVar.f246a;
        this.f242b = aVar.f247b;
        this.f243c = aVar.f248c;
        this.f244d = aVar.f249d;
    }

    public int getDialogType() {
        return this.f241a;
    }

    public Bundle getExtras() {
        return this.f245e;
    }

    public boolean isMediaTransferReceiverEnabled() {
        return this.f242b;
    }

    public boolean isOutputSwitcherEnabled() {
        return this.f243c;
    }

    public boolean isTransferToLocalEnabled() {
        return this.f244d;
    }
}
