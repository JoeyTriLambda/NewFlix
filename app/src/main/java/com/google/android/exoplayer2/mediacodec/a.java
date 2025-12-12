package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;

/* compiled from: MediaCodecSelector.java */
/* loaded from: classes.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0071a f5880a = new C0071a();

    /* compiled from: MediaCodecSelector.java */
    /* renamed from: com.google.android.exoplayer2.mediacodec.a$a, reason: collision with other inner class name */
    public static class C0071a implements a {
        @Override // com.google.android.exoplayer2.mediacodec.a
        public p5.a getDecoderInfo(String str, boolean z10) throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.getDecoderInfo(str, z10);
        }

        @Override // com.google.android.exoplayer2.mediacodec.a
        public p5.a getPassthroughDecoderInfo() throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.getPassthroughDecoderInfo();
        }
    }

    p5.a getDecoderInfo(String str, boolean z10) throws MediaCodecUtil.DecoderQueryException;

    p5.a getPassthroughDecoderInfo() throws MediaCodecUtil.DecoderQueryException;
}
