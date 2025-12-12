package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.util.Args;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class BasicHeaderIterator implements HeaderIterator {
    protected final Header[] allHeaders;
    protected int currentIndex = findNext(-1);
    protected String headerName;

    public BasicHeaderIterator(Header[] headerArr, String str) {
        this.allHeaders = (Header[]) Args.notNull(headerArr, "Header array");
        this.headerName = str;
    }

    public boolean filterHeader(int i10) {
        String str = this.headerName;
        return str == null || str.equalsIgnoreCase(this.allHeaders[i10].getName());
    }

    public int findNext(int i10) {
        if (i10 < -1) {
            return -1;
        }
        int length = this.allHeaders.length - 1;
        boolean zFilterHeader = false;
        while (!zFilterHeader && i10 < length) {
            i10++;
            zFilterHeader = filterHeader(i10);
        }
        if (zFilterHeader) {
            return i10;
        }
        return -1;
    }

    @Override // cz.msebera.android.httpclient.HeaderIterator, java.util.Iterator
    public boolean hasNext() {
        return this.currentIndex >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException {
        return nextHeader();
    }

    @Override // cz.msebera.android.httpclient.HeaderIterator
    public Header nextHeader() throws NoSuchElementException {
        int i10 = this.currentIndex;
        if (i10 < 0) {
            throw new NoSuchElementException("Iteration already finished.");
        }
        this.currentIndex = findNext(i10);
        return this.allHeaders[i10];
    }

    @Override // java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Removing headers is not supported.");
    }
}
