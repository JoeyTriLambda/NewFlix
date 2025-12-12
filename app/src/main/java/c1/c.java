package c1;

import android.app.FragmentManager;
import android.content.ClipData;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.leanback.widget.f0;
import androidx.leanback.widget.m0;
import c1.d;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.encoders.EncodingException;
import com.google.gson.o;
import com.google.gson.q;
import com.loopj.android.http.AsyncHttpClient;
import com.unity3d.ads.metadata.MediationMetaData;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpStatus;
import d9.c;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.FilterActivity;
import flix.com.vision.activities.LinksActivity;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.UserTorrentsActivity;
import flix.com.vision.activities.leanback.FilterActivityLeanBack;
import flix.com.vision.activities.leanback.fragment.TVListFragmentMain;
import flix.com.vision.activities.player.AdultVideoPlayerActivity;
import flix.com.vision.activities.player.PlayerActivityLiveTV;
import flix.com.vision.api.alldebrid.AllDebridApiKeyEntryActivity;
import flix.com.vision.api.premiumize.PremApiKeyEntryActivity;
import flix.com.vision.models.Movie;
import flix.com.vision.utils.JsonUtils;
import h9.a;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import o4.b;
import p4.j;
import qd.k;
import qd.m;
import r8.a0;
import r8.p0;
import r9.n;
import se.f;
import v6.a;
import wd.i;
import x0.c;
import x0.j0;
import x4.h;
import y0.c;
import y4.p;
import y4.s;
import z4.a;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements d.c, v4.a, a.InterfaceC0331a, p.a, a.InterfaceC0296a, c.a, a.InterfaceC0161a, Continuation, n4.d, f, androidx.leanback.widget.c, Toolbar.h {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5006b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f5007m;

    public /* synthetic */ c(Object obj, int i10) {
        this.f5006b = i10;
        this.f5007m = obj;
    }

    public final boolean a(e eVar, int i10, Bundle bundle) {
        View view = (View) this.f5007m;
        if (Build.VERSION.SDK_INT >= 25 && (i10 & 1) != 0) {
            try {
                eVar.requestPermission();
                Parcelable parcelable = (Parcelable) eVar.unwrap();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e10) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e10);
                return false;
            }
        }
        return j0.performReceiveContent(view, new c.a(new ClipData(eVar.getDescription(), new ClipData.Item(eVar.getContentUri())), 2).setLinkUri(eVar.getLinkUri()).setExtras(bundle).build()) == null;
    }

    @Override // se.f
    public final void accept(Object obj) {
        String str;
        int i10 = this.f5006b;
        Object obj2 = this.f5007m;
        switch (i10) {
            case 16:
                FilterActivity filterActivity = (FilterActivity) obj2;
                ArrayList<Movie> listMovie = JsonUtils.parseListMovie((o) obj, filterActivity.L);
                int size = listMovie.size();
                ArrayList<Movie> arrayList = filterActivity.S;
                if (size > 0 && filterActivity.Y) {
                    arrayList.clear();
                    filterActivity.Y = false;
                } else if (listMovie.size() == 0) {
                    Toast.makeText(filterActivity.getBaseContext(), "No more result", 0).show();
                    filterActivity.f11659c0.setupMoreListener(null, 20);
                    filterActivity.f11665i0.notifyDataSetChanged();
                    break;
                }
                arrayList.addAll(App.getInstance().filterList(listMovie));
                if (arrayList.size() > listMovie.size()) {
                    filterActivity.f11665i0.notifyItemRangeChanged(arrayList.size() - 1, listMovie.size());
                } else {
                    filterActivity.f11665i0.notifyDataSetChanged();
                }
                if (listMovie.size() > 0 && arrayList.size() == 0) {
                    int i11 = filterActivity.f11667k0 + 1;
                    filterActivity.f11667k0 = i11;
                    filterActivity.d(i11);
                    break;
                }
                break;
            case 17:
                LinksActivity linksActivity = (LinksActivity) obj2;
                int i12 = LinksActivity.C0;
                linksActivity.getClass();
                q asJsonObject = ((o) obj).getAsJsonObject();
                if (asJsonObject.get("still_path").isJsonNull()) {
                    str = null;
                } else {
                    str = App.F + "original" + asJsonObject.get("still_path").getAsString();
                }
                String asString = !asJsonObject.get("overview").isJsonNull() ? asJsonObject.get("overview").getAsString() : null;
                String asString2 = asJsonObject.get(MediationMetaData.KEY_NAME).isJsonNull() ? null : asJsonObject.get(MediationMetaData.KEY_NAME).getAsString();
                if (!asJsonObject.get("runtime").isJsonNull()) {
                    linksActivity.f11695y0 = asJsonObject.get("runtime").getAsInt();
                }
                if (asString2 == null || asString2.isEmpty()) {
                    asString2 = "Episode ";
                } else {
                    linksActivity.f11694x0 = asString2;
                }
                String str2 = linksActivity.f11695y0 + "min  · aired on " + asJsonObject.get("air_date").getAsString();
                if (str != null && asString != null) {
                    try {
                        linksActivity.f(str, asString, asString2, str2);
                        break;
                    } catch (Exception unused) {
                        return;
                    }
                }
                break;
            case 18:
                MainActivity mainActivity = (MainActivity) obj2;
                int i13 = MainActivity.f11697v0;
                mainActivity.getClass();
                ArrayList<String> suggestions = JsonUtils.parseSuggestions((o) obj);
                mainActivity.f11698a0.clearSuggestions();
                mainActivity.f11698a0.addSuggestions(suggestions);
                break;
            case 19:
                int i14 = UserTorrentsActivity.X;
                break;
            case 20:
                FilterActivityLeanBack filterActivityLeanBack = (FilterActivityLeanBack) obj2;
                ArrayList<Movie> listMovie2 = JsonUtils.parseListMovie((o) obj, filterActivityLeanBack.L);
                int size2 = listMovie2.size();
                ArrayList<Movie> arrayList2 = filterActivityLeanBack.S;
                if (size2 > 0 && filterActivityLeanBack.Y) {
                    arrayList2.clear();
                    filterActivityLeanBack.Y = false;
                } else if (listMovie2.size() == 0) {
                    Toast.makeText(filterActivityLeanBack.getBaseContext(), "No more result", 0).show();
                    filterActivityLeanBack.f11907c0.setupMoreListener(null, 20);
                    filterActivityLeanBack.f11913i0.notifyDataSetChanged();
                    break;
                }
                arrayList2.addAll(App.getInstance().filterList(listMovie2));
                if (arrayList2.size() > listMovie2.size()) {
                    filterActivityLeanBack.f11913i0.notifyItemRangeChanged(arrayList2.size() - 1, listMovie2.size());
                } else {
                    filterActivityLeanBack.f11913i0.notifyDataSetChanged();
                }
                if (listMovie2.size() > 0 && arrayList2.size() == 0) {
                    int i15 = filterActivityLeanBack.f11915k0 + 1;
                    filterActivityLeanBack.f11915k0 = i15;
                    filterActivityLeanBack.d(i15);
                    break;
                }
                break;
            case 21:
            case 22:
            case 23:
            default:
                i iVar = (i) obj2;
                o oVar = (o) obj;
                if (!iVar.f21085h) {
                    q asJsonObject2 = oVar.getAsJsonObject();
                    String asString3 = asJsonObject2.get("id").getAsString();
                    String asString4 = asJsonObject2.get("uri").getAsString();
                    if (asString4 != null && asString4.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                        iVar.b(asString4, asString3);
                        break;
                    } else if (asString3 != null && asString3.length() > 0) {
                        iVar.b("https://api.real-debrid.com/rest/1.0/torrents/info/".concat(asString3), asString3);
                        break;
                    }
                }
                break;
            case 24:
                int i16 = AllDebridApiKeyEntryActivity.Q;
                kc.d dVar = ((AllDebridApiKeyEntryActivity) obj2).P;
                if (dVar != null) {
                    try {
                        dVar.dismiss();
                        break;
                    } catch (Exception unused2) {
                        return;
                    }
                }
                break;
            case 25:
                int i17 = PremApiKeyEntryActivity.Q;
                kc.d dVar2 = ((PremApiKeyEntryActivity) obj2).P;
                if (dVar2 != null) {
                    try {
                        dVar2.dismiss();
                        break;
                    } catch (Exception unused3) {
                        return;
                    }
                }
                break;
            case 26:
                k kVar = (k) obj2;
                kVar.getClass();
                String asString5 = ((o) obj).getAsJsonObject().get("link").getAsString();
                if (asString5 != null && asString5.length() > 0) {
                    hd.o oVar2 = new hd.o();
                    oVar2.F = true;
                    oVar2.C = kVar.checkLinkLabel(asString5);
                    oVar2.D = asString5;
                    kVar.addLink(oVar2);
                    break;
                }
                break;
            case 27:
                m mVar = (m) obj2;
                mVar.getClass();
                String asString6 = ((o) obj).getAsJsonObject().get("link").getAsString();
                if (asString6 != null && asString6.length() > 0 && !asString6.contains("rabbitstream") && !asString6.contains("dokicloud")) {
                    hd.o oVar3 = new hd.o();
                    oVar3.F = true;
                    oVar3.C = mVar.checkLinkLabel(asString6);
                    oVar3.D = asString6;
                    mVar.addLink(oVar3);
                    break;
                }
                break;
            case 28:
                wd.f fVar = (wd.f) obj2;
                o oVar4 = (o) obj;
                if (!fVar.f21076k) {
                    q asJsonObject3 = oVar4.getAsJsonObject();
                    String asString7 = asJsonObject3.get("id").getAsString();
                    String asString8 = asJsonObject3.get("uri").getAsString();
                    if (asString8 != null && asString8.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                        fVar.b(asString8, asString7);
                        break;
                    } else if (asString7 != null && asString7.length() > 0) {
                        fVar.b("https://api.real-debrid.com/rest/1.0/torrents/info/".concat(asString7), asString7);
                        break;
                    }
                }
                break;
        }
    }

    @Override // y4.p.a, n4.d
    public final Object apply(Object obj) throws IOException {
        int i10 = this.f5006b;
        Object obj2 = this.f5007m;
        switch (i10) {
            case 1:
                o4.b bVar = (o4.b) obj2;
                b.a aVar = (b.a) obj;
                bVar.getClass();
                u4.a.i("CctTransportBackend", "Making request to: %s", aVar.f17008a);
                HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f17008a.openConnection();
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(bVar.f17007g);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "3.1.9"));
                httpURLConnection.setRequestProperty("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                String str = aVar.f17010c;
                if (str != null) {
                    httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
                }
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    try {
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                        try {
                            ((c.a) bVar.f17001a).encode(aVar.f17009b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                            gZIPOutputStream.close();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            int responseCode = httpURLConnection.getResponseCode();
                            u4.a.i("CctTransportBackend", "Status Code: %d", Integer.valueOf(responseCode));
                            u4.a.d("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                            u4.a.d("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                            if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                                return new b.C0210b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                            }
                            if (responseCode != 200) {
                                return new b.C0210b(responseCode, null, 0L);
                            }
                            InputStream inputStream = httpURLConnection.getInputStream();
                            try {
                                InputStream gZIPInputStream = AsyncHttpClient.ENCODING_GZIP.equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                                try {
                                    b.C0210b c0210b = new b.C0210b(responseCode, null, j.fromJson(new BufferedReader(new InputStreamReader(gZIPInputStream))).getNextRequestWaitMillis());
                                    if (gZIPInputStream != null) {
                                        gZIPInputStream.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    return c0210b;
                                } finally {
                                }
                            } catch (Throwable th2) {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable th3) {
                                        th2.addSuppressed(th3);
                                    }
                                }
                                throw th2;
                            }
                        } finally {
                        }
                    } catch (Throwable th4) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable th5) {
                                th4.addSuppressed(th5);
                            }
                        }
                        throw th4;
                    }
                } catch (EncodingException e10) {
                    e = e10;
                    u4.a.e("CctTransportBackend", "Couldn't encode request, returning with 400", e);
                    return new b.C0210b(HttpStatus.SC_BAD_REQUEST, null, 0L);
                } catch (ConnectException e11) {
                    e = e11;
                    u4.a.e("CctTransportBackend", "Couldn't open connection, returning with 500", e);
                    return new b.C0210b(500, null, 0L);
                } catch (UnknownHostException e12) {
                    e = e12;
                    u4.a.e("CctTransportBackend", "Couldn't open connection, returning with 500", e);
                    return new b.C0210b(500, null, 0L);
                } catch (IOException e13) {
                    e = e13;
                    u4.a.e("CctTransportBackend", "Couldn't encode request, returning with 400", e);
                    return new b.C0210b(HttpStatus.SC_BAD_REQUEST, null, 0L);
                }
            case 8:
                Map map = (Map) obj2;
                Cursor cursor = (Cursor) obj;
                n4.b bVar2 = p.f21888q;
                while (cursor.moveToNext()) {
                    long j10 = cursor.getLong(0);
                    Set hashSet = (Set) map.get(Long.valueOf(j10));
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        map.put(Long.valueOf(j10), hashSet);
                    }
                    hashSet.add(new p.b(cursor.getString(1), cursor.getString(2)));
                }
                return null;
            default:
                int i11 = r9.e.f18858b;
                ((r9.e) obj2).getClass();
                String strEncode = ((c.a) n.f18878a.getSESSION_EVENT_ENCODER$com_google_firebase_firebase_sessions()).encode((r9.m) obj);
                zf.i.checkNotNullExpressionValue(strEncode, "SessionEvents.SESSION_EVENT_ENCODER.encode(value)");
                Log.d("EventGDTLogger", "Session Event: " + strEncode);
                byte[] bytes = strEncode.getBytes(ig.c.f13440b);
                zf.i.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                return bytes;
        }
    }

    public final void b(f0.a aVar, Object obj, m0.b bVar, Object obj2) {
        flix.com.vision.activities.leanback.fragment.a aVar2 = ((TVListFragmentMain) this.f5007m).O0;
        if (aVar2 != null) {
            if (obj instanceof Movie) {
                aVar2.onMovieClicked((Movie) obj);
            } else if (obj instanceof ld.a) {
                aVar2.onNetworkClicked((ld.a) obj);
            }
        }
    }

    public final void c(boolean z10) {
        v7.k kVar = (v7.k) this.f5007m;
        AutoCompleteTextView autoCompleteTextView = kVar.f20547h;
        if (autoCompleteTextView != null) {
            if (autoCompleteTextView.getInputType() != 0) {
                return;
            }
            j0.setImportantForAccessibility(kVar.f20561d, z10 ? 2 : 1);
        }
    }

    public final Object d() {
        int i10 = this.f5006b;
        Object obj = this.f5007m;
        switch (i10) {
            case 6:
                return ((s) obj).getWritableDatabase();
            default:
                n4.b bVar = p.f21888q;
                ((SQLiteDatabase) obj).beginTransaction();
                return null;
        }
    }

    public final void e(Canvas canvas) {
        super/*android.widget.FrameLayout*/.dispatchDraw(canvas);
    }

    @Override // z4.a.InterfaceC0331a
    public final Object execute() {
        int i10 = this.f5006b;
        Object obj = this.f5007m;
        switch (i10) {
            case 2:
                return Integer.valueOf(((y4.d) obj).cleanUp());
            case 3:
                ((h) obj).f21539i.resetClientMetrics();
                return null;
            case 4:
                return ((y4.c) obj).loadClientMetrics();
            default:
                x4.j jVar = (x4.j) obj;
                Iterator<q4.o> it = jVar.f21550b.loadActiveContexts().iterator();
                while (it.hasNext()) {
                    jVar.f21551c.schedule(it.next(), 1);
                }
                return null;
        }
    }

    @Override // h9.a.InterfaceC0161a
    public final void handle(h9.b bVar) {
        int i10 = this.f5006b;
        Object obj = this.f5007m;
        switch (i10) {
            case 11:
                o8.b bVar2 = (o8.b) obj;
                bVar2.getClass();
                o8.e.getLogger().d("Crashlytics native component now available.");
                bVar2.f17040b.set((o8.a) bVar.get());
                break;
            default:
                ((p9.a) bVar.get()).registerRolloutsStateSubscriber("firebase", (o8.c) obj);
                o8.e.getLogger().d("Registering RemoteConfig Rollouts subscriber");
                break;
        }
    }

    @Override // androidx.appcompat.widget.Toolbar.h
    public final boolean onMenuItemClick(MenuItem menuItem) {
        int i10 = this.f5006b;
        Object obj = this.f5007m;
        switch (i10) {
            case 22:
                AdultVideoPlayerActivity adultVideoPlayerActivity = (AdultVideoPlayerActivity) obj;
                int i11 = AdultVideoPlayerActivity.f11962b0;
                adultVideoPlayerActivity.getClass();
                if (menuItem.getItemId() == R.id.action_related_videos) {
                    try {
                        adultVideoPlayerActivity.N.scrollToPosition(0);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                    if (adultVideoPlayerActivity.M.getVisibility() == 0) {
                        adultVideoPlayerActivity.g();
                    } else {
                        adultVideoPlayerActivity.h();
                    }
                }
                if (menuItem.getItemId() == R.id.aspect_ratio_button) {
                    adultVideoPlayerActivity.S.setScaleType();
                    break;
                }
                break;
            default:
                PlayerActivityLiveTV playerActivityLiveTV = (PlayerActivityLiveTV) obj;
                int i12 = PlayerActivityLiveTV.f11967a0;
                playerActivityLiveTV.getClass();
                if (menuItem.getItemId() != R.id.action_episodes) {
                    if (menuItem.getItemId() == R.id.action_close) {
                        if (playerActivityLiveTV.O.getVisibility() != 0) {
                            FragmentManager fragmentManager = playerActivityLiveTV.getFragmentManager();
                            kc.d dVarNewInstance = kc.d.newInstance(playerActivityLiveTV, true);
                            dVarNewInstance.setTitle("Exit");
                            dVarNewInstance.setMessage("Do you really want to stop playback and exit ?");
                            dVarNewInstance.setButton1("CANCEL", new zb.c());
                            dVarNewInstance.setButton2("YES", new zb.d(playerActivityLiveTV));
                            try {
                                dVarNewInstance.show(fragmentManager, "");
                                break;
                            } catch (Exception e11) {
                                e11.printStackTrace();
                                break;
                            }
                        } else {
                            playerActivityLiveTV.O.startAnimation(playerActivityLiveTV.R);
                            playerActivityLiveTV.O.setVisibility(8);
                            break;
                        }
                    }
                } else {
                    try {
                        playerActivityLiveTV.P.scrollToPosition(playerActivityLiveTV.S);
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                    playerActivityLiveTV.O.setVisibility(0);
                    playerActivityLiveTV.O.startAnimation(playerActivityLiveTV.Q);
                    playerActivityLiveTV.P.requestFocus();
                    break;
                }
                break;
        }
        return true;
        return false;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        boolean z10;
        int i10 = this.f5006b;
        Object obj = this.f5007m;
        switch (i10) {
            case 13:
                ((r8.m0) obj).getClass();
                if (task.isSuccessful()) {
                    a0 a0Var = (a0) task.getResult();
                    o8.e.getLogger().d("Crashlytics report successfully enqueued to DataTransport: " + a0Var.getSessionId());
                    File reportFile = a0Var.getReportFile();
                    if (reportFile.delete()) {
                        o8.e.getLogger().d("Deleted report file: " + reportFile.getPath());
                    } else {
                        o8.e.getLogger().w("Crashlytics could not delete report file: " + reportFile.getPath());
                    }
                    z10 = true;
                } else {
                    o8.e.getLogger().w("Crashlytics report could not be enqueued to DataTransport", task.getException());
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            default:
                ExecutorService executorService = p0.f18742a;
                ((CountDownLatch) obj).countDown();
                return null;
        }
    }
}
