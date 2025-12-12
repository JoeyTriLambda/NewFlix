package com.google.android.youtube.player.internal;

import android.os.IBinder;
import com.google.android.youtube.player.internal.j;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class k<T> extends j.a {

    /* renamed from: a, reason: collision with root package name */
    public final T f9594a;

    public k(T t10) {
        this.f9594a = t10;
    }

    public static <T> j a(T t10) {
        return new k(t10);
    }

    public static <T> T a(j jVar) throws SecurityException {
        if (jVar instanceof k) {
            return ((k) jVar).f9594a;
        }
        IBinder iBinderAsBinder = jVar.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        if (declaredFields.length != 1) {
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
        }
        Field field = declaredFields[0];
        if (field.isAccessible()) {
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
        }
        field.setAccessible(true);
        try {
            return (T) field.get(iBinderAsBinder);
        } catch (IllegalAccessException e10) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e10);
        } catch (IllegalArgumentException e11) {
            throw new IllegalArgumentException("remoteBinder is the wrong class.", e11);
        } catch (NullPointerException e12) {
            throw new IllegalArgumentException("Binder object is null.", e12);
        }
    }
}
