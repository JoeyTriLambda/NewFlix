package c3;

import android.os.Build;
import androidx.work.NetworkType;
import f3.t;
import zf.i;

/* compiled from: ContraintControllers.kt */
/* loaded from: classes.dex */
public final class g extends c<b3.b> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d3.g<b3.b> gVar) {
        super(gVar);
        i.checkNotNullParameter(gVar, "tracker");
    }

    @Override // c3.c
    public boolean hasConstraint(t tVar) {
        i.checkNotNullParameter(tVar, "workSpec");
        NetworkType requiredNetworkType = tVar.f11435j.getRequiredNetworkType();
        return requiredNetworkType == NetworkType.UNMETERED || (Build.VERSION.SDK_INT >= 30 && requiredNetworkType == NetworkType.TEMPORARILY_UNMETERED);
    }

    @Override // c3.c
    public boolean isConstrained(b3.b bVar) {
        i.checkNotNullParameter(bVar, "value");
        return !bVar.isConnected() || bVar.isMetered();
    }
}
