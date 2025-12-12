package org.jsoup.parser;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ParseErrorList extends ArrayList<gh.b> {

    /* renamed from: b, reason: collision with root package name */
    public final int f17209b;

    public ParseErrorList(int i10, int i11) {
        super(i10);
        this.f17209b = i11;
    }

    public static ParseErrorList noTracking() {
        return new ParseErrorList(0, 0);
    }

    public static ParseErrorList tracking(int i10) {
        return new ParseErrorList(16, i10);
    }

    public final boolean a() {
        return size() < this.f17209b;
    }
}
