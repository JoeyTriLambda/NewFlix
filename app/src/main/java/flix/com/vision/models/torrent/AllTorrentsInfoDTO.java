package flix.com.vision.models.torrent;

import ac.c;
import java.util.List;

/* loaded from: classes2.dex */
public class AllTorrentsInfoDTO {
    private String added;
    private long bytes;
    private String ended;
    private String filename;
    private String hash;
    private String host;

    /* renamed from: id, reason: collision with root package name */
    private String f12427id;
    private List<String> links;
    private int progress;
    private int split;
    private String status;

    public String getAdded() {
        return this.added;
    }

    public long getBytes() {
        return this.bytes;
    }

    public String getEnded() {
        return this.ended;
    }

    public String getFilename() {
        return this.filename;
    }

    public String getHash() {
        return this.hash;
    }

    public String getHost() {
        return this.host;
    }

    public String getId() {
        return this.f12427id;
    }

    public List<String> getLinks() {
        return this.links;
    }

    public int getProgress() {
        return this.progress;
    }

    public int getSplit() {
        return this.split;
    }

    public String getStatus() {
        return this.status;
    }

    public void setAdded(String str) {
        this.added = str;
    }

    public void setBytes(long j10) {
        this.bytes = j10;
    }

    public void setEnded(String str) {
        this.ended = str;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setId(String str) {
        this.f12427id = str;
    }

    public void setLinks(List<String> list) {
        this.links = list;
    }

    public void setProgress(int i10) {
        this.progress = i10;
    }

    public void setSplit(int i10) {
        this.split = i10;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("AllTorrentsInfoDTO{id='");
        sb2.append(this.f12427id);
        sb2.append("', filename='");
        sb2.append(this.filename);
        sb2.append("', hash='");
        sb2.append(this.hash);
        sb2.append("', bytes=");
        sb2.append(this.bytes);
        sb2.append(", host='");
        sb2.append(this.host);
        sb2.append("', split=");
        sb2.append(this.split);
        sb2.append(", progress=");
        sb2.append(this.progress);
        sb2.append(", status='");
        sb2.append(this.status);
        sb2.append("', added='");
        sb2.append(this.added);
        sb2.append("', links=");
        sb2.append(this.links);
        sb2.append(", ended='");
        return c.o(sb2, this.ended, "'}");
    }
}
