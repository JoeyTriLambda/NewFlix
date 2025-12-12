package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.conn.util.PublicSuffixList;
import java.io.IOException;
import java.io.Reader;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
/* loaded from: classes2.dex */
public class PublicSuffixListParser {
    private final PublicSuffixFilter filter;
    private final cz.msebera.android.httpclient.conn.util.PublicSuffixListParser parser = new cz.msebera.android.httpclient.conn.util.PublicSuffixListParser();

    public PublicSuffixListParser(PublicSuffixFilter publicSuffixFilter) {
        this.filter = publicSuffixFilter;
    }

    public void parse(Reader reader) throws IOException {
        PublicSuffixList publicSuffixList = this.parser.parse(reader);
        this.filter.setPublicSuffixes(publicSuffixList.getRules());
        this.filter.setExceptions(publicSuffixList.getExceptions());
    }
}
