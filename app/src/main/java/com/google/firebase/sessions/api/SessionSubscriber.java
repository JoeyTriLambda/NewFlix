package com.google.firebase.sessions.api;

import ac.c;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import zf.i;

/* compiled from: SessionSubscriber.kt */
/* loaded from: classes.dex */
public interface SessionSubscriber {

    /* compiled from: SessionSubscriber.kt */
    public enum Name {
        CRASHLYTICS,
        PERFORMANCE,
        /* JADX INFO: Fake field, exist only in values array */
        MATT_SAYS_HI
    }

    /* compiled from: SessionSubscriber.kt */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f9981a;

        public a(String str) {
            i.checkNotNullParameter(str, JsonStorageKeyNames.SESSION_ID_KEY);
            this.f9981a = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && i.areEqual(this.f9981a, ((a) obj).f9981a);
        }

        public final String getSessionId() {
            return this.f9981a;
        }

        public int hashCode() {
            return this.f9981a.hashCode();
        }

        public String toString() {
            return c.n(new StringBuilder("SessionDetails(sessionId="), this.f9981a, ')');
        }
    }

    Name getSessionSubscriberName();

    boolean isDataCollectionEnabled();

    void onSessionChanged(a aVar);
}
