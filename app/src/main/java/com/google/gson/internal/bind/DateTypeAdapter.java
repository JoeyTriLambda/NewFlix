package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.i;
import com.google.gson.stream.JsonToken;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import v9.s;
import v9.v;

/* loaded from: classes.dex */
public final class DateTypeAdapter extends w<Date> {

    /* renamed from: b, reason: collision with root package name */
    public static final x f10113b = new x() { // from class: com.google.gson.internal.bind.DateTypeAdapter.1
        @Override // com.google.gson.x
        public <T> w<T> create(i iVar, y9.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10114a;

    public DateTypeAdapter() {
        ArrayList arrayList = new ArrayList();
        this.f10114a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (s.isJava9OrLater()) {
            arrayList.add(v.getUSDateTimeFormat(2, 2));
        }
    }

    @Override // com.google.gson.w
    public Date read(z9.a aVar) throws IOException {
        if (aVar.peek() == JsonToken.NULL) {
            aVar.nextNull();
            return null;
        }
        String strNextString = aVar.nextString();
        synchronized (this.f10114a) {
            Iterator it = this.f10114a.iterator();
            while (it.hasNext()) {
                try {
                    return ((DateFormat) it.next()).parse(strNextString);
                } catch (ParseException unused) {
                }
            }
            try {
                return w9.a.parse(strNextString, new ParsePosition(0));
            } catch (ParseException e10) {
                StringBuilder sbV = ac.c.v("Failed parsing '", strNextString, "' as Date; at path ");
                sbV.append(aVar.getPreviousPath());
                throw new JsonSyntaxException(sbV.toString(), e10);
            }
        }
    }

    @Override // com.google.gson.w
    public void write(z9.b bVar, Date date) throws IOException {
        String str;
        if (date == null) {
            bVar.nullValue();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f10114a.get(0);
        synchronized (this.f10114a) {
            str = dateFormat.format(date);
        }
        bVar.value(str);
    }
}
