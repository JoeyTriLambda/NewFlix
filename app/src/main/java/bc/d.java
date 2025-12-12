package bc;

import com.google.gson.o;
import java.util.List;
import java.util.Map;
import ne.k;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/* compiled from: iAPIMovieInterface.java */
/* loaded from: classes2.dex */
public interface d {
    @GET("/v4/magnet/upload")
    k<o> addMagnetsAllDebrid(@QueryMap Map<String, String> map, @Query("magnets[]") List<String> list);

    @GET("/v4/magnet/delete")
    k<o> deleteMagnetsAllDebrid(@QueryMap Map<String, String> map);

    @DELETE("/rest/1.0/torrents/delete/{id}")
    k<Void> deleteMagnetsRealDebrid(@Path("id") String str, @Header("authorization") String str2);

    @GET("/ajax/sources/{id}")
    k<o> get123MoviesGo(@Path("id") String str);

    @GET("/ajax/movie/episodes/{id}")
    Call<String> get123MoviesGoMeta(@Path("id") String str);

    @GET("/ajax/v2/episode/servers/{id}")
    Call<String> get123MoviesGoSeriesEpisodesServers(@Path("id") String str);

    @GET("/ajax/v2/season/episodes/{id}")
    Call<String> get123MoviesGoSeriesSeasonEpisodes(@Path("id") String str);

    @GET("ajax/v2/tv/seasons/{id}")
    Call<String> get123MoviesGoSeriesSeasons(@Path("id") String str);

    @Headers({"Content-Type:application/json"})
    @GET("/api/v1/adult")
    k<o> getAdultCategories(@QueryMap Map<String, String> map);

    @GET("/3/{type}/airing_today")
    k<o> getAiringToday(@Path("type") String str, @QueryMap Map<String, String> map);

    @GET("/3/{type}/{movie_id}/credits")
    k<o> getCasts(@Path("type") String str, @Path("movie_id") String str2, @QueryMap Map<String, String> map);

    @GET("/3/collection/{id}")
    k<o> getCollection(@Path("id") String str, @QueryMap Map<String, String> map);

    @GET("/3/person/{person_id}/{type}")
    k<o> getDetailCast(@Path("person_id") String str, @Path("type") String str2, @QueryMap Map<String, String> map);

    @GET("/3/{type}/{id}")
    k<o> getDetails(@Path("type") String str, @Path("id") String str2, @QueryMap Map<String, String> map);

    @GET("/3/discover/{type}")
    k<o> getDiscover(@Path("type") String str, @QueryMap Map<String, String> map);

    @GET("/3/tv/{tv_id}/season/{season_number}/episode/{episode_number}")
    k<o> getEpisode(@Path("tv_id") String str, @Path("season_number") String str2, @Path("episode_number") String str3, @QueryMap Map<String, String> map);

    @FormUrlEncoded
    @POST("/rest/1.0/unrestrict/link")
    k<o> getLinkRealDebrid(@FieldMap Map<String, String> map, @Header("authorization") String str);

    @FormUrlEncoded
    @POST("/rest/1.0/torrents/addMagnet")
    k<o> getLinkRealDebridTorrent(@FieldMap Map<String, String> map, @Header("authorization") String str);

    @GET("/3/tv/{tv_id}/season/{season_number}")
    k<o> getListEpisode(@Path("tv_id") String str, @Path("season_number") String str2, @QueryMap Map<String, String> map);

    @GET("/v4/magnet/status")
    k<o> getMagnetStatusAllDebrid(@QueryMap Map<String, String> map);

    @GET("/rest/1.0/torrents")
    k<o> getMagnetsRealDebrid(@QueryMap Map<String, String> map, @Header("authorization") String str);

    @GET("/3/movie/now_playing")
    k<o> getNowPlayingMovies(@QueryMap Map<String, String> map);

    @GET("/3/tv/on_the_air")
    k<o> getNowPlayingShows(@QueryMap Map<String, String> map);

    @GET("/3/{type}/popular")
    k<o> getPopular(@Path("type") String str, @QueryMap Map<String, String> map);

    @GET("/3/{type}/{id}/release_dates")
    k<o> getRating(@Path("type") String str, @Path("id") String str2, @QueryMap Map<String, String> map);

    @GET("/3/{type}/{id}/content_ratings")
    k<o> getRatingSeries(@Path("type") String str, @Path("id") String str2, @QueryMap Map<String, String> map);

    @GET("/3/search/multi")
    k<o> getSearchMulti(@QueryMap Map<String, String> map);

    @GET("/3/{type}/{movie_id}/recommendations")
    k<o> getSeeAlso(@Path("type") String str, @Path("movie_id") String str2, @QueryMap Map<String, String> map);

    @GET("/3/{type}/{movie_id}/watch/providers")
    k<o> getStreamingServices(@Path("type") String str, @Path("movie_id") String str2, @QueryMap Map<String, String> map);

    @GET("/complete/search")
    k<o> getSuggestSearchGoogle(@QueryMap Map<String, String> map);

    @GET("/3/{type}/top_rated")
    k<o> getTopRated(@Path("type") String str, @QueryMap Map<String, String> map);

    @GET("/3/{type}/{movie_id}/videos")
    k<o> getTrailer(@Path("type") String str, @Path("movie_id") String str2, @QueryMap Map<String, String> map);

    @GET("/3/trending/{media_type}/week")
    k<o> getTrending(@Path("media_type") String str, @QueryMap Map<String, String> map);

    @GET("/3/{type}/upcoming")
    k<o> getUpcoming(@Path("type") String str, @QueryMap Map<String, String> map);

    @GET("/rest/1.0/user")
    k<o> getUserRealDebrid(@Header("authorization") String str);

    @GET("/api/transfer/list")
    k<o> getUserTorrentsPrem(@QueryMap Map<String, String> map);

    @GET("/v4/user")
    k<o> loginAllDebrid(@QueryMap Map<String, String> map);

    @FormUrlEncoded
    @POST("/api/account/info")
    k<o> loginPremiumize(@FieldMap Map<String, String> map);

    @GET("/3/search/{type}")
    k<o> searchData(@Path("type") String str, @QueryMap Map<String, String> map);

    @GET("/3/search/person")
    k<o> searchPeople(@QueryMap Map<String, String> map);

    @GET("/v4/link/unlock")
    k<o> unlockLinkAllDebrid(@QueryMap Map<String, String> map);
}
