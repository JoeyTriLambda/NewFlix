package androidx.lifecycle;

import com.unity3d.ads.metadata.MediationMetaData;
import java.util.HashMap;

/* compiled from: MethodCallsLogger.kt */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f3505a = new HashMap();

    public boolean approveCall(String str, int i10) {
        zf.i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        HashMap map = this.f3505a;
        Integer num = (Integer) map.get(str);
        int iIntValue = num != null ? num.intValue() : 0;
        boolean z10 = (iIntValue & i10) != 0;
        map.put(str, Integer.valueOf(i10 | iIntValue));
        return !z10;
    }
}
