package k1;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.io.InputStream;
import zf.f;
import zf.i;

/* compiled from: PreferencesMapCompat.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f14718a = new a(null);

    /* compiled from: PreferencesMapCompat.kt */
    public static final class a {
        public a(f fVar) {
        }

        public final c readFrom(InputStream inputStream) throws IOException {
            i.checkNotNullParameter(inputStream, "input");
            try {
                c from = c.parseFrom(inputStream);
                i.checkNotNullExpressionValue(from, "{\n                PreferencesProto.PreferenceMap.parseFrom(input)\n            }");
                return from;
            } catch (InvalidProtocolBufferException e10) {
                throw new CorruptionException("Unable to parse preferences proto.", e10);
            }
        }
    }
}
