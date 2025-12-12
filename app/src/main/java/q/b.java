package q;

import android.content.Context;
import android.content.Intent;
import fg.h;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import lf.g;
import mf.q;
import mf.x;
import q.a;
import zf.f;
import zf.i;

/* compiled from: ActivityResultContracts.kt */
/* loaded from: classes.dex */
public final class b extends q.a<String[], Map<String, Boolean>> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f17774a = new a(null);

    /* compiled from: ActivityResultContracts.kt */
    public static final class a {
        public a(f fVar) {
        }

        public final Intent createIntent$activity_release(String[] strArr) {
            i.checkNotNullParameter(strArr, "input");
            Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
            i.checkNotNullExpressionValue(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return intentPutExtra;
        }
    }

    @Override // q.a
    public Intent createIntent(Context context, String[] strArr) {
        i.checkNotNullParameter(context, "context");
        i.checkNotNullParameter(strArr, "input");
        return f17774a.createIntent$activity_release(strArr);
    }

    @Override // q.a
    public a.C0227a<Map<String, Boolean>> getSynchronousResult(Context context, String[] strArr) {
        i.checkNotNullParameter(context, "context");
        i.checkNotNullParameter(strArr, "input");
        boolean z10 = true;
        if (strArr.length == 0) {
            return new a.C0227a<>(kotlin.collections.a.emptyMap());
        }
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            if (!(m0.a.checkSelfPermission(context, strArr[i10]) == 0)) {
                z10 = false;
                break;
            }
            i10++;
        }
        if (!z10) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(h.coerceAtLeast(x.mapCapacity(strArr.length), 16));
        for (String str : strArr) {
            Pair pair = g.to(str, Boolean.TRUE);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return new a.C0227a<>(linkedHashMap);
    }

    @Override // q.a
    public Map<String, Boolean> parseResult(int i10, Intent intent) {
        if (i10 != -1) {
            return kotlin.collections.a.emptyMap();
        }
        if (intent == null) {
            return kotlin.collections.a.emptyMap();
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra == null || stringArrayExtra == null) {
            return kotlin.collections.a.emptyMap();
        }
        ArrayList arrayList = new ArrayList(intArrayExtra.length);
        for (int i11 : intArrayExtra) {
            arrayList.add(Boolean.valueOf(i11 == 0));
        }
        return kotlin.collections.a.toMap(q.zip(mf.i.filterNotNull(stringArrayExtra), arrayList));
    }
}
