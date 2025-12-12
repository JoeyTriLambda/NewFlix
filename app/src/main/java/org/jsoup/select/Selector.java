package org.jsoup.select;

import org.jsoup.nodes.Element;

/* loaded from: classes2.dex */
public final class Selector {

    public static class SelectorParseException extends IllegalStateException {
        public SelectorParseException(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    public static Elements select(String str, Element element) {
        dh.f.notEmpty(str);
        return select(e.parse(str), element);
    }

    public static Element selectFirst(String str, Element element) {
        dh.f.notEmpty(str);
        return a.findFirst(e.parse(str), element);
    }

    public static Elements select(c cVar, Element element) {
        dh.f.notNull(cVar);
        dh.f.notNull(element);
        return a.collect(cVar, element);
    }
}
