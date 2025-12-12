package org.greenrobot.eventbus;

import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class SubscriberMethod {
    final Class<?> eventType;
    final Method method;
    String methodString;
    final int priority;
    final boolean sticky;
    final ThreadMode threadMode;

    public SubscriberMethod(Method method, Class<?> cls, ThreadMode threadMode, int i10, boolean z10) {
        this.method = method;
        this.threadMode = threadMode;
        this.eventType = cls;
        this.priority = i10;
        this.sticky = z10;
    }

    private synchronized void checkMethodString() {
        if (this.methodString == null) {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append(this.method.getDeclaringClass().getName());
            sb2.append('#');
            sb2.append(this.method.getName());
            sb2.append('(');
            sb2.append(this.eventType.getName());
            this.methodString = sb2.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubscriberMethod)) {
            return false;
        }
        checkMethodString();
        SubscriberMethod subscriberMethod = (SubscriberMethod) obj;
        subscriberMethod.checkMethodString();
        return this.methodString.equals(subscriberMethod.methodString);
    }

    public int hashCode() {
        return this.method.hashCode();
    }
}
