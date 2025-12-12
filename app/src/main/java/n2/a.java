package n2;

import android.content.Context;
import java.util.List;

/* compiled from: Initializer.java */
/* loaded from: classes.dex */
public interface a<T> {
    T create(Context context);

    List<Class<? extends a<?>>> dependencies();
}
