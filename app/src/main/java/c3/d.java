package c3;

import android.os.Build;
import androidx.work.NetworkType;
import f3.t;
import zf.i;

/* compiled from: ContraintControllers.kt */
/* loaded from: classes.dex */
public final class d extends c<b3.b> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(d3.g<b3.b> gVar) {
        super(gVar);
        i.checkNotNullParameter(gVar, "tracker");
    }

    @Override // c3.c
    public boolean hasConstraint(t tVar) {
        i.checkNotNullParameter(tVar, "workSpec");
        return tVar.f11435j.getRequiredNetworkType() == NetworkType.CONNECTED;
    }

    @Override // c3.c
    public boolean isConstrained(b3.b bVar) {
        i.checkNotNullParameter(bVar, "value");
        if (Build.VERSION.SDK_INT >= 26) {
            if (!bVar.isConnected() || !bVar.isValidated()) {
                return true;
            }
        } else if (!bVar.isConnected()) {
            return true;
        }
        return false;
    }
}
