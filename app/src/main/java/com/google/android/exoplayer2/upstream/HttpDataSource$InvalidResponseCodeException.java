package com.google.android.exoplayer2.upstream;

import ac.c;
import java.util.List;
import java.util.Map;
import k6.f;

/* loaded from: classes.dex */
public final class HttpDataSource$InvalidResponseCodeException extends HttpDataSource$HttpDataSourceException {

    /* renamed from: b, reason: collision with root package name */
    public final int f6027b;

    /* renamed from: m, reason: collision with root package name */
    public final Map<String, List<String>> f6028m;

    public HttpDataSource$InvalidResponseCodeException(int i10, Map<String, List<String>> map, f fVar) {
        super(c.f("Response code: ", i10), fVar, 1);
        this.f6027b = i10;
        this.f6028m = map;
    }
}
