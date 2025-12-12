package okhttp3.internal.cache2;

import ah.c;
import java.io.IOException;
import java.nio.channels.FileChannel;
import zf.i;

/* compiled from: FileOperator.kt */
/* loaded from: classes2.dex */
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel) {
        i.checkNotNullParameter(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    public final void read(long j10, c cVar, long j11) throws IOException {
        i.checkNotNullParameter(cVar, "sink");
        if (j11 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j11 > 0) {
            long jTransferTo = this.fileChannel.transferTo(j10, j11, cVar);
            j10 += jTransferTo;
            j11 -= jTransferTo;
        }
    }

    public final void write(long j10, c cVar, long j11) throws IOException {
        i.checkNotNullParameter(cVar, "source");
        if (j11 < 0 || j11 > cVar.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j12 = j10;
        long j13 = j11;
        while (j13 > 0) {
            long jTransferFrom = this.fileChannel.transferFrom(cVar, j12, j13);
            j12 += jTransferFrom;
            j13 -= jTransferFrom;
        }
    }
}
