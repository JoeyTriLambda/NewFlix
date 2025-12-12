package com.google.android.gms.dynamic;

import ac.c;
import android.os.IBinder;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.lang.reflect.Field;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@RetainForClient
@KeepForSdk
/* loaded from: classes.dex */
public final class ObjectWrapper<T> extends IObjectWrapper.Stub {

    /* renamed from: a, reason: collision with root package name */
    public final Object f7563a;

    public ObjectWrapper(Object obj) {
        this.f7563a = obj;
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public static <T> T unwrap(IObjectWrapper iObjectWrapper) throws SecurityException {
        if (iObjectWrapper instanceof ObjectWrapper) {
            return (T) ((ObjectWrapper) iObjectWrapper).f7563a;
        }
        IBinder iBinderAsBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i10 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i10++;
                field = field2;
            }
        }
        if (i10 != 1) {
            throw new IllegalArgumentException(c.f("Unexpected number of IObjectWrapper declared fields: ", declaredFields.length));
        }
        Preconditions.checkNotNull(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return (T) field.get(iBinderAsBinder);
        } catch (IllegalAccessException e10) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e10);
        } catch (NullPointerException e11) {
            throw new IllegalArgumentException("Binder object is null.", e11);
        }
    }

    @KeepForSdk
    public static <T> IObjectWrapper wrap(T t10) {
        return new ObjectWrapper(t10);
    }
}
