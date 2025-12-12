package s8;

import java.io.IOException;
import java.io.InputStream;
import s8.h;

/* compiled from: QueueFileLogStore.java */
/* loaded from: classes.dex */
public final class i implements h.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ byte[] f19154a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int[] f19155b;

    public i(byte[] bArr, int[] iArr) {
        this.f19154a = bArr;
        this.f19155b = iArr;
    }

    @Override // s8.h.d
    public void read(InputStream inputStream, int i10) throws IOException {
        int[] iArr = this.f19155b;
        try {
            inputStream.read(this.f19154a, iArr[0], i10);
            iArr[0] = iArr[0] + i10;
        } finally {
            inputStream.close();
        }
    }
}
