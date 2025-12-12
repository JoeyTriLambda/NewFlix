package io.reactivex.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes2.dex */
public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;

    /* renamed from: b, reason: collision with root package name */
    public final List<Throwable> f13528b;

    /* renamed from: m, reason: collision with root package name */
    public final String f13529m;

    /* renamed from: n, reason: collision with root package name */
    public Throwable f13530n;

    public static final class CompositeExceptionCausalChain extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        @Override // java.lang.Throwable
        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    public static abstract class a {
        public abstract void a(String str);
    }

    public static final class b extends a {

        /* renamed from: a, reason: collision with root package name */
        public final PrintStream f13531a;

        public b(PrintStream printStream) {
            this.f13531a = printStream;
        }

        @Override // io.reactivex.exceptions.CompositeException.a
        public final void a(String str) {
            this.f13531a.println((Object) str);
        }
    }

    public static final class c extends a {

        /* renamed from: a, reason: collision with root package name */
        public final PrintWriter f13532a;

        public c(PrintWriter printWriter) {
            this.f13532a = printWriter;
        }

        @Override // io.reactivex.exceptions.CompositeException.a
        public final void a(String str) {
            this.f13532a.println((Object) str);
        }
    }

    public CompositeException(Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    public static void a(StringBuilder sb2, Throwable th2, String str) {
        sb2.append(str);
        sb2.append(th2);
        sb2.append('\n');
        for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
            sb2.append("\t\tat ");
            sb2.append(stackTraceElement);
            sb2.append('\n');
        }
        if (th2.getCause() != null) {
            sb2.append("\tCaused by: ");
            a(sb2, th2.getCause(), "");
        }
    }

    public final void b(a aVar) {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(this);
        sb2.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb2.append("\tat ");
            sb2.append(stackTraceElement);
            sb2.append('\n');
        }
        int i10 = 1;
        for (Throwable th2 : this.f13528b) {
            sb2.append("  ComposedException ");
            sb2.append(i10);
            sb2.append(" :\n");
            a(sb2, th2, "\t");
            i10++;
        }
        aVar.a(sb2.toString());
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        if (this.f13530n == null) {
            CompositeExceptionCausalChain compositeExceptionCausalChain = new CompositeExceptionCausalChain();
            HashSet hashSet = new HashSet();
            Iterator<Throwable> it = this.f13528b.iterator();
            CompositeExceptionCausalChain compositeExceptionCausalChain2 = compositeExceptionCausalChain;
            while (it.hasNext()) {
                Throwable next = it.next();
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    ArrayList arrayList = new ArrayList();
                    Throwable cause = next.getCause();
                    if (cause != null && cause != next) {
                        while (true) {
                            arrayList.add(cause);
                            Throwable cause2 = cause.getCause();
                            if (cause2 == null || cause2 == cause) {
                                break;
                            }
                            cause = cause2;
                        }
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        Throwable th2 = (Throwable) it2.next();
                        if (hashSet.contains(th2)) {
                            next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(th2);
                        }
                    }
                    try {
                        compositeExceptionCausalChain2.initCause(next);
                    } catch (Throwable unused) {
                    }
                    Throwable cause3 = compositeExceptionCausalChain2.getCause();
                    if (cause3 != null && compositeExceptionCausalChain2 != cause3) {
                        while (true) {
                            Throwable cause4 = cause3.getCause();
                            if (cause4 == null || cause4 == cause3) {
                                break;
                            }
                            cause3 = cause4;
                        }
                        compositeExceptionCausalChain2 = cause3;
                    }
                }
            }
            this.f13530n = compositeExceptionCausalChain;
        }
        return this.f13530n;
    }

    public List<Throwable> getExceptions() {
        return this.f13528b;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f13529m;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        b(new b(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        b(new c(printWriter));
    }

    public CompositeException(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable th2 : iterable) {
                if (th2 instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th2).getExceptions());
                } else if (th2 != null) {
                    linkedHashSet.add(th2);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            arrayList.addAll(linkedHashSet);
            List<Throwable> listUnmodifiableList = Collections.unmodifiableList(arrayList);
            this.f13528b = listUnmodifiableList;
            this.f13529m = listUnmodifiableList.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }
}
