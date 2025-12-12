package yh;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.LazyThreadSafetyMode;
import kotlin.text.StringsKt__StringsKt;
import mf.q;
import mh.c;
import zf.i;

/* compiled from: KoinPlatformTools.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f22543a = new b();

    public final c defaultContext() {
        return mh.b.f16320a;
    }

    public final LazyThreadSafetyMode defaultLazyMode() {
        return LazyThreadSafetyMode.SYNCHRONIZED;
    }

    public final String generateId() {
        String string = UUID.randomUUID().toString();
        i.checkNotNullExpressionValue(string, "randomUUID().toString()");
        return string;
    }

    public final String getClassName(gg.b<?> bVar) {
        i.checkNotNullParameter(bVar, "kClass");
        String name = xf.a.getJavaClass(bVar).getName();
        i.checkNotNullExpressionValue(name, "kClass.java.name");
        return name;
    }

    public final String getStackTrace(Exception exc) {
        i.checkNotNullParameter(exc, "e");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(exc);
        sb2.append("\n\t");
        StackTraceElement[] stackTrace = exc.getStackTrace();
        i.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTrace) {
            i.checkNotNullExpressionValue(stackTraceElement.getClassName(), "it.className");
            if (!(!StringsKt__StringsKt.contains$default((CharSequence) r6, (CharSequence) "sun.reflect", false, 2, (Object) null))) {
                break;
            }
            arrayList.add(stackTraceElement);
        }
        sb2.append(q.joinToString$default(arrayList, "\n\t", null, null, 0, null, null, 62, null));
        return sb2.toString();
    }

    public final <K, V> Map<K, V> safeHashMap() {
        return new ConcurrentHashMap();
    }

    /* renamed from: synchronized, reason: not valid java name */
    public final <R> R m238synchronized(Object obj, yf.a<? extends R> aVar) {
        R rInvoke;
        i.checkNotNullParameter(obj, "lock");
        i.checkNotNullParameter(aVar, "block");
        synchronized (obj) {
            rInvoke = aVar.invoke();
        }
        return rInvoke;
    }
}
