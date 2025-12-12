package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
final class CharRange implements Iterable<Character>, Serializable {
    private static final long serialVersionUID = 8270183163158333422L;
    private final char end;
    private transient String iToString;
    private final boolean negated;
    private final char start;

    public static class CharacterIterator implements Iterator<Character> {
        private char current;
        private boolean hasNext;
        private final CharRange range;

        private void prepareNext() {
            if (!this.range.negated) {
                if (this.current < this.range.end) {
                    this.current = (char) (this.current + 1);
                    return;
                } else {
                    this.hasNext = false;
                    return;
                }
            }
            char c10 = this.current;
            if (c10 == 65535) {
                this.hasNext = false;
                return;
            }
            if (c10 + 1 != this.range.start) {
                this.current = (char) (this.current + 1);
            } else if (this.range.end == 65535) {
                this.hasNext = false;
            } else {
                this.current = (char) (this.range.end + 1);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private CharacterIterator(CharRange charRange) {
            this.range = charRange;
            this.hasNext = true;
            if (!charRange.negated) {
                this.current = charRange.start;
                return;
            }
            if (charRange.start != 0) {
                this.current = (char) 0;
            } else if (charRange.end == 65535) {
                this.hasNext = false;
            } else {
                this.current = (char) (charRange.end + 1);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Character next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            char c10 = this.current;
            prepareNext();
            return Character.valueOf(c10);
        }
    }

    private CharRange(char c10, char c11, boolean z10) {
        if (c10 > c11) {
            c11 = c10;
            c10 = c11;
        }
        this.start = c10;
        this.end = c11;
        this.negated = z10;
    }

    public static CharRange is(char c10) {
        return new CharRange(c10, c10, false);
    }

    public static CharRange isIn(char c10, char c11) {
        return new CharRange(c10, c11, false);
    }

    public static CharRange isNot(char c10) {
        return new CharRange(c10, c10, true);
    }

    public static CharRange isNotIn(char c10, char c11) {
        return new CharRange(c10, c11, true);
    }

    public boolean contains(char c10) {
        return (c10 >= this.start && c10 <= this.end) != this.negated;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CharRange)) {
            return false;
        }
        CharRange charRange = (CharRange) obj;
        return this.start == charRange.start && this.end == charRange.end && this.negated == charRange.negated;
    }

    public char getEnd() {
        return this.end;
    }

    public char getStart() {
        return this.start;
    }

    public int hashCode() {
        return (this.end * 7) + this.start + 'S' + (this.negated ? 1 : 0);
    }

    public boolean isNegated() {
        return this.negated;
    }

    @Override // java.lang.Iterable
    public Iterator<Character> iterator() {
        return new CharacterIterator();
    }

    public String toString() {
        if (this.iToString == null) {
            StringBuilder sb2 = new StringBuilder(4);
            if (isNegated()) {
                sb2.append('^');
            }
            sb2.append(this.start);
            if (this.start != this.end) {
                sb2.append('-');
                sb2.append(this.end);
            }
            this.iToString = sb2.toString();
        }
        return this.iToString;
    }

    public boolean contains(CharRange charRange) {
        Validate.isTrue(charRange != null, "The Range must not be null", new Object[0]);
        return this.negated ? charRange.negated ? this.start >= charRange.start && this.end <= charRange.end : charRange.end < this.start || charRange.start > this.end : charRange.negated ? this.start == 0 && this.end == 65535 : this.start <= charRange.start && this.end >= charRange.end;
    }
}
