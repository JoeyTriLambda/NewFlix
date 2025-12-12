package org.jsoup.select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;

/* loaded from: classes2.dex */
public class Elements extends ArrayList<Element> {
    public Elements() {
    }

    public String attr(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (next.hasAttr(str)) {
                return next.attr(str);
            }
        }
        return "";
    }

    public Element first() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    public Element last() {
        if (isEmpty()) {
            return null;
        }
        return get(size() - 1);
    }

    public String outerHtml() {
        StringBuilder sb2 = new StringBuilder();
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (sb2.length() != 0) {
                sb2.append(StringUtils.LF);
            }
            sb2.append(next.outerHtml());
        }
        return sb2.toString();
    }

    public String text() {
        StringBuilder sb2 = new StringBuilder();
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (sb2.length() != 0) {
                sb2.append(StringUtils.SPACE);
            }
            sb2.append(next.text());
        }
        return sb2.toString();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return outerHtml();
    }

    public Elements(int i10) {
        super(i10);
    }

    @Override // java.util.ArrayList
    public Elements clone() {
        Elements elements = new Elements(size());
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            elements.add(it.next().mo226clone());
        }
        return elements;
    }

    public Elements(List<Element> list) {
        super(list);
    }
}
