package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.m;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContactsPhotoRequestHandler.java */
/* loaded from: classes2.dex */
public final class d extends m {

    /* renamed from: b, reason: collision with root package name */
    public static final UriMatcher f10552b;

    /* renamed from: a, reason: collision with root package name */
    public final Context f10553a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f10552b = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "display_photo/#", 4);
    }

    public d(Context context) {
        this.f10553a = context;
    }

    @Override // com.squareup.picasso.m
    public boolean canHandleRequest(k kVar) {
        Uri uri = kVar.f10584c;
        return "content".equals(uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f10552b.match(kVar.f10584c) != -1;
    }

    @Override // com.squareup.picasso.m
    public m.a load(k kVar, int i10) throws IOException {
        InputStream inputStreamOpenContactPhotoInputStream;
        ContentResolver contentResolver = this.f10553a.getContentResolver();
        Uri uriLookupContact = kVar.f10584c;
        int iMatch = f10552b.match(uriLookupContact);
        if (iMatch != 1) {
            if (iMatch != 2) {
                if (iMatch != 3) {
                    if (iMatch != 4) {
                        throw new IllegalStateException(ac.c.i("Invalid uri: ", uriLookupContact));
                    }
                }
            }
            inputStreamOpenContactPhotoInputStream = contentResolver.openInputStream(uriLookupContact);
        } else {
            uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uriLookupContact);
            inputStreamOpenContactPhotoInputStream = uriLookupContact == null ? null : ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uriLookupContact, true);
        }
        if (inputStreamOpenContactPhotoInputStream == null) {
            return null;
        }
        return new m.a(ah.m.source(inputStreamOpenContactPhotoInputStream), Picasso.LoadedFrom.DISK);
    }
}
