package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: MetadataRepo.java */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final m1.b f2654a;

    /* renamed from: b, reason: collision with root package name */
    public final char[] f2655b;

    /* renamed from: c, reason: collision with root package name */
    public final a f2656c = new a(1024);

    /* renamed from: d, reason: collision with root package name */
    public final Typeface f2657d;

    /* compiled from: MetadataRepo.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final SparseArray<a> f2658a;

        /* renamed from: b, reason: collision with root package name */
        public i f2659b;

        public a() {
            this(1);
        }

        public final void a(i iVar, int i10, int i11) {
            int codepointAt = iVar.getCodepointAt(i10);
            SparseArray<a> sparseArray = this.f2658a;
            a aVar = sparseArray == null ? null : sparseArray.get(codepointAt);
            if (aVar == null) {
                aVar = new a();
                sparseArray.put(iVar.getCodepointAt(i10), aVar);
            }
            if (i11 > i10) {
                aVar.a(iVar, i10 + 1, i11);
            } else {
                aVar.f2659b = iVar;
            }
        }

        public a(int i10) {
            this.f2658a = new SparseArray<>(i10);
        }
    }

    public o(Typeface typeface, m1.b bVar) {
        this.f2657d = typeface;
        this.f2654a = bVar;
        this.f2655b = new char[bVar.listLength() * 2];
        int iListLength = bVar.listLength();
        for (int i10 = 0; i10 < iListLength; i10++) {
            i iVar = new i(this, i10);
            Character.toChars(iVar.getId(), this.f2655b, i10 * 2);
            w0.h.checkNotNull(iVar, "emoji metadata cannot be null");
            w0.h.checkArgument(iVar.getCodepointsLength() > 0, "invalid metadata codepoint length");
            this.f2656c.a(iVar, 0, iVar.getCodepointsLength() - 1);
        }
    }

    public static o create(Typeface typeface, ByteBuffer byteBuffer) throws IOException {
        try {
            t0.m.beginSection("EmojiCompat.MetadataRepo.create");
            return new o(typeface, n.a(byteBuffer));
        } finally {
            t0.m.endSection();
        }
    }

    public char[] getEmojiCharArray() {
        return this.f2655b;
    }

    public m1.b getMetadataList() {
        return this.f2654a;
    }
}
