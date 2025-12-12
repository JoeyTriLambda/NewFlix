package lg;

import android.os.Looper;
import java.util.List;
import kg.w1;
import kotlinx.coroutines.android.HandlerContext;
import pg.q;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes2.dex */
public final class a implements q {
    @Override // pg.q
    public w1 createDispatcher(List<? extends q> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            throw new IllegalStateException("The main looper is not available");
        }
        return new HandlerContext(e.asHandler(mainLooper, true), null, 2, 0 == true ? 1 : 0);
    }

    @Override // pg.q
    public int getLoadPriority() {
        return 1073741823;
    }

    @Override // pg.q
    public String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }
}
