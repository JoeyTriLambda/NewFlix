package f3;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: WorkTagDao.kt */
/* loaded from: classes.dex */
public interface y {

    /* compiled from: WorkTagDao.kt */
    public static final class a {
        public static void insertTags(y yVar, String str, Set<String> set) {
            zf.i.checkNotNullParameter(str, "id");
            zf.i.checkNotNullParameter(set, "tags");
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                yVar.insert(new x((String) it.next(), str));
            }
        }
    }

    void deleteByWorkSpecId(String str);

    List<String> getTagsForWorkSpecId(String str);

    void insert(x xVar);

    void insertTags(String str, Set<String> set);
}
