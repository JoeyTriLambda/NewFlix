package ga;

import okhttp3.ResponseBody;
import qf.c;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/* compiled from: ApiService.kt */
/* loaded from: classes.dex */
public interface a {
    @GET
    Object getNewConfiguration(@Url String str, c<? super ResponseBody> cVar);

    @POST
    Object registerMyDevice(@Url String str, c<? super String> cVar);
}
