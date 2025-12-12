package cz.msebera.android.httpclient.message;

import ac.c;

/* loaded from: classes2.dex */
public class ParserCursor {
    private final int lowerBound;
    private int pos;
    private final int upperBound;

    public ParserCursor(int i10, int i11) {
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("Lower bound cannot be negative");
        }
        if (i10 > i11) {
            throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        }
        this.lowerBound = i10;
        this.upperBound = i11;
        this.pos = i10;
    }

    public boolean atEnd() {
        return this.pos >= this.upperBound;
    }

    public int getLowerBound() {
        return this.lowerBound;
    }

    public int getPos() {
        return this.pos;
    }

    public int getUpperBound() {
        return this.upperBound;
    }

    public String toString() {
        return "[" + Integer.toString(this.lowerBound) + '>' + Integer.toString(this.pos) + '>' + Integer.toString(this.upperBound) + ']';
    }

    public void updatePos(int i10) {
        if (i10 < this.lowerBound) {
            StringBuilder sbS = c.s("pos: ", i10, " < lowerBound: ");
            sbS.append(this.lowerBound);
            throw new IndexOutOfBoundsException(sbS.toString());
        }
        if (i10 <= this.upperBound) {
            this.pos = i10;
        } else {
            StringBuilder sbS2 = c.s("pos: ", i10, " > upperBound: ");
            sbS2.append(this.upperBound);
            throw new IndexOutOfBoundsException(sbS2.toString());
        }
    }
}
