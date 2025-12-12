package org.adblockplus.libadblockplus.android;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class Subscription implements Serializable {
    public String author;
    public String homepage;
    public String prefixes;
    public String title;
    public String url;

    public Subscription() {
        this.title = "";
        this.url = "";
        this.prefixes = "";
        this.homepage = "";
        this.author = "";
    }

    public Subscription(String str, String str2, String str3, String str4, String str5) {
        this.title = str;
        this.url = str2;
        this.prefixes = str3;
        this.homepage = str4;
        this.author = str5;
    }
}
