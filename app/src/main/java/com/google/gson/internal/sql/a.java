package com.google.gson.internal.sql;

import com.google.gson.internal.bind.a;
import com.google.gson.x;
import java.sql.Date;
import java.sql.Timestamp;

/* compiled from: SqlTypesSupport.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f10218a;

    /* renamed from: b, reason: collision with root package name */
    public static final C0107a f10219b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f10220c;

    /* renamed from: d, reason: collision with root package name */
    public static final x f10221d;

    /* renamed from: e, reason: collision with root package name */
    public static final x f10222e;

    /* renamed from: f, reason: collision with root package name */
    public static final x f10223f;

    /* compiled from: SqlTypesSupport.java */
    /* renamed from: com.google.gson.internal.sql.a$a, reason: collision with other inner class name */
    public class C0107a extends a.AbstractC0105a<Date> {
        public C0107a() {
            super(Date.class);
        }

        @Override // com.google.gson.internal.bind.a.AbstractC0105a
        public Date deserialize(java.util.Date date) {
            return new Date(date.getTime());
        }
    }

    /* compiled from: SqlTypesSupport.java */
    public class b extends a.AbstractC0105a<Timestamp> {
        public b() {
            super(Timestamp.class);
        }

        @Override // com.google.gson.internal.bind.a.AbstractC0105a
        public Timestamp deserialize(java.util.Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z10;
        try {
            Class.forName("java.sql.Date");
            z10 = true;
        } catch (ClassNotFoundException unused) {
            z10 = false;
        }
        f10218a = z10;
        if (z10) {
            f10219b = new C0107a();
            f10220c = new b();
            f10221d = SqlDateTypeAdapter.f10212b;
            f10222e = SqlTimeTypeAdapter.f10214b;
            f10223f = SqlTimestampTypeAdapter.f10216b;
            return;
        }
        f10219b = null;
        f10220c = null;
        f10221d = null;
        f10222e = null;
        f10223f = null;
    }
}
