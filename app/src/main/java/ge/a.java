package ge;

import android.content.Context;
import android.content.SharedPreferences;
import io.netas.R;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static a f12821b;

    /* renamed from: a, reason: collision with root package name */
    public final Context f12822a;

    public a(Context context) {
        this.f12822a = context;
    }

    public int a(String str, int i10) {
        return b().getInt(str, i10);
    }

    public final SharedPreferences b() {
        int i10 = R.string.netas_preference_file_key;
        Context context = this.f12822a;
        return context.getSharedPreferences(context.getString(i10), 0);
    }

    public static synchronized a a(Context context) {
        if (f12821b == null) {
            f12821b = new a(context);
        }
        return f12821b;
    }

    public void b(String str, int i10) {
        b().edit().putInt(str, i10).apply();
    }

    public String a(String str) {
        return b().getString(str, null);
    }

    public void b(String str, String str2) {
        b().edit().putString(str, str2).apply();
    }

    public String a(String str, String str2) {
        return b().getString(str, str2);
    }

    public boolean b(String str) {
        return b().getBoolean(str, false);
    }

    public void a(String str, boolean z10) {
        b().edit().putBoolean(str, z10).apply();
    }
}
