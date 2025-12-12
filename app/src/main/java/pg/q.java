package pg;

import java.util.List;
import kg.w1;

/* compiled from: MainDispatcherFactory.kt */
/* loaded from: classes2.dex */
public interface q {
    w1 createDispatcher(List<? extends q> list);

    int getLoadPriority();

    String hintOnError();
}
