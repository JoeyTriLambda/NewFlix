package androidx.versionedparcelable;

import android.os.Parcelable;
import b0.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import s2.c;

/* loaded from: classes.dex */
public abstract class VersionedParcel {

    /* renamed from: a, reason: collision with root package name */
    public final b<String, Method> f4450a;

    /* renamed from: b, reason: collision with root package name */
    public final b<String, Method> f4451b;

    /* renamed from: c, reason: collision with root package name */
    public final b<String, Class> f4452c;

    public static class ParcelException extends RuntimeException {
    }

    public VersionedParcel(b<String, Method> bVar, b<String, Method> bVar2, b<String, Class> bVar3) {
        this.f4450a = bVar;
        this.f4451b = bVar2;
        this.f4452c = bVar3;
    }

    public final Class a(Class<? extends c> cls) throws ClassNotFoundException {
        String name = cls.getName();
        b<String, Class> bVar = this.f4452c;
        Class cls2 = bVar.get(name);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        bVar.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method b(String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        b<String, Method> bVar = this.f4450a;
        Method method = bVar.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        bVar.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Method c(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException {
        String name = cls.getName();
        b<String, Method> bVar = this.f4451b;
        Method method = bVar.get(name);
        if (method != null) {
            return method;
        }
        Class clsA = a(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsA.getDeclaredMethod("write", cls, VersionedParcel.class);
        bVar.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract void closeField();

    public abstract VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    public abstract boolean readBoolean();

    public boolean readBoolean(boolean z10, int i10) {
        return !readField(i10) ? z10 : readBoolean();
    }

    public abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] bArr, int i10) {
        return !readField(i10) ? bArr : readByteArray();
    }

    public abstract CharSequence readCharSequence();

    public CharSequence readCharSequence(CharSequence charSequence, int i10) {
        return !readField(i10) ? charSequence : readCharSequence();
    }

    public abstract boolean readField(int i10);

    public <T extends c> T readFromParcel(String str, VersionedParcel versionedParcel) {
        try {
            return (T) b(str).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e12);
        } catch (InvocationTargetException e13) {
            if (e13.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e13.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e13);
        }
    }

    public abstract int readInt();

    public int readInt(int i10, int i11) {
        return !readField(i11) ? i10 : readInt();
    }

    public abstract <T extends Parcelable> T readParcelable();

    public <T extends Parcelable> T readParcelable(T t10, int i10) {
        return !readField(i10) ? t10 : (T) readParcelable();
    }

    public abstract String readString();

    public String readString(String str, int i10) {
        return !readField(i10) ? str : readString();
    }

    public <T extends c> T readVersionedParcelable(T t10, int i10) {
        return !readField(i10) ? t10 : (T) readVersionedParcelable();
    }

    public abstract void setOutputField(int i10);

    public abstract void writeBoolean(boolean z10);

    public void writeBoolean(boolean z10, int i10) {
        setOutputField(i10);
        writeBoolean(z10);
    }

    public abstract void writeByteArray(byte[] bArr);

    public void writeByteArray(byte[] bArr, int i10) {
        setOutputField(i10);
        writeByteArray(bArr);
    }

    public abstract void writeCharSequence(CharSequence charSequence);

    public void writeCharSequence(CharSequence charSequence, int i10) {
        setOutputField(i10);
        writeCharSequence(charSequence);
    }

    public abstract void writeInt(int i10);

    public void writeInt(int i10, int i11) {
        setOutputField(i11);
        writeInt(i10);
    }

    public abstract void writeParcelable(Parcelable parcelable);

    public void writeParcelable(Parcelable parcelable, int i10) {
        setOutputField(i10);
        writeParcelable(parcelable);
    }

    public abstract void writeString(String str);

    public void writeString(String str, int i10) {
        setOutputField(i10);
        writeString(str);
    }

    public <T extends c> void writeToParcel(T t10, VersionedParcel versionedParcel) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            c(t10.getClass()).invoke(null, t10, versionedParcel);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e12);
        } catch (InvocationTargetException e13) {
            if (!(e13.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e13);
            }
            throw ((RuntimeException) e13.getCause());
        }
    }

    public void writeVersionedParcelable(c cVar, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        setOutputField(i10);
        writeVersionedParcelable(cVar);
    }

    public <T extends c> T readVersionedParcelable() {
        String string = readString();
        if (string == null) {
            return null;
        }
        return (T) readFromParcel(string, createSubParcel());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void writeVersionedParcelable(c cVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (cVar == null) {
            writeString(null);
            return;
        }
        try {
            writeString(a(cVar.getClass()).getName());
            VersionedParcel versionedParcelCreateSubParcel = createSubParcel();
            writeToParcel(cVar, versionedParcelCreateSubParcel);
            versionedParcelCreateSubParcel.closeField();
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException(cVar.getClass().getSimpleName().concat(" does not have a Parcelizer"), e10);
        }
    }

    public void setSerializationFlags(boolean z10, boolean z11) {
    }
}
