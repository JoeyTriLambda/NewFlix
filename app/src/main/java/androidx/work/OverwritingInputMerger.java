package androidx.work;

import androidx.work.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import w2.e;

/* loaded from: classes.dex */
public final class OverwritingInputMerger extends e {
    @Override // w2.e
    public b merge(List<b> list) {
        b.a aVar = new b.a();
        HashMap map = new HashMap();
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            map.putAll(it.next().getKeyValueMap());
        }
        aVar.putAll(map);
        return aVar.build();
    }
}
