package com.google.gson.internal.bind;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: classes.dex */
public final class TypeAdapters {
    public static final com.google.gson.x A;
    public static final com.google.gson.x B;

    /* renamed from: a, reason: collision with root package name */
    public static final com.google.gson.x f10146a = newFactory(Class.class, new k().nullSafe());

    /* renamed from: b, reason: collision with root package name */
    public static final com.google.gson.x f10147b = newFactory(BitSet.class, new u().nullSafe());

    /* renamed from: c, reason: collision with root package name */
    public static final w f10148c;

    /* renamed from: d, reason: collision with root package name */
    public static final com.google.gson.x f10149d;

    /* renamed from: e, reason: collision with root package name */
    public static final com.google.gson.x f10150e;

    /* renamed from: f, reason: collision with root package name */
    public static final com.google.gson.x f10151f;

    /* renamed from: g, reason: collision with root package name */
    public static final com.google.gson.x f10152g;

    /* renamed from: h, reason: collision with root package name */
    public static final com.google.gson.x f10153h;

    /* renamed from: i, reason: collision with root package name */
    public static final com.google.gson.x f10154i;

    /* renamed from: j, reason: collision with root package name */
    public static final com.google.gson.x f10155j;

    /* renamed from: k, reason: collision with root package name */
    public static final b f10156k;

    /* renamed from: l, reason: collision with root package name */
    public static final com.google.gson.x f10157l;

    /* renamed from: m, reason: collision with root package name */
    public static final g f10158m;

    /* renamed from: n, reason: collision with root package name */
    public static final h f10159n;

    /* renamed from: o, reason: collision with root package name */
    public static final i f10160o;

    /* renamed from: p, reason: collision with root package name */
    public static final com.google.gson.x f10161p;

    /* renamed from: q, reason: collision with root package name */
    public static final com.google.gson.x f10162q;

    /* renamed from: r, reason: collision with root package name */
    public static final com.google.gson.x f10163r;

    /* renamed from: s, reason: collision with root package name */
    public static final com.google.gson.x f10164s;

    /* renamed from: t, reason: collision with root package name */
    public static final com.google.gson.x f10165t;

    /* renamed from: u, reason: collision with root package name */
    public static final com.google.gson.x f10166u;

    /* renamed from: v, reason: collision with root package name */
    public static final com.google.gson.x f10167v;

    /* renamed from: w, reason: collision with root package name */
    public static final com.google.gson.x f10168w;

    /* renamed from: x, reason: collision with root package name */
    public static final com.google.gson.x f10169x;

    /* renamed from: y, reason: collision with root package name */
    public static final com.google.gson.x f10170y;

    /* renamed from: z, reason: collision with root package name */
    public static final t f10171z;

