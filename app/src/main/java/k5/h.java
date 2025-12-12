package k5;

import android.util.Log;
import android.util.Pair;
import java.nio.ByteBuffer;
import java.util.UUID;

/* compiled from: PsshAtomUtil.java */
/* loaded from: classes.dex */
public final class h {
    public static Pair<UUID, byte[]> a(byte[] bArr) {
        l6.l lVar = new l6.l(bArr);
        if (lVar.limit() < 32) {
            return null;
        }
        lVar.setPosition(0);
        if (lVar.readInt() != lVar.bytesLeft() + 4 || lVar.readInt() != a.V) {
            return null;
        }
        int fullAtomVersion = a.parseFullAtomVersion(lVar.readInt());
        if (fullAtomVersion > 1) {
            o1.a.o("Unsupported pssh version: ", fullAtomVersion, "PsshAtomUtil");
            return null;
        }
        UUID uuid = new UUID(lVar.readLong(), lVar.readLong());
        if (fullAtomVersion == 1) {
            lVar.skipBytes(lVar.readUnsignedIntToInt() * 16);
        }
        int unsignedIntToInt = lVar.readUnsignedIntToInt();
        if (unsignedIntToInt != lVar.bytesLeft()) {
            return null;
        }
        byte[] bArr2 = new byte[unsignedIntToInt];
        lVar.readBytes(bArr2, 0, unsignedIntToInt);
        return Pair.create(uuid, bArr2);
    }

    public static byte[] buildPsshAtom(UUID uuid, byte[] bArr) {
        int length = bArr.length + 32;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length);
        byteBufferAllocate.putInt(a.V);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putLong(uuid.getMostSignificantBits());
        byteBufferAllocate.putLong(uuid.getLeastSignificantBits());
        byteBufferAllocate.putInt(bArr.length);
        byteBufferAllocate.put(bArr);
        return byteBufferAllocate.array();
    }

    public static byte[] parseSchemeSpecificData(byte[] bArr, UUID uuid) {
        Pair<UUID, byte[]> pairA = a(bArr);
        if (pairA == null) {
            return null;
        }
        if (uuid == null || uuid.equals(pairA.first)) {
            return (byte[]) pairA.second;
        }
        Log.w("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + pairA.first + ".");
        return null;
    }

    public static UUID parseUuid(byte[] bArr) {
        Pair<UUID, byte[]> pairA = a(bArr);
        if (pairA == null) {
            return null;
        }
        return (UUID) pairA.first;
    }
}
