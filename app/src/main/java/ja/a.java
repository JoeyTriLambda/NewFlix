package ja;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.lang3.StringUtils;
import zf.i;

/* compiled from: FileUtils.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f14682a = new a();

    public final String toString(File file) throws IOException {
        i.checkNotNullParameter(file, "file");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                String string = sb2.toString();
                i.checkNotNullExpressionValue(string, "toString(...)");
                fileInputStream.close();
                return string;
            }
            sb2.append(line);
            sb2.append(StringUtils.LF);
        }
    }
}
