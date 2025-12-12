package o5;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import g5.f;
import java.io.IOException;
import l6.l;
import l6.u;

/* compiled from: WavHeaderReader.java */
/* loaded from: classes.dex */
public final class c {

    /* compiled from: WavHeaderReader.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f17027a;

        /* renamed from: b, reason: collision with root package name */
        public final long f17028b;

        public a(int i10, long j10) {
            this.f17027a = i10;
            this.f17028b = j10;
        }

        public static a peek(f fVar, l lVar) throws InterruptedException, IOException {
            ((g5.b) fVar).peekFully(lVar.f15881a, 0, 8);
            lVar.setPosition(0);
            return new a(lVar.readInt(), lVar.readLittleEndianUnsignedInt());
        }
    }

    public static b peek(f fVar) throws InterruptedException, IOException {
        long j10;
        l6.a.checkNotNull(fVar);
        l lVar = new l(16);
        if (a.peek(fVar, lVar).f17027a != u.getIntegerCodeForString("RIFF")) {
            return null;
        }
        g5.b bVar = (g5.b) fVar;
        bVar.peekFully(lVar.f15881a, 0, 4);
        lVar.setPosition(0);
        int i10 = lVar.readInt();
        if (i10 != u.getIntegerCodeForString("WAVE")) {
            Log.e("WavHeaderReader", "Unsupported RIFF format: " + i10);
            return null;
        }
        a aVarPeek = a.peek(bVar, lVar);
        while (true) {
            int i11 = aVarPeek.f17027a;
            int integerCodeForString = u.getIntegerCodeForString("fmt ");
            j10 = aVarPeek.f17028b;
            if (i11 == integerCodeForString) {
                break;
            }
            bVar.advancePeekPosition((int) j10);
            aVarPeek = a.peek(bVar, lVar);
        }
        l6.a.checkState(j10 >= 16);
        bVar.peekFully(lVar.f15881a, 0, 16);
        lVar.setPosition(0);
        int littleEndianUnsignedShort = lVar.readLittleEndianUnsignedShort();
        int littleEndianUnsignedShort2 = lVar.readLittleEndianUnsignedShort();
        int littleEndianUnsignedIntToInt = lVar.readLittleEndianUnsignedIntToInt();
        int littleEndianUnsignedIntToInt2 = lVar.readLittleEndianUnsignedIntToInt();
        int littleEndianUnsignedShort3 = lVar.readLittleEndianUnsignedShort();
        int littleEndianUnsignedShort4 = lVar.readLittleEndianUnsignedShort();
        int i12 = (littleEndianUnsignedShort2 * littleEndianUnsignedShort4) / 8;
        if (littleEndianUnsignedShort3 != i12) {
            throw new ParserException(ac.c.g("Expected block alignment: ", i12, "; got: ", littleEndianUnsignedShort3));
        }
        int pcmEncoding = u.getPcmEncoding(littleEndianUnsignedShort4);
        if (pcmEncoding == 0) {
            Log.e("WavHeaderReader", "Unsupported WAV bit depth: " + littleEndianUnsignedShort4);
            return null;
        }
        if (littleEndianUnsignedShort == 1 || littleEndianUnsignedShort == 65534) {
            bVar.advancePeekPosition(((int) j10) - 16);
            return new b(littleEndianUnsignedShort2, littleEndianUnsignedIntToInt, littleEndianUnsignedIntToInt2, littleEndianUnsignedShort3, littleEndianUnsignedShort4, pcmEncoding);
        }
        Log.e("WavHeaderReader", "Unsupported WAV format type: " + littleEndianUnsignedShort);
        return null;
    }

    public static void skipToData(f fVar, b bVar) throws InterruptedException, IOException {
        l6.a.checkNotNull(fVar);
        l6.a.checkNotNull(bVar);
        g5.b bVar2 = (g5.b) fVar;
        bVar2.resetPeekPosition();
        l lVar = new l(8);
        a aVarPeek = a.peek(bVar2, lVar);
        while (true) {
            int i10 = aVarPeek.f17027a;
            int integerCodeForString = u.getIntegerCodeForString(JsonStorageKeyNames.DATA_KEY);
            long j10 = aVarPeek.f17028b;
            if (i10 == integerCodeForString) {
                bVar2.skipFully(8);
                bVar.setDataBounds(bVar2.getPosition(), j10);
                return;
            }
            StringBuilder sb2 = new StringBuilder("Ignoring unknown WAV chunk: ");
            int i11 = aVarPeek.f17027a;
            sb2.append(i11);
            Log.w("WavHeaderReader", sb2.toString());
            long j11 = j10 + 8;
            if (i11 == u.getIntegerCodeForString("RIFF")) {
                j11 = 12;
            }
            if (j11 > 2147483647L) {
                throw new ParserException("Chunk is too large (~2GB+) to skip; id: " + i11);
            }
            bVar2.skipFully((int) j11);
            aVarPeek = a.peek(bVar2, lVar);
        }
    }
}
