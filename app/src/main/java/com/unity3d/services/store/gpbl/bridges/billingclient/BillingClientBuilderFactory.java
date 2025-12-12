package com.unity3d.services.store.gpbl.bridges.billingclient;

import android.content.Context;
import com.unity3d.services.store.gpbl.bridges.billingclient.v4.BillingClientBridge;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public class BillingClientBuilderFactory {
    public static IBillingClientBuilderBridge getBillingClientBuilder(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        return BillingClientBridge.isAvailable() ? BillingClientBridge.newBuilder(context) : com.unity3d.services.store.gpbl.bridges.billingclient.v3.BillingClientBridge.newBuilder(context);
    }
}
