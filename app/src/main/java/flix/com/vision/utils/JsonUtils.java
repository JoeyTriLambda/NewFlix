package flix.com.vision.utils;

import ac.c;
import android.util.Log;
import androidx.annotation.Keep;
import be.f;
import ch.a;
import com.google.gson.l;
import com.google.gson.o;
import com.google.gson.q;
import com.google.gson.r;
import com.unity3d.ads.metadata.MediationMetaData;
import fd.e;
import flix.com.vision.App;
import flix.com.vision.models.Movie;
import hd.b;
import hd.g;
import hd.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@Keep
/* loaded from: classes2.dex */
public class JsonUtils {
    public static boolean availableOnStreamingServices(o oVar) {
        try {
            q asJsonObject = oVar.getAsJsonObject().get("results").getAsJsonObject();
            for (int i10 = 0; i10 < asJsonObject.size(); i10++) {
                if (asJsonObject.get("US").getAsJsonObject() != null || asJsonObject.get("GB").getAsJsonObject() != null || asJsonObject.get("CA").getAsJsonObject() != null) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static p getDirector(o oVar) {
        ArrayList arrayList = new ArrayList();
        l asJsonArray = oVar.getAsJsonObject().get("crew").getAsJsonArray();
        String str = "";
        for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
            q asJsonObject = asJsonArray.get(i10).getAsJsonObject();
            String asString = asJsonObject.get("job").getAsString();
            if (asString != null && asString.trim().equalsIgnoreCase("director")) {
                String asString2 = asJsonObject.get(MediationMetaData.KEY_NAME).getAsString();
                if (asString2 != null) {
                    str = asString2;
                }
                long asLong = asJsonObject.get("id").getAsLong();
                p pVar = new p();
                if (str.isEmpty()) {
                    str = "N/A";
                }
                pVar.setName(str);
                pVar.setId(asLong);
                arrayList.add(pVar);
            }
        }
        return (p) arrayList.get(0);
    }

    public static String getLogoPath(String str) {
        q asJsonObject = r.parseString(str).getAsJsonObject();
        if (asJsonObject == null) {
            return null;
        }
        new ArrayList();
        l asJsonArray = asJsonObject.getAsJsonObject().get("logos").getAsJsonArray();
        if (asJsonArray.size() > 0) {
            for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
                if (asJsonArray.get(i10).getAsJsonObject().get("iso_639_1").getAsString().equalsIgnoreCase("en")) {
                    return asJsonArray.get(i10).getAsJsonObject().get("file_path").getAsString();
                }
            }
        }
        return null;
    }

    public static String getWriters(o oVar) {
        String asString;
        l asJsonArray = oVar.getAsJsonObject().get("crew").getAsJsonArray();
        String strC = "";
        for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
            q asJsonObject = asJsonArray.get(i10).getAsJsonObject();
            String asString2 = asJsonObject.get("department").getAsString();
            if (asString2 != null && asString2.trim().equalsIgnoreCase("writing") && (asString = asJsonObject.get(MediationMetaData.KEY_NAME).getAsString()) != null) {
                strC = c.C(strC, asString, ", ");
            }
        }
        String strTrim = strC.trim();
        return (strTrim == null || strTrim.isEmpty()) ? "N/A" : strTrim.substring(0, strTrim.length() - 1);
    }

    public static String getYearSplit(String str) {
        return (f.isEmpty(str) || !str.contains("-")) ? "" : str.split("-")[0];
    }

    public static o parse(String str) {
        return r.parseString(str);
    }

    public static String parse123MoviesHubearch(o oVar, String str, String str2) {
        Document document = a.parse(oVar.getAsJsonObject().get("content").getAsString());
        if (str2 != null) {
            Iterator<Element> it = document.getElementsByClass("ss-title").iterator();
            while (it.hasNext()) {
                Element next = it.next();
                String strText = next.text();
                if (strText.contains("(") && strText.contains(str2) && strText.replace("-", "").contains(str.replace("-", ""))) {
                    return next.attr("href").replace(".html", "").trim();
                }
            }
        }
        Iterator<Element> it2 = document.getElementsByClass("ss-title").iterator();
        while (it2.hasNext()) {
            Element next2 = it2.next();
            if (next2.text().replace("-", "").equalsIgnoreCase(str.replace("-", ""))) {
                return next2.attr("href").replace(".html", "").trim();
            }
        }
        Iterator<Element> it3 = document.getElementsByClass("ss-title").iterator();
        while (it3.hasNext()) {
            Element next3 = it3.next();
            if (f.removeSpecialChars(next3.text()).equalsIgnoreCase(f.removeSpecialChars(str))) {
                return next3.attr("href").replace(".html", "").trim();
            }
        }
        return "";
    }

