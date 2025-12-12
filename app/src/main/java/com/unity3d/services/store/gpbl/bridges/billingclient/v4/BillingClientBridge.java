package com.unity3d.services.store.gpbl.bridges.billingclient.v4;

import android.content.Context;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.unity3d.services.store.gpbl.bridges.billingclient.common.BillingClientBridgeCommon;
import com.unity3d.services.store.gpbl.bridges.billingclient.common.BillingClientBuilderBridgeCommon;
import com.unity3d.services.store.gpbl.proxies.PurchasesResponseListenerProxy;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class BillingClientBridge extends BillingClientBridgeCommon {
    private static final String queryPurchasesAsyncMethodName = "queryPurchasesAsync";

    public static class BuilderBridge extends BillingClientBuilderBridgeCommon {
        public BuilderBridge(Object obj) throws ClassNotFoundException {
            super(obj);
        }

        @Override // com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClientBuilderBridge
        public BillingClientBridgeCommon build() throws ClassNotFoundException {
            return new BillingClientBridge(callNonVoidMethod(JsonPOJOBuilder.DEFAULT_BUILD_METHOD, this._billingClientBuilderInternalInstance, new Object[0]));
        }
    }

    public BillingClientBridge(Object obj) throws ClassNotFoundException {
        super(obj, new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.store.gpbl.bridges.billingclient.v4.BillingClientBridge.1
            {
                put(BillingClientBridge.queryPurchasesAsyncMethodName, new Class[]{String.class, PurchasesResponseListenerProxy.getProxyListenerClass()});
            }
        });
    }

    public static boolean isAvailable() throws NoSuchMethodException, SecurityException {
        try {
            BillingClientBridgeCommon.getClassForBridge().getMethod(queryPurchasesAsyncMethodName, String.class, PurchasesResponseListenerProxy.getProxyListenerClass());
            return true;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return false;
        }
    }

    public static BuilderBridge newBuilder(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        return new BuilderBridge(BillingClientBridgeCommon.callNonVoidStaticMethod("newBuilder", context));
    }

    @Override // com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClient
    public void queryPurchasesAsync(String str, PurchasesResponseListenerProxy purchasesResponseListenerProxy) throws IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        callVoidMethod(queryPurchasesAsyncMethodName, this._billingClientInternalInstance, str, purchasesResponseListenerProxy.getProxyInstance());
    }
}
