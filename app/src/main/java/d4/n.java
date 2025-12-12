package d4;

import android.content.Context;
import d4.d;
import java.io.File;

/* compiled from: Volley.java */
/* loaded from: classes.dex */
public final class n implements d.c {

    /* renamed from: a, reason: collision with root package name */
    public File f10848a = null;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f10849b;

    public n(Context context) {
        this.f10849b = context;
    }

    public File get() {
        if (this.f10848a == null) {
            this.f10848a = new File(this.f10849b.getCacheDir(), "volley");
        }
        return this.f10848a;
    }
}
