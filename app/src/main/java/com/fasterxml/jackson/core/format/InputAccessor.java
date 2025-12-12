package com.fasterxml.jackson.core.format;

import ac.c;
import com.fasterxml.jackson.core.JsonFactory;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public interface InputAccessor {
    boolean hasMoreBytes() throws IOException;

    byte nextByte() throws IOException;

    void reset();

    public static class Std implements InputAccessor {
        protected final byte[] _buffer;
        protected int _bufferedEnd;
        protected final int _bufferedStart;
        protected final InputStream _in;
        protected int _ptr;

        public Std(InputStream inputStream, byte[] bArr) {
            this._in = inputStream;
            this._buffer = bArr;
            this._bufferedStart = 0;
            this._ptr = 0;
            this._bufferedEnd = 0;
        }

        public DataFormatMatcher createMatcher(JsonFactory jsonFactory, MatchStrength matchStrength) {
            InputStream inputStream = this._in;
            byte[] bArr = this._buffer;
            int i10 = this._bufferedStart;
            return new DataFormatMatcher(inputStream, bArr, i10, this._bufferedEnd - i10, jsonFactory, matchStrength);
        }

        @Override // com.fasterxml.jackson.core.format.InputAccessor
        public boolean hasMoreBytes() throws IOException {
            int i10;
            int i11 = this._ptr;
            if (i11 < this._bufferedEnd) {
                return true;
            }
            InputStream inputStream = this._in;
            if (inputStream == null) {
                return false;
            }
            byte[] bArr = this._buffer;
            int length = bArr.length - i11;
            if (length < 1 || (i10 = inputStream.read(bArr, i11, length)) <= 0) {
                return false;
            }
            this._bufferedEnd += i10;
            return true;
        }

        @Override // com.fasterxml.jackson.core.format.InputAccessor
        public byte nextByte() throws IOException {
            if (this._ptr < this._bufferedEnd || hasMoreBytes()) {
                byte[] bArr = this._buffer;
                int i10 = this._ptr;
                this._ptr = i10 + 1;
                return bArr[i10];
            }
            StringBuilder sb2 = new StringBuilder("Failed auto-detect: could not read more than ");
            sb2.append(this._ptr);
            sb2.append(" bytes (max buffer size: ");
            throw new EOFException(c.m(sb2, this._buffer.length, ")"));
        }

        @Override // com.fasterxml.jackson.core.format.InputAccessor
        public void reset() {
            this._ptr = this._bufferedStart;
        }

        public Std(byte[] bArr) {
            this._in = null;
            this._buffer = bArr;
            this._bufferedStart = 0;
            this._bufferedEnd = bArr.length;
        }

        public Std(byte[] bArr, int i10, int i11) {
            this._in = null;
            this._buffer = bArr;
            this._ptr = i10;
            this._bufferedStart = i10;
            this._bufferedEnd = i10 + i11;
        }
    }
}
