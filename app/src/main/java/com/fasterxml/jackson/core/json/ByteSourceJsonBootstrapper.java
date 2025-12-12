package com.fasterxml.jackson.core.json;

import ac.c;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.MergedStream;
import com.fasterxml.jackson.core.io.UTF32Reader;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* loaded from: classes.dex */
public final class ByteSourceJsonBootstrapper {
    public static final byte UTF8_BOM_1 = -17;
    public static final byte UTF8_BOM_2 = -69;
    public static final byte UTF8_BOM_3 = -65;
    private boolean _bigEndian;
    private final boolean _bufferRecyclable;
    private int _bytesPerChar;
    private final IOContext _context;
    private final InputStream _in;
    private final byte[] _inputBuffer;
    private int _inputEnd;
    private int _inputPtr;

    public ByteSourceJsonBootstrapper(IOContext iOContext, InputStream inputStream) {
        this._bigEndian = true;
        this._context = iOContext;
        this._in = inputStream;
        this._inputBuffer = iOContext.allocReadIOBuffer();
        this._inputPtr = 0;
        this._inputEnd = 0;
        this._bufferRecyclable = true;
    }

    private boolean checkUTF16(int i10) {
        if ((65280 & i10) == 0) {
            this._bigEndian = true;
        } else {
            if ((i10 & 255) != 0) {
                return false;
            }
            this._bigEndian = false;
        }
        this._bytesPerChar = 2;
        return true;
    }

    private boolean checkUTF32(int i10) throws IOException {
        if ((i10 >> 8) == 0) {
            this._bigEndian = true;
        } else if ((16777215 & i10) == 0) {
            this._bigEndian = false;
        } else if (((-16711681) & i10) == 0) {
            reportWeirdUCS4("3412");
        } else {
            if ((i10 & (-65281)) != 0) {
                return false;
            }
            reportWeirdUCS4("2143");
        }
        this._bytesPerChar = 4;
        return true;
    }

    private boolean handleBOM(int i10) throws IOException {
        if (i10 == -16842752) {
            reportWeirdUCS4("3412");
        } else {
            if (i10 == -131072) {
                this._inputPtr += 4;
                this._bytesPerChar = 4;
                this._bigEndian = false;
                return true;
            }
            if (i10 == 65279) {
                this._bigEndian = true;
                this._inputPtr += 4;
                this._bytesPerChar = 4;
                return true;
            }
            if (i10 == 65534) {
                reportWeirdUCS4("2143");
            }
        }
        int i11 = i10 >>> 16;
        if (i11 == 65279) {
            this._inputPtr += 2;
            this._bytesPerChar = 2;
            this._bigEndian = true;
            return true;
        }
        if (i11 == 65534) {
            this._inputPtr += 2;
            this._bytesPerChar = 2;
            this._bigEndian = false;
            return true;
        }
        if ((i10 >>> 8) != 15711167) {
            return false;
        }
        this._inputPtr += 3;
        this._bytesPerChar = 1;
        this._bigEndian = true;
        return true;
    }

