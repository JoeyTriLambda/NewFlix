package com.unity3d.services.store.gpbl.proxies;

import com.unity3d.services.core.reflection.GenericListenerProxy;
import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.PurchaseBridge;
import com.unity3d.services.store.listeners.IPurchaseUpdatedResponseListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class PurchaseUpdatedListenerProxy extends GenericListenerProxy {
    private static final String onPurchasesUpdatedMethodName = "onPurchasesUpdated";
    private IPurchaseUpdatedResponseListener _purchaseUpdatedResponseListener;

    public PurchaseUpdatedListenerProxy(IPurchaseUpdatedResponseListener iPurchaseUpdatedResponseListener) {
        this._purchaseUpdatedResponseListener = iPurchaseUpdatedResponseListener;
    }

    public static Class<?> getProxyListenerClass() throws ClassNotFoundException {
        return Class.forName("com.android.billingclient.api.PurchasesUpdatedListener");
    }

    @Override // com.unity3d.services.core.reflection.GenericListenerProxy
    public Class<?> getProxyClass() throws ClassNotFoundException {
        return getProxyListenerClass();
    }

    @Override // com.unity3d.services.core.reflection.GenericListenerProxy, java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (!method.getName().equals(onPurchasesUpdatedMethodName)) {
            return super.invoke(obj, method, objArr);
        }
        onPurchasesUpdated(objArr[0], (List) objArr[1]);
        return null;
    }

    public void onPurchasesUpdated(Object obj, List<Object> list) {
        ArrayList arrayList;
        if (list != null) {
            arrayList = new ArrayList();
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new PurchaseBridge(it.next()));
            }
        } else {
            arrayList = null;
        }
        IPurchaseUpdatedResponseListener iPurchaseUpdatedResponseListener = this._purchaseUpdatedResponseListener;
        if (iPurchaseUpdatedResponseListener != null) {
            iPurchaseUpdatedResponseListener.onBillingResponse(new BillingResultBridge(obj), arrayList);
        }
    }
}
