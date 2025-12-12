package com.uwetrottmann.trakt5.entities;

import java.util.List;

/* loaded from: classes2.dex */
public class ListItemRank {
    public List<Long> rank;

    public static ListItemRank from(List<Long> list) {
        ListItemRank listItemRank = new ListItemRank();
        listItemRank.rank = list;
        return listItemRank;
    }
}
