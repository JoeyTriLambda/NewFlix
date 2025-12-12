package q2;

import android.annotation.SuppressLint;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

/* compiled from: TransitionValues.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    @SuppressLint({"UnknownNullness"})
    public final View f17786b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f17785a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<androidx.transition.e> f17787c = new ArrayList<>();

    @Deprecated
    public i() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f17786b == iVar.f17786b && this.f17785a.equals(iVar.f17785a);
    }

    public int hashCode() {
        return this.f17785a.hashCode() + (this.f17786b.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sbU = ac.c.u("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        sbU.append(this.f17786b);
        sbU.append(StringUtils.LF);
        String strB = ac.c.B(sbU.toString(), "    values:");
        HashMap map = this.f17785a;
        for (String str : map.keySet()) {
            strB = strB + "    " + str + ": " + map.get(str) + StringUtils.LF;
        }
        return strB;
    }

    public i(View view) {
        this.f17786b = view;
    }
}
