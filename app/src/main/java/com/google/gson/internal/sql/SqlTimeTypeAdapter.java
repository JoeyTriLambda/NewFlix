package com.google.gson.internal.sql;

import ac.c;
import com.google.gson.JsonSyntaxException;
import com.google.gson.i;
import com.google.gson.stream.JsonToken;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import z9.b;

/* loaded from: classes.dex */
public final class SqlTimeTypeAdapter extends w<Time> {

    /* renamed from: b, reason: collision with root package name */
    public static final x f10214b = new x() { // from class: com.google.gson.internal.sql.SqlTimeTypeAdapter.1
        @Override // com.google.gson.x
        public <T> w<T> create(i iVar, y9.a<T> aVar) {
            if (aVar.getRawType() == Time.class) {
                return new SqlTimeTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f10215a = new SimpleDateFormat("hh:mm:ss a");

    @Override // com.google.gson.w
    public Time read(z9.a aVar) throws IOException {
        Time time;
        if (aVar.peek() == JsonToken.NULL) {
            aVar.nextNull();
            return null;
        }
        String strNextString = aVar.nextString();
        try {
            synchronized (this) {
                time = new Time(this.f10215a.parse(strNextString).getTime());
            }
            return time;
        } catch (ParseException e10) {
            StringBuilder sbV = c.v("Failed parsing '", strNextString, "' as SQL Time; at path ");
            sbV.append(aVar.getPreviousPath());
            throw new JsonSyntaxException(sbV.toString(), e10);
        }
    }

    @Override // com.google.gson.w
    public void write(b bVar, Time time) throws IOException {
        String str;
        if (time == null) {
            bVar.nullValue();
            return;
        }
        synchronized (this) {
            str = this.f10215a.format((Date) time);
        }
        bVar.value(str);
    }
}
