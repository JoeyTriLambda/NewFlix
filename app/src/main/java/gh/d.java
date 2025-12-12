package gh;

import java.io.Reader;
import java.io.StringReader;
import org.jsoup.nodes.Document;
import org.jsoup.parser.ParseErrorList;

/* compiled from: Parser.java */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final org.jsoup.parser.c f12847a;

    /* renamed from: b, reason: collision with root package name */
    public ParseErrorList f12848b;

    /* renamed from: c, reason: collision with root package name */
    public final c f12849c;

    public d(org.jsoup.parser.c cVar) {
        this.f12847a = cVar;
        this.f12849c = cVar.a();
    }

    public static d htmlParser() {
        return new d(new org.jsoup.parser.a());
    }

    public static Document parse(String str, String str2) {
        org.jsoup.parser.a aVar = new org.jsoup.parser.a();
        aVar.initialiseParse(new StringReader(str), str2, ParseErrorList.noTracking(), c.f12843c);
        aVar.runParser();
        return aVar.f17313c;
    }

    public static d xmlParser() {
        return new d(new org.jsoup.parser.d());
    }

    public boolean isTrackErrors() {
        return false;
    }

    public Document parseInput(String str, String str2) {
        this.f12848b = isTrackErrors() ? ParseErrorList.tracking(0) : ParseErrorList.noTracking();
        StringReader stringReader = new StringReader(str);
        ParseErrorList parseErrorList = this.f12848b;
        org.jsoup.parser.c cVar = this.f12847a;
        cVar.initialiseParse(stringReader, str2, parseErrorList, this.f12849c);
        cVar.runParser();
        return cVar.f17313c;
    }

    public Document parseInput(Reader reader, String str) {
        ParseErrorList parseErrorListTracking = isTrackErrors() ? ParseErrorList.tracking(0) : ParseErrorList.noTracking();
        this.f12848b = parseErrorListTracking;
        org.jsoup.parser.c cVar = this.f12847a;
        cVar.initialiseParse(reader, str, parseErrorListTracking, this.f12849c);
        cVar.runParser();
        return cVar.f17313c;
    }
}
