package ac;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import okhttp3.logging.HttpLoggingInterceptor;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.instance.SingleInstanceFactory;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class c implements HttpLoggingInterceptor.Logger {
    public static int A(int i10, int i11, int i12, int i13) {
        return ((i10 + i11) * i12) + i13;
    }

    public static String B(String str, String str2) {
        return str + str2;
    }

    public static String C(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static int a(int i10, int i11, int i12, int i13) {
        return ((i10 * i11) / i12) + i13;
    }

    public static int b(String str, int i10, int i11) {
        return (str.hashCode() + i10) * i11;
    }

    public static View c(ViewGroup viewGroup, int i10, ViewGroup viewGroup2, boolean z10) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i10, viewGroup2, z10);
    }

    public static String d(Class cls, StringBuilder sb2, String str) {
        sb2.append(cls.getName());
        sb2.append(str);
        return sb2.toString();
    }

    public static String e(String str, char c10) {
        return str + c10;
    }

    public static String f(String str, int i10) {
        return str + i10;
    }

    public static String g(String str, int i10, String str2, int i11) {
        return str + i10 + str2 + i11;
    }

    public static String h(String str, long j10) {
        return str + j10;
    }

    public static String i(String str, Uri uri) {
        return str + uri;
    }

    public static String j(String str, String str2) {
        return str + str2;
    }

    public static String k(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String l(StringBuilder sb2, int i10, char c10) {
        sb2.append(i10);
        sb2.append(c10);
        return sb2.toString();
    }

    public static String m(StringBuilder sb2, int i10, String str) {
        sb2.append(i10);
        sb2.append(str);
        return sb2.toString();
    }

    public static String n(StringBuilder sb2, String str, char c10) {
        sb2.append(str);
        sb2.append(c10);
        return sb2.toString();
    }

    public static String o(StringBuilder sb2, String str, String str2) {
        sb2.append(str);
        sb2.append(str2);
        return sb2.toString();
    }

    public static String p(StringBuilder sb2, String str, String str2, String str3) {
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str3);
        return sb2.toString();
    }

    public static StringBuilder q(int i10, String str) {
        StringBuilder sb2 = new StringBuilder(i10);
        sb2.append(str);
        return sb2;
    }

    public static StringBuilder r(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        return sb2;
    }

    public static StringBuilder s(String str, int i10, String str2) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(i10);
        sb2.append(str2);
        return sb2;
    }

    public static StringBuilder t(String str, int i10, String str2, int i11, String str3) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(i10);
        sb2.append(str2);
        sb2.append(i11);
        sb2.append(str3);
        return sb2;
    }

    public static StringBuilder u(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str2);
        return sb2;
    }

    public static StringBuilder v(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(str2);
        sb2.append(str3);
        return sb2;
    }

    public static HashMap w(String str, String str2) {
        HashMap map = new HashMap();
        map.put(str, str2);
        return map;
    }

    public static HashMap x(String str, String str2, String str3, String str4) {
        HashMap map = new HashMap();
        map.put(str, str2);
        map.put(str3, str4);
        return map;
    }

    public static SingleInstanceFactory y(BeanDefinition beanDefinition, rh.a aVar) {
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        aVar.indexPrimaryType(singleInstanceFactory);
        return singleInstanceFactory;
    }

    public static boolean z(org.jsoup.parser.a aVar, String str) {
        return aVar.currentElement().nodeName().equals(str);
    }

    @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
    public void log(String str) {
        zf.i.checkNotNullParameter(str, "message");
        Log.d("HttpLoggingInterceptor", str);
    }
}
