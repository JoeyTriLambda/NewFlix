package cz.msebera.android.httpclient.params;

import java.util.Set;

@Deprecated
/* loaded from: classes2.dex */
public abstract class AbstractHttpParams implements HttpParams, HttpParamsNames {
    @Override // cz.msebera.android.httpclient.params.HttpParams
    public boolean getBooleanParameter(String str, boolean z10) {
        Object parameter = getParameter(str);
        return parameter == null ? z10 : ((Boolean) parameter).booleanValue();
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public double getDoubleParameter(String str, double d10) {
        Object parameter = getParameter(str);
        return parameter == null ? d10 : ((Double) parameter).doubleValue();
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public int getIntParameter(String str, int i10) {
        Object parameter = getParameter(str);
        return parameter == null ? i10 : ((Integer) parameter).intValue();
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public long getLongParameter(String str, long j10) {
        Object parameter = getParameter(str);
        return parameter == null ? j10 : ((Long) parameter).longValue();
    }

    @Override // cz.msebera.android.httpclient.params.HttpParamsNames
    public Set<String> getNames() {
        throw new UnsupportedOperationException();
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public boolean isParameterFalse(String str) {
        return !getBooleanParameter(str, false);
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public boolean isParameterTrue(String str) {
        return getBooleanParameter(str, false);
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams setBooleanParameter(String str, boolean z10) {
        setParameter(str, z10 ? Boolean.TRUE : Boolean.FALSE);
        return this;
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams setDoubleParameter(String str, double d10) {
        setParameter(str, Double.valueOf(d10));
        return this;
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams setIntParameter(String str, int i10) {
        setParameter(str, Integer.valueOf(i10));
        return this;
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams setLongParameter(String str, long j10) {
        setParameter(str, Long.valueOf(j10));
        return this;
    }
}
