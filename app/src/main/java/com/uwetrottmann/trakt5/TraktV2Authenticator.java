package com.uwetrottmann.trakt5;

import com.uwetrottmann.trakt5.entities.AccessToken;
import java.io.IOException;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* loaded from: classes2.dex */
public class TraktV2Authenticator implements Authenticator {
    public final TraktV2 trakt;

    public TraktV2Authenticator(TraktV2 traktV2) {
        this.trakt = traktV2;
    }

    public static Request handleAuthenticate(Response response, TraktV2 traktV2) throws IOException {
        String strRefreshToken;
        if (traktV2.apiHost().equals(response.request().url().host()) && responseCount(response) < 2 && (strRefreshToken = traktV2.refreshToken()) != null && strRefreshToken.length() != 0) {
            retrofit2.Response<AccessToken> responseRefreshAccessToken = traktV2.refreshAccessToken(strRefreshToken);
            AccessToken accessTokenBody = responseRefreshAccessToken.body();
            if (responseRefreshAccessToken.isSuccessful() && accessTokenBody != null) {
                String str = accessTokenBody.access_token;
                traktV2.accessToken(str);
                traktV2.refreshToken(accessTokenBody.refresh_token);
                return response.request().newBuilder().header("Authorization", "Bearer " + str).build();
            }
        }
        return null;
    }

    private static int responseCount(Response response) {
        int i10 = 1;
        while (true) {
            response = response.priorResponse();
            if (response == null) {
                return i10;
            }
            i10++;
        }
    }

    @Override // okhttp3.Authenticator
    public Request authenticate(Route route, Response response) throws IOException {
        return handleAuthenticate(response, this.trakt);
    }
}
