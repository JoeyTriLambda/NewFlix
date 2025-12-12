package g2;

import android.content.Context;
import androidx.room.RoomDatabase;
import org.apache.commons.lang3.ClassUtils;

/* compiled from: Room.kt */
/* loaded from: classes.dex */
public final class n {
    public static final <T extends RoomDatabase> RoomDatabase.a<T> databaseBuilder(Context context, Class<T> cls, String str) {
        zf.i.checkNotNullParameter(context, "context");
        zf.i.checkNotNullParameter(cls, "klass");
        if (true ^ (str == null || ig.l.isBlank(str))) {
            return new RoomDatabase.a<>(context, cls, str);
        }
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder".toString());
    }

    public static final <T, C> T getGeneratedImplementation(Class<C> cls, String str) throws ClassNotFoundException {
        String str2;
        zf.i.checkNotNullParameter(cls, "klass");
        zf.i.checkNotNullParameter(str, "suffix");
        Package r12 = cls.getPackage();
        zf.i.checkNotNull(r12);
        String name = r12.getName();
        String canonicalName = cls.getCanonicalName();
        zf.i.checkNotNull(canonicalName);
        zf.i.checkNotNullExpressionValue(name, "fullPackage");
        if (!(name.length() == 0)) {
            canonicalName = canonicalName.substring(name.length() + 1);
            zf.i.checkNotNullExpressionValue(canonicalName, "this as java.lang.String).substring(startIndex)");
        }
        String strO = ac.c.o(new StringBuilder(), ig.l.replace$default(canonicalName, ClassUtils.PACKAGE_SEPARATOR_CHAR, '_', false, 4, (Object) null), str);
        try {
            if (name.length() == 0) {
                str2 = strO;
            } else {
                str2 = name + ClassUtils.PACKAGE_SEPARATOR_CHAR + strO;
            }
            Class<?> cls2 = Class.forName(str2, true, cls.getClassLoader());
            zf.i.checkNotNull(cls2, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
            return (T) cls2.newInstance();
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Cannot find implementation for " + cls.getCanonicalName() + ". " + strO + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor " + cls + ".canonicalName");
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + cls + ".canonicalName");
        }
    }

    public static final <T extends RoomDatabase> RoomDatabase.a<T> inMemoryDatabaseBuilder(Context context, Class<T> cls) {
        zf.i.checkNotNullParameter(context, "context");
        zf.i.checkNotNullParameter(cls, "klass");
        return new RoomDatabase.a<>(context, cls, null);
    }
}
