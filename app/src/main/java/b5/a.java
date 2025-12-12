package b5;

import ac.c;
import android.util.SparseArray;
import com.google.android.datatransport.Priority;
import java.util.HashMap;

/* compiled from: PriorityMapping.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray<Priority> f4775a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap<Priority, Integer> f4776b;

    static {
        HashMap<Priority, Integer> map = new HashMap<>();
        f4776b = map;
        map.put(Priority.DEFAULT, 0);
        map.put(Priority.VERY_LOW, 1);
        map.put(Priority.HIGHEST, 2);
        for (Priority priority : map.keySet()) {
            f4775a.append(f4776b.get(priority).intValue(), priority);
        }
    }

    public static int toInt(Priority priority) {
        Integer num = f4776b.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    public static Priority valueOf(int i10) {
        Priority priority = f4775a.get(i10);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException(c.f("Unknown Priority for value ", i10));
    }
}
