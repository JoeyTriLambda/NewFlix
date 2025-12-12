package com.uwetrottmann.trakt5.entities;

/* loaded from: classes2.dex */
public class Settings {
    public Account account;
    public Connections connections;
    public Limits limits;
    public SharingText sharing_text;
    public User user;

    public static class Limits {
        public ItemCount favorites;
        public CountAndItemCount list;
        public ItemCount recommendations;
        public ItemCount watchlist;

        public static class CountAndItemCount extends ItemCount {
            public Integer count;
        }

        public static class ItemCount {
            public Integer item_count;
        }
    }
}
