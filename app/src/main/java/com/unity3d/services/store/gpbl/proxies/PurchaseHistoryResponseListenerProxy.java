package com.unity3d.services.store.gpbl.proxies;

import com.unity3d.services.core.reflection.GenericListenerProxy;
import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.PurchaseHistoryRecordBridge;
import com.unity3d.services.store.listeners.IPurchaseHistoryResponseListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class PurchaseHistoryResponseListenerProxy extends GenericListenerProxy {
    private static final String onPurchaseHistoryResponseMethodName = "onPurchaseHistoryResponse";
    private int _maxPurchases;
    private IPurchaseHistoryResponseListener _purchaseUpdatedResponseListener;

    public PurchaseHistoryResponseListenerProxy(IPurchaseHistoryResponseListener iPurchaseHistoryResponseListener, int i10) {
        this._purchaseUpdatedResponseListener = iPurchaseHistoryResponseListener;
        this._maxPurchases = i10;
    }

    public static Class<?> getProxyListenerClass() throws ClassNotFoundException {
        return Class.forName("com.android.billingclient.api.PurchaseHistoryResponseListener");
    }

    @Override // com.unity3d.services.core.reflection.GenericListenerProxy
    public Class<?> getProxyClass() throws ClassNotFoundException {
        return getProxyListenerClass();
    }

    @Override // com.unity3d.services.core.reflection.GenericListenerProxy, java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (!method.getName().equals(onPurchaseHistoryResponseMethodName)) {
            return super.invoke(obj, method, objArr);
        }
        onPurchaseHistoryResponse(objArr[0], (List) objArr[1]);
        return null;
    }

    public void onPurchaseHistoryResponse(Object obj, List<Object> list) {
        ArrayList arrayList;
        if (list != null) {
            arrayList = new ArrayList();
            for (int i10 = 0; i10 < this._maxPurchases && i10 < list.size(); i10++) {
                arrayList.add(new PurchaseHistoryRecordBridge(list.get(i10)));
            }
        } else {
            arrayList = null;
        }
        IPurchaseHistoryResponseListener iPurchaseHistoryResponseListener = this._purchaseUpdatedResponseListener;
        if (iPurchaseHistoryResponseListener != null) {
            iPurchaseHistoryResponseListener.onBillingResponse(new BillingResultBridge(obj), arrayList);
        }
    }
}
