package com.google.gson.internal.sql;

import com.google.gson.i;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import z9.b;

/* loaded from: classes.dex */
public final class SqlTimestampTypeAdapter extends w<Timestamp> {

    /* renamed from: b, reason: collision with root package name */
    public static final x f10216b = new x() { // from class: com.google.gson.internal.sql.SqlTimestampTypeAdapter.1
        @Override // com.google.gson.x
        public <T> w<T> create(i iVar, y9.a<T> aVar) {
            if (aVar.getRawType() == Timestamp.class) {
                return new SqlTimestampTypeAdapter(iVar.getAdapter(Date.class));
            }
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final w<Date> f10217a;

    public SqlTimestampTypeAdapter(w wVar) {
        this.f10217a = wVar;
    }

    @Override // com.google.gson.w
    public Timestamp read(z9.a aVar) throws IOException {
        Date date = this.f10217a.read(aVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // com.google.gson.w
    public void write(b bVar, Timestamp timestamp) throws IOException {
        this.f10217a.write(bVar, timestamp);
    }
}