    public static MatchStrength hasJSONFormat(InputAccessor inputAccessor) throws IOException {
        if (!inputAccessor.hasMoreBytes()) {
            return MatchStrength.INCONCLUSIVE;
        }
        byte bNextByte = inputAccessor.nextByte();
        if (bNextByte == -17) {
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (inputAccessor.nextByte() != -69) {
                return MatchStrength.NO_MATCH;
            }
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (inputAccessor.nextByte() != -65) {
                return MatchStrength.NO_MATCH;
            }
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            bNextByte = inputAccessor.nextByte();
        }
        int iSkipSpace = skipSpace(inputAccessor, bNextByte);
        if (iSkipSpace < 0) {
            return MatchStrength.INCONCLUSIVE;
        }
        if (iSkipSpace == 123) {
            int iSkipSpace2 = skipSpace(inputAccessor);
            return iSkipSpace2 < 0 ? MatchStrength.INCONCLUSIVE : (iSkipSpace2 == 34 || iSkipSpace2 == 125) ? MatchStrength.SOLID_MATCH : MatchStrength.NO_MATCH;
        }
        if (iSkipSpace == 91) {
            int iSkipSpace3 = skipSpace(inputAccessor);
            return iSkipSpace3 < 0 ? MatchStrength.INCONCLUSIVE : (iSkipSpace3 == 93 || iSkipSpace3 == 91) ? MatchStrength.SOLID_MATCH : MatchStrength.SOLID_MATCH;
        }
        MatchStrength matchStrength = MatchStrength.WEAK_MATCH;
        if (iSkipSpace == 34) {
            return matchStrength;
        }
        if (iSkipSpace <= 57 && iSkipSpace >= 48) {
            return matchStrength;
        }
        if (iSkipSpace != 45) {
            return iSkipSpace == 110 ? tryMatch(inputAccessor, "ull", matchStrength) : iSkipSpace == 116 ? tryMatch(inputAccessor, "rue", matchStrength) : iSkipSpace == 102 ? tryMatch(inputAccessor, "alse", matchStrength) : MatchStrength.NO_MATCH;
        }
        int iSkipSpace4 = skipSpace(inputAccessor);
        return iSkipSpace4 < 0 ? MatchStrength.INCONCLUSIVE : (iSkipSpace4 > 57 || iSkipSpace4 < 48) ? MatchStrength.NO_MATCH : matchStrength;
    }

    private void reportWeirdUCS4(String str) throws IOException {
        throw new CharConversionException(c.k("Unsupported UCS-4 endianness (", str, ") detected"));
    }

    private static int skipSpace(InputAccessor inputAccessor) throws IOException {
        if (inputAccessor.hasMoreBytes()) {
            return skipSpace(inputAccessor, inputAccessor.nextByte());
        }
        return -1;
    }

    public static int skipUTF8BOM(DataInput dataInput) throws IOException {
        int unsignedByte = dataInput.readUnsignedByte();
        if (unsignedByte != 239) {
            return unsignedByte;
        }
        int unsignedByte2 = dataInput.readUnsignedByte();
        if (unsignedByte2 != 187) {
            throw new IOException("Unexpected byte 0x" + Integer.toHexString(unsignedByte2) + " following 0xEF; should get 0xBB as part of UTF-8 BOM");
        }
        int unsignedByte3 = dataInput.readUnsignedByte();
        if (unsignedByte3 == 191) {
            return dataInput.readUnsignedByte();
        }
        throw new IOException("Unexpected byte 0x" + Integer.toHexString(unsignedByte3) + " following 0xEF 0xBB; should get 0xBF as part of UTF-8 BOM");
    }

