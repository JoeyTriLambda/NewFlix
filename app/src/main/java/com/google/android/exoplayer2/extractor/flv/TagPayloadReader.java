package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import g5.m;
import l6.l;

/* loaded from: classes.dex */
public abstract class TagPayloadReader {

    /* renamed from: a, reason: collision with root package name */
    public final m f5846a;

    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str);
        }
    }

    public TagPayloadReader(m mVar) {
        this.f5846a = mVar;
    }

    public final void consume(l lVar, long j10) throws ParserException {
        if (parseHeader(lVar)) {
            parsePayload(lVar, j10);
        }
    }

    public abstract boolean parseHeader(l lVar) throws ParserException;

    public abstract void parsePayload(l lVar, long j10) throws ParserException;
}
