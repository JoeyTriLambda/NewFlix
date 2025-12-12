package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import k6.d;
import k6.f;
import k6.h;
import k6.n;

/* loaded from: classes.dex */
public final class FileDataSource implements d {

    /* renamed from: a, reason: collision with root package name */
    public final n<? super FileDataSource> f6022a;

    /* renamed from: b, reason: collision with root package name */
    public RandomAccessFile f6023b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f6024c;

    /* renamed from: d, reason: collision with root package name */
    public long f6025d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6026e;

    public static class FileDataSourceException extends IOException {
        public FileDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public FileDataSource(n<? super FileDataSource> nVar) {
        this.f6022a = nVar;
    }

    @Override // k6.d
    public void close() throws FileDataSourceException {
        n<? super FileDataSource> nVar = this.f6022a;
        this.f6024c = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f6023b;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e10) {
                throw new FileDataSourceException(e10);
            }
        } finally {
            this.f6023b = null;
            if (this.f6026e) {
                this.f6026e = false;
                if (nVar != null) {
                    ((h) nVar).onTransferEnd(this);
                }
            }
        }
    }

    @Override // k6.d
    public Uri getUri() {
        return this.f6024c;
    }

    @Override // k6.d
    public long open(f fVar) throws IOException {
        try {
            Uri uri = fVar.f14959a;
            long j10 = fVar.f14962d;
            this.f6024c = uri;
            RandomAccessFile randomAccessFile = new RandomAccessFile(fVar.f14959a.getPath(), "r");
            this.f6023b = randomAccessFile;
            randomAccessFile.seek(j10);
            long length = fVar.f14963e;
            if (length == -1) {
                length = this.f6023b.length() - j10;
            }
            this.f6025d = length;
            if (length < 0) {
                throw new EOFException();
            }
            this.f6026e = true;
            n<? super FileDataSource> nVar = this.f6022a;
            if (nVar != null) {
                ((h) nVar).onTransferStart(this, fVar);
            }
            return this.f6025d;
        } catch (IOException e10) {
            throw new FileDataSourceException(e10);
        }
    }

    @Override // k6.d
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f6025d;
        if (j10 == 0) {
            return -1;
        }
        try {
            int i12 = this.f6023b.read(bArr, i10, (int) Math.min(j10, i11));
            if (i12 > 0) {
                this.f6025d -= i12;
                n<? super FileDataSource> nVar = this.f6022a;
                if (nVar != null) {
                    ((h) nVar).onBytesTransferred(this, i12);
                }
            }
            return i12;
        } catch (IOException e10) {
            throw new FileDataSourceException(e10);
        }
    }
}
