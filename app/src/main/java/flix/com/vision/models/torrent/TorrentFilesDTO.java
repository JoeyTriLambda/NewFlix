package flix.com.vision.models.torrent;

import ac.c;

/* loaded from: classes2.dex */
public class TorrentFilesDTO {
    private long bytes;

    /* renamed from: id, reason: collision with root package name */
    private int f12428id;
    private String path;
    private int selected;

    public long getBytes() {
        return this.bytes;
    }

    public int getId() {
        return this.f12428id;
    }

    public String getPath() {
        return this.path;
    }

    public int getSelected() {
        return this.selected;
    }

    public void setBytes(long j10) {
        this.bytes = j10;
    }

    public void setId(int i10) {
        this.f12428id = i10;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setSelected(int i10) {
        this.selected = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("TorrentFilesDTO{id=");
        sb2.append(this.f12428id);
        sb2.append(", path='");
        sb2.append(this.path);
        sb2.append("', bytes=");
        sb2.append(this.bytes);
        sb2.append(", selected=");
        return c.l(sb2, this.selected, '}');
    }
}
