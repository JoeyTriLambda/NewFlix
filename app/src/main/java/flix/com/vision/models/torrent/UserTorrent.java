package flix.com.vision.models.torrent;

import ac.c;
import fd.e;
import flix.com.vision.activities.LinksActivity;
import flix.com.vision.processors.english.BaseProcessor;
import hd.o;

/* loaded from: classes2.dex */
public class UserTorrent {
    public boolean clicked;
    public String download;
    public String file_id;
    public String file_size_label;
    public String filename;
    public long filesize;
    public String generated_time;
    public String host;
    public boolean is_all_debrid;
    public boolean is_premiumize;
    public boolean is_real_debrid;
    public String link;
    public String mimeType;
    public BaseProcessor.TorrentServiceType source_type;
    public String src;
    public String status;
    public boolean streamable;

    public o toVideoSource() {
        if (!this.streamable) {
            return null;
        }
        o oVar = new o();
        oVar.D = this.download;
        BaseProcessor.TorrentServiceType torrentServiceType = this.source_type;
        if (torrentServiceType == BaseProcessor.TorrentServiceType.REAL_DEBRID) {
            oVar.f13050z = true;
        }
        if (torrentServiceType == BaseProcessor.TorrentServiceType.PREMIUMIZE) {
            oVar.A = true;
        }
        oVar.f13047w = true;
        oVar.C = c.k("[PREMIUMIZE][USER TORRENT] [", e.readableFileSize(this.filesize), "]");
        oVar.f13043s = 1000;
        LinksActivity.setRDQtyLabel(oVar);
        return oVar;
    }
}
