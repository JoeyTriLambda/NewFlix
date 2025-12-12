package c3;

import android.os.Build;
import androidx.work.NetworkType;
import f3.t;
import zf.i;

/* compiled from: ContraintControllers.kt */
/* loaded from: classes.dex */
public final class e extends c<b3.b> {

    /* renamed from: f, reason: collision with root package name */
    public static final String f5020f;

    /* compiled from: ContraintControllers.kt */
    public static final class a {
        public a(zf.f fVar) {
        }
    }

    static {
        new a(null);
        String strTagWithPrefix = w2.g.tagWithPrefix("NetworkMeteredCtrlr");
        i.checkNotNullExpressionValue(strTagWithPrefix, "tagWithPrefix(\"NetworkMeteredCtrlr\")");
        f5020f = strTagWithPrefix;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d3.g<b3.b> gVar) {
        super(gVar);
        i.checkNotNullParameter(gVar, "tracker");
    }

    @Override // c3.c
    public boolean hasConstraint(t tVar) {
        i.checkNotNullParameter(tVar, "workSpec");
        return tVar.f11435j.getRequiredNetworkType() == NetworkType.METERED;
    }

    @Override // c3.c
    public boolean isConstrained(b3.b bVar) {
        i.checkNotNullParameter(bVar, "value");
        if (Build.VERSION.SDK_INT < 26) {
            w2.g.get().debug(f5020f, "Metered network constraint is not supported before API 26, only checking for connected state.");
            if (bVar.isConnected()) {
                return false;
            }
        } else if (bVar.isConnected() && bVar.isMetered()) {
            return false;
        }
        return true;
    }
}
