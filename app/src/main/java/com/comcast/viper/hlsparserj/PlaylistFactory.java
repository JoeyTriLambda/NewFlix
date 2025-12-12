package com.comcast.viper.hlsparserj;

import com.comcast.viper.hlsparserj.tags.TagNames;
import com.comcast.viper.hlsparserj.v12.MasterPlaylistV12;
import com.comcast.viper.hlsparserj.v12.MediaPlaylistV12;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/* loaded from: classes.dex */
public class PlaylistFactory {

    /* renamed from: com.comcast.viper.hlsparserj.PlaylistFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$comcast$viper$hlsparserj$PlaylistVersion;

        static {
            int[] iArr = new int[PlaylistVersion.values().length];
            $SwitchMap$com$comcast$viper$hlsparserj$PlaylistVersion = iArr;
            try {
                iArr[PlaylistVersion.TWELVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$comcast$viper$hlsparserj$PlaylistVersion[PlaylistVersion.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        try {
            String str = TagNames.EXTXVERSION;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private static InputStream getPlaylistInputStream(CloseableHttpClient closeableHttpClient, URL url) throws IOException {
        CloseableHttpResponse closeableHttpResponseExecute = closeableHttpClient.execute(new HttpGet(url.toString()));
        if (closeableHttpResponseExecute == null) {
            throw new IOException("Request returned a null response");
        }
        if (closeableHttpResponseExecute.getStatusLine().getStatusCode() == 200) {
            return closeableHttpResponseExecute.getEntity().getContent();
        }
        closeableHttpResponseExecute.close();
        throw new IOException("Request returned a status code of " + closeableHttpResponseExecute.getStatusLine().getStatusCode());
    }

    private static AbstractPlaylist getVersionSpecificPlaylist(PlaylistParser playlistParser, PlaylistVersion playlistVersion) {
        int i10 = AnonymousClass1.$SwitchMap$com$comcast$viper$hlsparserj$PlaylistVersion[playlistVersion.ordinal()];
        return playlistParser.isMasterPlaylist() ? new MasterPlaylistV12(playlistParser.getTags()) : new MediaPlaylistV12(playlistParser.getTags());
    }

    public static AbstractPlaylist parsePlaylist(PlaylistVersion playlistVersion, InputStream inputStream) throws IOException {
        PlaylistParser playlistParser = new PlaylistParser();
        playlistParser.parse(inputStream);
        return getVersionSpecificPlaylist(playlistParser, playlistVersion);
    }

    public static AbstractPlaylist parsePlaylist(PlaylistVersion playlistVersion, String str) {
        PlaylistParser playlistParser = new PlaylistParser();
        playlistParser.parse(str);
        return getVersionSpecificPlaylist(playlistParser, playlistVersion);
    }

    public static AbstractPlaylist parsePlaylist(PlaylistVersion playlistVersion, URL url, int i10, int i11, int i12) throws IOException {
        RequestConfig.Builder socketTimeout = RequestConfig.custom().setConnectTimeout(i10).setConnectionRequestTimeout(i11).setSocketTimeout(i12);
        HttpClientBuilder httpClientBuilderCreate = HttpClientBuilder.create();
        httpClientBuilderCreate.setDefaultRequestConfig(socketTimeout.build());
        CloseableHttpClient closeableHttpClientBuild = httpClientBuilderCreate.build();
        PlaylistParser playlistParser = new PlaylistParser();
        try {
            playlistParser.parse(getPlaylistInputStream(closeableHttpClientBuild, url));
            closeableHttpClientBuild.close();
            return getVersionSpecificPlaylist(playlistParser, playlistVersion);
        } catch (Throwable th2) {
            closeableHttpClientBuild.close();
            throw th2;
        }
    }
}
