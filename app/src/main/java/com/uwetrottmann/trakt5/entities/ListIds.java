package com.uwetrottmann.trakt5.entities;

/* loaded from: classes2.dex */
public class ListIds {
    public String slug;
    public Integer trakt;

    public static ListIds slug(String str) {
        ListIds listIds = new ListIds();
        listIds.slug = str;
        return listIds;
    }

    public static ListIds trakt(int i10) {
        ListIds listIds = new ListIds();
        listIds.trakt = Integer.valueOf(i10);
        return listIds;
    }
}
