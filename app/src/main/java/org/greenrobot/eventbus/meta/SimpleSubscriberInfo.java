package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.SubscriberMethod;

/* loaded from: classes2.dex */
public class SimpleSubscriberInfo extends AbstractSubscriberInfo {
    private final SubscriberMethodInfo[] methodInfos;

    public SimpleSubscriberInfo(Class cls, boolean z10, SubscriberMethodInfo[] subscriberMethodInfoArr) {
        super(cls, null, z10);
        this.methodInfos = subscriberMethodInfoArr;
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public synchronized SubscriberMethod[] getSubscriberMethods() {
        SubscriberMethod[] subscriberMethodArr;
        int length = this.methodInfos.length;
        subscriberMethodArr = new SubscriberMethod[length];
        for (int i10 = 0; i10 < length; i10++) {
            SubscriberMethodInfo subscriberMethodInfo = this.methodInfos[i10];
            subscriberMethodArr[i10] = createSubscriberMethod(subscriberMethodInfo.methodName, subscriberMethodInfo.eventType, subscriberMethodInfo.threadMode, subscriberMethodInfo.priority, subscriberMethodInfo.sticky);
        }
        return subscriberMethodArr;
    }
}
