package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import com.google.android.youtube.player.internal.d;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class w {

    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th2) {
            super(str, th2);
        }
    }

    public static IBinder a(Class<?> cls, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, boolean z10) throws a {
        try {
            return (IBinder) cls.getConstructor(IBinder.class, IBinder.class, IBinder.class, Boolean.TYPE).newInstance(iBinder, iBinder2, iBinder3, Boolean.valueOf(z10));
        } catch (IllegalAccessException e10) {
            String name = cls.getName();
            throw new a(name.length() != 0 ? "Unable to call the default constructor of ".concat(name) : new String("Unable to call the default constructor of "), e10);
        } catch (InstantiationException e11) {
            String name2 = cls.getName();
            throw new a(name2.length() != 0 ? "Unable to instantiate the dynamic class ".concat(name2) : new String("Unable to instantiate the dynamic class "), e11);
        } catch (NoSuchMethodException e12) {
            String name3 = cls.getName();
            throw new a(name3.length() != 0 ? "Could not find the right constructor for ".concat(name3) : new String("Could not find the right constructor for "), e12);
        } catch (InvocationTargetException e13) {
            String name4 = cls.getName();
            throw new a(name4.length() != 0 ? "Exception thrown by invoked constructor in ".concat(name4) : new String("Exception thrown by invoked constructor in "), e13);
        }
    }

    public static d a(Activity activity, IBinder iBinder, boolean z10) throws a {
        a8.a.a(activity);
        a8.a.a(iBinder);
        Context contextB = a8.h.b(activity);
        if (contextB == null) {
            throw new a("Could not create remote context");
        }
        try {
            return d.a.a(a(contextB.getClassLoader().loadClass("com.google.android.youtube.api.jar.client.RemoteEmbeddedPlayer"), k.a(contextB).asBinder(), k.a(activity).asBinder(), iBinder, z10));
        } catch (ClassNotFoundException e10) {
            throw new a("com.google.android.youtube.api.jar.client.RemoteEmbeddedPlayer".length() != 0 ? "Unable to find dynamic class ".concat("com.google.android.youtube.api.jar.client.RemoteEmbeddedPlayer") : new String("Unable to find dynamic class "), e10);
        }
    }
}
