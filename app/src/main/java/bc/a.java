package bc;

import android.content.Context;
import com.google.gson.o;
import flix.com.vision.api.alldebrid.AllDebridCommon;
import flix.com.vision.helpers.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import ne.k;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Call;

/* compiled from: FVMovieApi.java */
/* loaded from: classes2.dex */
public final class a {
    public static k<o> addMagnetAllDebrid(List<String> list) {
        HashMap map = new HashMap();
        map.put("apikey", AllDebridCommon.f12044o);
        map.put("agent", "flixvision");
        return c.getInstanceAllDebridAPI().addMagnetsAllDebrid(map, list);
    }

    public static k<o> deleteMagnetAllDebrid(String str) {
        HashMap map = new HashMap();
        map.put("apikey", AllDebridCommon.f12044o);
        map.put("agent", "flixvision");
        map.put("id", str);
        return c.getInstanceAllDebridAPI().deleteMagnetsAllDebrid(map);
    }

    public static k<Void> deleteMagnetRealDebrid(String str, String str2, String str3) {
        return c.getInstanceDebrid().deleteMagnetsRealDebrid(str, str2 + StringUtils.SPACE + str3);
    }

    public static Call<String> get123MoviesGoSeriesEpisodeServers(String str, String str2) {
        return c.getInstanceHDO(str).get123MoviesGoSeriesEpisodesServers(str2);
    }

    public static Call<String> get123MoviesGoSeriesSeasonEpisodes(String str, String str2) {
        return c.getInstanceHDO(str).get123MoviesGoSeriesSeasonEpisodes(str2);
    }

    public static Call<String> get123MoviesGoSeriesSeasons(String str, String str2) {
        return c.getInstanceHDO(str).get123MoviesGoSeriesSeasons(str2);
    }

    public static k<o> getAdultCategories() {
        return c.getRequest(Constants.f12319a).getAdultCategories(new HashMap());
    }

    public static k<o> getAllDebridUserAccount(String str) {
        HashMap mapW = ac.c.w("apikey", str);
        HashSet hashSet = AllDebridCommon.f12041b;
        mapW.put("agent", "flixvision");
        return c.getInstanceAllDebridAPI().loginAllDebrid(mapW);
    }

    public static k<o> getAllMagnetAllDebrid() {
        HashMap map = new HashMap();
        map.put("apikey", AllDebridCommon.f12044o);
        map.put("agent", "flixvision");
        return c.getInstanceAllDebridAPI().getMagnetStatusAllDebrid(map);
    }

    public static k<o> getCast(Context context, String str, long j10) {
        return c.getRequestTmdb().getCasts(str, String.valueOf(j10), ac.c.x("api_key", "2f3cb5763db1117fcba3948632f8aad9", "language", "en-US"));
    }

    public static k<o> getCollection(long j10) {
        HashMap mapX = ac.c.x("api_key", "2f3cb5763db1117fcba3948632f8aad9", "language", "en-US");
        mapX.put("append_to_response", "external_ids");
        return c.getRequestTmdb().getCollection(String.valueOf(j10), mapX);
    }

    public static k<o> getDetailCast(Context context, String str, long j10, boolean z10) {
        HashMap mapX = ac.c.x("api_key", "2f3cb5763db1117fcba3948632f8aad9", "language", "en-US");
        mapX.put("include_adult", Boolean.toString(z10));
        return c.getRequestTmdb().getDetailCast(String.valueOf(j10), str, mapX);
    }

    public static k<o> getDetails(Context context, String str, long j10) {
        HashMap mapX = ac.c.x("api_key", "2f3cb5763db1117fcba3948632f8aad9", "language", "en-US");
        mapX.put("append_to_response", "external_ids");
        return c.getRequestTmdb().getDetails(str, String.valueOf(j10), mapX);
    }

    public static k<o> getEpisode(Context context, String str, String str2, String str3) {
        return c.getRequestTmdb().getEpisode(str, str2, str3, ac.c.x("api_key", "2f3cb5763db1117fcba3948632f8aad9", "language", "en-US"));
    }