    public static ArrayList<id.a> parseAdultCategories(o oVar) {
        if (oVar == null) {
            return null;
        }
        ArrayList<id.a> arrayList = new ArrayList<>();
        l asJsonArray = oVar.getAsJsonObject().get("categories").getAsJsonArray();
        for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
            q asJsonObject = asJsonArray.get(i10).getAsJsonObject();
            String asString = asJsonObject.get("title").getAsString();
            String asString2 = asJsonObject.get("url").getAsString();
            String asString3 = asJsonObject.get("img_url").getAsString();
            id.a aVar = new id.a();
            aVar.f13360a = asString;
            aVar.f13362c = asString2;
            aVar.f13361b = asString3;
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public static ArrayList<b> parseCast(o oVar) {
        if (oVar == null) {
            return null;
        }
        l asJsonArray = oVar.getAsJsonObject().get("cast").getAsJsonArray();
        ArrayList<b> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
            q asJsonObject = asJsonArray.get(i10).getAsJsonObject();
            String asString = asJsonObject.get(MediationMetaData.KEY_NAME).getAsString();
            int asInt = asJsonObject.get("gender").getAsInt();
            String asString2 = asJsonObject.get("character").getAsString();
            long asLong = asJsonObject.get("id").getAsLong();
            String str = asJsonObject.get("profile_path").isJsonNull() ? null : App.F + "w185" + asJsonObject.get("profile_path").getAsString();
            b bVar = new b();
            bVar.setName(asString);
            bVar.setId(asLong);
            bVar.f12975c = asInt;
            bVar.f12974b = asString2;
            bVar.setImg_url(str);
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public static ArrayList<Movie> parseCastMovies(o oVar, int i10) {
        if (oVar == null) {
            return null;
        }
        l asJsonArray = oVar.getAsJsonObject().get("cast").getAsJsonArray();
        ArrayList<Movie> arrayList = new ArrayList<>();
        for (int i11 = 0; i11 < asJsonArray.size(); i11++) {
            arrayList.add(parseMovieData(asJsonArray.get(i11).getAsJsonObject(), i10));
        }
        return arrayList;
    }

    public static ArrayList<g> parseCategory(o oVar) {
        l asJsonArray;
        if (oVar == null || (asJsonArray = oVar.getAsJsonObject().get("genres").getAsJsonArray()) == null) {
            return null;
        }
        ArrayList<g> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
            int asInt = asJsonArray.get(i10).getAsJsonObject().get("id").getAsInt();
            String asString = asJsonArray.get(i10).getAsJsonObject().get(MediationMetaData.KEY_NAME).getAsString();
            if (asInt != 16) {
                g gVar = new g();
                gVar.f13006a = asInt;
                gVar.f13007b = asString;
                arrayList.add(gVar);
            }
        }
        return arrayList;
    }

    public static ArrayList<Movie> parseCollectionMovies(o oVar, int i10) {
        if (oVar == null) {
            return null;
        }
        l asJsonArray = oVar.getAsJsonObject().get("parts").getAsJsonArray();
        ArrayList<Movie> arrayList = new ArrayList<>();
        for (int i11 = 0; i11 < asJsonArray.size(); i11++) {
            arrayList.add(parseMovieData(asJsonArray.get(i11).getAsJsonObject(), i10));
        }
        return arrayList;
    }

    public static ArrayList<Movie> parseDirectorMovies(o oVar, int i10) {
        if (oVar == null) {
            return null;
        }
        l asJsonArray = oVar.getAsJsonObject().get("crew").getAsJsonArray();
        ArrayList<Movie> arrayList = new ArrayList<>();
        for (int i11 = 0; i11 < asJsonArray.size(); i11++) {
            q asJsonObject = asJsonArray.get(i11).getAsJsonObject();
            String asString = asJsonObject.get("job").getAsString();
            if (asString != null && asString.trim().equalsIgnoreCase("director")) {
                arrayList.add(parseMovieData(asJsonObject, i10));
            }
        }
        return arrayList;
    }

    public static String parseHDOSearch(o oVar, String str, String str2) {
        Document document = a.parse(oVar.getAsJsonObject().get("content").getAsString());
        Iterator<Element> it = document.getElementsByClass("ss-title").iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (next.text().equalsIgnoreCase(str)) {
                String str3 = next.attr("href").replace(".html", "").trim().split("-")[r2.length - 1];
                if (str2 == null) {
                    return str3;
                }
                try {
                    Iterator<Element> it2 = ((dh.b) a.connect(c.k("https://solarmoviehd.ru/ajax/movie_get_info/", str3, ".html"))).get().getElementsByClass("jtip-top").first().getElementsByClass("jt-info").iterator();
                    while (it2.hasNext()) {
                        String strTrim = it2.next().text().trim();
                        if (!strTrim.contains("min") && strTrim.length() > 0 && strTrim.equals(str2)) {
                            return str3;
                        }
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return str3;
                }
            }
        }
        Iterator<Element> it3 = document.getElementsByClass("ss-title").iterator();
        while (it3.hasNext()) {
            Element next2 = it3.next();
            if (f.removeSpecialChars(next2.text()).equalsIgnoreCase(f.removeSpecialChars(str))) {
                return next2.attr("href").replace(".html", "").trim().split("-")[r8.length - 1];
            }
        }
        return null;
    }

    public static ArrayList<hd.o> parseLinks(o oVar) {
        ArrayList<hd.o> arrayList = new ArrayList<>();
        l asJsonArray = oVar.getAsJsonArray();
        for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
            String asString = asJsonArray.get(i10).getAsJsonObject().get("urlvideo").getAsString();
            hd.o oVar2 = new hd.o();
            oVar2.D = asString;
            oVar2.f13047w = true;
            oVar2.C = md.a.checkLinkLabel(asString) + "- HQ";
            arrayList.add(oVar2);
        }
        return arrayList;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:5|(2:35|6)|(14:33|8|(1:10)(1:11)|(2:46|45)|37|16|(2:41|18)|21|39|22|(2:24|25)|30|47|45)(1:44)|15|37|16|(0)|21|39|22|(0)|30|47|45|3) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d7, code lost:
    
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d9, code lost:
    
