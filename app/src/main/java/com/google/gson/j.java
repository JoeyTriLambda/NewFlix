package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.bind.a;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/* compiled from: GsonBuilder.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final Excluder f10224a = Excluder.f10072q;

    /* renamed from: b, reason: collision with root package name */
    public final LongSerializationPolicy f10225b = LongSerializationPolicy.f10036b;

    /* renamed from: c, reason: collision with root package name */
    public final c f10226c = FieldNamingPolicy.f10034b;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f10227d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f10228e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f10229f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final int f10230g;

    /* renamed from: h, reason: collision with root package name */
    public final int f10231h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f10232i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10233j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f10234k;

    /* renamed from: l, reason: collision with root package name */
    public final v f10235l;

    /* renamed from: m, reason: collision with root package name */
    public final v f10236m;

    /* renamed from: n, reason: collision with root package name */
    public final LinkedList<ReflectionAccessFilter> f10237n;

    public j() {
        y9.a<?> aVar = i.f10049o;
        this.f10230g = 2;
        this.f10231h = 2;
        this.f10232i = true;
        this.f10233j = false;
        this.f10234k = true;
        this.f10235l = ToNumberPolicy.f10043b;
        this.f10236m = ToNumberPolicy.f10044m;
        this.f10237n = new LinkedList<>();
    }

    public i create() {
        int i10;
        x xVarCreateAdapterFactory;
        x xVarCreateAdapterFactory2;
        ArrayList arrayList = this.f10228e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f10229f;
        ArrayList arrayList3 = new ArrayList(arrayList2.size() + size + 3);
        arrayList3.addAll(arrayList);
        Collections.reverse(arrayList3);
        ArrayList arrayList4 = new ArrayList(arrayList2);
        Collections.reverse(arrayList4);
        arrayList3.addAll(arrayList4);
        boolean z10 = com.google.gson.internal.sql.a.f10218a;
        int i11 = this.f10230g;
        if (i11 != 2 && (i10 = this.f10231h) != 2) {
            x xVarCreateAdapterFactory3 = a.AbstractC0105a.f10192b.createAdapterFactory(i11, i10);
            if (z10) {
                xVarCreateAdapterFactory = com.google.gson.internal.sql.a.f10220c.createAdapterFactory(i11, i10);
                xVarCreateAdapterFactory2 = com.google.gson.internal.sql.a.f10219b.createAdapterFactory(i11, i10);
            } else {
                xVarCreateAdapterFactory = null;
                xVarCreateAdapterFactory2 = null;
            }
            arrayList3.add(xVarCreateAdapterFactory3);
            if (z10) {
                arrayList3.add(xVarCreateAdapterFactory);
                arrayList3.add(xVarCreateAdapterFactory2);
            }
        }
        return new i(this.f10224a, this.f10226c, new HashMap(this.f10227d), this.f10232i, this.f10233j, this.f10234k, this.f10225b, new ArrayList(arrayList), new ArrayList(arrayList2), arrayList3, this.f10235l, this.f10236m, new ArrayList(this.f10237n));
    }

    public j registerTypeAdapter(Type type, Object obj) {
        boolean z10 = obj instanceof u;
        v9.a.checkArgument(z10 || (obj instanceof n) || (obj instanceof k) || (obj instanceof w));
        if (obj instanceof k) {
            this.f10227d.put(type, (k) obj);
        }
        ArrayList arrayList = this.f10228e;
        if (z10 || (obj instanceof n)) {
            arrayList.add(TreeTypeAdapter.newFactoryWithMatchRawType(y9.a.get(type), obj));
        }
        if (obj instanceof w) {
            arrayList.add(TypeAdapters.newFactory(y9.a.get(type), (w) obj));
        }
        return this;
    }

    public j setLenient() {
        this.f10233j = true;
        return this;
    }
}
