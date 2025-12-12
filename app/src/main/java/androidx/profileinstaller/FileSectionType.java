package androidx.profileinstaller;

/* loaded from: classes.dex */
enum FileSectionType {
    DEX_FILES(0),
    /* JADX INFO: Fake field, exist only in values array */
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    /* JADX INFO: Fake field, exist only in values array */
    AGGREGATION_COUNT(4);


    /* renamed from: b, reason: collision with root package name */
    public final long f3837b;

    FileSectionType(long j10) {
        this.f3837b = j10;
    }

    public long getValue() {
        return this.f3837b;
    }
}
