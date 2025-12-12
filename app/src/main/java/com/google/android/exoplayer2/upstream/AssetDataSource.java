package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import k6.d;
import k6.f;
import k6.h;
import k6.n;

/* loaded from: classes.dex */
public final class AssetDataSource implements d {

    /* renamed from: a, reason: collision with root package name */
    public final AssetManager f6009a;

    /* renamed from: b, reason: collision with root package name */
    public final n<? super AssetDataSource> f6010b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f6011c;

    /* renamed from: d, reason: collision with root package name */
    public InputStream f6012d;

    /* renamed from: e, reason: collision with root package name */
    public long f6013e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6014f;

    public static final class AssetDataSourceException extends IOException {
        public AssetDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public AssetDataSource(Context context, n<? super AssetDataSource> nVar) {
        this.f6009a = context.getAssets();
        this.f6010b = nVar;
    }

    @Override // k6.d
    public void close() throws AssetDataSourceException {
        n<? super AssetDataSource> nVar = this.f6010b;
        this.f6011c = null;
        try {
            try {
                InputStream inputStream = this.f6012d;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e10) {
                throw new AssetDataSourceException(e10);
            }
        } finally {
            this.f6012d = null;
            if (this.f6014f) {
                this.f6014f = false;
                if (nVar != null) {
                    ((h) nVar).onTransferEnd(this);
                }
            }
        }
    }

    @Override // k6.d
    public Uri getUri() {
        return this.f6011c;
    }

    @Override // k6.d
    public long open(f fVar) throws IOException {
        try {
            Uri uri = fVar.f14959a;
            long j10 = fVar.f14962d;
            this.f6011c = uri;
            String path = uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            InputStream inputStreamOpen = this.f6009a.open(path, 1);
            this.f6012d = inputStreamOpen;
            if (inputStreamOpen.skip(j10) < j10) {
                throw new EOFException();
            }
            long j11 = fVar.f14963e;
            if (j11 != -1) {
                this.f6013e = j11;
            } else {
                long jAvailable = this.f6012d.available();
                this.f6013e = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.f6013e = -1L;
                }
            }
            this.f6014f = true;
            n<? super AssetDataSource> nVar = this.f6010b;
            if (nVar != null) {
                ((h) nVar).onTransferStart(this, fVar);
            }
            return this.f6013e;
        } catch (IOException e10) {
            throw new AssetDataSourceException(e10);
        }
    }

    @Override // k6.d
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f6013e;
        if (j10 == 0) {
            return -1;
        }
        if (j10 != -1) {
            try {
                i11 = (int) Math.min(j10, i11);
            } catch (IOException e10) {
                throw new AssetDataSourceException(e10);
            }
        }
        int i12 = this.f6012d.read(bArr, i10, i11);
        if (i12 == -1) {
            if (this.f6013e == -1) {
                return -1;
            }
            throw new AssetDataSourceException(new EOFException());
        }
        long j11 = this.f6013e;
        if (j11 != -1) {
            this.f6013e = j11 - i12;
        }
        n<? super AssetDataSource> nVar = this.f6010b;
        if (nVar != null) {
            ((h) nVar).onBytesTransferred(this, i12);
        }
        return i12;
    }
}
