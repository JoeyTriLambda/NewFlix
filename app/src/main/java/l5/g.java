package l5;

import com.android.volley.DefaultRetryPolicy;
import com.loopj.android.http.AsyncHttpClient;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import l5.h;
import l6.l;
import l6.u;

/* compiled from: OpusReader.java */
/* loaded from: classes.dex */
public final class g extends h {

    /* renamed from: o, reason: collision with root package name */
    public static final int f15807o = u.getIntegerCodeForString("Opus");

    /* renamed from: p, reason: collision with root package name */
    public static final byte[] f15808p = {79, 112, 117, 115, 72, 101, 97, 100};

    /* renamed from: n, reason: collision with root package name */
    public boolean f15809n;

    public static void a(int i10, ArrayList arrayList) {
        arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((i10 * 1000000000) / 48000).array());
    }

    public static boolean verifyBitstreamType(l lVar) {
        int iBytesLeft = lVar.bytesLeft();
        byte[] bArr = f15808p;
        if (iBytesLeft < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        lVar.readBytes(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // l5.h
    public long preparePayload(l lVar) {
        int i10;
        byte[] bArr = lVar.f15881a;
        int i11 = bArr[0] & 255;
        int i12 = i11 & 3;
        if (i12 != 0) {
            i10 = 2;
            if (i12 != 1 && i12 != 2) {
                i10 = bArr[1] & 63;
            }
        } else {
            i10 = 1;
        }
        int i13 = i11 >> 3;
        return convertTimeToGranule(i10 * (i13 >= 16 ? DefaultRetryPolicy.DEFAULT_TIMEOUT_MS << r1 : i13 >= 12 ? AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT << (r1 & 1) : (i13 & 3) == 3 ? 60000 : AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT << r1));
    }

    @Override // l5.h
    public boolean readHeaders(l lVar, long j10, h.a aVar) throws InterruptedException, IOException {
        if (this.f15809n) {
            boolean z10 = lVar.readInt() == f15807o;
            lVar.setPosition(0);
            return z10;
        }
        byte[] bArrCopyOf = Arrays.copyOf(lVar.f15881a, lVar.limit());
        int i10 = bArrCopyOf[9] & 255;
        int i11 = ((bArrCopyOf[11] & 255) << 8) | (bArrCopyOf[10] & 255);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArrCopyOf);
        a(i11, arrayList);
        a(3840, arrayList);
        aVar.f15823a = c5.i.createAudioSampleFormat(null, "audio/opus", null, -1, -1, i10, 48000, arrayList, null, 0, null);
        this.f15809n = true;
        return true;
    }

    @Override // l5.h
    public void reset(boolean z10) {
        super.reset(z10);
        if (z10) {
            this.f15809n = false;
        }
    }
}
