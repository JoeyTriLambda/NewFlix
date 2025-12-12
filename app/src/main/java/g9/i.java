package g9;

import com.google.auto.value.AutoValue;
import java.util.List;

/* compiled from: HeartBeatResult.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class i {
    public static i create(String str, List<String> list) {
        return new a(str, list);
    }

    public abstract List<String> getUsedDates();

    public abstract String getUserAgent();
}
