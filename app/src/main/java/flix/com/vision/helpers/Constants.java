package flix.com.vision.helpers;

import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.models.Movie;
import hd.g;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.threeten.bp.chrono.HijrahDate;

/* loaded from: classes2.dex */
public final class Constants {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12319a = App.getInstance().f11578z;

    /* renamed from: b, reason: collision with root package name */
    public static final String f12320b = "https://t.ly/nlELZ";

    /* renamed from: c, reason: collision with root package name */
    public static final String f12321c = "user_agent";

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f12322d = {"119927", "232877", "486101", "109456", "91253", "62699", "88408", "92137", "62459", "99688", "102229", "33025", "155724", "106734", "66586", "80112", "56517", "123925", "88713", "33025"};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f12323e = {"70484", "61335", "85021", "92628", "119826", "63853", "70496", "75789", "70384", "76692", "87108", "113987", "72787", "649918", "91445", "124477"};

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f12324f = {"66980", "83936", "135323", "109357"};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f12325g = {"rus", "french", "ita", "pl", "finnish", "esp", "latino", "ukr", "hun"};

    public enum TRAKT_TV_EVENT {
        USER_LOGGED_IN,
        USER_LOGGED_OUT
    }

    public static class a {
    }

    public static ArrayList<Movie> filterFlaggedContent(ArrayList<Movie> arrayList) {
        try {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(new ArrayList(Arrays.asList(f12322d)));
            arrayList2.addAll(new ArrayList(Arrays.asList(f12323e)));
            arrayList2.addAll(new ArrayList(Arrays.asList(f12324f)));
            ArrayList<Movie> arrayList3 = new ArrayList<>();
            Iterator<Movie> it = arrayList.iterator();
            while (it.hasNext()) {
                Movie next = it.next();
                if (!arrayList2.contains(String.valueOf(next.getMovieId()))) {
                    arrayList3.add(next);
                }
            }
            return arrayList3;
        } catch (Exception unused) {
            return arrayList;
        }
    }

    public static String getGenre(int i10, int i11) {
        Iterator<g> it = (i11 == 0 ? getMovieCategories() : getSeriesCategories()).iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.f13006a == i10) {
                return next.f13007b;
            }
        }
        return "";
    }

    public static ArrayList<g> getMovieCategories() {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(28, "Action"));
        arrayList.add(new g(12, "Adventure"));
        arrayList.add(new g(16, "Animation"));
        arrayList.add(new g(35, "Comedy"));
        arrayList.add(new g(80, "Crime"));
        arrayList.add(new g(99, "Documentary"));
        arrayList.add(new g(18, "Drama"));
        arrayList.add(new g(10751, "Family"));
        arrayList.add(new g(14, "Fantasy"));
        arrayList.add(new g(36, "History"));
        arrayList.add(new g(27, "Horror"));
        arrayList.add(new g(10402, "Music"));
        arrayList.add(new g(9648, "Mystery"));
        arrayList.add(new g(10749, "Romance"));
        arrayList.add(new g(878, "Science Fiction"));
        arrayList.add(new g(10770, "TV Movie"));
        arrayList.add(new g(53, "Thriller"));
        arrayList.add(new g(10752, "War"));
        arrayList.add(new g(37, "Western"));
        return arrayList;
    }

    public static ArrayList<ld.a> getNetworks() {
        ArrayList<ld.a> arrayList = new ArrayList<>();
        arrayList.add(new ld.a(213, "Netflix", null, R.drawable.netflix));
        arrayList.add(new ld.a(2739, "Disney+", null, R.drawable.disney));
        arrayList.add(new ld.a(1024, "Prime Video", null, R.drawable.prime));
        arrayList.add(new ld.a(9991, "K-Drama", null, R.drawable.drama));
        arrayList.add(new ld.a(2552, "Apple TV+", null, R.drawable.appletvplus));
        arrayList.add(new ld.a(4330, "Paramount+", null, R.drawable.paramount));
        arrayList.add(new ld.a(49, "HBO Max", null, R.drawable.hbomax));
        arrayList.add(new ld.a(453, "Hulu", null, R.drawable.hulu));
        arrayList.add(new ld.a(318, "Starz", null, R.drawable.starz));
        arrayList.add(new ld.a(999, "Bollywood", null, R.drawable.bollywood_logo));
        arrayList.add(new ld.a(2, "ABC", null, R.drawable.abc_image));
        arrayList.add(new ld.a(16, "CBS", null, R.drawable.cbs_image));
        arrayList.add(new ld.a(174, "AMC", null, R.drawable.amc_image));
        arrayList.add(new ld.a(3353, "Peacock", null, R.drawable.peacock));
        arrayList.add(new ld.a(HijrahDate.MAX_VALUE_OF_ERA, "Marvel Studios", null, R.drawable.marvel));
        arrayList.add(new ld.a(3343, "BET+", null, R.drawable.bet_plus_2));
        arrayList.add(new ld.a(4025, "BritBox", null, R.drawable.brit_box));
        return arrayList;
    }

    public static ArrayList<g> getSeriesCategories() {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(10759, "Action & Adventure"));
        arrayList.add(new g(16, "Animation"));
        arrayList.add(new g(35, "Comedy"));
        arrayList.add(new g(80, "Crime"));
        arrayList.add(new g(99, "Documentary"));
        arrayList.add(new g(18, "Drama"));
        arrayList.add(new g(10751, "Family"));
        arrayList.add(new g(10762, "Kids"));
        arrayList.add(new g(9648, "Mystery"));
        arrayList.add(new g(10763, "News"));
        arrayList.add(new g(10764, "Reality"));
        arrayList.add(new g(10765, "Sci-Fi & Fantasy"));
        arrayList.add(new g(10766, "Soap"));
        arrayList.add(new g(10767, "Talk"));
        arrayList.add(new g(10768, "War & Politics"));
        arrayList.add(new g(37, "Western"));
        return arrayList;
    }

    public static String readJSON(InputStream inputStream) throws IOException {
        try {
            String str = "";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return str;
                }
                str = str + line;
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
