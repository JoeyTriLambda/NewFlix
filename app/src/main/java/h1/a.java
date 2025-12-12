package h1;

import android.content.Context;
import java.io.File;
import zf.i;

/* compiled from: DataStoreFile.kt */
/* loaded from: classes.dex */
public final class a {
    public static final File dataStoreFile(Context context, String str) {
        i.checkNotNullParameter(context, "<this>");
        i.checkNotNullParameter(str, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), i.stringPlus("datastore/", str));
    }
}
