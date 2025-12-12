package ch;

import dh.b;
import gh.d;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;

/* compiled from: Jsoup.java */
/* loaded from: classes2.dex */
public final class a {
    public static Connection connect(String str) {
        return b.connect(str);
    }

    public static Document parse(String str, String str2, d dVar) {
        return dVar.parseInput(str, str2);
    }

    public static Document parse(String str) {
        return d.parse(str, "");
    }
}
