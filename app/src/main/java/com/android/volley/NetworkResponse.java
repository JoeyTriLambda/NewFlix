package com.android.volley;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class NetworkResponse {
    public final List<Header> allHeaders;
    public final byte[] data;
    public final Map<String, String> headers;
    public final long networkTimeMs;
    public final boolean notModified;
    public final int statusCode;

    @Deprecated
    public NetworkResponse(int i10, byte[] bArr, Map<String, String> map, boolean z10, long j10) {
        this(i10, bArr, map, toAllHeaderList(map), z10, j10);
    }

    private static List<Header> toAllHeaderList(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new Header(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    private static Map<String, String> toHeaderMap(List<Header> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Header header : list) {
            treeMap.put(header.getName(), header.getValue());
        }
        return treeMap;
    }

    public NetworkResponse(int i10, byte[] bArr, boolean z10, long j10, List<Header> list) {
        this(i10, bArr, toHeaderMap(list), list, z10, j10);
    }

    @Deprecated
    public NetworkResponse(int i10, byte[] bArr, Map<String, String> map, boolean z10) {
        this(i10, bArr, map, z10, 0L);
    }

    public NetworkResponse(byte[] bArr) {
        this(200, bArr, false, 0L, (List<Header>) Collections.emptyList());
    }

    @Deprecated
    public NetworkResponse(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

    private NetworkResponse(int i10, byte[] bArr, Map<String, String> map, List<Header> list, boolean z10, long j10) {
        this.statusCode = i10;
        this.data = bArr;
        this.headers = map;
        if (list == null) {
            this.allHeaders = null;
        } else {
            this.allHeaders = Collections.unmodifiableList(list);
        }
        this.notModified = z10;
        this.networkTimeMs = j10;
    }
}
