package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class ToNumberPolicy implements v {

    /* renamed from: b, reason: collision with root package name */
    public static final ToNumberPolicy f10043b;

    /* renamed from: m, reason: collision with root package name */
    public static final ToNumberPolicy f10044m;

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ ToNumberPolicy[] f10045n;

    static {
        ToNumberPolicy toNumberPolicy = new ToNumberPolicy() { // from class: com.google.gson.ToNumberPolicy.1
            @Override // com.google.gson.v
            public Double readNumber(z9.a aVar) throws IOException {
                return Double.valueOf(aVar.nextDouble());
            }
        };
        f10043b = toNumberPolicy;
        ToNumberPolicy toNumberPolicy2 = new ToNumberPolicy() { // from class: com.google.gson.ToNumberPolicy.2
            @Override // com.google.gson.v
            public Number readNumber(z9.a aVar) throws IOException {
                return new LazilyParsedNumber(aVar.nextString());
            }
        };
        f10044m = toNumberPolicy2;
        f10045n = new ToNumberPolicy[]{toNumberPolicy, toNumberPolicy2, new ToNumberPolicy() { // from class: com.google.gson.ToNumberPolicy.3
            @Override // com.google.gson.v
            public Number readNumber(z9.a aVar) throws JsonParseException, IOException, NumberFormatException {
                String strNextString = aVar.nextString();
                try {
                    try {
                        return Long.valueOf(Long.parseLong(strNextString));
                    } catch (NumberFormatException e10) {
                        StringBuilder sbV = ac.c.v("Cannot parse ", strNextString, "; at path ");
                        sbV.append(aVar.getPreviousPath());
                        throw new JsonParseException(sbV.toString(), e10);
                    }
                } catch (NumberFormatException unused) {
                    Double dValueOf = Double.valueOf(strNextString);
                    if ((!dValueOf.isInfinite() && !dValueOf.isNaN()) || aVar.isLenient()) {
                        return dValueOf;
                    }
                    throw new MalformedJsonException("JSON forbids NaN and infinities: " + dValueOf + "; at path " + aVar.getPreviousPath());
                }
            }
        }, new ToNumberPolicy() { // from class: com.google.gson.ToNumberPolicy.4
            @Override // com.google.gson.v
            public BigDecimal readNumber(z9.a aVar) throws IOException {
                String strNextString = aVar.nextString();
                try {
                    return new BigDecimal(strNextString);
                } catch (NumberFormatException e10) {
                    StringBuilder sbV = ac.c.v("Cannot parse ", strNextString, "; at path ");
                    sbV.append(aVar.getPreviousPath());
                    throw new JsonParseException(sbV.toString(), e10);
                }
            }
        }};
    }

    public ToNumberPolicy() {
        throw null;
    }

    public ToNumberPolicy(String str, int i10) {
    }

    public static ToNumberPolicy valueOf(String str) {
        return (ToNumberPolicy) Enum.valueOf(ToNumberPolicy.class, str);
    }

    public static ToNumberPolicy[] values() {
        return (ToNumberPolicy[]) f10045n.clone();
    }
}
