package r4;

import android.content.Context;
import com.google.auto.value.AutoValue;

/* compiled from: CreationContext.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class f {
    public static f create(Context context, a5.a aVar, a5.a aVar2, String str) {
        return new b(context, aVar, aVar2, str);
    }

    public abstract Context getApplicationContext();

    public abstract String getBackendName();

    public abstract a5.a getMonotonicClock();

    public abstract a5.a getWallClock();
}
