package ub;

import android.widget.Toast;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import cz.msebera.android.httpclient.HttpStatus;
import flix.com.vision.activities.LinksActivity;
import flix.com.vision.activities.UserTorrentsActivity;
import flix.com.vision.models.torrent.UserTorrent;
import flix.com.vision.processors.english.BaseProcessor;
import flix.com.vision.utils.JsonUtils;
import java.util.ArrayList;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class w2 implements se.f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20311b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ UserTorrentsActivity f20312m;

    public /* synthetic */ w2(UserTorrentsActivity userTorrentsActivity, int i10) {
        this.f20311b = i10;
        this.f20312m = userTorrentsActivity;
    }

    @Override // se.f
    public final void accept(Object obj) {
        int i10 = this.f20311b;
        String str = "";
        int i11 = 0;
        UserTorrentsActivity userTorrentsActivity = this.f20312m;
        switch (i10) {
            case 0:
                int i12 = UserTorrentsActivity.X;
                userTorrentsActivity.getClass();
                com.google.gson.l asJsonArray = ((com.google.gson.o) obj).getAsJsonArray();
                int i13 = 0;
                while (true) {
                    int size = asJsonArray.size();
                    ArrayList<UserTorrent> arrayList = userTorrentsActivity.K;
                    if (i13 >= size) {
                        if (arrayList.size() > 0) {
                            userTorrentsActivity.Q.notifyDataSetChanged();
                            break;
                        }
                    } else {
                        com.google.gson.q asJsonObject = asJsonArray.get(i13).getAsJsonObject();
                        UserTorrent userTorrent = new UserTorrent();
                        userTorrent.filesize = asJsonObject.get("bytes").getAsLong();
                        userTorrent.host = asJsonObject.get("host").getAsString();
                        userTorrent.file_id = asJsonObject.get("id").getAsString();
                        long j10 = userTorrent.filesize;
                        if (j10 > 1000000) {
                            userTorrent.file_size_label = fd.e.readableFileSize(j10);
                        }
                        userTorrent.status = asJsonObject.get("status").getAsString();
                        userTorrent.filename = asJsonObject.get("filename").getAsString();
                        userTorrent.source_type = BaseProcessor.TorrentServiceType.REAL_DEBRID;
                        String str2 = userTorrent.status;
                        if (str2 != null && !str2.equals("error")) {
                            com.google.gson.l asJsonArray2 = asJsonObject.get("links").getAsJsonArray();
                            if (asJsonArray2.size() > 0) {
                                userTorrent.src = asJsonArray2.get(0).getAsString();
                            }
                        }
                        arrayList.add(userTorrent);
                        i13++;
                    }
                }
                break;
            case 1:
                int i14 = UserTorrentsActivity.X;
                userTorrentsActivity.getClass();
                com.google.gson.q asJsonObject2 = ((com.google.gson.o) obj).getAsJsonObject();
                if (!asJsonObject2.get("status").getAsString().equals("success")) {
                    Toast.makeText(userTorrentsActivity, "Error getting torrent links from Premiumize Server", 0).show();
                    break;
                } else {
                    com.google.gson.l asJsonArray3 = asJsonObject2.get("transfers").getAsJsonArray();
                    while (true) {
                        int size2 = asJsonArray3.size();
                        ArrayList<UserTorrent> arrayList2 = userTorrentsActivity.K;
                        if (i11 >= size2) {
                            if (arrayList2.size() > 0) {
                                userTorrentsActivity.Q.notifyDataSetChanged();
                                break;
                            }
                        } else {
                            com.google.gson.q asJsonObject3 = asJsonArray3.get(i11).getAsJsonObject();
                            asJsonObject3.get("status").getAsString();
                            UserTorrent userTorrent2 = new UserTorrent();
                            userTorrent2.status = asJsonObject3.get("status").getAsString();
                            userTorrent2.file_id = asJsonObject3.get("id").getAsString();
                            userTorrent2.source_type = BaseProcessor.TorrentServiceType.PREMIUMIZE;
                            userTorrent2.src = asJsonObject3.get("src").getAsString();
                            userTorrent2.filename = asJsonObject3.get(MediationMetaData.KEY_NAME).getAsString();
                            userTorrent2.is_premiumize = true;
                            arrayList2.add(userTorrent2);
                            i11++;
                        }
                    }
                }
                break;
            case 2:
                int i15 = UserTorrentsActivity.X;
                userTorrentsActivity.getClass();
                com.google.gson.q asJsonObject4 = ((com.google.gson.o) obj).getAsJsonObject();
                String asString = asJsonObject4.get("status").getAsString();
                if (asString != null && asString.equals("success")) {
                    com.google.gson.l asJsonArray4 = asJsonObject4.get(JsonStorageKeyNames.DATA_KEY).getAsJsonObject().get("magnets").getAsJsonArray();
                    while (true) {
                        int size3 = asJsonArray4.size();
                        ArrayList<UserTorrent> arrayList3 = userTorrentsActivity.K;
                        if (i11 >= size3) {
                            if (arrayList3.size() > 0) {
                                userTorrentsActivity.Q.notifyDataSetChanged();
                                break;
                            }
                        } else {
                            com.google.gson.q asJsonObject5 = asJsonArray4.get(i11).getAsJsonObject();
                            long asLong = asJsonObject5.get("id").getAsLong();
                            String str3 = fd.e.readableFileSize(asJsonObject5.get("size").getAsLong());
                            String asString2 = asJsonObject5.get("filename").getAsString();
                            String asString3 = asJsonObject5.get("status").getAsString();
                            UserTorrent userTorrent3 = new UserTorrent();
                            userTorrent3.status = asString3;
                            userTorrent3.file_size_label = str3;
                            userTorrent3.file_id = asLong + "";
                            userTorrent3.source_type = BaseProcessor.TorrentServiceType.ALL_DEBRID;
                            userTorrent3.filename = asString2;
                            userTorrent3.is_all_debrid = true;
                            arrayList3.add(userTorrent3);
                            i11++;
                        }
                    }
                }
                break;
            case 3:
                com.google.gson.o oVar = (com.google.gson.o) obj;
                int i16 = UserTorrentsActivity.X;
                kc.d dVar = userTorrentsActivity.V;
                if (dVar != null) {
                    try {
                        dVar.dismiss();
                    } catch (Exception unused) {
                    }
                }
                hd.o rDVideo = JsonUtils.parseRDVideo(oVar);
                if (rDVideo != null) {
                    LinksActivity.setRDQtyLabel(rDVideo);
                }
                ArrayList<hd.o> arrayList4 = userTorrentsActivity.W;
                arrayList4.add(rDVideo);
                userTorrentsActivity.d(arrayList4);
                break;
            default:
                int i17 = UserTorrentsActivity.X;
                userTorrentsActivity.getClass();
                com.google.gson.q asJsonObject6 = ((com.google.gson.o) obj).getAsJsonObject();
                String asString4 = asJsonObject6.get("status").getAsString();
                if (asString4 != null && asString4.equals("success")) {
                    com.google.gson.q asJsonObject7 = asJsonObject6.get(JsonStorageKeyNames.DATA_KEY).getAsJsonObject();
                    String asString5 = asJsonObject7.get("link").getAsString();
                    long asLong2 = asJsonObject7.get("filesize").getAsLong();
                    if (asLong2 >= 100000000) {
                        if (asLong2 != 0 && asLong2 != -1) {
                            str = fd.e.readableFileSize(asLong2);
                        }
                        hd.o oVar2 = new hd.o();
                        oVar2.f13047w = true;
                        oVar2.C = ac.c.k("[ALLDEBRID] [FAST] [", str, "]");
                        oVar2.D = asString5;
                        oVar2.B = true;
                        LinksActivity.setRDQtyLabel(oVar2);
                        if (oVar2.f13043s == 0) {
                            oVar2.f13043s = HttpStatus.SC_MULTIPLE_CHOICES;
                        }
                        userTorrentsActivity.W.add(oVar2);
                        break;
                    }
                }
                break;
        }
    }
}
