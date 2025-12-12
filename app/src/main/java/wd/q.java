package wd;

import android.os.AsyncTask;
import android.util.Log;
import flix.com.vision.activities.MovieDetailActivity;
import flix.com.vision.api.realdebrid.RealDebridCommon;
import flix.com.vision.helpers.Constants;
import flix.com.vision.models.torrent.AllTorrentsInfoDTO;
import flix.com.vision.models.torrent.RealDebridException;
import flix.com.vision.models.torrent.TorrentInfoDTO;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* compiled from: Torrentz2Movies.java */
/* loaded from: classes2.dex */
public final class q extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f21109a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f21110b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f21111c;

    public q(p pVar, String str, String str2) {
        this.f21111c = pVar;
        this.f21109a = str;
        this.f21110b = str2;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        String json;
        String str = this.f21109a;
        String str2 = this.f21110b;
        p pVar = this.f21111c;
        pVar.getClass();
        try {
            TorrentInfoDTO torrentInfoDTO = (TorrentInfoDTO) be.c.getObjectMapper().readValue(str, TorrentInfoDTO.class);
            int iSelectCorrectFileId = be.c.selectCorrectFileId(torrentInfoDTO);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("files", String.valueOf(iSelectCorrectFileId));
            be.c.postAndGetData("https://api.real-debrid.com/rest/1.0/torrents/selectFiles/" + str2, RealDebridCommon.f12047b, linkedHashMap);
            HttpURLConnection httpUrlConnection = be.c.getHttpUrlConnection(new URL("https://api.real-debrid.com/rest/1.0/torrents"), RealDebridCommon.f12047b);
            if (httpUrlConnection.getResponseCode() == 200 && (json = Constants.readJSON(httpUrlConnection.getInputStream())) != null) {
                ArrayList arrayList = new ArrayList();
                com.google.gson.l asJsonArray = com.google.gson.r.parseString(json).getAsJsonArray();
                for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
                    com.google.gson.q asJsonObject = asJsonArray.get(i10).getAsJsonObject();
                    AllTorrentsInfoDTO allTorrentsInfoDTO = new AllTorrentsInfoDTO();
                    allTorrentsInfoDTO.setHash(asJsonObject.get("hash").getAsString());
                    com.google.gson.l asJsonArray2 = asJsonObject.get("links").getAsJsonArray();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i11 = 0; i11 < asJsonArray2.size(); i11++) {
                        arrayList2.add(asJsonArray2.get(i11).getAsString());
                    }
                    allTorrentsInfoDTO.setLinks(arrayList2);
                    arrayList.add(allTorrentsInfoDTO);
                }
                String linkOfSelectedTorrentFromTorrentInfo = be.c.getLinkOfSelectedTorrentFromTorrentInfo(torrentInfoDTO, arrayList);
                hd.o oVar = new hd.o();
                oVar.f13044t = true;
                oVar.f13036b = torrentInfoDTO.getFilename();
                oVar.D = linkOfSelectedTorrentFromTorrentInfo;
                pVar.addLink(oVar);
                return null;
            }
            return null;
        } catch (RealDebridException e10) {
            Log.d(MovieDetailActivity.class.toString(), "", e10);
            return null;
        } catch (Exception e11) {
            Log.d(MovieDetailActivity.class.toString(), "", e11);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((q) str);
    }
}
