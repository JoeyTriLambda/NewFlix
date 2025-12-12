package com.android.volley;

/* loaded from: classes.dex */
public class ParseError extends VolleyError {
    public ParseError() {
    }

    public ParseError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public ParseError(Throwable th2) {
        super(th2);
    }
}
