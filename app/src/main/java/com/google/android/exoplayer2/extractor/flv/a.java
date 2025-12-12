package com.google.android.exoplayer2.extractor.flv;

import android.util.Pair;
import c5.i;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import g5.m;
import java.util.Collections;
import l6.c;
import l6.l;

/* compiled from: AudioTagPayloadReader.java */
/* loaded from: classes.dex */
public final class a extends TagPayloadReader {

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f5847e = {5512, 11025, 22050, 44100};

    /* renamed from: b, reason: collision with root package name */
    public boolean f5848b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5849c;

    /* renamed from: d, reason: collision with root package name */
    public int f5850d;

    public a(m mVar) {
        super(mVar);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean parseHeader(l lVar) throws TagPayloadReader.UnsupportedFormatException {
        if (this.f5848b) {
            lVar.skipBytes(1);
        } else {
            int unsignedByte = lVar.readUnsignedByte();
            int i10 = (unsignedByte >> 4) & 15;
            this.f5850d = i10;
            m mVar = this.f5846a;
            if (i10 == 2) {
                mVar.format(i.createAudioSampleFormat(null, "audio/mpeg", null, -1, -1, 1, f5847e[(unsignedByte >> 2) & 3], null, null, 0, null));
                this.f5849c = true;
            } else if (i10 == 7 || i10 == 8) {
                mVar.format(i.createAudioSampleFormat(null, i10 == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", null, -1, -1, 1, 8000, (unsignedByte & 1) == 1 ? 2 : 3, null, null, 0, null));
                this.f5849c = true;
            } else if (i10 != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.f5850d);
            }
            this.f5848b = true;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void parsePayload(l lVar, long j10) {
        int i10 = this.f5850d;
        m mVar = this.f5846a;
        if (i10 == 2) {
            int iBytesLeft = lVar.bytesLeft();
            mVar.sampleData(lVar, iBytesLeft);
            this.f5846a.sampleMetadata(j10, 1, iBytesLeft, 0, null);
            return;
        }
        int unsignedByte = lVar.readUnsignedByte();
        if (unsignedByte != 0 || this.f5849c) {
            if (this.f5850d != 10 || unsignedByte == 1) {
                int iBytesLeft2 = lVar.bytesLeft();
                mVar.sampleData(lVar, iBytesLeft2);
                this.f5846a.sampleMetadata(j10, 1, iBytesLeft2, 0, null);
                return;
            }
            return;
        }
        int iBytesLeft3 = lVar.bytesLeft();
        byte[] bArr = new byte[iBytesLeft3];
        lVar.readBytes(bArr, 0, iBytesLeft3);
        Pair<Integer, Integer> aacAudioSpecificConfig = c.parseAacAudioSpecificConfig(bArr);
        mVar.format(i.createAudioSampleFormat(null, "audio/mp4a-latm", null, -1, -1, ((Integer) aacAudioSpecificConfig.second).intValue(), ((Integer) aacAudioSpecificConfig.first).intValue(), Collections.singletonList(bArr), null, 0, null));
        this.f5849c = true;
    }
}
