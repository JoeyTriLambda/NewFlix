package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: JsonArray.java */
/* loaded from: classes.dex */
public final class l extends o implements Iterable<o> {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f10238b = new ArrayList();

    public void add(o oVar) {
        if (oVar == null) {
            oVar = p.f10239b;
        }
        this.f10238b.add(oVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof l) && ((l) obj).f10238b.equals(this.f10238b));
    }

    public o get(int i10) {
        return (o) this.f10238b.get(i10);
    }

    @Override // com.google.gson.o
    public boolean getAsBoolean() {
        ArrayList arrayList = this.f10238b;
        if (arrayList.size() == 1) {
            return ((o) arrayList.get(0)).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.o
    public double getAsDouble() {
        ArrayList arrayList = this.f10238b;
        if (arrayList.size() == 1) {
            return ((o) arrayList.get(0)).getAsDouble();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.o
    public int getAsInt() {
        ArrayList arrayList = this.f10238b;
        if (arrayList.size() == 1) {
            return ((o) arrayList.get(0)).getAsInt();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.o
    public long getAsLong() {
        ArrayList arrayList = this.f10238b;
        if (arrayList.size() == 1) {
            return ((o) arrayList.get(0)).getAsLong();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.o
    public String getAsString() {
        ArrayList arrayList = this.f10238b;
        if (arrayList.size() == 1) {
            return ((o) arrayList.get(0)).getAsString();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.f10238b.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<o> iterator() {
        return this.f10238b.iterator();
    }

    public int size() {
        return this.f10238b.size();
    }
}
