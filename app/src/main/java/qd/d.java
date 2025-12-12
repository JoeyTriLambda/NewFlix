package qd;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import flix.com.vision.App;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import flix.com.vision.tv.Constant;
import java.util.ArrayList;

/* compiled from: AnimeProcessor.java */
/* loaded from: classes2.dex */
public final class d extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Context f18089f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList<hd.o> f18090g;

    public d(Context context, gd.f fVar, Movie movie) {
        this.f18089f = context;
        this.f12431b = fVar;
        this.f18090g = new ArrayList<>();
        SharedPreferences sharedPreferences = App.getInstance().f11574v;
        String str = Constant.f12450b;
        this.f12433d = sharedPreferences.getString("anime_domain", "gogoanime.pe");
    }

    public void Process(String str) {
        new c(this, str.replace("www9.gogoanime.io", this.f12433d).replace("gogoanime.io", this.f12433d)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
