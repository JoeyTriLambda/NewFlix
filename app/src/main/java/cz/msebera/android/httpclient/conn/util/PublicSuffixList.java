package cz.msebera.android.httpclient.conn.util;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.util.Args;
import java.util.Collections;
import java.util.List;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public final class PublicSuffixList {
    private final List<String> exceptions;
    private final List<String> rules;
    private final DomainType type;

    public PublicSuffixList(DomainType domainType, List<String> list, List<String> list2) {
        this.type = (DomainType) Args.notNull(domainType, "Domain type");
        this.rules = Collections.unmodifiableList((List) Args.notNull(list, "Domain suffix rules"));
        this.exceptions = Collections.unmodifiableList(list2 == null ? Collections.emptyList() : list2);
    }

    public List<String> getExceptions() {
        return this.exceptions;
    }

    public List<String> getRules() {
        return this.rules;
    }

    public DomainType getType() {
        return this.type;
    }

    public PublicSuffixList(List<String> list, List<String> list2) {
        this(DomainType.UNKNOWN, list, list2);
    }
}
