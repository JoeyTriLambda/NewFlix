package com.loopj.android.http;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;

/* loaded from: classes.dex */
public class BlackholeHttpResponseHandler extends AsyncHttpResponseHandler {
    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onCancel() {
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onFinish() {
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onStart() {
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onRetry(int i10) {
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onUserException(Throwable th2) {
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler, com.loopj.android.http.ResponseHandlerInterface
    public void onPostProcessResponse(ResponseHandlerInterface responseHandlerInterface, HttpResponse httpResponse) {
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler, com.loopj.android.http.ResponseHandlerInterface
    public void onPreProcessResponse(ResponseHandlerInterface responseHandlerInterface, HttpResponse httpResponse) {
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onProgress(long j10, long j11) {
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onSuccess(int i10, Header[] headerArr, byte[] bArr) {
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onFailure(int i10, Header[] headerArr, byte[] bArr, Throwable th2) {
    }
}
