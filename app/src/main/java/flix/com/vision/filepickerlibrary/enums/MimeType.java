package flix.com.vision.filepickerlibrary.enums;

import org.adblockplus.libadblockplus.HttpClient;

/* loaded from: classes2.dex */
public enum MimeType {
    /* JADX INFO: Fake field, exist only in values array */
    JPEG("image/jpeg"),
    /* JADX INFO: Fake field, exist only in values array */
    PNG("image/png"),
    /* JADX INFO: Fake field, exist only in values array */
    XML("application/xml"),
    /* JADX INFO: Fake field, exist only in values array */
    XLS("application/vnd.ms-excel"),
    /* JADX INFO: Fake field, exist only in values array */
    XLSX("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
    /* JADX INFO: Fake field, exist only in values array */
    DOC("application/msword"),
    /* JADX INFO: Fake field, exist only in values array */
    DOCX("application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
    /* JADX INFO: Fake field, exist only in values array */
    HTML(HttpClient.MIME_TYPE_TEXT_HTML),
    /* JADX INFO: Fake field, exist only in values array */
    TXT("text/plain"),
    /* JADX INFO: Fake field, exist only in values array */
    PDF("application/pdf");


    /* renamed from: b, reason: collision with root package name */
    public final String f12308b;

    MimeType(String str) {
        this.f12308b = str;
    }

    public String getMimeType() {
        return this.f12308b;
    }
}
