package s7;

import com.google.android.material.snackbar.BaseTransientBottomBar;

/* compiled from: BaseTransientBottomBar.java */
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f19117b;

    public d(BaseTransientBottomBar baseTransientBottomBar) {
        this.f19117b = baseTransientBottomBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f19117b.a();
    }
}
