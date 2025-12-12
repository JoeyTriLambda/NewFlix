package ah;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: JvmOkio.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class n {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f704a = Logger.getLogger("okio.Okio");

    public static final w appendingSink(File file) throws FileNotFoundException {
        zf.i.checkNotNullParameter(file, "<this>");
        return m.sink(new FileOutputStream(file, true));
    }

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        zf.i.checkNotNullParameter(assertionError, "<this>");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message == null ? false : StringsKt__StringsKt.contains$default((CharSequence) message, (CharSequence) "getsockname failed", false, 2, (Object) null);
    }

    public static final w sink(OutputStream outputStream) {
        zf.i.checkNotNullParameter(outputStream, "<this>");
        return new q(outputStream, new z());
    }

    public static /* synthetic */ w sink$default(File file, boolean z10, int i10, Object obj) throws FileNotFoundException {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return m.sink(file, z10);
    }

    public static final y source(InputStream inputStream) {
        zf.i.checkNotNullParameter(inputStream, "<this>");
        return new l(inputStream, new z());
    }

    public static final w sink(Socket socket) throws IOException {
        zf.i.checkNotNullParameter(socket, "<this>");
        x xVar = new x(socket);
        OutputStream outputStream = socket.getOutputStream();
        zf.i.checkNotNullExpressionValue(outputStream, "getOutputStream()");
        return xVar.sink(new q(outputStream, xVar));
    }

    public static final y source(Socket socket) throws IOException {
        zf.i.checkNotNullParameter(socket, "<this>");
        x xVar = new x(socket);
        InputStream inputStream = socket.getInputStream();
        zf.i.checkNotNullExpressionValue(inputStream, "getInputStream()");
        return xVar.source(new l(inputStream, xVar));
    }

    public static final w sink(File file, boolean z10) throws FileNotFoundException {
        zf.i.checkNotNullParameter(file, "<this>");
        return m.sink(new FileOutputStream(file, z10));
    }

    public static final y source(File file) throws FileNotFoundException {
        zf.i.checkNotNullParameter(file, "<this>");
        return new l(new FileInputStream(file), z.NONE);
    }
}
