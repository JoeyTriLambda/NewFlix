package org.jsoup.nodes;

import cz.msebera.android.httpclient.client.config.CookieSpecs;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.jsoup.SerializationException;
import org.jsoup.nodes.Document;

/* compiled from: Attribute.java */
/* loaded from: classes2.dex */
public class a implements Map.Entry<String, String>, Cloneable {

    /* renamed from: o, reason: collision with root package name */
    public static final String[] f17161o = {"allowfullscreen", "async", "autofocus", "checked", "compact", "declare", CookieSpecs.DEFAULT, "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", AbstractCircuitBreaker.PROPERTY_NAME, "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};

    /* renamed from: b, reason: collision with root package name */
    public final String f17162b;

    /* renamed from: m, reason: collision with root package name */
    public String f17163m;

    /* renamed from: n, reason: collision with root package name */
    public b f17164n;

    public a(String str, String str2) {
        this(str, str2, null);
    }

    public static boolean isBooleanAttribute(String str) {
        return Arrays.binarySearch(f17161o, str) >= 0;
    }

    public static boolean shouldCollapseAttribute(String str, String str2, Document.OutputSettings outputSettings) {
        return outputSettings.syntax() == Document.OutputSettings.Syntax.html && (str2 == null || (("".equals(str2) || str2.equalsIgnoreCase(str)) && isBooleanAttribute(str)));
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = aVar.f17162b;
        String str2 = this.f17162b;
        if (str2 == null ? str != null : !str2.equals(str)) {
            return false;
        }
        String str3 = this.f17163m;
        String str4 = aVar.f17163m;
        return str3 != null ? str3.equals(str4) : str4 == null;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        String str = this.f17162b;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f17163m;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String html() {
        StringBuilder sb2 = new StringBuilder();
        try {
            html(sb2, new Document("").outputSettings());
            return sb2.toString();
        } catch (IOException e10) {
            throw new SerializationException(e10);
        }
    }

    public String toString() {
        return html();
    }

    public a(String str, String str2, b bVar) {
        dh.f.notNull(str);
        this.f17162b = str.trim();
        dh.f.notEmpty(str);
        this.f17163m = str2;
        this.f17164n = bVar;
    }

    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // java.util.Map.Entry
    public String getKey() {
        return this.f17162b;
    }

    @Override // java.util.Map.Entry
    public String getValue() {
        return this.f17163m;
    }

    @Override // java.util.Map.Entry
    public String setValue(String str) {
        int iC;
        b bVar = this.f17164n;
        String str2 = this.f17162b;
        String str3 = bVar.get(str2);
        b bVar2 = this.f17164n;
        if (bVar2 != null && (iC = bVar2.c(str2)) != -1) {
            this.f17164n.f17168n[iC] = str;
        }
        this.f17163m = str;
        return str3;
    }

    public static void html(String str, String str2, Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(str);
        if (shouldCollapseAttribute(str, str2, outputSettings)) {
            return;
        }
        appendable.append("=\"");
        if (str2 == null) {
            str2 = "";
        }
        Entities.b(appendable, str2, outputSettings, true, false);
        appendable.append('\"');
    }

    public void html(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        html(this.f17162b, this.f17163m, appendable, outputSettings);
    }
}
