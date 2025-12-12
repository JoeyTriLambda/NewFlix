package com.google.common.collect;

/* loaded from: classes.dex */
class EmptyImmutableSetMultimap extends ImmutableSetMultimap<Object, Object> {

    /* renamed from: m, reason: collision with root package name */
    public static final EmptyImmutableSetMultimap f9626m = new EmptyImmutableSetMultimap();
    private static final long serialVersionUID = 0;

    private EmptyImmutableSetMultimap() {
        super(ImmutableMap.of(), 0);
    }
}
