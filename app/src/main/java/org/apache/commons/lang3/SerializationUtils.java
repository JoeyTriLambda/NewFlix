package org.apache.commons.lang3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class SerializationUtils {

    public static class ClassLoaderAwareObjectInputStream extends ObjectInputStream {
        private static final Map<String, Class<?>> primitiveTypes;
        private final ClassLoader classLoader;

        static {
            HashMap map = new HashMap();
            primitiveTypes = map;
            map.put("byte", Byte.TYPE);
            map.put("short", Short.TYPE);
            map.put("int", Integer.TYPE);
            map.put("long", Long.TYPE);
            map.put("float", Float.TYPE);
            map.put("double", Double.TYPE);
            map.put("boolean", Boolean.TYPE);
            map.put("char", Character.TYPE);
            map.put("void", Void.TYPE);
        }

        public ClassLoaderAwareObjectInputStream(InputStream inputStream, ClassLoader classLoader) throws IOException {
            super(inputStream);
            this.classLoader = classLoader;
        }

        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
            String name = objectStreamClass.getName();
            try {
                try {
                    return Class.forName(name, false, this.classLoader);
                } catch (ClassNotFoundException unused) {
                    return Class.forName(name, false, Thread.currentThread().getContextClassLoader());
                }
            } catch (ClassNotFoundException e10) {
                Class<?> cls = primitiveTypes.get(name);
                if (cls != null) {
                    return cls;
                }
                throw e10;
            }
        }
    }

    public static <T extends Serializable> T clone(T t10) throws IOException {
        if (t10 == null) {
            return null;
        }
        try {
            ClassLoaderAwareObjectInputStream classLoaderAwareObjectInputStream = new ClassLoaderAwareObjectInputStream(new ByteArrayInputStream(serialize(t10)), t10.getClass().getClassLoader());
            try {
                T t11 = (T) classLoaderAwareObjectInputStream.readObject();
                classLoaderAwareObjectInputStream.close();
                return t11;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    try {
                        classLoaderAwareObjectInputStream.close();
                    } catch (Throwable th4) {
                        th2.addSuppressed(th4);
                    }
                    throw th3;
                }
            }
        } catch (IOException e10) {
            throw new SerializationException("IOException while reading or closing cloned object data", e10);
        } catch (ClassNotFoundException e11) {
            throw new SerializationException("ClassNotFoundException while reading cloned object data", e11);
        }
    }

    public static <T> T deserialize(InputStream inputStream) throws IOException {
        Validate.isTrue(inputStream != null, "The InputStream must not be null", new Object[0]);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            try {
                T t10 = (T) objectInputStream.readObject();
                objectInputStream.close();
                return t10;
            } finally {
            }
        } catch (IOException | ClassNotFoundException e10) {
            throw new SerializationException(e10);
        }
    }

    public static <T extends Serializable> T roundtrip(T t10) {
        return (T) deserialize(serialize(t10));
    }

    public static void serialize(Serializable serializable, OutputStream outputStream) throws IOException {
        Validate.isTrue(outputStream != null, "The OutputStream must not be null", new Object[0]);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            try {
                objectOutputStream.writeObject(serializable);
                objectOutputStream.close();
            } finally {
            }
        } catch (IOException e10) {
            throw new SerializationException(e10);
        }
    }

    public static <T> T deserialize(byte[] bArr) {
        Validate.isTrue(bArr != null, "The byte[] must not be null", new Object[0]);
        return (T) deserialize(new ByteArrayInputStream(bArr));
    }

    public static byte[] serialize(Serializable serializable) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        serialize(serializable, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
