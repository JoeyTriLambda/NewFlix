package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import v9.s;
import v9.v;

/* compiled from: DefaultDateTypeAdapter.java */
/* loaded from: classes.dex */
public final class a<T extends Date> extends w<T> {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0105a<T> f10190a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f10191b;

    public a(AbstractC0105a abstractC0105a, int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        this.f10191b = arrayList;
        this.f10190a = (AbstractC0105a) v9.a.checkNotNull(abstractC0105a);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i10, i11, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i10, i11));
        }
        if (s.isJava9OrLater()) {
            arrayList.add(v.getUSDateTimeFormat(i10, i11));
        }
    }

    public String toString() {
        DateFormat dateFormat = (DateFormat) this.f10191b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    @Override // com.google.gson.w
    public T read(z9.a aVar) throws IOException {
        Date date;
        if (aVar.peek() == JsonToken.NULL) {
            aVar.nextNull();
            return null;
        }
        String strNextString = aVar.nextString();
        synchronized (this.f10191b) {
            Iterator it = this.f10191b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    try {
                        date = w9.a.parse(strNextString, new ParsePosition(0));
                        break;
                    } catch (ParseException e10) {
                        StringBuilder sbV = ac.c.v("Failed parsing '", strNextString, "' as Date; at path ");
                        sbV.append(aVar.getPreviousPath());
                        throw new JsonSyntaxException(sbV.toString(), e10);
                    }
                }
                try {
                    date = ((DateFormat) it.next()).parse(strNextString);
                    break;
                } catch (ParseException unused) {
                }
            }
        }
        return (T) this.f10190a.deserialize(date);
    }

    @Override // com.google.gson.w
    public void write(z9.b bVar, Date date) throws IOException {
        String str;
        if (date == null) {
            bVar.nullValue();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f10191b.get(0);
        synchronized (this.f10191b) {
            str = dateFormat.format(date);
        }
        bVar.value(str);
    }

    /* compiled from: DefaultDateTypeAdapter.java */
    /* renamed from: com.google.gson.internal.bind.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0105a<T extends Date> {

        /* renamed from: b, reason: collision with root package name */
        public static final C0106a f10192b = new C0106a();

        /* renamed from: a, reason: collision with root package name */
        public final Class<T> f10193a;

        public AbstractC0105a(Class<T> cls) {
            this.f10193a = cls;
        }

        public final x createAdapterFactory(int i10, int i11) {
            return TypeAdapters.newFactory(this.f10193a, new a(this, i10, i11));
        }

        public abstract T deserialize(Date date);

        /* compiled from: DefaultDateTypeAdapter.java */
        /* renamed from: com.google.gson.internal.bind.a$a$a, reason: collision with other inner class name */
        public class C0106a extends AbstractC0105a<Date> {
            public C0106a() {
                super(Date.class);
            }

            @Override // com.google.gson.internal.bind.a.AbstractC0105a
            public Date deserialize(Date date) {
                return date;
            }
        }
    }
}
