package androidx.lifecycle;

import android.content.Context;
import androidx.lifecycle.u;
import java.util.List;

/* compiled from: ProcessLifecycleInitializer.kt */
/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements n2.a<l> {
    @Override // n2.a
    public List<Class<? extends n2.a<?>>> dependencies() {
        return mf.k.emptyList();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // n2.a
    public l create(Context context) {
        zf.i.checkNotNullParameter(context, "context");
        androidx.startup.a aVar = androidx.startup.a.getInstance(context);
        zf.i.checkNotNullExpressionValue(aVar, "getInstance(context)");
        if (!aVar.isEagerlyInitialized(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
        }
        i.init(context);
        u.b bVar = u.f3506t;
        bVar.init$lifecycle_process_release(context);
        return bVar.get();
    }
}