    public static k<o> getItemsByGenres(Context context, String str, int i10, int i11, String str2, String str3, int i12, String str4) {
        String str5 = i11 == 0 ? "movie" : "tv";
        HashMap mapX = ac.c.x("api_key", "2f3cb5763db1117fcba3948632f8aad9", "language", "en-US");
        mapX.put("include_adult", Boolean.toString(false));
        mapX.put("include_video", Boolean.toString(false));
        if (i12 != -1) {
            if (i12 == 999) {
                mapX.put("with_origin_country", "IN");
            } else if (i12 == 9999) {
                mapX.put("with_companies", "420|19551|38679|2301|13252");
            } else if (i11 == 0) {
                mapX.put("with_watch_providers", String.valueOf(ld.a.getProviderId(i12)));
            } else {
                mapX.put("with_networks", String.valueOf(i12));
            }
        }
        if (str2 != null) {
            if (i11 == 1) {
                mapX.put("first_air_date_year", str2);
            } else {
                mapX.put("primary_release_year", str2);
            }
        }
        mapX.put("sort_by", str3);
        if (!str.equals("-1") && !str.equals("0")) {
            mapX.put("with_genres", str);
        }
        mapX.put("page", String.valueOf(i10));
        return c.getRequestTmdb().getDiscover(str5, mapX);
    }

    public static k<o> getItemsByGenresLeanBack(Context context, String str, int i10, int i11, String str2, boolean z10) {
        String str3 = i11 == 0 ? "movie" : "tv";
        HashMap mapX = ac.c.x("api_key", "2f3cb5763db1117fcba3948632f8aad9", "language", "en-US");
        mapX.put("sort_by", str2);
        mapX.put("include_adult", Boolean.toString(false));
        mapX.put("include_video", Boolean.toString(false));
        if (!str.equals("-1")) {
            mapX.put("with_genres", str);
        }
        mapX.put("page", String.valueOf(i10));
        return c.getRequestTmdb().getDiscover(str3, mapX);
    }

    public static k<o> getLinkRealDebrid(String str, String str2, String str3) {
        HashMap mapW = ac.c.w("link", str);
        return c.getInstanceDebrid().getLinkRealDebrid(mapW, str2 + StringUtils.SPACE + str3);
    }

    public static k<o> getLinks123MoviesGo(String str, String str2) {
        return c.getInstanceFlix(str).get123MoviesGo(str2);
    }

    public static Call<String> getLinks123MoviesGoMeta(String str, String str2) {
        return c.getInstanceHDO(str).get123MoviesGoMeta(str2);
    }

    public static k<o> getListEpisode(Context context, String str, String str2) {
        return c.getRequestTmdb().getListEpisode(str, str2, ac.c.x("api_key", "2f3cb5763db1117fcba3948632f8aad9", "language", "en-US"));
    }

    public static k<o> getMagnetStatusAllDebrid(String str) {
        HashMap map = new HashMap();
        map.put("apikey", AllDebridCommon.f12044o);
        map.put("agent", "flixvision");
        map.put("id", str + "");
        return c.getInstanceAllDebridAPI().getMagnetStatusAllDebrid(map);
    }

    public static k<o> getMagnetsRealDebridAll(String str, String str2, int i10) {
        HashMap map = new HashMap();
        map.put("limit", i10 + "");
        return c.getInstanceDebrid().getMagnetsRealDebrid(map, str + StringUtils.SPACE + str2);
    }

    public static k<o> getMagnetsRealDebridLatest(String str, String str2, int i10) {
        HashMap map = new HashMap();
        map.put("limit", i10 + "");
        return c.getInstanceDebrid().getMagnetsRealDebrid(map, str + StringUtils.SPACE + str2);
    }

    public static k<o> getPremUserAccount(String str) {
        return c.getInstancePremiumizeAPI().loginPremiumize(ac.c.w("apikey", str));
    }

    public static k<o> getRating(Context context, String str, long j10) {
        return c.getRequestTmdb().getRating(str, String.valueOf(j10), ac.c.x("api_key", "2f3cb5763db1117fcba3948632f8aad9", "language", "en-US"));
    }

    public static k<o> getRatingSeries(Context context, String str, long j10) {
        return c.getRequestTmdb().getRatingSeries(str, String.valueOf(j10), ac.c.x("api_key", "2f3cb5763db1117fcba3948632f8aad9", "language", "en-US"));
    }

    public static k<o> getRealDebridUserAccount(String str, String str2) {
        return c.getInstanceDebrid().getUserRealDebrid(str + StringUtils.SPACE + str2);
    }

    public static k<o> getSeeAlso(Context context, int i10, long j10) {
        HashMap mapX = ac.c.x("api_key", "2f3cb5763db1117fcba3948632f8aad9", "language", "en-US");
        mapX.put("include_adult", Boolean.toString(false));
        mapX.put("include_video", Boolean.toString(false));
        mapX.put("page", "1");
        return c.getRequestTmdb().getSeeAlso(i10 == 0 ? "movie" : "tv", String.valueOf(j10), mapX);
    }

