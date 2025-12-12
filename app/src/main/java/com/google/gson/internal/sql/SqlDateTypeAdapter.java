package com.google.gson.internal.sql;

import ac.c;
import com.google.gson.JsonSyntaxException;
import com.google.gson.i;
import com.google.gson.stream.JsonToken;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import z9.b;

/* loaded from: classes.dex */
public final class SqlDateTypeAdapter extends w<Date> {

    /* renamed from: b, reason: collision with root package name */
    public static final x f10212b = new x() { // from class: com.google.gson.internal.sql.SqlDateTypeAdapter.1
        @Override // com.google.gson.x
        public <T> w<T> create(i iVar, y9.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f10213a = new SimpleDateFormat("MMM d, yyyy");

    @Override // com.google.gson.w
    public Date read(z9.a aVar) throws IOException {
        java.util.Date date;
        if (aVar.peek() == JsonToken.NULL) {
            aVar.nextNull();
            return null;
        }
        String strNextString = aVar.nextString();
        try {
            synchronized (this) {
                date = this.f10213a.parse(strNextString);
            }
            return new Date(date.getTime());
        } catch (ParseException e10) {
            StringBuilder sbV = c.v("Failed parsing '", strNextString, "' as SQL Date; at path ");
            sbV.append(aVar.getPreviousPath());
            throw new JsonSyntaxException(sbV.toString(), e10);
        }
    }

    @Override // com.google.gson.w
    public void write(b bVar, Date date) throws IOException {
        String str;
        if (date == null) {
            bVar.nullValue();
            return;
        }
        synchronized (this) {
            str = this.f10213a.format((java.util.Date) date);
        }
        bVar.value(str);
    }
}
