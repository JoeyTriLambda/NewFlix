package androidx.work;

import android.content.Context;
import androidx.work.a;
import java.util.Collections;
import java.util.List;
import w2.g;
import w2.n;

/* loaded from: classes.dex */
public final class WorkManagerInitializer implements n2.a<n> {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4482a = g.tagWithPrefix("WrkMgrInitializer");

    @Override // n2.a
    public List<Class<? extends n2.a<?>>> dependencies() {
        return Collections.emptyList();
    }

    @Override // n2.a
    public n create(Context context) {
        g.get().debug(f4482a, "Initializing WorkManager with default configuration.");
        n.initialize(context, new a.C0047a().build());
        return n.getInstance(context);
    }
}
