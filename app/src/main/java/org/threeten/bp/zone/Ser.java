package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import org.threeten.bp.ZoneOffset;

/* loaded from: classes2.dex */
final class Ser implements Externalizable {
    static final byte SZR = 1;
    static final byte ZOT = 2;
    static final byte ZOTRULE = 3;
    private static final long serialVersionUID = -8885321777449118786L;
    private Object object;
    private byte type;

    public Ser() {
    }

    public static Object read(DataInput dataInput) throws IOException, ClassNotFoundException {
        return readInternal(dataInput.readByte(), dataInput);
    }

    public static long readEpochSec(DataInput dataInput) throws IOException {
        if ((dataInput.readByte() & 255) == 255) {
            return dataInput.readLong();
        }
        return ((((r0 << 16) + ((dataInput.readByte() & 255) << 8)) + (dataInput.readByte() & 255)) * 900) - 4575744000L;
    }

    private static Object readInternal(byte b10, DataInput dataInput) throws IOException, ClassNotFoundException {
        if (b10 == 1) {
            return StandardZoneRules.readExternal(dataInput);
        }
        if (b10 == 2) {
            return ZoneOffsetTransition.readExternal(dataInput);
        }
        if (b10 == 3) {
            return ZoneOffsetTransitionRule.readExternal(dataInput);
        }
        throw new StreamCorruptedException("Unknown serialized type");
    }

    public static ZoneOffset readOffset(DataInput dataInput) throws IOException {
        byte b10 = dataInput.readByte();
        return b10 == 127 ? ZoneOffset.ofTotalSeconds(dataInput.readInt()) : ZoneOffset.ofTotalSeconds(b10 * 900);
    }

    private Object readResolve() {
        return this.object;
    }

    public static void write(Object obj, DataOutput dataOutput) throws IOException {
        writeInternal(SZR, obj, dataOutput);
    }

    public static void writeEpochSec(long j10, DataOutput dataOutput) throws IOException {
        if (j10 < -4575744000L || j10 >= 10413792000L || j10 % 900 != 0) {
            dataOutput.writeByte(255);
            dataOutput.writeLong(j10);
        } else {
            int i10 = (int) ((j10 + 4575744000L) / 900);
            dataOutput.writeByte((i10 >>> 16) & 255);
            dataOutput.writeByte((i10 >>> 8) & 255);
            dataOutput.writeByte(i10 & 255);
        }
    }

    private static void writeInternal(byte b10, Object obj, DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(b10);
        if (b10 == 1) {
            ((StandardZoneRules) obj).writeExternal(dataOutput);
        } else if (b10 == 2) {
            ((ZoneOffsetTransition) obj).writeExternal(dataOutput);
        } else {
            if (b10 != 3) {
                throw new InvalidClassException("Unknown serialized type");
            }
            ((ZoneOffsetTransitionRule) obj).writeExternal(dataOutput);
        }
    }

    public static void writeOffset(ZoneOffset zoneOffset, DataOutput dataOutput) throws IOException {
        int totalSeconds = zoneOffset.getTotalSeconds();
        int i10 = totalSeconds % 900 == 0 ? totalSeconds / 900 : 127;
        dataOutput.writeByte(i10);
        if (i10 == 127) {
            dataOutput.writeInt(totalSeconds);
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        byte b10 = objectInput.readByte();
        this.type = b10;
        this.object = readInternal(b10, objectInput);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        writeInternal(this.type, this.object, objectOutput);
    }

    public Ser(byte b10, Object obj) {
        this.type = b10;
        this.object = obj;
    }
}
