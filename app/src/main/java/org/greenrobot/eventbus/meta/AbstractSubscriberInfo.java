package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes2.dex */
public abstract class AbstractSubscriberInfo implements SubscriberInfo {
    private final boolean shouldCheckSuperclass;
    private final Class subscriberClass;
    private final Class<? extends SubscriberInfo> superSubscriberInfoClass;

    public AbstractSubscriberInfo(Class cls, Class<? extends SubscriberInfo> cls2, boolean z10) {
        this.subscriberClass = cls;
        this.superSubscriberInfoClass = cls2;
        this.shouldCheckSuperclass = z10;
    }

    public SubscriberMethod createSubscriberMethod(String str, Class<?> cls) {
        return createSubscriberMethod(str, cls, ThreadMode.POSTING, 0, false);
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public Class getSubscriberClass() {
        return this.subscriberClass;
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public SubscriberInfo getSuperSubscriberInfo() {
        Class<? extends SubscriberInfo> cls = this.superSubscriberInfoClass;
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException(e11);
        }
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public boolean shouldCheckSuperclass() {
        return this.shouldCheckSuperclass;
    }

    public SubscriberMethod createSubscriberMethod(String str, Class<?> cls, ThreadMode threadMode) {
        return createSubscriberMethod(str, cls, threadMode, 0, false);
    }

    public SubscriberMethod createSubscriberMethod(String str, Class<?> cls, ThreadMode threadMode, int i10, boolean z10) {
        try {
            return new SubscriberMethod(this.subscriberClass.getDeclaredMethod(str, cls), cls, threadMode, i10, z10);
        } catch (NoSuchMethodException e10) {
            throw new EventBusException("Could not find subscriber method in " + this.subscriberClass + ". Maybe a missing ProGuard rule?", e10);
        }
    }
}
