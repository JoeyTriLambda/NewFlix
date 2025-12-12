package g2;

import androidx.room.RoomDatabase;
import java.util.Collections;
import java.util.IdentityHashMap;

/* compiled from: InvalidationLiveDataContainer.kt */
/* loaded from: classes.dex */
public final class i {
    public i(RoomDatabase roomDatabase) {
        zf.i.checkNotNullParameter(roomDatabase, "database");
        zf.i.checkNotNullExpressionValue(Collections.newSetFromMap(new IdentityHashMap()), "newSetFromMap(IdentityHashMap())");
    }
}
