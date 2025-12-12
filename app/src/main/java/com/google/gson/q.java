package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

/* compiled from: JsonObject.java */
/* loaded from: classes.dex */
public final class q extends o {

    /* renamed from: b, reason: collision with root package name */
    public final LinkedTreeMap<String, o> f10240b = new LinkedTreeMap<>();

    public void add(String str, o oVar) {
        if (oVar == null) {
            oVar = p.f10239b;
        }
        this.f10240b.put(str, oVar);
    }

    public void addProperty(String str, String str2) {
        add(str, str2 == null ? p.f10239b : new s(str2));
    }

    public Set<Map.Entry<String, o>> entrySet() {
        return this.f10240b.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof q) && ((q) obj).f10240b.equals(this.f10240b));
    }

    public o get(String str) {
        return this.f10240b.get(str);
    }

    public l getAsJsonArray(String str) {
        return (l) this.f10240b.get(str);
    }

    public q getAsJsonObject(String str) {
        return (q) this.f10240b.get(str);
    }

    public boolean has(String str) {
        return this.f10240b.containsKey(str);
    }

    public int hashCode() {
        return this.f10240b.hashCode();
    }

    public int size() {
        return this.f10240b.size();
    }
}