        r4 = null;
        r11 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bf A[Catch: Exception -> 0x00d7, TRY_LEAVE, TryCatch #3 {Exception -> 0x00d7, blocks: (B:22:0x00a0, B:24:0x00bf), top: B:39:0x00a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<hd.f> parseListEpisode(com.google.gson.o r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: flix.com.vision.utils.JsonUtils.parseListEpisode(com.google.gson.o, boolean):java.util.ArrayList");
    }

    public static ArrayList<Movie> parseListMovie(o oVar, int i10) {
        if (oVar == null) {
            return null;
        }
        l asJsonArray = oVar.getAsJsonObject().get("results").getAsJsonArray();
        ArrayList<Movie> arrayList = new ArrayList<>();
        for (int i11 = 0; i11 < asJsonArray.size(); i11++) {
            try {
                arrayList.add(parseMovieSimple(asJsonArray.get(i11).getAsJsonObject(), i10));
            } catch (Exception unused) {
                Log.d("", "");
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0370 A[Catch: Exception -> 0x037c, TRY_LEAVE, TryCatch #12 {Exception -> 0x037c, blocks: (B:114:0x0366, B:116:0x0370), top: B:177:0x0366 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0172  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static flix.com.vision.models.Movie parseMovie(com.google.gson.q r41, int r42) {
        /*
            Method dump skipped, instructions count: 1038
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: flix.com.vision.utils.JsonUtils.parseMovie(com.google.gson.q, int):flix.com.vision.models.Movie");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3 A[Catch: Exception -> 0x00bd, TRY_LEAVE, TryCatch #0 {Exception -> 0x00bd, blocks: (B:27:0x00a9, B:29:0x00b3), top: B:47:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static flix.com.vision.models.Movie parseMovieData(com.google.gson.q r14, int r15) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: flix.com.vision.utils.JsonUtils.parseMovieData(com.google.gson.q, int):flix.com.vision.models.Movie");
    }

    public static jd.a parseMovieHindi(String str) {
        Matcher matcher = Pattern.compile("\\{.*?\\};").matcher(str);
        if (matcher.find()) {
            try {
                q asJsonObject = r.parseString(matcher.group(0).replace("pc =", "").replace("};", "}").trim()).getAsJsonObject();
                String asString = asJsonObject.get("file").getAsString();
                String asString2 = asJsonObject.get("key").getAsString();
                asJsonObject.get("host").getAsString();
                asJsonObject.get("href").getAsString();
                jd.a aVar = new jd.a();
                aVar.f14691b = asString;
                aVar.f14690a = asString2;
                return aVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static jd.a parseMovieHindi2(String str) {
        Matcher matcher = Pattern.compile("\\(.*?\\}\\);").matcher(str);
        if (matcher.find()) {
            try {
                q asJsonObject = r.parseString(matcher.group(0).replace("({", "{").replace(");", "").trim()).getAsJsonObject();
                String asString = asJsonObject.get("file").getAsString();
                String asString2 = asJsonObject.get("key").getAsString();
                asJsonObject.get("host").getAsString();
                asJsonObject.get("href").getAsString();
                jd.a aVar = new jd.a();
                aVar.f14691b = asString;
                aVar.f14690a = asString2;
                return aVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static jd.a parseMovieHindiSeries(String str) {
        Matcher matcher = Pattern.compile("\\(.*?\\}\\);").matcher(str);
        if (matcher.find()) {
            try {
                q asJsonObject = r.parseString(matcher.group(0).replace("({", "{").replace(");", "").trim()).getAsJsonObject();
                String asString = asJsonObject.get("file").getAsString();
                String asString2 = asJsonObject.get("key").getAsString();
                asJsonObject.get("host").getAsString();
                asJsonObject.get("href").getAsString();
                jd.a aVar = new jd.a();
                aVar.f14691b = asString;
                aVar.f14690a = asString2;
                return aVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static jd.a parseMovieHindiSeries2(String str) {
        Matcher matcher = Pattern.compile("\\{.*?\\};").matcher(str);
        if (matcher.find()) {
            try {
                q asJsonObject = r.parseString(matcher.group(0).replace("({", "{").replace(");", "").trim()).getAsJsonObject();
                String asString = asJsonObject.get("file").getAsString();
                String asString2 = asJsonObject.get("key").getAsString();
                asJsonObject.get("host").getAsString();
                asJsonObject.get("href").getAsString();
                jd.a aVar = new jd.a();
                aVar.f14691b = asString;
                aVar.f14690a = asString2;
                return aVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static Movie parseMovieInfo(o oVar, int i10) {
        return parseMovie(oVar.getAsJsonObject(), i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static flix.com.vision.models.Movie parseMovieMulti(com.google.gson.q r17) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: flix.com.vision.utils.JsonUtils.parseMovieMulti(com.google.gson.q):flix.com.vision.models.Movie");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0133 A[LOOP:0: B:43:0x012d->B:45:0x0133, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0197  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static flix.com.vision.models.Movie parseMovieSimple(com.google.gson.q r19, int r20) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: flix.com.vision.utils.JsonUtils.parseMovieSimple(com.google.gson.q, int):flix.com.vision.models.Movie");
    }

    private static ArrayList<Movie> parseMoviesFromKownfor(q qVar) {
        ArrayList<Movie> arrayList = new ArrayList<>();
        try {
            l asJsonArray = qVar.getAsJsonObject().get("known_for").getAsJsonArray();
            for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
                Movie movieMulti = parseMovieMulti(asJsonArray.get(i10).getAsJsonObject());
                if (movieMulti != null && !movieMulti.getTitle().toLowerCase(Locale.ROOT).trim().equals("gomorrah")) {
                    arrayList.add(movieMulti);
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static ArrayList<b> parsePeople(o oVar) {
        if (oVar == null) {
            return null;
        }
        l asJsonArray = oVar.getAsJsonObject().get("results").getAsJsonArray();
        ArrayList<b> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
            q asJsonObject = asJsonArray.get(i10).getAsJsonObject();
            b bVar = new b();
            String asString = asJsonObject.get(MediationMetaData.KEY_NAME).getAsString();
            String str = App.F + "w185" + asJsonObject.get("profile_path").getAsString();
            int asInt = asJsonObject.get("id").getAsInt();
            bVar.setName(asString);
            bVar.setId(asInt);
            bVar.setImg_url(str);
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public static ArrayList<jd.b> parsePlaylistHindi(l lVar) {
        ArrayList<jd.b> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < lVar.size(); i10++) {
            try {
                q asJsonObject = lVar.get(i10).getAsJsonObject();
                String asString = asJsonObject.get("file").getAsString();
                asJsonObject.get("id").getAsString();
                String asString2 = asJsonObject.get("title").getAsString();
                jd.b bVar = new jd.b();
                bVar.f14692a = asString;
                bVar.f14693b = asString2;
                arrayList.add(bVar);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public static ArrayList<jd.b> parsePlaylistHindiSeries(l lVar, int i10, int i11) {
        ArrayList<jd.b> arrayList = new ArrayList<>();
        for (int i12 = 0; i12 < lVar.size(); i12++) {
            try {
                q asJsonObject = lVar.get(i12).getAsJsonObject();
                if (asJsonObject.get("id").getAsString().equalsIgnoreCase(i10 + "")) {
                    l asJsonArray = asJsonObject.getAsJsonArray("folder");
                    for (int i13 = 0; i13 < asJsonArray.size(); i13++) {
                        q asJsonObject2 = asJsonArray.get(i13).getAsJsonObject();
                        if (asJsonObject2.get("episode").getAsString().equalsIgnoreCase(i11 + "")) {
                            l asJsonArray2 = asJsonObject2.get("folder").getAsJsonArray();
                            for (int i14 = 0; i14 < asJsonArray2.size(); i14++) {
                                try {
                                    q asJsonObject3 = asJsonArray2.get(i14).getAsJsonObject();
                                    String asString = asJsonObject3.get("file").getAsString();
                                    asJsonObject3.get("id").getAsString();
                                    String asString2 = asJsonObject3.get("title").getAsString();
                                    jd.b bVar = new jd.b();
                                    bVar.f14692a = asString;
                                    bVar.f14693b = asString2;
                                    arrayList.add(bVar);
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        }
        return arrayList;
    }

    public static hd.o parseRDVideo(o oVar) {
        if (oVar == null) {
            return null;
        }
        try {
            q asJsonObject = oVar.getAsJsonObject();
            String asString = asJsonObject.get("download").getAsString();
            String asString2 = asJsonObject.get("host").getAsString();
            String asString3 = asJsonObject.get("mimeType").getAsString();
            if (asString2 == null) {
                asString2 = "RD.NET";
            }
            int asInt = asJsonObject.get("streamable").getAsInt();
            long asLong = asJsonObject.get("filesize").getAsLong();
            String str = "";
            if (asLong != 0 && asLong != -1) {
                str = e.readableFileSize(asLong);
            }
            if (asInt <= 0) {
                return null;
            }
            hd.o oVar2 = new hd.o();
            try {
                oVar2.D = asString;
                oVar2.C = "[" + asString2.toUpperCase() + "] [RD] [" + str + "]";
                oVar2.f13050z = true;
                oVar2.f13042r = asString3;
                oVar2.f13047w = true;
                return oVar2;
            } catch (Exception unused) {
                return oVar2;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static String parseRating(o oVar, int i10, String str) {
        l asJsonArray = oVar.getAsJsonObject().get("results").getAsJsonArray();
        String str2 = "NA";
        int i11 = 0;
        while (i11 < asJsonArray.size()) {
            q asJsonObject = asJsonArray.get(i11).getAsJsonObject();
            String asString = asJsonObject.get("iso_3166_1").getAsString();
            if (asString.equalsIgnoreCase(str)) {
                l asJsonArray2 = asJsonObject.getAsJsonArray("release_dates");
                for (int i12 = 0; i12 < asJsonArray2.size(); i12++) {
                    String asString2 = asJsonArray2.get(i12).getAsJsonObject().get("certification").getAsString();
                    if (asString2 != null && !asString2.isEmpty()) {
                        return asString2;
                    }
                }
            }
            i11++;
            str2 = asString;
        }
        return !str2.isEmpty() ? str2 : "0";
    }

    public static String parseRatingSeries(o oVar, int i10, String str) {
        l asJsonArray = oVar.getAsJsonObject().get("results").getAsJsonArray();
        String asString = null;
        for (int i11 = 0; i11 < asJsonArray.size(); i11++) {
            q asJsonObject = asJsonArray.get(i11).getAsJsonObject();
            if (asJsonObject.get("iso_3166_1").getAsString().equalsIgnoreCase(str) && (asString = asJsonObject.get("rating").getAsString()) != null && !asString.isEmpty()) {
                return asString;
            }
        }
        return ((asString == null || !asString.isEmpty()) && !str.equalsIgnoreCase("us")) ? parseRatingSeries(oVar, i10, "us") : "0";
    }

    public static ArrayList<Movie> parseSearchMovies(o oVar, int i10) {
        if (oVar == null) {
            return null;
        }
        l asJsonArray = oVar.getAsJsonObject().get("results").getAsJsonArray();
        ArrayList<Movie> arrayList = new ArrayList<>();
        for (int i11 = 0; i11 < asJsonArray.size(); i11++) {
            Movie movieData = parseMovieData(asJsonArray.get(i11).getAsJsonObject(), i10);
            if (!movieData.getTitle().toLowerCase(Locale.ROOT).trim().equals("gomorrah")) {
                arrayList.add(movieData);
            }
        }
        return arrayList;
    }

    public static ArrayList<Movie> parseSearchMulti(o oVar) {
        if (oVar == null) {
            return null;
        }
        l asJsonArray = oVar.getAsJsonObject().get("results").getAsJsonArray();
        ArrayList<Movie> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
            q asJsonObject = asJsonArray.get(i10).getAsJsonObject();
            Movie movieMulti = parseMovieMulti(asJsonObject);
            if (movieMulti == null || movieMulti.getTitle().toLowerCase(Locale.ROOT).trim().equals("gomorrah")) {
                arrayList.addAll(parseMoviesFromKownfor(asJsonObject));
            } else {
                arrayList.add(movieMulti);
            }
        }
        return arrayList;
    }

    public static ArrayList<String> parseSuggestions(o oVar) {
        ArrayList<String> arrayList = new ArrayList<>();
        l asJsonArray = oVar.getAsJsonObject().get("results").getAsJsonArray();
        for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
            q asJsonObject = asJsonArray.get(i10).getAsJsonObject();
            try {
                try {
                    arrayList.add(asJsonObject.getAsJsonObject().get("title").getAsString());
                } catch (Exception unused) {
                    arrayList.add(asJsonObject.getAsJsonObject().get(MediationMetaData.KEY_NAME).getAsString());
                }
            } catch (Exception unused2) {
            }
        }
        return arrayList;
    }

    public static ArrayList<String> parseSuggestionsGoogle(o oVar) {
        ArrayList<String> arrayList = new ArrayList<>();
        l asJsonArray = oVar.getAsJsonArray().get(1).getAsJsonArray();
        for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
            arrayList.add(asJsonArray.get(i10).getAsString());
        }
        return arrayList;
    }

    public static String parseTrailer(o oVar) {
        if (oVar == null) {
            return null;
        }
        l asJsonArray = oVar.getAsJsonObject().get("results").getAsJsonArray();
        for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
            q asJsonObject = asJsonArray.get(i10).getAsJsonObject();
            String asString = asJsonObject.get("site").getAsString();
            String asString2 = asJsonObject.get("type").getAsString();
            if (asString != null && asString.equalsIgnoreCase("YouTube") && asString2 != null && asString2.equalsIgnoreCase("trailer")) {
                return asJsonObject.get("key").getAsString();
            }
        }
        return null;
    }

    public static ArrayList<p> parseWriters(o oVar) {
        if (oVar == null) {
            return null;
        }
        l asJsonArray = oVar.getAsJsonObject().get("crew").getAsJsonArray();
        ArrayList<p> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
            q asJsonObject = asJsonArray.get(i10).getAsJsonObject();
            String asString = asJsonObject.get(MediationMetaData.KEY_NAME).getAsString();
            asJsonObject.get("job").getAsString();
            asJsonObject.get("department").getAsString();
            long asLong = asJsonObject.get("id").getAsLong();
            p pVar = new p();
            pVar.setName(asString);
            pVar.setId(asLong);
            pVar.setImg_url("");
            arrayList.add(pVar);
        }
        return arrayList;
    }
}
