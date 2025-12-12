package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import k6.d;
import k6.f;
import k6.h;
import k6.n;

/* loaded from: classes.dex */
public final class ContentDataSource implements d {

    /* renamed from: a, reason: collision with root package name */
    public final ContentResolver f6015a;

    /* renamed from: b, reason: collision with root package name */
    public final n<? super ContentDataSource> f6016b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f6017c;

    /* renamed from: d, reason: collision with root package name */
    public AssetFileDescriptor f6018d;

    /* renamed from: e, reason: collision with root package name */
    public FileInputStream f6019e;

    /* renamed from: f, reason: collision with root package name */
    public long f6020f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6021g;

    public static class ContentDataSourceException extends IOException {
        public ContentDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public ContentDataSource(Context context, n<? super ContentDataSource> nVar) {
        this.f6015a = context.getContentResolver();
        this.f6016b = nVar;
    }

    @Override // k6.d
    public void close() throws ContentDataSourceException {
        n<? super ContentDataSource> nVar = this.f6016b;
        this.f6017c = null;
        try {
            try {
                FileInputStream fileInputStream = this.f6019e;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f6019e = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f6018d;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } finally {
                        this.f6018d = null;
                        if (this.f6021g) {
                            this.f6021g = false;
                            if (nVar != null) {
                                ((h) nVar).onTransferEnd(this);
                            }
                        }
                    }
                } catch (IOException e10) {
                    throw new ContentDataSourceException(e10);
                }
            } catch (IOException e11) {
                throw new ContentDataSourceException(e11);
            }
        } catch (Throwable th2) {
            this.f6019e = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f6018d;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f6018d = null;
                    if (this.f6021g) {
                        this.f6021g = false;
                        if (nVar != null) {
                            ((h) nVar).onTransferEnd(this);
                        }
                    }
                    throw th2;
                } catch (IOException e12) {
                    throw new ContentDataSourceException(e12);
                }
            } finally {
                this.f6018d = null;
                if (this.f6021g) {
                    this.f6021g = false;
                    if (nVar != null) {
                        ((h) nVar).onTransferEnd(this);
                    }
                }
            }
        }
    }

    @Override // k6.d
    public Uri getUri() {
        return this.f6017c;
    }

    @Override // k6.d
    public long open(f fVar) throws ContentDataSourceException, EOFException, FileNotFoundException {
        try {
            Uri uri = fVar.f14959a;
            long j10 = fVar.f14962d;
            this.f6017c = uri;
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.f6015a.openAssetFileDescriptor(uri, "r");
            this.f6018d = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + this.f6017c);
            }
            this.f6019e = new FileInputStream(this.f6018d.getFileDescriptor());
            long startOffset = this.f6018d.getStartOffset();
            long jSkip = this.f6019e.skip(startOffset + j10) - startOffset;
            if (jSkip != j10) {
                throw new EOFException();
            }
            long j11 = fVar.f14963e;
            if (j11 != -1) {
                this.f6020f = j11;
            } else {
                long length = this.f6018d.getLength();
                if (length == -1) {
                    long jAvailable = this.f6019e.available();
                    this.f6020f = jAvailable;
                    if (jAvailable == 0) {
                        this.f6020f = -1L;
                    }
                } else {
                    this.f6020f = length - jSkip;
                }
            }
            this.f6021g = true;
            n<? super ContentDataSource> nVar = this.f6016b;
            if (nVar != null) {
                ((h) nVar).onTransferStart(this, fVar);
            }
            return this.f6020f;
        } catch (IOException e10) {
            throw new ContentDataSourceException(e10);
        }
    }

    @Override // k6.d
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f6020f;
        if (j10 == 0) {
            return -1;
        }
        if (j10 != -1) {
            try {
                i11 = (int) Math.min(j10, i11);
            } catch (IOException e10) {
                throw new ContentDataSourceException(e10);
            }
        }
        int i12 = this.f6019e.read(bArr, i10, i11);
        if (i12 == -1) {
            if (this.f6020f == -1) {
                return -1;
            }
            throw new ContentDataSourceException(new EOFException());
        }
        long j11 = this.f6020f;
        if (j11 != -1) {
            this.f6020f = j11 - i12;
        }
        n<? super ContentDataSource> nVar = this.f6016b;
        if (nVar != null) {
            ((h) nVar).onBytesTransferred(this, i12);
        }
        return i12;
    }
}
