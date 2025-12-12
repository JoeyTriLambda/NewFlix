package i2;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import com.unity3d.ads.metadata.MediationMetaData;
import ig.l;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import zf.i;

/* compiled from: CursorUtil.kt */
/* loaded from: classes.dex */
public final class a {
    public static final Cursor copyAndClose(Cursor cursor) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(cursor, "c");
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objArr = new Object[cursor.getColumnCount()];
                int columnCount = cursor.getColumnCount();
                for (int i10 = 0; i10 < columnCount; i10++) {
                    int type = cursor.getType(i10);
                    if (type == 0) {
                        objArr[i10] = null;
                    } else if (type == 1) {
                        objArr[i10] = Long.valueOf(cursor.getLong(i10));
                    } else if (type == 2) {
                        objArr[i10] = Double.valueOf(cursor.getDouble(i10));
                    } else if (type == 3) {
                        objArr[i10] = cursor.getString(i10);
                    } else {
                        if (type != 4) {
                            throw new IllegalStateException();
                        }
                        objArr[i10] = cursor.getBlob(i10);
                    }
                }
                matrixCursor.addRow(objArr);
            }
            wf.a.closeFinally(cursor, null);
            return matrixCursor;
        } finally {
        }
    }

    public static final int findColumnIndexBySuffix(String[] strArr, String str) {
        i.checkNotNullParameter(strArr, "columnNames");
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        String str2 = "." + str;
        String str3 = "." + str + '`';
        int length = strArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            String str4 = strArr[i10];
            int i12 = i11 + 1;
            if (str4.length() >= str.length() + 2) {
                if (l.endsWith$default(str4, str2, false, 2, null)) {
                    return i11;
                }
                if (str4.charAt(0) == '`' && l.endsWith$default(str4, str3, false, 2, null)) {
                    return i11;
                }
            }
            i10++;
            i11 = i12;
        }
        return -1;
    }

    public static final int getColumnIndex(Cursor cursor, String str) {
        i.checkNotNullParameter(cursor, "c");
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex("`" + str + '`');
        if (columnIndex2 >= 0) {
            return columnIndex2;
        }
        if (Build.VERSION.SDK_INT <= 25) {
            if (!(str.length() == 0)) {
                String[] columnNames = cursor.getColumnNames();
                i.checkNotNullExpressionValue(columnNames, "columnNames");
                return findColumnIndexBySuffix(columnNames, str);
            }
        }
        return -1;
    }

    public static final int getColumnIndexOrThrow(Cursor cursor, String str) {
        String strJoinToString$default;
        i.checkNotNullParameter(cursor, "c");
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        int columnIndex = getColumnIndex(cursor, str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            i.checkNotNullExpressionValue(columnNames, "c.columnNames");
            strJoinToString$default = mf.i.joinToString$default(columnNames, null, null, null, 0, null, null, 63, null);
        } catch (Exception e10) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e10);
            strJoinToString$default = "unknown";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + strJoinToString$default);
    }
}
