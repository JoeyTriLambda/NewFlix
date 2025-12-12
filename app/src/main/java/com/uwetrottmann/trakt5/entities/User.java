package com.uwetrottmann.trakt5.entities;

import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import org.threeten.bp.OffsetDateTime;
import u9.b;

/* loaded from: classes2.dex */
public class User {
    public String about;
    public int age;
    public String gender;
    public UserIds ids;
    public Images images;

    @b(HeaderConstants.PRIVATE)
    public Boolean isPrivate;
    public OffsetDateTime joined_at;
    public String location;
    public String name;
    public String username;
    public Boolean vip;
    public Boolean vip_ep;

    public static class UserIds {
        public String slug;
    }
}