    private static MatchStrength tryMatch(InputAccessor inputAccessor, String str, MatchStrength matchStrength) throws IOException {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (inputAccessor.nextByte() != str.charAt(i10)) {
                return MatchStrength.NO_MATCH;
            }
        }
        return matchStrength;
    }

    public JsonParser constructParser(int i10, ObjectCodec objectCodec, ByteQuadsCanonicalizer byteQuadsCanonicalizer, CharsToNameCanonicalizer charsToNameCanonicalizer, int i11) throws IOException {
        int i12 = this._inputPtr;
        JsonEncoding jsonEncodingDetectEncoding = detectEncoding();
        int i13 = this._inputPtr - i12;
        if (jsonEncodingDetectEncoding != JsonEncoding.UTF8 || !JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(i11)) {
            return new ReaderBasedJsonParser(this._context, i10, constructReader(), objectCodec, charsToNameCanonicalizer.makeChild(i11));
        }
        return new UTF8StreamJsonParser(this._context, i10, this._in, objectCodec, byteQuadsCanonicalizer.makeChild(i11), this._inputBuffer, this._inputPtr, this._inputEnd, i13, this._bufferRecyclable);
    }

    public Reader constructReader() throws IOException {
        JsonEncoding encoding = this._context.getEncoding();
        int iBits = encoding.bits();
        if (iBits != 8 && iBits != 16) {
            if (iBits != 32) {
                throw new RuntimeException("Internal error");
            }
            IOContext iOContext = this._context;
            return new UTF32Reader(iOContext, this._in, this._inputBuffer, this._inputPtr, this._inputEnd, iOContext.getEncoding().isBigEndian());
        }
        InputStream mergedStream = this._in;
        if (mergedStream == null) {
            mergedStream = new ByteArrayInputStream(this._inputBuffer, this._inputPtr, this._inputEnd);
        } else if (this._inputPtr < this._inputEnd) {
            mergedStream = new MergedStream(this._context, mergedStream, this._inputBuffer, this._inputPtr, this._inputEnd);
        }
        return new InputStreamReader(mergedStream, encoding.getJavaName());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.fasterxml.jackson.core.JsonEncoding detectEncoding() throws java.io.IOException {
        /*
            r8 = this;
            r0 = 4
            boolean r1 = r8.ensureLoaded(r0)
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L42
            byte[] r1 = r8._inputBuffer
            int r5 = r8._inputPtr
            r6 = r1[r5]
            int r6 = r6 << 24
            int r7 = r5 + 1
            r7 = r1[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << 16
            r6 = r6 | r7
            int r7 = r5 + 2
            r7 = r1[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << 8
            r6 = r6 | r7
            int r5 = r5 + 3
            r1 = r1[r5]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r1 | r6
            boolean r5 = r8.handleBOM(r1)
            if (r5 == 0) goto L32
            goto L5e
        L32:
            boolean r5 = r8.checkUTF32(r1)
            if (r5 == 0) goto L39
            goto L5e
        L39:
            int r1 = r1 >>> 16
            boolean r1 = r8.checkUTF16(r1)
            if (r1 == 0) goto L5f
            goto L5e
        L42:
            boolean r1 = r8.ensureLoaded(r2)
            if (r1 == 0) goto L5f
            byte[] r1 = r8._inputBuffer
            int r5 = r8._inputPtr
            r6 = r1[r5]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << 8
            int r5 = r5 + r3
            r1 = r1[r5]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r1 | r6
            boolean r1 = r8.checkUTF16(r1)
            if (r1 == 0) goto L5f
        L5e:
            r4 = 1
        L5f:
            if (r4 != 0) goto L64
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF8
            goto L8a
        L64:
            int r1 = r8._bytesPerChar
            if (r1 == r3) goto L88
            if (r1 == r2) goto L7e
            if (r1 != r0) goto L76
            boolean r0 = r8._bigEndian
            if (r0 == 0) goto L73
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF32_BE
            goto L8a
        L73:
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF32_LE
            goto L8a
        L76:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Internal error"
            r0.<init>(r1)
            throw r0
        L7e:
            boolean r0 = r8._bigEndian
            if (r0 == 0) goto L85
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF16_BE
            goto L8a
        L85:
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF16_LE
            goto L8a
        L88:
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF8
        L8a:
            com.fasterxml.jackson.core.io.IOContext r1 = r8._context
            r1.setEncoding(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper.detectEncoding():com.fasterxml.jackson.core.JsonEncoding");
    }

    public boolean ensureLoaded(int i10) throws IOException {
        int i11;
        int i12 = this._inputEnd - this._inputPtr;
        while (i12 < i10) {
            InputStream inputStream = this._in;
            if (inputStream == null) {
                i11 = -1;
            } else {
                byte[] bArr = this._inputBuffer;
                int i13 = this._inputEnd;
                i11 = inputStream.read(bArr, i13, bArr.length - i13);
            }
            if (i11 < 1) {
                return false;
            }
            this._inputEnd += i11;
            i12 += i11;
        }
        return true;
    }

    private static int skipSpace(InputAccessor inputAccessor, byte b10) throws IOException {
        while (true) {
            int i10 = b10 & 255;
            if (i10 != 32 && i10 != 13 && i10 != 10 && i10 != 9) {
                return i10;
            }
            if (!inputAccessor.hasMoreBytes()) {
                return -1;
            }
            b10 = inputAccessor.nextByte();
        }
    }

    public ByteSourceJsonBootstrapper(IOContext iOContext, byte[] bArr, int i10, int i11) {
        this._bigEndian = true;
        this._context = iOContext;
        this._in = null;
        this._inputBuffer = bArr;
        this._inputPtr = i10;
        this._inputEnd = i10 + i11;
        this._bufferRecyclable = false;
    }
}
