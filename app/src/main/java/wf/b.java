package wf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import zf.i;

/* compiled from: FileReadWrite.kt */
/* loaded from: classes2.dex */
public class b {
    public static final String readText(File file, Charset charset) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(file, "<this>");
        i.checkNotNullParameter(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String text = d.readText(inputStreamReader);
            a.closeFinally(inputStreamReader, null);
            return text;
        } finally {
        }
    }

    public static /* synthetic */ String readText$default(File file, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = ig.c.f13440b;
        }
        return readText(file, charset);
    }
}
