package okhttp3.internal.io;

import ah.m;
import ah.n;
import ah.w;
import ah.y;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import zf.i;

/* compiled from: FileSystem.kt */
/* loaded from: classes2.dex */
public interface FileSystem {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final FileSystem SYSTEM = new Companion.SystemFileSystem();

    /* compiled from: FileSystem.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* compiled from: FileSystem.kt */
        public static final class SystemFileSystem implements FileSystem {
            @Override // okhttp3.internal.io.FileSystem
            public w appendingSink(File file) throws FileNotFoundException {
                i.checkNotNullParameter(file, "file");
                try {
                    return m.appendingSink(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return m.appendingSink(file);
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public void delete(File file) throws IOException {
                i.checkNotNullParameter(file, "file");
                if (!file.delete() && file.exists()) {
                    throw new IOException(i.stringPlus("failed to delete ", file));
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public void deleteContents(File file) throws IOException {
                i.checkNotNullParameter(file, "directory");
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles == null) {
                    throw new IOException(i.stringPlus("not a readable directory: ", file));
                }
                int length = fileArrListFiles.length;
                int i10 = 0;
                while (i10 < length) {
                    File file2 = fileArrListFiles[i10];
                    i10++;
                    if (file2.isDirectory()) {
                        i.checkNotNullExpressionValue(file2, "file");
                        deleteContents(file2);
                    }
                    if (!file2.delete()) {
                        throw new IOException(i.stringPlus("failed to delete ", file2));
                    }
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public boolean exists(File file) {
                i.checkNotNullParameter(file, "file");
                return file.exists();
            }

            @Override // okhttp3.internal.io.FileSystem
            public void rename(File file, File file2) throws IOException {
                i.checkNotNullParameter(file, "from");
                i.checkNotNullParameter(file2, "to");
                delete(file2);
                if (file.renameTo(file2)) {
                    return;
                }
                throw new IOException("failed to rename " + file + " to " + file2);
            }

            @Override // okhttp3.internal.io.FileSystem
            public w sink(File file) throws FileNotFoundException {
                i.checkNotNullParameter(file, "file");
                try {
                    return n.sink$default(file, false, 1, null);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return n.sink$default(file, false, 1, null);
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public long size(File file) {
                i.checkNotNullParameter(file, "file");
                return file.length();
            }

            @Override // okhttp3.internal.io.FileSystem
            public y source(File file) throws FileNotFoundException {
                i.checkNotNullParameter(file, "file");
                return m.source(file);
            }

            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private Companion() {
        }
    }

    w appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    w sink(File file) throws FileNotFoundException;

    long size(File file);

    y source(File file) throws FileNotFoundException;
}
