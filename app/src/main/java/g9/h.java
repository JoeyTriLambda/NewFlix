package g9;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: HeartBeatInfoStorage.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f12814a;

    public h(Context context, String str) {
        this.f12814a = context.getSharedPreferences("FirebaseHeartBeat" + str, 0);
    }

    public final synchronized void a() {
        long j10 = this.f12814a.getLong("fire-count", 0L);
        String key = "";
        String str = null;
        for (Map.Entry<String, ?> entry : this.f12814a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                for (String str2 : (Set) entry.getValue()) {
                    if (str == null || str.compareTo(str2) > 0) {
                        key = entry.getKey();
                        str = str2;
                    }
                }
            }
        }
        HashSet hashSet = new HashSet(this.f12814a.getStringSet(key, new HashSet()));
        hashSet.remove(str);
        this.f12814a.edit().putStringSet(key, hashSet).putLong("fire-count", j10 - 1).commit();
    }

    public final synchronized void b() {
        SharedPreferences.Editor editorEdit = this.f12814a.edit();
        int i10 = 0;
        for (Map.Entry<String, ?> entry : this.f12814a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Set set = (Set) entry.getValue();
                String strD = d(System.currentTimeMillis());
                String key = entry.getKey();
                if (set.contains(strD)) {
                    HashSet hashSet = new HashSet();
                    hashSet.add(strD);
                    i10++;
                    editorEdit.putStringSet(key, hashSet);
                } else {
                    editorEdit.remove(key);
                }
            }
        }
        if (i10 == 0) {
            editorEdit.remove("fire-count");
        } else {
            editorEdit.putLong("fire-count", i10);
        }
        editorEdit.commit();
    }

    public final synchronized ArrayList c() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.f12814a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                HashSet hashSet = new HashSet((Set) entry.getValue());
                hashSet.remove(d(System.currentTimeMillis()));
                if (!hashSet.isEmpty()) {
                    arrayList.add(i.create(entry.getKey(), new ArrayList(hashSet)));
                }
            }
        }
        h(System.currentTimeMillis());
        return arrayList;
    }

    public final synchronized String d(long j10) {
        if (Build.VERSION.SDK_INT >= 26) {
            return new Date(j10).toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j10));
    }

    public final synchronized String e(String str) {
        for (Map.Entry<String, ?> entry : this.f12814a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return entry.getKey();
                    }
                }
            }
        }
        return null;
    }

    public final synchronized void f(String str) {
        String strE = e(str);
        if (strE == null) {
            return;
        }
        HashSet hashSet = new HashSet(this.f12814a.getStringSet(strE, new HashSet()));
        hashSet.remove(str);
        if (hashSet.isEmpty()) {
            this.f12814a.edit().remove(strE).commit();
        } else {
            this.f12814a.edit().putStringSet(strE, hashSet).commit();
        }
    }

    public final synchronized void g(long j10, String str) {
        String strD = d(j10);
        if (this.f12814a.getString("last-used-date", "").equals(strD)) {
            String strE = e(strD);
            if (strE == null) {
                return;
            }
            if (strE.equals(str)) {
                return;
            }
            i(str, strD);
            return;
        }
        long j11 = this.f12814a.getLong("fire-count", 0L);
        if (j11 + 1 == 30) {
            a();
            j11 = this.f12814a.getLong("fire-count", 0L);
        }
        HashSet hashSet = new HashSet(this.f12814a.getStringSet(str, new HashSet()));
        hashSet.add(strD);
        this.f12814a.edit().putStringSet(str, hashSet).putLong("fire-count", j11 + 1).putString("last-used-date", strD).commit();
    }

    public final synchronized void h(long j10) {
        this.f12814a.edit().putLong("fire-global", j10).commit();
    }

    public final synchronized void i(String str, String str2) {
        f(str2);
        HashSet hashSet = new HashSet(this.f12814a.getStringSet(str, new HashSet()));
        hashSet.add(str2);
        this.f12814a.edit().putStringSet(str, hashSet).commit();
    }
}
