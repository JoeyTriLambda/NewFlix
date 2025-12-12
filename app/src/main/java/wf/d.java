package wf;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import zf.i;

/* compiled from: ReadWrite.kt */
/* loaded from: classes2.dex */
public final class d {
    public static final long copyTo(Reader reader, Writer writer, int i10) throws IOException {
        i.checkNotNullParameter(reader, "<this>");
        i.checkNotNullParameter(writer, "out");
        char[] cArr = new char[i10];
        int i11 = reader.read(cArr);
        long j10 = 0;
        while (i11 >= 0) {
            writer.write(cArr, 0, i11);
            j10 += i11;
            i11 = reader.read(cArr);
        }
        return j10;
    }

    public static /* synthetic */ long copyTo$default(Reader reader, Writer writer, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        return copyTo(reader, writer, i10);
    }

    public static final String readText(Reader reader) {
        i.checkNotNullParameter(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        copyTo$default(reader, stringWriter, 0, 2, null);
        String string = stringWriter.toString();
        i.checkNotNullExpressionValue(string, "buffer.toString()");
        return string;
    }
}
