package r;

import android.content.Context;

/* compiled from: AppCompatActivity.java */
/* loaded from: classes.dex */
public final class i implements p.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f18245a;

    public i(j jVar) {
        this.f18245a = jVar;
    }

    @Override // p.b
    public void onContextAvailable(Context context) {
        j jVar = this.f18245a;
        m delegate = jVar.getDelegate();
        delegate.installViewFactory();
        delegate.onCreate(jVar.getSavedStateRegistry().consumeRestoredStateForKey("androidx:appcompat"));
    }
}
