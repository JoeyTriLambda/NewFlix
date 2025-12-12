package o1;

import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import fd.c;
import flix.com.vision.activities.SettingsActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import org.threeten.bp.temporal.TemporalField;
import se.f;
import ub.z1;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements f {
    public /* synthetic */ a(int i10) {
    }

    public static float a(float f10, float f11, float f12, float f13) {
        return ((f10 - f11) * f12) + f13;
    }

    public static DisplayMetrics b(Display display) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static ViewPropertyAnimator c(View view, float f10, float f11, float f12, float f13) {
        view.setElevation(f10);
        view.animate().z(f11).start();
        view.animate().translationZ(f12).start();
        view.animate().scaleX(f13).start();
        return view.animate();
    }

    public static String d(String str, int i10, String str2) {
        return str + i10 + str2;
    }

    public static String e(String str, TemporalField temporalField) {
        return str + temporalField;
    }

    public static /* synthetic */ Iterator f() {
        try {
            return Arrays.asList(new lg.b()).iterator();
        } catch (Throwable th2) {
            throw new ServiceConfigurationError(th2.getMessage(), th2);
        }
    }

    public static /* bridge */ /* synthetic */ void g(int i10, int i11, Class cls) {
        throw null;
    }

    public static void h(int i10, RecyclerView recyclerView) {
        recyclerView.addItemDecoration(new c(i10));
    }

    public static void i(int i10, HashMap map, String str, int i11, String str2, int i12, String str3, int i13, String str4) {
        map.put(str, Integer.valueOf(i10));
        map.put(str2, Integer.valueOf(i11));
        map.put(str3, Integer.valueOf(i12));
        map.put(str4, Integer.valueOf(i13));
    }

    public static void j(SharedPreferences sharedPreferences, String str, boolean z10) {
        sharedPreferences.edit().putBoolean(str, z10).apply();
    }

    public static void k(RelativeLayout relativeLayout, long j10, float f10) {
        relativeLayout.animate().setDuration(j10).scaleX(f10).start();
    }

    public static void l(SettingsActivity settingsActivity, int i10, LinearLayout linearLayout) {
        linearLayout.setOnClickListener(new z1(settingsActivity, i10));
    }

    public static /* bridge */ /* synthetic */ void m(Object obj) {
        throw null;
    }

    public static /* bridge */ /* synthetic */ void n(Object obj, int i10, int i11, int i12) {
        throw null;
    }

    public static void o(String str, int i10, String str2) {
        Log.w(str2, str + i10);
    }

    public static void p(ArrayList arrayList, String str, String str2, String str3, String str4) {
        arrayList.add(str);
        arrayList.add(str2);
        arrayList.add(str3);
        arrayList.add(str4);
    }

    public static /* synthetic */ Iterator q() {
        try {
            return Arrays.asList(new lg.a()).iterator();
        } catch (Throwable th2) {
            throw new ServiceConfigurationError(th2.getMessage(), th2);
        }
    }

    public static void r(RelativeLayout relativeLayout, long j10, float f10) {
        relativeLayout.animate().setDuration(j10).scaleY(f10).start();
    }

    @Override // se.f
    public void accept(Object obj) {
    }
}
