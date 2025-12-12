package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class HeaderGroup implements Cloneable, Serializable {
    private static final long serialVersionUID = 2608834160639271617L;
    private final Header[] EMPTY = new Header[0];
    private final List<Header> headers = new ArrayList(16);

    public void addHeader(Header header) {
        if (header == null) {
            return;
        }
        this.headers.add(header);
    }

    public void clear() {
        this.headers.clear();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean containsHeader(String str) {
        for (int i10 = 0; i10 < this.headers.size(); i10++) {
            if (this.headers.get(i10).getName().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public HeaderGroup copy() {
        HeaderGroup headerGroup = new HeaderGroup();
        headerGroup.headers.addAll(this.headers);
        return headerGroup;
    }

    public Header[] getAllHeaders() {
        List<Header> list = this.headers;
        return (Header[]) list.toArray(new Header[list.size()]);
    }

    public Header getCondensedHeader(String str) {
        Header[] headers = getHeaders(str);
        if (headers.length == 0) {
            return null;
        }
        if (headers.length == 1) {
            return headers[0];
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(128);
        charArrayBuffer.append(headers[0].getValue());
        for (int i10 = 1; i10 < headers.length; i10++) {
            charArrayBuffer.append(", ");
            charArrayBuffer.append(headers[i10].getValue());
        }
        return new BasicHeader(str.toLowerCase(Locale.ROOT), charArrayBuffer.toString());
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
    	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:118)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    public Header getFirstHeader(String str) {
        for (int i10 = 0; i10 < this.headers.size(); i10++) {
            Header header = this.headers.get(i10);
            if (header.getName().equalsIgnoreCase(str)) {
                return header;
            }
        }
        return null;
    }

    public Header[] getHeaders(String str) {
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < this.headers.size(); i10++) {
            Header header = this.headers.get(i10);
            if (header.getName().equalsIgnoreCase(str)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(header);
            }
        }
        return arrayList != null ? (Header[]) arrayList.toArray(new Header[arrayList.size()]) : this.EMPTY;
    }

    public Header getLastHeader(String str) {
        for (int size = this.headers.size() - 1; size >= 0; size--) {
            Header header = this.headers.get(size);
            if (header.getName().equalsIgnoreCase(str)) {
                return header;
            }
        }
        return null;
    }

    public HeaderIterator iterator() {
        return new BasicListHeaderIterator(this.headers, null);
    }

    public void removeHeader(Header header) {
        if (header == null) {
            return;
        }
        this.headers.remove(header);
    }

    public void setHeaders(Header[] headerArr) {
        clear();
        if (headerArr == null) {
            return;
        }
        Collections.addAll(this.headers, headerArr);
    }

    public String toString() {
        return this.headers.toString();
    }

    public void updateHeader(Header header) {
        if (header == null) {
            return;
        }
        for (int i10 = 0; i10 < this.headers.size(); i10++) {
            if (this.headers.get(i10).getName().equalsIgnoreCase(header.getName())) {
                this.headers.set(i10, header);
                return;
            }
        }
        this.headers.add(header);
    }

    public HeaderIterator iterator(String str) {
        return new BasicListHeaderIterator(this.headers, str);
    }
}
