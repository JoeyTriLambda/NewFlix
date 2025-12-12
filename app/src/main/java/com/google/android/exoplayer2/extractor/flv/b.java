package com.google.android.exoplayer2.extractor.flv;

import ac.c;
import c5.i;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.unity3d.services.core.device.MimeTypes;
import g5.m;
import l6.j;
import l6.l;

/* compiled from: VideoTagPayloadReader.java */
/* loaded from: classes.dex */
public final class b extends TagPayloadReader {

    /* renamed from: b, reason: collision with root package name */
    public final l f5851b;

    /* renamed from: c, reason: collision with root package name */
    public final l f5852c;

    /* renamed from: d, reason: collision with root package name */
    public int f5853d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5854e;

    /* renamed from: f, reason: collision with root package name */
    public int f5855f;

    public b(m mVar) {
        super(mVar);
        this.f5851b = new l(j.f15860a);
        this.f5852c = new l(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean parseHeader(l lVar) throws TagPayloadReader.UnsupportedFormatException {
        int unsignedByte = lVar.readUnsignedByte();
        int i10 = (unsignedByte >> 4) & 15;
        int i11 = unsignedByte & 15;
        if (i11 != 7) {
            throw new TagPayloadReader.UnsupportedFormatException(c.f("Video format not supported: ", i11));
        }
        this.f5855f = i10;
        return i10 != 5;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void parsePayload(l lVar, long j10) throws ParserException {
        int unsignedByte = lVar.readUnsignedByte();
        long unsignedInt24 = (lVar.readUnsignedInt24() * 1000) + j10;
        m mVar = this.f5846a;
        if (unsignedByte == 0 && !this.f5854e) {
            l lVar2 = new l(new byte[lVar.bytesLeft()]);
            lVar.readBytes(lVar2.f15881a, 0, lVar.bytesLeft());
            m6.a aVar = m6.a.parse(lVar2);
            this.f5853d = aVar.f16111b;
            mVar.format(i.createVideoSampleFormat(null, MimeTypes.VIDEO_H264, null, -1, -1, aVar.f16112c, aVar.f16113d, -1.0f, aVar.f16110a, -1, aVar.f16114e, null));
            this.f5854e = true;
            return;
        }
        if (unsignedByte == 1 && this.f5854e) {
            l lVar3 = this.f5852c;
            byte[] bArr = lVar3.f15881a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i10 = 4 - this.f5853d;
            int i11 = 0;
            while (lVar.bytesLeft() > 0) {
                lVar.readBytes(lVar3.f15881a, i10, this.f5853d);
                lVar3.setPosition(0);
                int unsignedIntToInt = lVar3.readUnsignedIntToInt();
                l lVar4 = this.f5851b;
                lVar4.setPosition(0);
                mVar.sampleData(lVar4, 4);
                mVar.sampleData(lVar, unsignedIntToInt);
                i11 = i11 + 4 + unsignedIntToInt;
            }
            this.f5846a.sampleMetadata(unsignedInt24, this.f5855f == 1 ? 1 : 0, i11, 0, null);
        }
    }
}
