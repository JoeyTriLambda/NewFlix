package com.google.common.util.concurrent;

import c8.f;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.d;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class CycleDetectingLockFactory {

    public static class ExampleStackTrace extends IllegalStateException {
        static {
            ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), b.class.getName());
        }
    }

    public static final class PotentialDeadlockException extends ExampleStackTrace {
        @Override // java.lang.Throwable
        public String getMessage() {
            String message = super.getMessage();
            Objects.requireNonNull(message);
            return new StringBuilder(message).toString();
        }
    }

    public class a extends ThreadLocal<ArrayList<b>> {
        @Override // java.lang.ThreadLocal
        public ArrayList<b> initialValue() {
            return f.newArrayListWithCapacity(3);
        }
    }

    public static class b {
    }

    static {
        new d().weakKeys().makeMap();
        Logger.getLogger(CycleDetectingLockFactory.class.getName());
        new a();
    }
}
