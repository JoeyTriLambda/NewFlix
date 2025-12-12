package cz.msebera.android.httpclient.util;

import ac.c;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.Serializable;
import java.nio.CharBuffer;

/* loaded from: classes2.dex */
public final class CharArrayBuffer implements CharSequence, Serializable {
    private static final long serialVersionUID = -6208952725094867135L;
    private char[] buffer;
    private int len;

    public CharArrayBuffer(int i10) {
        Args.notNegative(i10, "Buffer capacity");
        this.buffer = new char[i10];
    }

    private void expand(int i10) {
        char[] cArr = new char[Math.max(this.buffer.length << 1, i10)];
        System.arraycopy(this.buffer, 0, cArr, 0, this.len);
        this.buffer = cArr;
    }

    public void append(char[] cArr, int i10, int i11) {
        int i12;
        if (cArr == null) {
            return;
        }
        if (i10 < 0 || i10 > cArr.length || i11 < 0 || (i12 = i10 + i11) < 0 || i12 > cArr.length) {
            StringBuilder sbT = c.t("off: ", i10, " len: ", i11, " b.length: ");
            sbT.append(cArr.length);
            throw new IndexOutOfBoundsException(sbT.toString());
        }
        if (i11 == 0) {
            return;
        }
        int i13 = this.len + i11;
        if (i13 > this.buffer.length) {
            expand(i13);
        }
        System.arraycopy(cArr, i10, this.buffer, this.len, i11);
        this.len = i13;
    }

    public char[] buffer() {
        return this.buffer;
    }

    public int capacity() {
        return this.buffer.length;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.buffer[i10];
    }

    public void clear() {
        this.len = 0;
    }

    public void ensureCapacity(int i10) {
        if (i10 <= 0) {
            return;
        }
        int length = this.buffer.length;
        int i11 = this.len;
        if (i10 > length - i11) {
            expand(i11 + i10);
        }
    }

    public int indexOf(int i10, int i11, int i12) {
        if (i11 < 0) {
            i11 = 0;
        }
        int i13 = this.len;
        if (i12 > i13) {
            i12 = i13;
        }
        if (i11 > i12) {
            return -1;
        }
        while (i11 < i12) {
            if (this.buffer[i11] == i10) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.len == 0;
    }

    public boolean isFull() {
        return this.len == this.buffer.length;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.len;
    }

    public void setLength(int i10) {
        if (i10 >= 0 && i10 <= this.buffer.length) {
            this.len = i10;
        } else {
            StringBuilder sbS = c.s("len: ", i10, " < 0 or > buffer len: ");
            sbS.append(this.buffer.length);
            throw new IndexOutOfBoundsException(sbS.toString());
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        if (i10 < 0) {
            throw new IndexOutOfBoundsException(c.f("Negative beginIndex: ", i10));
        }
        if (i11 <= this.len) {
            if (i10 <= i11) {
                return CharBuffer.wrap(this.buffer, i10, i11);
            }
            throw new IndexOutOfBoundsException(c.g("beginIndex: ", i10, " > endIndex: ", i11));
        }
        StringBuilder sbS = c.s("endIndex: ", i11, " > length: ");
        sbS.append(this.len);
        throw new IndexOutOfBoundsException(sbS.toString());
    }

    public String substring(int i10, int i11) {
        if (i10 < 0) {
            throw new IndexOutOfBoundsException(c.f("Negative beginIndex: ", i10));
        }
        if (i11 <= this.len) {
            if (i10 <= i11) {
                return new String(this.buffer, i10, i11 - i10);
            }
            throw new IndexOutOfBoundsException(c.g("beginIndex: ", i10, " > endIndex: ", i11));
        }
        StringBuilder sbS = c.s("endIndex: ", i11, " > length: ");
        sbS.append(this.len);
        throw new IndexOutOfBoundsException(sbS.toString());
    }

    public String substringTrimmed(int i10, int i11) {
        if (i10 < 0) {
            throw new IndexOutOfBoundsException(c.f("Negative beginIndex: ", i10));
        }
        if (i11 > this.len) {
            StringBuilder sbS = c.s("endIndex: ", i11, " > length: ");
            sbS.append(this.len);
            throw new IndexOutOfBoundsException(sbS.toString());
        }
        if (i10 > i11) {
            throw new IndexOutOfBoundsException(c.g("beginIndex: ", i10, " > endIndex: ", i11));
        }
        while (i10 < i11 && HTTP.isWhitespace(this.buffer[i10])) {
            i10++;
        }
        while (i11 > i10 && HTTP.isWhitespace(this.buffer[i11 - 1])) {
            i11--;
        }
        return new String(this.buffer, i10, i11 - i10);
    }

    public char[] toCharArray() {
        int i10 = this.len;
        char[] cArr = new char[i10];
        if (i10 > 0) {
            System.arraycopy(this.buffer, 0, cArr, 0, i10);
        }
        return cArr;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return new String(this.buffer, 0, this.len);
    }

    public int indexOf(int i10) {
        return indexOf(i10, 0, this.len);
    }

    public void append(String str) {
        if (str == null) {
            str = "null";
        }
        int length = str.length();
        int i10 = this.len + length;
        if (i10 > this.buffer.length) {
            expand(i10);
        }
        str.getChars(0, length, this.buffer, this.len);
        this.len = i10;
    }

    public void append(CharArrayBuffer charArrayBuffer, int i10, int i11) {
        if (charArrayBuffer == null) {
            return;
        }
        append(charArrayBuffer.buffer, i10, i11);
    }

    public void append(CharArrayBuffer charArrayBuffer) {
        if (charArrayBuffer == null) {
            return;
        }
        append(charArrayBuffer.buffer, 0, charArrayBuffer.len);
    }

    public void append(char c10) {
        int i10 = this.len + 1;
        if (i10 > this.buffer.length) {
            expand(i10);
        }
        this.buffer[this.len] = c10;
        this.len = i10;
    }

    public void append(byte[] bArr, int i10, int i11) {
        int i12;
        if (bArr == null) {
            return;
        }
        if (i10 < 0 || i10 > bArr.length || i11 < 0 || (i12 = i10 + i11) < 0 || i12 > bArr.length) {
            StringBuilder sbT = c.t("off: ", i10, " len: ", i11, " b.length: ");
            sbT.append(bArr.length);
            throw new IndexOutOfBoundsException(sbT.toString());
        }
        if (i11 == 0) {
            return;
        }
        int i13 = this.len;
        int i14 = i11 + i13;
        if (i14 > this.buffer.length) {
            expand(i14);
        }
        while (i13 < i14) {
            this.buffer[i13] = (char) (bArr[i10] & 255);
            i10++;
            i13++;
        }
        this.len = i14;
    }

    public void append(ByteArrayBuffer byteArrayBuffer, int i10, int i11) {
        if (byteArrayBuffer == null) {
            return;
        }
        append(byteArrayBuffer.buffer(), i10, i11);
    }

    public void append(Object obj) {
        append(String.valueOf(obj));
    }
}