    public class a extends com.google.gson.w<AtomicIntegerArray> {
        @Override // com.google.gson.w
        public AtomicIntegerArray read(z9.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.beginArray();
            while (aVar.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.nextInt()));
                } catch (NumberFormatException e10) {
                    throw new JsonSyntaxException(e10);
                }
            }
            aVar.endArray();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicIntegerArray.set(i10, ((Integer) arrayList.get(i10)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            bVar.beginArray();
            int length = atomicIntegerArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                bVar.value(atomicIntegerArray.get(i10));
            }
            bVar.endArray();
        }
    }

    public class a0 extends com.google.gson.w<AtomicInteger> {
        @Override // com.google.gson.w
        public AtomicInteger read(z9.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.nextInt());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, AtomicInteger atomicInteger) throws IOException {
            bVar.value(atomicInteger.get());
        }
    }

    public class b extends com.google.gson.w<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.w
        public Number read(z9.a aVar) throws IOException {
            if (aVar.peek() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                return Long.valueOf(aVar.nextLong());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, Number number) throws IOException {
            bVar.value(number);
        }
    }

    public class b0 extends com.google.gson.w<AtomicBoolean> {
        @Override // com.google.gson.w
        public AtomicBoolean read(z9.a aVar) throws IOException {
            return new AtomicBoolean(aVar.nextBoolean());
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, AtomicBoolean atomicBoolean) throws IOException {
            bVar.value(atomicBoolean.get());
        }
    }

    public class c extends com.google.gson.w<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.w
        public Number read(z9.a aVar) throws IOException {
            if (aVar.peek() != JsonToken.NULL) {
                return Float.valueOf((float) aVar.nextDouble());
            }
            aVar.nextNull();
            return null;
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, Number number) throws IOException {
            bVar.value(number);
        }
    }

    public static final class c0<T extends Enum<T>> extends com.google.gson.w<T> {

        /* renamed from: a, reason: collision with root package name */
        public final HashMap f10186a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final HashMap f10187b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        public final HashMap f10188c = new HashMap();

        public class a implements PrivilegedAction<Field[]> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Class f10189a;

            public a(Class cls) {
                this.f10189a = cls;
            }

            @Override // java.security.PrivilegedAction
            public Field[] run() throws SecurityException {
                Field[] declaredFields = this.f10189a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public c0(Class<T> cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(cls))) {
                    Enum r42 = (Enum) field.get(null);
                    String strName = r42.name();
                    String string = r42.toString();
                    u9.b bVar = (u9.b) field.getAnnotation(u9.b.class);
                    if (bVar != null) {
                        strName = bVar.value();
                        for (String str : bVar.alternate()) {
                            this.f10186a.put(str, r42);
                        }
                    }
                    this.f10186a.put(strName, r42);
                    this.f10187b.put(string, r42);
                    this.f10188c.put(r42, strName);
                }
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // com.google.gson.w
        public T read(z9.a aVar) throws IOException {
            if (aVar.peek() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            String strNextString = aVar.nextString();
            T t10 = (T) this.f10186a.get(strNextString);
            return t10 == null ? (T) this.f10187b.get(strNextString) : t10;
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, T t10) throws IOException {
            bVar.value(t10 == null ? null : (String) this.f10188c.get(t10));
        }
    }

    public class d extends com.google.gson.w<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.w
        public Number read(z9.a aVar) throws IOException {
            if (aVar.peek() != JsonToken.NULL) {
                return Double.valueOf(aVar.nextDouble());
            }
            aVar.nextNull();
            return null;
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, Number number) throws IOException {
            bVar.value(number);
        }
    }

    public class e extends com.google.gson.w<Character> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.w
        public Character read(z9.a aVar) throws IOException {
            if (aVar.peek() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            String strNextString = aVar.nextString();
            if (strNextString.length() == 1) {
                return Character.valueOf(strNextString.charAt(0));
            }
            StringBuilder sbV = ac.c.v("Expecting character, got: ", strNextString, "; at ");
            sbV.append(aVar.getPreviousPath());
            throw new JsonSyntaxException(sbV.toString());
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, Character ch2) throws IOException {
            bVar.value(ch2 == null ? null : String.valueOf(ch2));
        }
    }

    public class f extends com.google.gson.w<String> {
        @Override // com.google.gson.w
        public String read(z9.a aVar) throws IOException {
            JsonToken jsonTokenPeek = aVar.peek();
            if (jsonTokenPeek != JsonToken.NULL) {
                return jsonTokenPeek == JsonToken.BOOLEAN ? Boolean.toString(aVar.nextBoolean()) : aVar.nextString();
            }
            aVar.nextNull();
            return null;
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, String str) throws IOException {
            bVar.value(str);
        }
    }

    public class g extends com.google.gson.w<BigDecimal> {
        @Override // com.google.gson.w
        public BigDecimal read(z9.a aVar) throws IOException {
            if (aVar.peek() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            String strNextString = aVar.nextString();
            try {
                return new BigDecimal(strNextString);
            } catch (NumberFormatException e10) {
                StringBuilder sbV = ac.c.v("Failed parsing '", strNextString, "' as BigDecimal; at path ");
                sbV.append(aVar.getPreviousPath());
                throw new JsonSyntaxException(sbV.toString(), e10);
            }
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, BigDecimal bigDecimal) throws IOException {
            bVar.value(bigDecimal);
        }
    }

    public class h extends com.google.gson.w<BigInteger> {
        @Override // com.google.gson.w
        public BigInteger read(z9.a aVar) throws IOException {
            if (aVar.peek() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            String strNextString = aVar.nextString();
            try {
                return new BigInteger(strNextString);
            } catch (NumberFormatException e10) {
                StringBuilder sbV = ac.c.v("Failed parsing '", strNextString, "' as BigInteger; at path ");
                sbV.append(aVar.getPreviousPath());
                throw new JsonSyntaxException(sbV.toString(), e10);
            }
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, BigInteger bigInteger) throws IOException {
            bVar.value(bigInteger);
        }
    }

    public class i extends com.google.gson.w<LazilyParsedNumber> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.w
        public LazilyParsedNumber read(z9.a aVar) throws IOException {
            if (aVar.peek() != JsonToken.NULL) {
                return new LazilyParsedNumber(aVar.nextString());
            }
            aVar.nextNull();
            return null;
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, LazilyParsedNumber lazilyParsedNumber) throws IOException {
            bVar.value(lazilyParsedNumber);
        }
    }

    public class j extends com.google.gson.w<StringBuilder> {
        @Override // com.google.gson.w
        public StringBuilder read(z9.a aVar) throws IOException {
            if (aVar.peek() != JsonToken.NULL) {
                return new StringBuilder(aVar.nextString());
            }
            aVar.nextNull();
            return null;
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, StringBuilder sb2) throws IOException {
            bVar.value(sb2 == null ? null : sb2.toString());
        }
    }

    public class k extends com.google.gson.w<Class> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.w
        public Class read(z9.a aVar) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, Class cls) throws IOException {
            throw new UnsupportedOperationException(ac.c.d(cls, new StringBuilder("Attempted to serialize java.lang.Class: "), ". Forgot to register a type adapter?"));
        }
    }

    public class l extends com.google.gson.w<StringBuffer> {
        @Override // com.google.gson.w
        public StringBuffer read(z9.a aVar) throws IOException {
            if (aVar.peek() != JsonToken.NULL) {
                return new StringBuffer(aVar.nextString());
            }
            aVar.nextNull();
            return null;
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, StringBuffer stringBuffer) throws IOException {
            bVar.value(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    public class m extends com.google.gson.w<URL> {
        @Override // com.google.gson.w
        public URL read(z9.a aVar) throws IOException {
            if (aVar.peek() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            String strNextString = aVar.nextString();
            if ("null".equals(strNextString)) {
                return null;
            }
            return new URL(strNextString);
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, URL url) throws IOException {
            bVar.value(url == null ? null : url.toExternalForm());
        }
    }

    public class n extends com.google.gson.w<URI> {
        @Override // com.google.gson.w
        public URI read(z9.a aVar) throws IOException {
            if (aVar.peek() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                String strNextString = aVar.nextString();
                if ("null".equals(strNextString)) {
                    return null;
                }
                return new URI(strNextString);
            } catch (URISyntaxException e10) {
                throw new JsonIOException(e10);
            }
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, URI uri) throws IOException {
            bVar.value(uri == null ? null : uri.toASCIIString());
        }
    }

    public class o extends com.google.gson.w<InetAddress> {
        @Override // com.google.gson.w
        public InetAddress read(z9.a aVar) throws IOException {
            if (aVar.peek() != JsonToken.NULL) {
                return InetAddress.getByName(aVar.nextString());
            }
            aVar.nextNull();
            return null;
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, InetAddress inetAddress) throws IOException {
            bVar.value(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    public class p extends com.google.gson.w<UUID> {
        @Override // com.google.gson.w
        public UUID read(z9.a aVar) throws IOException {
            if (aVar.peek() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            String strNextString = aVar.nextString();
            try {
                return UUID.fromString(strNextString);
            } catch (IllegalArgumentException e10) {
                StringBuilder sbV = ac.c.v("Failed parsing '", strNextString, "' as UUID; at path ");
                sbV.append(aVar.getPreviousPath());
                throw new JsonSyntaxException(sbV.toString(), e10);
            }
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, UUID uuid) throws IOException {
            bVar.value(uuid == null ? null : uuid.toString());
        }
    }

    public class q extends com.google.gson.w<Currency> {
        @Override // com.google.gson.w
        public Currency read(z9.a aVar) throws IOException {
            String strNextString = aVar.nextString();
            try {
                return Currency.getInstance(strNextString);
            } catch (IllegalArgumentException e10) {
                StringBuilder sbV = ac.c.v("Failed parsing '", strNextString, "' as Currency; at path ");
                sbV.append(aVar.getPreviousPath());
                throw new JsonSyntaxException(sbV.toString(), e10);
            }
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, Currency currency) throws IOException {
            bVar.value(currency.getCurrencyCode());
        }
    }

    public class r extends com.google.gson.w<Calendar> {
        @Override // com.google.gson.w
        public Calendar read(z9.a aVar) throws IOException, NumberFormatException {
            if (aVar.peek() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            aVar.beginObject();
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (aVar.peek() != JsonToken.END_OBJECT) {
                String strNextName = aVar.nextName();
                int iNextInt = aVar.nextInt();
                if ("year".equals(strNextName)) {
                    i10 = iNextInt;
                } else if ("month".equals(strNextName)) {
                    i11 = iNextInt;
                } else if ("dayOfMonth".equals(strNextName)) {
                    i12 = iNextInt;
                } else if ("hourOfDay".equals(strNextName)) {
                    i13 = iNextInt;
                } else if ("minute".equals(strNextName)) {
                    i14 = iNextInt;
                } else if ("second".equals(strNextName)) {
                    i15 = iNextInt;
                }
            }
            aVar.endObject();
            return new GregorianCalendar(i10, i11, i12, i13, i14, i15);
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                bVar.nullValue();
                return;
            }
            bVar.beginObject();
            bVar.name("year");
            bVar.value(calendar.get(1));
            bVar.name("month");
            bVar.value(calendar.get(2));
            bVar.name("dayOfMonth");
            bVar.value(calendar.get(5));
            bVar.name("hourOfDay");
            bVar.value(calendar.get(11));
            bVar.name("minute");
            bVar.value(calendar.get(12));
            bVar.name("second");
            bVar.value(calendar.get(13));
            bVar.endObject();
        }
    }

    public class s extends com.google.gson.w<Locale> {
        @Override // com.google.gson.w
        public Locale read(z9.a aVar) throws IOException {
            if (aVar.peek() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.nextString(), "_");
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, Locale locale) throws IOException {
            bVar.value(locale == null ? null : locale.toString());
        }
    }

    public class t extends com.google.gson.w<com.google.gson.o> {
        public static com.google.gson.o a(z9.a aVar, JsonToken jsonToken) throws IOException {
            int iOrdinal = jsonToken.ordinal();
            if (iOrdinal == 5) {
                return new com.google.gson.s(aVar.nextString());
            }
            if (iOrdinal == 6) {
                return new com.google.gson.s(new LazilyParsedNumber(aVar.nextString()));
            }
            if (iOrdinal == 7) {
                return new com.google.gson.s(Boolean.valueOf(aVar.nextBoolean()));
            }
            if (iOrdinal == 8) {
                aVar.nextNull();
                return com.google.gson.p.f10239b;
            }
            throw new IllegalStateException("Unexpected token: " + jsonToken);
        }

        public static com.google.gson.o b(z9.a aVar, JsonToken jsonToken) throws IOException {
            int iOrdinal = jsonToken.ordinal();
            if (iOrdinal == 0) {
                aVar.beginArray();
                return new com.google.gson.l();
            }
            if (iOrdinal != 2) {
                return null;
            }
            aVar.beginObject();
            return new com.google.gson.q();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.w
        public com.google.gson.o read(z9.a aVar) throws IOException {
            if (aVar instanceof com.google.gson.internal.bind.b) {
                com.google.gson.internal.bind.b bVar = (com.google.gson.internal.bind.b) aVar;
                JsonToken jsonTokenPeek = bVar.peek();
                if (jsonTokenPeek != JsonToken.NAME && jsonTokenPeek != JsonToken.END_ARRAY && jsonTokenPeek != JsonToken.END_OBJECT && jsonTokenPeek != JsonToken.END_DOCUMENT) {
                    com.google.gson.o oVar = (com.google.gson.o) bVar.p();
                    bVar.skipValue();
                    return oVar;
                }
                throw new IllegalStateException("Unexpected " + jsonTokenPeek + " when reading a JsonElement.");
            }
            JsonToken jsonTokenPeek2 = aVar.peek();
            com.google.gson.o oVarB = b(aVar, jsonTokenPeek2);
            if (oVarB == null) {
                return a(aVar, jsonTokenPeek2);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (aVar.hasNext()) {
                    String strNextName = oVarB instanceof com.google.gson.q ? aVar.nextName() : null;
                    JsonToken jsonTokenPeek3 = aVar.peek();
                    com.google.gson.o oVarB2 = b(aVar, jsonTokenPeek3);
                    boolean z10 = oVarB2 != null;
                    com.google.gson.o oVarA = oVarB2 == null ? a(aVar, jsonTokenPeek3) : oVarB2;
                    if (oVarB instanceof com.google.gson.l) {
                        ((com.google.gson.l) oVarB).add(oVarA);
                    } else {
                        ((com.google.gson.q) oVarB).add(strNextName, oVarA);
                    }
                    if (z10) {
                        arrayDeque.addLast(oVarB);
                        oVarB = oVarA;
                    }
                } else {
                    if (oVarB instanceof com.google.gson.l) {
                        aVar.endArray();
                    } else {
                        aVar.endObject();
                    }
                    if (arrayDeque.isEmpty()) {
                        return oVarB;
                    }
                    oVarB = (com.google.gson.o) arrayDeque.removeLast();
                }
            }
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, com.google.gson.o oVar) throws IOException {
            if (oVar == null || oVar.isJsonNull()) {
                bVar.nullValue();
                return;
            }
            if (oVar.isJsonPrimitive()) {
                com.google.gson.s asJsonPrimitive = oVar.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    bVar.value(asJsonPrimitive.getAsNumber());
                    return;
                } else if (asJsonPrimitive.isBoolean()) {
                    bVar.value(asJsonPrimitive.getAsBoolean());
                    return;
                } else {
                    bVar.value(asJsonPrimitive.getAsString());
                    return;
                }
            }
            if (oVar.isJsonArray()) {
                bVar.beginArray();
                Iterator<com.google.gson.o> it = oVar.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(bVar, it.next());
                }
                bVar.endArray();
                return;
            }
            if (!oVar.isJsonObject()) {
                throw new IllegalArgumentException("Couldn't write " + oVar.getClass());
            }
            bVar.beginObject();
            for (Map.Entry<String, com.google.gson.o> entry : oVar.getAsJsonObject().entrySet()) {
                bVar.name(entry.getKey());
                write(bVar, entry.getValue());
            }
            bVar.endObject();
        }
    }

    public class u extends com.google.gson.w<BitSet> {
        @Override // com.google.gson.w
        public BitSet read(z9.a aVar) throws IOException, NumberFormatException {
            boolean zNextBoolean;
            BitSet bitSet = new BitSet();
            aVar.beginArray();
            JsonToken jsonTokenPeek = aVar.peek();
            int i10 = 0;
            while (jsonTokenPeek != JsonToken.END_ARRAY) {
                int iOrdinal = jsonTokenPeek.ordinal();
                if (iOrdinal == 5 || iOrdinal == 6) {
                    int iNextInt = aVar.nextInt();
                    if (iNextInt == 0) {
                        zNextBoolean = false;
                    } else {
                        if (iNextInt != 1) {
                            StringBuilder sbS = ac.c.s("Invalid bitset value ", iNextInt, ", expected 0 or 1; at path ");
                            sbS.append(aVar.getPreviousPath());
                            throw new JsonSyntaxException(sbS.toString());
                        }
                        zNextBoolean = true;
                    }
                } else {
                    if (iOrdinal != 7) {
                        throw new JsonSyntaxException("Invalid bitset value type: " + jsonTokenPeek + "; at path " + aVar.getPath());
                    }
                    zNextBoolean = aVar.nextBoolean();
                }
                if (zNextBoolean) {
                    bitSet.set(i10);
                }
                i10++;
                jsonTokenPeek = aVar.peek();
            }
            aVar.endArray();
            return bitSet;
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, BitSet bitSet) throws IOException {
            bVar.beginArray();
            int length = bitSet.length();
            for (int i10 = 0; i10 < length; i10++) {
                bVar.value(bitSet.get(i10) ? 1L : 0L);
            }
            bVar.endArray();
        }
    }

    public class v extends com.google.gson.w<Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.w
        public Boolean read(z9.a aVar) throws IOException {
            JsonToken jsonTokenPeek = aVar.peek();
            if (jsonTokenPeek != JsonToken.NULL) {
                return jsonTokenPeek == JsonToken.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.nextString())) : Boolean.valueOf(aVar.nextBoolean());
            }
            aVar.nextNull();
            return null;
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, Boolean bool) throws IOException {
            bVar.value(bool);
        }
    }

    public class w extends com.google.gson.w<Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.w
        public Boolean read(z9.a aVar) throws IOException {
            if (aVar.peek() != JsonToken.NULL) {
                return Boolean.valueOf(aVar.nextString());
            }
            aVar.nextNull();
            return null;
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, Boolean bool) throws IOException {
            bVar.value(bool == null ? "null" : bool.toString());
        }
    }

    public class x extends com.google.gson.w<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.w
        public Number read(z9.a aVar) throws IOException {
            if (aVar.peek() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                int iNextInt = aVar.nextInt();
                if (iNextInt <= 255 && iNextInt >= -128) {
                    return Byte.valueOf((byte) iNextInt);
                }
                StringBuilder sbS = ac.c.s("Lossy conversion from ", iNextInt, " to byte; at path ");
                sbS.append(aVar.getPreviousPath());
                throw new JsonSyntaxException(sbS.toString());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, Number number) throws IOException {
            bVar.value(number);
        }
    }

    public class y extends com.google.gson.w<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.w
        public Number read(z9.a aVar) throws IOException {
            if (aVar.peek() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                int iNextInt = aVar.nextInt();
                if (iNextInt <= 65535 && iNextInt >= -32768) {
                    return Short.valueOf((short) iNextInt);
                }
                StringBuilder sbS = ac.c.s("Lossy conversion from ", iNextInt, " to short; at path ");
                sbS.append(aVar.getPreviousPath());
                throw new JsonSyntaxException(sbS.toString());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, Number number) throws IOException {
            bVar.value(number);
        }
    }

    public class z extends com.google.gson.w<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.w
        public Number read(z9.a aVar) throws IOException {
            if (aVar.peek() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(aVar.nextInt());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, Number number) throws IOException {
            bVar.value(number);
        }
    }

    static {
        v vVar = new v();
        f10148c = new w();
        f10149d = newFactory(Boolean.TYPE, Boolean.class, vVar);
        f10150e = newFactory(Byte.TYPE, Byte.class, new x());
        f10151f = newFactory(Short.TYPE, Short.class, new y());
        f10152g = newFactory(Integer.TYPE, Integer.class, new z());
        f10153h = newFactory(AtomicInteger.class, new a0().nullSafe());
        f10154i = newFactory(AtomicBoolean.class, new b0().nullSafe());
        f10155j = newFactory(AtomicIntegerArray.class, new a().nullSafe());
        f10156k = new b();
        new c();
        new d();
        f10157l = newFactory(Character.TYPE, Character.class, new e());
        f fVar = new f();
        f10158m = new g();
        f10159n = new h();
        f10160o = new i();
        f10161p = newFactory(String.class, fVar);
        f10162q = newFactory(StringBuilder.class, new j());
        f10163r = newFactory(StringBuffer.class, new l());
        f10164s = newFactory(URL.class, new m());
        f10165t = newFactory(URI.class, new n());
        f10166u = newTypeHierarchyFactory(InetAddress.class, new o());
        f10167v = newFactory(UUID.class, new p());
        f10168w = newFactory(Currency.class, new q().nullSafe());
        f10169x = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, new r());
        f10170y = newFactory(Locale.class, new s());
        t tVar = new t();
        f10171z = tVar;
        A = newTypeHierarchyFactory(com.google.gson.o.class, tVar);
        B = new com.google.gson.x() { // from class: com.google.gson.internal.bind.TypeAdapters.29
            @Override // com.google.gson.x
            public <T> com.google.gson.w<T> create(com.google.gson.i iVar, y9.a<T> aVar) {
                Class<? super T> rawType = aVar.getRawType();
                if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                    return null;
                }
                if (!rawType.isEnum()) {
                    rawType = rawType.getSuperclass();
                }
                return new c0(rawType);
            }
        };
    }

    public static <TT> com.google.gson.x newFactory(final y9.a<TT> aVar, final com.google.gson.w<TT> wVar) {
        return new com.google.gson.x() { // from class: com.google.gson.internal.bind.TypeAdapters.30
            @Override // com.google.gson.x
            public <T> com.google.gson.w<T> create(com.google.gson.i iVar, y9.a<T> aVar2) {
                if (aVar2.equals(aVar)) {
                    return wVar;
                }
                return null;
            }
        };
    }

    public static <TT> com.google.gson.x newFactoryForMultipleTypes(final Class<TT> cls, final Class<? extends TT> cls2, final com.google.gson.w<? super TT> wVar) {
        return new com.google.gson.x() { // from class: com.google.gson.internal.bind.TypeAdapters.33
            @Override // com.google.gson.x
            public <T> com.google.gson.w<T> create(com.google.gson.i iVar, y9.a<T> aVar) {
                Class<? super T> rawType = aVar.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return wVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + wVar + "]";
            }
        };
    }

    public static <T1> com.google.gson.x newTypeHierarchyFactory(final Class<T1> cls, final com.google.gson.w<T1> wVar) {
        return new com.google.gson.x() { // from class: com.google.gson.internal.bind.TypeAdapters.34

            /* JADX INFO: Add missing generic type declarations: [T1] */
            /* renamed from: com.google.gson.internal.bind.TypeAdapters$34$a */
            public class a<T1> extends com.google.gson.w<T1> {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Class f10184a;

                public a(Class cls) {
                    this.f10184a = cls;
                }

                @Override // com.google.gson.w
                public T1 read(z9.a aVar) throws IOException {
                    T1 t12 = (T1) wVar.read(aVar);
                    if (t12 != null) {
                        Class cls = this.f10184a;
                        if (!cls.isInstance(t12)) {
                            throw new JsonSyntaxException("Expected a " + cls.getName() + " but was " + t12.getClass().getName() + "; at path " + aVar.getPreviousPath());
                        }
                    }
                    return t12;
                }

                @Override // com.google.gson.w
                public void write(z9.b bVar, T1 t12) throws IOException {
                    wVar.write(bVar, t12);
                }
            }

            @Override // com.google.gson.x
            public <T2> com.google.gson.w<T2> create(com.google.gson.i iVar, y9.a<T2> aVar) {
                Class<? super T2> rawType = aVar.getRawType();
                if (cls.isAssignableFrom(rawType)) {
                    return new a(rawType);
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + wVar + "]";
            }
        };
    }

    public static <TT> com.google.gson.x newFactory(final Class<TT> cls, final com.google.gson.w<TT> wVar) {
        return new com.google.gson.x() { // from class: com.google.gson.internal.bind.TypeAdapters.31
            @Override // com.google.gson.x
            public <T> com.google.gson.w<T> create(com.google.gson.i iVar, y9.a<T> aVar) {
                if (aVar.getRawType() == cls) {
                    return wVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + wVar + "]";
            }
        };
    }

    public static <TT> com.google.gson.x newFactory(final Class<TT> cls, final Class<TT> cls2, final com.google.gson.w<? super TT> wVar) {
        return new com.google.gson.x() { // from class: com.google.gson.internal.bind.TypeAdapters.32
            @Override // com.google.gson.x
            public <T> com.google.gson.w<T> create(com.google.gson.i iVar, y9.a<T> aVar) {
                Class<? super T> rawType = aVar.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return wVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + wVar + "]";
            }
        };
    }
}
