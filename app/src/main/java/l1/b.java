package l1;

import androidx.datastore.preferences.core.MutablePreferences;
import java.util.Arrays;
import l1.a;
import zf.i;

/* compiled from: PreferencesFactory.kt */
/* loaded from: classes.dex */
public final class b {
    public static final a createEmpty() {
        return new MutablePreferences(null, true, 1, null);
    }

    public static final MutablePreferences createMutable(a.b<?>... bVarArr) {
        i.checkNotNullParameter(bVarArr, "pairs");
        MutablePreferences mutablePreferences = new MutablePreferences(null, false, 1, null);
        mutablePreferences.putAll((a.b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        return mutablePreferences;
    }
}
