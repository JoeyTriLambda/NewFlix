package k1;

import android.content.Context;
import com.unity3d.ads.metadata.MediationMetaData;
import java.io.File;
import zf.i;

/* compiled from: PreferenceDataStoreFile.kt */
/* loaded from: classes.dex */
public final class a {
    public static final File preferencesDataStoreFile(Context context, String str) {
        i.checkNotNullParameter(context, "<this>");
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        return h1.a.dataStoreFile(context, i.stringPlus(str, ".preferences_pb"));
    }
}
