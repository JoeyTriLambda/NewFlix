package o9;

import com.fasterxml.jackson.core.JsonPointer;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import l8.l;

/* compiled from: DefaultUserAgentPublisher.java */
/* loaded from: classes.dex */
public final class b implements h {

    /* renamed from: a, reason: collision with root package name */
    public final String f17052a;

    /* renamed from: b, reason: collision with root package name */
    public final c f17053b;

    public b(Set<e> set, c cVar) {
        this.f17052a = a(set);
        this.f17053b = cVar;
    }

    public static String a(Set<e> set) {
        StringBuilder sb2 = new StringBuilder();
        Iterator<e> it = set.iterator();
        while (it.hasNext()) {
            e next = it.next();
            sb2.append(next.getLibraryName());
            sb2.append(JsonPointer.SEPARATOR);
            sb2.append(next.getVersion());
            if (it.hasNext()) {
                sb2.append(TokenParser.SP);
            }
        }
        return sb2.toString();
    }

    public static l8.b<h> component() {
        return l8.b.builder(h.class).add(l.setOf(e.class)).factory(new m8.g(6)).build();
    }

    @Override // o9.h
    public String getUserAgent() {
        Set setUnmodifiableSet;
        c cVar = this.f17053b;
        synchronized (cVar.f17055a) {
            setUnmodifiableSet = Collections.unmodifiableSet(cVar.f17055a);
        }
        boolean zIsEmpty = setUnmodifiableSet.isEmpty();
        String str = this.f17052a;
        if (zIsEmpty) {
            return str;
        }
        return str + TokenParser.SP + a(cVar.a());
    }
}
