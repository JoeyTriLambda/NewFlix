package i2;

import android.database.Cursor;
import com.unity3d.ads.metadata.MediationMetaData;
import i2.d;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import mf.j;
import mf.q;
import mf.x;
import mf.y;
import zf.i;

/* compiled from: TableInfo.kt */
/* loaded from: classes.dex */
public final class e {
    public static final d readTableInfo(k2.e eVar, String str) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Map mapBuild;
        Set set;
        int i10;
        String str2;
        int i11;
        int i12;
        Throwable th2;
        d.e eVar2;
        k2.e eVar3 = eVar;
        i.checkNotNullParameter(eVar3, "database");
        i.checkNotNullParameter(str, "tableName");
        StringBuilder sb2 = new StringBuilder("PRAGMA table_info(`");
        sb2.append(str);
        String str3 = "`)";
        sb2.append("`)");
        Cursor cursorQuery = eVar3.query(sb2.toString());
        try {
            int columnCount = cursorQuery.getColumnCount();
            String str4 = MediationMetaData.KEY_NAME;
            if (columnCount <= 0) {
                mapBuild = kotlin.collections.a.emptyMap();
                wf.a.closeFinally(cursorQuery, null);
            } else {
                int columnIndex = cursorQuery.getColumnIndex(MediationMetaData.KEY_NAME);
                int columnIndex2 = cursorQuery.getColumnIndex("type");
                int columnIndex3 = cursorQuery.getColumnIndex("notnull");
                int columnIndex4 = cursorQuery.getColumnIndex("pk");
                int columnIndex5 = cursorQuery.getColumnIndex("dflt_value");
                Map mapCreateMapBuilder = x.createMapBuilder();
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndex);
                    String string2 = cursorQuery.getString(columnIndex2);
                    boolean z10 = cursorQuery.getInt(columnIndex3) != 0;
                    int i13 = cursorQuery.getInt(columnIndex4);
                    String string3 = cursorQuery.getString(columnIndex5);
                    i.checkNotNullExpressionValue(string, MediationMetaData.KEY_NAME);
                    i.checkNotNullExpressionValue(string2, "type");
                    mapCreateMapBuilder.put(string, new d.a(string, string2, z10, i13, string3, 2));
                    columnIndex = columnIndex;
                }
                mapBuild = x.build(mapCreateMapBuilder);
                wf.a.closeFinally(cursorQuery, null);
            }
            cursorQuery = eVar3.query("PRAGMA foreign_key_list(`" + str + "`)");
            try {
                int columnIndex6 = cursorQuery.getColumnIndex("id");
                int columnIndex7 = cursorQuery.getColumnIndex("seq");
                int columnIndex8 = cursorQuery.getColumnIndex("table");
                int columnIndex9 = cursorQuery.getColumnIndex("on_delete");
                int columnIndex10 = cursorQuery.getColumnIndex("on_update");
                int columnIndex11 = cursorQuery.getColumnIndex("id");
                int columnIndex12 = cursorQuery.getColumnIndex("seq");
                int columnIndex13 = cursorQuery.getColumnIndex("from");
                int columnIndex14 = cursorQuery.getColumnIndex("to");
                List listCreateListBuilder = j.createListBuilder();
                while (cursorQuery.moveToNext()) {
                    String str5 = str4;
                    int i14 = cursorQuery.getInt(columnIndex11);
                    int i15 = columnIndex11;
                    int i16 = cursorQuery.getInt(columnIndex12);
                    int i17 = columnIndex12;
                    String string4 = cursorQuery.getString(columnIndex13);
                    int i18 = columnIndex13;
                    i.checkNotNullExpressionValue(string4, "cursor.getString(fromColumnIndex)");
                    String string5 = cursorQuery.getString(columnIndex14);
                    i.checkNotNullExpressionValue(string5, "cursor.getString(toColumnIndex)");
                    listCreateListBuilder.add(new d.C0163d(i14, i16, string4, string5));
                    mapBuild = mapBuild;
                    str4 = str5;
                    columnIndex11 = i15;
                    columnIndex12 = i17;
                    columnIndex13 = i18;
                    columnIndex14 = columnIndex14;
                }
                Map map = mapBuild;
                String str6 = str4;
                List listSorted = q.sorted(j.build(listCreateListBuilder));
                cursorQuery.moveToPosition(-1);
                Set setCreateSetBuilder = y.createSetBuilder();
                while (cursorQuery.moveToNext()) {
                    if (cursorQuery.getInt(columnIndex7) == 0) {
                        int i19 = cursorQuery.getInt(columnIndex6);
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        for (Object obj : listSorted) {
                            List list = listSorted;
                            int i20 = columnIndex6;
                            if (((d.C0163d) obj).getId() == i19) {
                                arrayList3.add(obj);
                            }
                            listSorted = list;
                            columnIndex6 = i20;
                        }
                        List list2 = listSorted;
                        int i21 = columnIndex6;
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            d.C0163d c0163d = (d.C0163d) it.next();
                            arrayList.add(c0163d.getFrom());
                            arrayList2.add(c0163d.getTo());
                        }
                        String string6 = cursorQuery.getString(columnIndex8);
                        i.checkNotNullExpressionValue(string6, "cursor.getString(tableColumnIndex)");
                        String string7 = cursorQuery.getString(columnIndex9);
                        i.checkNotNullExpressionValue(string7, "cursor.getString(onDeleteColumnIndex)");
                        String string8 = cursorQuery.getString(columnIndex10);
                        i.checkNotNullExpressionValue(string8, "cursor.getString(onUpdateColumnIndex)");
                        setCreateSetBuilder.add(new d.c(string6, string7, string8, arrayList, arrayList2));
                        listSorted = list2;
                        columnIndex6 = i21;
                    }
                }
                Set setBuild = y.build(setCreateSetBuilder);
                wf.a.closeFinally(cursorQuery, null);
                cursorQuery = eVar3.query("PRAGMA index_list(`" + str + "`)");
                String str7 = str6;
                try {
                    int columnIndex15 = cursorQuery.getColumnIndex(str7);
                    int columnIndex16 = cursorQuery.getColumnIndex("origin");
                    int columnIndex17 = cursorQuery.getColumnIndex("unique");
                    if (columnIndex15 == -1 || columnIndex16 == -1 || columnIndex17 == -1) {
                        wf.a.closeFinally(cursorQuery, null);
                        set = null;
                    } else {
                        Set setCreateSetBuilder2 = y.createSetBuilder();
                        while (true) {
                            if (!cursorQuery.moveToNext()) {
                                Set setBuild2 = y.build(setCreateSetBuilder2);
                                wf.a.closeFinally(cursorQuery, null);
                                set = setBuild2;
                                break;
                            }
                            if (i.areEqual("c", cursorQuery.getString(columnIndex16))) {
                                String string9 = cursorQuery.getString(columnIndex15);
                                boolean z11 = cursorQuery.getInt(columnIndex17) == 1;
                                i.checkNotNullExpressionValue(string9, str7);
                                cursorQuery = eVar3.query("PRAGMA index_xinfo(`" + string9 + str3);
                                try {
                                    int columnIndex18 = cursorQuery.getColumnIndex("seqno");
                                    int columnIndex19 = cursorQuery.getColumnIndex("cid");
                                    int columnIndex20 = cursorQuery.getColumnIndex(str7);
                                    int columnIndex21 = cursorQuery.getColumnIndex("desc");
                                    String str8 = str7;
                                    if (columnIndex18 == -1 || columnIndex19 == -1 || columnIndex20 == -1 || columnIndex21 == -1) {
                                        i10 = columnIndex15;
                                        str2 = str3;
                                        i11 = columnIndex16;
                                        i12 = columnIndex17;
                                        th2 = null;
                                        wf.a.closeFinally(cursorQuery, null);
                                        eVar2 = null;
                                    } else {
                                        TreeMap treeMap = new TreeMap();
                                        i10 = columnIndex15;
                                        TreeMap treeMap2 = new TreeMap();
                                        while (cursorQuery.moveToNext()) {
                                            if (cursorQuery.getInt(columnIndex19) >= 0) {
                                                int i22 = cursorQuery.getInt(columnIndex18);
                                                String str9 = str3;
                                                String string10 = cursorQuery.getString(columnIndex20);
                                                int i23 = columnIndex21;
                                                String str10 = cursorQuery.getInt(columnIndex21) > 0 ? "DESC" : "ASC";
                                                int i24 = columnIndex16;
                                                Integer numValueOf = Integer.valueOf(i22);
                                                i.checkNotNullExpressionValue(string10, "columnName");
                                                treeMap.put(numValueOf, string10);
                                                treeMap2.put(Integer.valueOf(i22), str10);
                                                str3 = str9;
                                                columnIndex16 = i24;
                                                columnIndex21 = i23;
                                                columnIndex17 = columnIndex17;
                                            }
                                        }
                                        str2 = str3;
                                        i11 = columnIndex16;
                                        i12 = columnIndex17;
                                        Collection collectionValues = treeMap.values();
                                        i.checkNotNullExpressionValue(collectionValues, "columnsMap.values");
                                        List list3 = q.toList(collectionValues);
                                        Collection collectionValues2 = treeMap2.values();
                                        i.checkNotNullExpressionValue(collectionValues2, "ordersMap.values");
                                        d.e eVar4 = new d.e(string9, z11, list3, q.toList(collectionValues2));
                                        wf.a.closeFinally(cursorQuery, null);
                                        eVar2 = eVar4;
                                        th2 = null;
                                    }
                                    if (eVar2 == null) {
                                        wf.a.closeFinally(cursorQuery, th2);
                                        set = null;
                                        break;
                                    }
                                    setCreateSetBuilder2.add(eVar2);
                                    eVar3 = eVar;
                                    str7 = str8;
                                    columnIndex15 = i10;
                                    str3 = str2;
                                    columnIndex16 = i11;
                                    columnIndex17 = i12;
                                } finally {
                                }
                            }
                        }
                    }
                    return new d(str, map, setBuild, set);
                } finally {
                }
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }
}
