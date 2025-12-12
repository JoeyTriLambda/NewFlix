package j3;

import ac.c;
import android.os.Build;
import f3.j;
import f3.o;
import f3.t;
import f3.w;
import f3.y;
import java.util.Iterator;
import java.util.List;
import mf.q;
import org.apache.commons.lang3.StringUtils;
import w2.g;
import zf.i;

/* compiled from: DiagnosticsWorker.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f14583a;

    static {
        String strTagWithPrefix = g.tagWithPrefix("DiagnosticsWrkr");
        i.checkNotNullExpressionValue(strTagWithPrefix, "tagWithPrefix(\"DiagnosticsWrkr\")");
        f14583a = strTagWithPrefix;
    }

    public static final String access$workSpecRows(o oVar, y yVar, j jVar, List list) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n Id \t Class Name\t " + (Build.VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id") + "\t State\t Unique Name\t Tags\t");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            f3.i systemIdInfo = jVar.getSystemIdInfo(w.generationalId(tVar));
            Integer numValueOf = systemIdInfo != null ? Integer.valueOf(systemIdInfo.f11411c) : null;
            String strJoinToString$default = q.joinToString$default(oVar.getNamesForWorkSpecId(tVar.f11426a), ",", null, null, 0, null, null, 62, null);
            String str = tVar.f11426a;
            String strJoinToString$default2 = q.joinToString$default(yVar.getTagsForWorkSpecId(str), ",", null, null, 0, null, null, 62, null);
            StringBuilder sbV = c.v(StringUtils.LF, str, "\t ");
            sbV.append(tVar.f11428c);
            sbV.append("\t ");
            sbV.append(numValueOf);
            sbV.append("\t ");
            sbV.append(tVar.f11427b.name());
            sbV.append("\t ");
            sbV.append(strJoinToString$default);
            sbV.append("\t ");
            sbV.append(strJoinToString$default2);
            sbV.append('\t');
            sb2.append(sbV.toString());
        }
        String string = sb2.toString();
        i.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
