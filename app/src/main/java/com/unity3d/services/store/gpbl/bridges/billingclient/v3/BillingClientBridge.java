package com.unity3d.services.store.gpbl.bridges.billingclient.v3;

import android.content.Context;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.unity3d.services.store.gpbl.bridges.PurchasesResultBridge;
import com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClient;
import com.unity3d.services.store.gpbl.bridges.billingclient.common.BillingClientBridgeCommon;
import com.unity3d.services.store.gpbl.bridges.billingclient.common.BillingClientBuilderBridgeCommon;
import com.unity3d.services.store.gpbl.proxies.PurchasesResponseListenerProxy;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class BillingClientBridge extends BillingClientBridgeCommon {
    private static final String queryPurchasesMethodName = "queryPurchases";

    public static class BuilderBridge extends BillingClientBuilderBridgeCommon {
        public BuilderBridge(Object obj) throws ClassNotFoundException {
            super(obj);
        }

        @Override // com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClientBuilderBridge
        public IBillingClient build() throws ClassNotFoundException {
            return new BillingClientBridge(callNonVoidMethod(JsonPOJOBuilder.DEFAULT_BUILD_METHOD, this._billingClientBuilderInternalInstance, new Object[0]));
        }
    }

    public BillingClientBridge(Object obj) throws ClassNotFoundException {
        super(obj, new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.store.gpbl.bridges.billingclient.v3.BillingClientBridge.1
            {
                put(BillingClientBridge.queryPurchasesMethodName, new Class[]{String.class});
            }
        });
    }

    public static BuilderBridge newBuilder(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        return new BuilderBridge(BillingClientBridgeCommon.callNonVoidStaticMethod("newBuilder", context));
    }

    @Override // com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClient
    public void queryPurchasesAsync(String str, PurchasesResponseListenerProxy purchasesResponseListenerProxy) {
        PurchasesResultBridge purchasesResultBridge = new PurchasesResultBridge(callNonVoidMethod(queryPurchasesMethodName, this._billingClientInternalInstance, str));
        purchasesResponseListenerProxy.getPurchasesResponseListener().onBillingResponse(purchasesResultBridge.getBillingResult(), purchasesResultBridge.getPurchasesList());
    }
}
