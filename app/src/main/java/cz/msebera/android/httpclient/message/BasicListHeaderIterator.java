package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class BasicListHeaderIterator implements HeaderIterator {
    protected final List<Header> allHeaders;
    protected String headerName;
    protected int currentIndex = findNext(-1);
    protected int lastIndex = -1;

    public BasicListHeaderIterator(List<Header> list, String str) {
        this.allHeaders = (List) Args.notNull(list, "Header list");
        this.headerName = str;
    }

    public boolean filterHeader(int i10) {
        if (this.headerName == null) {
            return true;
        }
        return this.headerName.equalsIgnoreCase(this.allHeaders.get(i10).getName());
    }

    public int findNext(int i10) {
        if (i10 < -1) {
            return -1;
        }
        int size = this.allHeaders.size() - 1;
        boolean zFilterHeader = false;
        while (!zFilterHeader && i10 < size) {
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
        this.lastIndex = i10;
        this.currentIndex = findNext(i10);
        return this.allHeaders.get(i10);
    }

    @Override // java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        Asserts.check(this.lastIndex >= 0, "No header to remove");
        this.allHeaders.remove(this.lastIndex);
        this.lastIndex = -1;
        this.currentIndex--;
    }
}
