package a8;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.View;
import com.google.android.youtube.player.internal.k;
import com.google.android.youtube.player.internal.q;

/* loaded from: classes.dex */
public final class e implements com.google.android.youtube.player.b {

    /* renamed from: a, reason: collision with root package name */
    public final b f379a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.youtube.player.internal.d f380b;

    public e(b bVar, com.google.android.youtube.player.internal.d dVar) {
        this.f379a = (b) a.a(bVar, "connectionClient cannot be null");
        this.f380b = (com.google.android.youtube.player.internal.d) a.a(dVar, "embeddedPlayer cannot be null");
    }

    public final View a() {
        try {
            return (View) k.a(this.f380b.s());
        } catch (RemoteException e10) {
            throw new q(e10);
        }
    }

    public final void b() {
        try {
            this.f380b.m();
        } catch (RemoteException e10) {
            throw new q(e10);
        }
    }

    public final void c() {
        try {
            this.f380b.n();
        } catch (RemoteException e10) {
            throw new q(e10);
        }
    }

    public final void d() {
        try {
            this.f380b.o();
        } catch (RemoteException e10) {
            throw new q(e10);
        }
    }

    public final void e() {
        try {
            this.f380b.p();
        } catch (RemoteException e10) {
            throw new q(e10);
        }
    }

    public final void f() {
        try {
            this.f380b.q();
        } catch (RemoteException e10) {
            throw new q(e10);
        }
    }

    public final void g() {
        try {
            this.f380b.l();
        } catch (RemoteException e10) {
            throw new q(e10);
        }
    }

    public final Bundle h() {
        try {
            return this.f380b.r();
        } catch (RemoteException e10) {
            throw new q(e10);
        }
    }

    public final void loadVideo(String str) {
        loadVideo(str, 0);
    }

    public final void setFullscreen(boolean z10) {
        try {
            this.f380b.b(z10);
        } catch (RemoteException e10) {
            throw new q(e10);
        }
    }

    public final void a(Configuration configuration) {
        try {
            this.f380b.a(configuration);
        } catch (RemoteException e10) {
            throw new q(e10);
        }
    }

    public final void b(boolean z10) {
        try {
            this.f380b.e(z10);
        } catch (RemoteException e10) {
            throw new q(e10);
        }
    }

    public final void loadVideo(String str, int i10) {
        try {
            this.f380b.b(str, i10);
        } catch (RemoteException e10) {
            throw new q(e10);
        }
    }

    public final void a(boolean z10) {
        b bVar = this.f379a;
        try {
            this.f380b.a(z10);
            bVar.a(z10);
            bVar.d();
        } catch (RemoteException e10) {
            throw new q(e10);
        }
    }

    public final boolean b(int i10, KeyEvent keyEvent) {
        try {
            return this.f380b.b(i10, keyEvent);
        } catch (RemoteException e10) {
            throw new q(e10);
        }
    }

    public final boolean a(int i10, KeyEvent keyEvent) {
        try {
            return this.f380b.a(i10, keyEvent);
        } catch (RemoteException e10) {
            throw new q(e10);
        }
    }

    public final boolean a(Bundle bundle) {
        try {
            return this.f380b.a(bundle);
        } catch (RemoteException e10) {
            throw new q(e10);
        }
    }
}
