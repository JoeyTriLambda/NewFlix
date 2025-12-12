package n4;

import com.google.android.datatransport.Priority;
import com.google.auto.value.AutoValue;

/* compiled from: Event.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class c<T> {
    public static <T> c<T> ofData(int i10, T t10) {
        return new a(Integer.valueOf(i10), t10, Priority.DEFAULT);
    }

    public static <T> c<T> ofTelemetry(int i10, T t10) {
        return new a(Integer.valueOf(i10), t10, Priority.VERY_LOW);
    }

    public static <T> c<T> ofUrgent(T t10) {
        return new a(null, t10, Priority.HIGHEST);
    }

    public abstract Integer getCode();

    public abstract T getPayload();

    public abstract Priority getPriority();

    public static <T> c<T> ofData(T t10) {
        return new a(null, t10, Priority.DEFAULT);
    }
}
