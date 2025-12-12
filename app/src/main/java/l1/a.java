package l1;

import androidx.datastore.preferences.core.MutablePreferences;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.Map;
import zf.i;

/* compiled from: Preferences.kt */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: Preferences.kt */
    /* renamed from: l1.a$a, reason: collision with other inner class name */
    public static final class C0186a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final String f15719a;

        public C0186a(String str) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            this.f15719a = str;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0186a)) {
                return false;
            }
            return i.areEqual(this.f15719a, ((C0186a) obj).f15719a);
        }

        public final String getName() {
            return this.f15719a;
        }

        public int hashCode() {
            return this.f15719a.hashCode();
        }

        public String toString() {
            return this.f15719a;
        }
    }

    /* compiled from: Preferences.kt */
    public static final class b<T> {
        public final C0186a<T> getKey$datastore_preferences_core() {
            return null;
        }

        public final T getValue$datastore_preferences_core() {
            return null;
        }
    }

    public abstract Map<C0186a<?>, Object> asMap();

    public abstract <T> T get(C0186a<T> c0186a);

    public final MutablePreferences toMutablePreferences() {
        return new MutablePreferences(kotlin.collections.a.toMutableMap(asMap()), false);
    }

    public final a toPreferences() {
        return new MutablePreferences(kotlin.collections.a.toMutableMap(asMap()), true);
    }
}
