package ah;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* loaded from: classes2.dex */
public final class m {
    public static final w appendingSink(File file) throws FileNotFoundException {
        return n.appendingSink(file);
    }

    public static final w blackhole() {
        return o.blackhole();
    }

    public static final d buffer(w wVar) {
        return o.buffer(wVar);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return n.isAndroidGetsocknameError(assertionError);
    }

    public static final w sink(File file, boolean z10) throws FileNotFoundException {
        return n.sink(file, z10);
    }

    public static final y source(File file) throws FileNotFoundException {
        return n.source(file);
    }

    public static final e buffer(y yVar) {
        return o.buffer(yVar);
    }

    public static final w sink(OutputStream outputStream) {
        return n.sink(outputStream);
    }

    public static final y source(InputStream inputStream) {
        return n.source(inputStream);
    }

    public static final w sink(Socket socket) throws IOException {
        return n.sink(socket);
    }

    public static final y source(Socket socket) throws IOException {
        return n.source(socket);
    }
}
