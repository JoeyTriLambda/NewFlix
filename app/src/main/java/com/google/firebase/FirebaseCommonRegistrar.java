package com.google.firebase;

import android.os.Build;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.firebase.components.ComponentRegistrar;
import cz.msebera.android.httpclient.message.TokenParser;
import g9.c;
import java.util.ArrayList;
import java.util.List;
import l8.b;
import o9.d;
import o9.g;
import pd.a;

/* loaded from: classes.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    public static String a(String str) {
        return str.replace(TokenParser.SP, '_').replace(JsonPointer.SEPARATOR, '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<b<?>> getComponents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(o9.b.component());
        arrayList.add(c.component());
        arrayList.add(g.create("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(g.create("fire-core", "20.4.3"));
        arrayList.add(g.create("device-name", a(Build.PRODUCT)));
        arrayList.add(g.create("device-model", a(Build.DEVICE)));
        arrayList.add(g.create("device-brand", a(Build.BRAND)));
        arrayList.add(g.fromContext("android-target-sdk", new a(20)));
        arrayList.add(g.fromContext("android-min-sdk", new a(21)));
        arrayList.add(g.fromContext("android-platform", new a(22)));
        arrayList.add(g.fromContext("android-installer", new a(23)));
        String strDetectVersion = d.detectVersion();
        if (strDetectVersion != null) {
            arrayList.add(g.create("kotlin", strDetectVersion));
        }
        return arrayList;
    }
}
