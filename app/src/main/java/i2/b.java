package i2;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import ig.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import lf.h;
import mf.j;
import zf.i;

/* compiled from: DBUtil.kt */
/* loaded from: classes.dex */
public final class b {
    public static final void dropFtsSyncTriggers(k2.e eVar) throws IllegalAccessException, IOException, SQLException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(eVar, "db");
        List listCreateListBuilder = j.createListBuilder();
        Cursor cursorQuery = eVar.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cursorQuery.moveToNext()) {
            try {
                listCreateListBuilder.add(cursorQuery.getString(0));
            } finally {
            }
        }
        h hVar = h.f16056a;
        wf.a.closeFinally(cursorQuery, null);
        for (String str : j.build(listCreateListBuilder)) {
            i.checkNotNullExpressionValue(str, "triggerName");
            if (l.startsWith$default(str, "room_fts_content_sync_", false, 2, null)) {
                eVar.execSQL("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    public static final Cursor query(RoomDatabase roomDatabase, k2.h hVar, boolean z10, CancellationSignal cancellationSignal) {
        i.checkNotNullParameter(roomDatabase, "db");
        i.checkNotNullParameter(hVar, "sqLiteQuery");
        Cursor cursorQuery = roomDatabase.query(hVar, cancellationSignal);
        if (!z10 || !(cursorQuery instanceof AbstractWindowedCursor)) {
            return cursorQuery;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) cursorQuery;
        int count = abstractWindowedCursor.getCount();
        return (Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? a.copyAndClose(cursorQuery) : cursorQuery;
    }

    public static final int readVersion(File file) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(file, "databaseFile");
        FileChannel channel = new FileInputStream(file).getChannel();
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(byteBufferAllocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            byteBufferAllocate.rewind();
            int i10 = byteBufferAllocate.getInt();
            wf.a.closeFinally(channel, null);
            return i10;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                wf.a.closeFinally(channel, th2);
                throw th3;
            }
        }
    }
}
