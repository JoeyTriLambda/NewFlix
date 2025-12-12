package c3;

import android.os.Build;
import androidx.work.NetworkType;
import f3.t;
import zf.i;

/* compiled from: ContraintControllers.kt */
/* loaded from: classes.dex */
public final class f extends c<b3.b> {

    /* renamed from: f, reason: collision with root package name */
    public static final String f5021f;

    /* compiled from: ContraintControllers.kt */
    public static final class a {
        public a(zf.f fVar) {
        }
    }

    static {
        new a(null);
        String strTagWithPrefix = w2.g.tagWithPrefix("NetworkNotRoamingCtrlr");
        i.checkNotNullExpressionValue(strTagWithPrefix, "tagWithPrefix(\"NetworkNotRoamingCtrlr\")");
        f5021f = strTagWithPrefix;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d3.g<b3.b> gVar) {
        super(gVar);
        i.checkNotNullParameter(gVar, "tracker");
    }

    @Override // c3.c
    public boolean hasConstraint(t tVar) {
        i.checkNotNullParameter(tVar, "workSpec");
        return tVar.f11435j.getRequiredNetworkType() == NetworkType.NOT_ROAMING;
    }

    @Override // c3.c
    public boolean isConstrained(b3.b bVar) {
        i.checkNotNullParameter(bVar, "value");
        if (Build.VERSION.SDK_INT < 24) {
            w2.g.get().debug(f5021f, "Not-roaming network constraint is not supported before API 24, only checking for connected state.");
            if (bVar.isConnected()) {
                return false;
            }
        } else if (bVar.isConnected() && bVar.isNotRoaming()) {
            return false;
        }
        return true;
    }
}