    public static k<o> getStreamingServices(Context context, String str, long j10) {
        return c.getRequestTmdb().getStreamingServices(str, String.valueOf(j10), ac.c.w("api_key", "2f3cb5763db1117fcba3948632f8aad9"));
    }

    public static k<o> getSuggest(Context context, String str) {
        HashMap mapX = ac.c.x("client", "youtube", "ds", "yt");
        mapX.put("q", str);
        return c.getInstanceFlix("http://suggestqueries.google.com").getSuggestSearchGoogle(mapX);
    }

    public static k<o> getTorrent(String str, String str2, String str3) {
        HashMap mapW = ac.c.w("magnet", str);
        return c.getInstanceDebrid().getLinkRealDebridTorrent(mapW, str2 + StringUtils.SPACE + str3);
    }

    public static k<o> getTrailer(Context context, String str, long j10) {
        return c.getRequestTmdb().getTrailer(str, String.valueOf(j10), ac.c.w("api_key", "2f3cb5763db1117fcba3948632f8aad9"));
    }

    public static k<o> getUserTorrentPrem(String str) {
        return c.getInstancePremiumizeAPI().getUserTorrentsPrem(ac.c.w("apikey", str));
    }

    public static k<o> gettabbedList(Context context, int i10, String str, int i11) {
        HashMap mapX = ac.c.x("api_key", "2f3cb5763db1117fcba3948632f8aad9", "language", "en-US");
        mapX.put("include_video", Boolean.toString(false));
        mapX.put("include_adult", Boolean.toString(false));
        mapX.put("page", String.valueOf(i10));
        if (str == null || !str.equalsIgnoreCase("movie")) {
            if (str != null && str.equalsIgnoreCase("tv")) {
                if (i11 == 0) {
                    return c.getRequestTmdb().getTrending(str, mapX);
                }
                if (i11 == 1) {
                    return c.getRequestTmdb().getNowPlayingShows(mapX);
                }
                if (i11 == 2) {
                    return c.getRequestTmdb().getPopular(str, mapX);
                }
                if (i11 == 3) {
                    return c.getRequestTmdb().getTopRated(str, mapX);
                }
                if (i11 == 4) {
                    return c.getRequestTmdb().getAiringToday(str, mapX);
                }
            }
        } else {
            if (i11 == 0) {
                return c.getRequestTmdb().getTrending(str, mapX);
            }
            if (i11 == 1) {
                return c.getRequestTmdb().getNowPlayingMovies(mapX);
            }
            if (i11 == 2) {
                return c.getRequestTmdb().getPopular(str, mapX);
            }
            if (i11 == 3) {
                return c.getRequestTmdb().getTopRated(str, mapX);
            }
            if (i11 == 4) {
                return c.getRequestTmdb().getUpcoming(str, mapX);
            }
        }
        return c.getRequestTmdb().getTrending(str, mapX);
    }

    public static k<o> searchData(Context context, String str, int i10, String str2, boolean z10) {
        if (str == null) {
            str = "";
        }
        HashMap mapX = ac.c.x("api_key", "2f3cb5763db1117fcba3948632f8aad9", "language", "en-US");
        mapX.put("include_adult", Boolean.toString(false));
        mapX.put("include_video", Boolean.toString(false));
        mapX.put("page", String.valueOf(i10));
        mapX.put("query", str);
        return c.getRequestTmdb().searchData(str2, mapX);
    }

    public static k<o> searchDataMulti(Context context, String str, int i10, boolean z10) {
        if (str == null) {
            str = "";
        }
        HashMap mapX = ac.c.x("api_key", "2f3cb5763db1117fcba3948632f8aad9", "language", "en-US");
        mapX.put("page", String.valueOf(i10));
        mapX.put("query", str);
        mapX.put("include_adult", Boolean.toString(false));
        mapX.put("include_video", Boolean.toString(false));
        return c.getRequestTmdb().getSearchMulti(mapX);
    }

    public static k<o> searchPeople(Context context, String str, int i10) {
        if (str == null) {
            str = "";
        }
        HashMap mapX = ac.c.x("api_key", "2f3cb5763db1117fcba3948632f8aad9", "language", "en-US");
        mapX.put("page", String.valueOf(i10));
        mapX.put("query", str);
        mapX.put("include_adult", Boolean.toString(false));
        return c.getRequestTmdb().searchPeople(mapX);
    }

    public static k<o> unlockLinkAllDebrid(String str) {
        HashMap map = new HashMap();
        map.put("apikey", AllDebridCommon.f12044o);
        map.put("agent", "flixvision");
        map.put("link", str);
        return c.getInstanceAllDebridAPI().unlockLinkAllDebrid(map);
    }
}
