package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.m;
import cz.msebera.android.httpclient.HttpHost;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import sa.h;

/* loaded from: classes2.dex */
public final class NetworkRequestHandler extends m {

    /* renamed from: a, reason: collision with root package name */
    public final sa.d f10480a;

    /* renamed from: b, reason: collision with root package name */
    public final sa.h f10481b;

    public static class ContentLengthException extends IOException {
        public ContentLengthException() {
            super("Received response with 0 content-length header.");
        }
    }

    public static final class ResponseException extends IOException {

        /* renamed from: b, reason: collision with root package name */
        public final int f10482b;

        /* renamed from: m, reason: collision with root package name */
        public final int f10483m;

        public ResponseException(int i10) {
            super(ac.c.f("HTTP ", i10));
            this.f10482b = i10;
            this.f10483m = 0;
        }
    }

    public NetworkRequestHandler(sa.d dVar, sa.h hVar) {
        this.f10480a = dVar;
        this.f10481b = hVar;
    }

    @Override // com.squareup.picasso.m
    public final int c() {
        return 2;
    }

    @Override // com.squareup.picasso.m
    public boolean canHandleRequest(k kVar) {
        String scheme = kVar.f10584c.getScheme();
        return HttpHost.DEFAULT_SCHEME_NAME.equals(scheme) || "https".equals(scheme);
    }

    @Override // com.squareup.picasso.m
    public final boolean d(NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    @Override // com.squareup.picasso.m
    public m.a load(k kVar, int i10) throws IOException {
        CacheControl cacheControlBuild;
        if (i10 == 0) {
            cacheControlBuild = null;
        } else if (NetworkPolicy.isOfflineOnly(i10)) {
            cacheControlBuild = CacheControl.FORCE_CACHE;
        } else {
            CacheControl.Builder builder = new CacheControl.Builder();
            if (!NetworkPolicy.shouldReadFromDiskCache(i10)) {
                builder.noCache();
            }
            if (!NetworkPolicy.shouldWriteToDiskCache(i10)) {
                builder.noStore();
            }
            cacheControlBuild = builder.build();
        }
        Request.Builder builderUrl = new Request.Builder().url(kVar.f10584c.toString());
        if (cacheControlBuild != null) {
            builderUrl.cacheControl(cacheControlBuild);
        }
        Response responseLoad = ((sa.g) this.f10480a).load(builderUrl.build());
        ResponseBody responseBodyBody = responseLoad.body();
        if (!responseLoad.isSuccessful()) {
            responseBodyBody.close();
            throw new ResponseException(responseLoad.code());
        }
        Response responseCacheResponse = responseLoad.cacheResponse();
        Picasso.LoadedFrom loadedFrom = Picasso.LoadedFrom.NETWORK;
        Picasso.LoadedFrom loadedFrom2 = Picasso.LoadedFrom.DISK;
        Picasso.LoadedFrom loadedFrom3 = responseCacheResponse == null ? loadedFrom : loadedFrom2;
        if (loadedFrom3 == loadedFrom2 && responseBodyBody.contentLength() == 0) {
            responseBodyBody.close();
            throw new ContentLengthException();
        }
        if (loadedFrom3 == loadedFrom && responseBodyBody.contentLength() > 0) {
            long jContentLength = responseBodyBody.contentLength();
            h.a aVar = this.f10481b.f19197b;
            aVar.sendMessage(aVar.obtainMessage(4, Long.valueOf(jContentLength)));
        }
        return new m.a(responseBodyBody.source(), loadedFrom3);
    }
}
