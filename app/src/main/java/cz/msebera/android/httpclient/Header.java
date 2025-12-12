package cz.msebera.android.httpclient;

/* loaded from: classes2.dex */
public interface Header extends NameValuePair {
    HeaderElement[] getElements() throws ParseException;
}
