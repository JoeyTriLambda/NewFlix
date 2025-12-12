package org.jsoup.select;

/* loaded from: classes2.dex */
public interface NodeFilter {

    public enum FilterResult {
        CONTINUE,
        SKIP_CHILDREN,
        /* JADX INFO: Fake field, exist only in values array */
        SKIP_ENTIRELY,
        REMOVE,
        STOP
    }
}
