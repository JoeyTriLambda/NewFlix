package r5;

import java.nio.ByteBuffer;
import java.util.Arrays;
import l6.l;
import q5.d;

/* compiled from: EventMessageDecoder.java */
/* loaded from: classes.dex */
public final class b implements q5.b {
    @Override // q5.b
    public q5.a decode(d dVar) {
        ByteBuffer byteBuffer = dVar.f11142n;
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        l lVar = new l(bArrArray, iLimit);
        String nullTerminatedString = lVar.readNullTerminatedString();
        String nullTerminatedString2 = lVar.readNullTerminatedString();
        long unsignedInt = lVar.readUnsignedInt();
        lVar.skipBytes(4);
        return new q5.a(new a(nullTerminatedString, nullTerminatedString2, (lVar.readUnsignedInt() * 1000) / unsignedInt, lVar.readUnsignedInt(), Arrays.copyOfRange(bArrArray, lVar.getPosition(), iLimit)));
    }
}
