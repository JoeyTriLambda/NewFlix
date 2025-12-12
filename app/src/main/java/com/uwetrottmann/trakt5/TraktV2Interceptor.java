package com.uwetrottmann.trakt5;

import cz.msebera.android.httpclient.HttpHeaders;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes2.dex */
public class TraktV2Interceptor implements Interceptor {
    private final TraktV2 trakt;

    public TraktV2Interceptor(TraktV2 traktV2) {
        this.trakt = traktV2;
    }

    private static boolean accessTokenIsNotEmpty(String str) {
        return (str == null || str.length() == 0) ? false : true;
    }

    public static Response handleIntercept(Interceptor.Chain chain, String str, String str2) throws InterruptedException, IOException {
        String strHeader;
        Request request = chain.request();
        if (!TraktV2.API_HOST.equals(request.url().host()) && !TraktV2.API_STAGING_HOST.equals(request.url().host())) {
            return chain.proceed(request);
        }
        Request.Builder builderNewBuilder = request.newBuilder();
        builderNewBuilder.header("Content-Type", "application/json");
        builderNewBuilder.header(TraktV2.HEADER_TRAKT_API_KEY, str);
        builderNewBuilder.header(TraktV2.HEADER_TRAKT_API_VERSION, TraktV2.API_VERSION);
        if (hasNoAuthorizationHeader(request) && accessTokenIsNotEmpty(str2)) {
            builderNewBuilder.header("Authorization", "Bearer " + str2);
        }
        Response responseProceed = chain.proceed(builderNewBuilder.build());
        if (responseProceed.code() == 429 && (strHeader = responseProceed.header(HttpHeaders.RETRY_AFTER)) != null) {
            try {
                Thread.sleep((int) ((Integer.parseInt(strHeader) + 0.5d) * 1000.0d));
                if (responseProceed.body() != null) {
                    responseProceed.body().close();
                }
                return handleIntercept(chain, str, str2);
            } catch (InterruptedException | NumberFormatException unused) {
            }
        }
        return responseProceed;
    }

    private static boolean hasNoAuthorizationHeader(Request request) {
        return request.header("Authorization") == null;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        return handleIntercept(chain, this.trakt.apiKey(), this.trakt.accessToken());
    }
}
