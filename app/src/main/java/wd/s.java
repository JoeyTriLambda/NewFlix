package wd;

import a2.x;
import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.App;
import flix.com.vision.api.realdebrid.RealDebridCommon;
import flix.com.vision.helpers.Constants;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: Torrentz2Series.java */
/* loaded from: classes2.dex */
public final class s extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f21114f;

    /* renamed from: i, reason: collision with root package name */
    public int f21117i;

    /* renamed from: j, reason: collision with root package name */
    public int f21118j;

    /* renamed from: k, reason: collision with root package name */
    public String f21119k;

    /* renamed from: g, reason: collision with root package name */
    public final String f21115g = "https://torrentz2.nz";

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f21116h = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public boolean f21120l = false;

    /* compiled from: Torrentz2Series.java */
    public class a extends d4.m {
        public a(String str, x xVar, pd.a aVar) {
            super(0, str, xVar, aVar);
        }

        @Override // com.android.volley.Request
        public Map<String, String> getHeaders() {
            return ac.c.w("authorization", RealDebridCommon.f12049n + StringUtils.SPACE + RealDebridCommon.f12047b);
        }
    }

    public s(Context context, Movie movie, gd.f fVar) {
        this.f21114f = movie;
        this.f12431b = fVar;
        EventBus.getDefault().register(this);
    }

    public final void b(String str, String str2) {
        App.getInstance().getRequestQueue().add(new a(str, new x(19, this, str2), new pd.a(22)));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Constants.a aVar) {
        this.f21120l = true;
        EventBus.getDefault().unregister(this);
    }

    public void process(int i10, int i11, int i12) {
        if (i12 > 1) {
            this.f12430a = 8;
        }
        this.f21117i = i10;
        this.f21118j = i11;
        if (this.f21120l) {
            return;
        }
        this.f21119k = "S" + be.f.formatSeasonnumber(this.f21117i) + "E" + be.f.formatSeasonnumber(this.f21118j);
        new r(this, ac.c.B(ac.c.o(new StringBuilder(), this.f21115g, "/search?q="), be.f.removeSpecialCharsKeepSpace(this.f21114f.getTitle().replace("&", "") + StringUtils.SPACE + this.f21119k).replace(StringUtils.SPACE, "+"))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
