package r;

import android.os.Bundle;
import androidx.savedstate.a;

/* compiled from: AppCompatActivity.java */
/* loaded from: classes.dex */
public final class h implements a.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f18244a;

    public h(j jVar) {
        this.f18244a = jVar;
    }

    @Override // androidx.savedstate.a.c
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        this.f18244a.getDelegate().onSaveInstanceState(bundle);
        return bundle;
    }
}
